// src/main/java/com/chanock/papelon_backend/dto/ClienteRequestDto.java
package com.chanock.papelon_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(name = "ClienteRequest", description = "DTO para crear o actualizar un cliente")
public class ClienteRequestDto {
    @NotBlank
    @Schema(description = "Nombre del cliente", example = "Juan Perez")
    private String nombre;

    @Schema(description = "Correo electrónico del cliente", example = "juan.perez@example.com")
    private String email;

    @Schema(description = "Teléfono del cliente", example = "5512345678")
    private String telefono;

    @Schema(description = "Dirección del cliente", example = "Calle 123, Ciudad de México")
    private String direccion;
}
