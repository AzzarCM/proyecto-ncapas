package com.uca.capas.proyecto.dao;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.proyecto.domain.Materia;

public interface MateriaDAO {


		public List<Materia> findAll() throws DataAccessException;

		public Materia findOne(Integer code) throws DataAccessException;

		public void save(Materia materia) throws DataAccessException;

		void delete(Integer codigoMateria) throws DataAccessException;
		

	
}
