// src/main/java/com/chanock/papelon_backend/service/UsuarioServiceImpl.java
package com.chanock.papelon_backend.service;

import com.chanock.papelon_backend.exception.ResourceNotFoundException;
import com.chanock.papelon_backend.model.Usuario;
import com.chanock.papelon_backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repo;
    private final PasswordEncoder encoder;

    @Override
    public List<Usuario> getAll() {
        return repo.findAll();
    }

    @Override
    public Usuario getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", id));
    }

    @Override
    public Usuario create(Usuario u) {
        // encripta la contraseña antes de persistir
        u.setPassword(encoder.encode(u.getPassword()));
        return repo.save(u);
    }

    @Override
    public Usuario update(Long id, Usuario u) {
        Usuario existing = getById(id);
        existing.setUsername(u.getUsername());
        // solo re-encriptar si la contraseña cambió
        if (!encoder.matches(u.getPassword(), existing.getPassword())) {
            existing.setPassword(encoder.encode(u.getPassword()));
        }
        existing.setRol(u.getRol());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        Usuario u = getById(id);
        repo.delete(u);
    }
}
