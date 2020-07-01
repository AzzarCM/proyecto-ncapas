package com.uca.capas.proyecto.dao;

import com.uca.capas.proyecto.domain.Usuario;
import org.springframework.dao.DataAccessException;

public interface UsuarioDAO {
    public void insert(Usuario usuario) throws DataAccessException;
}
