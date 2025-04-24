<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="com.trabajosuy.model.logicadatatype.DTEmpresa"
	import="com.trabajosuy.model.logicadatatype.DTPostulante"
	import="com.trabajosuy.model.logicadatatype.DTOfertaLaboral"
	import="com.trabajosuy.model.logicadatatype.DTPostulacion"
	import="com.trabajosuy.model.logicadatatype.DTTipoPublicacion"
    import="java.util.Map"
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Trabajo.uy</title>
</head>
<body>
	<h2>Prueba de datos</h2>
	<%
	DTPostulante[] postulantes = (DTPostulante[]) request.getAttribute("postulantes");
	String[] keywords = (String[]) request.getAttribute("keywords");
	DTTipoPublicacion[] tiposPublicacion = (DTTipoPublicacion[]) request.getAttribute("tiposPublicacion");
	DTEmpresa[] empresas = (DTEmpresa[]) request.getAttribute("empresas");
	Map<String,DTOfertaLaboral[]> ofertas = (Map<String,DTOfertaLaboral[]>) request.getAttribute("ofertas");
	Map<String,DTPostulacion[]> postulaciones = (Map<String,DTPostulacion[]>) request.getAttribute("postulaciones");
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
	
	<h3>Lista de keywords</h3>
	<ul>
		<%
		for(String keyword: keywords){
		%>
		<li><%= keyword %></li>
		<% } %>
	</ul>
	
	<h3>Lista de tipos de publicacion</h3>
	<ul>
		<%
		for(DTTipoPublicacion tipoPublicacion: tiposPublicacion){
		%>
		<li><%= tipoPublicacion %>
			<ul>
				<li>Nombre: <%= tipoPublicacion.getNombre() %> </li>
				<li>Descripcion: <%= tipoPublicacion.getDescripcion() %> </li>
				<li>Costo: <%= tipoPublicacion.getCosto() %> </li>
				<li>Exposicion: <%= tipoPublicacion.getExposicion() %> </li>
				<li>TiempoEnPlataforma: <%= tipoPublicacion.getTiempoEnPlataforma() %> </li>
				<li>FechaAlta: <%= tipoPublicacion.getFechaAlta() %> </li>
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
	
	<h3>Lista de postulaciones</h3>
	<ul>
		<%
		for(String key: postulaciones.keySet()){
			for(DTPostulacion postulacion: postulaciones.get(key)){
		%>
		<li><%= postulacion %>
			<ul>
				<li> <%= postulacion.getPostulante() %> </li>
				<li> <%= postulacion.getOferta() %> </li>
				<li> <%= postulacion.getMotivacion() %> </li>
				<li> <%= postulacion.getCVReducido() %> </li>
				<li> <%= postulacion.getFecha() %> </li>
			</ul>
		</li>
		<% }} %>
	</ul>
</body>
</html>