package org.example.todopersistence.Service;

import org.example.todopersistence.Dto.TaskCreateDTO;
import org.example.todopersistence.Dto.TaskDeleteDTO;
import org.example.todopersistence.Dto.TaskResponseDTO;
import org.example.todopersistence.Dto.TaskUpdateDTO;
import org.example.todopersistence.Exceptions.TaskNotFoundException;
import org.example.todopersistence.Models.Task;
import org.example.todopersistence.Models.TaskStatus;
import org.example.todopersistence.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskResponseDTO> getTasks(TaskStatus status){
        List<Task> tasks;
        if(status == null){
            tasks = taskRepository.findAll();
        } else {
            tasks = taskRepository.findByStatus(status);
        }

        return tasks.stream()
                .map(task -> new TaskResponseDTO(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.getStatus()
                )).toList();
    }

    public TaskResponseDTO findTaskById(Long id){
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Not found"));
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus()
        );
    }
    public TaskResponseDTO addTask(TaskCreateDTO dto){
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(TaskStatus.PENDING);

        Task savedTask = taskRepository.save(task);

        return new TaskResponseDTO(
                savedTask.getId(),
                savedTask.getTitle(),
                savedTask.getDescription(),
                savedTask.getStatus()
        );
    }

    public TaskResponseDTO editTask(Long id, TaskUpdateDTO dto) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Not found"));

        if(dto.getTitle() != null){
            task.setTitle(dto.getTitle());
        }
        if(dto.getDescription() != null){
            task.setDescription((dto.getDescription()));
        }

        if(dto.getStatus() != null){
            task.setStatus((dto.getStatus()));
        }

        taskRepository.save(task);
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus()
        );
    }

    public void deleteTask(Long id){
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Not found"));
        taskRepository.deleteById(id);
    }
}
