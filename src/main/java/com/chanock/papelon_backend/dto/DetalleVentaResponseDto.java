// src/main/java/com/chanock/papelon_backend/dto/DetalleVentaResponseDto.java
package com.chanock.papelon_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Schema(name = "DetalleVentaResponse", description = "Detalle de un ítem en la venta")
public class DetalleVentaResponseDto {
    @Schema(description = "ID del detalle", example = "1")
    private Integer id;

    @Schema(description = "ID del producto", example = "5")
    private Integer productoId;

    @Schema(description = "Cantidad vendida", example = "3")
    private Integer cantidad;

    @Schema(description = "Precio unitario de venta", example = "25.00")
    private BigDecimal precioUnitario;

    @Schema(description = "Fecha de creación del detalle")
    private LocalDateTime createdAt;
}
