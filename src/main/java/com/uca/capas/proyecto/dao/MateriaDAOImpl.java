package com.uca.capas.proyecto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.proyecto.domain.Materia;

@Repository
public class MateriaDAOImpl implements MateriaDAO {

	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Materia> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.materia");
		Query query =  entityManager.createNativeQuery(sb.toString(), Materia.class);
		List<Materia> resultset = query.getResultList();		
	
		return resultset;		
	}

	@Override
	public Materia findOne(Integer code) throws DataAccessException {

		Materia materia = entityManager.find(Materia.class, code);
		return materia;	
	}

	@Override
	public void save(Materia materia) throws DataAccessException {
		try {

			if(materia.getId_materia() == null) {
				entityManager.persist(materia); 
			}
			else {
				entityManager.merge(materia);
				entityManager.flush();
			}
			
		}catch(Throwable e) {
			e.printStackTrace();
		}
				
	}

	@Override
	public void delete(Integer codigoMateria) throws DataAccessException {
		Materia materia = entityManager.find(Materia.class, codigoMateria);
		entityManager.remove(materia);		
	}

}
