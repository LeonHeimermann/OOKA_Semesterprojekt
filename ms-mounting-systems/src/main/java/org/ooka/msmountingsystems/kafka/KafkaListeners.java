package org.ooka.msmountingsystems.kafka;

import lombok.RequiredArgsConstructor;
import org.ooka.commons.model.TaskRequestModel;
import org.ooka.msmountingsystems.task.TaskService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final TaskService taskService;

    @KafkaListener(topics = "request-mounting-systems", groupId = "bff-group", containerFactory = "kafkaListenerFactory")
    void listener(TaskRequestModel data) {
        taskService.handleTask(data);
    }

}
