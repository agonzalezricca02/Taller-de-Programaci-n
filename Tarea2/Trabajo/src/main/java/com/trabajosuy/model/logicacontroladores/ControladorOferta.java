package com.trabajosuy.model.logicacontroladores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.trabajosuy.model.excepciones.KeywordRepetidaException;
import com.trabajosuy.model.excepciones.OfertaExpiradaException;
import com.trabajosuy.model.excepciones.OfertaRepetidaException;
import com.trabajosuy.model.excepciones.PostulacionRepetidaException;
import com.trabajosuy.model.excepciones.TipoPublicacionRepetidaException;
import com.trabajosuy.model.logicaclases.Empresa;
import com.trabajosuy.model.logicaclases.Keyword;
import com.trabajosuy.model.logicaclases.OfertaLaboral;
import com.trabajosuy.model.logicaclases.Postulacion;
import com.trabajosuy.model.logicaclases.Postulante;
import com.trabajosuy.model.logicaclases.TipoPublicacion;
import com.trabajosuy.model.logicaclases.Usuario;
import com.trabajosuy.model.logicaclases.PublicacionOferta;
import com.trabajosuy.model.logicadatatype.DTOfertaLaboral;
import com.trabajosuy.model.logicadatatype.DTPostulacion;
import com.trabajosuy.model.logicadatatype.DTTipoPublicacion;
import com.trabajosuy.model.logicaenums.Departamentos;
import com.trabajosuy.model.logicaenums.Estados;
import com.trabajosuy.model.logicamanejadores.ManejadorOferta;
import com.trabajosuy.model.logicamanejadores.ManejadorUsuario;

public class ControladorOferta implements IControladorOferta {
    public DTOfertaLaboral[] listarOfertasUsuario(String usuario) {
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        Usuario user = manejadorUsr.getUsuario(usuario);
        List<DTOfertaLaboral> ldt = new ArrayList<>();

        if (user instanceof Postulante) {
            Postulante postulante = (Postulante) user;
            Postulacion[] postulaciones = postulante.getPostulaciones();
            for (Postulacion pos : postulaciones) {
                ldt.add(pos.getOferta().getDT());
            }
        } else {
            Empresa empresa = (Empresa) user;
            ldt = ((Empresa) manejadorUsr.getEmpresa(empresa.getNickname())).listarOfertas();
        }

        return Arrays.copyOf(ldt.toArray(), ldt.toArray().length, DTOfertaLaboral[].class);
    }

    public DTOfertaLaboral getOferta(String oferta) {
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        OfertaLaboral ofer = manejadorOf.getOferta(oferta);
        return ofer.getDT();
    }

    public DTTipoPublicacion getTipoOferta(String oferta) {
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        OfertaLaboral ofer = manejadorOf.getOferta(oferta);
        return ofer.getTipoPublicacion().getDT();
    }
    
    public boolean getEmpresaOferta(String empresa, String oferta) {
    	ManejadorUsuario manejadorUS = ManejadorUsuario.getinstance(); 
    	Empresa empre = (Empresa) manejadorUS.getEmpresa(empresa);
    	List<PublicacionOferta> publList= empre.getPublicaciones();
    	boolean result = false;
    	for (PublicacionOferta pub : publList ) {
    		OfertaLaboral ofe = pub.getOfertaPublicada() ;
    		if (ofe.getNombre() == oferta ) {
    			return true;
    		}
    	}
    	return result ;
    }

    public DTOfertaLaboral[] listarOfertas() {
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        OfertaLaboral[] ofertas = manejadorOf.getOfertas();
        DTOfertaLaboral[] ofertasDT = new DTOfertaLaboral[ofertas.length];

        for (int iter = 0; iter < ofertas.length; iter++) {
            ofertasDT[iter] = ofertas[iter].getDT();
        }

        return ofertasDT;
    }

    public DTOfertaLaboral[] listarOfertasVigentes(String empresa) {
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        List<DTOfertaLaboral> ldt = ((Empresa) manejadorUsr.getEmpresa(empresa)).listarOfertasVigentes();

        return Arrays.copyOf(ldt.toArray(), ldt.toArray().length, DTOfertaLaboral[].class);
    }

    public DTTipoPublicacion[] listarTiposPublicacion() {
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        TipoPublicacion[] tipoPubli = manejadorOf.getTiposPublicacion();
        DTTipoPublicacion[] dttp = new DTTipoPublicacion[tipoPubli.length];

        for (int i = 0; i < tipoPubli.length; i++) {
            dttp[i] = tipoPubli[i].getDT();
        }

        return dttp;
    }

    public String[] listarKeywords() {
        ManejadorOferta manejadorUsr = ManejadorOferta.getinstance();
        Keyword[] keylist = manejadorUsr.getKeywords();

        String[] stkw = new String[keylist.length];

        for (int i = 0; i < keylist.length; i++) {
            stkw[i] = keylist[i].getNombre();
        }

        return stkw;
    }

    public DTPostulacion[] listarPostulaciones(String oferta) {
        ManejadorOferta manejadorUsr = ManejadorOferta.getinstance();
        Postulacion[] pst = manejadorUsr.getOferta(oferta).getPostulaciones();

        DTPostulacion[] dtpst = new DTPostulacion[pst.length];
        for (int i = 0; i < pst.length; i++) {
            dtpst[i] = pst[i].getDT();
        }
        return dtpst;
    }

    public void altaOferta(String empresa, String tipoPublicacion, String nombre, String descripcion, String ciudad, Departamentos departamento, String horario, float remuneracion, LocalDate fechaDeAlta, String[] keywords, String imagen) throws OfertaRepetidaException {
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();

        if (manejadorOf.getOferta(nombre) != null) {
            throw new OfertaRepetidaException("Ya existe una Oferta Laboral con ese nombre");
        }

        Keyword[] kws = new Keyword[keywords.length];
        for (int i = 0; i < keywords.length; i++) {
            kws[i] = manejadorOf.getKeyword(keywords[i]);
        }

        OfertaLaboral ofLab = new OfertaLaboral(nombre, descripcion, ciudad, departamento, horario, remuneracion, fechaDeAlta, manejadorOf.getTipoPublicacion(tipoPublicacion), kws, imagen);
        manejadorOf.addOferta(ofLab);

        ControladorUsuario controladorUsr = new ControladorUsuario();
        controladorUsr.linkearEmpresaPublicacion(empresa, nombre);
    }

    public void altaPostulacion(String postulante, String oferta, String motivacion, String currivitae, LocalDate fecha) throws PostulacionRepetidaException, OfertaExpiradaException {
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();
        OfertaLaboral ofLab = manejadorOf.getOferta(oferta);

        if (ofLab.getPostulacion(postulante) != null) {
            throw new PostulacionRepetidaException("Ya existe una postulacion de este postulante a esa Oferta Laboral");
        } else if (ofLab.getFechaDeExpiracion().isBefore(fecha)) {
            throw new OfertaExpiradaException("La oferta ya expiro en dicha fecha");
        } else if (ofLab.getFechaDeAlta().isAfter(fecha)) {
            throw new OfertaExpiradaException("La oferta no habia sido creada aun en dicha fecha");
        }

        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        ofLab.addPostulacion(new DTPostulacion(postulante, oferta, currivitae, motivacion, fecha), ofLab, (Postulante) manejadorUsr.getPostulante(postulante));
    }

    public void altaKeyword(String keyword) throws KeywordRepetidaException {
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();

        if (manejadorOf.getKeyword(keyword) != null) {
            throw new KeywordRepetidaException("Ya existe dicha keyword");
        }

        manejadorOf.addKeyword(new Keyword(keyword));
    }

    public void altaTipoPublicacion(DTTipoPublicacion tipoP) throws TipoPublicacionRepetidaException {
        ManejadorOferta manejadorOf = ManejadorOferta.getinstance();

        if (manejadorOf.getTipoPublicacion(tipoP.getNombre()) != null) {
            throw new TipoPublicacionRepetidaException("Ya existe un Tipo de Publicacion de Oferta Laboral con ese nombre");
        }

        TipoPublicacion tipoPubli = new TipoPublicacion(tipoP.getNombre(), tipoP.getDescripcion(), tipoP.getExposicion(), tipoP.getTiempoEnPlataforma(), tipoP.getCosto(), tipoP.getFechaAlta());
        manejadorOf.addTipoPubli(tipoPubli);
    }

    public void aceptarOfertaLaboral(OfertaLaboral ofLab) {
        ofLab.setEstado(Estados.CONFIRMADA);
    }

    public void rechazarOfertaLaboral(OfertaLaboral ofLab) {
        ofLab.setEstado(Estados.RECHAZADA);
    }
}
