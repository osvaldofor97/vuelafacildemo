package com.vuelafacil.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tciudades")
public class ciudades {
    @Id
    @Column(name="idciudades")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idciudades;
    
    @Column(name="nombreciudad", length=45, nullable=false, unique=true)
    private String nombreciudad;
    
    @Column(name="descripcionciudad", length=45, nullable=false, unique=false)
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

    public ciudades(int idciudades, String nombreciudad, String descripcionciudad ,boolean habilitado) {
        this.idciudades = idciudades;
        this.nombreciudad = nombreciudad;
        this.habilitado = habilitado;
        this.descripcionciudad=descripcionciudad;
    }

    public int getIdciudades() {
        return idciudades;
    }

    public void setIdciudades(int id) {
        this.idciudades = idciudades;
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
