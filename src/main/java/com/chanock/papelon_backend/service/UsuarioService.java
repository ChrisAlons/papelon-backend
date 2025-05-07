// src/main/java/com/chanock/papelon_backend/service/UsuarioService.java
package com.chanock.papelon_backend.service;

import com.chanock.papelon_backend.dto.UsuarioRequestDto;
import com.chanock.papelon_backend.exception.ResourceNotFoundException;
import com.chanock.papelon_backend.model.Usuario;
import com.chanock.papelon_backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repo;
    private final PasswordEncoder passwordEncoder;

    public List<Usuario> findAll() {
        return repo.findAll();
    }

    public Usuario findById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", (id)));
    }

    public Usuario create(UsuarioRequestDto dto) {
        Usuario u = new Usuario();
        u.setUsername(dto.getUsername());
        u.setPassword(passwordEncoder.encode(dto.getPassword()));
        u.setRol(dto.getRol());
        return repo.save(u);
    }

    public Usuario update(Integer id, UsuarioRequestDto dto) {
        Usuario u = findById(id);
        u.setUsername(dto.getUsername());
        u.setRol(dto.getRol());
        if (dto.getPassword()!=null && !dto.getPassword().isBlank()) {
            u.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        return repo.save(u);
    }

    public void delete(Integer id) {
        Usuario u = findById(id);
        repo.delete(u);
    }
}
