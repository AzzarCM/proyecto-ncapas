package com.uca.capas.proyecto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.proyecto.domain.Catalogo_materias;
import com.uca.capas.proyecto.domain.Materia;
import com.uca.capas.proyecto.service.CatMateriaService;
import com.uca.capas.proyecto.service.MateriaService;

@Controller
public class MateriaController {

	@Autowired
	private MateriaService materiaService;
	@Autowired
	private CatMateriaService catMateriaService;
	@RequestMapping("/materiaEstudiante")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Materia> materias = null;

		try {
			materias = materiaService.findAllMateriasEst(2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("materias", materias);
		mav.setViewName("Materia");
		return mav;
	}


	@GetMapping("/insertMatEst")
	public ModelAndView insertMatEst() {
		ModelAndView mav = new ModelAndView();
		List<Catalogo_materias> catMaterias = null;
		
		try {
			catMaterias = catMateriaService.findAllCatMat();
		} catch (Exception e) {
			e.printStackTrace();
		}
<<<<<<< HEAD
		
		mav.addObject("materia", new Materia());
=======
		Materia materia = new Materia();
		mav.addObject("materia", materia);
>>>>>>> 56e8a69ee83be0ef8ab41bc9c7f19a84a0c72ef1
		mav.addObject("catMaterias", catMaterias);
		mav.setViewName("InsertMat");
		return mav;
	}
<<<<<<< HEAD
	
	
	@PostMapping("/saveMat")
	public ModelAndView guardarMat(@Valid @ModelAttribute Materia materia, BindingResult result ) {
		List<Catalogo_materias> catMaterias = null;

		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			catMaterias = catMateriaService.findAllCatMat();
			mav.addObject("catMaterias", catMaterias);
			mav.setViewName("InsertMat");

		} else {		    
			
=======
	@PostMapping("/guardarMat")
	public ModelAndView guardarCont(@Valid @ModelAttribute Materia c, BindingResult result) {
		ModelAndView mav = new ModelAndView();

		if(result.hasErrors()) {
			List<Catalogo_materias> catMaterias = null;

			try {
				catMaterias = catMateriaService.findAllCatMat();
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.addObject("catMaterias", catMaterias);
			mav.setViewName("InsertMat");
		}
		else {
			if(c.getNota()>=6) {
				c.setResultado("APROBADO");
			} else {
				c.setResultado("REPROBADO");
>>>>>>> 56e8a69ee83be0ef8ab41bc9c7f19a84a0c72ef1

			if(materia.getNota()>=6) {
				materia.setResultado("APROBADO");
			} else {
				materia.setResultado("REPROBADO");
			}
<<<<<<< HEAD
			
			materia.setId_estudiante(2);
			
			materiaService.save(materia);
			

			List<Materia> materias = null;
			
=======
			c.setId_estudiante(2);
			List<Materia> materias = null;

			materiaService.save(c);
>>>>>>> 56e8a69ee83be0ef8ab41bc9c7f19a84a0c72ef1
			try {
				materias = materiaService.findAllMateriasEst(2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			mav.addObject("materias", materias);
			mav.setViewName("Materia");
		}
		return mav;
	}
<<<<<<< HEAD
	
	
}
=======
}
>>>>>>> 56e8a69ee83be0ef8ab41bc9c7f19a84a0c72ef1
