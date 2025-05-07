package com.chanock.papelon_backend.exception;

import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, @NotBlank Integer id) {
        super(resource + " con ID " + id + " no encontrado.");
    }

    public ResourceNotFoundException(String usuario, Long id) {
    }
}
