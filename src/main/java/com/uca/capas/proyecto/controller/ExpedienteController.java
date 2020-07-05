package com.uca.capas.proyecto.controller;

import com.uca.capas.proyecto.domain.CatalogoCE;
import com.uca.capas.proyecto.domain.Departamento;
import com.uca.capas.proyecto.domain.Expediente;
import com.uca.capas.proyecto.service.CatalogoCEService;
import com.uca.capas.proyecto.service.DepartamentoService;
import com.uca.capas.proyecto.service.ExpedienteService;
import com.uca.capas.proyecto.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ExpedienteController {
    @Autowired
    CatalogoCEService catalogoCEService;

    @Autowired
    ExpedienteService expedienteService;

    @Autowired
    MateriaService materiaService;

    @Autowired
    DepartamentoService departamentoService;

    @RequestMapping("/expediente")
    public ModelAndView cargar(){
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
        mav.addObject("expediente", new Expediente());
        mav.setViewName("expediente");
        return mav;
    }

    @RequestMapping("/filtrar")
    public ModelAndView filtrar(@RequestParam(value = "valor")String valor){
        ModelAndView mav = new ModelAndView();
        CatalogoCE escuela = new CatalogoCE();
        List<CatalogoCE> centrosE = catalogoCEService.filtrarCEporNombre(valor);
        List<Departamento> departamentos;
        try{
            departamentos = departamentoService.findAll();
            mav.addObject("departamento", departamentos);
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            catalogoCEService.filtrarCEporNombre(valor);
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("escuela", escuela);
        mav.addObject("centros", centrosE);
        mav.setViewName("expediente");
        mav.addObject("expediente", new Expediente());
        return mav;
    }

    @RequestMapping("/insertar")
    public ModelAndView insertar(@Valid @ModelAttribute Expediente expediente, BindingResult result){
        ModelAndView mav = new ModelAndView();
        CatalogoCE escuela = new CatalogoCE();
        List<Departamento> departamentos;
        if(result.hasErrors()){
            System.out.println(result.toString());
            try{
                departamentos = departamentoService.findAll();
                mav.addObject("departamento", departamentos);
            }catch (Exception e){
                e.printStackTrace();
            }
            mav.addObject("escuela", escuela);
            mav.addObject("expediente", expediente);
            mav.setViewName("expediente");
        }else{
            expediente.setEdad(CalcularEdad(expediente.getFechaNacimiento()));
            expedienteService.save(expediente);
            mav.setViewName("principalexp");
        }

        mav.addObject("expediente", expediente);
        return mav;
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam(value = "valor")String valor){//, @RequestParam(value = "id")Integer id
        ModelAndView mav = new ModelAndView();
        List<Expediente> expedientes = null;
        expedientes = expedienteService.buscarPorNombre(valor);/*

        if(id.equals("1")){
            try{
                expedienteService.buscarPorNombre(valor);
            }catch (Exception e){
                e.printStackTrace();;
            }
        }*/
        for(Expediente m : expedientes){
            m.setPromedio(materiaService.promedioNotas(m.getIdEstudiante()));
            m.setAprovadas(materiaService.materiaAprovada(m.getIdEstudiante()));
            m.setReprovadas(materiaService.materiaReprovada(m.getIdEstudiante()));
        }
        mav.addObject("expedientes", expedientes);
        mav.setViewName("principalexp");
        return mav;
    }
    @RequestMapping("/mainExpediente")
    public ModelAndView loadMain(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("principalexp");
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
