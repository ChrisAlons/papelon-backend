// src/main/java/com/chanock/papelon_backend/dto/ProductoRequestDto.java
package com.chanock.papelon_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(name = "ProductoRequest", description = "Datos para crear o actualizar un producto")
public class ProductoRequestDto {

    @NotBlank @Size(max = 100)
    @Schema(description = "Nombre del producto", example = "Cuaderno rayado A4")
    private String nombre;

    @Schema(description = "Descripción del producto", example = "100 hojas, tapa dura")
    private String descripcion;

    @NotNull @DecimalMin("0.0")
    @Schema(description = "Precio de compra", example = "15.50")
    private BigDecimal precioCompra;

    @NotNull @DecimalMin("0.0")
    @Schema(description = "Precio de venta", example = "25.00")
    private BigDecimal precioVenta;
}
