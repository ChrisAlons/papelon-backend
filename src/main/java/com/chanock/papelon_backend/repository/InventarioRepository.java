// src/main/java/com/chanock/papelon_backend/repository/InventarioRepository.java
package com.chanock.papelon_backend.repository;

import com.chanock.papelon_backend.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
    Inventario findByProductoId(Integer productoId);
}
