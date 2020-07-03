package com.uca.capas.proyecto.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.proyecto.domain.Materia;

public interface MateriaService {
	
	public List<Materia> findAllMaterias() throws DataAccessException;

	public Materia findOne(Integer code) throws DataAccessException;

	public void save(Materia materia) throws DataAccessException;

	void delete(Integer codigoMateria) throws DataAccessException;

	List<Materia> findAllMateriasEst(Integer code) throws DataAccessException;

	public Float promedioNotas(Integer code) throws DataAccessException;

	public Integer materiaAprovada(Integer code) throws DataAccessException;

	public Integer materiaReprovada(Integer code) throws DataAccessException;
}
