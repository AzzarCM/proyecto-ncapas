package com.uca.capas.proyecto.service;

import com.uca.capas.proyecto.domain.Expediente;
import com.uca.capas.proyecto.repositories.ExpedienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpedienteServiceImpl implements ExpedienteService {

    @Autowired
    ExpedienteRepo expedienteRepo;

    @Override
    public void save(Expediente expediente) throws DataAccessException {
        expedienteRepo.save(expediente);
    }

    @Override
    public List<Expediente> findAll() throws DataAccessException {
        return expedienteRepo.findAll();
    }

    @Override
    public List<Expediente> buscarPorNombre(String cadena) throws DataAccessException {
        return expedienteRepo.buscarPorNombre(cadena);
    }

    @Override
    public List<Expediente> buscarPorApellido(String cadena) throws DataAccessException {
        return expedienteRepo.buscarPorApellido(cadena);
    }

    @Override
    public String buscarNombrePorId(Integer id) throws DataAccessException {
        return expedienteRepo.NombrePorId(id);
    }
}
