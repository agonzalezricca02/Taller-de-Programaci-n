package com.trabajosuy.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import com.trabajosuy.model.logicaclases.Keyword;
import com.trabajosuy.model.logicaclases.OfertaLaboral;
import com.trabajosuy.model.logicaclases.PublicacionOferta;
import com.trabajosuy.model.logicaclases.TipoPublicacion;
import com.trabajosuy.model.logicaenums.Departamentos;
import com.trabajosuy.model.logicamanejadores.ManejadorOferta;

public class PublicacionOfertaTest {

    @Test
    public void testSetOferta() {
        TipoPublicacion tipop = new TipoPublicacion("nombre", "descripcion", 1, 1, 1.0F, LocalDate.of(1, 1, 1));
        Keyword[] keys = { new Keyword("Prueba") };
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        OfertaLaboral oferta = new OfertaLaboral("Nombre", "Descripcion", "Ciudad", Departamentos.ARTIGAS,
                "HorarioLaboral", 1.0F, LocalDate.of(1, 1, 1), tipop, keys, "imagen");
        manejadorOf.addOferta(oferta);
        assertEquals(oferta, manejadorOf.getOferta("Nombre"));

        PublicacionOferta publicacionOferta = new PublicacionOferta();
        publicacionOferta.setOferta("Nombre");
        assertEquals(oferta, publicacionOferta.getOfertaPublicada());
    }

    @Test
    public void testEsOfertaPublicadaVigente() {
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        OfertaLaboral oferta = new OfertaLaboral("Nombre", "Descripción", "Ciudad", Departamentos.ARTIGAS,
                "HorarioLaboral", 1.0F, LocalDate.now(),
                new TipoPublicacion("nombre", "descripcion", 1, 1, 1.0F, LocalDate.of(1, 1, 1)),
                new Keyword[] { new Keyword("Prueba") }, "imagen");
        manejadorOf.addOferta(oferta);

        PublicacionOferta publicacionOferta = new PublicacionOferta();
        publicacionOferta.setOferta("Nombre");

        assertTrue(publicacionOferta.esOfertaPublicadaVigente());
    }
}