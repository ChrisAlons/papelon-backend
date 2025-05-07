// src/main/java/com/chanock/papelon_backend/dto/DetalleCompraRequestDto.java
package com.chanock.papelon_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(name="DetalleCompraRequest", description="Un ítem de la compra")
public class DetalleCompraRequestDto {
    @NotNull
    @Schema(description="ID del producto", example="5")
    private Integer productoId;

    @NotNull @Min(1)
    @Schema(description="Cantidad comprada", example="10")
    private Integer cantidad;

    @NotNull
    @Schema(description="Precio unitario", example="12.50")
    private BigDecimal precioUnitario;
}
