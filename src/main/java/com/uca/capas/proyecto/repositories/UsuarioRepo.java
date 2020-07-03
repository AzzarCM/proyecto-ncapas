package com.uca.capas.proyecto.repositories;

import com.uca.capas.proyecto.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
    @Query(value = "SELECT u.nombre_usuario, u.contrasenia, u.estado, r.nombre " +
            "FROM public.usuario u, public.rol r " +
            "WHERE u.id_rol  = r.id_rol and u.nombre_usuario = ?1",
            nativeQuery = true)
    Usuario findByNombre_usuario(String nombre_usuario);
}
