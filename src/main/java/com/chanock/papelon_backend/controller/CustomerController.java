// src/main/java/com/chanock/papelon_backend/controller/CustomerController.java
package com.chanock.papelon_backend.controller;

import com.chanock.papelon_backend.dto.*;
import com.chanock.papelon_backend.mapper.CustomerMapper;
import com.chanock.papelon_backend.model.Customers;
import com.chanock.papelon_backend.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Tag(name = "Customers", description = "Operaciones CRUD sobre clientes")
public class CustomerController {

    private final CustomerService service;
    private final CustomerMapper mapper;

    @Operation(summary = "Listar todos los clientes")
    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAll() {
        var dtos = service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @Operation(summary = "Obtener un cliente por ID")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getById(@PathVariable Long id) {
        Customers c = service.findById(id);
        return ResponseEntity.ok(mapper.toDto(c));
    }

    @Operation(summary = "Crear un nuevo cliente")
    @PostMapping
    public ResponseEntity<CustomerResponseDto> create(
            @RequestBody @Valid CustomerRequestDto req) {
        Customers created = service.create(mapper.toEntity(req));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toDto(created));
    }

    @Operation(summary = "Actualizar un cliente")
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> update(
            @PathVariable Long id,
            @RequestBody @Valid CustomerRequestDto req) {
        Customers updated = service.update(id, mapper.toEntity(req));
        return ResponseEntity.ok(mapper.toDto(updated));
    }

    @Operation(summary = "Eliminar un cliente")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
