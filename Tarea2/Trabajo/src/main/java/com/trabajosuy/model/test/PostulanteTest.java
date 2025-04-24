package com.trabajosuy.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.trabajosuy.model.logicaclases.Keyword;
import com.trabajosuy.model.logicaclases.OfertaLaboral;
import com.trabajosuy.model.logicaclases.Postulacion;
import com.trabajosuy.model.logicaclases.Postulante;
import com.trabajosuy.model.logicaclases.TipoPublicacion;
import com.trabajosuy.model.logicadatatype.DTPostulante;
import com.trabajosuy.model.logicaenums.Departamentos;

import java.time.LocalDate;

public class PostulanteTest {

	private Postulante postulante;
	private OfertaLaboral oferta; 
	private TipoPublicacion tipoPublicacion;
	private Keyword[] keywords;

	@BeforeEach
	public void setUp() {
		LocalDate fechaNacimiento = LocalDate.of(1990, 1, 1);
		postulante = new Postulante("nick", "Nombre", "Apellido", "email@example.com", "contraseña", "imagen", fechaNacimiento, "Nacionalidad");
		tipoPublicacion = new TipoPublicacion("Nombre", "Descripción", 3, 30, 50.0f, LocalDate.now());
		keywords = new Keyword[] { new Keyword("Palabra1"), new Keyword("Palabra2"), new Keyword("Palabra3") };
		oferta = new OfertaLaboral("FakeOferta", "Descripcion", "Mvd", Departamentos.MONTEVIDEO, "09:00 - 18:00", 1F, LocalDate.now(), tipoPublicacion, keywords, "imagen");

	}

	@Test
	public void testGetFechaNacimiento() {
		LocalDate expectedFecha = LocalDate.of(1990, 1, 1);
		assertEquals(expectedFecha, postulante.getFechaNacimiento());
	}

	@Test
	public void testGetNacionalidad() {
		assertEquals("Nacionalidad", postulante.getNacionalidad());
	}

	@Test
	public void testSetFechaNacimiento() {
		LocalDate newFecha = LocalDate.of(2000, 5, 15);
		postulante.setFechaNacimiento(newFecha);
		assertEquals(newFecha, postulante.getFechaNacimiento());
	}

	@Test
	public void testSetNacionalidad() {
		postulante.setNacionalidad("Nueva Nacionalidad");
		assertEquals("Nueva Nacionalidad", postulante.getNacionalidad());
	}

	@Test
	public void testGetDT() {
		DTPostulante dtPostulante = postulante.getDT();
		assertNotNull(dtPostulante);
		assertEquals("nick", dtPostulante.getNickname());
		assertEquals("Nombre", dtPostulante.getNombre());
		assertEquals("Apellido", dtPostulante.getApellido());
		assertEquals("email@example.com", dtPostulante.getEmail());
		assertEquals(LocalDate.of(1990, 1, 1), dtPostulante.getFechaNacimiento());
		assertEquals("Nacionalidad", dtPostulante.getNacionalidad());
	}

	@Test
	public void testVincularConPostulacion() {
		Postulacion postulacion = new Postulacion("CV Reducido...", "Quiero trabajar", LocalDate.now(), oferta, postulante); 
		postulante.vincularConPostulacion("Oferta1", postulacion);

		Postulacion[] postulaciones = postulante.getPostulaciones();
		Postulacion post = null;
		for (Postulacion pos : postulaciones) {
	        if (pos.getOferta().getNombre().equals(oferta.getNombre())) {
	        	post = pos;
	            break;
	        }
	    }
		assertEquals(postulacion, post);
	}
}