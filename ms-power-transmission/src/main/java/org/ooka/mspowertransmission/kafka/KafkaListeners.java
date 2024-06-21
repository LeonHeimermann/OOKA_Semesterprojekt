package org.ooka.mspowertransmission.kafka;

import lombok.RequiredArgsConstructor;
import org.ooka.commons.model.TaskRequestModel;
import org.ooka.mspowertransmission.task.TaskService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final TaskService taskService;

    @KafkaListener(topics = "request-power-transmission", groupId = "bff-group", containerFactory = "kafkaListenerFactory")
    void listener(TaskRequestModel data) {
        taskService.handleTask(data);
    }

}
