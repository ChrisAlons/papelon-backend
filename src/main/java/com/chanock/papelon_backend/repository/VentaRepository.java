// src/main/java/com/chanock/papelon_backend/repository/VentaRepository.java
package com.chanock.papelon_backend.repository;

import com.chanock.papelon_backend.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
}
