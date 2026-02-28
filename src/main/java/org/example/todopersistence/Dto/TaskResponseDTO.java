package org.example.todopersistence.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.todopersistence.Models.TaskStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TaskResponseDTO {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
}
