package com.trabajosuy.model.excepciones;

public class PostulacionRepetidaException extends Exception{
	
	public PostulacionRepetidaException(String nombre) {
		super(nombre);
	}
}
