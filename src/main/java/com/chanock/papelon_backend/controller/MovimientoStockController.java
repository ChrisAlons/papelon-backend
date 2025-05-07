// src/main/java/com/chanock/papelon_backend/controller/MovimientoStockController.java
package com.chanock.papelon_backend.controller;

import com.chanock.papelon_backend.dto.ApiResponse;
import com.chanock.papelon_backend.dto.MovimientoStockResponseDto;
import com.chanock.papelon_backend.model.MovimientoStock;
import com.chanock.papelon_backend.service.MovimientoStockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Movimientos", description = "Historial de ingresos y egresos de stock")
@RestController
@RequestMapping("/api/movimientos")
@RequiredArgsConstructor
public class MovimientoStockController {

    private final MovimientoStockService svc;

    private MovimientoStockResponseDto toDto(MovimientoStock m) {
        MovimientoStockResponseDto dto = new MovimientoStockResponseDto();
        dto.setId(m.getId());
        dto.setProductoId(m.getProductoId());
        dto.setFecha(m.getFecha());
        dto.setCantidad("EGRESO".equals(m.getTipo()) ? -m.getCantidad() : m.getCantidad());
        dto.setTipo(m.getTipo());
        dto.setReferenciaId(m.getReferenciaId());
        dto.setReferenciaTipo(m.getReferenciaTipo());
        return dto;
    }

    @Operation(summary = "Listar movimientos", description = "Obtiene todos los movimientos de stock")
    @GetMapping
    public ResponseEntity<ApiResponse<List<MovimientoStockResponseDto>>> getAll() {
        List<MovimientoStockResponseDto> list = svc.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse<>(true, "Historial completo", list));
    }

    @Operation(summary = "Movimientos por producto", description = "Filtra movimientos por ID de producto")
    @GetMapping("/{productoId}")
    public ResponseEntity<ApiResponse<List<MovimientoStockResponseDto>>> getByProductoId(
            @PathVariable Integer productoId) {
        List<MovimientoStockResponseDto> list = svc.findByProductoId(productoId).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse<>(true, "Movimientos del producto", list));
    }
}
