package com.uca.capas.proyecto.service;

import com.uca.capas.proyecto.domain.CatalogoCE;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CatalogoCEService {

    public List<CatalogoCE> allCentrosEscolares() throws DataAccessException;
    public List<CatalogoCE> filtrarCE(Integer codigo) throws DataAccessException;
    CatalogoCE findOne(Integer id) throws  DataAccessException;
    void save(CatalogoCE escuela) throws DataAccessException;
    public List<CatalogoCE> filtrarCEporNombre(String nombre) throws DataAccessException;
    List<CatalogoCE> findById(Integer id) throws DataAccessException;

}
