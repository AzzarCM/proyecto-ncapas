package com.uca.capas.proyecto.service;

import com.uca.capas.proyecto.domain.Rol;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface RolService {
    List<Rol> findAll() throws DataAccessException;
}
