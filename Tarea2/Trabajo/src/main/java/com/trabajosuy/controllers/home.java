package com.trabajosuy.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.trabajosuy.model.logicacontroladores.Fabrica;
import com.trabajosuy.model.logicacontroladores.IControladorOferta;
import com.trabajosuy.model.logicadatatype.DTOfertaLaboral;
import com.trabajosuy.model.logicadatatype.DTTipoPublicacion;
import com.trabajosuy.model.logicaenums.EstadoSesion;

/**
 * Servlet implementation class home
 */
@WebServlet ("/home")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public home() {
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
		    
		    Fabrica factory = Fabrica.getInstance();
		    IControladorOferta ctrlOferta = factory.getICtrlOferta();
		    
		    DTOfertaLaboral[] ofertas = ctrlOferta.listarOfertas();
		    String[] keywords = ctrlOferta.listarKeywords();
		    DTTipoPublicacion[] tiposP = ctrlOferta.listarTiposPublicacion();
		    
		    req.setAttribute("ofertas", ofertas);
		    req.setAttribute("keywords", keywords);
		    req.setAttribute("TipoPublicaciones", tiposP);

		    switch (getEstado(req)) {
		        case NO_LOGIN:
		        	req.getRequestDispatcher("/WEB-INF/Views/home.jsp").forward(req, resp);
		        	break;
		        case LOGIN_INCORRECTO:
		            req.getRequestDispatcher("/WEB-INF/Views/home.jsp").forward(req, resp);
		            break;
		        case LOGIN_CORRECTO:
		            req.getRequestDispatcher("/WEB-INF/Views/home.jsp").forward(req, resp);
		            break;
		        default:
		            req.getRequestDispatcher("/WEB-INF/Views/home.jsp").forward(req, resp);
		            break;
		    }
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}

