package org.ooka.bffservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.ooka.bffservice.kafka.KafkaTopicConfig;
import org.ooka.bffservice.model.AnalysisConfigurationDto;
import org.ooka.bffservice.model.AnalysisConfigurationRequestModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalysisService {

    private final AnalysisConfigurationMapper analysisConfigurationMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void analyse(AnalysisConfigurationRequestModel configRequestModel) throws JsonProcessingException {
        AnalysisConfigurationDto configDto = analysisConfigurationMapper.mapAnalysisConfigurationRequestModelToDto(configRequestModel);
        String configDtoString = objectMapper.writeValueAsString(configDto);
        kafkaTemplate.send(KafkaTopicConfig.TASK_AUXILIARY_SYSTEMS_TOPIC, configDtoString);
        kafkaTemplate.send(KafkaTopicConfig.TASK_CONTROL_SYSTEMS_TOPIC, configDtoString);
        kafkaTemplate.send(KafkaTopicConfig.TASK_ENGINE_SYSTEMS_TOPIC, configDtoString);
        kafkaTemplate.send(KafkaTopicConfig.TASK_MOUNTING_SYSTEMS_TOPIC, configDtoString);
        kafkaTemplate.send(KafkaTopicConfig.TASK_POWER_TRANSMISSION_TOPIC, configDtoString);
    }

}
