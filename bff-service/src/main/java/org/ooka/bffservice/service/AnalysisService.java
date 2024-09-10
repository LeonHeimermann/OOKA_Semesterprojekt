package org.ooka.bffservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.ooka.bffservice.model.AnalysisResultDto;
import org.ooka.bffservice.model.ConfigurationDTO;
import org.ooka.bffservice.kafka.KafkaTopicConfig;
import org.ooka.bffservice.model.AnalysisConfigurationDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnalysisService {

    private final ConnectionHandler connectionHandler;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final Map<String, Integer> messageCounter = new HashMap<>();
    private final int SERVICE_AMOUNT = 5;

    public SseEmitter analyse(String configDtoString) throws JsonProcessingException {
        ConfigurationDTO configDto = objectMapper.readValue(configDtoString, ConfigurationDTO.class);
        UUID uuid = UUID.randomUUID();
        messageCounter.put(uuid.toString(), 0);
        SseEmitter sseEmitter = connectionHandler.addConnection(uuid.toString());
        AnalysisConfigurationDto analysisConfigurationDto = AnalysisConfigurationDto.builder()
                .uuid(uuid.toString())
                .configuration(configDto)
                .build();
        String analysisConfigDtoString = objectMapper.writeValueAsString(analysisConfigurationDto);
        kafkaTemplate.send(KafkaTopicConfig.TASK_AUXILIARY_SYSTEMS_TOPIC, analysisConfigDtoString);
        kafkaTemplate.send(KafkaTopicConfig.TASK_CONTROL_SYSTEMS_TOPIC, analysisConfigDtoString);
        kafkaTemplate.send(KafkaTopicConfig.TASK_ENGINE_SYSTEMS_TOPIC, analysisConfigDtoString);
        kafkaTemplate.send(KafkaTopicConfig.TASK_MOUNTING_SYSTEMS_TOPIC, analysisConfigDtoString);
        kafkaTemplate.send(KafkaTopicConfig.TASK_POWER_TRANSMISSION_TOPIC, analysisConfigDtoString);
        return sseEmitter;
    }

    public synchronized void sendAnalysisResult(String uuid, AnalysisResultDto analysisResultDto) throws JsonProcessingException {
        String analysisResultString = objectMapper.writeValueAsString(analysisResultDto);
        System.out.println(analysisResultString);
        connectionHandler.send(uuid, analysisResultString);
        messageCounter.put(uuid, messageCounter.get(uuid) + 1);
        if (messageCounter.get(uuid) >= SERVICE_AMOUNT) {
            connectionHandler.removeConnection(uuid);
            messageCounter.remove(uuid);
            System.out.println("Removed connection for uuid: " + uuid);
        }
    }

}
