package org.ooka.bffservice.persistence;

import jakarta.persistence.*;
import lombok.*;
import org.ooka.bffservice.model.enums.*;

import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor()
@Getter @Setter
public class Configuration {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String title;
    private String description;
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private EngineType engineType;
    @Enumerated(EnumType.STRING)
    private EngineConfiguration engineConfiguration;
    @Enumerated(EnumType.STRING)
    private StartingSystem startingSystem;
    @Enumerated(EnumType.STRING)
    private AuxiliaryPTO auxiliaryPTO;
    @Enumerated(EnumType.STRING)
    private OilSystem oilSystem;
    @Enumerated(EnumType.STRING)
    private FuelSystem fuelSystem;
    @Enumerated(EnumType.STRING)
    private CoolingSystem coolingSystem;
    @Enumerated(EnumType.STRING)
    private ExhaustSystem exhaustSystem;
    @Enumerated(EnumType.STRING)
    private MountingSystem mountingSystem;
    @Enumerated(EnumType.STRING)
    private EngineManagementSystem engineManagementSystem;
    @Enumerated(EnumType.STRING)
    private MonitoringSystem monitoringSystem;
    @Enumerated(EnumType.STRING)
    private PowerTransmission powerTransmission;
    @Enumerated(EnumType.STRING)
    private GearboxOptions gearboxOption;

    @PrePersist
    private void createdAt() {
        createdAt = LocalDateTime.now();
    }
}
