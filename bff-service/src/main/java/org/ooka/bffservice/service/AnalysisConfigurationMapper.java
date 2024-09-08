package org.ooka.bffservice.service;

import org.ooka.bffservice.model.AnalysisConfigurationDto;
import org.ooka.bffservice.model.AnalysisConfigurationRequestModel;
import org.springframework.stereotype.Service;

@Service
public class AnalysisConfigurationMapper {

    public AnalysisConfigurationDto mapAnalysisConfigurationRequestModelToDto(AnalysisConfigurationRequestModel analysisConfigurationRequestModel) {
        return AnalysisConfigurationDto.builder()
                .engineType(analysisConfigurationRequestModel.getEngineType())
                .engineConfiguration(analysisConfigurationRequestModel.getEngineConfiguration())
                .startingSystem(analysisConfigurationRequestModel.getStartingSystem())
                .auxiliaryPTO(analysisConfigurationRequestModel.getAuxiliaryPTO())
                .oilSystem(analysisConfigurationRequestModel.getOilSystem())
                .fuelSystem(analysisConfigurationRequestModel.getFuelSystem())
                .coolingSystem(analysisConfigurationRequestModel.getCoolingSystem())
                .exhaustSystem(analysisConfigurationRequestModel.getExhaustSystem())
                .mountingSystem(analysisConfigurationRequestModel.getMountingSystem())
                .engineManagementSystem(analysisConfigurationRequestModel.getEngineManagementSystem())
                .monitoringSystem(analysisConfigurationRequestModel.getMonitoringSystem())
                .powerTransmission(analysisConfigurationRequestModel.getPowerTransmission())
                .gearboxOption(analysisConfigurationRequestModel.getGearboxOption())
                .build();
    }

}
