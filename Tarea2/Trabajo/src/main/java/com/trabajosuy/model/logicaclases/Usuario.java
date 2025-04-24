package com.trabajosuy.model.logicaclases;

import com.trabajosuy.model.logicadatatype.DTUsuario;

public abstract class Usuario {

	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasena;
	private String imagen;

    public Usuario(String Nickname, String Nombre, String Apellido, String Email, String Contraseña, String imagen) {
        this.nickname = Nickname;
        this.nombre = Nombre;
        this.apellido = Apellido;
        this.email = Email;
        this.contrasena = Contraseña;
        this.imagen = imagen;
    }
    // Getters
    public String getNickname() {
        return nickname;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getEmail() {
        return email;
    }
    public String getContrasena() { 
        return contrasena;
    }
    public String getImagen() { 
        return imagen;
    }
    
    // Setters
    public void setNickname(String nickname) {
    	this.nickname = nickname;
    }
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    public void setApellido(String apellido) {
    	this.apellido = apellido;
    }
    public void setEmail(String email) {
    	this.email = email;
    }
    public void setContrasena(String contraseña) {
    	this.email = contraseña;
    }
    public void setImagen(String imagen) { 
        this.imagen = imagen;
    }
    
    // Public methods
    public abstract DTUsuario getDT();
}
