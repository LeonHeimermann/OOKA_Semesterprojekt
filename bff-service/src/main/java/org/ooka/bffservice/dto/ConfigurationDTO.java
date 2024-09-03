package org.ooka.bffservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ooka.bffservice.model.enums.*;
import org.ooka.bffservice.persistence.Configuration;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ConfigurationDTO {
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

    public ConfigurationDTO(Configuration c) {
        this.title = c.getTitle();
        this.description = c.getDescription();
        this.createdAt = c.getCreatedAt();

        this.engineType = c.getEngineType();
        this.engineConfiguration = c.getEngineConfiguration();
        this.startingSystem = c.getStartingSystem();
        this.auxiliaryPTO = c.getAuxiliaryPTO();
        this.oilSystem = c.getOilSystem();
        this.fuelSystem = c.getFuelSystem();
        this.coolingSystem = c.getCoolingSystem();
        this.exhaustSystem = c.getExhaustSystem();
        this.mountingSystem = c.getMountingSystem();
        this.engineManagementSystem = c.getEngineManagementSystem();
        this.monitoringSystem = c.getMonitoringSystem();
        this.powerTransmission = c.getPowerTransmission();
        this.gearboxOption = c.getGearboxOption();
    }

    public Configuration convertToModel() {
        var c = new Configuration();

         c.setTitle(this.title);
         c.setDescription(this.description);

         c.setEngineType(this.engineType);
         c.setEngineConfiguration(this.engineConfiguration);
         c.setStartingSystem(this.startingSystem);
         c.setAuxiliaryPTO(this.auxiliaryPTO);
         c.setOilSystem(this.oilSystem);
         c.setFuelSystem(this.fuelSystem);
         c.setCoolingSystem(this.coolingSystem);
         c.setExhaustSystem(this.exhaustSystem);
         c.setMountingSystem(this.mountingSystem);
         c.setEngineManagementSystem(this.engineManagementSystem);
         c.setMonitoringSystem(this.monitoringSystem);
         c.setPowerTransmission(this.powerTransmission);
         c.setGearboxOption(this.gearboxOption);

        return c;
    }
}
