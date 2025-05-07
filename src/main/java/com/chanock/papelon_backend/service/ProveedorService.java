// src/main/java/com/chanock/papelon_backend/service/ProveedorService.java
package com.chanock.papelon_backend.service;

import com.chanock.papelon_backend.dto.ProveedorRequestDto;
import com.chanock.papelon_backend.exception.ResourceNotFoundException;
import com.chanock.papelon_backend.model.Proveedor;
import com.chanock.papelon_backend.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorService {

    private final ProveedorRepository repo;

    /** Devuelve todos los proveedores ordenados por ID asc */
    public List<Proveedor> findAll() {
        return repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Proveedor findById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor", id));
    }

    public Proveedor create(ProveedorRequestDto dto) {
        Proveedor p = new Proveedor();
        p.setNombre(dto.getNombre());
        p.setTelefono(dto.getTelefono());
        p.setDireccion(dto.getDireccion());
        return repo.save(p);
    }

    public Proveedor update(Integer id, ProveedorRequestDto dto) {
        Proveedor p = findById(id);
        p.setNombre(dto.getNombre());
        p.setTelefono(dto.getTelefono());
        p.setDireccion(dto.getDireccion());
        return repo.save(p);
    }

    public void delete(Integer id) {
        Proveedor p = findById(id);
        repo.delete(p);
    }
}
