package com.trabajosuy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.trabajosuy.model.logicacontroladores.Fabrica;
import com.trabajosuy.model.logicacontroladores.IControladorOferta;
import com.trabajosuy.model.logicacontroladores.IControladorUsuario;
import com.trabajosuy.model.logicadatatype.DTOfertaLaboral;
import com.trabajosuy.model.logicadatatype.DTPostulante;
import com.trabajosuy.model.logicadatatype.DTEmpresa;
import com.trabajosuy.model.excepciones.*;

/**
 * Servlet implementation class usuario
 */
@WebServlet ("/usuario")
public class usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usuario() {
        super();
    }
    
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, UsuarioNoExisteException {
	    Fabrica factory = Fabrica.getInstance();
	    IControladorUsuario ctrlUsuario = factory.getIControladorUsuario();
	    IControladorOferta ctrlOferta = factory.getICtrlOferta();
	 
	    DTPostulante[] postulantes;
		try {
			postulantes = ctrlUsuario.listarPostulantes();
			req.setAttribute("postulantes", postulantes);
			
		} catch (UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	DTEmpresa[] empresas;
		try {
			empresas = ctrlUsuario.listarEmpresas();
			req.setAttribute("empresas", empresas);
			
			Map<String,DTOfertaLaboral[]> ofertas = new HashMap<String,DTOfertaLaboral[]>();
			for(DTEmpresa empresa: empresas) {
				ofertas.put(empresa.getNickname(),ctrlOferta.listarOfertasUsuario(empresa.getNickname()));
			}
			req.setAttribute("ofertas", ofertas);
			
		} catch (UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Views/usuario.jsp").forward(request, response);
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | UsuarioNoExisteException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | UsuarioNoExisteException e) {
			e.printStackTrace();
		}
	}

}
