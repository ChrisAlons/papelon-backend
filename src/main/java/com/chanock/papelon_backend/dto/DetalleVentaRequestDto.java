// src/main/java/com/chanock/papelon_backend/dto/DetalleVentaRequestDto.java
package com.chanock.papelon_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(name = "DetalleVentaRequest", description = "Un ítem de la venta")
public class DetalleVentaRequestDto {
    @NotNull
    @Schema(description = "ID del producto", example = "5")
    private Integer productoId;

    @NotNull @Min(1)
    @Schema(description = "Cantidad vendida", example = "3")
    private Integer cantidad;

    @NotNull
    @Schema(description = "Precio unitario de venta", example = "25.00")
    private java.math.BigDecimal precioUnitario;
}
