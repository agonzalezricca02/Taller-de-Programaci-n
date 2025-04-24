package com.trabajosuy.model.logicadatatype;

public class DTEmpresa extends DTUsuario {
	private String descripcion;
	private String sitioWeb;
	
	// Constructor
	public DTEmpresa(String Nickname, String Nombre, String Apellido, String Email, String Contraseña, String imagen, String Descripcion, String SitioWeb) {
		super(Nickname, Nombre, Apellido, Email, Contraseña, imagen);
		this.descripcion = Descripcion;
		this.sitioWeb = SitioWeb;
	}
	
	// Getters
	public String getDescripcion() {
    	return descripcion;
    }
	public String getSitioWeb() {
    	return sitioWeb;
    }
	// Setters
	public void setDescripcion(String Descripcion) {
		this.descripcion = Descripcion;
	}
	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}
}
