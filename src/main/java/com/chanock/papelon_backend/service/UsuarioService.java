package com.chanock.papelon_backend.service;

import com.chanock.papelon_backend.model.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> getAll();
    Usuario getById(Long id);
    Usuario create(Usuario u);
    Usuario update(Long id, Usuario u);
    void delete(Long id);
}
