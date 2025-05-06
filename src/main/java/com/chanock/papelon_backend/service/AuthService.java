package com.chanock.papelon_backend.service;

import com.chanock.papelon_backend.dto.auth.*;
import com.chanock.papelon_backend.model.Usuario;
import com.chanock.papelon_backend.repository.UsuarioRepository;
import com.chanock.papelon_backend.security.JwtTokenProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authManager;
    private final JwtTokenProvider tokenProvider;
    private final UsuarioRepository repo;
    private final UsuarioService usuarioService;

    public LoginResponseDto login(@Valid LoginRequestDto req) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getUsername(), req.getPassword())
        );
        Usuario u = repo.findByUsername(req.getUsername()).get();
        String token = tokenProvider.generateToken(u.getUsername(), u.getRol());
        return new LoginResponseDto(token, u.getUsername(), u.getRol());
    }

    public RegisterResponseDto register(RegisterRequestDto req) {
        // mapear DTO → entidad
        Usuario u = Usuario.builder()
                .username(req.getUsername())
                .password(req.getPassword())  // se encriptará en el service
                .rol(req.getRol())
                .build();

        Usuario saved = usuarioService.create(u);
        // mapear entidad → DTO de respuesta
        return RegisterResponseDto.builder()
                .id(saved.getId())
                .username(saved.getUsername())
                .rol(saved.getRol())
                .build();
    }

}
