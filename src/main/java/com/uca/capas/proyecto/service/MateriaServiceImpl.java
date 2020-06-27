package com.uca.capas.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.uca.capas.proyecto.domain.Materia;
import com.uca.capas.proyecto.repositories.MateriaRepo;

@Service
public class MateriaServiceImpl implements MateriaService {
	

	@Autowired
	MateriaRepo materiaRepo;

	@Override
	public List<Materia> findAllMaterias() throws DataAccessException {
		// TODO Auto-generated method stub
		return materiaRepo.findAll();
	}

	@Override
	public Materia findOne(Integer code) throws DataAccessException {
		return materiaRepo.getOne(code);
	}

	@Override
	public void save(Materia materia) throws DataAccessException {
		materiaRepo.save(materia);		
	}

	@Override
	public void delete(Integer codigoMateria) throws DataAccessException {
		materiaRepo.deleteById(codigoMateria);		
	}

	



}
