package org.ooka.mscontrolsystems.kafka;

import lombok.RequiredArgsConstructor;
import org.ooka.commons.model.TaskRequestModel;
import org.ooka.mscontrolsystems.task.TaskService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final TaskService taskService;

    @KafkaListener(topics = "request-control-systems", groupId = "bff-group", containerFactory = "kafkaListenerFactory")
    void listener(TaskRequestModel data) {
        taskService.handleTask(data);
    }

}
