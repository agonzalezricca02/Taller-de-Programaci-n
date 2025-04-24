<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.trabajosuy.model.logicadatatype.DTOfertaLaboral"%>
    <%@page import="com.trabajosuy.model.logicadatatype.DTTipoPublicacion"%>
    <%@page import="com.trabajosuy.model.logicadatatype.DTUsuario"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/Views/Templates/headTemplate.jsp"/>
	<link rel="stylesheet" type="text/css" href="media/Styles/home.css">
 
  <title>Trabajo.uy</title>

</head>

<body>
  <header>
      <jsp:include page="/WEB-INF/Views/Templates/buscadorTemplate.jsp"/>
  </header>
  <div class="principal-container">
    <aside class="keyword-aside common-white-component">
      <div class="aside-container">
        <h2>Keywords</h2>
        <div class="aside-bar"></div>
      </div>
      <div class="keyword-list">
        <ul>
        <% 
			String[] keywords = (String[])request.getAttribute("keywords");
			for(String keyword: keywords){
		%>
			<li class="aside-li">
	            <h3><%= keyword %></h3>
          	</li>
		<% } %>
        </ul>
      </div>
    </aside>
    <main>
    <div id="listar" class="main">
			<% 
				DTOfertaLaboral[] ofertas = (DTOfertaLaboral[])request.getAttribute("ofertas");

				for(DTOfertaLaboral oferta: ofertas){
			%>
			<div class="oferta-laboral-home-container">
        		<div class="oferta-laboral-container">
          			<img alt="Oferta laboral" class="oferta-laboral-img" src="media/img/OfLab/DesarrolladorFrontend.png">
          			<a href="/TrabajosUY/ofertaLaboral?ofertaSeleccionada=<%= oferta.getNombre()  %>">
            			<div class="oferta-laboral-info-container">
              				<h3><%= oferta.getNombre() %></h3>
              				<p><%= oferta.getDescripcion() %></p>
            			</div>
         			 </a>
       			</div>
      		</div>	
			<% } %>
	</div>
    </main>
    <aside class="tipos-de-publicacion-aside common-white-component">
      <div class="aside-container">
        <h2>Tipos de publicación</h2>
        <div class="aside-bar"></div>
      </div>
      <div class="tipos-de-publicacion-list">
        <ul>
        	<% 
        		DTTipoPublicacion[] tiposP = (DTTipoPublicacion[])request.getAttribute("TipoPublicaciones");
				for(DTTipoPublicacion tipo: tiposP){
			%>
			<li class="aside-li abrir-ventana-emergente" data-target="#ventanaTipoDePublicacion<%= tipo.getNombre() %>">
	            <h3><%= tipo.getNombre() %></h3>
          	</li>
			<% } %>
        </ul>
      </div>
    </aside>
  </div>
  <% for(DTTipoPublicacion tipo: tiposP){ %>
	<div id="ventanaTipoDePublicacion<%= tipo.getNombre() %>" class="ventanaEmergente-tdpp">
    	<div class="common-white-component tipo-de-publicacion">
     		<h2><%= tipo.getNombre() %></h2>
      		<p><strong>Descripción:</strong> <%= tipo.getDescripcion() %></p>
      		<p><strong>Exposición:</strong><%= tipo.getExposicion() %></p>
      		<p><strong>Duración:</strong> <%= tipo.getTiempoEnPlataforma() %></p>
      		<p><strong>Costo:</strong> <%= tipo.getCosto() %></p>
      		<p><strong>Fecha de Alta:</strong> <%= tipo.getFechaAlta() %></p>
      		<button class="cerrar-ventana-emergente" data-target="#ventanaTipoDePublicacion<%= tipo.getNombre() %>">Cerrar</button>
    	</div>
  	</div>
  <% } %>
</body>
</html>