package com.uca.capas.proyecto.service;

import com.uca.capas.proyecto.domain.Expediente;
import com.uca.capas.proyecto.domain.Materia;
import org.springframework.dao.DataAccessException;

public interface ExpedienteService {

    public void save(Expediente expediente) throws DataAccessException;
}
