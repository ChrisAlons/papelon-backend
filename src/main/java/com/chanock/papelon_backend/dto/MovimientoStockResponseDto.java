// src/main/java/com/chanock/papelon_backend/dto/MovimientoStockResponseDto.java
package com.chanock.papelon_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "MovimientoStockResponse", description = "Registro de un movimiento de inventario")
public class MovimientoStockResponseDto {
    @Schema(description = "ID del movimiento", example = "10")
    private Integer id;

    @Schema(description = "ID del producto", example = "1")
    private Integer productoId;

    @Schema(description = "Fecha del movimiento")
    private LocalDateTime fecha;

    @Schema(description = "Cantidad movida (positivo=ingreso, negativo=egreso)", example = "10")
    private Integer cantidad;

    @Schema(description = "Tipo de movimiento: INGRESO o EGRESO", example = "INGRESO")
    private String tipo;

    @Schema(description = "ID de la compra o venta que originó el movimiento", example = "5")
    private Integer referenciaId;

    @Schema(description = "Origen del movimiento: COMPRA o VENTA", example = "COMPRA")
    private String referenciaTipo;
}
