package com.trabajosuy.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.trabajosuy.model.logicadatatype.DTPostulacion;

import java.time.LocalDate;

public class DTPostulacionTest {
    private DTPostulacion dtPostulacion;

    @BeforeEach
    public void setUp() {
        dtPostulacion = new DTPostulacion("postulante", "oferta", "cv", "Motivación", LocalDate.now());
    }

    @Test
    public void testGetPostulante() {
        assertEquals("postulante", dtPostulacion.getPostulante());
    }

    @Test
    public void testGetOferta() {
        assertEquals("oferta", dtPostulacion.getOferta());
    }

    @Test
    public void testGetCVReducido() {
        assertEquals("cv", dtPostulacion.getCVReducido());
    }

    @Test
    public void testGetMotivacion() {
        assertEquals("Motivación", dtPostulacion.getMotivacion());
    }

    @Test
    public void testGetFecha() {
        LocalDate fecha = LocalDate.now();
        assertEquals(fecha, dtPostulacion.getFecha());
    }

    @Test
    public void testSetPostulante() {
        dtPostulacion.setPostulante("nuevoPostulante");
        assertEquals("nuevoPostulante", dtPostulacion.getPostulante());
    }

    @Test
    public void testSetOferta() {
        dtPostulacion.setOferta("nuevaOferta");
        assertEquals("nuevaOferta", dtPostulacion.getOferta());
    }

    @Test
    public void testSetCVReducido() {
        dtPostulacion.setCvReducido("nuevoCV.pdf");
        assertEquals("nuevoCV.pdf", dtPostulacion.getCVReducido());
    }

    @Test
    public void testSetMotivacion() {
        dtPostulacion.setMotivacion("Nueva motivación");
        assertEquals("Nueva motivación", dtPostulacion.getMotivacion());
    }

    @Test
    public void testSetFecha() {
        LocalDate nuevaFecha = LocalDate.of(2000, 8, 1);
        dtPostulacion.setFecha(nuevaFecha);
        assertEquals(nuevaFecha, dtPostulacion.getFecha());
    }
}