package com.trabajosuy.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.trabajosuy.model.logicaclases.TipoPublicacion;
import com.trabajosuy.model.logicadatatype.DTTipoPublicacion;
import java.time.LocalDate;

public class TipoPublicacionTest {
    private TipoPublicacion tipoPublicacion;

    @BeforeEach
    public void setUp() {
        LocalDate fechaAlta = LocalDate.now();
        tipoPublicacion = new TipoPublicacion("Tipo1", "Descripción", 10, 30, 50.0f, fechaAlta);
    }

    @Test
    public void testGetNombre() {
        assertEquals("Tipo1", tipoPublicacion.getNombre());
    }

    @Test
    public void testGetDescripcion() {
        assertEquals("Descripción", tipoPublicacion.getDescripcion());
    }

    @Test
    public void testGetExposicion() {
        assertEquals(10, tipoPublicacion.getExposicion());
    }

    @Test
    public void testGetTiempoEnPlataforma() {
        assertEquals(30, tipoPublicacion.getTiempoEnPlataforma());
    }

    @Test
    public void testGetCosto() {
        assertEquals(50.0f, tipoPublicacion.getCosto());
    }

    @Test
    public void testGetFechaAlta() {
        LocalDate fechaAlta = LocalDate.now();
        assertEquals(fechaAlta, tipoPublicacion.getFechaAlta());
    }

    @Test
    public void testGetDT() {
        DTTipoPublicacion datatype = tipoPublicacion.getDT();
        assertNotNull(datatype);
        assertEquals("Tipo1", datatype.getNombre());
        assertEquals("Descripción", datatype.getDescripcion());
        assertEquals(10, datatype.getExposicion());
        assertEquals(30, datatype.getTiempoEnPlataforma());
        assertEquals(50.0f, datatype.getCosto());
        assertEquals(LocalDate.now(), datatype.getFechaAlta());
    }
    
    //Seters  
    
    @Test
    public void testSetNombre() {
        tipoPublicacion.setNombre("NuevoNombre");
        assertEquals("NuevoNombre", tipoPublicacion.getNombre());
    }

    @Test
    public void testSetDescripcion() {
        tipoPublicacion.setDescripcion("NuevaDescripción");
        assertEquals("NuevaDescripción", tipoPublicacion.getDescripcion());
    }

    @Test
    public void testSetExposicion() {
        tipoPublicacion.setExposicion(20);
        assertEquals(20, tipoPublicacion.getExposicion());
    }

    @Test
    public void testSetTiempoEnPlataforma() {
        tipoPublicacion.setTiempoEnPlataforma(60);
        assertEquals(60, tipoPublicacion.getTiempoEnPlataforma());
    }

    @Test
    public void testSetCosto() {
        tipoPublicacion.setCosto(75.0f);
        assertEquals(75.0f, tipoPublicacion.getCosto());
    }

    @Test
    public void testSetFechaAlta() {
        LocalDate nuevaFechaAlta = LocalDate.of(2023, 8, 1);
        tipoPublicacion.setFechaAlta(nuevaFechaAlta);
        assertEquals(nuevaFechaAlta, tipoPublicacion.getFechaAlta());
    }
}