package org.ooka.mscontrolsystems.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.ooka.mscontrolsystems.model.AnalysisConfigurationRequestModel;
import org.ooka.mscontrolsystems.service.ControlSystemsService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final ObjectMapper objectMapper;

    public static final String TASK_CONTROL_SYSTEMS_TOPIC = "task-control-systems";
    private final ControlSystemsService controlSystemsService;

    @KafkaListener(topics = TASK_CONTROL_SYSTEMS_TOPIC, groupId = "analysis-group", containerFactory = "kafkaListenerFactory")
    void listenerControlSystems(String configString) throws JsonProcessingException {
        AnalysisConfigurationRequestModel analysisResultModel = objectMapper.readValue(configString, AnalysisConfigurationRequestModel.class);
        controlSystemsService.analyse(analysisResultModel);
    }

}
