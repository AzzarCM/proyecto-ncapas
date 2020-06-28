package com.uca.capas.proyecto.service;

import com.uca.capas.proyecto.domain.Expediente;
import com.uca.capas.proyecto.repositories.ExpedienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ExpedienteServiceImpl implements ExpedienteService {

    @Autowired
    ExpedienteRepo expedienteRepo;

    @Override
    public void save(Expediente expediente) throws DataAccessException {
        expedienteRepo.save(expediente);
    }
}
