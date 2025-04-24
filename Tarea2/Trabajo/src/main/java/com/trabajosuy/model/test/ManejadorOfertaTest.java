package com.trabajosuy.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.trabajosuy.model.logicaclases.Keyword;
import com.trabajosuy.model.logicaclases.OfertaLaboral;
import com.trabajosuy.model.logicaclases.TipoPublicacion;
import com.trabajosuy.model.logicaenums.Departamentos;
import com.trabajosuy.model.logicamanejadores.ManejadorOferta;

import java.time.LocalDate;

public class ManejadorOfertaTest {
    private ManejadorOferta manejador;

    @BeforeEach
    public void setUp() {
        manejador = ManejadorOferta.getinstance();
    }

    @Test
    public void testAddAndGetOferta() {
        TipoPublicacion tipop = new TipoPublicacion("nombre", "descripcion", 1, 1, 1.0F, LocalDate.of(1, 1, 1));
        Keyword[] keys = {new Keyword("Prueba")};

        OfertaLaboral oferta = new OfertaLaboral("Nombre", "Descripcion", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, LocalDate.of(1, 1, 1), tipop, keys, "imagen");
        manejador.addOferta(oferta);

        OfertaLaboral result = manejador.getOferta("Nombre");
        assertNotNull(result);
        assertEquals(oferta, result);
    }

    @Test
    public void testGetOfertas() {
        TipoPublicacion tipop = new TipoPublicacion("nombre", "descripcion", 1, 1, 1.0F, LocalDate.of(1, 1, 1));
        Keyword[] keys = {new Keyword("Prueba")};

        OfertaLaboral oferta1 = new OfertaLaboral("Nombre1", "Descripcion1", "Ciudad1", Departamentos.ARTIGAS, "HorarioLaboral1", 1.0F, LocalDate.of(1, 1, 1), tipop, keys, "imagen");
        OfertaLaboral oferta2 = new OfertaLaboral("Nombre2", "Descripcion2", "Ciudad2", Departamentos.ARTIGAS, "HorarioLaboral2", 1.0F, LocalDate.of(1, 1, 1), tipop, keys, "imagen");
        manejador.reiniciarManejador();
        OfertaLaboral[] ofertas = manejador.getOfertas();
        assertEquals(0, ofertas.length);
        manejador.addOferta(oferta1);
        manejador.addOferta(oferta2);
        ofertas = manejador.getOfertas();

        assertNotNull(ofertas);
        assertEquals(2, ofertas.length);
        assertEquals(oferta1, ofertas[0]);
        assertEquals(oferta2, ofertas[1]);
        assertEquals(oferta1, manejador.getOferta(oferta1.getNombre()));
        assertEquals(oferta2, manejador.getOferta(oferta2.getNombre()));
    }

    @Test
    public void testAddGetTipoPublicacion() {
        TipoPublicacion tipoP = new TipoPublicacion("Nombre", "Descripción", 5, 30, 100.0f, LocalDate.now());
        manejador.addTipoPubli(tipoP);

        TipoPublicacion result = manejador.getTipoPublicacion("Nombre");
        assertNotNull(result);
        assertEquals(tipoP, result);
    }

    @Test
    public void testGetTiposPublicacion() {
        TipoPublicacion tipoP1 = new TipoPublicacion("Tipo1", "Descripción1", 5, 30, 101.0f, LocalDate.now());
        TipoPublicacion tipoP2 = new TipoPublicacion("Tipo2", "Descripción2", 10, 60, 207.0f, LocalDate.now());
        manejador.addTipoPubli(tipoP1);
        manejador.addTipoPubli(tipoP2);

        TipoPublicacion[] tiposPublicacion = manejador.getTiposPublicacion();
        assertNotNull(tiposPublicacion);
        assertEquals(tipoP1, manejador.getTipoPublicacion(tipoP1.getNombre()));
        assertEquals(tipoP2, manejador.getTipoPublicacion(tipoP2.getNombre()));
    }

    @Test
    public void testAddAndGetKeyword() {
        Keyword keyword = new Keyword("Diseno");
        manejador.addKeyword(keyword);

        Keyword result = manejador.getKeyword("Diseno");
        assertNotNull(result);
        assertEquals(keyword, result);
    }

    @Test
    public void testGetKeywords() {
        Keyword keyword1 = new Keyword("Infra");
        Keyword keyword2 = new Keyword("Web");
        manejador.addKeyword(keyword1);
        manejador.addKeyword(keyword2);

        Keyword[] keywords = manejador.getKeywords();
        assertNotNull(keywords);
        assertEquals(keyword1, manejador.getKeyword(keyword1.getNombre()));
        assertEquals(keyword2, manejador.getKeyword(keyword2.getNombre()));
    }
}
