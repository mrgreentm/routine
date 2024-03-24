package com.routine.routine.controllers;

import com.routine.routine.entities.TaskEntity;
import com.routine.routine.models.ChangeTaskRequestDTO;
import com.routine.routine.models.TaskRequestDTO;
import com.routine.routine.models.TaskResponseDTO;
import com.routine.routine.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/task")
    public ResponseEntity<List<TaskEntity>> helloRoutine() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }
    @PostMapping("/task")
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }
    @PutMapping("/task/{id}")
    public ResponseEntity<TaskEntity> changeStatusTask(
            @PathVariable Long id,
            @RequestBody ChangeTaskRequestDTO task
    ) {
        return ResponseEntity.ok(taskService.changeStatusTask(id, task));
    }
    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

}
