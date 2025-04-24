package com.trabajosuy.model.logicaclases;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.trabajosuy.model.logicadatatype.DTOfertaLaboral;
import com.trabajosuy.model.logicadatatype.DTPostulacion;
import com.trabajosuy.model.logicaenums.Departamentos;
import com.trabajosuy.model.logicaenums.Estados;

import java.util.HashMap;
import java.util.ArrayList;

public class OfertaLaboral {
	private String nombre;
	private String descripcion;
	private String ciudad;
	private Departamentos departamento;
	private String horarioLaboral;
	private float remuneracion;
	private LocalDate fechaDeAlta;
	private Estados estado;
	private String imagen;

	private Map<String, Postulacion> postulacionesPostulantes;
	private List<Keyword> keywords;
	private TipoPublicacion tipoPublicacion;

	// Contructor
	public OfertaLaboral(String Nombre, String Descripcion, String Ciudad, Departamentos Departamento, String HorarioLaboral, float Remuneracion, LocalDate FechaDeAlta, TipoPublicacion tipoPublicacion, Keyword[] keys, String imagen){
		this.nombre = Nombre;
		this.descripcion = Descripcion;
		this.ciudad = Ciudad;
		this.departamento = Departamento;
		this.horarioLaboral = HorarioLaboral;
		this.remuneracion = Remuneracion;
		this.fechaDeAlta = FechaDeAlta;
		this.tipoPublicacion = tipoPublicacion;
		this.estado = Estados.INGRESADA;
		this.imagen = imagen;

		postulacionesPostulantes = new HashMap<String, Postulacion>();
		keywords = new ArrayList<>();
		for (Keyword i: keys) {
			this.keywords.add(i);
		}
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public TipoPublicacion getTipoPublicacion() {
		return tipoPublicacion;
	}
	public void setNombre(String nombr) {
		nombre = nombr;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descrip) {
		descripcion = descrip;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciuda) {
		ciudad = ciuda;
	}
	public Departamentos getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamentos departament) {
		departamento = departament;
	}
	public String getHorarioLaboral() { //Map<LocalDate, LocalDate> getHorarioLaboral() {
		return horarioLaboral;
	}
	public void setHorarioLaboral(String horarioLab) { //Map<LocalDate, LocalDate> horarioLaboral) {
		horarioLaboral = horarioLab;
	}
	public float getRemuneracion() {
		return remuneracion;
	}
	public void setRemuneracion(float remunera) {
		remuneracion = remunera;
	}
	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}
	public void setFechaDeAlta(LocalDate fechaDeAlt) {
		fechaDeAlta = fechaDeAlt;
	}
	
	public Estados getEstado() {
		return estado;
	}
	
	public void setEstado(Estados esta) {
		estado = esta;
	}

	public String getImagen() {
		return imagen;
	}
	
	public void setImagen(String imagen1) {
		this.imagen = imagen1;
	}
	
	public List<Keyword> getKeys(){
		return keywords;
	}
	public void addPostulacion(DTPostulacion postu, OfertaLaboral ofLab, Postulante postulante) {
		Postulacion postulacion = new Postulacion(postu.getCVReducido(), postu.getMotivacion(), postu.getFecha(), ofLab, postulante);
		postulacionesPostulantes.put(postu.getPostulante(), postulacion);
		postulante.vincularConPostulacion(ofLab.getNombre(), postulacion);
	}

	public Postulacion getPostulacion(String postulante) {
		return postulacionesPostulantes.get(postulante);
	}

	public Postulacion[] getPostulaciones() {
		return postulacionesPostulantes.values().toArray(new Postulacion[0]);
	}
	
	public LocalDate getFechaDeExpiracion() {
		return fechaDeAlta.plusDays(tipoPublicacion.getTiempoEnPlataforma());
	}

	public DTOfertaLaboral getDT() {
		String[] keywordsArray = new String[keywords.size()];
		for (int i = 0; i < keywords.size(); i++) {
			keywordsArray[i] = keywords.get(i).getNombre();
		}

		return new DTOfertaLaboral(nombre, descripcion, ciudad, departamento, horarioLaboral, remuneracion, fechaDeAlta, estado, keywordsArray, tipoPublicacion, imagen);
	}

	public boolean esVigente() {
		return LocalDate.now().isBefore(fechaDeAlta.plusDays(tipoPublicacion.getTiempoEnPlataforma()));
	}
}
