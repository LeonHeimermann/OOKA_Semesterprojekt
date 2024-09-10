package org.ooka.msmountingsystems.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnalysisResultDto {
    private String uuid;
    private String result;
}
