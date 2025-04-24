package com.trabajosuy.model.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.trabajosuy.model.logicaclases.Empresa;
import com.trabajosuy.model.logicaclases.Keyword;
import com.trabajosuy.model.logicaclases.OfertaLaboral;
import com.trabajosuy.model.logicaclases.TipoPublicacion;
import com.trabajosuy.model.logicadatatype.DTEmpresa;
import com.trabajosuy.model.logicadatatype.DTOfertaLaboral;
import com.trabajosuy.model.logicaenums.Departamentos;
import com.trabajosuy.model.logicamanejadores.ManejadorOferta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpresaTest {
	
    private Empresa usuario;

    @BeforeEach
    public void iniciar() {
        usuario = new Empresa("nickTestEmpresa", "nombre", "apellido", "email", "contraseña", "imagen", "Descripcion", "SitioWeb");
    }

    @Test
    void testGetNickname() {
        assertEquals("nickTestEmpresa", usuario.getNickname());
    }

    @Test
    void testGetNombre() {
        assertEquals("nombre", usuario.getNombre());
    }

    @Test
    void testGetApellido() {
        assertEquals("apellido", usuario.getApellido());
    }

    @Test
    void testGetEmail() {
        assertEquals("email", usuario.getEmail());
    }

    @Test
    void testGetDescripcion() {
        assertEquals("Descripcion", usuario.getDescripcion());
    }

    @Test
    void getSitioWeb() {
        assertEquals("SitioWeb", usuario.getSitioWeb());
    }

    @Test
    void addPublicacionOfertaTest() {
        Keyword key = new Keyword("key1");
        Keyword[] keylist = {key};
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        manejadorOf.addKeyword(key);
        OfertaLaboral ofLab = new OfertaLaboral("NOL", "Descripcion", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 0f, LocalDate.of(1, 1, 1), new TipoPublicacion("tp", "descTP", 1, 1, 1, null), keylist, "imagen");
        manejadorOf.addOferta(ofLab);
        Empresa usuario2 = new Empresa("nick2", "nombre", "apellido", "email2", "contraseña", "imagen", "Descripcion", "SitioWeb");
        usuario2.addPublicacionOferta("NOL");
        assertEquals(1, usuario2.getPublicaciones().size());
        usuario2.getPublicaciones().get(0).getDTOfertaPublicada();
        assertEquals(ofLab.getNombre(), usuario2.getPublicaciones().get(0).getDTOfertaPublicada().getNombre());
    }

    @Test
    void listarOfertasTest() {
        Empresa usuario3 = new Empresa("nick3", "nombre", "apellido", "email3", "contraseña", "imagen", "Descripcion", "SitioWeb");
        Keyword[] keylist = {};
        OfertaLaboral ofLab = new OfertaLaboral("NOL", "Descripcion", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 0f, LocalDate.of(1, 1, 1), new TipoPublicacion("tp", "descTP", 1, 1, 1, null), keylist, "imagen");
        OfertaLaboral ofLab2 = new OfertaLaboral("NOL2", "Descripcion", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 0f, LocalDate.of(1, 1, 1), new TipoPublicacion("tp", "descTP", 1, 1, 1, null), keylist, "imagen");
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        manejadorOf.addOferta(ofLab);
        manejadorOf.addOferta(ofLab2);
        usuario3.addPublicacionOferta(ofLab.getNombre());
        usuario3.addPublicacionOferta(ofLab2.getNombre());
        List<DTOfertaLaboral> resEsp = new ArrayList<>();
        resEsp.add(ofLab.getDT());
        resEsp.add(ofLab2.getDT());
        List<DTOfertaLaboral> resFun = usuario3.listarOfertas();
        assertEquals(resFun.size(), resEsp.size());
        assertEquals(resFun.get(0).getNombre(), resEsp.get(0).getNombre());
        assertEquals(resFun.get(0).getCiudad(), resEsp.get(0).getCiudad());
        assertEquals(resFun.get(0).getDepartamento(), resEsp.get(0).getDepartamento());
        assertEquals(resFun.get(0).getDescripcion(), resEsp.get(0).getDescripcion());
        assertEquals(resFun.get(0).getFechaDeAlta(), resEsp.get(0).getFechaDeAlta());
        assertEquals(resFun.get(0).getRemuneracion(), resEsp.get(0).getRemuneracion());
    }

    @Test
    void listarOfertasVigentesTest() {
        Empresa usuario3 = new Empresa("nick3", "nombre", "apellido", "email3", "contraseña", "imagen", "Descripcion", "SitioWeb");
        Keyword[] keylist = {};
        OfertaLaboral ofLab = new OfertaLaboral("NOLvigente", "Descripcion", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 0f, LocalDate.of(2023, 1, 1), new TipoPublicacion("tp", "descTP", 1, 1000, 1, null), keylist, "imagen");
        OfertaLaboral ofLab2 = new OfertaLaboral("NOLnovigente", "Descripcion", "Ciudad", Departamentos.ARTIGAS, "HorarioLaboral", 0f, LocalDate.of(2023, 1, 1), new TipoPublicacion("tp", "descTP", 1, 1, 1, null), keylist, "imagen");
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        manejadorOf.addOferta(ofLab);
        manejadorOf.addOferta(ofLab2);
        usuario3.addPublicacionOferta(ofLab.getNombre());
        usuario3.addPublicacionOferta(ofLab2.getNombre());
        List<DTOfertaLaboral> resEsp = new ArrayList<>();
        resEsp.add(ofLab.getDT());
        resEsp.add(ofLab2.getDT());
        List<DTOfertaLaboral> resFun = usuario3.listarOfertasVigentes();
        assertEquals(resFun.size(), 1);
        assertEquals(resFun.get(0).getNombre(), resEsp.get(0).getNombre());
        assertEquals(resFun.get(0).getCiudad(), resEsp.get(0).getCiudad());
        assertEquals(resFun.get(0).getDepartamento(), resEsp.get(0).getDepartamento());
        assertEquals(resFun.get(0).getDescripcion(), resEsp.get(0).getDescripcion());
        assertEquals(resFun.get(0).getFechaDeAlta(), resEsp.get(0).getFechaDeAlta());
        assertEquals(resFun.get(0).getRemuneracion(), resEsp.get(0).getRemuneracion());
    }

    @Test
    void getDTTest() {
        DTEmpresa dtEmpresa = usuario.getDT();
        assertEquals(usuario.getNickname(), dtEmpresa.getNickname());
        assertEquals(usuario.getNombre(), dtEmpresa.getNombre());
        assertEquals(usuario.getApellido(), dtEmpresa.getApellido());
        assertEquals(usuario.getDescripcion(), dtEmpresa.getDescripcion());
        assertEquals(usuario.getEmail(), dtEmpresa.getEmail());
        assertEquals(usuario.getSitioWeb(), dtEmpresa.getSitioWeb());
        assertEquals(usuario.getContrasena(), dtEmpresa.getContrasena());
    }
}
