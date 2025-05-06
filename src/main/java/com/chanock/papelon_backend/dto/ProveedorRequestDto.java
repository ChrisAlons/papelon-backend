// src/main/java/com/chanock/papelon_backend/dto/ProveedorRequestDto.java
package com.chanock.papelon_backend.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProveedorRequestDto {
    @Size(max = 100)
    private String nombre;

    @Size(max = 20)
    private String telefono;

    private String direccion;
}
