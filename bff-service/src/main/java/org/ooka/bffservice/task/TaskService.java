package org.ooka.bffservice.task;

import lombok.RequiredArgsConstructor;
import org.ooka.bffservice.model.AnalyseRequestModel;
import org.ooka.bffservice.model.TaskRequestModel;
import org.ooka.bffservice.model.TaskResponseModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final KafkaTemplate<String, TaskRequestModel> kafkaTemplate;

    public void submitTaskResponse(TaskResponseModel taskResponseModel) {

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
        return null;
    }

}
