document.addEventListener("DOMContentLoaded", function() {
	$('.opcionales_Empresa, .opcionales_Postulante').hide();

	$('input[type="radio"]').change(function() {
		var opcionSeleccionada = $(this).val();
		if (opcionSeleccionada == "Empresa") {
			$('.opcionales_Empresa').show();
			$('.opcionales_Postulante').hide();
		} else {
			$('.opcionales_Postulante').show();
			$('.opcionales_Empresa').hide();
		}
	});
	function validateForm() {
		var nickname = document.getElementById("nickname").value;
		var nombre = document.getElementById("nombre").value;
		var apellido = document.getElementById("apellido").value;
		var password = document.getElementById("password").value;
		var confirmPassword = document.getElementById("confirmPassword").value;
		var email = document.getElementById("email").value;
		var empresa = document.getElementById("empresa").checked;
		var postulante = document.getElementById("postulante").checked;

		if (!nickname || !nombre || !apellido || !password || !confirmPassword || !email || (!empresa && !postulante)) {
			alert("Por favor, complete todos los campos requeridos.");
			return false;
		}

		if (password != confirmPassword) {
			alert("Las contraseñas no coinciden");
			return false;
		}

		return true;
	}

	var form = document.getElementById("form");
	form.addEventListener("submit", function(event) {
		if (!validateForm()) {
			event.preventDefault(); // Evita que el formulario se envíe si no pasa la validación
		}
	});
});