package org.ooka.msauxiliarysystems.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.ooka.msauxiliarysystems.kafka.KafkaTopicConfig;
import org.ooka.msauxiliarysystems.model.AnalysisConfigurationRequestModel;
import org.ooka.msauxiliarysystems.model.AnalysisResultModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Service
@RequiredArgsConstructor
public class AuxiliarySystemsService {

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final TaskAnalyser taskAnalyser;
    private final ObjectMapper objectMapper;


    public void analyse(AnalysisConfigurationRequestModel analysisConfigurationRequestModel) {
        scheduler.execute(() -> {
            AnalysisResultModel analysisResultModel = taskAnalyser.analyse(analysisConfigurationRequestModel);
            try {
                String analysisResultModelString = objectMapper.writeValueAsString(analysisResultModel);
                kafkaTemplate.send(KafkaTopicConfig.RESULT_AUXILIARY_SYSTEMS_TOPIC, analysisResultModelString);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
