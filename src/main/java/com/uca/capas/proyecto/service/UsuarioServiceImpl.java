package com.uca.capas.proyecto.service;

import com.uca.capas.proyecto.domain.Usuario;
import com.uca.capas.proyecto.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
