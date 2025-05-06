package com.chanock.papelon_backend.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, Long id) {
        super(resource + " con ID " + id + " no encontrado.");
    }
}
