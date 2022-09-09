package com.vuelafacil;

import com.vuelafacil.entidades.ciudades;
import com.vuelafacil.servicios.ciudadService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class VuelafacildemoApplicationTests {
        
        @Autowired
        private ciudadService servicio;
        
	@Test
	void verificacionCrearCiudades() {
            ciudades c = new ciudades("Medellín","Ciudad de la eterna primavera",true);
            ciudades guardado = servicio.crearCiudad(c);
            Assertions.assertDoesNotThrow(()->{
                servicio.crearCiudad(c);
            },"No se pudo crear una nueva ciudad");
	}
        

}
