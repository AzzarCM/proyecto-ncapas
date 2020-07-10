package com.uca.capas.proyecto.repositories;

import com.uca.capas.proyecto.domain.CatalogoCE;
import com.uca.capas.proyecto.domain.Municipio;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatalogoCERepo extends JpaRepository<CatalogoCE, Integer> {

    @Query(nativeQuery=true, value="SELECT * FROM public.catalogo_ce")
    public List<CatalogoCE> allCentrosEscolares() throws DataAccessException;

    @Query(nativeQuery=true, value="SELECT * FROM public.catalogo_ce WHERE id_municipio = :idmun")
    public List<CatalogoCE> filtrarCE(Integer idmun) throws DataAccessException;

    @Query(value = "SELECT e.id_catce, e.nombre, e.estado, m.id_municipio, m.nombre FROM Catalogo_CE e, municipio m WHERE e.id_municipio = ?1 AND m.id_municipio = ?1",
            nativeQuery = true)
    List<CatalogoCE> findMunicipioBy(Integer id) throws DataAccessException;

    @Query(nativeQuery=true, value="SELECT c.id_catce, c.nombre, c.estado, c.id_municipio FROM PUBLIC.municipio m, PUBLIC.catalogo_ce c WHERE m.id_municipio = c.id_municipio AND m.nombre = :nombre")
    public List<CatalogoCE> filtrarCEporNombre(String nombre) throws DataAccessException;

}