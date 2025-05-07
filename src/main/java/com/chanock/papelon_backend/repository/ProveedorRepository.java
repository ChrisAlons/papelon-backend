// src/main/java/com/chanock/papelon_backend/repository/ProveedorRepository.java
package com.chanock.papelon_backend.repository;

import com.chanock.papelon_backend.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
}
