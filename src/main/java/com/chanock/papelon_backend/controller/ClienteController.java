// src/main/java/com/chanock/papelon_backend/controller/ClienteController.java
package com.chanock.papelon_backend.controller;

import com.chanock.papelon_backend.dto.ApiResponse;
import com.chanock.papelon_backend.dto.ClienteRequestDto;
import com.chanock.papelon_backend.dto.ClienteResponseDto;
import com.chanock.papelon_backend.model.Cliente;
import com.chanock.papelon_backend.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Clientes", description = "CRUD de clientes (terceros)")
@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService svc;

    private ClienteResponseDto toDto(Cliente c) {
        ClienteResponseDto dto = new ClienteResponseDto();
        dto.setId(c.getId());
        dto.setNombre(c.getNombre());
        dto.setEmail(c.getEmail());
        dto.setTelefono(c.getTelefono());
        dto.setDireccion(c.getDireccion());
        dto.setCreatedAt(c.getCreatedAt());
        dto.setUpdatedAt(c.getUpdatedAt());
        return dto;
    }

    @Operation(summary = "Listar clientes", description = "Obtiene todos los clientes ordenados por ID ascendente")
    @GetMapping
    public ResponseEntity<ApiResponse<List<ClienteResponseDto>>> getAll() {
        List<ClienteResponseDto> list = svc.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse<>(true, "Lista de clientes", list));
    }

    @Operation(summary = "Obtener cliente", description = "Busca un cliente por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ClienteResponseDto>> getById(@PathVariable Integer id) {
        ClienteResponseDto dto = toDto(svc.findById(id));
        return ResponseEntity.ok(new ApiResponse<>(true, "Cliente encontrado", dto));
    }

    @Operation(summary = "Crear cliente", description = "Registra un nuevo cliente (tercero)")
    @PostMapping
    public ResponseEntity<ApiResponse<ClienteResponseDto>> create(
            @Valid @RequestBody ClienteRequestDto req) {
        Cliente c = svc.create(req);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Cliente creado", toDto(c)));
    }

    @Operation(summary = "Actualizar cliente", description = "Modifica datos de un cliente existente")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ClienteResponseDto>> update(
            @PathVariable Integer id,
            @Valid @RequestBody ClienteRequestDto req) {
        Cliente c = svc.update(id, req);
        return ResponseEntity.ok(new ApiResponse<>(true, "Cliente actualizado", toDto(c)));
    }

    @Operation(summary = "Eliminar cliente", description = "Borra un cliente por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        svc.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Cliente eliminado", null));
    }
}
