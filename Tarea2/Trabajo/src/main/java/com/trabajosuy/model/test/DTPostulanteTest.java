package com.trabajosuy.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.trabajosuy.model.logicadatatype.DTPostulante;

import java.time.LocalDate;

public class DTPostulanteTest {
    private DTPostulante dtPostulante;

    @BeforeEach
    public void setUp() {
    	dtPostulante = new DTPostulante("DataTec", "Daniel", "Pérez", "dany@datatec.com", "Contraseña", "imagen", LocalDate.of(1990, 5, 15), "Argentino");
    }

    @Test
    public void testGetFechaNacimiento() {
        assertEquals(LocalDate.of(1990, 5, 15), dtPostulante.getFechaNacimiento());
    }

    @Test
    public void testGetNacionalidad() {
        assertEquals("Argentino", dtPostulante.getNacionalidad());
    }

    @Test
    public void testSetFechaNacimiento() {
        dtPostulante.setFechaNacimiento(LocalDate.of(1985, 3, 20));
        assertEquals(LocalDate.of(1985, 3, 20), dtPostulante.getFechaNacimiento());
    }

    @Test
    public void testSetNacionalidad() {
        dtPostulante.setNacionalidad("Mexicano");
        assertEquals("Mexicano", dtPostulante.getNacionalidad());
    }
}