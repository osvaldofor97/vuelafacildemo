package com.vuelafacil.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
* index.html            /
* listaCiudades.html    /ciudades
* formCiudades.html     /ciudades/form/{id}
* 
*/


@Controller
public class CiudadesController {
    
    @GetMapping("/")
    public String cargarIndex(){
        return "index";
    }
    
    @GetMapping("/ciudades")
    public String cargarCiudades(Model modelo){
        return "listaCiudades";
    }
    
    @GetMapping("/ciudades/form")
    public String cargarFormCiudades(){
        return "formCiudades";
    }
}
