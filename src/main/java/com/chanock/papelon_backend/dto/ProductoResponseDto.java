// src/main/java/com/chanock/papelon_backend/dto/ProductoResponseDto.java
package com.chanock.papelon_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Schema(name = "ProductoResponse", description = "Información de un producto")
public class ProductoResponseDto {

    @Schema(description = "ID del producto", example = "1")
    private Integer id;

    @Schema(description = "Nombre del producto", example = "Cuaderno rayado A4")
    private String nombre;

    @Schema(description = "Descripción", example = "100 hojas, tapa dura")
    private String descripcion;

    @Schema(description = "Precio de compra", example = "15.50")
    private BigDecimal precioCompra;

    @Schema(description = "Precio de venta", example = "25.00")
    private BigDecimal precioVenta;

    @Schema(description = "Fecha de creación")
    private LocalDateTime createdAt;

    @Schema(description = "Fecha de última actualización")
    private LocalDateTime updatedAt;
}
