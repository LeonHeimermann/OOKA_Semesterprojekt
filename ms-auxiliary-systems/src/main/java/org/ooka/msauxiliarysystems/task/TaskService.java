package org.ooka.msauxiliarysystems.task;

import lombok.RequiredArgsConstructor;
import org.ooka.commons.model.ServiceType;
import org.ooka.commons.model.TaskRequestModel;
import org.ooka.commons.model.TaskResponseModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final KafkaTemplate<String, TaskResponseModel> kafkaTemplate;

    public void handleTask(TaskRequestModel taskRequestModel) {
        TaskResponseModel taskResponseModel = TaskResponseModel.builder()
                .taskId(taskRequestModel.getTaskId())
                .result(String.format("Request: %s - Response: TestResult", taskRequestModel.getData()))
                .serviceTypeId(ServiceType.AUXILIARY_SYSTEM.getUuid())
                .build();
        kafkaTemplate.send("result-analyser", taskResponseModel);
    }

}
