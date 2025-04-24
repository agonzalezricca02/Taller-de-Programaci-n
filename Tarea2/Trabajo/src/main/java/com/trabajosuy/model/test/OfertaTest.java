package com.trabajosuy.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.trabajosuy.model.logicaclases.Keyword;
import com.trabajosuy.model.logicaclases.OfertaLaboral;
import com.trabajosuy.model.logicaclases.Postulacion;
import com.trabajosuy.model.logicaclases.Postulante;
import com.trabajosuy.model.logicaclases.TipoPublicacion;
import com.trabajosuy.model.logicadatatype.DTPostulacion;
import com.trabajosuy.model.logicaenums.Departamentos;

public class OfertaTest {

    private OfertaLaboral oferta;

    @BeforeEach
    public void iniciar() {
        TipoPublicacion tipop = new TipoPublicacion("nombre", "descripcion", 1, 1, 1.0F, LocalDate.of(1, 1, 1));
        Keyword[] keys = { new Keyword("Prueba") };

        oferta = new OfertaLaboral("Nombre", "Descripcion", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, LocalDate.of(1, 1, 1), tipop, keys, "imagen");
    }

    @Test
    void testGetNombre() {
        assertEquals("Nombre", oferta.getNombre());
    }

    @Test
    void testGetDescripcion() {
        assertEquals("Descripcion", oferta.getDescripcion());
    }

    @Test
    void testGetCiudad() {
        assertEquals("Ciudad", oferta.getCiudad());
    }

    @Test
    void testGetDepartamento() {
        assertEquals(Departamentos.ARTIGAS, oferta.getDepartamento());
    }

    @Test
    void testGetHorarioLaboral() {
        assertEquals("HorarioLaboral", oferta.getHorarioLaboral());
    }

    @Test
    void testGetRemuneracion() {
        assertEquals(1.0F, oferta.getRemuneracion());
    }

    @Test
    void testGetFechaDeAlta() {
        assertEquals(LocalDate.of(1, 1, 1), oferta.getFechaDeAlta());
    }

    @Test
    void testGetKeys() {
        assertEquals("Prueba", oferta.getKeys().get(0).getNombre());
    }

    @Test
    public void addPostulacionTest() {
        TipoPublicacion tipop = new TipoPublicacion("nombre", "descripcion", 1, 1, 1.0F, LocalDate.of(1, 1, 1));
        Keyword[] keys = { new Keyword("Prueba") };
        OfertaLaboral oferta2 = new OfertaLaboral("Nombre2", "Descripcion2", "Ciudad2", Departamentos.CANELONES, "HorarioLaboral2", 1.0F, LocalDate.of(1, 1, 1), tipop, keys, "imagen");
        Postulante post = new Postulante("Nickname", "Nombre", "Apellido", "Email", "contraseña", "imagen", LocalDate.of(1, 1, 1), "Nacionalidad");
        Postulacion postulacion = new Postulacion("h", "h", LocalDate.of(1, 1, 1), oferta2, post);
        DTPostulacion postu = postulacion.getDT();

        oferta2.addPostulacion(postu, oferta2, post);

        assertEquals(1, oferta2.getPostulaciones().length);
    }

    @Test
    public void testGetPostulacion() {
        TipoPublicacion tipop = new TipoPublicacion("nombre", "descripcion", 1, 1, 1.0F, LocalDate.of(1, 1, 1));
        Keyword[] keys = { new Keyword("Prueba") };
        OfertaLaboral oferta2 = new OfertaLaboral("Nombre2", "Descripcion2", "Ciudad2", Departamentos.CANELONES, "HorarioLaboral2", 1.0F, LocalDate.of(1, 1, 1), tipop, keys, "imagen");
        Postulante post = new Postulante("Nickname", "Nombre", "Apellido", "Email", "contraseña", "imagen", LocalDate.of(1, 1, 1), "Nacionalidad");
        Postulacion postulacion = new Postulacion("h", "h", LocalDate.of(1, 1, 1), oferta2, post);
        DTPostulacion postu = postulacion.getDT();

        oferta2.addPostulacion(postu, oferta2, post);
        DTPostulacion dtPostu = oferta2.getPostulacion("Nickname").getDT();

        assertEquals(dtPostu.getPostulante(), post.getNickname());
        assertEquals(dtPostu.getOferta(), oferta2.getNombre());
        assertEquals(dtPostu.getCVReducido(), "h");
        assertEquals(dtPostu.getMotivacion(), "h");
        assertEquals(dtPostu.getFecha(), LocalDate.of(1, 1, 1));
    }

    @Test
    public void testGetPostulaciones() {
        TipoPublicacion tipop = new TipoPublicacion("nombre", "descripcion", 1, 1, 1.0F, LocalDate.of(1, 1, 1));
        Keyword[] keys = { new Keyword("Prueba") };
        OfertaLaboral oferta2 = new OfertaLaboral("Nombre2", "Descripcion2", "Ciudad2", Departamentos.CANELONES, "HorarioLaboral2", 1.0F, LocalDate.of(1, 1, 1), tipop, keys, "imagen");
        Postulante post = new Postulante("Nickname", "Nombre", "Apellido", "Email", "contraseña", "imagen", LocalDate.of(1, 1, 1), "Nacionalidad");
        Postulacion postulacion = new Postulacion("h", "h", LocalDate.of(1, 1, 1), oferta2, post);
        DTPostulacion ostu = postulacion.getDT();

        oferta2.addPostulacion(ostu, oferta2, post);

        Postulacion[] poss = oferta2.getPostulaciones();

        assertEquals(poss.length, 1);
        assertEquals(poss[0].getDT().getCVReducido(), "h");
        assertEquals(poss[0].getDT().getMotivacion(), "h");
        assertEquals(poss[0].getDT().getFecha(), LocalDate.of(1, 1, 1));
        assertEquals(poss[0].getDT().getOferta(), oferta2.getNombre());
        assertEquals(poss[0].getDT().getPostulante(), post.getNickname());
    }

    @Test
    public void testSetNombre() {
    	TipoPublicacion tipop = new TipoPublicacion("nombre", "descripcion", 1, 1, 1.0F, LocalDate.of(1, 1, 1));
        Keyword[] keys = { new Keyword("Prueba") };
        OfertaLaboral oferta2 = new OfertaLaboral("Nombre2", "Descripcion2", "Ciudad2", Departamentos.CANELONES, "HorarioLaboral2", 1.0F, LocalDate.of(1, 1, 1), tipop, keys, "imagen");
        
        oferta2.setNombre("Nombre2");
        assertEquals("Nombre2", oferta2.getNombre());
    }

    @Test
    public void testSetDescripcion() {
    	TipoPublicacion tipop = new TipoPublicacion("nombre", "descripcion", 1, 1, 1.0F, LocalDate.of(1, 1, 1));
        Keyword[] keys = { new Keyword("Prueba") };
        OfertaLaboral oferta2 = new OfertaLaboral("Nombre2", "Descripcion2", "Ciudad2", Departamentos.CANELONES, "HorarioLaboral2", 1.0F, LocalDate.of(1, 1, 1), tipop, keys, "imagen");
        
        oferta2.setDescripcion("Descripcion2");
        assertEquals("Descripcion2", oferta2.getDescripcion());
    }

    @Test
    public void testSetCiudad() {
    	TipoPublicacion tipop = new TipoPublicacion("nombre", "descripcion", 1, 1, 1.0F, LocalDate.of(1, 1, 1));
        Keyword[] keys = { new Keyword("Prueba") };
        OfertaLaboral oferta2 = new OfertaLaboral("Nombre2", "Descripcion2", "Ciudad2", Departamentos.CANELONES, "HorarioLaboral2", 1.0F, LocalDate.of(1, 1, 1), tipop, keys, "imagen");
        
        oferta2.setCiudad("Ciudad2");
        assertEquals("Ciudad2", oferta2.getCiudad());
    }

    @Test
    public void testSetDepartamento() {
    	TipoPublicacion tipop = new TipoPublicacion("nombre", "descripcion", 1, 1, 1.0F, LocalDate.of(1, 1, 1));
        Keyword[] keys = { new Keyword("Prueba") };
        OfertaLaboral oferta2 = new OfertaLaboral("Nombre2", "Descripcion2", "Ciudad2", Departamentos.CANELONES, "HorarioLaboral2", 1.0F, LocalDate.of(1, 1, 1), tipop, keys, "imagen");
        
        oferta2.setDepartamento(Departamentos.CANELONES);
        assertEquals(Departamentos.CANELONES, oferta2.getDepartamento());
    }

    @Test
    public void testSetHorarioLaboral() {
    	TipoPublicacion tipop = new TipoPublicacion("nombre", "descripcion", 1, 1, 1.0F, LocalDate.of(1, 1, 1));
        Keyword[] keys = { new Keyword("Prueba") };
        OfertaLaboral oferta2 = new OfertaLaboral("Nombre2", "Descripcion2", "Ciudad2", Departamentos.CANELONES, "HorarioLaboral2", 1.0F, LocalDate.of(1, 1, 1), tipop, keys, "imagen");
        
        oferta2.setHorarioLaboral("HorarioLaboral2");
        assertEquals("HorarioLaboral2", oferta2.getHorarioLaboral());
    }

    @Test
    public void testSetRemuneracion() {
    	TipoPublicacion tipop = new TipoPublicacion("nombre", "descripcion", 1, 1, 1.0F, LocalDate.of(1, 1, 1));
        Keyword[] keys = { new Keyword("Prueba") };
        OfertaLaboral oferta2 = new OfertaLaboral("Nombre2", "Descripcion2", "Ciudad2", Departamentos.CANELONES, "HorarioLaboral2", 1.0F, LocalDate.of(1, 1, 1), tipop, keys, "imagen");
        
        oferta2.setRemuneracion(1.0F);
        assertEquals(1.0F, oferta2.getRemuneracion());
    }

    @Test
    public void testSetFechaDeAlta() {
    	TipoPublicacion tipop = new TipoPublicacion("nombre", "descripcion", 1, 1, 1.0F, LocalDate.of(1, 1, 1));
        Keyword[] keys = { new Keyword("Prueba") };
        OfertaLaboral oferta2 = new OfertaLaboral("Nombre2", "Descripcion2", "Ciudad2", Departamentos.CANELONES, "HorarioLaboral2", 1.0F, LocalDate.of(1, 1, 1), tipop, keys, "imagen");
        
        LocalDate fecha = LocalDate.of(1, 1, 1);
        oferta2.setFechaDeAlta(fecha);
        assertEquals(fecha, oferta2.getFechaDeAlta());
    }
}
