// src/main/java/com/chanock/papelon_backend/dto/ProveedorResponseDto.java
package com.chanock.papelon_backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProveedorResponseDto {
    private Long id;
    private String nombre;
    private String telefono;
    private String direccion;
}
