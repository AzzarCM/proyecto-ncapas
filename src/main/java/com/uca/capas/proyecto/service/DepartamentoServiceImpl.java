package com.uca.capas.proyecto.service;


import com.uca.capas.proyecto.domain.Departamento;
import com.uca.capas.proyecto.repositories.DepartamentoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

    @Autowired
    DepartamentoRepo departamentoRepo;

    @Override
    public List<Departamento> findAll() throws DataAccessException {
        return departamentoRepo.findAll();
    }
}
