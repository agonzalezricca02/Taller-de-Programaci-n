package com.trabajosuy.model.excepciones;

public class OfertaExpiradaException extends Exception{
	
	public OfertaExpiradaException(String nombre) {
		super(nombre);
	}
}