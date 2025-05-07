// src/main/java/com/chanock/papelon_backend/dto/UsuarioRequestDto.java
package com.chanock.papelon_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "UsuarioRequest", description = "Datos para crear o actualizar un usuario")
public class UsuarioRequestDto {
    @NotBlank @Size(min = 3, max = 50)
    @Schema(description = "Nombre de usuario único", example = "juan.perez")
    private String username;

    @NotBlank @Size(min = 5, max = 100)
    @Schema(description = "Contraseña en texto plano (será encriptada)", example = "Secret123!")
    private String password;

    @NotBlank @Size(max = 20)
    @Schema(description = "Rol del usuario (ADMIN o CAJERO)", example = "ADMIN")
    private String rol;
}
