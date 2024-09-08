package org.ooka.bffservice.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.ooka.bffservice.model.AnalysisResultModel;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final ObjectMapper objectMapper;

    public static final String RESULT_AUXILIARY_SYSTEMS_TOPIC = "result-auxiliary-systems";
    public static final String RESULT_CONTROL_SYSTEMS_TOPIC = "result-control-systems";
    public static final String RESULT_ENGINE_SYSTEMS_TOPIC = "result-engine-systems";
    public static final String RESULT_MOUNTING_SYSTEMS_TOPIC = "result-mounting-systems";
    public static final String RESULT_POWER_TRANSMISSION_TOPIC = "result-power-transmission";

    @KafkaListener(topics = RESULT_AUXILIARY_SYSTEMS_TOPIC, groupId = "bff-group", containerFactory = "kafkaListenerFactory")
    void listenerAuxiliarySystems(String analysisResultModelString) throws JsonProcessingException {
        AnalysisResultModel analysisResultModel = objectMapper.readValue(analysisResultModelString, AnalysisResultModel.class);
        System.out.println(String.format("Auxiliary Systems: %s", analysisResultModel.getResult()));
    }

    @KafkaListener(topics = RESULT_CONTROL_SYSTEMS_TOPIC, groupId = "bff-group", containerFactory = "kafkaListenerFactory")
    void listenerControlSystems(String analysisResultModelString) throws JsonProcessingException {
        AnalysisResultModel analysisResultModel = objectMapper.readValue(analysisResultModelString, AnalysisResultModel.class);
        System.out.println(String.format("Control Systems: %s", analysisResultModel.getResult()));
    }

    @KafkaListener(topics = RESULT_ENGINE_SYSTEMS_TOPIC, groupId = "bff-group", containerFactory = "kafkaListenerFactory")
    void listenerEngineSystems(String analysisResultModelString) throws JsonProcessingException {
        AnalysisResultModel analysisResultModel = objectMapper.readValue(analysisResultModelString, AnalysisResultModel.class);
        System.out.println(String.format("Engine Systems: %s", analysisResultModel.getResult()));
    }

    @KafkaListener(topics = RESULT_MOUNTING_SYSTEMS_TOPIC, groupId = "bff-group", containerFactory = "kafkaListenerFactory")
    void listenerMountingSystems(String analysisResultModelString) throws JsonProcessingException {
        AnalysisResultModel analysisResultModel = objectMapper.readValue(analysisResultModelString, AnalysisResultModel.class);
        System.out.println(String.format("Mounting Systems: %s", analysisResultModel.getResult()));
    }

    @KafkaListener(topics = RESULT_POWER_TRANSMISSION_TOPIC, groupId = "bff-group", containerFactory = "kafkaListenerFactory")
    void listenerPowerTransmission(String analysisResultModelString) throws JsonProcessingException {
        AnalysisResultModel analysisResultModel = objectMapper.readValue(analysisResultModelString, AnalysisResultModel.class);
        System.out.println(String.format("Power Transmission: %s", analysisResultModel.getResult()));
    }

}
