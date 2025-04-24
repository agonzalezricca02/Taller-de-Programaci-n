package com.trabajosuy.model.logicacontroladores;

import java.time.LocalDate;

import com.trabajosuy.model.excepciones.OfertaRepetidaException;
import com.trabajosuy.model.excepciones.PostulacionRepetidaException;
import com.trabajosuy.model.excepciones.TipoPublicacionRepetidaException;
import com.trabajosuy.model.logicadatatype.DTOfertaLaboral;
import com.trabajosuy.model.logicadatatype.DTPostulacion;
import com.trabajosuy.model.logicadatatype.DTTipoPublicacion;
import com.trabajosuy.model.excepciones.KeywordRepetidaException;
import com.trabajosuy.model.excepciones.OfertaExpiradaException;
import com.trabajosuy.model.logicaenums.Departamentos;

public interface IControladorOferta {
	
	public abstract DTOfertaLaboral[] listarOfertasUsuario(String usuario);

	public abstract DTOfertaLaboral[] listarOfertas();

	public abstract DTOfertaLaboral[] listarOfertasVigentes(String empresa);
	
	public abstract DTTipoPublicacion[] listarTiposPublicacion();
	
	public abstract String[] listarKeywords();
	
	public abstract DTPostulacion[] listarPostulaciones(String oferta);
	
	public abstract DTOfertaLaboral getOferta(String oferta); 
	
	public abstract DTTipoPublicacion getTipoOferta(String oferta);
	
	public abstract boolean getEmpresaOferta(String empresa, String oferta);

	public abstract void altaOferta(String empresa, String tipoPublicacion, String nombre, String descripcion, String ciudad, Departamentos departamento, String horario, float remuneracion, LocalDate fechaDeAlta, String[] keywords, String imagen) throws OfertaRepetidaException;

	public abstract void altaPostulacion(String postulante, String oferta, String motivacion, String currivitae, LocalDate fecha) throws PostulacionRepetidaException, OfertaExpiradaException;
	
	public abstract void altaTipoPublicacion(DTTipoPublicacion tipopos) throws TipoPublicacionRepetidaException;
	
	public abstract void altaKeyword(String keyword) throws KeywordRepetidaException;
	
}
