document.addEventListener("DOMContentLoaded", function () {
    $(document).ready(function () {
    });

    $('.abrir-ventana-emergente').click(function () {
        var target=$(this).data('target');
        $(target).css("display", "flex");
        console.log("sada");
    });

    $('.cerrar-ventana-emergente').click(function () {
        var target=$(this).data('target');
        $(target).hide();
    });

    $(document).keydown(function (e) {
        if (e.keyCode === 27) {
            $(target).hide();
        }
    });
});