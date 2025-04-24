package com.trabajosuy.model.excepciones;

public class OfertaRepetidaException extends Exception{
	
	public OfertaRepetidaException(String nombre) {
		super(nombre);
	}
}
