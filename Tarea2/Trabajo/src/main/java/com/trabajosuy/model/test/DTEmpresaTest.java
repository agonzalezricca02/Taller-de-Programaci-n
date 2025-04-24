package com.trabajosuy.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.trabajosuy.model.logicadatatype.DTEmpresa;

public class DTEmpresaTest {
    private DTEmpresa dtEmpresa;

    @BeforeEach
    public void setUp() {
        dtEmpresa = new DTEmpresa("fingArt", "Leo", "Gonzalez", "lGonzalez@fingart.com", "contraseña", "imagen", "Descripción", "www.fingart.com");
    }

    @Test
    public void testGetDescripcion() {
        assertEquals("Descripción", dtEmpresa.getDescripcion());
    }

    @Test
    public void testGetSitioWeb() {
        assertEquals("www.fingart.com", dtEmpresa.getSitioWeb());
    }

    @Test
    public void testSetDescripcion() {
        dtEmpresa.setDescripcion("Nueva descripción");
        assertEquals("Nueva descripción", dtEmpresa.getDescripcion());
    }

    @Test
    public void testSetSitioWeb() {
        dtEmpresa.setSitioWeb("www.nueva-empresa.com");
        assertEquals("www.nueva-empresa.com", dtEmpresa.getSitioWeb());
    }
}