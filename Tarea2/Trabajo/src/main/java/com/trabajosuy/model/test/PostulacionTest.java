package com.trabajosuy.model.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.trabajosuy.model.logicaclases.Keyword;
import com.trabajosuy.model.logicaclases.OfertaLaboral;
import com.trabajosuy.model.logicaclases.Postulacion;
import com.trabajosuy.model.logicaclases.Postulante;
import com.trabajosuy.model.logicaclases.TipoPublicacion;
import com.trabajosuy.model.logicadatatype.DTPostulacion;
import com.trabajosuy.model.logicaenums.Departamentos;

import java.time.LocalDate;

public class PostulacionTest {
    private OfertaLaboral oferta;
    private Postulacion postulacion;
    private Postulante postulante;

    @Test
    public void testGetNickPostulante() {
        TipoPublicacion tipop = new TipoPublicacion("nombre", "descripcion", 1, 1, 1.0F, LocalDate.of(1, 1, 1));
        Keyword[] keys = { new Keyword("Prueba") };
        postulante = new Postulante("Migue", "Miguel", "Barboza", "mig@fing", "contraseña", "imagen", LocalDate.of(1984, 11, 14), "oriental");
        oferta = new OfertaLaboral("Nombre", "Descripcion", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, LocalDate.of(1, 1, 1), tipop, keys, "imagen");
        postulacion = new Postulacion("CV", "Motivacion", LocalDate.now(), oferta, postulante);

        String nickPostulante = postulacion.getNickPostulante();

        assertEquals("Migue", nickPostulante);
    }

    @Test
    public void testGetDT() {
        TipoPublicacion tipop = new TipoPublicacion("nombre", "descripcion", 1, 1, 1.0F, LocalDate.of(1, 1, 1));
        Keyword[] keys = { new Keyword("Prueba") };
        Postulante postulante = new Postulante("Migue", "Miguel", "Barboza", "mig@fing", "contraseña", "imagen", LocalDate.of(1984, 11, 14), "oriental");
        OfertaLaboral oferta = new OfertaLaboral("Programador", "Descripcion", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, LocalDate.of(1, 1, 1), tipop, keys, "imagen");
        LocalDate fecha = LocalDate.of(1984, 11, 14);
        Postulacion postulacion = new Postulacion("CV", "Motivacion", fecha, oferta, postulante);

        DTPostulacion dtpostu = postulacion.getDT();

        assertEquals("Migue", dtpostu.getPostulante());
        assertEquals("Programador", dtpostu.getOferta());
        assertEquals("CV", dtpostu.getCVReducido());
        assertEquals("Motivacion", dtpostu.getMotivacion());
        assertEquals(fecha, dtpostu.getFecha());
    }

    @Test
    public void testGetters() {
        Postulacion postulacion = new Postulacion("CV", "Motivación", LocalDate.now(), oferta, postulante);

        assertEquals("CV", postulacion.getCvReducido());
        assertEquals("Motivación", postulacion.getMotivacion());
        assertEquals(LocalDate.now(), postulacion.getFecha());
    }

    @Test
    public void testSetters() {
        Postulacion postulacion = new Postulacion("CV", "Motivación", LocalDate.now(), oferta, postulante);

        postulacion.setCvReducido("Nuevo CV");
        postulacion.setMotivacion("Nueva Motivación");
        LocalDate nuevaFecha = LocalDate.of(2023, 8, 27);
        postulacion.setFecha(nuevaFecha);

        assertEquals("Nuevo CV", postulacion.getCvReducido());
        assertEquals("Nueva Motivación", postulacion.getMotivacion());
        assertEquals(nuevaFecha, postulacion.getFecha());
    }
}
