package com.uca.capas.proyecto.repositories;

import com.uca.capas.proyecto.domain.CatalogoCE;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatalogoCERepo extends JpaRepository<CatalogoCE, Integer> {

    @Query(nativeQuery=true, value="SELECT * FROM public.catalogo_ce")
    public List<CatalogoCE> allCentrosEscolares() throws DataAccessException;

    @Query(nativeQuery=true, value="SELECT * FROM public.catalogo_ce WHERE id_municipio = :idmun")
    public List<CatalogoCE> filtrarCE(Integer idmun) throws DataAccessException;

}
