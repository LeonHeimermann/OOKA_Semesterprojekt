package org.ooka.bffservice.persistence;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor()
public class Configuration {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime createdAt;

    private String engineType;
    private String engineConfiguration;
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
