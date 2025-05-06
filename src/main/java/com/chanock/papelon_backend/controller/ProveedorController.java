// src/main/java/com/chanock/papelon_backend/controller/ProveedorController.java
package com.chanock.papelon_backend.controller;

import com.chanock.papelon_backend.dto.*;
import com.chanock.papelon_backend.mapper.ProveedorMapper;
import com.chanock.papelon_backend.model.Proveedor;
import com.chanock.papelon_backend.service.ProveedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/proveedores")
@RequiredArgsConstructor
@Tag(name = "Proveedores", description = "Operaciones CRUD sobre proveedores")
public class ProveedorController {

    private final ProveedorService service;
    private final ProveedorMapper mapper;

    @Operation(summary = "Listar todos los proveedores")
    @GetMapping
    public ResponseEntity<List<ProveedorResponseDto>> getAll() {
        var dtos = service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @Operation(summary = "Obtener un proveedor por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProveedorResponseDto> getById(@PathVariable Long id) {
        Proveedor p = service.findById(id);
        return ResponseEntity.ok(mapper.toDto(p));
    }

    @Operation(summary = "Crear un nuevo proveedor")
    @PostMapping
    public ResponseEntity<ProveedorResponseDto> create(
            @RequestBody @Valid ProveedorRequestDto req) {
        Proveedor created = service.create(mapper.toEntity(req));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toDto(created));
    }

    @Operation(summary = "Actualizar un proveedor")
    @PutMapping("/{id}")
    public ResponseEntity<ProveedorResponseDto> update(
            @PathVariable Long id,
            @RequestBody @Valid ProveedorRequestDto req) {
        Proveedor updated = service.update(id, mapper.toEntity(req));
        return ResponseEntity.ok(mapper.toDto(updated));
    }

    @Operation(summary = "Eliminar un proveedor")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
