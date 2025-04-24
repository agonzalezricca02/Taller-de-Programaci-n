package com.trabajosuy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import com.trabajosuy.model.excepciones.OfertaRepetidaException;
import com.trabajosuy.model.excepciones.UsuarioNoExisteException;
import com.trabajosuy.model.logicaenums.Departamentos;
import com.trabajosuy.model.logicacontroladores.Fabrica;
import com.trabajosuy.model.logicacontroladores.IControladorOferta;
import com.trabajosuy.model.logicacontroladores.IControladorUsuario;
import com.trabajosuy.model.logicadatatype.DTEmpresa;
import com.trabajosuy.model.logicadatatype.DTPostulante;
import com.trabajosuy.model.logicadatatype.DTTipoPublicacion;
import com.trabajosuy.model.logicadatatype.DTUsuario;

@WebServlet ("/altaOfertaLaboral")
public class altaOfertaLaboral extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
            
    public altaOfertaLaboral() {
        super();
    }    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DTUsuario usr = (DTUsuario) request.getSession().getAttribute("usuario_logueado");
		
		if (usr==null) {
			response.sendRedirect("login");
			
		} else if (usr instanceof DTEmpresa) {
			
			Fabrica factory = Fabrica.getInstance();
		    IControladorOferta ctrlOferta = factory.getICtrlOferta();
		    
			String[] keywords = ctrlOferta.listarKeywords();
		    DTTipoPublicacion[] tiposPublicacion = ctrlOferta.listarTiposPublicacion();
		    
		    request.setAttribute("keywords", keywords);
		    request.setAttribute("tiposPublicacion", tiposPublicacion);
		    
		    if (request.getAttribute("estadoAltaOferta") == null) {
			    request.setAttribute("estadoAltaOferta", "correcto");
		    }
			
		    request.getRequestDispatcher("/WEB-INF/Views/altaOfertaLaboral.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("home");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	    DTUsuario empresa = (DTUsuario) request.getSession().getAttribute("usuario_logueado");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String horario = request.getParameter("horario");
		float remuneracion = Float.parseFloat(request.getParameter("remuneracion"));
		Departamentos departamento = Departamentos.valueOf(request.getParameter("departamento"));
		String ciudad = request.getParameter("ciudad");
		String imagen = request.getParameter("imagen");
		String[] keywordsSelected = request.getParameterValues("keywords");
		if (keywordsSelected == null) {
			keywordsSelected = new String[0];
		}
		String tipoPublicacion = request.getParameter("tipoPublicacion");
		
		Fabrica factory = Fabrica.getInstance();
	    IControladorOferta ctrlOferta = factory.getICtrlOferta();
	    
	    String[] keywords = ctrlOferta.listarKeywords();
	    DTTipoPublicacion[] tiposPublicacion = ctrlOferta.listarTiposPublicacion();
	    
	    request.setAttribute("keywords", keywords);
	    request.setAttribute("tiposPublicacion", tiposPublicacion);
	    
	    try {
			ctrlOferta.altaOferta(empresa.getNickname(), tipoPublicacion, nombre, descripcion, ciudad, departamento, horario, remuneracion, LocalDate.now(), keywordsSelected, imagen);
			request.setAttribute("estadoAltaOferta", "creada");
			request.getRequestDispatcher("/WEB-INF/Views/altaOfertaLaboral.jsp").forward(request, response);
	    } catch (OfertaRepetidaException e) {
			request.setAttribute("estadoAltaOferta", "error");
	    	request.getRequestDispatcher("/WEB-INF/Views/altaOfertaLaboral.jsp").forward(request, response);
		}
	}	
}