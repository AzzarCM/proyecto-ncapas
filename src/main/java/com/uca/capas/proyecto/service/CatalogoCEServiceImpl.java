package com.uca.capas.proyecto.service;

import com.uca.capas.proyecto.domain.CatalogoCE;
import com.uca.capas.proyecto.repositories.CatalogoCERepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoCEServiceImpl implements CatalogoCEService {

    @Autowired
    CatalogoCERepo catalogoCE;

    @Override
    public List<CatalogoCE> allCentrosEscolares() throws DataAccessException {
        return catalogoCE.findAll(Sort.by(Sort.Direction.ASC, "idCentroEscolar"));
    }

    @Override
    public List<CatalogoCE> filtrarCE(Integer codigo) throws DataAccessException {
        return catalogoCE.filtrarCE(codigo);
    }

    @Override
    public CatalogoCE findOne(Integer id) throws DataAccessException {
        return catalogoCE.getOne(id);
    }

    @Override
    public void save(CatalogoCE escuela) throws DataAccessException {
        catalogoCE.save(escuela);
    }
}
