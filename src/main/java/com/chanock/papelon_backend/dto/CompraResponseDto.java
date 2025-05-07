// src/main/java/com/chanock/papelon_backend/dto/CompraResponseDto.java
package com.chanock.papelon_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema(name="CompraResponse", description="Datos de la compra realizada")
public class CompraResponseDto {
    @Schema(description="ID de la compra", example="1")
    private Integer id;

    @Schema(description="ID del usuario que registró", example="1")
    private Integer usuarioId;

    @Schema(description="ID del proveedor", example="2")
    private Integer proveedorId;

    @Schema(description="Fecha de la compra")
    private LocalDateTime fecha;

    @Schema(description="Total calculado", example="125.00")
    private BigDecimal total;

    @Schema(description="Fecha de creación del registro")
    private LocalDateTime createdAt;

    @Schema(description="Fecha de última actualización")
    private LocalDateTime updatedAt;

    @Schema(description="Lista de detalles de compra")
    private List<DetalleCompraResponseDto> detalles;
}
