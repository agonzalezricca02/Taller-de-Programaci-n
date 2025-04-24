package com.trabajosuy.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.trabajosuy.model.logicadatatype.DTEmpresa;
import com.trabajosuy.model.logicadatatype.DTPostulante;
import com.trabajosuy.model.logicadatatype.DTUsuario;

public class DTUsuarioTest {
    private DTUsuario dtUsuario;
    private DTUsuario dtUsuario2;
    //private DTUsuario dtUsuario3;
    @BeforeEach
    public void setUp() {
    	DTEmpresa dtEmpresa = new DTEmpresa("fingArt", "Leo", "Gonzalez", "lGonzalez@fingart.com", "contraseña", "imagen", "Descripción", "www.fingart.com");
        dtUsuario = dtEmpresa;
        DTPostulante dtPostulante = new DTPostulante("DataTec", "Daniel", "Pérez", "dany@datatec.com", "contraseña", "imagen", LocalDate.of(1990, 5, 15), "Argentino");
        dtUsuario2 = dtPostulante;
    }

    @Test
    public void testGetNickname() {
        assertEquals("fingArt", dtUsuario.getNickname());
    }

    @Test
    public void testGetNombre() {
        assertEquals("Leo", dtUsuario.getNombre());
    }

    @Test
    public void testGetApellido() {
        assertEquals("Gonzalez", dtUsuario.getApellido());
    }

    @Test
    public void testGetEmail() {
        assertEquals("lGonzalez@fingart.com", dtUsuario.getEmail());
    }
    @Test
    public void testGetContrasena() {
        assertEquals("contraseña", dtUsuario.getContrasena());
    }

    @Test
    public void testToString() {
        assertEquals("fingArt (Leo Gonzalez)", dtUsuario.toString());
    }
    
    @Test
    public void testGetNickname2() {
        assertEquals("DataTec", dtUsuario2.getNickname());
    }

    @Test
    public void testGetNombre2() {
        assertEquals("Daniel", dtUsuario2.getNombre());
    }

    @Test
    public void testGetApellido2() {
        assertEquals("Pérez", dtUsuario2.getApellido());
    }

    @Test
    public void testGetEmail2() {
        assertEquals("dany@datatec.com", dtUsuario2.getEmail());
    }
    @Test
    public void testGetcontrasena() {
        assertEquals("contraseña", dtUsuario2.getContrasena());
    }

    @Test
    public void testToString2() {
        assertEquals("DataTec (Daniel Pérez)", dtUsuario2.toString());
    }
    
    
}