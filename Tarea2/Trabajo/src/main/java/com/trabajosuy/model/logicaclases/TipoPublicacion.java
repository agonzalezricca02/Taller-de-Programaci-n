package com.trabajosuy.model.logicaclases;


import java.time.LocalDate;

import com.trabajosuy.model.logicadatatype.DTTipoPublicacion;


public class TipoPublicacion {
	
	private String nombre;
	private String descripcion;
	private int exposicion;
	private int tiempoEnPlataforma;
	private float costo;
	private LocalDate fechaAlta;

    // Constructor
    public TipoPublicacion(String nombre, String descripcion, int exposicion, int tiempoEnPlataforma, float costo, LocalDate fechaAlta) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.exposicion = exposicion;
        this.tiempoEnPlataforma = tiempoEnPlataforma;
        this.costo = costo;
        this.fechaAlta = fechaAlta;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getExposicion() {
        return exposicion;
    }
    public void setExposicion(int exposicion) {
        this.exposicion = exposicion;
    }
    public int getTiempoEnPlataforma() {
        return tiempoEnPlataforma;
    }
    public void setTiempoEnPlataforma(int tiempoEnPlataforma) {
        this.tiempoEnPlataforma = tiempoEnPlataforma;
    }
    public float getCosto() {
        return costo;
    }
    public void setCosto(float costo) {
        this.costo = costo;
    }
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    public DTTipoPublicacion getDT() {
		return new DTTipoPublicacion(nombre, descripcion, exposicion, tiempoEnPlataforma, costo, fechaAlta);
	}
}
