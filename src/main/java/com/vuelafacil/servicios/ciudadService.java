package com.vuelafacil.servicios;

import com.vuelafacil.entidades.Ciudad;
import com.vuelafacil.repositorios.IciudadesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadService {
    
    @Autowired
    private IciudadesRepository repo;
    
    public Ciudad crearCiudad(Ciudad c){
         return repo.save(c);
    }
    public Ciudad actualizarCiudad(Ciudad c){
         return repo.save(c);
    }
    public Ciudad consultarCiudad(int idciudades){
         return repo.findById(idciudades).orElse(null);
    }
    
    public List<Ciudad> consultarCiudad(){
         List<Ciudad> listac = repo.findAll();
         return listac;
    }
    
    public List<Ciudad> consultarCiudad(String criterio){
         List<Ciudad> listac = repo.findByNombreciudadContaining(criterio);
         return listac;
    }
    
    public List<Ciudad> consultarCiudadesHabilitadas(){
         List<Ciudad> listac = repo.findByHabilitadoTrue();
         return listac;
    }
    
    public void eliminarCiudad(Ciudad c){
         repo.delete(c);
    }
}
