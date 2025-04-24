package com.trabajosuy.model.logicadatatype;

import java.time.LocalDate;
import java.time.LocalDate;

public class DTPostulacion {
	
	private String postulante;
	private String oferta;
	private String cvReducido;
	private String motivacion;
	private LocalDate fecha;
	
	public DTPostulacion(String postulante, String oferta, String cvReducido, String motivacion, LocalDate fecha) {
		this.postulante = postulante;
		this.oferta = oferta;
		this.cvReducido = cvReducido;
		this.motivacion = motivacion;
		this.fecha = fecha;
	}
	public String getPostulante() {
        return postulante;
    }
    public void setPostulante(String postulante) {
        this.postulante = postulante;
    }
    public String getOferta() {
        return oferta;
    }
    public void setOferta(String oferta) {
        this.oferta = oferta;
    }
    public String getCVReducido() {
        return cvReducido;
    }
    public void setCvReducido(String cvReducido) {
        this.cvReducido = cvReducido;
    }
    public String getMotivacion() {
        return motivacion;
    }
    public void setMotivacion(String motivacion) {
        this.motivacion = motivacion;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String toString() {
    	return this.postulante;
    }
}
