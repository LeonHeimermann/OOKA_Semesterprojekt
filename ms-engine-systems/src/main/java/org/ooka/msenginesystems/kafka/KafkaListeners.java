package org.ooka.msenginesystems.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.ooka.msenginesystems.model.AnalysisConfigurationRequestModel;
import org.ooka.msenginesystems.service.EngineSystemsService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final ObjectMapper objectMapper;

    public static final String TASK_ENGINE_SYSTEMS_TOPIC = "task-engine-systems";
    private final EngineSystemsService engineSystemsService;

    @KafkaListener(topics = TASK_ENGINE_SYSTEMS_TOPIC, groupId = "analysis-group", containerFactory = "kafkaListenerFactory")
    void listenerEngineSystems(String configString) throws JsonProcessingException {
        AnalysisConfigurationRequestModel analysisResultModel = objectMapper.readValue(configString, AnalysisConfigurationRequestModel.class);
        engineSystemsService.analyse(analysisResultModel);
    }

}
