// src/main/java/com/chanock/papelon_backend/repository/ClienteRepository.java
package com.chanock.papelon_backend.repository;

import com.chanock.papelon_backend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
