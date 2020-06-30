package com.uca.capas.proyecto.controller;


import com.uca.capas.proyecto.domain.Municipio;
import com.uca.capas.proyecto.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class MunicipioController {

    @Autowired
    MunicipioService municipioService;

    @GetMapping("/municipios")
    public @ResponseBody List<Municipio> getMunicipios(@RequestParam int id){
        return municipioService.findById(id);

    }
}
