// src/main/java/com/chanock/papelon_backend/repository/ProductoRepository.java
package com.chanock.papelon_backend.repository;

import com.chanock.papelon_backend.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
