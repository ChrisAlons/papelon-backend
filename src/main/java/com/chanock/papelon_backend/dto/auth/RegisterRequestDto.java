package com.chanock.papelon_backend.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequestDto {

    @NotBlank
    @Size(min = 4, max = 50)
    private String username;

    @NotBlank
    @Size(min = 8, max = 100)
    private String password;

    /**
     * Rol del usuario al registrarse.
     * Podría venir "admin", "cajero"
     */
    @NotBlank
    @Size(max = 20)
    private String rol;
}
