package com.vuelafacil;

import com.vuelafacil.entidades.ciudades;
import com.vuelafacil.servicios.ciudadService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;


@SpringBootTest
class CiudadesUnitTest {
        
        @Autowired
        private ciudadService servicio;
        
	@Test
        @Disabled("Ya probada")
	void verificacionCrearCiudades() {
            ciudades c = new ciudades("Cartagena","La ciudad amurallada",true);
            ciudades guardado = servicio.crearCiudad(c);
            Assertions.assertDoesNotThrow(()->{
                servicio.crearCiudad(c);
            },"No se pudo crear una nueva ciudad");
	}
        
        @Test
        void verificarNoPoderCrearUnaCiudadRepetida(){
            ciudades c = new ciudades("Barranquilla","La puerta de oro",true);
            Assertions.assertThrows(DataIntegrityViolationException.class, () ->{
                servicio.crearCiudad(c);
            },"No se genero ninguna excepcion en la base de datos");
        }
        
        @Test
        void verificarSiNoSeGuardanGenerosInvalidos(){
            ciudades c = new ciudades(null,null,false);
            Assertions.assertThrows(DataIntegrityViolationException.class, () ->{
                servicio.crearCiudad(c);
            },"No se genero ninguna excepcion en la base de datos");
        }
        
        @Test
        void verificarSiSePuedenConsultarTodasLasCiudades(){
            List<ciudades> listac = servicio.consultarCiudad();
            Assertions.assertTrue(listac.size()>0,"No se consultaron las ciudades");
        }
        
        @Test
        void verificarSiSePuedeConsultarUnaCiudadExistentePorID(){
            ciudades c = servicio.consultarCiudad(1);
            Assertions.assertNotNull(c,"No se pudo consultar genero");
        }
        
        @Test
        void verificarSiSePuedeConsultarUnaCiudadExistentePorSuNombre(){
            List<ciudades> listac = servicio.consultarCiudad("Bogotá");
            Assertions.assertTrue(listac.size()>0,"No se pudo consultar ciudad");
        }
        
        @Test
        void verificarSiSePuedeConsultarUnaCiudadNoExistentePorID(){
            ciudades c = servicio.consultarCiudad(800000);
            Assertions.assertNull(c,"No se pudo consultar genero");
        }
}
