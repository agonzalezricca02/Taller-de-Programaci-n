package com.trabajosuy.model.logicaclases;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.trabajosuy.model.logicadatatype.DTPostulante;

public class Postulante extends Usuario {
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private Map<String, Postulacion> postulacionesOfertas;

    // Constructor
    public Postulante(String Nickname, String Nombre, String Apellido, String Email, String Contraseña, String imagen, LocalDate FechaNacimiento, String Nacionalidad) {
        super(Nickname, Nombre, Apellido, Email, Contraseña, imagen);
        this.fechaNacimiento = FechaNacimiento;
        this.nacionalidad = Nacionalidad;
        postulacionesOfertas = new HashMap<String, Postulacion>();
    }

    // Getters
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    // Setters
    public void setFechaNacimiento(LocalDate fecha) {
        this.fechaNacimiento = fecha;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    // Public methods
    public DTPostulante getDT() {
        return new DTPostulante(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getContrasena(), this.getImagen(), this.fechaNacimiento, this.nacionalidad);
    }

    public Postulacion getPostulacion(String oferta) {
        return postulacionesOfertas.get(oferta);
    }

    public Postulacion[] getPostulaciones() {
        return postulacionesOfertas.values().toArray(new Postulacion[0]);
    }

    public void vincularConPostulacion(String oferta, Postulacion postulacion) {
        postulacionesOfertas.put(oferta, postulacion);
    }
}

