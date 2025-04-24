package com.trabajosuy.model.logicaclases;

import com.trabajosuy.model.logicadatatype.DTOfertaLaboral;
import com.trabajosuy.model.logicamanejadores.ManejadorOferta;

public class PublicacionOferta {
	
	private OfertaLaboral oferta;
	
	public PublicacionOferta() {
	}
	
	public void setOferta(String oferta) {
		ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
		this.oferta = manejadorOf.getOferta(oferta);
	}
	
	public OfertaLaboral getOfertaPublicada() {
		return oferta;
	}
	
	public DTOfertaLaboral getDTOfertaPublicada() {
		return oferta.getDT();
	}
	
	public boolean esOfertaPublicadaVigente() {
		return oferta.esVigente();
	}
}
