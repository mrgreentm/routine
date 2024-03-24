package com.routine.routine.controllers;

import com.routine.routine.entities.TaskEntity;
import com.routine.routine.models.ChangeTaskRequestDTO;
import com.routine.routine.models.TaskRequestDTO;
import com.routine.routine.models.TaskResponseDTO;
import com.routine.routine.services.TaskService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class TaskController {
    private final Logger logger = LoggerFactory.getLogger(TaskController.class);

    private final TaskService taskService;

    @GetMapping("/task")
    public ResponseEntity<List<TaskEntity>> getAllTasks() {
        logger.info("Capturar todas tasks inicializado");
        List<TaskEntity> taskEntities = taskService.getAllTasks();
        logger.info("Capturar todas tasks finalizado");
        return ResponseEntity.ok(taskEntities);
    }
    @PostMapping("/task")
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO task) {
        logger.info("Criar task inicializado");
        TaskResponseDTO taskResponseDTO = taskService.createTask(task);
        logger.info("Criar task finalizado");
        return ResponseEntity.ok(taskResponseDTO);
    }
    @PutMapping("/task/{id}")
    public ResponseEntity<TaskEntity> changeStatusTask(
            @PathVariable Long id,
            @RequestBody ChangeTaskRequestDTO task
    ) {
        logger.info("Editar task inicializado");
        TaskEntity taskEntity = taskService.changeStatusTask(id, task);
        logger.info("Editar task finalizado");
        return ResponseEntity.ok(taskEntity);
    }
    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable Long id) {
        logger.info("Delete task inicializado");
        taskService.deleteTask(id);
        logger.info("Delete task finalizado");
    }

}
