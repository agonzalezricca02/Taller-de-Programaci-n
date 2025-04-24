<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.trabajosuy.model.logicaclases.OfertaLaboral" %>
<%@ page import="com.trabajosuy.model.logicaclases.Postulacion" %>  
<%@ page import="com.trabajosuy.model.logicaclases.Keyword" %>  
<%@page import="com.trabajosuy.model.logicadatatype.DTOfertaLaboral"%>
<%@page import="com.trabajosuy.model.logicadatatype.DTTipoPublicacion"%>
<%@page import="com.trabajosuy.model.logicadatatype.DTPostulacion"%>
<%@page import="com.trabajosuy.model.logicadatatype.DTPostulante"%>
<%@page import="com.trabajosuy.model.logicadatatype.DTEmpresa"%>

<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <jsp:include page="/WEB-INF/Views/Templates/headTemplate.jsp"/>
  <script src="Scripts/ofertaLaboral.js"></script> 
  <link rel="stylesheet" type="text/css" href="media/Styles/ofertaLaboral.css">
  <title>Trabajo.uy</title>
</head>

<body>
  <header>
    <jsp:include page="/WEB-INF/Views/Templates/buscadorTemplate.jsp"/>
	<%
    	DTOfertaLaboral oferta = (DTOfertaLaboral) request.getAttribute("ofertaSeleccionada");
    	Postulacion post = (Postulacion) request.getAttribute("postulacionSeleccionada");
    %>
  </header>
  <div class="principal-container">
    <div style="grid-column: 1; display: grid; grid-template-rows: auto auto;height: fit-content;">
      <div style="grid-row: 2;margin-top: 15px;" class="button-container">
        <button>
          <h3 style="text-align: center; color: black;">Cerrar Sesión</h3>
        </button>
      </div>
    </div>
    <main style="padding: 20px;">    
    	<div id="carrusel-ofertas" class="oferta " style="display: flex;">
    		<div>
          		<h2><%= oferta.getNombre()%></h2>
          		<img style="width: 100%; height: 100%; max-width: 150px; max-height: 150px;" class="imagen-oferta" src="media/img/OfLab/DesarrolladorFrontend.png" alt="Imagen de la Oferta">
        	</div>
        	<div>
          		<p><strong>Descripción:</strong> <%= oferta.getDescripcion() %> </p>
          		<p><strong>Departamento:</strong> <%= oferta.getDepartamento() %> </p>
          		<p><strong>Ciudad:</strong> <%= oferta.getCiudad() %> </p>
          		<p><strong>Horario Laboral:</strong> <%= oferta.getHorarioLaboral() %></p>
          		<p><strong>Remuneración:</strong> <%= oferta.getRemuneracion() %></p>
          		<p><strong>Tipo de Publicación:</strong> <%= oferta.getTipo().getNombre() %> 
          		<a class="ver-mas-tdpp abrir-ventana-emergente" data-target="#ventanaTipoDePublicacionVerMas">Ver más</a> </p>
          		<p><strong>Fecha de Alta:</strong> <%= oferta.getFechaDeAlta() %></p>
          		<p><strong>Keywords:</strong> </p>
    			<ul class="ListaKeywords">
        		<% 
            		String[] keywords = oferta.getKeywords();
            		for (String keyword : keywords) {
        		%>
        			<li class="tipoli"><%= keyword %></li>
        		<% } %>
    			</ul>
        	</div>
      	</div>
      	<div style="text-align:center; display:flex; justify-content:space-between;">
        	<div style="align-items: center;">
          		<button id="postEmergenteBoton" class="buttonsInline" >Postularse</button>
          		
          		 <%
           		String estadoPostulante = (String) request.getAttribute("estadoPostulante");
				if (estadoPostulante == "error") {
			%>
         		<h4 style="color:red;">Ya estas postulado a esta oferta laboral</h4>
         <%--   	<% } else if (estadoPostulante == "creada") { %>
           		<h4 style="color:green;">La oferta fue creada correctamente</h4> --%>
           	<% } %>
           	
          		
          		
          		
          		
          		<button id="miPostEmergenteBoton"  data-target="#ventanaConsultaPostulacion1">Mi postulacion</button>
        	</div>
      	</div>
    </main>
	<%
	
		boolean esPostulante = (boolean) request.getAttribute("esPostulante");
		boolean esEmpresa = (boolean) request.getAttribute("esEmpresa");
		boolean esOfertaEmpresa = (boolean) request.getAttribute("esOfertaEmpresa");
		
		
        if (!esPostulante && esEmpresa && esOfertaEmpresa) {
    %>
    <aside class="postulante-aside common-white-component" style="margin: 0px 10px;">
      <div style="padding: 0 10px">
        <h2 style="text-align:center; padding-bottom: 5px;">Postulantes</h2>
        <div style="border: 2px solid #969696; border-radius: 50%;"></div>
      </div>
      <div class="postulantes-list">
        <ul>
      	<% 
      		DTPostulacion[] postulaciones = (DTPostulacion[]) request.getAttribute("postulaciones");
            for (DTPostulacion postulacion : postulaciones) {
        %>
        	<li class="postulante-li " data-target="#ventanaConsultaPostulacion<%= postulacion.getPostulante() %>">
            	<h3><%= postulacion.getPostulante() %></h3>
            	<img class="imgUsuarioPostulacion" style="max-width: 150px; max-height: 150px; width: 100%; height: 100%;" src="media/img/OfLab/DesarrolladorFrontend.png">
          	</li>
        <% } %>
        </ul>
      </div>
    </aside>
    
    <% for (DTPostulacion postulacion: postulaciones) { %>
  <div id="ventanaConsultaPostulacion<%= postulacion.getPostulante() %>" class="ventanaEmergente">
    <div class="form">
      <p><strong>Postulante:</strong></p>
      <div class="usuarioPostulado">
        <img id="imgUsuarioPostulacion" src="media/img/OfLab/DesarrolladorFrontend.png" height="100px" wigth="100px">
        <p id="pUsuarioPostulacion"><%= postulacion.getPostulante() %> </p>
      </div>


      <p><strong> Motivacion:</strong> <%= postulacion.getMotivacion() %>  </p>
	  <p><strong> Cv:</strong> <%= postulacion.getCVReducido() %>  </p>
      <p><strong> Fecha postulacion:</strong> <%= postulacion.getFecha() %>  </p>
      <button class="cerrarPostulacionBoton2" data-target="#ventanaConsultaPostulacion<%= postulacion.getPostulante() %>">Cerrar</button>
    </div>
  </div>
  <% } %>
    
    
    
    
    
    
    <% } %>
  </div>
  
  

  	<% DTTipoPublicacion tipo = (DTTipoPublicacion)request.getAttribute("TipoPublicacion"); %>
	<div id="ventanaTipoDePublicacionVerMas" class="ventanaEmergente-tdpp">
    	<div class="common-white-component tipo-de-publicacion">
     		<h2><%= tipo.getNombre() %></h2>
      		<p><strong>Descripción:</strong> <%= tipo.getDescripcion() %></p>
      		<p><strong>Exposición:</strong><%= tipo.getExposicion() %></p>
      		<p><strong>Duración:</strong> <%= tipo.getTiempoEnPlataforma() %></p>
      		<p><strong>Costo:</strong> <%= tipo.getCosto() %></p>
      		<p><strong>Fecha de Alta:</strong> <%= tipo.getFechaAlta() %></p>
      		<button class="cerrar-ventana-emergente" data-target="#ventanaTipoDePublicacionVerMas"  >Cerrar</button>
    	</div>
  	</div>
  
  
  
  
  
  <div id="ventanaPostulacion" class="ventanaEmergente">
    <div class="form">
      <form>
        <textarea rows=3 placeholder="motivacion" required></textarea>
        <textarea rows=5 placeholder="cv" required></textarea>
        <button class="buttonsInline">Postularse</button>
        <button id="cerrarPostulacionBoton" class="buttonsInline">Cancelar</button>
      </form>
    </div>
  </div>

  

</body>

</html>