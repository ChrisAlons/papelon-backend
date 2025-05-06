package com.chanock.papelon_backend.mapper;

import com.chanock.papelon_backend.dto.UsuarioResponseDto;
import com.chanock.papelon_backend.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioResponseDto toDto(Usuario u) {
        return new UsuarioResponseDto(u.getId(), u.getUsername(), u.getRol());
    }
}
