// src/main/java/com/chanock/papelon_backend/mapper/ProveedorMapper.java
package com.chanock.papelon_backend.mapper;

import com.chanock.papelon_backend.dto.*;
import com.chanock.papelon_backend.model.Proveedor;
import org.springframework.stereotype.Component;

@Component
public class ProveedorMapper {

    public ProveedorResponseDto toDto(Proveedor p) {
        return ProveedorResponseDto.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .telefono(p.getTelefono())
                .direccion(p.getDireccion())
                .build();
    }

    public Proveedor toEntity(ProveedorRequestDto dto) {
        return Proveedor.builder()
                .nombre(dto.getNombre())
                .telefono(dto.getTelefono())
                .direccion(dto.getDireccion())
                .build();
    }
}
