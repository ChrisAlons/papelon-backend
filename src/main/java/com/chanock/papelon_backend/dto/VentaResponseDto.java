// src/main/java/com/chanock/papelon_backend/dto/VentaResponseDto.java
package com.chanock.papelon_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema(name = "VentaResponse", description = "Información de una venta")
public class VentaResponseDto {
    @Schema(description = "ID de la venta", example = "1")
    private Integer id;

    @Schema(description = "ID del usuario que registró", example = "1")
    private Integer usuarioId;

    @Schema(description = "ID del cliente", example = "2")
    private Integer clienteId;

    @Schema(description = "Fecha de la venta")
    private LocalDateTime fecha;

    @Schema(description = "Total de la venta", example = "75.00")
    private BigDecimal total;

    @Schema(description = "Fecha de creación")
    private LocalDateTime createdAt;

    @Schema(description = "Fecha de última actualización")
    private LocalDateTime updatedAt;

    @Schema(description = "Lista de detalles de la venta")
    private List<DetalleVentaResponseDto> detalles;
}
