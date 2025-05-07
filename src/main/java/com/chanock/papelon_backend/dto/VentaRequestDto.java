// src/main/java/com/chanock/papelon_backend/dto/VentaRequestDto.java
package com.chanock.papelon_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Schema(name = "VentaRequest", description = "Datos para crear una venta")
public class VentaRequestDto {
    @NotNull
    @Schema(description = "ID del usuario que registra", example = "1")
    private Integer usuarioId;

    @Schema(description = "ID del cliente (opcional)", example = "2")
    private Integer clienteId;

    @NotNull @Valid
    @Schema(description = "Lista de detalles de la venta")
    private List<DetalleVentaRequestDto> detalles;
}
