package org.ooka.bffservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnalysisResultDto {
    private String result;
    private String serviceId;
}
