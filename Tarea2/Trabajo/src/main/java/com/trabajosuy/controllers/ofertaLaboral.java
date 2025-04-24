package com.trabajosuy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.trabajosuy.model.excepciones.OfertaExpiradaException;
import com.trabajosuy.model.excepciones.OfertaRepetidaException;
import com.trabajosuy.model.excepciones.PostulacionRepetidaException;
import com.trabajosuy.model.excepciones.UsuarioNoExisteException;

import java.io.IOException;
import java.time.LocalDate;

import com.trabajosuy.model.logicaclases.Keyword;
import com.trabajosuy.model.logicaclases.OfertaLaboral;
import com.trabajosuy.model.logicaclases.TipoPublicacion;
import com.trabajosuy.model.logicacontroladores.ControladorOferta;
import com.trabajosuy.model.logicacontroladores.Fabrica;
import com.trabajosuy.model.logicacontroladores.IControladorOferta;
import com.trabajosuy.model.logicacontroladores.IControladorUsuario;
import com.trabajosuy.model.logicadatatype.DTEmpresa;
import com.trabajosuy.model.logicadatatype.DTOfertaLaboral;
import com.trabajosuy.model.logicadatatype.DTPostulacion;
import com.trabajosuy.model.logicadatatype.DTPostulante;
import com.trabajosuy.model.logicadatatype.DTTipoPublicacion;
import com.trabajosuy.model.logicadatatype.DTUsuario;
import com.trabajosuy.model.logicaenums.Departamentos;
import com.trabajosuy.model.logicaenums.EstadoSesion;
import com.trabajosuy.model.logicamanejadores.ManejadorOferta;
import com.trabajosuy.controllers.cargaDatos;

@WebServlet ("/ofertaLaboral")
public class ofertaLaboral extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ofertaLaboral() {
        super();
    }
	
    public static void initSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("estado_sesion") == null) {
			session.setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
		}
	}
	
	public static EstadoSesion getEstado(HttpServletRequest request){
		return (EstadoSesion) request.getSession().getAttribute("estado_sesion");
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    initSession(req);

		    switch (getEstado(req)) {
		        case NO_LOGIN:
		        	req.getRequestDispatcher("/WEB-INF/Views/ofertaLaboral.jsp").forward(req, resp);
		        	System.out.println("A");
		        	break;
		        case LOGIN_INCORRECTO:
		            req.getRequestDispatcher("/WEB-INF/Views/ofertaLaboral.jsp").forward(req, resp);
		            break;
		        case LOGIN_CORRECTO:
		            req.getRequestDispatcher("/WEB-INF/Views/ofertaLaboral.jsp").forward(req, resp);
		            break;
		        default:
		            req.getRequestDispatcher("/WEB-INF/Views/ofertaLaboral.jsp").forward(req, resp);
		            break;
		    }
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oferta = request.getParameter("ofertaSeleccionada");
		DTUsuario usr = (DTUsuario) request.getSession().getAttribute("usuario_logueado");
		request.setAttribute("esPostulante", usr instanceof DTPostulante);
		request.setAttribute("esEmpresa", usr instanceof DTEmpresa);
		
		
		
		Fabrica factory = Fabrica.getInstance();
	    IControladorOferta ctrlOferta = factory.getICtrlOferta();
	    IControladorUsuario ctrlUsu = factory.getIControladorUsuario();
	    
	    DTTipoPublicacion tipoP = ctrlOferta.getTipoOferta(oferta);
	    DTOfertaLaboral DToferta = ctrlOferta.getOferta(oferta);
	    DTPostulacion[] postulaciones = ctrlOferta.listarPostulaciones(oferta);
	    
	   
	    
		request.setAttribute("TipoPublicacion", tipoP);
        request.setAttribute("ofertaSeleccionada", DToferta);
        request.setAttribute("postulaciones", postulaciones);
        
        if (request.getAttribute("esEmpresa") != null && request.getAttribute("usuario_logueado") != null) {
        	 boolean empresaOferta = ctrlOferta.getEmpresaOferta(usr.getNickname() , oferta);
        	request.setAttribute("esOfertaEmpresa",empresaOferta);
        } else {
        	request.setAttribute("esOfertaEmpresa",false);
        }
        
        
        request.getRequestDispatcher("/WEB-INF/Views/ofertaLaboral.jsp").forward(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String oferta = request.getParameter("ofertaSeleccionada");
		DTUsuario postulante = (DTUsuario) request.getSession().getAttribute("usuario_logueado");
		String motivacion = request.getParameter("motivacion");
	    String cv = request.getParameter("cv");
		
		Fabrica factory = Fabrica.getInstance();
	    IControladorOferta ctrlOferta = factory.getICtrlOferta();
	    IControladorUsuario ctrlUsu = factory.getIControladorUsuario();
		
	    /* Falta hacer algo asi
	    if (request.getAttribute("estadoAltaOferta") == null) {
		    request.setAttribute("estadoAltaOferta", "correcto");
	    }
		
	    request.getRequestDispatcher("/WEB-INF/Views/altaOfertaLaboral.jsp").forward(request, response);
		
	} else {
		response.sendRedirect("home");
	}
} */
	    
	    
	    
		try {
			ctrlOferta.altaPostulacion(postulante.getNickname() ,oferta, motivacion,cv,LocalDate.now());
			request.setAttribute("estadoPostulante", "creada");
			request.getRequestDispatcher("/WEB-INF/Views/ofertaLaboral.jsp").forward(request, response);
	    } catch (PostulacionRepetidaException exce ) {
			request.setAttribute("estadoPostulante", "error");
	    	request.getRequestDispatcher("/WEB-INF/Views/ofertaLaboral.jsp").forward(request, response);
		} catch (OfertaExpiradaException e) {
			e.printStackTrace();
		}
		
		
	}
	
		
	

}