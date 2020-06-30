package com.uca.capas.proyecto.service;

import com.uca.capas.proyecto.domain.Usuario;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface UsuarioService {
    void save(Usuario usuario) throws DataAccessException;
    Usuario findByUsername(String s) throws DataAccessException;
    List<Usuario> findAll() throws  DataAccessException;
}