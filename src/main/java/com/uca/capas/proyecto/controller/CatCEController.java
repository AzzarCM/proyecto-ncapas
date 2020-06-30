package com.uca.capas.proyecto.controller;

import com.uca.capas.proyecto.domain.CatalogoCE;
import com.uca.capas.proyecto.domain.Catalogo_materias;
import com.uca.capas.proyecto.domain.Departamento;
import com.uca.capas.proyecto.service.CatalogoCEService;
import com.uca.capas.proyecto.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CatCEController {

    @Autowired
    private CatalogoCEService catalogoCEService;

    @Autowired
    DepartamentoService departamentoService;

    @RequestMapping("/escolares")
    public ModelAndView materias() {
        ModelAndView mav = new ModelAndView();
        List<CatalogoCE> escolares = null;

        try {
            escolares = catalogoCEService.allCentrosEscolares();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mav.addObject("escolares", escolares);
        mav.setViewName("CatalogoCE");
        return mav;
    }

    @RequestMapping("/escuela")
    public ModelAndView updateMateria(@RequestParam("id") Integer id) {
        ModelAndView mav = new ModelAndView();
        CatalogoCE escuela = new CatalogoCE();
        List<Departamento> departamentos;
        try {
            escuela = catalogoCEService.findOne(id);
            departamentos = departamentoService.findAll();
            mav.addObject("departamento", departamentos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("escuela", escuela);
        mav.setViewName("updateCE");
        return mav;
    }

    @RequestMapping("/saveEscuela")
    public ModelAndView actualizar(@ModelAttribute CatalogoCE escuela){
        ModelAndView mav = new ModelAndView();
        try{
            catalogoCEService.save(escuela);
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.setViewName("redirect:/escolares");
        return mav;
    }

    @RequestMapping("/crearCE")
    public ModelAndView crear(){
        ModelAndView mav = new ModelAndView();
        CatalogoCE escuela = new CatalogoCE();
        List<Departamento> departamentos;
        try{
            departamentos = departamentoService.findAll();
            mav.addObject("departamento", departamentos);
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("escuela", escuela);
        mav.setViewName("crearCE");
        return mav;
    }
}
