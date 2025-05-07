// src/main/java/com/chanock/papelon_backend/service/ProductoService.java
package com.chanock.papelon_backend.service;

import com.chanock.papelon_backend.dto.ProductoRequestDto;
import com.chanock.papelon_backend.exception.ResourceNotFoundException;
import com.chanock.papelon_backend.model.Producto;
import com.chanock.papelon_backend.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository repo;

    /** Devuelve todos los productos ordenados por ID asc */
    public List<Producto> findAll() {
        return repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Producto findById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto", id));
    }

    public Producto create(ProductoRequestDto dto) {
        Producto p = Producto.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .precioCompra(dto.getPrecioCompra())
                .precioVenta(dto.getPrecioVenta())
                .build();
        return repo.save(p);
    }

    public Producto update(Integer id, ProductoRequestDto dto) {
        Producto p = findById(id);
        p.setNombre(dto.getNombre());
        p.setDescripcion(dto.getDescripcion());
        p.setPrecioCompra(dto.getPrecioCompra());
        p.setPrecioVenta(dto.getPrecioVenta());
        return repo.save(p);
    }

    public void delete(Integer id) {
        Producto p = findById(id);
        repo.delete(p);
    }
}
