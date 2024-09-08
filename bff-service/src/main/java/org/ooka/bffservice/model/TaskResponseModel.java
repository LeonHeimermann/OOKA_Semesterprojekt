package org.ooka.bffservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseModel implements Serializable {
    private String taskId;
    private String result;
    private String serviceTypeId;
}
