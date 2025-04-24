package com.trabajosuy.model.logicadatatype;

public class DTUsuario{

	private String nickname;
	private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private String imagen;
    
    // Constructors

    public DTUsuario(String nickname, String nombre, String apellido, String email, String contraseña, String imagen) {
    	this.setNickname(nickname);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEmail(email);
        this.setContrasena(contraseña);
        this.setImagen(imagen);
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
    private void setNickname(String nickname) {
        this.nickname = nickname;
    }
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private void setApellido(String apellido) {
        this.apellido = apellido;
    }
    private void setEmail(String email) {
        this.email = email;
    }
    private void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }
    private void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    // Public methods
    // Sirve para mostrar textualmente la información del usuario, por ejemplo en un ComboBox
    public String toString() {
    	return getNickname() + " (" + getNombre() + " " + getApellido() + ")";
    }
}
