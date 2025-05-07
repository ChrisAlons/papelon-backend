// src/main/java/com/chanock/papelon_backend/dto/UsuarioResponseDto.java
package com.chanock.papelon_backend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsuarioResponseDto {
    private Integer id;
    private String username;
    private String rol;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
