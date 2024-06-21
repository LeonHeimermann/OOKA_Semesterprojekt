package org.ooka.bffservice.task;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TaskResultDto {
    private List<String> taskResult;
}
