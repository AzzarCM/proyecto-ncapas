package com.uca.capas.proyecto.service;

import com.uca.capas.proyecto.domain.Usuario;
import com.uca.capas.proyecto.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepo usuarioRepo;

    @Override
    @Transactional
    public void save(Usuario usuario) throws DataAccessException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        usuario.setContrasenia(encoder.encode(usuario.getContrasenia()));
        usuarioRepo.save(usuario);
    }

    @Override
    public Usuario findByUsername(String s) throws DataAccessException {
        return usuarioRepo.findByNombre_usuario(s);
    }

    @Override
    public Usuario findOne(Integer id) throws DataAccessException {
        return usuarioRepo.getOne(id);
    }

    @Override
    public List<Usuario> findAll() throws DataAccessException {
        return usuarioRepo.findAll(Sort.by(Sort.Direction.ASC, "idUsuario"));
    }
}
