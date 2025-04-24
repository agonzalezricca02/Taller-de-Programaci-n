package com.trabajosuy.model.logicaclases;

import java.time.LocalDate;

import com.trabajosuy.model.logicadatatype.DTPostulacion;

public class Postulacion {
	
	private String cvReducido;
	private String motivacion;
	private LocalDate fecha;
	
	private OfertaLaboral oferta;
	private Postulante postulante;
	
	public Postulacion(String cvReducido, String motivacion, LocalDate fecha, OfertaLaboral oferta, Postulante postulante) {
		this.cvReducido = cvReducido;
		this.motivacion = motivacion;
		this.fecha = fecha;
		this.oferta = oferta;
		this.postulante = postulante;
	}
	
	// Getters
	public String getNickPostulante() {
		return postulante.getNickname();
	}
	public DTPostulacion getDT() {
		return new DTPostulacion(postulante.getNickname(), oferta.getNombre(), cvReducido, motivacion, fecha);
	}
    public String getCvReducido() {
        return cvReducido;
    }
    public String getMotivacion() {
        return motivacion;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public OfertaLaboral getOferta() {
        return oferta;
    }
    // Setters
    public void setCvReducido(String cvReducido) {
        this.cvReducido = cvReducido;
    }
    public void setMotivacion(String motivacion) {
        this.motivacion = motivacion;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public void setOferta(OfertaLaboral oferta) {
        this.oferta = oferta;
    }
    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }
}
