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
    
    @Column(name="nombreciudad", length=45, nullable=false, unique=true)
    private String nombreciudad;
    
    @Column(name="descripcionciudad", length=45, nullable=false, unique=true)
    private String descripcionciudad;
    
    @Column(name="habilitado", columnDefinition="TINYINT", nullable=false)
    private boolean habilitado;

    public ciudades() {
    }

    public ciudades(String nombreciudad, String descripcionciudad ,boolean habilitado) {
        this.nombreciudad = nombreciudad;
        this.habilitado = habilitado;
        this.descripcionciudad=descripcionciudad;
    }

    public ciudades(int id, String nombreciudad, String descripcionciudad ,boolean habilitado) {
        this.id = id;
        this.nombreciudad = nombreciudad;
        this.habilitado = habilitado;
        this.descripcionciudad=descripcionciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreciudad() {
        return nombreciudad;
    }

    public void setNombreciudad(String descripcion_ciudad) {
        this.nombreciudad = nombreciudad;
    }
    
    public String getDescripcionciudad() {
        return descripcionciudad;
    }

    public void setDescripcionciudad(String descripcion_ciudad) {
        this.descripcionciudad = descripcionciudad;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
    
}
