package com.uca.capas.proyecto.service;

import com.uca.capas.proyecto.domain.Usuario;
import org.springframework.dao.DataAccessException;

public interface UsuarioService {
    void save(Usuario usuario) throws DataAccessException;
    Usuario findByUsername(String s) throws DataAccessException;
}