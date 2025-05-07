// src/main/java/com/chanock/papelon_backend/dto/ClienteResponseDto.java
package com.chanock.papelon_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "ClienteResponse", description = "Información detallada de un cliente")
public class ClienteResponseDto {
    @Schema(description = "ID del cliente", example = "1")
    private Integer id;

    @Schema(description = "Nombre del cliente", example = "Juan Perez")
    private String nombre;

    @Schema(description = "Correo electrónico del cliente", example = "juan.perez@example.com")
    private String email;

    @Schema(description = "Teléfono del cliente", example = "5512345678")
    private String telefono;

    @Schema(description = "Dirección del cliente", example = "Calle 123, Ciudad de México")
    private String direccion;

    @Schema(description = "Fecha de creación del registro")
    private LocalDateTime createdAt;

    @Schema(description = "Fecha de última actualización del registro")
    private LocalDateTime updatedAt;
}
