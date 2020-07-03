package com.uca.capas.proyecto.service;

import com.uca.capas.proyecto.domain.Municipio;
import org.springframework.dao.DataAccessException;

import java.util.List;


public interface MunicipioService {
    List<Municipio> findById(int id) throws DataAccessException;
}
