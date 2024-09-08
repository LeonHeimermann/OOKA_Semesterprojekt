package org.ooka.msenginesystems.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisConfigurationRequestModel {
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
