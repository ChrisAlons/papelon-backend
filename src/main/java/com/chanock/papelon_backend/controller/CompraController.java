// src/main/java/com/chanock/papelon_backend/controller/CompraController.java
package com.chanock.papelon_backend.controller;

import com.chanock.papelon_backend.dto.ApiResponse;
import com.chanock.papelon_backend.dto.CompraRequestDto;
import com.chanock.papelon_backend.dto.CompraResponseDto;
import com.chanock.papelon_backend.dto.DetalleCompraResponseDto;
import com.chanock.papelon_backend.model.Compra;
import com.chanock.papelon_backend.model.DetalleCompra;
import com.chanock.papelon_backend.service.CompraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Compras", description = "Registrar y listar compras, actualización de stock")
@RestController
@RequestMapping("/api/compras")
@RequiredArgsConstructor
public class CompraController {

    private final CompraService svc;

    private DetalleCompraResponseDto toDto(DetalleCompra dc) {
        DetalleCompraResponseDto dto = new DetalleCompraResponseDto();
        dto.setId(dc.getId());
        dto.setProductoId(dc.getProducto().getId());
        dto.setCantidad(dc.getCantidad());
        dto.setPrecioUnitario(dc.getPrecioUnitario());
        dto.setCreatedAt(dc.getCreatedAt());
        return dto;
    }

    private CompraResponseDto toDto(Compra c) {
        CompraResponseDto dto = new CompraResponseDto();
        dto.setId(c.getId());
        dto.setUsuarioId(c.getUsuario().getId());
        dto.setProveedorId(c.getProveedor().getId());
        dto.setFecha(c.getFecha());
        dto.setTotal(c.getTotal());
        dto.setCreatedAt(c.getCreatedAt());
        dto.setUpdatedAt(c.getUpdatedAt());
        dto.setDetalles(c.getDetalles().stream()
                .map(this::toDto).collect(Collectors.toList()));
        return dto;
    }

    @Operation(summary = "Listar compras", description = "Obtiene todas las compras registradas")
    @GetMapping
    public ResponseEntity<ApiResponse<List<CompraResponseDto>>> getAll() {
        List<CompraResponseDto> list = svc.findAll().stream()
                .map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse<>(true, "Lista de compras", list));
    }

    @Operation(summary = "Registrar compra", description = "Registra una nueva compra con sus detalles")
    @PostMapping
    public ResponseEntity<ApiResponse<CompraResponseDto>> create(
            @Valid @RequestBody CompraRequestDto req) {
        Compra c = svc.create(req);
        return ResponseEntity.status(201)
                .body(new ApiResponse<>(true, "Compra creada", toDto(c)));
    }

    @Operation(summary = "Obtener compra por ID", description = "Busca una compra por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CompraResponseDto>> getById(@PathVariable Integer id) {
        Compra c = svc.findById(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Compra encontrada", toDto(c)));
    }
}
