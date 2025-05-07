// src/main/java/com/chanock/papelon_backend/controller/InventarioController.java
package com.chanock.papelon_backend.controller;

import com.chanock.papelon_backend.dto.ApiResponse;
import com.chanock.papelon_backend.dto.InventarioResponseDto;
import com.chanock.papelon_backend.model.Inventario;
import com.chanock.papelon_backend.service.InventarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Inventario", description = "Consultas de stock actual de productos")
@RestController
@RequestMapping("/api/inventario")
@RequiredArgsConstructor
public class InventarioController {

    private final InventarioService svc;

    private InventarioResponseDto toDto(Inventario i) {
        InventarioResponseDto dto = new InventarioResponseDto();
        dto.setProductoId(i.getProductoId());
        dto.setStockActual(i.getStockActual());
        dto.setUpdatedAt(i.getUpdatedAt());
        return dto;
    }

    @Operation(summary = "Listar inventario", description = "Obtiene el stock de todos los productos")
    @GetMapping
    public ResponseEntity<ApiResponse<List<InventarioResponseDto>>> getAll() {
        List<InventarioResponseDto> list = svc.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse<>(true, "Lista de inventario", list));
    }

    @Operation(summary = "Stock por producto", description = "Consulta el stock actual de un producto")
    @GetMapping("/{productoId}")
    public ResponseEntity<ApiResponse<InventarioResponseDto>> getByProductoId(
            @PathVariable Integer productoId) {
        InventarioResponseDto dto = toDto(svc.findByProductoId(productoId));
        return ResponseEntity.ok(new ApiResponse<>(true, "Stock del producto", dto));
    }
}
