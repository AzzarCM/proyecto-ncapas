package com.uca.capas.proyecto.service;

import com.uca.capas.proyecto.domain.Municipio;
import com.uca.capas.proyecto.repositories.MunicipioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MunicipioServiceImpl implements MunicipioService{

    @Autowired
    MunicipioRepo municipioRepo;

    @Override
    public List<Municipio> findById(int id) throws DataAccessException {
        return municipioRepo.findMunicipioBy(id);
    }
}