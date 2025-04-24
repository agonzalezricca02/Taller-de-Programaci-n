package com.trabajosuy.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

import com.trabajosuy.model.excepciones.KeywordRepetidaException;
import com.trabajosuy.model.excepciones.OfertaExpiradaException;
import com.trabajosuy.model.excepciones.OfertaRepetidaException;
import com.trabajosuy.model.excepciones.PostulacionRepetidaException;
import com.trabajosuy.model.excepciones.TipoPublicacionRepetidaException;
import com.trabajosuy.model.excepciones.UsuarioRepetidoException;
import com.trabajosuy.model.logicaclases.Empresa;
import com.trabajosuy.model.logicaclases.Keyword;
import com.trabajosuy.model.logicacontroladores.ControladorOferta;
import com.trabajosuy.model.logicacontroladores.ControladorUsuario;
import com.trabajosuy.model.logicadatatype.DTEmpresa;
import com.trabajosuy.model.logicadatatype.DTOfertaLaboral;
import com.trabajosuy.model.logicadatatype.DTPostulacion;
import com.trabajosuy.model.logicadatatype.DTPostulante;
import com.trabajosuy.model.logicadatatype.DTTipoPublicacion;
import com.trabajosuy.model.logicaenums.Departamentos;
import com.trabajosuy.model.logicamanejadores.ManejadorOferta;
import com.trabajosuy.model.logicamanejadores.ManejadorUsuario;

public class ControladorOfertaTest {

    @Test
    public void testListarOfertas() {
        ControladorOferta controladorOferta = new ControladorOferta();
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        manejadorUsr.reiniciarUsuarios();
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        manejadorOf.reiniciarManejador();

        try {
            controladorUsuario.altaUsuario(new DTEmpresa("", "", "", "MailEmpresa", "contraseña", "imagen", "", ""));
        } catch (UsuarioRepetidoException e) {
        	e.printStackTrace();
        }
        Empresa emp = (Empresa) manejadorUsr.getEmpresa("");

        try {
            controladorOferta.altaTipoPublicacion(new DTTipoPublicacion("", "", 0, 0, 0, null));
        } catch (TipoPublicacionRepetidaException e) {
            e.printStackTrace();
        }

        try {
            controladorOferta.altaOferta("", "", "", "", "", Departamentos.ARTIGAS, "", 0f, null, new String[0], "imagen");
        } catch (OfertaRepetidaException e) {
            e.printStackTrace();
        }

        DTOfertaLaboral[] ofertas = controladorOferta.listarOfertasUsuario(emp.getNickname());

        assertNotNull(ofertas);
        assertEquals(ofertas.length, 1);
        assertEquals(emp.getPublicaciones().get(0).getOfertaPublicada().getNombre(), ofertas[0].getNombre());
    }

    @Test
    public void testListarOfertasPost() {
        ControladorOferta controladorOferta = new ControladorOferta();
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        manejadorUsr.reiniciarUsuarios();
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        manejadorOf.reiniciarManejador();

        try {
            controladorUsuario.altaUsuario(new DTPostulante("NickPost", "", "", "MailPost", "contraseña", "imagen", null, ""));
        } catch (UsuarioRepetidoException e) {
        	e.printStackTrace();
        }

        try {
            controladorUsuario.altaUsuario(new DTEmpresa("NickEmp", "", "", "MailEmpresa", "contraseña", "imagen", "", ""));
        } catch (UsuarioRepetidoException e) {
        	e.printStackTrace();
        }
        try {
            controladorOferta.altaTipoPublicacion(new DTTipoPublicacion("tp", "", 0, 10, 0, LocalDate.now()));
        } catch (TipoPublicacionRepetidaException e) {
            e.printStackTrace();
        }

        try {
            controladorOferta.altaOferta("NickEmp", "tp", "ol", "", "", Departamentos.ARTIGAS, "", 0f, LocalDate.now(), new String[0], "imagen");
        } catch (OfertaRepetidaException e) {
            e.printStackTrace();
        }

        try {
            controladorOferta.altaPostulacion("NickPost", "ol", "", "", LocalDate.now());
        } catch (PostulacionRepetidaException e) {
            e.printStackTrace();
        } catch (OfertaExpiradaException e) {
            e.printStackTrace();
        }

        DTOfertaLaboral[] ofertas = controladorOferta.listarOfertasUsuario("NickPost");

        assertNotNull(ofertas);
        assertEquals(ofertas.length, 1);
    }

    @Test
    public void testListarOfertasVacio() {
        ControladorOferta controladorOferta = new ControladorOferta();
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        manejadorUsr.reiniciarUsuarios();
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        manejadorOf.reiniciarManejador();

        try {
            controladorUsuario.altaUsuario(new DTEmpresa("", "", "", "MailEmpresa", "contraseña", "imagen", "", ""));
        } catch (UsuarioRepetidoException e) {
        	e.printStackTrace();
        }
        Empresa emp = (Empresa) manejadorUsr.getEmpresa("");

        DTOfertaLaboral[] ofertas = controladorOferta.listarOfertasUsuario(emp.getNickname());

        assertNotNull(ofertas);
        assertEquals(ofertas.length, 0);
    }

    @Test
    public void testListarOfertasVigentes() {
        ControladorOferta controladorOferta = new ControladorOferta();
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        manejadorUsr.reiniciarUsuarios();
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        manejadorOf.reiniciarManejador();

        try {
            controladorUsuario.altaUsuario(new DTEmpresa("", "", "", "MailEmpresa", "contraseña", "imagen", "", ""));
        } catch (UsuarioRepetidoException e) {
        	e.printStackTrace();
        }
        Empresa emp = (Empresa) manejadorUsr.getEmpresa("");

        try {
            controladorOferta.altaTipoPublicacion(new DTTipoPublicacion("", "", 0, 2, 0, null));
        } catch (TipoPublicacionRepetidaException e) {
            e.printStackTrace();
        }

        try {
            controladorOferta.altaOferta("", "", "ol1", "", "", Departamentos.ARTIGAS, "", 0f, LocalDate.now().minus(10, ChronoUnit.DAYS), new String[0], "imagen");
            controladorOferta.altaOferta("", "", "ol2", "", "", Departamentos.ARTIGAS, "", 0f, LocalDate.now(), new String[0], "imagen");
        } catch (OfertaRepetidaException e) {
            e.printStackTrace();
        }

        DTOfertaLaboral[] ofertas = controladorOferta.listarOfertasVigentes(emp.getNickname());

        assertNotNull(ofertas);
        assertEquals(ofertas.length, 1);
    }

    @Test
    public void testListarTiposPublicacion() {
        ControladorOferta controladorOferta = new ControladorOferta();
        DTTipoPublicacion[] tiposPublicacion = controladorOferta.listarTiposPublicacion();

        assertNotNull(tiposPublicacion);
        assertTrue(tiposPublicacion.length > 0);
    }

    @Test
    public void testListarKeywords() throws KeywordRepetidaException {
        ControladorOferta controladorOferta = new ControladorOferta();
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        manejadorOf.reiniciarManejador();
        Keyword keyword1 = new Keyword("Cajero");
        Keyword keyword2 = new Keyword("Chofer");
        String Skeyword1 = "Cajero";
        String Skeyword2 = "Chofer";
        controladorOferta.altaKeyword(Skeyword1);
        controladorOferta.altaKeyword(Skeyword2);
        manejadorOf.addKeyword(keyword1);
        manejadorOf.addKeyword(keyword2);
        assertEquals(keyword1, manejadorOf.getKeyword(Skeyword1));
        assertEquals(keyword2, manejadorOf.getKeyword(Skeyword2));
        String[] keywords = controladorOferta.listarKeywords();

        assertNotNull(keywords);
        assertTrue(keywords.length == 2);
    }

    @Test
    public void testAltaKeyword() throws KeywordRepetidaException {
        ControladorOferta controladorOferta = new ControladorOferta();
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        manejadorOf.reiniciarManejador();

        Keyword keyword1 = new Keyword("Cajero");
        Keyword keyword2 = new Keyword("Chofer");
        String Skeyword1 = "Cajero";
        String Skeyword2 = "Chofer";

        controladorOferta.altaKeyword(Skeyword1);
        controladorOferta.altaKeyword(Skeyword2);

        manejadorOf.addKeyword(keyword1);
        manejadorOf.addKeyword(keyword2);

        assertEquals(keyword1, manejadorOf.getKeyword(Skeyword1));
        assertEquals(keyword2, manejadorOf.getKeyword(Skeyword2));

        assertThrows(KeywordRepetidaException.class, () -> {
            controladorOferta.altaKeyword(Skeyword1);
        });
    }

    @Test
    public void testAltaTipoPublicacion() {
        ControladorOferta controladorOferta = new ControladorOferta();
        DTTipoPublicacion tipoPublicacion = new DTTipoPublicacion("NuevoTipo", "Descripción", 5, 30, 100.0f, LocalDate.now());

        assertDoesNotThrow(() -> {
            controladorOferta.altaTipoPublicacion(tipoPublicacion);
        });

        assertThrows(TipoPublicacionRepetidaException.class, () -> {
            controladorOferta.altaTipoPublicacion(tipoPublicacion);
        });
    }

    @Test
    public void testAltaOferta() {
        ControladorOferta controladorOferta = new ControladorOferta();
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        manejadorOf.reiniciarManejador();

        String empresa = "NombreEmpresa"; // Reemplaza con el nombre de una empresa existente
        String tipoPublicacion = "TipoPublicacion"; // Reemplaza con un tipo de publicación existente
        String nombre = "NuevaOferta";
        String descripcion = "Descripción";
        String ciudad = "Ciudad";
        Departamentos departamento = Departamentos.MONTEVIDEO;
        String horario = "Horario";
        float remuneracion = 1000.0f;
        LocalDate fechaDeAlta = LocalDate.now();
        String[] keywords = { "Keyword1", "Keyword2" }; // Reemplaza con palabras clave existentes

        ControladorUsuario controladorUsr = new ControladorUsuario();
        try {
            controladorUsr.altaUsuario((new Empresa(empresa, "", "", "", "contraseña", "imagen", "", "")).getDT());
        } catch (UsuarioRepetidoException e) {
        	e.printStackTrace();
        }

        assertDoesNotThrow(() -> {
            controladorOferta.altaOferta(empresa, tipoPublicacion, nombre, descripcion, ciudad, departamento, horario, remuneracion, fechaDeAlta, keywords, "imagen");
        });

        assertThrows(OfertaRepetidaException.class, () -> {
            controladorOferta.altaOferta(empresa, tipoPublicacion, nombre, descripcion, ciudad, departamento, horario, remuneracion, fechaDeAlta, keywords, "imagen");
        });
    }

    @Test
    public void testAltaPostulacion() {
        ControladorOferta controladorOferta = new ControladorOferta();
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        manejadorUsr.reiniciarUsuarios();
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        manejadorOf.reiniciarManejador();

        try {
            controladorUsuario.altaUsuario(new DTEmpresa("nickEmpre", "", "", "MailEmpresa", "contraseña", "imagen", "", ""));
            controladorUsuario.altaUsuario(new DTPostulante("nickPost", "", "", "MailPostulante", "contraseña", "imagen", null, ""));
        } catch (UsuarioRepetidoException e) {
        	e.printStackTrace();
        }
        try {
            controladorOferta.altaTipoPublicacion(new DTTipoPublicacion("", "", 0, 0, 0, null));
        } catch (TipoPublicacionRepetidaException e) {
            e.printStackTrace();
        }

        try {
            controladorOferta.altaOferta("nickEmpre", "", "Noferta", "", "", Departamentos.ARTIGAS, "", 0f, null, new String[0], "imagen");
        } catch (OfertaRepetidaException e) {
            e.printStackTrace();
        }

        assertDoesNotThrow(() -> {
            controladorOferta.altaPostulacion("nickPost", "Noferta", "motivacion", "cv", LocalDate.now());
        });

        DTPostulacion[] postulaciones = controladorOferta.listarPostulaciones("Noferta");
        assertEquals(postulaciones.length, 1);
        assertEquals(postulaciones[0].getOferta(), "Noferta");
        assertEquals(postulaciones[0].getPostulante(), "nickPost");

        assertThrows(PostulacionRepetidaException.class, () -> {
            controladorOferta.altaPostulacion("nickPost", "Noferta", "motivacion", "cv", LocalDate.now());
        });
    }
}
