package com.vuelafacil.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tciudades")
public class ciudades {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name="nombre_ciudad", length=45, nullable=false, unique=true)
    private String nombre_ciudad;
    
    @Column(name="habilitado", columnDefinition="TINYINT", nullable=false)
    private boolean habilitado;

    public ciudades() {
    }

    public ciudades(String nombre_ciudad, boolean habilitado) {
        this.nombre_ciudad = nombre_ciudad;
        this.habilitado = habilitado;
    }

    public ciudades(int id, String nombre_ciudad, boolean habilitado) {
        this.id = id;
        this.nombre_ciudad = nombre_ciudad;
        this.habilitado = habilitado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
    
}
