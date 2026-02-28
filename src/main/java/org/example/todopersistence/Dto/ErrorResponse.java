package org.example.todopersistence.Dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ErrorResponse {
    private int status;
    private String message;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}
