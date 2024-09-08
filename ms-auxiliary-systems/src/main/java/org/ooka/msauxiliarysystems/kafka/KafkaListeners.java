package org.ooka.msauxiliarysystems.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.ooka.msauxiliarysystems.model.AnalysisConfigurationRequestModel;
import org.ooka.msauxiliarysystems.service.AuxiliarySystemsService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final ObjectMapper objectMapper;

    public static final String TASK_AUXILIARY_SYSTEMS_TOPIC = "task-auxiliary-systems";
    private final AuxiliarySystemsService auxiliarySystemsService;

    @KafkaListener(topics = TASK_AUXILIARY_SYSTEMS_TOPIC, groupId = "analysis-group", containerFactory = "kafkaListenerFactory")
    void listenerAuxiliarySystems(String configString) throws JsonProcessingException {
        AnalysisConfigurationRequestModel analysisResultModel = objectMapper.readValue(configString, AnalysisConfigurationRequestModel.class);
        auxiliarySystemsService.analyse(analysisResultModel);
    }

}
