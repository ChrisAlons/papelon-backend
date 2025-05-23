// src/main/java/com/chanock/papelon_backend/dto/DetalleCompraResponseDto.java
package com.chanock.papelon_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Schema(name="DetalleCompraResponse", description="Detalle de ítem en la compra")
public class DetalleCompraResponseDto {
    @Schema(description="ID del detalle", example="1")
    private Integer id;

    @Schema(description="ID de la compra", example="1")
    private Integer compraId;

    @Schema(description="ID del producto", example="5")
    private Integer productoId;

    @Schema(description="Nombre del producto", example="Producto A")
    private String nombreProducto;

    @Schema(description="Cantidad comprada", example="10")
    private Integer cantidad;

    @Schema(description="Precio unitario", example="12.50")
    private BigDecimal precioUnitario;

    @Schema(description="Fecha de creación del detalle")
    private LocalDateTime createdAt;
}
