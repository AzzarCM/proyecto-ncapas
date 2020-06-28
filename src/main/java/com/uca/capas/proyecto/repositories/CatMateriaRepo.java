package com.uca.capas.proyecto.repositories;

import java.util.List;


import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.capas.proyecto.domain.Catalogo_materias;

public interface CatMateriaRepo extends JpaRepository<Catalogo_materias, Integer> {

		
	@Query(nativeQuery=true, value="SELECT * FROM public.catalogo_materias")
	public List<Catalogo_materias> mostrarAllCat() throws DataAccessException;
	

}






