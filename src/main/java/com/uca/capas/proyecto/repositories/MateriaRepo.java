package com.uca.capas.proyecto.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.uca.capas.proyecto.domain.Materia;

public interface MateriaRepo extends JpaRepository<Materia, Integer> {

	public List<Materia> findByNombre(String cadena) throws DataAccessException;
	
	public List<Materia> findByApellidoStartingWith(String cadena) throws DataAccessException;
	
	@Query(nativeQuery=true, value="SELECT * FROM public.materia")
	public List<Materia> mostrarAllMat() throws DataAccessException;
	
	@Transactional
	@Modifying
	@Query("UPDATE materia SET id_catmateria = ?1, anio = ?2, ciclo = ?3, nota =?4, id_estudiante= ?5, resultado =?6 WHERE id_materia = ?7")
	public void ActualizarMat(String nombre, String apellido, Integer edad, Boolean estado, Integer codigo) throws DataAccessException;
}






