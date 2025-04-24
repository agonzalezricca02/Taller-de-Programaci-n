document.addEventListener("DOMContentLoaded", function() {
    var form = document.getElementById("formAltaOL");

    form.addEventListener("submit", function(event) {
        if (!validarRemuneracion()) {
            event.preventDefault();
        }
    });

    function validarRemuneracion() {
        var remuneracionInput = document.getElementsByName("remuneracion")[0];
        var remuneracionValue = parseFloat(remuneracionInput.value);

        if (isNaN(remuneracionValue) || remuneracionValue < 0) {
            alert("La remuneración debe ser un número positivo o cero.");
            remuneracionInput.focus();
            return false;
        }

        return true;
    }
});