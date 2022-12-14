package com.vuelafacil.controladores;

import com.vuelafacil.entidades.Ciudad;
import com.vuelafacil.servicios.CiudadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class CiudadesWebController {
    
    @Autowired
    private CiudadService servicio;
    
    @GetMapping("/api/ciudades")
    public ResponseEntity<List<Ciudad>> consultarGeneros(){
        List<Ciudad> listac = servicio.consultarCiudad();
        return new ResponseEntity<>(listac, HttpStatus.OK);
    }
}
