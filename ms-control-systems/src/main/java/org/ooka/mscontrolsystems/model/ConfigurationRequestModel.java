package org.ooka.mscontrolsystems.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ooka.mscontrolsystems.model.enums.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ConfigurationRequestModel {
    private String title;
    private String description;
    private LocalDateTime createdAt;

    private EngineType engineType;
    private EngineConfiguration engineConfiguration;
    private StartingSystem startingSystem;
    private AuxiliaryPTO auxiliaryPTO;
    private OilSystem oilSystem;
    private FuelSystem fuelSystem;
    private CoolingSystem coolingSystem;
    private ExhaustSystem exhaustSystem;
    private MountingSystem mountingSystem;
    private EngineManagementSystem engineManagementSystem;
    private MonitoringSystem monitoringSystem;
    private PowerTransmission powerTransmission;
    private GearboxOptions gearboxOption;
}
