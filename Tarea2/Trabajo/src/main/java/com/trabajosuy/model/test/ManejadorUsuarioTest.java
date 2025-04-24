package com.trabajosuy.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.trabajosuy.model.logicaclases.Empresa;
import com.trabajosuy.model.logicaclases.Postulante;
import com.trabajosuy.model.logicaclases.Usuario;
import com.trabajosuy.model.logicamanejadores.ManejadorUsuario;

import java.time.LocalDate;

public class ManejadorUsuarioTest {

    private ManejadorUsuario manejador;

    @BeforeEach
    public void setUp() {
        manejador = ManejadorUsuario.getinstance();
    }

    @Test
    public void testAgregarUsuario() {
        Postulante postulante = new Postulante("post1", "Postulante", "Apellido", "emailP", "contraseña", "imagen", LocalDate.now(), "Nacionalidad");
        Empresa empresa = new Empresa("emp1", "Empresa", "Apellido", "emailE", "contraseña", "imagen", "Descripción", "SitioWeb");
        Usuario usuario1 = postulante;
        Usuario usuario2 = empresa;
        manejador.addUsuario(usuario1);
        manejador.addUsuario(usuario2);
        assertEquals(usuario1, manejador.getUsuario("post1"));
        assertEquals(usuario1, manejador.getUsuarioEmai("emailP"));
        assertEquals(usuario2, manejador.getUsuario("emp1"));
        assertEquals(usuario2, manejador.getUsuarioEmai("emailE"));
    }

    @Test
    public void testEliminarUsuario() {
        Postulante postulante = new Postulante("post1", "Postulante", "Apellido", "eemailP", "contraseña", "imagen", LocalDate.now(), "Nacionalidad");
        Empresa empresa = new Empresa("emp1", "Empresa", "Apellido", "emailE", "contraseña", "imagen", "Descripción", "SitioWeb");
        Usuario usuario1 = postulante;
        Usuario usuario2 = empresa;
        manejador.addUsuario(usuario1);
        manejador.deleteUsuario(usuario1);
        manejador.addUsuario(usuario2);
        manejador.deleteUsuario(usuario2);
        assertNull(manejador.getUsuario("post1"));
        assertNull(manejador.getUsuarioEmai("emailP"));
        assertNull(manejador.getUsuario("emp1"));
        assertNull(manejador.getUsuarioEmai("emailE"));
    }

    @Test
    public void testAgregarYObtenerPostulante() {
        Postulante postulante = new Postulante("post1", "Postulante", "Apellido", "emailP", "contraseña", "imagen", LocalDate.now(), "Nacionalidad");
        manejador.reiniciarUsuarios();
        manejador.addUsuario(postulante);
        assertEquals(postulante, manejador.getPostulante("post1"));
        assertTrue(manejador.getPostulantes().length == 1);
    }

    @Test
    public void testAgregarYObtenerEmpresa() {
        Empresa empresa = new Empresa("emp1", "Empresa", "Apellido", "emailE", "contraseña", "imagen", "Descripción", "SitioWeb");
        manejador.reiniciarUsuarios();
        manejador.addUsuario(empresa);
        assertEquals(empresa, manejador.getEmpresa("emp1"));
        assertTrue(manejador.getEmpresas().length == 1);
    }

    @Test
    public void testGetUsuariosSinUsuarios() {
        Usuario[] usuarios = manejador.getUsuarios();
        manejador.reiniciarUsuarios();
        assertNull(usuarios);
    }

    @Test
    public void testGetUsuariosConUsuarios() {
        Postulante postulante1 = new Postulante("post1", "Postulante1", "Apellido1", "postulante1@example.com", "contraseña", "imagen", LocalDate.now(), "Nacionalidad1");
        Empresa empresa2 = new Empresa("emp2", "Empresa2", "Apellido2", "empresa2@example.com", "contraseña", "imagen", "Descripción2", "SitioWeb2");
        Usuario usuario1 = postulante1;
        Usuario usuario2 = empresa2;
        manejador.addUsuario(usuario1);
        manejador.addUsuario(usuario2);

        Usuario[] usuarios = manejador.getUsuarios();
        assertEquals(2, usuarios.length);
        assertTrue(usuarios[0] == usuario1 || usuarios[0] == usuario2);
        assertTrue(usuarios[1] == usuario1 || usuarios[1] == usuario2);
    }

    @Test
    public void testGetPostulantesSinPostulantes() {
        Postulante[] postulantes = manejador.getPostulantes();
        manejador.reiniciarUsuarios();
        postulantes = manejador.getPostulantes();
        assertNull(postulantes);
    }

    @Test
    public void testGetPostulantesConPostulantes() {
        Postulante postulante1 = new Postulante("post1", "Postulante1", "Apellido1", "postulante1@example.com", "contraseña", "imagen", LocalDate.now(), "Nacionalidad1");
        Postulante postulante2 = new Postulante("post2", "Postulante2", "Apellido2", "postulante2@example.com", "contraseña", "imagen", LocalDate.now(), "Nacionalidad2");
        manejador.addUsuario(postulante1);
        manejador.addUsuario(postulante2);

        Postulante[] postulantes = manejador.getPostulantes();
        assertEquals(2, postulantes.length);
        assertTrue(postulantes[0] == postulante1 || postulantes[0] == postulante2);
        assertTrue(postulantes[1] == postulante1 || postulantes[1] == postulante2);
    }

    @Test
    public void testGetEmpresasSinEmpresas() {
        Empresa[] empresas = manejador.getEmpresas();
        manejador.reiniciarUsuarios();
        assertNull(empresas);
    }

    @Test
    public void testGetEmpresasConEmpresas() {
        manejador.reiniciarUsuarios();
        Empresa empresa1 = new Empresa("emp1", "Empresa1", "Apellido1", "empresa1@example.com", "contraseña", "imagen", "Descripción1", "SitioWeb1");
        Empresa empresa2 = new Empresa("emp2", "Empresa2", "Apellido2", "empresa2@example.com", "contraseña", "imagen", "Descripción2", "SitioWeb2");
        manejador.addUsuario(empresa1);
        manejador.addUsuario(empresa2);

        Empresa[] empresas = manejador.getEmpresas();
        assertEquals(2, empresas.length);
        assertTrue(empresas[0] == empresa1 || empresas[0] == empresa2);
        assertTrue(empresas[1] == empresa1 || empresas[1] == empresa2);
    }
}
