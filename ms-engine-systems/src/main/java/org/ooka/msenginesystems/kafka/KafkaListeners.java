package org.ooka.msenginesystems.kafka;

import lombok.RequiredArgsConstructor;
import org.ooka.commons.model.TaskRequestModel;
import org.ooka.msenginesystems.task.TaskService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final TaskService taskService;

    @KafkaListener(topics = "request-engine-systems", groupId = "bff-group", containerFactory = "kafkaListenerFactory")
    void listener(TaskRequestModel data) {
        taskService.handleTask(data);
    }

}
