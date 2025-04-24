package com.trabajosuy.model.logicadatatype;
import java.time.LocalDate;
import com.trabajosuy.model.logicaclases.TipoPublicacion;
import com.trabajosuy.model.logicaenums.Departamentos;
import com.trabajosuy.model.logicaenums.Estados;

public class DTOfertaLaboral {
	private String nombre;
	private String descripcion;
	private String ciudad;
	private Departamentos departamento;
	private String horarioLaboral;
	private float remuneracion;
	private LocalDate fechaDeAlta;
	private Estados estado;
	private String[] keywords;
	private TipoPublicacion tipoPublicacion;
	private String imagen;
	
	public DTOfertaLaboral(String Nombre, String Descripcion, String Ciudad, Departamentos Departamento, String HorarioLaboral, float Remuneracion, LocalDate FechaDeAlta, Estados estado, String[] keywords, TipoPublicacion tipoPublicacion,  String imagen) {
		this.nombre = Nombre;
		this.descripcion = Descripcion;
		this.ciudad = Ciudad;
		this.departamento = Departamento;
		this.horarioLaboral = HorarioLaboral;
		this.remuneracion = Remuneracion;
		this.fechaDeAlta = FechaDeAlta;
		this.estado = estado;
		this.keywords = keywords;
		this.tipoPublicacion = tipoPublicacion;
		this.imagen = imagen;
	}
	// Getters y Setters
	public String getNombre() {
		return nombre;
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
	
	public void setEstado(Estados estad) {
		estado = estad;
	}

	public String getImagen() {
		return imagen;
	}
	
	public void setImagen(String imagen1) {
		this.imagen = imagen1;
	}
	
	public String[] getKeywords() {
		return keywords;
	}
	public void setKeywords(String[] keywords1) {
		keywords = keywords1;
	}
	
	public String toString() {
		return nombre;
	}
	public TipoPublicacion getTipo() {
		return tipoPublicacion;
	}
	public void setTipo(TipoPublicacion tipo) {
	 tipoPublicacion = tipo;
	}
}