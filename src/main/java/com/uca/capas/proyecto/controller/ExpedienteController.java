package com.uca.capas.proyecto.controller;

import com.uca.capas.proyecto.domain.CatalogoCE;
import com.uca.capas.proyecto.domain.Expediente;
import com.uca.capas.proyecto.service.CatalogoCEService;
import com.uca.capas.proyecto.service.ExpedienteService;
import com.uca.capas.proyecto.service.MateriaService;
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

    @Autowired
    MateriaService materiaService;

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

    @RequestMapping("/mainExpediente")
    public ModelAndView loadMain(@RequestParam(value ="id1") String id1, @RequestParam(value = "id2")String id2, @RequestParam(value = "valor")String valor){
        ModelAndView mav = new ModelAndView();
        List<Expediente> expedientes = null;
        if(id1.equals("1")){
            try{
                expedienteService.buscarPorNombre(valor);
            }catch (Exception e){
                e.printStackTrace();;
            }
        }
        if(id2.equals("2")){
            try{
                expedienteService.buscarPorApellido(valor);
            }catch (Exception e){
                e.printStackTrace();;
            }
        }
        mav.addObject("expedientes", expedientes);
        mav.setViewName("principalexp");
        return mav;
    }

}
