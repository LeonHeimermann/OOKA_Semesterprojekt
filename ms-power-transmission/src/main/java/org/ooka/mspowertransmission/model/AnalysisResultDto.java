package org.ooka.mspowertransmission.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnalysisResultDto {
    private String uuid;
    private String result;
}
