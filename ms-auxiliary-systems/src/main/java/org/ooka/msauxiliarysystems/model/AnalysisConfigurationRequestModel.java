package org.ooka.msauxiliarysystems.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisConfigurationRequestModel {
    private String uuid;
    private ConfigurationRequestModel configuration;
}
