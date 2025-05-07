// src/main/java/com/chanock/papelon_backend/repository/MovimientoStockRepository.java
package com.chanock.papelon_backend.repository;

import com.chanock.papelon_backend.model.MovimientoStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoStockRepository extends JpaRepository<MovimientoStock, Integer> {
    List<MovimientoStock> findByProductoIdOrderByFechaDesc(Integer productoId);

    List<MovimientoStock> findAllByOrderByFechaDesc();
}
