package com.trabajosuy.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.trabajosuy.model.excepciones.UsuarioNoExisteException;
import com.trabajosuy.model.excepciones.UsuarioRepetidoException;
import com.trabajosuy.model.logicaclases.Empresa;
import com.trabajosuy.model.logicaclases.Keyword;
import com.trabajosuy.model.logicaclases.OfertaLaboral;
import com.trabajosuy.model.logicaclases.Postulante;
import com.trabajosuy.model.logicaclases.TipoPublicacion;
import com.trabajosuy.model.logicacontroladores.ControladorUsuario;
import com.trabajosuy.model.logicadatatype.DTEmpresa;
import com.trabajosuy.model.logicadatatype.DTPostulante;
import com.trabajosuy.model.logicadatatype.DTUsuario;
import com.trabajosuy.model.logicaenums.Departamentos;
import com.trabajosuy.model.logicamanejadores.ManejadorOferta;
import com.trabajosuy.model.logicamanejadores.ManejadorUsuario;

public class ControladorUsuarioTest {

    @Test
    void getUsuariosTest() {
        ControladorUsuario ctrlUsu = new ControladorUsuario();
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        manejadorUsr.reiniciarUsuarios();
        manejadorUsr.addUsuario(new Empresa("nick", "nombre", "apellido", "email", "contraseña", "imagen", "descripcion", "sitioweb"));

        try {
            DTUsuario[] dts = ctrlUsu.getUsuarios();
            assertEquals(dts[0].getNickname(), "nick");
            assertEquals(dts[0].getNombre(), "nombre");
            assertEquals(dts[0].getApellido(), "apellido");
            assertEquals(dts[0].getEmail(), "email");
            assertEquals(dts[0].getContrasena(), "contraseña");
            assertEquals(((DTEmpresa) dts[0]).getDescripcion(), "descripcion");
            assertEquals(((DTEmpresa) dts[0]).getSitioWeb(), "sitioweb");

        } catch (UsuarioNoExisteException e) {
            fail(e.getMessage());
            e.printStackTrace();
        }
        ;
    }

    @Test
    void getUsuariosTestVacio() {
        ControladorUsuario ctrlUsu = new ControladorUsuario();
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        manejadorUsr.reiniciarUsuarios();
        assertThrows(UsuarioNoExisteException.class, () -> {
            ctrlUsu.getUsuarios();
        });
    }

    @Test
    void listarEmpresasTest() {
        ControladorUsuario ctrlUsu = new ControladorUsuario();
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        manejadorUsr.reiniciarUsuarios();
        manejadorUsr.addUsuario(new Empresa("nick", "nombre", "apellido", "email", "contraseña", "imagen", "descripcion", "sitioweb"));

        try {
            DTUsuario[] dts = ctrlUsu.listarEmpresas();
            assertEquals(dts[0].getNickname(), "nick");
            assertEquals(dts[0].getNombre(), "nombre");
            assertEquals(dts[0].getApellido(), "apellido");
            assertEquals(dts[0].getEmail(), "email");
            assertEquals(((DTEmpresa) dts[0]).getDescripcion(), "descripcion");
            assertEquals(((DTEmpresa) dts[0]).getSitioWeb(), "sitioweb");

        } catch (UsuarioNoExisteException e) {
            fail(e.getMessage());
            e.printStackTrace();
        }
        ;
    }

    @Test
    void getEmpresasTestVacio() {
        ControladorUsuario ctrlUsu = new ControladorUsuario();
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        manejadorUsr.reiniciarUsuarios();
        assertThrows(UsuarioNoExisteException.class, () -> {
            ctrlUsu.listarEmpresas();
        });
    }

    @Test
    void getPostulantesTest() {
        ControladorUsuario ctrlUsu = new ControladorUsuario();
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        manejadorUsr.reiniciarUsuarios();
        manejadorUsr.addUsuario(new Postulante("nick", "nombre", "apellido", "email", "contraseña", "imagen", LocalDate.of(1, 1, 1), "nacionalidad"));

        try {
            DTUsuario[] dts = ctrlUsu.listarPostulantes();
            assertEquals(dts[0].getNickname(), "nick");
            assertEquals(dts[0].getNombre(), "nombre");
            assertEquals(dts[0].getApellido(), "apellido");
            assertEquals(dts[0].getEmail(), "email");
            assertEquals(dts[0].getContrasena(), "contraseña");
            assertEquals(((DTPostulante) dts[0]).getFechaNacimiento(), LocalDate.of(1, 1, 1));
            assertEquals(((DTPostulante) dts[0]).getNacionalidad(), "nacionalidad");

        } catch (UsuarioNoExisteException e) {
            fail(e.getMessage());
            e.printStackTrace();
        }
        ;
    }

    @Test
    void getPostulantesTestVacio() {
        ControladorUsuario ctrlUsu = new ControladorUsuario();
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        manejadorUsr.reiniciarUsuarios();
        assertThrows(UsuarioNoExisteException.class, () -> {
            ctrlUsu.listarPostulantes();
        });
    }

    @Test
    void altaUsuariosTestEmpresa() {
        ControladorUsuario ctrlUsu = new ControladorUsuario();
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        manejadorUsr.reiniciarUsuarios();
        DTEmpresa dtu = (new Empresa("nick", "nombre", "apellido", "email", "contraseña", "imagen", "descripcion", "sitioweb")).getDT();

        try {
            ctrlUsu.altaUsuario(dtu);
            assertEquals(1, manejadorUsr.getUsuarios().length);
            DTEmpresa dts = ((Empresa) manejadorUsr.getUsuarios()[0]).getDT();

            assertEquals(dts.getNickname(), dtu.getNickname());
            assertEquals(dts.getNombre(), dtu.getNombre());
            assertEquals(dts.getApellido(), dtu.getApellido());
            assertEquals(dts.getEmail(), dtu.getEmail());
            assertEquals(dts.getContrasena(), dtu.getContrasena());
            assertEquals(dts.getDescripcion(), dtu.getDescripcion());
            assertEquals(dts.getSitioWeb(), dtu.getSitioWeb());

        } catch (UsuarioRepetidoException e) {
            fail(e.getMessage());
            e.printStackTrace();
        }
        ;
    }

    @Test
    void altaUsuariosTestPostulante() {
        ControladorUsuario ctrlUsu = new ControladorUsuario();
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        manejadorUsr.reiniciarUsuarios();
        DTPostulante dtu = (new Postulante("nick", "nombre", "apellido", "email", "contraseña", "imagen", LocalDate.of(1, 1, 1), "nacionalidad")).getDT();

        try {
            ctrlUsu.altaUsuario(dtu);
            assertEquals(1, manejadorUsr.getUsuarios().length);
            DTPostulante dts = ((Postulante) manejadorUsr.getUsuarios()[0]).getDT();

            assertEquals(dts.getNickname(), dtu.getNickname());
            assertEquals(dts.getNombre(), dtu.getNombre());
            assertEquals(dts.getApellido(), dtu.getApellido());
            assertEquals(dts.getEmail(), dtu.getEmail());
            assertEquals(dts.getContrasena(), dtu.getContrasena());
            assertEquals(dts.getFechaNacimiento(), dtu.getFechaNacimiento());
            assertEquals(dts.getNacionalidad(), dtu.getNacionalidad());

        } catch (UsuarioRepetidoException e) {
            fail(e.getMessage());
            e.printStackTrace();
        }
        ;
    }

    @Test
    void altaUsuariosTestRepetidoNick() {
        ControladorUsuario ctrlUsu = new ControladorUsuario();
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        manejadorUsr.reiniciarUsuarios();

        try {
            ctrlUsu.altaUsuario((new Empresa("nick", "nombre", "apellido", "email", "contraseña", "imagen", "descripcion", "sitioweb")).getDT());
        } catch (UsuarioRepetidoException e) {
            fail(e.getMessage());
            e.printStackTrace();
        }
        ;

        assertThrows(UsuarioRepetidoException.class, () -> {
            ctrlUsu.altaUsuario((new Empresa("nick", "nombre", "apellido", "email2", "contraseña", "imagen", "descripcion", "sitioweb")).getDT());
        });
    }

    @Test
    void altaUsuariosTestRepetidoMail() {
        ControladorUsuario ctrlUsu = new ControladorUsuario();
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        manejadorUsr.reiniciarUsuarios();

        try {
            ctrlUsu.altaUsuario((new Empresa("nick", "nombre", "apellido", "email", "contraseña", "imagen", "descripcion", "sitioweb")).getDT());
        } catch (UsuarioRepetidoException e) {
            fail(e.getMessage());
            e.printStackTrace();
        }
        ;

        assertThrows(UsuarioRepetidoException.class, () -> {
            ctrlUsu.altaUsuario((new Empresa("nick2", "nombre", "apellido", "email", "contraseña", "imagen", "descripcion", "sitioweb")).getDT());
        });
    }

    @Test
    void linkearEmpresaPublicacionTest() {
        ControladorUsuario ctrlUsu = new ControladorUsuario();
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        manejadorOf.reiniciarManejador();
        manejadorUsr.reiniciarUsuarios();

        Keyword[] kws = {};
        OfertaLaboral ofLab = new OfertaLaboral("nombreof", "descripcion", "ciudad", Departamentos.ARTIGAS, "horario", 5f, LocalDate.of(1, 1, 1), new TipoPublicacion("nTP", "dTP", 1, 1, 1f, LocalDate.of(1, 1, 1)), kws, "imagen");
        manejadorOf.addOferta(ofLab);

        try {
            ctrlUsu.altaUsuario((new Empresa("nick", "nombre", "apellido", "email", "contraseña", "imagen", "descripcion", "sitioweb")).getDT());
        } catch (UsuarioRepetidoException e) {
            System.out.println("nop");
        }
        Empresa emp = (Empresa) manejadorUsr.getUsuarios()[0];

        ctrlUsu.linkearEmpresaPublicacion(emp.getNickname(), ofLab.getNombre());
        assertEquals(emp.getPublicaciones().get(0).getOfertaPublicada(), ofLab);
    }
}
