document.addEventListener("DOMContentLoaded", function() {
	function validateForm() {
		var nickname = document.getElementById("nickname").value;
		var password = document.getElementById("password").value;

		if (!nickname || !password) {
			alert("Por favor, complete todos los campos requeridos.");
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