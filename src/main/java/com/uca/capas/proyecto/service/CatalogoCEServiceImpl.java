package com.uca.capas.proyecto.service;

import com.uca.capas.proyecto.domain.CatalogoCE;
import com.uca.capas.proyecto.repositories.CatalogoCERepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoCEServiceImpl implements CatalogoCEService {

    @Autowired
    CatalogoCERepo catalogoCE;

    @Override
    public List<CatalogoCE> allCentrosEscolares() throws DataAccessException {
        return catalogoCE.allCentrosEscolares();
    }

    @Override
    public List<CatalogoCE> filtrarCE(Integer codigo) throws DataAccessException {
        return catalogoCE.filtrarCE(codigo);
    }
}
