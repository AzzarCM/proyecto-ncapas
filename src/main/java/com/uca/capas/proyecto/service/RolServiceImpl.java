package com.uca.capas.proyecto.service;

import com.uca.capas.proyecto.domain.Rol;
import com.uca.capas.proyecto.repositories.RolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService{
    @Autowired
    RolRepo rolRepo;


    @Override
    public List<Rol> findAll() throws DataAccessException {
        return rolRepo.findAll();
    }
}
