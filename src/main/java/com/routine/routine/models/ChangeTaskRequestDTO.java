package com.routine.routine.models;

import lombok.Data;

@Data
public class ChangeTaskRequestDTO {
    private String name;
    private Boolean status;
}
