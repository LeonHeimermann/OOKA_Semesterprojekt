package org.ooka.msenginesystems.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.ooka.msenginesystems.kafka.KafkaTopicConfig;
import org.ooka.msenginesystems.model.AnalysisConfigurationRequestModel;
import org.ooka.msenginesystems.model.AnalysisResultModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Service
@RequiredArgsConstructor
public class EngineSystemsService {

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final TaskAnalyser taskAnalyser;
    private final ObjectMapper objectMapper = new ObjectMapper();


    public void analyse(AnalysisConfigurationRequestModel analysisConfigurationRequestModel) {
        scheduler.execute(() -> {
            AnalysisResultModel analysisResultModel = taskAnalyser.analyse(analysisConfigurationRequestModel);
            try {
                String analysisResultModelString = objectMapper.writeValueAsString(analysisResultModel);
                kafkaTemplate.send(KafkaTopicConfig.RESULT_ENGINE_SYSTEMS_TOPIC, analysisResultModelString);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
