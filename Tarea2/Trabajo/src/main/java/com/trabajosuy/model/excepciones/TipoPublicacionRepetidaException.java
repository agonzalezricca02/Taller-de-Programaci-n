package com.trabajosuy.model.excepciones;

public class TipoPublicacionRepetidaException extends Exception{
	
	public TipoPublicacionRepetidaException(String nombre) {
		super(nombre);
	}
}
