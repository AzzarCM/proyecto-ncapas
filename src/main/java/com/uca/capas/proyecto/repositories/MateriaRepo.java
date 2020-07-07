package com.uca.capas.proyecto.repositories;

import java.util.List;


import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.capas.proyecto.domain.Materia;

public interface MateriaRepo extends JpaRepository<Materia, Integer> {

		
	@Query(nativeQuery=true, value="SELECT * FROM public.materia")
	public List<Materia> mostrarAllMat() throws DataAccessException;
	
	@Query(nativeQuery=true, value="SELECT * FROM public.materia WHERE id_estudiante = ?1")
	public List<Materia> mostrarMatEst(Integer codigo) throws DataAccessException;

	@Query(nativeQuery=true, value ="SELECT COUNT(resultado) FROM PUBLIC.materia WHERE resultado = 'APROBADO' and id_estudiante = :codigo")
	public Integer materiaAprovada(Integer codigo) throws DataAccessException;

	@Query(nativeQuery=true, value ="SELECT COUNT(resultado) FROM PUBLIC.materia WHERE resultado = 'REPROBADO' and id_estudiante = :codigo")
	public Integer materiaReprovada(Integer codigo) throws DataAccessException;

	@Query(nativeQuery=true, value ="SELECT ROUND(CAST(AVG(nota) as numeric),2) FROM PUBLIC.materia WHERE id_estudiante =:codigo")
	public Float promedioNotas(Integer codigo) throws DataAccessException;
}






