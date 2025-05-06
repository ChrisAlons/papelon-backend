package com.chanock.papelon_backend.dto.auth;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterResponseDto {

    private Long id;
    private String username;
    private String rol;
}
