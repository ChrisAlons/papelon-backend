// src/main/java/com/chanock/papelon_backend/controller/UsuarioController.java
package com.chanock.papelon_backend.controller;

import com.chanock.papelon_backend.dto.UsuarioResponseDto;
import com.chanock.papelon_backend.mapper.UsuarioMapper;
import com.chanock.papelon_backend.model.Usuario;
import com.chanock.papelon_backend.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@Tag(name = "Usuarios", description = "Operaciones CRUD sobre usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    @Operation(summary = "Listar todos los usuarios (sin contraseña)")
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> getAll() {
        List<UsuarioResponseDto> dtos = usuarioService.getAll().stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @Operation(summary = "Obtener un usuario por ID (sin contraseña)")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> getById(@PathVariable Long id) {
        Usuario u = usuarioService.getById(id);
        return ResponseEntity.ok(usuarioMapper.toDto(u));
    }

    @Operation(summary = "Crear un nuevo usuario")
    @PostMapping
    public ResponseEntity<UsuarioResponseDto> create(@RequestBody @Valid Usuario request) {
        Usuario created = usuarioService.create(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuarioMapper.toDto(created));
    }

    @Operation(summary = "Actualizar un usuario existente")
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> update(
            @PathVariable Long id,
            @RequestBody @Valid Usuario request) {
        Usuario updated = usuarioService.update(id, request);
        return ResponseEntity.ok(usuarioMapper.toDto(updated));
    }

    @Operation(summary = "Eliminar un usuario")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
