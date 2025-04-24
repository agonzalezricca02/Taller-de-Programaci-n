package com.trabajosuy.model.test;

import org.junit.jupiter.api.Test;

import com.trabajosuy.model.logicaclases.Keyword;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeywordTest {

    @Test
    public void testConstructorAndGetters() {
        Keyword keyword = new Keyword("Cajero");
        assertEquals("Cajero", keyword.getNombre());
    }

    @Test
    public void testSetter() {
        Keyword keyword = new Keyword("Chofer");
        keyword.setNombre("Guarda");
        assertEquals("Guarda", keyword.getNombre());
    }
}