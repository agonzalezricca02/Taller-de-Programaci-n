package com.trabajosuy.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import com.trabajosuy.model.logicaclases.TipoPublicacion;
import com.trabajosuy.model.logicadatatype.DTOfertaLaboral;
import com.trabajosuy.model.logicaenums.Departamentos;
import com.trabajosuy.model.logicaenums.Estados;

public class DTOfertaLaboralTest {

   private TipoPublicacion tipop = new TipoPublicacion("nombre", "descripcion", 1, 1, 1.0F, LocalDate.of(1, 1, 1));

    @Test
    public void testGetNombre() {
        DTOfertaLaboral dtOferta = new DTOfertaLaboral("Nombre", "Descripción", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, LocalDate.now(), Estados.CONFIRMADA, new String[]{"Keyword"}, tipop, "imagen");
        assertEquals("Nombre", dtOferta.getNombre());
    }

    @Test
    public void testGetDescripcion() {
        DTOfertaLaboral dtOferta = new DTOfertaLaboral("Nombre", "Descripción", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, LocalDate.now(), Estados.CONFIRMADA, new String[]{"Keyword"}, tipop, "imagen");
        assertEquals("Descripción", dtOferta.getDescripcion());
    }

    @Test
    public void testGetCiudad() {
        DTOfertaLaboral dtOferta = new DTOfertaLaboral("Nombre", "Descripción", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, LocalDate.now(), Estados.CONFIRMADA, new String[]{"Keyword"}, tipop, "imagen");
        assertEquals("Ciudad", dtOferta.getCiudad());
    }

    @Test
    public void testGetDepartamento() {
        DTOfertaLaboral dtOferta = new DTOfertaLaboral("Nombre", "Descripción", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, LocalDate.now(), Estados.CONFIRMADA, new String[]{"Keyword"}, tipop, "imagen");
        assertEquals(Departamentos.ARTIGAS, dtOferta.getDepartamento());
    }

    @Test
    public void testGetHorarioLaboral() {
        DTOfertaLaboral dtOferta = new DTOfertaLaboral("Nombre", "Descripción", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, LocalDate.now(), Estados.CONFIRMADA, new String[]{"Keyword"}, tipop, "imagen");
        assertEquals("HorarioLaboral", dtOferta.getHorarioLaboral());
    }

    @Test
    public void testGetRemuneracion() {
        DTOfertaLaboral dtOferta = new DTOfertaLaboral("Nombre", "Descripción", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, LocalDate.now(), Estados.CONFIRMADA, new String[]{"Keyword"}, tipop, "imagen");
        assertEquals(1.0F, dtOferta.getRemuneracion());
    }

    @Test
    public void testGetFechaDeAlta() {
        LocalDate fecha = LocalDate.now();
        DTOfertaLaboral dtOferta = new DTOfertaLaboral("Nombre", "Descripción", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, fecha, Estados.CONFIRMADA, new String[]{"Keyword"}, tipop, "imagen");
        assertEquals(fecha, dtOferta.getFechaDeAlta());
    }

    @Test
    public void testGetKeywords() {
        DTOfertaLaboral dtOferta = new DTOfertaLaboral("Nombre", "Descripción", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, LocalDate.now(), Estados.CONFIRMADA, new String[]{"Keyword"}, tipop, "imagen");
        assertArrayEquals(new String[]{"Keyword"}, dtOferta.getKeywords());
    }

    @Test
    public void testToString() {
        DTOfertaLaboral dtOferta = new DTOfertaLaboral("Nombre", "Descripción", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, LocalDate.now(), Estados.CONFIRMADA, new String[]{"Keyword"}, tipop, "imagen");
        assertEquals("Nombre", dtOferta.toString());
    }

    @Test
    public void testSetNombre() {
        DTOfertaLaboral dtOferta = new DTOfertaLaboral("Nombre", "Descripción", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, LocalDate.now(), Estados.CONFIRMADA, new String[]{"Keyword"}, tipop, "imagen");
        dtOferta.setNombre("NuevoNombre");
        assertEquals("NuevoNombre", dtOferta.getNombre());
    }

    @Test
    public void testSetDescripcion() {
        DTOfertaLaboral dtOferta = new DTOfertaLaboral("Nombre", "Descripción", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, LocalDate.now(), Estados.CONFIRMADA, new String[]{"Keyword"}, tipop, "imagen");
        dtOferta.setDescripcion("NuevaDescripción");
        assertEquals("NuevaDescripción", dtOferta.getDescripcion());
    }

    @Test
    public void testSetCiudad() {
        DTOfertaLaboral dtOferta = new DTOfertaLaboral("Nombre", "Descripción", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, LocalDate.now(), Estados.CONFIRMADA, new String[]{"Keyword"}, tipop, "imagen");
        dtOferta.setCiudad("NuevaCiudad");
        assertEquals("NuevaCiudad", dtOferta.getCiudad());
    }

    @Test
    public void testSetDepartamento() {
        DTOfertaLaboral dtOferta = new DTOfertaLaboral("Nombre", "Descripción", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, LocalDate.now(), Estados.CONFIRMADA, new String[]{"Keyword"}, tipop, "imagen");
        dtOferta.setDepartamento(Departamentos.MONTEVIDEO);
        assertEquals(Departamentos.MONTEVIDEO, dtOferta.getDepartamento());
    }

    @Test
    public void testSetHorarioLaboral() {
        DTOfertaLaboral dtOferta = new DTOfertaLaboral("Nombre", "Descripción", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, LocalDate.now(), Estados.CONFIRMADA, new String[]{"Keyword"}, tipop, "imagen");
        dtOferta.setHorarioLaboral("NuevoHorario");
        assertEquals("NuevoHorario", dtOferta.getHorarioLaboral());
    }

    @Test
    public void testSetRemuneracion() {
        DTOfertaLaboral dtOferta = new DTOfertaLaboral("Nombre", "Descripción", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, LocalDate.now(), Estados.CONFIRMADA, new String[]{"Keyword"}, tipop, "imagen");
        dtOferta.setRemuneracion(2.0F);
        assertEquals(2.0F, dtOferta.getRemuneracion());
    }

    @Test
    public void testSetFechaDeAlta() {
        LocalDate fecha = LocalDate.now();
        DTOfertaLaboral dtOferta = new DTOfertaLaboral("Nombre", "Descripción", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, fecha, Estados.CONFIRMADA, new String[]{"Keyword"}, tipop, "imagen");
        LocalDate nuevaFecha = LocalDate.of(2023, 1, 1);
        dtOferta.setFechaDeAlta(nuevaFecha);
        assertEquals(nuevaFecha, dtOferta.getFechaDeAlta());
    }

    @Test
    public void testSetKeywords() {
        LocalDate fecha = LocalDate.now();
        DTOfertaLaboral dtOferta = new DTOfertaLaboral("Nombre", "Descripción", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 1.0F, fecha, Estados.CONFIRMADA, new String[]{"Keyword"}, tipop, "imagen");
        String[] nuevosKeywords = {"NuevoKeyword"};
        dtOferta.setKeywords(nuevosKeywords);
        assertArrayEquals(nuevosKeywords, dtOferta.getKeywords());
    }
    

}
