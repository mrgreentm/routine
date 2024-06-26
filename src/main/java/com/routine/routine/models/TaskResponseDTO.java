package com.routine.routine.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskResponseDTO {
    private String name;
    private Boolean status;
    private String createdAt;
}
