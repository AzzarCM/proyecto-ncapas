package com.uca.capas.proyecto.repositories;

import com.uca.capas.proyecto.domain.Expediente;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpedienteRepo extends JpaRepository<Expediente, Integer> {
    @Query(nativeQuery=true, value="SELECT * FROM PUBLIC.expediente WHERE nombres= :cadena")
    public List<Expediente> buscarPorNombre(String cadena) throws DataAccessException;

    @Query(nativeQuery=true, value="SELECT * FROM PUBLIC.expediente WHERE apellidos= :cadena")
    public List<Expediente> buscarPorApellido(String cadena) throws DataAccessException;
}
