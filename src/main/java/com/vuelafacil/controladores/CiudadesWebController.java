package com.vuelafacil.controladores;

import com.vuelafacil.entidades.ciudades;
import com.vuelafacil.servicios.ciudadService;
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
    private ciudadService servicio;
    
    @GetMapping("/api/ciudades")
    public ResponseEntity<List<ciudades>> consultarGeneros(){
        List<ciudades> listac = servicio.consultarCiudad();
        return new ResponseEntity<>(listac, HttpStatus.OK);
    }
}
