package org.example.todopersistence.Dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TaskCreateDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
}
