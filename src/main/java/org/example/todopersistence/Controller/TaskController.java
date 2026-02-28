package org.example.todopersistence.Controller;

import jakarta.validation.Valid;
import org.example.todopersistence.Dto.TaskCreateDTO;
import org.example.todopersistence.Dto.TaskResponseDTO;
import org.example.todopersistence.Dto.TaskUpdateDTO;
import org.example.todopersistence.Models.TaskStatus;
import org.example.todopersistence.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<TaskResponseDTO> getTasks(@RequestParam(required = false) TaskStatus status){
        return taskService.getTasks(status);
    }

    @GetMapping("/tasks/{id}")
    public TaskResponseDTO getTaskById(@PathVariable Long id){
        return taskService.findTaskById(id);
    }

    @PostMapping("/tasks")
    public TaskResponseDTO addTask(@Valid @RequestBody TaskCreateDTO dto){
        return taskService.addTask(dto);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @PatchMapping("/tasks/{id}")
    public TaskResponseDTO editTask(@PathVariable Long id, @Valid @RequestBody TaskUpdateDTO dto){
        return taskService.editTask(id, dto);
    }

}
