package org.ooka.msauxiliarysystems.kafka;

import lombok.RequiredArgsConstructor;
import org.ooka.commons.model.TaskRequestModel;
import org.ooka.msauxiliarysystems.task.TaskService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final TaskService taskService;

    @KafkaListener(topics = "request-auxiliary-systems", groupId = "bff-group", containerFactory = "kafkaListenerFactory")
    void listener(TaskRequestModel data) {
        taskService.handleTask(data);
    }

}
