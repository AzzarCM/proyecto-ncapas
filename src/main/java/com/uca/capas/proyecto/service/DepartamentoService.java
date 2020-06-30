package com.uca.capas.proyecto.service;

import com.uca.capas.proyecto.domain.Departamento;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface DepartamentoService {
    List<Departamento> findAll() throws DataAccessException;
}
