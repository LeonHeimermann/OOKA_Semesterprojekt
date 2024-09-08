package org.ooka.bffservice.kafka;

import lombok.RequiredArgsConstructor;
import org.ooka.bffservice.model.TaskResponseModel;
import org.ooka.bffservice.task.TaskService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final TaskService taskService;

    @KafkaListener(topics = "result-analyser", groupId = "bff-group", containerFactory = "kafkaListenerFactory")
    void listenerAnalyser(TaskResponseModel taskResponseModel) {
        taskService.submitTaskResponse(taskResponseModel);
    }

}
