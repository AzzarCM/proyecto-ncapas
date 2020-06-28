package com.uca.capas.proyecto.service;

import com.uca.capas.proyecto.domain.Materia;
import com.uca.capas.proyecto.domain.Usuario;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioService extends JpaRepository<Usuario, Integer> {


    @Query(nativeQuery=true, value="SELECT * FROM public.usuario")
    public List<Materia> findAllActiveUsers() throws DataAccessException;


}