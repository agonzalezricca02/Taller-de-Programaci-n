<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.trabajosuy.model.logicadatatype.DTOfertaLaboral"%>
    <%@page import="com.trabajosuy.model.logicadatatype.DTUsuario"%>
    <%@page import="com.trabajosuy.model.logicadatatype.DTPostulante"%>
    <%@page import="com.trabajosuy.model.logicadatatype.DTEmpresa"%>
    <%@page import="java.util.Map"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="Scripts/script.js"></script>
  <script src="Scripts/usuario.js"></script>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Bitter:wght@500&display=swap" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="media/Styles/styles.css">
  <link rel="stylesheet" type="text/css" href="media/Styles/usuario.css">
  <title>Trabajo.uy</title>

</head>

<body>
  <header>
    
    <div class="hardcode-login">
      <select id="hardcode-login-select" name="opciones">
        <option value="U11">U11</option>
        <option value="U1">U1</option>
      </select>
    </div>

    <div class="navbar-container common-white-component">
      <div id="logo">
        <a href="/WEB-INF/Views/home.jsp"">
          <h1>Trabajo.uy</h1>
        </a>
      </div>
      <div class="search-container">
        <input type="text" id="search-input" placeholder="Buscar..." style="width: -webkit-fill-available;">
        <button id="search-button">Buscar</button>
      </div>
      <nav>
        <ul class="lista-horizontal">
          <li style="text-align: right;" class="hardcode-login-U1"><a href="usuario.html"><img
            id="imgPostulanteLogeado" src="media/img/Usr/U1.jpeg" height="50px" wigth="50px"></a></li>
      <li style="margin-top: auto;margin-bottom: auto;" class="hardcode-login-U1"><a
          id="aNickPostulanteLogeado" class="algo" href="usuario.html">lgarcia</a></li>

      <li style="text-align: right;" class="hardcode-login-U11"><a href="usuario.html"><img
            src="media/img/Usr/U11.jpg" height="50px" wigth="50px"></a></li>
      <li style="margin-top: auto;margin-bottom: auto;" class="hardcode-login-U11"><a class="algo"
          href="usuario.html">EcoTech</a></li>

          
        </ul>
      </nav>
      <div>
      </div>
    </div>
  </header>

  <div class="principal-container">
    
    <main class="hardcode-login-U11" style="padding: 20px;">
      <div style="display: flex;">
        <img class="imagen-logo" src="media/img/Usr/U11.jpg" alt="logo">
        <div style="align-self: center;">
          <h1 style="text-align: center; color: black;"> Sophia Johnson</h1>
          <h2 style="text-align: center; color: rgb(83, 81, 81);"> info@EcoTech.com</h2>
        </div>
      </div>
      <div>
        <div class="tabs">
          <ul class="tab-links">
          <li class="active"><a href="#tab1">Postulantes</a></li>
          	<% 
          		DTPostulante[] postulantes = (DTPostulante[]) request.getAttribute("postulantes");
          		DTEmpresa[] empresas = (DTEmpresa[]) request.getAttribute("empresas");
          		Map<String,DTOfertaLaboral[]> ofertas = (Map<String,DTOfertaLaboral[]>) request.getAttribute("ofertas");
          	
			%>
	
     <h3>Lista de postulantes</h3>
	<ul>
		<%
		for(DTPostulante postulante: postulantes){
		%>
		<li>
			<%= postulante %>
			<ul>
				<li> <%= postulante.getNombre() %> </li>
				<li> <%= postulante.getApellido() %> </li>
				<li> <%= postulante.getEmail() %> </li>
				<li> <%= postulante.getNacionalidad() %> </li>
				<li> <%= postulante.getFechaNacimiento() %> </li>
				<li> <%= postulante.getContrasena() %> </li>
				<li> <%= postulante.getImagen() %> </li>
			</ul>
		</li>
		<% } %>
	</ul>
	
	
	<h3>Lista de empresas</h3>
	<ul>
		<%
		for(DTEmpresa empresa: empresas){
		%>
		<li><%= empresa %>
			<ul>
				<li> <%= empresa.getNombre() %> </li>
				<li> <%= empresa.getApellido() %> </li>
				<li> <%= empresa.getEmail() %> </li>
				<li> <%= empresa.getDescripcion() %> </li>
				<li> <%= empresa.getSitioWeb() %> </li>
				<li> <%= empresa.getContrasena() %> </li>
			</ul>
		</li>
		<% } %>
	</ul>
	
	<h3>Lista de ofertas</h3>
	<ul>
		<%
		for(String key: ofertas.keySet()){
			for(DTOfertaLaboral oferta: ofertas.get(key)){
		%>
		<li><%= oferta %>
			<ul>
				<li> <%= oferta.getNombre() %> </li>
				<li> <%= oferta.getCiudad() %> </li>
				<li> <%= oferta.getHorarioLaboral() %> </li>
				<li> <%= oferta.getDescripcion() %> </li>
				<li> <%= oferta.getRemuneracion() %> </li>
				<li> <%= oferta.getDepartamento() %> </li>
				<li> <%= oferta.getEstado() %> </li>
				<li> <%= oferta.getFechaDeAlta() %> </li>
				<li> <%= oferta.getImagen() %> </li>
				<li> keywords:
					<ul>
						<% for(String keys: oferta.getKeywords()){ %>
							<li> <%= keys %> </li>
						<% } %>
					</ul>
				</li>
			</ul>
		</li>
		<% }} %>
	</ul>
			
			
			//Faltan las Ofertas
	
            <li><a href="#tab2">Ofertas Laborales</a></li>
          </ul>
          

            <div id="tab2" class="tab" style="display: none;">
              <h4 style="text-align: left; color: rgb(21, 20, 20);"> Nombre: Desarrollador Frontend </h4>
              <h4 style="text-align: left; color: rgb(21, 20, 20);"> Estado: Confirmada </h4>
              <ul>
              	<li class="aside-li abrir-ventana-emergente" data-target="#ventanaDetallesOferta">
            		<h4 style=" text-align: left; color: blue;"> Ver Detalles </h4>
              	</li>
              </ul>
              <div id="ventanaDetallesOferta" class="ventanaEmergente-tdpp">
    				<div class="common-white-component detalles-de-oferta">
      					<h2>Desarrollador Frontend</h2>
      					<h4 style="text-align: left; color: rgb(21, 20, 20);"> Descripción: Unete a nuestro equipo de desarrollo frontend y crea experiencias de usuario excepcionales. </h4>
              			<h4 style="text-align: left; color: rgb(21, 20, 20);"> Ciudad: Montevideo </h4>
              			<h4 style="text-align: left; color: rgb(21, 20, 20);"> Departamento: Montevideo </h4>
              			<h4 style="text-align: left; color: rgb(21, 20, 20);"> Horario: 09:00-18:00 </h4>
              			<h4 style="text-align: left; color: rgb(21, 20, 20);"> Remuneración: $UYU 90000 </h4>
              			<h4 style="text-align: left; color: rgb(21, 20, 20);"> Fecha de Alta: 14/08/23 </h4>
      					<button class="cerrar-ventana-emergente" data-target="#ventanaDetallesOferta">Cerrar</button>
    				</div>
  			  </div>    
           </div>

          </div>
        </div>
      </div>
    </main>

    <main class="hardcode-login-U1" style="padding: 20px;">
      <div style="display: flex;">
        <img class="imagen-logo" src="media/img/Usr/U1.jpeg" alt="logo">
        <div style="align-self: center;">
          <h1 style="text-align: center; color: black;"> lgarcia</h1>
          <h2 style="text-align: center; color: rgb(83, 81, 81);"> lgarcia85@gmail.com</h2>
        </div>
      </div>
      <div>
        <div class="tabs">
          <ul class="tab-links">
            <li class="active"><a href="#tab1">Perfil</a></li>
            <li><a href="#tab2">Postulaciones</a></li>
          </ul>
          <div class="tab-content">
            <div id="tab1" class="tab active" style="display: block;">
              <h4 style="text-align: left; color: rgb(21, 20, 20);"> Nickname: lgarcia </h4>
              <h4 style="text-align: left; color: rgb(21, 20, 20);"> Nombre: Lucía </h4>
              <h4 style="text-align: left; color: rgb(21, 20, 20);"> Apellido: García </h4>
              <h4 style="text-align: left; color: rgb(21, 20, 20);"> Email: lgarcia85@gmail.com </h4>
              <h4 style="text-align: left; color: rgb(21, 20, 20);"> Fecha de naciemiento: 15/03/1985 </h4>
              <h4 style="text-align: left; color: rgb(21, 20, 20);"> Nacionalidad: Uruguaya</h4>
            </div>

            <div id="tab2" class="tab" style="display: none;">
              <h4 style="text-align: left; color: rgb(21, 20, 20);"> Nombre de la oferta: <a href="WEB-INF/Views/ofertaLaboral.jps">Desarrollador Frontend</a> </h4>
              <h4 style="text-align: left; color: rgb(21, 20, 20);"> Motivacion: Estoy emocionada por la oportunidad de 
                formar parte de un equipo dinámico y contribuir con mis habilidades de liderazgo. </h4>
              <h4 style="text-align: left; color: rgb(21, 20, 20);"> CV: Licenciada en Administración, experiencia en gestión 
                de equipos y proyectos. Conocimientos en Microsoft Office </h4>
              <h4 style="text-align: left; color: rgb(21, 20, 20);"> Fecha postulacion: 16/08/23 </h4>
            </div>

          </div>
        </div>
      </div>
    </main>
  </div>
</body>