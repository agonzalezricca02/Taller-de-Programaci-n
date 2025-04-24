package com.trabajosuy.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.trabajosuy.model.logicadatatype.DTTipoPublicacion;


public class DTTipoPublicacionTest {
    private DTTipoPublicacion dtTipoPublicacion;

    @BeforeEach
    public void setUp() {
        LocalDate fechaAlta = LocalDate.now();
        dtTipoPublicacion = new DTTipoPublicacion("Tipo1", "Descripción", 10, 30, 50.0f, fechaAlta);
    }

    @Test
    public void testGetNombre() {
        assertEquals("Tipo1", dtTipoPublicacion.getNombre(), "El nombre debe ser 'Tipo1'");
    }

    @Test
    public void testGetDescripcion() {
        assertEquals("Descripción", dtTipoPublicacion.getDescripcion(), "La descripción debe ser 'Descripción'");
    }

    @Test
    public void testGetExposicion() {
        assertEquals(10, dtTipoPublicacion.getExposicion(), "La exposición debe ser 10");
    }

    @Test
    public void testGetTiempoEnPlataforma() {
        assertEquals(30, dtTipoPublicacion.getTiempoEnPlataforma(), "El tiempo en plataforma debe ser 30");
    }

    @Test
    public void testGetCosto() {
        assertEquals(50.0f, dtTipoPublicacion.getCosto(), 0.01, "El costo debe ser 50.0");
    }

    @Test
    public void testGetFechaAlta() {
        LocalDate fechaAlta = LocalDate.now();
        assertEquals(fechaAlta, dtTipoPublicacion.getFechaAlta(), "La fecha de alta debe coincidir con la fecha actual");
    }

    @Test
    public void testSetNombre() {
        dtTipoPublicacion.setNombre("NuevoNombre");
        assertEquals("NuevoNombre", dtTipoPublicacion.getNombre(), "El nombre debe haber sido actualizado a 'NuevoNombre'");
    }

    @Test
    public void testSetDescripcion() {
        dtTipoPublicacion.setDescripcion("NuevaDescripción");
        assertEquals("NuevaDescripción", dtTipoPublicacion.getDescripcion(), "La descripción debe haber sido actualizada a 'NuevaDescripción'");
    }

    @Test
    public void testSetExposicion() {
        dtTipoPublicacion.setExposicion(20);
        assertEquals(20, dtTipoPublicacion.getExposicion(), "La exposición debe haber sido actualizada a 20");
    }

    @Test
    public void testSetTiempoEnPlataforma() {
        dtTipoPublicacion.setTiempoEnPlataforma(60);
        assertEquals(60, dtTipoPublicacion.getTiempoEnPlataforma(), "El tiempo en plataforma debe haber sido actualizado a 60");
    }

    @Test
    public void testSetCosto() {
        dtTipoPublicacion.setCosto(75.0f);
        assertEquals(75.0f, dtTipoPublicacion.getCosto(), 0.01, "El costo debe haber sido actualizado a 75.0");
    }

    @Test
    public void testSetFechaAlta() {
        LocalDate nuevaFechaAlta = LocalDate.of(2023, 8, 1);
        dtTipoPublicacion.setFechaAlta(nuevaFechaAlta);
        assertEquals(nuevaFechaAlta, dtTipoPublicacion.getFechaAlta(), "La fecha de alta debe haber sido actualizada");
    }
}