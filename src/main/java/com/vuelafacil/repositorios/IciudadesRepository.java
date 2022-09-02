package com.vuelafacil.repositorios;

import com.vuelafacil.entidades.ciudades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IciudadesRepository extends JpaRepository <ciudades,Integer>{
    
}
