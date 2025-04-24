package com.trabajosuy.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

import com.trabajosuy.model.excepciones.UsuarioNoExisteException;
import com.trabajosuy.model.excepciones.UsuarioRepetidoException;
import com.trabajosuy.model.logicacontroladores.ControladorUsuario;
import com.trabajosuy.model.logicacontroladores.Fabrica;
import com.trabajosuy.model.logicacontroladores.IControladorUsuario;
import com.trabajosuy.model.logicadatatype.DTEmpresa;
import com.trabajosuy.model.logicadatatype.DTPostulante;
import com.trabajosuy.model.logicadatatype.DTUsuario;
import com.trabajosuy.model.logicaenums.EstadoSesion;
import com.trabajosuy.model.logicamanejadores.ManejadorUsuario;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public register() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Views/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DTUsuario user = null;
		HttpSession objSesion = request.getSession();

		String nickname = request.getParameter("nickname");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String tipoUsuario = request.getParameter("tipoUsuario");
		if (tipoUsuario.equals("Empresa")) {
			String webSite = request.getParameter("webSite");
			String description = request.getParameter("description");
			user = new DTEmpresa(nickname, nombre, apellido, email, password, "", description, webSite);
		} else {
			String nationality = request.getParameter("nationality");
			String birthDate = request.getParameter("birthDate");
			LocalDate fechaNacimiento;

			if (birthDate.isEmpty()) {
			    fechaNacimiento = null;
			} else {
			    fechaNacimiento = LocalDate.parse(birthDate);
			}
			
			user = new DTPostulante(nickname, nombre, apellido, email, password, "", fechaNacimiento, nationality);
		}
		ControladorUsuario ctrlUser = new ControladorUsuario();
		try {
			ctrlUser.altaUsuario(user);
		} catch (UsuarioRepetidoException e) {
			request.getRequestDispatcher("/WEB-INF/Views/register.jsp").forward(request, response);//redirigir a pagina de usuario repetido
		}
		objSesion.setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
		Fabrica factory = Fabrica.getInstance();
	    IControladorUsuario ctrlUsuario = factory.getIControladorUsuario();
		try {
			DTUsuario usr = ctrlUsuario.getUsuario(nickname);
			request.getSession().setAttribute("usuario_logueado", usr);
			response.sendRedirect("home");
		}
		catch (UsuarioNoExisteException ex) {
			
		}
	}
}