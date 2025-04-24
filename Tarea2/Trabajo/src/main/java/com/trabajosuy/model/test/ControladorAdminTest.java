package com.trabajosuy.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.trabajosuy.model.logicaclases.Empresa;
import com.trabajosuy.model.logicaclases.Keyword;
import com.trabajosuy.model.logicaclases.OfertaLaboral;
import com.trabajosuy.model.logicaclases.Postulacion;
import com.trabajosuy.model.logicaclases.Postulante;
import com.trabajosuy.model.logicaclases.PublicacionOferta;
import com.trabajosuy.model.logicaclases.TipoPublicacion;
import com.trabajosuy.model.logicacontroladores.ControladorAdmin;
import com.trabajosuy.model.logicaenums.Departamentos;
import com.trabajosuy.model.logicamanejadores.ManejadorOferta;
import com.trabajosuy.model.logicamanejadores.ManejadorUsuario;

import java.time.LocalDate;
import java.util.List;

public class ControladorAdminTest {
    private ControladorAdmin ctrlAdmin;
    private ManejadorUsuario manejadorUsr;
    private ManejadorOferta manejadorOf;

    @BeforeEach
    public void setUp() {
        ctrlAdmin = new ControladorAdmin();
        manejadorUsr = ManejadorUsuario.getinstance();
        manejadorOf = ManejadorOferta.getinstance();
    }

    @Test
    public void testCargarDatosDePrueba() {
        ctrlAdmin.cargarDatosDePrueba();

        chequeoUsuarios();
        chequeoKeywords();
        chequeoTipoPublicacion();
        chequeoOfertasLaborales();
        chequeoPostulaciones();

    } 

    private void chequeoUsuarios() {
        Postulante usuario1 = (Postulante) (manejadorUsr.getPostulante("lgarcia"));
        assertNotNull(usuario1);
        assertEquals(usuario1.getNombre(), "Lucía");
        assertEquals(usuario1.getApellido(), "García");
        assertEquals(usuario1.getEmail(), "lgarcia85@gmail.com");
        assertEquals(usuario1.getFechaNacimiento(), LocalDate.of(1985, 3, 15));
        assertEquals(usuario1.getNacionalidad(), "Uruguaya");

        Postulante usuario2 = (Postulante) (manejadorUsr.getPostulante("matilo"));
        assertNotNull(usuario2);
        assertEquals(usuario2.getNombre(), "Matías");
        assertEquals(usuario2.getApellido(), "López");
        assertEquals(usuario2.getEmail(), "matias.lopez90@hotmail.com");
        assertEquals(usuario2.getFechaNacimiento(), LocalDate.of(1990, 8, 21));
        assertEquals(usuario2.getNacionalidad(), "Argentina");

        Postulante usuario3 = (Postulante) (manejadorUsr.getPostulante("maro"));
        assertNotNull(usuario3);
        assertEquals(usuario3.getNombre(), "María");
        assertEquals(usuario3.getApellido(), "Rodríguez");
        assertEquals(usuario3.getEmail(), "marrod@gmail.com");
        assertEquals(usuario3.getFechaNacimiento(), LocalDate.of(1988, 11, 10));
        assertEquals(usuario3.getNacionalidad(), "Uruguaya");

        Postulante usuario4 = (Postulante) (manejadorUsr.getPostulante("javierf"));
        assertNotNull(usuario4);
        assertEquals(usuario4.getNombre(), "Javier");
        assertEquals(usuario4.getApellido(), "Fernández");
        assertEquals(usuario4.getEmail(), "javierf93@yahoo.com");
        assertEquals(usuario4.getFechaNacimiento(), LocalDate.of(1993, 6, 05));
        assertEquals(usuario4.getNacionalidad(), "Mexicana");

        Postulante usuario5 = (Postulante) (manejadorUsr.getPostulante("valen25"));
        assertNotNull(usuario5);
        assertEquals(usuario5.getNombre(), "Valentina");
        assertEquals(usuario5.getApellido(), "Martínez");
        assertEquals(usuario5.getEmail(), "vale87@gmail.com");
        assertEquals(usuario5.getFechaNacimiento(), LocalDate.of(1987, 2, 25));
        assertEquals(usuario5.getNacionalidad(), "Uruguaya");

        Postulante usuario6 = (Postulante) (manejadorUsr.getPostulante("andpe12"));
        assertNotNull(usuario6);
        assertEquals(usuario6.getNombre(), "Andrés");
        assertEquals(usuario6.getApellido(), "Pérez");
        assertEquals(usuario6.getEmail(), "anpe92@hotmail.com");
        assertEquals(usuario6.getFechaNacimiento(), LocalDate.of(1992, 4, 12));
        assertEquals(usuario6.getNacionalidad(), "Chilena");

        Postulante usuario7 = (Postulante) (manejadorUsr.getPostulante("sicam"));
        assertNotNull(usuario7);
        assertEquals(usuario7.getNombre(), "Camila");
        assertEquals(usuario7.getApellido(), "Silva");
        assertEquals(usuario7.getEmail(), "camilasilva89@gmail.com");
        assertEquals(usuario7.getFechaNacimiento(), LocalDate.of(1989, 9, 30));
        assertEquals(usuario7.getNacionalidad(), "Uruguaya");

        Postulante usuario8 = (Postulante) (manejadorUsr.getPostulante("sebgon"));
        assertNotNull(usuario8);
        assertEquals(usuario8.getNombre(), "Sebastián");
        assertEquals(usuario8.getApellido(), "González");
        assertEquals(usuario8.getEmail(), "gonza95@yahoo.com");
        assertEquals(usuario8.getFechaNacimiento(), LocalDate.of(1995, 1, 18));
        assertEquals(usuario8.getNacionalidad(), "Colombiana");

        Postulante usuario9 = (Postulante) (manejadorUsr.getPostulante("isabel"));
        assertNotNull(usuario9);
        assertEquals(usuario9.getNombre(), "Isabella");
        assertEquals(usuario9.getApellido(), "López");
        assertEquals(usuario9.getEmail(), "loisa@gmail.com");
        assertEquals(usuario9.getFechaNacimiento(), LocalDate.of(1991, 7, 7));
        assertEquals(usuario9.getNacionalidad(), "Uruguaya");

        Postulante usuario10 = (Postulante) (manejadorUsr.getPostulante("marram02"));
        assertNotNull(usuario10);
        assertEquals(usuario10.getNombre(), "Martín");
        assertEquals(usuario10.getApellido(), "Ramírez");
        assertEquals(usuario10.getEmail(), "marram@hotmail.com");
        assertEquals(usuario10.getFechaNacimiento(), LocalDate.of(1986, 12, 2));
        assertEquals(usuario10.getNacionalidad(), "Argentina");

        Empresa usuario11 = (Empresa) (manejadorUsr.getEmpresa("EcoTech"));
        assertNotNull(usuario11);
        assertEquals(usuario11.getNombre(), "Sophia");
        assertEquals(usuario11.getApellido(), "Johnson");
        assertEquals(usuario11.getEmail(), "info@EcoTech.com");
        assertEquals(usuario11.getDescripcion(), "EcoTech Innovations es una empresa líder en soluciones tecnológicas sostenibles. Nuestro enfoque se centra en desarrollar y comercializar productos y servicios que aborden los desafíos ambientales más apremiantes de nuestro tiempo. Desde sistemas de energía renovable y dispositivos de monitorización ambiental hasta soluciones de gestión de residuos inteligentes, nuestra misión es proporcionar herramientas que permitan a las empresas y comunidades adoptar prácticas más ecológicas sin comprometer la eficiencia. Creemos en la convergencia armoniosa entre la tecnología y la naturaleza, y trabajamos incansablemente para impulsar un futuro más limpio y sostenible.");
        assertEquals(usuario11.getSitioWeb(), "http://www.EcoTechInnovations.com");

        Empresa usuario12 = (Empresa) (manejadorUsr.getEmpresa("FusionTech"));
        assertNotNull(usuario12);
        assertEquals(usuario12.getNombre(), "William");
        assertEquals(usuario12.getApellido(), "Smith");
        assertEquals(usuario12.getEmail(), "contacto@FusionTech.net");
        assertEquals(usuario12.getDescripcion(), "FusionTech Dynamics es una empresa pionera en el ámbito de la inteligencia artificial y la automatización avanzada. Nuestro equipo multidisciplinario de ingenieros, científicos de datos y desarrolladores crea soluciones innovadoras que aprovechan la potencia de la IA para transformar industrias. Desde la optimización de procesos industriales hasta la creación de asistentes virtuales altamente personalizados, nuestro objetivo es revolucionar la forma en que las empresas operan y se conectan con sus clientes. Creemos en la sinergia entre la mente humana y las capacidades de la IA, y trabajamos para construir un mundo donde la tecnología mejore y amplíe nuestras capacidades innatas.");
        assertEquals(usuario12.getSitioWeb(), "http://www.FusionTechDynamics.net");

        Empresa usuario13 = (Empresa) (manejadorUsr.getEmpresa("GlobalHealth"));
        assertNotNull(usuario13);
        assertEquals(usuario13.getNombre(), "Isabella");
        assertEquals(usuario13.getApellido(), "Brown");
        assertEquals(usuario13.getEmail(), "jobs@GlobalHealth.uy");
        assertEquals(usuario13.getDescripcion(), "GlobalHealth Dynamics es una empresa comprometida con el avance de la atención médica a nivel mundial. Como líderes en el campo de la salud digital, desarrollamos plataformas y herramientas que permiten a los profesionales de la salud ofrecer diagnósticos más precisos, tratamientos personalizados y seguimiento continuo de los pacientes. Nuestra visión es crear un ecosistema de salud conectado en el que los datos médicos se utilicen de manera ética y segura para mejorar la calidad de vida de las personas. A través de la innovación constante y la colaboración con expertos médicos, estamos dando forma al futuro de la atención médica, donde la tecnología y la compasión se unen para salvar vidas y mejorar el bienestar en todo el mundo.");
        assertEquals(usuario13.getSitioWeb(), "http://www.GlobalHealthDynamics.uy/info");

        Empresa usuario14 = (Empresa) (manejadorUsr.getEmpresa("ANTEL"));
        assertNotNull(usuario14);
        assertEquals(usuario14.getNombre(), "Washington");
        assertEquals(usuario14.getApellido(), "Rocha");
        assertEquals(usuario14.getEmail(), "jarrington@ANTEL.com.uy");
        assertEquals(usuario14.getDescripcion(), "En Antel te brindamos servicios de vanguardia en tecnología de comunicación en Telefonía Móvil, Fija, Banda Ancha y Datos");
        assertEquals(usuario14.getSitioWeb(), "ANTEL.com.uy");

        Empresa usuario15 = (Empresa) (manejadorUsr.getEmpresa("MIEM"));
        assertNotNull(usuario15);
        assertEquals(usuario15.getNombre(), "Pablo");
        assertEquals(usuario15.getApellido(), "Bengoechea");
        assertEquals(usuario15.getEmail(), "eldiez@MIEM.org.uy");
        assertEquals(usuario15.getDescripcion(), "Balance Energético Nacional (BEN). La Dirección Nacional de Energía (DNE) del Ministerio de Industria, Energía y Minería (MIEM) presenta anualmente el BEN.");
        assertEquals(usuario15.getSitioWeb(), "MIEM.com.uy");

        Empresa usuario16 = (Empresa) (manejadorUsr.getEmpresa("TechSolutions"));
        assertNotNull(usuario16);
        assertEquals(usuario16.getNombre(), "Mercedes");
        assertEquals(usuario16.getApellido(), "Venn");
        assertEquals(usuario16.getEmail(), "Mercedes@TechSolutions.com.uy");
        assertEquals(usuario16.getDescripcion(), "\"TechSolutions Inc.\" es una empresa líder en el sector de tecnología de la información y el software. Se especializa en el desarrollo de soluciones de software personalizadas para empresas de diversos tamaños y sectores. Su enfoque se centra en la creación de aplicaciones empresariales innovadoras que optimizan procesos, mejoran la eficiencia y brindan una ventaja competitiva a sus clientes.");
        assertEquals(usuario16.getSitioWeb(), "TechSolutions.com");
    }

    private void chequeoKeywords() {
        assertNotNull(manejadorOf.getKeyword("Tiempo completo"));
        assertNotNull(manejadorOf.getKeyword("Medio tiempo"));
        assertNotNull(manejadorOf.getKeyword("Remoto"));
        assertNotNull(manejadorOf.getKeyword("Freelance"));
        assertNotNull(manejadorOf.getKeyword("Temporal"));
        assertNotNull(manejadorOf.getKeyword("Permanente"));
        assertNotNull(manejadorOf.getKeyword("Computación"));
        assertNotNull(manejadorOf.getKeyword("Administración"));
        assertNotNull(manejadorOf.getKeyword("Logística"));
        assertNotNull(manejadorOf.getKeyword("Contabilidad"));
    }

    private void chequeoTipoPublicacion() {
        TipoPublicacion tipo = manejadorOf.getTipoPublicacion("Premium");
        assertNotNull(tipo);
        assertEquals(tipo.getDescripcion(), "Obtén máxima visibilidad");
        assertEquals(tipo.getExposicion(), 1);
        assertEquals(tipo.getTiempoEnPlataforma(), 30);
        assertEquals(tipo.getCosto(), 4000);
        assertEquals(tipo.getFechaAlta(), LocalDate.of(2023, 8, 10));

        tipo = manejadorOf.getTipoPublicacion("Destacada");
        assertNotNull(tipo);
        assertEquals(tipo.getDescripcion(), "Destaca tu anuncio");
        assertEquals(tipo.getExposicion(), 2);
        assertEquals(tipo.getTiempoEnPlataforma(), 15);
        assertEquals(tipo.getCosto(), 500);
        assertEquals(tipo.getFechaAlta(), LocalDate.of(2023, 8, 5));

        tipo = manejadorOf.getTipoPublicacion("Estándar");
        assertNotNull(tipo);
        assertEquals(tipo.getDescripcion(), "Mejora la posición de tu anuncio");
        assertEquals(tipo.getExposicion(), 3);
        assertEquals(tipo.getTiempoEnPlataforma(), 20);
        assertEquals(tipo.getCosto(), 150);
        assertEquals(tipo.getFechaAlta(), LocalDate.of(2023, 8, 15));

        tipo = manejadorOf.getTipoPublicacion("Básica");
        assertNotNull(tipo);
        assertEquals(tipo.getDescripcion(), "Publica de forma sencilla en la lista de ofertas");
        assertEquals(tipo.getExposicion(), 4);
        assertEquals(tipo.getTiempoEnPlataforma(), 7);
        assertEquals(tipo.getCosto(), 50);
        assertEquals(tipo.getFechaAlta(), LocalDate.of(2023, 8, 7));
    }

    private void chequeoOfertasLaborales() {
        OfertaLaboral oferta = manejadorOf.getOferta("Desarrollador Frontend");
        assertNotNull(oferta);
        assertEquals(oferta.getDescripcion(), "Únete a nuestro equipo de desarrollo frontend y crea experiencias de usuario excepcionales.");
        assertEquals(oferta.getDepartamento(), Departamentos.MONTEVIDEO);
        assertEquals(oferta.getCiudad(), "Montevideo");
        assertEquals(oferta.getHorarioLaboral(), "09:00 - 18:00");
        assertEquals(oferta.getRemuneracion(), 90000F);
        List<PublicacionOferta> publicaciones = ((Empresa) manejadorUsr.getEmpresa("EcoTech")).getPublicaciones();
        PublicacionOferta pub = null;
        for (PublicacionOferta publicacion: publicaciones) {
            if (publicacion.getOfertaPublicada().equals(oferta)) {
                pub = publicacion;
                break;
            }
        }
        assertNotNull(pub);
        assertEquals(oferta.getFechaDeAlta(), LocalDate.of(2023, 8, 14));
        assertEquals(oferta.getTipoPublicacion(), manejadorOf.getTipoPublicacion("Premium"));
        List<Keyword> keys = oferta.getKeys();
        assertTrue(keys.contains(manejadorOf.getKeyword("Tiempo completo")));
        assertTrue(keys.contains(manejadorOf.getKeyword("Medio tiempo")));
        assertTrue(keys.contains(manejadorOf.getKeyword("Remoto")));
        assertTrue(keys.contains(manejadorOf.getKeyword("Freelance")));
        assertTrue(keys.contains(manejadorOf.getKeyword("Temporal")));
        assertTrue(keys.contains(manejadorOf.getKeyword("Permanente")));
    }

    private void chequeoPostulaciones() {
        Postulacion[] postulaciones = ((Postulante) manejadorUsr.getPostulante("lgarcia")).getPostulaciones();
        for (Postulacion postulacion: postulaciones) {
            OfertaLaboral ofLab = postulacion.getOferta();
            assertTrue(ofLab.equals(manejadorOf.getOferta("Desarrollador Frontend")) || ofLab.equals(manejadorOf.getOferta("Estratega de Negocios")));
        }
        postulaciones = ((Postulante) manejadorUsr.getPostulante("matilo")).getPostulaciones();
        for (Postulacion postulacion: postulaciones) {
            OfertaLaboral ofLab = postulacion.getOferta();
            assertEquals(ofLab, manejadorOf.getOferta("Estratega de Negocios"));
        }
        postulaciones = ((Postulante) manejadorUsr.getPostulante("maro")).getPostulaciones();
        for (Postulacion postulacion: postulaciones) {
            OfertaLaboral ofLab = postulacion.getOferta();
            assertEquals(ofLab, manejadorOf.getOferta("Desarrollador Frontend"));
        }
        postulaciones = ((Postulante) manejadorUsr.getPostulante("javierf")).getPostulaciones();
        for (Postulacion postulacion: postulaciones) {
            OfertaLaboral ofLab = postulacion.getOferta();
            assertEquals(ofLab, manejadorOf.getOferta("Diseñador UX/UI"));
        }
        postulaciones = ((Postulante) manejadorUsr.getPostulante("valen25")).getPostulaciones();
        for (Postulacion postulacion: postulaciones) {
            OfertaLaboral ofLab = postulacion.getOferta();
            assertEquals(ofLab, manejadorOf.getOferta("Estratega de Negocios"));
        }
    }
}
