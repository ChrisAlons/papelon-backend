// src/main/java/com/chanock/papelon_backend/dto/InventarioResponseDto.java
package com.chanock.papelon_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "InventarioResponse", description = "Stock actual de un producto")
public class InventarioResponseDto {
    @Schema(description = "ID del producto", example = "1")
    private Integer productoId;

    @Schema(description = "Stock actual", example = "50")
    private Integer stockActual;

    @Schema(description = "Fecha de última actualización del stock")
    private LocalDateTime updatedAt;
}
