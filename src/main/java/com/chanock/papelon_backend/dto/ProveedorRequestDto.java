// src/main/java/com/chanock/papelon_backend/dto/ProveedorRequestDto.java
package com.chanock.papelon_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name="ProveedorRequest", description="Datos para crear o actualizar un proveedor")
public class ProveedorRequestDto {
    @NotBlank @Size(max=100)
    @Schema(description="Nombre del proveedor", example="Papelería El Sol")
    private String nombre;

    @Size(max=20)
    @Schema(description="Teléfono de contacto", example="55-1234-5678")
    private String telefono;

    @Schema(description="Dirección", example="Calle Falsa 123, Ciudad de México")
    private String direccion;
}
