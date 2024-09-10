package org.ooka.bffservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnalysisConfigurationDto {
    private String uuid;
    private ConfigurationDTO configuration;
}
