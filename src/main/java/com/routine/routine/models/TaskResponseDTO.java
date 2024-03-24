package com.routine.routine.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TaskResponseDTO {
    private String name;
    private Boolean status;
    private String createdAt;
}
