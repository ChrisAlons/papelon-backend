// src/main/java/com/chanock/papelon_backend/dto/CompraRequestDto.java
package com.chanock.papelon_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Schema(name="CompraRequest", description="Datos para crear una compra")
public class CompraRequestDto {
    @NotNull
    @Schema(description="ID del usuario que registra", example="1")
    private Integer usuarioId;

    @NotNull
    @Schema(description="ID del proveedor", example="2")
    private Integer proveedorId;

    @NotNull
    @Schema(description="Detalle de todos los productos comprados")
    private List<DetalleCompraRequestDto> detalles;
}
