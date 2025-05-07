// src/main/java/com/chanock/papelon_backend/controller/UsuarioController.java
package com.chanock.papelon_backend.controller;

import com.chanock.papelon_backend.dto.ApiResponse;
import com.chanock.papelon_backend.dto.UsuarioRequestDto;
import com.chanock.papelon_backend.dto.UsuarioResponseDto;
import com.chanock.papelon_backend.model.Usuario;
import com.chanock.papelon_backend.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService svc;

    private UsuarioResponseDto toDto(Usuario u) {
        UsuarioResponseDto dto = new UsuarioResponseDto();
        dto.setId(u.getId());
        dto.setUsername(u.getUsername());
        dto.setRol(u.getRol());
        dto.setCreatedAt(u.getCreatedAt());
        dto.setUpdatedAt(u.getUpdatedAt());
        return dto;
    }

    @Operation(summary = "Listar usuarios", description = "Obtiene todos los usuarios registrados")
    @GetMapping
    public ResponseEntity<ApiResponse<List<UsuarioResponseDto>>> getAll() {
        List<UsuarioResponseDto> list = svc.findAll().stream()
                .map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse<>(true, "Lista de usuarios", list));
    }

    @Operation(summary = "Obtener usuario", description = "Busca un usuario por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UsuarioResponseDto>> getById(@PathVariable Integer id) {
        UsuarioResponseDto dto = toDto(svc.findById(id));
        return ResponseEntity.ok(new ApiResponse<>(true, "Usuario encontrado", dto));
    }

    @Operation(summary = "Crear usuario", description = "Registra un nuevo usuario")
    @PostMapping
    public ResponseEntity<ApiResponse<UsuarioResponseDto>> create(
            @Valid @RequestBody UsuarioRequestDto req) {
        Usuario u = svc.create(req);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Usuario creado", toDto(u)));
    }

    @Operation(summary = "Actualizar usuario", description = "Modifica datos de un usuario existente")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UsuarioResponseDto>> update(
            @PathVariable Integer id,
            @Valid @RequestBody UsuarioRequestDto req) {
        Usuario u = svc.update(id, req);
        return ResponseEntity.ok(new ApiResponse<>(true, "Usuario actualizado", toDto(u)));
    }

    @Operation(summary = "Eliminar usuario", description = "Borra un usuario por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        svc.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Usuario eliminado", null));
    }
}
