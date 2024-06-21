package org.ooka.bffservice.task;

import lombok.RequiredArgsConstructor;
import org.ooka.bffservice.model.AnalyseRequestModel;
import org.ooka.commons.model.TaskRequestModel;
import org.ooka.commons.model.TaskResponseModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final JedisPool jedisPool;
    private final KafkaTemplate<String, TaskRequestModel> kafkaTemplate;

    public void submitTaskResponse(TaskResponseModel taskResponseModel) {
        try (Jedis jedis = jedisPool.getResource()) {
            String taskId = taskResponseModel.getTaskId();
            jedis.hset(taskId, taskResponseModel.getServiceTypeId(), taskResponseModel.getResult());
        }
    }

    public String submitTaskRequest(AnalyseRequestModel analyseRequestModel) {
        String taskId = UUID.randomUUID().toString();
        TaskRequestModel taskRequestModel = TaskRequestModel.builder()
                .taskId(taskId)
                .data(analyseRequestModel.getData())
                .build();
        kafkaTemplate.send("request-auxiliary-systems", taskRequestModel);
        kafkaTemplate.send("request-control-systems", taskRequestModel);
        kafkaTemplate.send("request-engine-systems", taskRequestModel);
        kafkaTemplate.send("request-mounting-systems", taskRequestModel);
        kafkaTemplate.send("request-power-transmission", taskRequestModel);
        return taskId;
    }

    public TaskResultDto getResults(String taskId) {
        try (Jedis jedis = jedisPool.getResource()) {
            if (!jedis.exists(taskId)) {
                return TaskResultDto.builder()
                        .taskResult(new ArrayList<>())
                        .build();
            }
            List<String> resultList = new ArrayList<>(jedis.hgetAll(taskId).values());
            return TaskResultDto.builder()
                    .taskResult(resultList)
                    .build();
        }
    }

}
