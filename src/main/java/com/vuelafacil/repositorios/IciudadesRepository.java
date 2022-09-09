package com.vuelafacil.repositorios;

import com.vuelafacil.entidades.ciudades;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IciudadesRepository extends JpaRepository <ciudades,Integer>{
    
    public List<ciudades> findByNombreciudadContaining(String Criterio);
}
