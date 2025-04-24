package com.trabajosuy.model.logicacontroladores;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.trabajosuy.model.excepciones.OfertaRepetidaException;
import com.trabajosuy.model.logicaenums.Departamentos;
import com.trabajosuy.model.logicaenums.Estados;
import com.trabajosuy.model.logicadatatype.DTEmpresa;
import com.trabajosuy.model.logicadatatype.DTPostulante;
import com.trabajosuy.model.logicadatatype.DTTipoPublicacion;
import com.trabajosuy.model.logicamanejadores.ManejadorOferta;
import com.trabajosuy.model.excepciones.KeywordRepetidaException;
import com.trabajosuy.model.excepciones.OfertaExpiradaException;
import com.trabajosuy.model.excepciones.PostulacionRepetidaException;
import com.trabajosuy.model.excepciones.TipoPublicacionRepetidaException;
import com.trabajosuy.model.excepciones.UsuarioRepetidoException;

public class ControladorAdmin implements IControladorAdmin{
	private final String fileRoute = "C:\\Tprog_DatosPruebaT2_2023\\";
	private ControladorUsuario ctrlUsuario;
	private ControladorOferta ctrlOferta;

	public ControladorAdmin() {
		ctrlUsuario =  new ControladorUsuario();;
		ctrlOferta = new ControladorOferta();
	}

	public void cargarDatosDePrueba() {
		
		try {
			// Carga de Usuarios
			ArrayList<String[]> archivoUsuarios = leerArchivo("Usuarios");
			ArrayList<String[]> archivoPostulantes = leerArchivo("Usuarios-Postulantes");
			ArrayList<String[]> archivoEmpresas = leerArchivo("Usuarios-Empresas");
			int postulantesIndex = 0;
			int empresasIndex = 0;
			for (String[] fila: archivoUsuarios) {
				if (fila[1].equals("P")) {
					String[] filaPostulante = archivoPostulantes.get(postulantesIndex);
					LocalDate fechaNacimiento = localDateFormat(filaPostulante[1]);
					DTPostulante postulante = new DTPostulante(fila[2], fila[3], fila[4], fila[5], fila[6], fila[7], fechaNacimiento, filaPostulante[2]);
					try {
						ctrlUsuario.altaUsuario(postulante);
					} catch (UsuarioRepetidoException e) {
						System.out.print("ERROR: " + e.getMessage());
					}
					postulantesIndex++;
				} else if (fila[1].equals("E")) {
					String[] filaEmpresa = archivoEmpresas.get(empresasIndex);
					DTEmpresa empresa = new DTEmpresa(fila[2], fila[3], fila[4], fila[5], fila[6], fila[7], filaEmpresa[1], filaEmpresa[2]);
					try {
						ctrlUsuario.altaUsuario(empresa);
					} catch (UsuarioRepetidoException e) {
						System.out.print("ERROR: " + e.getMessage());
					}
					empresasIndex++;
				}
			}
			
			//Carga de Keywords
			ArrayList<String[]> archivoKeywords = leerArchivo("Keywords");
			for (String[] fila: archivoKeywords) {
				try {
					ctrlOferta.altaKeyword(fila[1]);
				} catch (KeywordRepetidaException e) {
					System.out.print("ERROR: " + e.getMessage());
				}
			}
			
			//Carga Tipo de Publicación
			ArrayList<String[]> archivoTipoDePublicacion = leerArchivo("TipoPublicacion");
			for (String[] fila: archivoTipoDePublicacion) {
				DTTipoPublicacion tipoPublicacion = new DTTipoPublicacion(fila[1], fila[2], Integer.parseInt(fila[3]), Integer.parseInt(fila[4]), Float.parseFloat(fila[5]), localDateFormat(fila[6]));
				try {
					ctrlOferta.altaTipoPublicacion(tipoPublicacion);
				} catch (TipoPublicacionRepetidaException e) {
					System.out.print("ERROR: " + e.getMessage());
				}
			}
	
			
			//Carga de Ofertas Laborales
			ArrayList<String[]> archivoOfertasLaborales = leerArchivo("OfertasLaborales");
			ArrayList<String[]> ofertasLaboralesKeywords = leerArchivo("OfertasLaboralesKeywords");
			ArrayList<String> keywords = new ArrayList<String>();
			for (String[] fila: archivoOfertasLaborales){
				
				//(INICIO) Keywords
				for (String[] filaOFK: ofertasLaboralesKeywords){
					if (filaOFK[0].equals(fila[0])) {	
						String[] keysIds = filaOFK[1].split(",");
						for (String keyId: keysIds) {
							for (String[] keyword: archivoKeywords)
								if (keyword[0].equals(keyId.trim())) {
									keywords.add(keyword[1]);				
								}
						}
					}
				}
				
				//(FIN) Keywords
				String depSinTildes = Normalizer.normalize(fila[3], Normalizer.Form.NFD);
				depSinTildes = depSinTildes.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
				Departamentos dep = Departamentos.valueOf(depSinTildes.toUpperCase().replace(' ', '_'));
				
				float remuneracion = Float.parseFloat(fila[6]);
				
				LocalDate fechaDeAlta = localDateFormat(fila[9]);
				
				String empresaA = "";
				
				for (String[] empresa: archivoUsuarios ) { 
					if (empresa[0].equals(fila[7])) {
						empresaA = empresa[2]; break; }}
				
				//(INICIO) Tipo Publicacion
				String tipoPublicacion = "";
				for (String[] filaTP: archivoTipoDePublicacion) {
					if (filaTP[0].equals(fila[8])) {
						tipoPublicacion = filaTP[1];
						break;
					}
				}
				
				//(FIN) Tipo Publicacion
				try {
					ctrlOferta.altaOferta(empresaA, tipoPublicacion, fila[1], fila[2], fila[4], dep, fila[5], remuneracion, fechaDeAlta, keywords.toArray(new String[0]), fila[12]);
					if (Estados.valueOf(fila[10].toUpperCase()) == Estados.CONFIRMADA) {
						ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
						ctrlOferta.aceptarOfertaLaboral(manejadorOf.getOferta(fila[1]));
					} else if (Estados.valueOf(fila[10].toUpperCase()) == Estados.RECHAZADA) {
						ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
						ctrlOferta.rechazarOfertaLaboral(manejadorOf.getOferta(fila[1]));
					}
				} catch (OfertaRepetidaException e) {
					System.out.print("ERROR: " + e.getMessage());
				}
				keywords.clear();
			}
	
			
			//Carga Postulacion
			ArrayList<String[]> archivoPostulacion = leerArchivo("Postulaciones");
			for (String[] fila: archivoPostulacion) {
				String pos = "";
				for (String[] postulante: archivoUsuarios ) 
					if (postulante[0].equals(fila[1])) {
						pos = postulante[2];
						break;
					}
				String ofLab = "";
				for (String[] oferta: archivoOfertasLaborales ) {
					if (oferta[0].equals(fila[5])) {
						ofLab = oferta[1]; break; }}
				try {
					ctrlOferta.altaPostulacion(pos, ofLab, fila[3], fila[2], localDateFormat(fila[4]));
				} catch (PostulacionRepetidaException e) {
					System.out.print("ERROR: " + e.getMessage());
				} catch (OfertaExpiradaException e) {
					System.out.print("ERROR: " + e.getMessage());
				}
			}
		} catch (FileNotFoundException e) {
			System.out.print("ERROR: " + e.getMessage());
		}
		
	}

	private ArrayList<String[]> leerArchivo(String fileName) throws FileNotFoundException {
		Scanner scaner = new Scanner(new File(fileRoute + fileName + ".csv"));  
		scaner.useDelimiter(","); 

		// Salta la primer linea que contiene los nombres de las columnas
		String line = scaner.nextLine();

		ArrayList<String[]> salida = new ArrayList<String[]>();
		while (scaner.hasNext()) {  
			line = scaner.nextLine();
			String[] campos = line.split(";");
			salida.add(campos);
		}   
		scaner.close();
		return salida;
	}

	// Private methods
	private static LocalDate localDateFormat(String fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
		return LocalDate.parse(fecha, formatter);

	}
}