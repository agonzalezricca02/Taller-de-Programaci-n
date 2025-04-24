<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.trabajosuy.model.logicaenums.EstadoSesion"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="media/Styles/styles.css">
    <link rel="stylesheet" href="media/Styles/login.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>Trabajo.uy</title>
</head>

<body>
    <div class="login-page">
        <div class="form">
            <form action="login" method="POST" class="login-form" onsubmit="return validateForm()";>
                <input type="text" placeholder="nickname" name="nickname" required=""/>
                <input type="password" placeholder="contraseña" name="password" required=""/>
                <button type="submit">Acceder</button>
                <p class="message">¿No estás registrado? <a href="/TrabajosUY/register">Crear una cuenta</a></p>
            	<%
            		EstadoSesion estado = (EstadoSesion) session.getAttribute("estado_sesion");
					if (estado == EstadoSesion.LOGIN_INCORRECTO) {
				%>
            		<h4 style="color:red;">Inicio erróneo, por favor intente nuevamente</h4>
            	<% } %>
            </form>
        </div>
    </div>
</body>

</html>

