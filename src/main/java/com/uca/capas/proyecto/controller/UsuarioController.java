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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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

        if(result.hasErrors()){
            mav.setViewName("nuevoUsuario");
        }else{
            try{

                usuario.setEstado(false);
                usuario.setEdad(CalcularEdad(usuario.getFechaNacimiento()));
                usuarioService.save(usuario);
                System.out.println("ENTRE KEKW");
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
        System.out.println("ROL: "+rol);
        if(authentication.isAuthenticated() && !authentication.getName().equals("anonymousUser")){
            mav.addObject("rol", rol);
        }

        return mav;
    }

    public Integer CalcularEdad(Date fechaNacimiento){
        //SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date d2 = new Date();
        //Date d1 = null;
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


