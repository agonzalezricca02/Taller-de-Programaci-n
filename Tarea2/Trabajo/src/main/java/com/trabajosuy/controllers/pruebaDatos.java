package com.trabajosuy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.trabajosuy.model.excepciones.UsuarioNoExisteException;
import com.trabajosuy.model.logicacontroladores.Fabrica;
import com.trabajosuy.model.logicacontroladores.IControladorOferta;
import com.trabajosuy.model.logicacontroladores.IControladorUsuario;
import com.trabajosuy.model.logicadatatype.DTEmpresa;
import com.trabajosuy.model.logicadatatype.DTOfertaLaboral;
import com.trabajosuy.model.logicadatatype.DTPostulacion;
import com.trabajosuy.model.logicadatatype.DTPostulante;

/**
 * Servlet implementation class pruebaDatos
 */
@WebServlet ("/pruebaDatos")
public class pruebaDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public pruebaDatos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		DTPostulante[] postulantes = (DTPostulante[]) getServletContext().getAttribute("postulantes");
		String[] keywords = (String[]) getServletContext().getAttribute("keywords");
		DTTipoPublicacion[] tiposPublicacion = (DTTipoPublicacion[]) getServletContext().getAttribute("tiposPublicacion");
		DTEmpresa[] empresas = (DTEmpresa[]) getServletContext().getAttribute("empresas");
		Map<String,DTOfertaLaboral[]> ofertas = (Map<String,DTOfertaLaboral[]>) getServletContext().getAttribute("ofertas");
		Map<String,DTPostulacion[]> postulaciones = (Map<String,DTPostulacion[]>) getServletContext().getAttribute("postulaciones");
		
		request.setAttribute("postulantes", postulantes);
		request.setAttribute("keywords", keywords);
		request.setAttribute("tiposPublicacion", tiposPublicacion);
		request.setAttribute("empresas", empresas);
		request.setAttribute("ofertas", ofertas);
		request.setAttribute("postulaciones", postulaciones);*/
		
		Fabrica fab = Fabrica.getInstance();
		IControladorUsuario cU = fab.getIControladorUsuario();
    	IControladorOferta cO = fab.getICtrlOferta();

    	DTPostulante[] postulantes;
		try {
			postulantes = cU.listarPostulantes();
			request.setAttribute("postulantes", postulantes);
			
		} catch (UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	DTEmpresa[] empresas;
		try {
			empresas = cU.listarEmpresas();
			request.setAttribute("empresas", empresas);
			
			Map<String,DTOfertaLaboral[]> ofertas = new HashMap<String,DTOfertaLaboral[]>();
			for(DTEmpresa empresa: empresas) {
				ofertas.put(empresa.getNickname(),cO.listarOfertasUsuario(empresa.getNickname()));
			}
			request.setAttribute("ofertas", ofertas);
			
			Map<String,DTPostulacion[]> postulaciones = new HashMap<String,DTPostulacion[]>();
			for(String key: ofertas.keySet()) {
				for(DTOfertaLaboral oferta: ofertas.get(key)) {
					postulaciones.put(oferta.getNombre(),cO.listarPostulaciones(oferta.getNombre()));
				}
			}
			request.setAttribute("postulaciones", postulaciones);
		} catch (UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		request.setAttribute("keywords", cO.listarKeywords());
		request.setAttribute("tiposPublicacion", cO.listarTiposPublicacion());
		
		request.getRequestDispatcher("/WEB-INF/Views/pruebaDatos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
