<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/500.jsp"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="media/Styles/styles.css">
    <link rel="stylesheet" href="media/Styles/login.css">
    <link rel="stylesheet" href="media/Styles/register.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="Scripts/register.js"></script>
    <title>Trabajo.uy</title>
</head>

<body>
    <div class="login-page">
        <div class="form">
            <form id="form" class="register-form" action="register" method="POST" onsubmit="return validateForm();">
                <input id="nickname" name="nickname" type="text" placeholder="nickname" required/>
                <input id="nombre" name="nombre" type="text" placeholder="nombre" required/>
                <input id="apellido" name="apellido" type="text" placeholder="apellido" required/>
                <input id="password" name="password" type="password" placeholder="contraseña" required/>
                <input id="confirmPassword" name="confirmPassword" type="password" placeholder="confirmación" required/>
                <input id="email" name="email" type="text" placeholder="email" required/>
                <fieldset>
                    <legend>Tipo</legend>
                    <div class="fieldset-container">
                        <div id="div-empresa">
                            <input type="radio" id="empresa" name="tipoUsuario" value="Empresa" style="margin: 0 15px 0 0;"/>
                            <label for="postulante">Empresa</label>
                        </div>
                        <div id="div-postulante">
                            <input type="radio" id="postulante" name="tipoUsuario" value="Postulante"   style="margin: 0 15px 0 0;"/>
                            <label for="postulante">Postulante</label>
                        </div>
                    </div>
                </fieldset>
                <input id="webSite" name="webSite" type="text" placeholder="sitio web" class="opcionales_Empresa"/>
                <textarea id="description" name="description" rows="5" placeholder="descripción" class="opcionales_Empresa" cols="6"  ></textarea>
                <input id="nationality" name="nationality" type="text" placeholder="nacionalidad" class="opcionales_Postulante"/>
                <input id="birthDate" name="birthDate" type="date" placeholder="fecha de nacimiento" class="opcionales_Postulante"/>


                <button type="submit">Registrar</button>
                <p class="message">¿Ya estás registrado? <a href="/TrabajosUY/login">Acceder</a></p>
            </form>
        </div>
    </div>
</body>

</html>