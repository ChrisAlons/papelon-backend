// src/main/java/com/chanock/papelon_backend/controller/ProveedorController.java
package com.chanock.papelon_backend.controller;

import com.chanock.papelon_backend.dto.ApiResponse;
import com.chanock.papelon_backend.dto.ProveedorRequestDto;
import com.chanock.papelon_backend.dto.ProveedorResponseDto;
import com.chanock.papelon_backend.model.Proveedor;
import com.chanock.papelon_backend.service.ProveedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Proveedores", description = "Operaciones sobre proveedores")
@RestController
@RequestMapping("/api/proveedores")
@RequiredArgsConstructor
public class ProveedorController {

    private final ProveedorService svc;

    private ProveedorResponseDto toDto(Proveedor p) {
        ProveedorResponseDto dto = new ProveedorResponseDto();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setTelefono(p.getTelefono());
        dto.setDireccion(p.getDireccion());
        dto.setCreatedAt(p.getCreatedAt());
        dto.setUpdatedAt(p.getUpdatedAt());
        return dto;
    }

    @Operation(summary = "Listar proveedores", description = "Obtiene todos los proveedores")
    @GetMapping
    public ResponseEntity<ApiResponse<List<ProveedorResponseDto>>> getAll() {
        List<ProveedorResponseDto> list = svc.findAll().stream()
                .map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse<>(true, "Lista de proveedores", list));
    }

    @Operation(summary = "Obtener proveedor", description = "Busca un proveedor por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProveedorResponseDto>> getById(@PathVariable Integer id) {
        ProveedorResponseDto dto = toDto(svc.findById(id));
        return ResponseEntity.ok(new ApiResponse<>(true, "Proveedor encontrado", dto));
    }

    @Operation(summary = "Crear proveedor", description = "Registra un nuevo proveedor")
    @PostMapping
    public ResponseEntity<ApiResponse<ProveedorResponseDto>> create(
            @Valid @RequestBody ProveedorRequestDto req) {
        Proveedor p = svc.create(req);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Proveedor creado", toDto(p)));
    }

    @Operation(summary = "Actualizar proveedor", description = "Modifica un proveedor existente")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProveedorResponseDto>> update(
            @PathVariable Integer id,
            @Valid @RequestBody ProveedorRequestDto req) {
        Proveedor p = svc.update(id, req);
        return ResponseEntity.ok(new ApiResponse<>(true, "Proveedor actualizado", toDto(p)));
    }

    @Operation(summary = "Eliminar proveedor", description = "Borra un proveedor por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        svc.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Proveedor eliminado", null));
    }
}
