<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.trabajosuy.model.logicadatatype.DTTipoPublicacion"%>
<%@ page import="com.trabajosuy.model.logicaenums.Departamentos"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<jsp:include page="/WEB-INF/Views/Templates/headTemplate.jsp"/>
	<link rel="stylesheet" type="text/css" href="media/Styles/altaOfertaLaboral.css">
	<script src="Scripts/altaOfertaLaboral.js"></script>
  	<title>Trabajo.uy</title>
</head>

<body>
    <header>
        <jsp:include page="/WEB-INF/Views/Templates/buscadorTemplate.jsp"/>
    </header>
    
    <div class="form-oferta form common-white-component">
        <form id="formAltaOL" action="altaOfertaLaboral" method="POST" onsubmit="return validarRemuneracion()">
            <div class="combo-box-container">
                <label for="opciones">Tipo de Publicacion:</label>
                <select id="opciones" name="tipoPublicacion" required>
                	<% 
                		DTTipoPublicacion[] tiposPublicacion = (DTTipoPublicacion[]) request.getAttribute("tiposPublicacion");
            			int i = 1;
                		for (DTTipoPublicacion tipoPublicacion: tiposPublicacion) {
                	%>
                    <option value="<%= tipoPublicacion.getNombre() %>"> <%= tipoPublicacion.getNombre() %> </option>
                    <%
                		}
                	%>
                </select>
            </div>
            <input type="text" name="nombre" placeholder="nombre" required />
            <input type="text" name="descripcion" placeholder="descripcion" required />
            <input type="text" name="horario" placeholder="horario" required />
            <input type="text" name="remuneracion" placeholder="remuneracion" required pattern="[0-9]+(\.[0-9]+)?" />
            <div class="combo-box-container">
                <label for="opciones">Departamento:</label>
                <select id="opciones3" name="departamento" required>
                	<% 
            			int j = 1;
                		for (Departamentos dep: Departamentos.values()) {
                	%>
                    <option value="<%= dep %>"> <%= dep %> </option>
                    <%
                		}
                	%>
                </select>
            </div>
            <input type="text" name="ciudad" placeholder="ciudad" required />
            <input type="text" name="imagen" placeholder="imagen (opcional)" />
            <div class="combo-box-container">
                <label for="opciones1">Keywords: </label>
                <select id="opciones1" multiple name="keywords">
                	<% 
                		String[] keywords = (String[]) request.getAttribute("keywords");
                		int k = 1;
                		for (String keyword: keywords) {
                	%>
                    <option value="<%= keyword %>"><%= keyword %></option>
                    <%
                		}
                	%>
                </select>
            </div>
            <button type="submit">Registrar Oferta</button>
            <%
           		String estadoAltaOferta = (String) request.getAttribute("estadoAltaOferta");
				if (estadoAltaOferta == "error") {
			%>
           		<h4 style="color:red;">Ya existe una oferta con ese nombre, intente con otro</h4>
           	<% } else if (estadoAltaOferta == "creada") { %>
           		<h4 style="color:green;">La oferta fue creada correctamente</h4>
           	<% } %>
           	
        </form>
    </div>
</body>

</html>