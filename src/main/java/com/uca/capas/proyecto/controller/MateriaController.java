package com.uca.capas.proyecto.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> 4fda9cace232295ca4360c7b9e2f4cf5c9e19d85
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.proyecto.domain.Catalogo_materias;
import com.uca.capas.proyecto.domain.Materia;
import com.uca.capas.proyecto.service.CatMateriaService;
import com.uca.capas.proyecto.service.MateriaService;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
public class MateriaController {

	Integer id;
	
	@Autowired
	private MateriaService materiaService;
	
	@Autowired
	private CatMateriaService catMateriaService;
	Materia idmat = new Materia();
	Integer aux;
	@RequestMapping("/materiaEstudiante")
	public ModelAndView initMain(@RequestParam(value = "id")Integer id) {
		ModelAndView mav = new ModelAndView();
		List<Materia> materias = null;

		idmat.setId_estudiante(id);
		aux = idmat.getId_estudiante();
		try {
			materias = materiaService.findAllMateriasEst(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("idmat", idmat);
		mav.addObject("materias", materias);
		mav.setViewName("Materia");
		return mav;
	}

	

	@GetMapping("/insertmatEst")
	public ModelAndView insertMatEst() {
		ModelAndView mav = new ModelAndView();
		List<Catalogo_materias> catMaterias = null;

		try {
			catMaterias = catMateriaService.findAllCatMat();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("materia", new Materia());
		mav.addObject("catMaterias", catMaterias);
		mav.setViewName("InsertMat");
		return mav;
	}
	
	
	@PostMapping("/saveMat")
	public ModelAndView guardarMat(@Valid @ModelAttribute Materia materia, BindingResult result ) {
		List<Catalogo_materias> catMaterias = null;
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			System.out.println(result.toString());
			catMaterias = catMateriaService.findAllCatMat();
			mav.addObject("catMaterias", catMaterias);
			mav.setViewName("InsertMat");

		} else {
			System.out.println("entre al else");

			if(materia.getNota()>=6) {
				materia.setResultado("APROBADO");
			} else {
				materia.setResultado("REPROBADO");
			}
			
			materia.setId_estudiante(aux);
			
			materiaService.save(materia);
			

			List<Materia> materias = null;
			
			try {
				materias = materiaService.findAllMateriasEst(aux);
			} catch (Exception e) {
				e.printStackTrace();
			}

			mav.addObject("materias", materias);
			mav.setViewName("Materia");
		}
		
		return mav;
	}
	

    @RequestMapping("/updatematEst")
    public ModelAndView updateMateriaEst(@RequestParam("id") Integer id) {
    	
        ModelAndView mav = new ModelAndView();
         Materia materia = new Materia();
        
        try {
            materia = materiaService.findOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        mav.addObject("materia", materia);
		mav.setViewName("updatemarEst");
		return mav;
    }
    
}