package com.uca.capas.proyecto.repositories;

import com.uca.capas.proyecto.domain.Municipio;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MunicipioRepo extends JpaRepository<Municipio, Integer> {
    @Query(value = "SELECT m.id_municipio, m.nombre, d.id_departamento, d.nombre FROM public.municipio m, public.departamento d WHERE m.id_departamento = ?1 and d.id_departamento = ?1",
            nativeQuery = true)
    List<Municipio> findMunicipioBy(Integer id) throws DataAccessException;
}
