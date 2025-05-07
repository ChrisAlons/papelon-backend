// src/main/java/com/chanock/papelon_backend/controller/ProductoController.java
package com.chanock.papelon_backend.controller;

import com.chanock.papelon_backend.dto.ApiResponse;
import com.chanock.papelon_backend.dto.ProductoRequestDto;
import com.chanock.papelon_backend.dto.ProductoResponseDto;
import com.chanock.papelon_backend.model.Producto;
import com.chanock.papelon_backend.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Productos", description = "CRUD y listado de productos")
@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService svc;

    private ProductoResponseDto toDto(Producto p) {
        ProductoResponseDto dto = new ProductoResponseDto();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setDescripcion(p.getDescripcion());
        dto.setPrecioCompra(p.getPrecioCompra());
        dto.setPrecioVenta(p.getPrecioVenta());
        dto.setCreatedAt(p.getCreatedAt());
        dto.setUpdatedAt(p.getUpdatedAt());
        return dto;
    }

    @Operation(summary = "Listar productos", description = "Obtiene todos los productos")
    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductoResponseDto>>> getAll() {
        List<ProductoResponseDto> list = svc.findAll().stream()
                .map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse<>(true, "Lista de productos", list));
    }

    @Operation(summary = "Obtener producto", description = "Busca un producto por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductoResponseDto>> getById(@PathVariable Integer id) {
        ProductoResponseDto dto = toDto(svc.findById(id));
        return ResponseEntity.ok(new ApiResponse<>(true, "Producto encontrado", dto));
    }

    @Operation(summary = "Crear producto", description = "Registra un nuevo producto")
    @PostMapping
    public ResponseEntity<ApiResponse<ProductoResponseDto>> create(
            @Valid @RequestBody ProductoRequestDto req) {
        Producto p = svc.create(req);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Producto creado", toDto(p)));
    }

    @Operation(summary = "Actualizar producto", description = "Modifica un producto existente")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductoResponseDto>> update(
            @PathVariable Integer id,
            @Valid @RequestBody ProductoRequestDto req) {
        Producto p = svc.update(id, req);
        return ResponseEntity.ok(new ApiResponse<>(true, "Producto actualizado", toDto(p)));
    }

    @Operation(summary = "Eliminar producto", description = "Borra un producto por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        svc.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Producto eliminado", null));
    }
}
