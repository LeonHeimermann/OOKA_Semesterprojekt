package org.ooka.bffservice.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.ooka.bffservice.model.AnalysisResultDto;
import org.ooka.bffservice.model.AnalysisResultModel;
import org.ooka.bffservice.service.AnalysisService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final ObjectMapper objectMapper;
    private final AnalysisService analysisService;

    public static final String RESULT_AUXILIARY_SYSTEMS_TOPIC = "result-auxiliary-systems";
    public static final String RESULT_CONTROL_SYSTEMS_TOPIC = "result-control-systems";
    public static final String RESULT_ENGINE_SYSTEMS_TOPIC = "result-engine-systems";
    public static final String RESULT_MOUNTING_SYSTEMS_TOPIC = "result-mounting-systems";
    public static final String RESULT_POWER_TRANSMISSION_TOPIC = "result-power-transmission";

    public static final String AUXILIARY_SYSTEMS_ID = "auxiliary-systems";
    public static final String CONTROL_SYSTEMS_ID = "control-systems";
    public static final String ENGINE_SYSTEMS_ID = "engine-systems";
    public static final String MOUNTING_SYSTEMS_ID = "mounting-systems";
    public static final String POWER_TRANSMISSION_ID = "power-transmission";

    @KafkaListener(topics = RESULT_AUXILIARY_SYSTEMS_TOPIC, groupId = "bff-group", containerFactory = "kafkaListenerFactory")
    void listenerAuxiliarySystems(String analysisResultModelString) throws JsonProcessingException {
        AnalysisResultModel analysisResultModel = objectMapper.readValue(analysisResultModelString, AnalysisResultModel.class);
        AnalysisResultDto analysisResultDto = generateAnalysisResultDto(analysisResultModel, AUXILIARY_SYSTEMS_ID);
        analysisService.sendAnalysisResult(analysisResultModel.getUuid(), analysisResultDto);
    }

    @KafkaListener(topics = RESULT_CONTROL_SYSTEMS_TOPIC, groupId = "bff-group", containerFactory = "kafkaListenerFactory")
    void listenerControlSystems(String analysisResultModelString) throws JsonProcessingException {
        AnalysisResultModel analysisResultModel = objectMapper.readValue(analysisResultModelString, AnalysisResultModel.class);
        AnalysisResultDto analysisResultDto = generateAnalysisResultDto(analysisResultModel, CONTROL_SYSTEMS_ID);
        analysisService.sendAnalysisResult(analysisResultModel.getUuid(), analysisResultDto);
    }

    @KafkaListener(topics = RESULT_ENGINE_SYSTEMS_TOPIC, groupId = "bff-group", containerFactory = "kafkaListenerFactory")
    void listenerEngineSystems(String analysisResultModelString) throws JsonProcessingException {
        AnalysisResultModel analysisResultModel = objectMapper.readValue(analysisResultModelString, AnalysisResultModel.class);
        AnalysisResultDto analysisResultDto = generateAnalysisResultDto(analysisResultModel, ENGINE_SYSTEMS_ID);
        analysisService.sendAnalysisResult(analysisResultModel.getUuid(), analysisResultDto);
    }

    @KafkaListener(topics = RESULT_MOUNTING_SYSTEMS_TOPIC, groupId = "bff-group", containerFactory = "kafkaListenerFactory")
    void listenerMountingSystems(String analysisResultModelString) throws JsonProcessingException {
        AnalysisResultModel analysisResultModel = objectMapper.readValue(analysisResultModelString, AnalysisResultModel.class);
        AnalysisResultDto analysisResultDto = generateAnalysisResultDto(analysisResultModel, MOUNTING_SYSTEMS_ID);
        analysisService.sendAnalysisResult(analysisResultModel.getUuid(), analysisResultDto);
    }

    @KafkaListener(topics = RESULT_POWER_TRANSMISSION_TOPIC, groupId = "bff-group", containerFactory = "kafkaListenerFactory")
    void listenerPowerTransmission(String analysisResultModelString) throws JsonProcessingException {
        AnalysisResultModel analysisResultModel = objectMapper.readValue(analysisResultModelString, AnalysisResultModel.class);
        AnalysisResultDto analysisResultDto = generateAnalysisResultDto(analysisResultModel, POWER_TRANSMISSION_ID);
        analysisService.sendAnalysisResult(analysisResultModel.getUuid(), analysisResultDto);
    }

    private AnalysisResultDto generateAnalysisResultDto(AnalysisResultModel analysisResultModel, String serviceId) {
        return AnalysisResultDto.builder()
                .result(analysisResultModel.getResult())
                .serviceId(serviceId)
                .build();
    }

}
