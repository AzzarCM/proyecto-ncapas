package com.uca.capas.proyecto.controller;

import com.uca.capas.proyecto.domain.CatalogoCE;
import com.uca.capas.proyecto.domain.Catalogo_materias;
import com.uca.capas.proyecto.domain.Departamento;
import com.uca.capas.proyecto.domain.Municipio;
import com.uca.capas.proyecto.service.CatalogoCEService;
import com.uca.capas.proyecto.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CatCEController {

    @Autowired
    private CatalogoCEService catalogoCEService;

    @Autowired
    DepartamentoService departamentoService;

    @GetMapping("/instituciones")
    public @ResponseBody List<CatalogoCE> getInstituciones(@RequestParam int id){
        List<CatalogoCE> institucionesLimpios = new ArrayList<>(), institucionesSucios = catalogoCEService.findById(id);
        System.out.println(institucionesSucios.size());

        for(CatalogoCE mun : institucionesSucios){
            CatalogoCE aux = new CatalogoCE();
            aux.setIdCentroEscolar(mun.getIdCentroEscolar());
            aux.setNombre(mun.getNombre());
            institucionesLimpios.add(aux);
        }
        return institucionesLimpios;
    }

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
    public ModelAndView actualizar(@Valid @ModelAttribute CatalogoCE escuela, BindingResult result){
        ModelAndView mav = new ModelAndView();
        List<Departamento> departamentos;
        if(result.hasErrors()){
            try{
                String mensaje = result.getFieldError().getDefaultMessage();
                mav.addObject("mensaje", mensaje);
                System.out.println(result);
                departamentos = departamentoService.findAll();
                mav.addObject("departamento", departamentos);
                mav.addObject("escuela", escuela);
                mav.setViewName("crearCE");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(escuela.getMunicipio().getDepartamento().getIdDepartamento() == 0){
            departamentos = departamentoService.findAll();
            mav.addObject("errorDepartamento", "Seleccione un departamento");
            mav.addObject("errorMunicipio", "Seleccione un municipio");
            mav.addObject("departamento", departamentos);
            mav.addObject("escuela", escuela);
            mav.setViewName("crearCE");
        }else if(escuela.getMunicipio().getIdMunicipio() == 0){
            departamentos = departamentoService.findAll();
            mav.addObject("errorMunicipio", "Seleccione un municipio");
            mav.addObject("departamento", departamentos);
            mav.addObject("escuela", escuela);
            mav.setViewName("crearCE");
        }
        else{
            try{
                catalogoCEService.save(escuela);
            }catch (Exception e){
                e.printStackTrace();
            }
            mav.setViewName("redirect:/escolares");
        }
        return mav;
    }

    @RequestMapping("/crearCE")
    public ModelAndView crear(){
        ModelAndView mav = new ModelAndView();
        CatalogoCE escuela = new CatalogoCE();
        List<Departamento> departamentos;
        String mensaje = "";
        try{
            departamentos = departamentoService.findAll();
            mav.addObject("departamento", departamentos);
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("mensaje", mensaje);
        mav.addObject("escuela", escuela);
        mav.setViewName("crearCE");
        return mav;
    }
}
