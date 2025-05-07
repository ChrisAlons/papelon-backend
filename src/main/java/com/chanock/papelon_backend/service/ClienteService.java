// src/main/java/com/chanock/papelon_backend/service/ClienteService.java
package com.chanock.papelon_backend.service;

import com.chanock.papelon_backend.dto.ClienteRequestDto;
import com.chanock.papelon_backend.exception.ResourceNotFoundException;
import com.chanock.papelon_backend.model.Cliente;
import com.chanock.papelon_backend.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repo;

    /** Devuelve todos los clientes ordenados por ID ascendente */
    public List<Cliente> findAll() {
        return repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    /** Busca un cliente por su ID o lanza excepción si no existe */
    public Cliente findById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", id));
    }

    /** Crea un nuevo cliente */
    public Cliente create(ClienteRequestDto dto) {
        Cliente c = new Cliente();
        c.setNombre(dto.getNombre());
        c.setEmail(dto.getEmail());
        c.setTelefono(dto.getTelefono());
        c.setDireccion(dto.getDireccion());
        return repo.save(c);
    }

    /** Actualiza un cliente existente */
    public Cliente update(Integer id, ClienteRequestDto dto) {
        Cliente c = findById(id);
        c.setNombre(dto.getNombre());
        c.setEmail(dto.getEmail());
        c.setTelefono(dto.getTelefono());
        c.setDireccion(dto.getDireccion());
        return repo.save(c);
    }

    /** Elimina un cliente por su ID */
    public void delete(Integer id) {
        Cliente c = findById(id);
        repo.delete(c);
    }
}
