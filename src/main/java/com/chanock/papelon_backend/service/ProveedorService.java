// src/main/java/com/chanock/papelon_backend/service/ProveedorService.java
package com.chanock.papelon_backend.service;

import com.chanock.papelon_backend.model.Proveedor;
import java.util.List;

public interface ProveedorService {
    List<Proveedor> findAll();
    Proveedor findById(Long id);
    Proveedor create(Proveedor p);
    Proveedor update(Long id, Proveedor p);
    void delete(Long id);
}
