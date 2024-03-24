package com.routine.routine.services;

import com.routine.routine.entities.TaskEntity;
import com.routine.routine.models.ChangeTaskRequestDTO;
import com.routine.routine.models.TaskRequestDTO;
import com.routine.routine.models.TaskResponseDTO;
import com.routine.routine.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO) {
        TaskResponseDTO taskResponseDTO = buildResponse(taskRequestDTO);
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setName(taskRequestDTO.getName());
        taskEntity.setCreatedAt(taskResponseDTO.getCreatedAt());
        taskEntity.setStatus(taskResponseDTO.getStatus());
        taskRepository.save(taskEntity);
        return taskResponseDTO;
    }
    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }
    public TaskEntity changeStatusTask(Long id, ChangeTaskRequestDTO changeTaskRequestDTO) {
        TaskEntity task = taskRepository.getReferenceById(id);
        task.setStatus(changeTaskRequestDTO.getStatus());
        task.setName(changeTaskRequestDTO.getName());
        taskRepository.save(task);
        return task;
    }
    private TaskResponseDTO buildResponse(TaskRequestDTO requestDTO) {
        return TaskResponseDTO
                .builder()
                .status(false)
                .name(requestDTO.getName())
                .createdAt(formatDate(LocalDate.now()))
                .build();
    }
    private String formatDate(LocalDate date) {
        DateTimeFormatter currentFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter actualFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(date.toString(), currentFormat);
        return data.format(actualFormat);
    }
}
