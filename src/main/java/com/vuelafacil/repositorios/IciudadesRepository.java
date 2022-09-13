package com.vuelafacil.repositorios;

import com.vuelafacil.entidades.Ciudad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IciudadesRepository extends JpaRepository <Ciudad,Integer>{
    
    public List<Ciudad> findByNombreciudadContaining(String Criterio);
    public List<Ciudad> findByHabilitadoTrue();
}
