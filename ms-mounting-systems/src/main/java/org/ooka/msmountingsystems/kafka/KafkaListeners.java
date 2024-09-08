package org.ooka.msmountingsystems.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.ooka.msmountingsystems.model.AnalysisConfigurationRequestModel;
import org.ooka.msmountingsystems.service.MountingSystemsService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final ObjectMapper objectMapper;

    public static final String TASK_MOUNTING_SYSTEMS_TOPIC = "task-mounting-systems";
    private final MountingSystemsService mountingSystemsService;

    @KafkaListener(topics = TASK_MOUNTING_SYSTEMS_TOPIC, groupId = "analysis-group", containerFactory = "kafkaListenerFactory")
    void listenerMountingSystems(String configString) throws JsonProcessingException {
        AnalysisConfigurationRequestModel analysisResultModel = objectMapper.readValue(configString, AnalysisConfigurationRequestModel.class);
        mountingSystemsService.analyse(analysisResultModel);
    }

}
