package com.example.buoi5_jpa.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private HttpStatus status;
    private String message;
}
