package com.trabajosuy.model.logicadatatype;

import java.time.LocalDate;

public class DTPostulante extends DTUsuario {
	private LocalDate fechaNacimiento;
	private String nacionalidad;
	
	// Constructor
	public DTPostulante(String Nickname, String Nombre, String Apellido, String Email, String Contraseña, String imagen, LocalDate FechaNacimiento, String Nacionalidad) {
		super(Nickname, Nombre, Apellido, Email, Contraseña, imagen);
		this.fechaNacimiento= FechaNacimiento;
		this.nacionalidad = Nacionalidad;
	}
	
	// Getters
	public LocalDate  getFechaNacimiento() {
    	return fechaNacimiento;
    }
	public String getNacionalidad() {
    	return nacionalidad;
    }
	// Setters
	public void setFechaNacimiento(LocalDate  fecha) {
		this.fechaNacimiento = fecha;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
}
