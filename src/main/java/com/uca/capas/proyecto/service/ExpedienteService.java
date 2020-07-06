package com.uca.capas.proyecto.service;

import com.uca.capas.proyecto.domain.Expediente;
import com.uca.capas.proyecto.domain.Materia;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ExpedienteService {

    public void save(Expediente expediente) throws DataAccessException;
    public List<Expediente> findAll() throws DataAccessException;
    public List<Expediente> buscarPorNombre(String cadena) throws DataAccessException;
    public List<Expediente> buscarPorApellido(String cadena) throws DataAccessException;
    public String buscarNombrePorId(Integer id) throws DataAccessException;
    public Expediente findOne(Integer id) throws DataAccessException;
}
