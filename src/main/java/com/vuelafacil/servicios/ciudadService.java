package com.vuelafacil.servicios;

import com.vuelafacil.entidades.ciudades;
import com.vuelafacil.repositorios.IciudadesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ciudadService {
    
    @Autowired
    private IciudadesRepository repo;
    
    public ciudades crearCiudad(ciudades c){
         return repo.save(c);
    }
    public ciudades actualizarCiudad(ciudades c){
         return repo.save(c);
    }
    public ciudades consultarCiudad(int id){
         return repo.findById(id).get();
    }
    
    public List<ciudades> consultarCiudad(){
         List<ciudades> listac = repo.findAll();
         return listac;
    }
    
    public List<ciudades> consultarCiudad(String criterio){
         List<ciudades> listac = repo.findByNombreciudadContaining(criterio);
         return listac;
    }
    
    public void eliminarCiudad(ciudades c){
         repo.delete(c);
    }
}
