package com.uca.capas.proyecto.controller;

import com.uca.capas.proyecto.domain.Catalogo_materias;
import com.uca.capas.proyecto.service.CatMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CatMateriaController {

    @Autowired
    private CatMateriaService catMateriaService;


    @RequestMapping("/materias")
    public ModelAndView materias() {
        ModelAndView mav = new ModelAndView();
        List<Catalogo_materias> materias = null;

        try {
            materias = catMateriaService.findAllCatMat();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mav.addObject("materias", materias);
        mav.setViewName("CatalogoMateria");
        return mav;
    }

    @RequestMapping("/materia")
    public ModelAndView updateMateria(@RequestParam("id") Integer id) {
        ModelAndView mav = new ModelAndView();
        Catalogo_materias materia = new Catalogo_materias();
        try {
            materia = catMateriaService.findOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mav.addObject("materia", materia);
        mav.setViewName("updateMateria");
        return mav;
    }

    @RequestMapping("/saveMateria")
    public ModelAndView actualizar(@Valid @ModelAttribute Catalogo_materias materia, BindingResult result){
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()){
            System.out.println(result.getFieldError().getDefaultMessage());
            String mensaje = result.getFieldError().getDefaultMessage();
            mav.addObject("mensaje", mensaje);
            mav.addObject("materia", materia);
            mav.setViewName("crearMateria");
        }else{
            try{
                catMateriaService.save(materia);
            }catch (Exception e){
                e.printStackTrace();
            }
            mav.setViewName("redirect:/materias");
        }
        return mav;
    }

    @RequestMapping("/crearMateria")
    public ModelAndView crear(){
        ModelAndView mav = new ModelAndView();
        String mensaje = "";
        mav.addObject("mensaje", mensaje);
        Catalogo_materias materia = new Catalogo_materias();
        mav.addObject("materia", materia);
        mav.setViewName("crearMateria");
        return mav;
    }

}
