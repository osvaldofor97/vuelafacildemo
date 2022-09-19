package com.vuelafacil.controladores;

import com.vuelafacil.entidades.Ciudad;
import com.vuelafacil.servicios.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
* index.html            /
 listaCiudades.html    /Ciudad
 formCiudades.html     /Ciudad/form/{id}
* 
*/


@Controller
public class CiudadesController {
    
    @Autowired
    private CiudadService servicio;
    
    @GetMapping("/")
    public String cargarIndex(){
        return "index";
    }
    
    @GetMapping("/ciudades")
    public String cargarCiudades(Model modelo, @RequestParam(value="criterio",required=false) String criterio){
        if (criterio == null) {
            modelo.addAttribute("ciudades",servicio.consultarCiudad());
        }else{
            modelo.addAttribute("ciudades",servicio.consultarCiudad(criterio));
            modelo.addAttribute("criterio",criterio);
        }
        return "listaciudades";
    }
    
    @GetMapping("/ciudades/form")
    public String cargarFormCiudades(Model modelo){
        Ciudad c = new Ciudad();
        modelo.addAttribute("ciudad", c);
        return "formciudades";
    }
    
    @GetMapping("/ciudades/form/{idciudades}")
    public String cargarFormCiudades(Model modelo, @PathVariable int idciudades){
        Ciudad c = servicio.consultarCiudad(idciudades);
        modelo.addAttribute("ciudad",c);
        return "formciudades";
    }
    
    @PostMapping("/ciudades")
    public String guardarCiudad(@ModelAttribute("ciudad") Ciudad c){
        System.out.println(c.getDescripcionciudad());
        servicio.crearCiudad(c);
        return "redirect:/ciudades";
    }
    
    @GetMapping("/ciudades/eliminar/{idciudades}")
    public String eliminarCiudad(@PathVariable int idciudades){
        Ciudad c = servicio.consultarCiudad(idciudades);
        servicio.eliminarCiudad(c);
        return "redirect:/ciudades";
    }
}
