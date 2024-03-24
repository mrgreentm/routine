package com.routine.routine.controllers;

import com.routine.routine.entities.TaskEntity;
import com.routine.routine.models.TaskRequestDTO;
import com.routine.routine.models.TaskResponseDTO;
import com.routine.routine.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoutineController {

    private final TaskService taskService;

    public RoutineController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task")
    public ResponseEntity<List<TaskEntity>> helloRoutine() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }
    @PostMapping("/task")
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

}