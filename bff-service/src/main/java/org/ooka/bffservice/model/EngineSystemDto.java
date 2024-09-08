package org.ooka.bffservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EngineSystemDto {
    private String engineType;
    private String engineConfiguration;
}
