package com.uca.capas.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.proyecto.domain.Catalogo_materias;
import com.uca.capas.proyecto.domain.Materia;
import com.uca.capas.proyecto.repositories.CatMateriaRepo;
import com.uca.capas.proyecto.repositories.MateriaRepo;

@Service
public class CatMateriaServiceImpl implements CatMateriaService {

	@Autowired
	CatMateriaRepo catMateriaRepo;

	@Override
	public List<Catalogo_materias> findAllCatMat() throws DataAccessException {
		return catMateriaRepo.findAll();
	}

	@Override
	public Catalogo_materias findOne(Integer code) throws DataAccessException {
		return catMateriaRepo.getOne(code)	;
	}

	@Override
	public void save(Catalogo_materias Catmateria) throws DataAccessException {
		System.out.println("ID: " + Catmateria.getId_catmateria());
		System.out.println("NOMBRE: " + Catmateria.getNombre());
		System.out.println("ESTADO: " + Catmateria.getEstadoDelegate());
		catMateriaRepo.save(Catmateria);
	}
}
