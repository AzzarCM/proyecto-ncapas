package com.uca.capas.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.proyecto.domain.Materia;
import com.uca.capas.proyecto.service.MateriaService;

@Controller
public class MateriaController {

	
	@Autowired
	private MateriaService materiaService;
	
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

}
