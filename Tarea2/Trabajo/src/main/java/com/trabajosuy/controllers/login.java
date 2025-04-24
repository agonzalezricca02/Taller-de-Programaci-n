package com.trabajosuy.controllers;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.trabajosuy.model.logicaclases.Usuario;
import com.trabajosuy.model.logicacontroladores.Fabrica;
import com.trabajosuy.model.logicacontroladores.IControladorOferta;
import com.trabajosuy.model.logicacontroladores.IControladorUsuario;
import com.trabajosuy.model.logicadatatype.DTUsuario;
import com.trabajosuy.model.logicaenums.EstadoSesion;
import com.trabajosuy.model.logicamanejadores.ManejadorUsuario;
import com.trabajosuy.model.excepciones.UsuarioNoExisteException;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public login() {
		super();
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession objSesion = request.getSession();
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		EstadoSesion nuevoEstado;
		
		try
		{
			Fabrica factory = Fabrica.getInstance();
		    IControladorUsuario ctrlUsuario = factory.getIControladorUsuario();
			DTUsuario usr = ctrlUsuario.getUsuario(nickname);
			if (usr != null) {	
				if (!usr.getContrasena().equals(password))
					nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
				else {
					nuevoEstado = EstadoSesion.LOGIN_CORRECTO;
					request.getSession().setAttribute("usuario_logueado", usr);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
					objSesion.setAttribute("estado_sesion", nuevoEstado);
					dispatcher.forward(request, response);
				}
			}
			else nuevoEstado = EstadoSesion.LOGIN_INCORRECTO; 
		} catch (Exception ex) {
			nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
		}
		objSesion.setAttribute("estado_sesion", nuevoEstado);
		request.getRequestDispatcher("/WEB-INF/Views/login.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}