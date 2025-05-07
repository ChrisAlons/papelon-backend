// src/main/java/com/chanock/papelon_backend/dto/ApiResponse.java
package com.chanock.papelon_backend.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ApiResponse", description = "Formato estándar de respuesta para todas las APIs")
public class ApiResponse<T> {

    @Schema(description = "Indica si la operación fue exitosa", example = "true")
    private boolean success;

    @Schema(description = "Mensaje descriptivo de la operación", example = "Producto creado correctamente")
    private String message;

    @Schema(description = "Datos devueltos por la operación")
    private T data;
}
