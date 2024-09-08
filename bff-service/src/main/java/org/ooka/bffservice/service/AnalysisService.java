package org.ooka.bffservice.service;

import lombok.RequiredArgsConstructor;
import org.ooka.bffservice.client.*;
import org.ooka.bffservice.model.AnalysisConfigurationDto;
import org.ooka.bffservice.model.AnalysisConfigurationRequestModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalysisService {

    private final AnalysisConfigurationMapper analysisConfigurationMapper;
    private final AuxiliarySystemsClient auxiliarySystemsClient;
    private final ControlSystemsClient controlSystemsClient;
    private final EngineSystemsClient engineSystemsClient;
    private final MountingSystemsClient mountingSystemsClient;
    private final PowerTransmissionClient powerTransmissionClient;

    public void analyse(AnalysisConfigurationRequestModel configRequestModel) {
        AnalysisConfigurationDto configDto = analysisConfigurationMapper.mapAnalysisConfigurationRequestModelToDto(configRequestModel);
        auxiliarySystemsClient.analyse(configDto);
        controlSystemsClient.analyse(configDto);
        engineSystemsClient.analyse(configDto);
        mountingSystemsClient.analyse(configDto);
        powerTransmissionClient.analyse(configDto);
    }

}
