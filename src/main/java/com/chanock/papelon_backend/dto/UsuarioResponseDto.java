package com.chanock.papelon_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioResponseDto {
    private Long id;
    private String username;
    private String rol;
}
