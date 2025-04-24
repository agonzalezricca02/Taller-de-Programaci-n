package com.trabajosuy.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.trabajosuy.model.logicaclases.Empresa;
import com.trabajosuy.model.logicaclases.Postulante;
import com.trabajosuy.model.logicaclases.Usuario;
import java.time.LocalDate;

public class UsuarioTest {
    private Usuario usuarioEmpresa;
    private Usuario usuarioPostulante;

    @BeforeEach
    public void setUp() {
        usuarioEmpresa = new Empresa("nickE", "NombreE", "ApellidoE", "emailE", "contraseña", "imagen", "Descripcion", "SitioWeb");
        usuarioPostulante = new Postulante("nickP", "NombreP", "ApellidoP", "emailP", "contraseña", "imagen", LocalDate.now(), "Oriental");
    }

    // Pruebas para Usuario
    @Test
    public void testUsuarioGetNickname() {
        assertEquals("nickE", usuarioEmpresa.getNickname());
        assertEquals("nickP", usuarioPostulante.getNickname());
    }

    @Test
    public void testUsuarioGetNombre() {
        assertEquals("NombreE", usuarioEmpresa.getNombre());
        assertEquals("NombreP", usuarioPostulante.getNombre());
    }

    @Test
    public void testUsuarioGetApellido() {
        assertEquals("ApellidoE", usuarioEmpresa.getApellido());
        assertEquals("ApellidoP", usuarioPostulante.getApellido());
    }

    @Test
    public void testUsuarioGetEmail() {
        assertEquals("emailE", usuarioEmpresa.getEmail());
        assertEquals("emailP", usuarioPostulante.getEmail());
    }
    public void testUsuarioGetContrasena() {
        assertEquals("contraseña", usuarioEmpresa.getContrasena());
        assertEquals("contraseña", usuarioPostulante.getContrasena());
    }
    
   

    // Pruebas para Empresa
    @Test
    public void testEmpresaGetDescripcion() {
        assertEquals("Descripcion", ((Empresa) usuarioEmpresa).getDescripcion());
    }

    @Test
    public void testEmpresaGetSitioWeb() {
        assertEquals("SitioWeb", ((Empresa) usuarioEmpresa).getSitioWeb());
    }

    // Pruebas para Postulante
    @Test
    public void testPostulanteGetFechaNacimiento() {
        assertEquals(LocalDate.now(), ((Postulante) usuarioPostulante).getFechaNacimiento());
    }

    @Test
    public void testPostulanteGetNacionalidad() {
        assertEquals("Oriental", ((Postulante) usuarioPostulante).getNacionalidad());
    }
    
    @Test
    public void testUsuarioSetNickname() {
        usuarioEmpresa.setNickname("nuevoNickE");
        usuarioPostulante.setNickname("nuevoNickP");
        assertEquals("nuevoNickE", usuarioEmpresa.getNickname());
        assertEquals("nuevoNickP", usuarioPostulante.getNickname());
    }

    @Test
    public void testUsuarioSetNombre() {
        usuarioEmpresa.setNombre("NuevoNombreE");
        usuarioPostulante.setNombre("NuevoNombreP");
        assertEquals("NuevoNombreE", usuarioEmpresa.getNombre());
        assertEquals("NuevoNombreP", usuarioPostulante.getNombre());
    }

    @Test
    public void testUsuarioSetApellido() {
        usuarioEmpresa.setApellido("NuevoApellidoE");
        usuarioPostulante.setApellido("NuevoApellidoP");
        assertEquals("NuevoApellidoE", usuarioEmpresa.getApellido());
        assertEquals("NuevoApellidoP", usuarioPostulante.getApellido());
    }

    @Test
    public void testUsuarioSetEmail() {
        usuarioEmpresa.setEmail("nuevoEmailE");
        usuarioPostulante.setEmail("nuevoEmailP");
        assertEquals("nuevoEmailE", usuarioEmpresa.getEmail());
        assertEquals("nuevoEmailP", usuarioPostulante.getEmail());
    }
    @Test
    public void testUsuarioSetContrasena() {
        usuarioEmpresa.setContrasena("Contraseña");
        usuarioPostulante.setContrasena("Contraseña");
        assertEquals("contraseña", usuarioEmpresa.getContrasena());
        assertEquals("contraseña", usuarioPostulante.getContrasena());
    }
}