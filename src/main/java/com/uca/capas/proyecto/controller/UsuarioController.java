package com.uca.capas.proyecto.controller;

import com.uca.capas.proyecto.domain.Departamento;
import com.uca.capas.proyecto.domain.Rol;
import com.uca.capas.proyecto.domain.Usuario;
import com.uca.capas.proyecto.service.DepartamentoService;
import com.uca.capas.proyecto.service.RolService;
import com.uca.capas.proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    DepartamentoService departamentoService;

    @Autowired
    RolService rolService;

    @RequestMapping("/registroUsuario")
    public ModelAndView registroUsuario(){
        ModelAndView mav = new ModelAndView();
        Usuario usuario = new Usuario();
        List<Departamento> departamentos;
        List<Rol> roles;
        mav.addObject("usuario", usuario);
        try {
            departamentos = departamentoService.findAll();
            roles = rolService.findAll();
            mav.addObject("departamento", departamentos);
            mav.addObject("rol", roles);
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("titulo", "Registro de usuario");
        mav.addObject("ruta", "insertarUsuario");
        mav.addObject("url", "login");
        mav.addObject("btn", "Iniciar sesion");
        mav.setViewName("nuevoUsuario");
        return mav;
    }

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mav;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.isAuthenticated() && !authentication.getName().equals("anonymousUser")){
            mav = new ModelAndView("redirect:/index");
        }else{
            mav = new ModelAndView();
            mav.setViewName("iniciarSesion");
        }
        return mav;
    }

    @RequestMapping("/insertarUsuario")
    public ModelAndView insertUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult result){
        ModelAndView mav = new ModelAndView();
        List<Usuario> usuarios;
        List<Departamento> departamentos;
        List<Rol> roles;
        if(result.hasErrors()){
            departamentos = departamentoService.findAll();
            roles = rolService.findAll();
            mav.addObject("titulo", "Registro de usuario");
            mav.addObject("ruta", "insertarUsuario");
            mav.addObject("url", "login");
            mav.addObject("btn", "Iniciar sesion");
            mav.addObject("departamento", departamentos);
            mav.addObject("rol", roles);
            mav.setViewName("nuevoUsuario");
        }
        if(usuario.getMunicipio().getDepartamento().getIdDepartamento() == 0){
            departamentos = departamentoService.findAll();
            roles = rolService.findAll();
            mav.addObject("titulo", "Registro de usuario");
            mav.addObject("ruta", "insertarUsuario");
            mav.addObject("departamento", departamentos);
            mav.addObject("rol", roles);
            mav.addObject("errorDepartamento", "Seleccione un departamento");
            mav.addObject("errorMunicipio", "Seleccione un municipio");
            mav.addObject("url", "login");
            mav.addObject("btn", "Iniciar sesion");
            mav.setViewName("nuevoUsuario");
            return mav;
        }else if(usuario.getMunicipio().getIdMunicipio() == 0){
            departamentos = departamentoService.findAll();
            roles = rolService.findAll();
            mav.addObject("titulo", "Registro de usuario");
            mav.addObject("ruta", "insertarUsuario");
            mav.addObject("departamento", departamentos);
            mav.addObject("rol", roles);
            mav.addObject("errorMunicipio", "Seleccione un municipio");
            mav.addObject("url", "login");
            mav.addObject("btn", "Iniciar sesion");
            mav.setViewName("nuevoUsuario");
        }

        else{
            try{
                usuarios = usuarioService.findAll();
                departamentos = departamentoService.findAll();
                roles = rolService.findAll();
                for(Usuario u : usuarios){
                    if(u.getNombre_usuario().equals(usuario.getNombre_usuario())){
                        mav.addObject("titulo", "Registro de usuario");
                        mav.addObject("ruta", "insertarUsuario");
                        mav.addObject("departamento", departamentos);
                        mav.addObject("rol", roles);
                        mav.addObject("url", "usuarios");
                        mav.addObject("btn", "Regresar");
                        mav.addObject("error", true);
                        mav.setViewName("nuevoUsuario");
                        return mav;
                    }
                }
                usuario.setEstado(false);
                usuario.setEdad(CalcularEdad(usuario.getFechaNacimiento()));
                usuarioService.save(usuario);
                mav.setViewName("iniciarSesion");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return mav;
    }

    @RequestMapping("/index")
    public ModelAndView inicio(){
        System.out.println("ESTOY EN INDEX");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        String rol = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            rol = authority.getAuthority();
        }
        if(authentication.isAuthenticated() && !authentication.getName().equals("anonymousUser")){
            mav.addObject("rol", rol);
        }

        return mav;
    }

    @RequestMapping("/usuarios")
    public ModelAndView usuarios() {
        ModelAndView mav = new ModelAndView();
        List<Usuario> usuarios = null;

        try {
            usuarios = usuarioService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("usuarios", usuarios);
        mav.setViewName("CatalogoUsuarios");
        return mav;
    }

    @RequestMapping("/usuario")
    public ModelAndView updateMateria(@RequestParam("id") Integer id) {
        ModelAndView mav = new ModelAndView();
        Usuario usuario = new Usuario();
        List<Rol> roles;
        List<Departamento> departamentos;
        try {
            roles = rolService.findAll();
            usuario = usuarioService.findOne(id);
            departamentos = departamentoService.findAll();
            mav.addObject("departamento", departamentos);
            mav.addObject("rol", roles);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("usuario", usuario);
        mav.setViewName("updateUsuario");
        return mav;
    }

    @RequestMapping("/logout")
    public ModelAndView cerrarSesion(){
        return new ModelAndView("redirect:/login?logout");
    }

    @RequestMapping("/saveUsuario")
    public ModelAndView actualizar(@Valid @ModelAttribute Usuario usuario, BindingResult result){
        ModelAndView mav = new ModelAndView();
        List<Usuario> usuarios;
        List<Departamento> departamentos;
        List<Rol> roles;
        if(result.hasErrors()){
            departamentos = departamentoService.findAll();
            roles = rolService.findAll();
            mav.addObject("edit", true);
            mav.addObject("departamento", departamentos);
            mav.addObject("rol", roles);
            mav.setViewName("nuevoUsuario");
        }
        if(usuario.getMunicipio().getDepartamento().getIdDepartamento() == 0){
            departamentos = departamentoService.findAll();
            roles = rolService.findAll();
            mav.addObject("titulo", "Registro de usuario");
            mav.addObject("ruta", "insertarUsuario");
            mav.addObject("departamento", departamentos);
            mav.addObject("rol", roles);
            mav.addObject("edit", true);
            mav.addObject("errorDepartamento", "Seleccione un departamento");
            mav.addObject("errorMunicipio", "Seleccione un municipio");
            mav.addObject("url", "usuarios");
            mav.addObject("btn", "Regresar");
            mav.setViewName("nuevoUsuario");
            return mav;
        }else if(usuario.getMunicipio().getIdMunicipio() == 0){
            departamentos = departamentoService.findAll();
            roles = rolService.findAll();
            mav.addObject("edit", true);
            mav.addObject("titulo", "Registro de usuario");
            mav.addObject("ruta", "insertarUsuario");
            mav.addObject("departamento", departamentos);
            mav.addObject("rol", roles);
            mav.addObject("errorMunicipio", "Seleccione un municipio");
            mav.addObject("url", "usuarios");
            mav.addObject("btn", "Regresar");
            mav.setViewName("nuevoUsuario");
        }
        else{
            try{
                usuarios = usuarioService.findAll();
                departamentos = departamentoService.findAll();
                roles = rolService.findAll();
                for(Usuario u : usuarios){
                    if(u.getNombre_usuario().equals(usuario.getNombre_usuario()) && usuario.getIdUsuario() == null){
                        mav.addObject("titulo", "Registro de usuario");
                        mav.addObject("ruta", "insertarUsuario");
                        mav.addObject("departamento", departamentos);
                        mav.addObject("rol", roles);
                        mav.addObject("error", true);
                        mav.addObject("url", "usuarios");
                        mav.addObject("btn", "Regresar");
                        mav.setViewName("nuevoUsuario");
                        return mav;
                    }
                }
                usuario.setEdad(CalcularEdad(usuario.getFechaNacimiento()));
                usuarioService.save(usuario);
                mav.setViewName("redirect:/usuarios");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return mav;
    }

    @RequestMapping("/crearUsuario")
    public ModelAndView crear(){
        ModelAndView mav = new ModelAndView();
        Usuario usuario = new Usuario();
        List<Departamento> departamentos;
        List<Rol> roles;
        mav.addObject("usuario", usuario);
        try {
            departamentos = departamentoService.findAll();
            roles = rolService.findAll();
            mav.addObject("departamento", departamentos);
            mav.addObject("rol", roles);
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("titulo", "Crear usuario");
        mav.addObject("ruta", "saveUsuario");
        mav.addObject("edit", true);
        mav.addObject("url", "usuarios");
        mav.addObject("btn", "Regresar");
        mav.setViewName("nuevoUsuario");
        return mav;
    }


    public Integer CalcularEdad(Date fechaNacimiento){
        Date d2 = new Date();
        Integer edad = 0;
        try {
            long diff = d2.getTime() - fechaNacimiento.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            edad = Math.toIntExact(diffDays / 365);
            System.out.print(edad + " anios");
            return edad;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return edad;
    }
}


