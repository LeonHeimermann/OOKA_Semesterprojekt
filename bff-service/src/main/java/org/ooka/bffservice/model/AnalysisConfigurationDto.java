package org.ooka.bffservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnalysisConfigurationDto {
    private String engineType;
    private String engineConfiguration;
    private String startingSystem;
    private String auxiliaryPTO;
    private String oilSystem;
    private String fuelSystem;
    private String coolingSystem;
    private String exhaustSystem;
    private String mountingSystem;
    private String engineManagementSystem;
    private String monitoringSystem;
    private String powerTransmission;
    private String gearboxOption;
}
