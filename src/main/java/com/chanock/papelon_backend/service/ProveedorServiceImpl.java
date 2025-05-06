// src/main/java/com/chanock/papelon_backend/service/ProveedorServiceImpl.java
package com.chanock.papelon_backend.service;

import com.chanock.papelon_backend.exception.ResourceNotFoundException;
import com.chanock.papelon_backend.model.Proveedor;
import com.chanock.papelon_backend.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository repo;

    @Override
    public List<Proveedor> findAll() {
        return repo.findAll();
    }

    @Override
    public Proveedor findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor", id));
    }

    @Override
    public Proveedor create(Proveedor p) {
        return repo.save(p);
    }

    @Override
    public Proveedor update(Long id, Proveedor p) {
        Proveedor existing = findById(id);
        existing.setNombre(p.getNombre());
        existing.setTelefono(p.getTelefono());
        existing.setDireccion(p.getDireccion());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        Proveedor p = findById(id);
        repo.delete(p);
    }
}
