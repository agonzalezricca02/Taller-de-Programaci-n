jQuery(document).ready(function() {

	$(document).ready(function () {
        $('.hardcode-login-U11').show();
        $('.hardcode-login-U1').hide();
        const miSelect = document.getElementById('hardcode-login-select');
        miSelect.addEventListener('change', function () {
            $('.hardcode-login-U11').hide();
            $('.hardcode-login-U1').hide();
    
            const opcionSeleccionada = $(this).val();
    
            $(`.hardcode-login-${opcionSeleccionada}`).show();
        });
    });



	jQuery('.tabs .tab-links a').on('click', function(e) {
		var currentAttrValue = jQuery(this).attr('href');

		// Mostrar u ocultar pestañas (animación slide 1).
        jQuery('.tabs ' + currentAttrValue).siblings().slideUp(400);
        jQuery('.tabs ' + currentAttrValue).delay(400).slideDown(400);
		// Cambiar la pestaña activa.
		jQuery(this).parent('li').addClass('active').siblings().removeClass('active');

		e.preventDefault();
	});
});