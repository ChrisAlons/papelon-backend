package com.chanock.papelon_backend.controller;

import com.chanock.papelon_backend.dto.auth.*;
import com.chanock.papelon_backend.model.Usuario;
import com.chanock.papelon_backend.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @RequestBody @Valid LoginRequestDto req) {
        return ResponseEntity.ok(authService.login(req));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(
            @RequestBody @Valid RegisterRequestDto req) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authService.register(req));
    }


}
