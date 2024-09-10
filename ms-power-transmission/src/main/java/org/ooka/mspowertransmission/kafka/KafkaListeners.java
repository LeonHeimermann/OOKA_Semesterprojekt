package org.ooka.mspowertransmission.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.ooka.mspowertransmission.model.AnalysisConfigurationRequestModel;
import org.ooka.mspowertransmission.service.PowerTransmissionService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final ObjectMapper objectMapper;

    public static final String TASK_POWER_TRANSMISSION_TOPIC = "task-power-transmission";
    private final PowerTransmissionService powerTransmissionService;

    @KafkaListener(topics = TASK_POWER_TRANSMISSION_TOPIC, groupId = "analysis-group", containerFactory = "kafkaListenerFactory")
    void listenerPowerTransmission(String configString) throws JsonProcessingException {
        AnalysisConfigurationRequestModel analysisResultModel = objectMapper.readValue(configString, AnalysisConfigurationRequestModel.class);
        powerTransmissionService.analyse(analysisResultModel);
    }

}
