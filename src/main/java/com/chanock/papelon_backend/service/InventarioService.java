// src/main/java/com/chanock/papelon_backend/service/InventarioService.java
package com.chanock.papelon_backend.service;

import com.chanock.papelon_backend.exception.ResourceNotFoundException;
import com.chanock.papelon_backend.model.Inventario;
import com.chanock.papelon_backend.repository.InventarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventarioService {

    private final InventarioRepository repo;

    /** Lista todo el inventario */
    public List<Inventario> findAll() {
        return repo.findAll();
    }

    /** Busca el inventario de un producto o lanza excepción */
    public Inventario findByProductoId(Integer productoId) {
        Inventario inv = repo.findByProductoId(productoId);
        if (inv == null) {
            throw new ResourceNotFoundException("Inventario de producto", productoId);
        }
        return inv;
    }
}
