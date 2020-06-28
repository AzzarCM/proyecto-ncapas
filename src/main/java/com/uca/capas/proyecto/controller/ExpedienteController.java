package com.uca.capas.proyecto.controller;

import com.uca.capas.proyecto.domain.CatalogoCE;
import com.uca.capas.proyecto.domain.Expediente;
import com.uca.capas.proyecto.service.CatalogoCEService;
import com.uca.capas.proyecto.service.ExpedienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ExpedienteController {
    @Autowired
    CatalogoCEService catalogoCEService;

    @Autowired
    ExpedienteService expedienteService;

    @RequestMapping("/expediente")
    public ModelAndView cargar(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("expediente", new Expediente());
        mav.setViewName("expediente");
        return mav;
    }

    @RequestMapping("/filtrar")
    public ModelAndView filtrar(@RequestParam(value = "codigo")Integer idMunicipio){
        ModelAndView mav = new ModelAndView();
        List<CatalogoCE> centrosE = catalogoCEService.filtrarCE(idMunicipio);

        try{
            catalogoCEService.filtrarCE(idMunicipio);
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("centros", centrosE);
        mav.setViewName("expediente");
        mav.addObject("expediente", new Expediente());
        return mav;
    }

    @RequestMapping("/insertar")
    public ModelAndView insertar(@ModelAttribute Expediente expediente){
        ModelAndView mav = new ModelAndView();

        expedienteService.save(expediente);

        mav.setViewName("expediente");
        mav.addObject("expediente", expediente);
        return mav;
    }

}
