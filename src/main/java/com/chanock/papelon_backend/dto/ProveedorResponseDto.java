// src/main/java/com/chanock/papelon_backend/dto/ProveedorResponseDto.java
package com.chanock.papelon_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name="ProveedorResponse", description="Información de un proveedor")
public class ProveedorResponseDto {
    @Schema(description="ID del proveedor", example="1")
    private Integer id;

    @Schema(description="Nombre del proveedor", example="Papelería El Sol")
    private String nombre;

    @Schema(description="Teléfono de contacto", example="55-1234-5678")
    private String telefono;

    @Schema(description="Dirección", example="Calle Falsa 123, Ciudad de México")
    private String direccion;

    @Schema(description="Fecha de creación")
    private LocalDateTime createdAt;

    @Schema(description="Fecha de última actualización")
    private LocalDateTime updatedAt;
}
