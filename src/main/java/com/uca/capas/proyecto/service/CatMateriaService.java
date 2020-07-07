package com.uca.capas.proyecto.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.proyecto.domain.Catalogo_materias;

public interface CatMateriaService {
	public List<Catalogo_materias> findAllCatMat() throws DataAccessException;
	public Catalogo_materias findOne(Integer code) throws DataAccessException;
	public void save(Catalogo_materias Catmateria) throws DataAccessException;
	public List<Catalogo_materias> mostrarAllCatActive() throws DataAccessException;

}
