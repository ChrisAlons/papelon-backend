// src/main/java/com/chanock/papelon_backend/controller/VentaController.java
package com.chanock.papelon_backend.controller;

import com.chanock.papelon_backend.dto.*;
import com.chanock.papelon_backend.model.Venta;
import com.chanock.papelon_backend.service.VentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Ventas", description = "Registrar y listar ventas, con actualización de stock")
@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class VentaController {

    private final VentaService svc;

    private VentaResponseDto toDto(Venta v) {
        VentaResponseDto dto = new VentaResponseDto();
        dto.setId(v.getId());
        dto.setUsuarioId(v.getUsuario().getId());
        dto.setClienteId(v.getCliente() != null ? v.getCliente().getId() : null);
        dto.setFecha(v.getFecha());
        dto.setTotal(v.getTotal());
        dto.setCreatedAt(v.getCreatedAt());
        dto.setUpdatedAt(v.getUpdatedAt());
        dto.setDetalles(v.getDetalles().stream().map(dv -> {
            DetalleVentaResponseDto rd = new DetalleVentaResponseDto();
            rd.setId(dv.getId());
            rd.setProductoId(dv.getProducto().getId());
            rd.setCantidad(dv.getCantidad());
            rd.setPrecioUnitario(dv.getPrecioUnitario());
            rd.setCreatedAt(dv.getCreatedAt());
            return rd;
        }).collect(Collectors.toList()));
        return dto;
    }

    @Operation(summary = "Listar ventas", description = "Obtiene todas las ventas registradas ordenadas por ID ascendente")
    @GetMapping
    public ResponseEntity<ApiResponse<List<VentaResponseDto>>> getAll() {
        List<VentaResponseDto> list = svc.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse<>(true, "Lista de ventas", list));
    }

    @Operation(summary = "Obtener venta", description = "Devuelve una venta por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<VentaResponseDto>> getById(@PathVariable Integer id) {
        VentaResponseDto dto = toDto(svc.findById(id));
        return ResponseEntity.ok(new ApiResponse<>(true, "Venta encontrada", dto));
    }

    @Operation(summary = "Registrar venta", description = "Crea una venta con sus detalles y actualiza el inventario")
    @PostMapping
    public ResponseEntity<ApiResponse<VentaResponseDto>> create(
            @Valid @RequestBody VentaRequestDto req) {
        Venta v = svc.create(req);
        return ResponseEntity.status(201)
                .body(new ApiResponse<>(true, "Venta registrada", toDto(v)));
    }
}
