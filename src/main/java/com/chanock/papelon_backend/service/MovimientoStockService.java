// src/main/java/com/chanock/papelon_backend/service/MovimientoStockService.java
package com.chanock.papelon_backend.service;

import com.chanock.papelon_backend.model.MovimientoStock;
import com.chanock.papelon_backend.repository.MovimientoStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimientoStockService {

    private final MovimientoStockRepository repo;

    /** Devuelve todos los movimientos ordenados por fecha descendente */
    public List<MovimientoStock> findAll() {
        return repo.findAllByOrderByFechaDesc();
    }

    /** Movimientos de un producto ordenados por fecha descendente */
    public List<MovimientoStock> findByProductoId(Integer productoId) {
        return repo.findByProductoIdOrderByFechaDesc(productoId);
    }
}
