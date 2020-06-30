package com.uca.capas.proyecto.dao;

import com.uca.capas.proyecto.domain.Usuario;
import org.springframework.dao.DataAccessException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class UsuarioDAOImpl implements UsuarioDAO{

    @PersistenceContext(unitName = "capas")
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insert(Usuario usuario) throws DataAccessException {
        try{
            if(usuario.getIdUsuario() == null){
                entityManager.persist(usuario);
            }else{
                entityManager.merge(usuario);
                entityManager.flush();
            }
        }catch (Throwable e){
            e.printStackTrace();
        }
    }
}
