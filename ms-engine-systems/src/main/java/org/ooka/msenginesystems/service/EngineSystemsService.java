package org.ooka.msenginesystems.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.ooka.msenginesystems.kafka.KafkaTopicConfig;
import org.ooka.msenginesystems.model.AnalysisConfigurationRequestModel;
import org.ooka.msenginesystems.model.AnalysisResultDto;
import org.ooka.msenginesystems.util.Algorithm;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Service
@RequiredArgsConstructor
public class EngineSystemsService {

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;


    public void analyse(AnalysisConfigurationRequestModel analysisConfigurationRequestModel) {
        scheduler.execute(() -> {
            Algorithm algorithm = new Algorithm();
            algorithm.run();
            AnalysisResultDto analysisResultDto = getResultFromAlgorithm(algorithm, analysisConfigurationRequestModel);
            try {
                String analysisResultModelString = objectMapper.writeValueAsString(analysisResultDto);
                kafkaTemplate.send(KafkaTopicConfig.RESULT_ENGINE_SYSTEMS_TOPIC, analysisResultModelString);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private AnalysisResultDto getResultFromAlgorithm(Algorithm algorithm, AnalysisConfigurationRequestModel analysisConfigurationRequestModel) {
        return AnalysisResultDto.builder()
                .uuid(analysisConfigurationRequestModel.getUuid())
                .result(algorithm.getResult())
                .build();
    }
}
