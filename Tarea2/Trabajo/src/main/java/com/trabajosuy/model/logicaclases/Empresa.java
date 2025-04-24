package com.trabajosuy.model.logicaclases;

import java.util.List;

import com.trabajosuy.model.logicadatatype.DTEmpresa;
import com.trabajosuy.model.logicadatatype.DTOfertaLaboral;

import java.util.ArrayList;

public class Empresa extends Usuario {
	
	private String descripcion;
	private String sitioWeb;
	
	private List<PublicacionOferta> ofertasPublicadas;
	
	// Constructor
	public Empresa(String Nickname, String Nombre, String Apellido, String Email, String Contraseña, String imagen, String Descripcion, String SitioWeb) {
		super(Nickname, Nombre, Apellido, Email, Contraseña, imagen);
		this.descripcion = Descripcion;
		this.sitioWeb = SitioWeb;
		ofertasPublicadas = new ArrayList<>();
	}
	
	// Getters
	public String getDescripcion() {
    	return descripcion;
    }
	public String getSitioWeb() {
    	return sitioWeb;
    }
	
	public List<PublicacionOferta> getPublicaciones() {
		return ofertasPublicadas;
	}
	
	public void addPublicacionOferta(String oferta) {
		PublicacionOferta postuOf = new PublicacionOferta();
		ofertasPublicadas.add(postuOf);
		postuOf.setOferta(oferta);
	}
	
	public List<DTOfertaLaboral> listarOfertas() {
		List<DTOfertaLaboral> lDT = new ArrayList<>();
		for (PublicacionOferta i: ofertasPublicadas) {
			lDT.add(i.getDTOfertaPublicada());
		}
		return lDT;
	}
	
	public List<DTOfertaLaboral> listarOfertasVigentes() {
		List<DTOfertaLaboral> lDT = new ArrayList<>();
		for (PublicacionOferta i: ofertasPublicadas) {
			if (i.esOfertaPublicadaVigente()) {
				lDT.add(i.getDTOfertaPublicada());
			}
		}
		return lDT;
	}
	
	// Setters
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}
	
	// Public Methods
	public DTEmpresa getDT() {
		return new DTEmpresa(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getContrasena(), this.getImagen(), this.descripcion, this.sitioWeb);
	}
	
	
}
