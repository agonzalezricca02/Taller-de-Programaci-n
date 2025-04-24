<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.trabajosuy.model.logicadatatype.DTUsuario"%>
<%@page import="com.trabajosuy.controllers.home"%>
<%@page import="com.trabajosuy.controllers.login"%>
    <div class="navbar-container common-white-component">
      <div id="logo">
        <a href="/TrabajosUY/home">
          <h1>Trabajo.uy</h1>
        </a>
      </div>
      <div class="search-container">
        <input type="text" id="search-input" placeholder="Buscar..." style="width: -webkit-fill-available;">
        <button id="search-button">Buscar</button>
      </div>
      <nav>
        <ul class="lista-horizontal">
        <%
			DTUsuario usr = (DTUsuario) session.getAttribute("usuario_logueado");
			if (usr != null) {
		%>
			<li style="text-align: right; margin-right:10px">
				<a href="usuario.html" style="float: right;">
					<div style="width: 50px; height: 50px; overflow: hidden; border-radius: 50%;">
						<img src="media/img/Usr/U11.jpg" style="width: 100%; height: 100%; object-fit: cover; border-radius: 50%;">
					</div>
				</a>
			</li>
          	<li style="margin-left:10px; margin-top: auto;margin-bottom: auto; text-align-last: left;">
          		<a class="algo" href="usuario.html"><strong><%= usr.getNombre().toUpperCase() %></strong></a>
          	</li>
		<% } else { %>
          <li style="margin-left: 15px;"><a href="/TrabajosUY/login">Iniciar sesión</a></li>
          <li style="margin-right: 15px;" ><a class="algo" href="/TrabajosUY/register">Registrarse</a></li>
		<% } %>
        </ul>
      </nav>
    </div>