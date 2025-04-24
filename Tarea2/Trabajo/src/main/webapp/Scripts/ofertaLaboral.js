
document.addEventListener("DOMContentLoaded", function () {
/* 
    $(document).ready(function () {
        $('.hardcode-login-visitante').show();
        $('.hardcode-login-empresa').hide();
        $('.hardcode-login-postulante').hide();
    
    
        const miSelect = document.getElementById('hardcode-login-select');
        miSelect.addEventListener('change', function () {
            $('.hardcode-login-visitante').hide();
            $('.hardcode-login-empresa').hide();
            $('.hardcode-login-postulante').hide();
    
            const opcionSeleccionada = $(this).val();
    
            $(`.hardcode-login-${opcionSeleccionada}`).show();

            var opcionSeleccionadaOferta = $('#hardcode-oferta-select').val();

            if (opcionSeleccionada=="postulante"){
                if (opcionSeleccionadaOferta=="O1"){
                    $('.hardcode-postulado').show();
                    $('.hardcode-noPostulado').hide();
                }else if (opcionSeleccionadaOferta=="O7"){
                    $('.hardcode-noPostulado').show();
                    $('.hardcode-postulado').hide();
                }
            } else {
                $('.hardcode-postulado').hide();
                $('.hardcode-noPostulado').hide();
            }
        });
    });

    $(document).ready(function () {
        const miSelect = document.getElementById('hardcode-post');
        var opcionSeleccionada = $('#hardcode-oferta-select').val();
        var opcionSeleccionadaVista = $("#hardcode-login-select").val();

        if (opcionSeleccionadaVista=="postulante"){
            if (opcionSeleccionada=="O1"){
                $('.hardcode-postulado').show();
                $('.hardcode-noPostulado').hide();
            }else if (opcionSeleccionada=="O7"){
                $('.hardcode-noPostulado').show();
                $('.hardcode-postulado').hide();
            }
        } else {
            $('.hardcode-postulado').hide();
            $('.hardcode-noPostulado').hide();
        }
        miSelect.addEventListener('change', function () {
            $('.hardcode-postulado').hide();
            $('.hardcode-noPostulado').hide();
    
            const opcionSeleccionada = $(this).val();    

            $(`.hardcode-${opcionSeleccionada}`).show();
        });
    });

    $(document).ready(function () {
        $('.hardcode-oferta-O1').show();
        $('.hardcode-oferta-O7').hide();
        const miSelect = document.getElementById('hardcode-oferta-select');
        miSelect.addEventListener('change', function () {
            $('.hardcode-oferta-O1').hide();
            $('.hardcode-oferta-O7').hide();
    
            const opcionSeleccionada = $(this).val();
    
            $(`.hardcode-oferta-${opcionSeleccionada}`).show();
            
            var opcionSeleccionadaVista = $("#hardcode-login-select").val();
            if (opcionSeleccionadaVista=="postulante"){
                if (opcionSeleccionada=="O1"){
                    $('.hardcode-postulado').show();
                    $('.hardcode-noPostulado').hide();
                }else if (opcionSeleccionada=="O7"){
                    $('.hardcode-noPostulado').show();
                    $('.hardcode-postulado').hide();
                }
            }
        });
    });
*/
/*
    const keywords = [
        "Tiempo completo",
        "Medio tiempo",
        "Remoto",
        "Freelance",
        "Temporal",
        "Permanente",
        "Computación",
        "Administración",
        "Logística",
        "Contabilidad"
    ];

    const listaContainer = document.querySelector(".keyword-list ul");

    keywords.forEach(keyword => {
        const li = document.createElement("li");
        li.className = "keyword-li";
        const h3 = document.createElement("h3");
        h3.textContent = keyword;
        li.appendChild(h3);
        listaContainer.appendChild(li);
    });


    const ofertas = [
        {
            Nombre: "Desarrollador Frontend",
            Descripcion: "Únete a nuestro equipo de desarrollo frontend y crea experiencias de usuario excepcionales.",
            Departamento: "Montevideo",
            Ciudad: "Montevideo",
            Horario: "09:00 - 18:00",
            Remuneracion: 90000,
            TipoPublicacion: "Básica",
            FechaDeAlta: new Date("2023", "7", "14"),
            Imagen: "https://previews.123rf.com/images/tashatuvango/tashatuvango1610/tashatuvango161001179/64181181-peri%C3%B3dico-con-peque%C3%B1os-anuncios-de-b%C3%BAsqueda-de-empleo-soporte-para-desarrolladores-de-aplicaciones.jpg",
            Keiwords: ["Tiempo completo", "Computación"]
        },
        {
            Nombre: "Estratega de Negocios",
            Descripcion: "Forma parte de nuestro equipo de estrategia y contribuye al crecimiento de las empresas clientes.",
            Departamento: "Maldonado",
            Ciudad: "Punta del Este",
            Horario: "08:00 - 17:00",
            Remuneracion: 80000,
            TipoPublicacion: "Plus",
            FechaDeAlta: new Date("2023", "7", "14"),
            Imagen: "https://www.gub.uy/ministerio-educacion-cultura/sites/ministerio-educacion-cultura/files/styles/listado/public/imagenes/noticias/Computadora.png?itok=T1yWzdOF",
            Keiwords: ["Tiempo completo", "Computación"]
        },
        {
            Nombre: "Diseñador UX/UI",
            Descripcion: "Trabaja en colaboración con nuestro talentoso equipo de diseño para crear soluciones impactantes.",
            Departamento: "Colonia",
            Ciudad: "Rosario",
            Horario: "14:00 - 18:00",
            Remuneracion: 65000,
            TipoPublicacion: "Plus",
            FechaDeAlta: new Date("2023", "7", "13"),
            Imagen: "https://cdn.shopify.com/s/files/1/0268/3679/5582/files/influencers_ganancias_rentabilidad_ingresos_480x480.jpg?v=1640470032",
            Keiwords: ["Tiempo completo", "Computación"]
        },
        {
            Nombre: "Analista de Datos",
            Descripcion: "Ayuda a nuestros clientes a tomar decisiones informadas basadas en análisis y visualizaciones de datos.",
            Departamento: "Maldonado",
            Ciudad: "Maldonado",
            Horario: "09:00 - 13:00",
            Remuneracion: 40000,
            TipoPublicacion: "Plus",
            FechaDeAlta: new Date("2023", "7", "11"),
            Imagen: "https://www.computing.es/wp-content/uploads/2022/11/13628_20.jpg",
            Keiwords: ["Tiempo completo", "Computación"]
        },
        {
            Nombre: "Content Manager",
            Descripcion: "Gestiona y crea contenido persuasivo y relevante para impulsar la presencia en línea de nuestros clientes.",
            Departamento: "Montevideo",
            Ciudad: "Montevideo",
            Horario: "18:00 - 22:00",
            Remuneracion: 10000,
            TipoPublicacion: "Plus",
            FechaDeAlta: new Date("2023", "7", "20"), // Mes -1 porque los meses en JavaScript son 0-indexados
            Imagen: "https://www.dipe.es/wp-content/uploads/2020/09/Cu%C3%A1l-es-la-labor-de-un-content-manager-y-cu%C3%A1les-son-sus-funciones-1.jpg",
            Keiwords: ["Tiempo completo", "Computación"]
        },
        {
            Nombre: "Soporte Técnico",
            Descripcion: "Ofrece un excelente servicio de soporte técnico a nuestros clientes, resolviendo problemas y brindando soluciones.",
            Departamento: "Lavalleja",
            Ciudad: "Minas",
            Horario: "09:00 - 18:00",
            Remuneracion: 30000,
            TipoPublicacion: "Plus",
            FechaDeAlta: new Date("2023", "7", "15"), // Mes -1 porque los meses en JavaScript son 0-indexados
            Imagen: "https://blog.hubspot.es/hubfs/media/servicioalclienteadistancia.jpeg",
            Keiwords: ["Tiempo completo", "Computación"]
        },
        {
            Nombre: "A. de Marketing Digital",
            Descripcion: "Únete a nuestro equipo de marketing y trabaja en estrategias digitales innovadoras.",
            Departamento: "Flores",
            Ciudad: "Flores",
            Horario: "10:00 - 19:00",
            Remuneracion: 80000,
            TipoPublicacion: "Plus",
            FechaDeAlta: new Date("2023", "7", "15"), // Mes -1 porque los meses en JavaScript son 0-indexados
            Imagen: "https://www.salesforce.com/content/dam/blogs/br/2021/por-que-investir-em-marketing-digital.jpg",
            Keiwords: ["Tiempo completo", "Computación"]
        },
        {
            Nombre: "Contador Senior",
            Descripcion: "Únete a nuestro equipo contable y ayuda en la gestión financiera de la empresa.",
            Departamento: "Colonia",
            Ciudad: "Colonia Suiza",
            Horario: "08:30 - 17:30",
            Remuneracion: 100000,
            TipoPublicacion: "Plus",
            FechaDeAlta: new Date("2023", "7", "16"), // Mes -1 porque los meses en JavaScript son 0-indexados
            Imagen: "https://img.freepik.com/vector-gratis/ilustracion-concepto-auditoria_114360-6727.jpg?w=826&t=st=1693992554~exp=1693993154~hmac=5a6ff9efff15e129aeb3161b6d1cadd68b02065d30dedcaccb2aa958bef14c83",
            Keiwords: ["Tiempo completo", "Computación"]
        }

    ]

    const carruselContainer = document.getElementById("carrusel-ofertas");
    let currentIndex = 0;

    // Función para mostrar una oferta en el carrusel
    function mostrarOferta(index) {
        // Limpia el carrusel
        carruselContainer.innerHTML = "";

        // Muestra la oferta en el índice actual
        const oferta = ofertas[index];
        const ofertaElement = mostrarOfertaLaboral(oferta);
        carruselContainer.appendChild(ofertaElement);
    }

    // Función para avanzar al siguiente elemento en el carrusel
    function siguienteOferta() {
        currentIndex = (currentIndex + 1) % ofertas.length;
        mostrarOferta(currentIndex);
    }

    // Función para retroceder al elemento anterior en el carrusel
    function anteriorOferta() {
        currentIndex = (currentIndex - 1 + ofertas.length) % ofertas.length;
        mostrarOferta(currentIndex);
    }

    // Puedes usar botones o eventos para navegar por las ofertas
    document.getElementById("btn-siguiente").addEventListener("click", siguienteOferta);
    document.getElementById("btn-anterior").addEventListener("click", anteriorOferta);

    // Muestra la primera oferta al cargar la página
    mostrarOferta(currentIndex);

    // Función para mostrar una oferta laboral de la lista de ofertas
    function mostrarOfertaLaboral(oferta) {
        // Div
        const div = document.createElement("div");
        div.className = "oferta-laboral-container";
        // Img
        const img = document.createElement("img");
        img.className = "oferta-laboral-img";
        img.alt = "Oferta laboral";
        img.src = oferta.Imagen;
        div.appendChild(img);
        // Div
        const divOfertaInfo = document.createElement("div");
        divOfertaInfo.className = "oferta-laboral-info-container";
        // h3
        const h3 = document.createElement("h3");
        h3.textContent = oferta.Nombre;
        divOfertaInfo.appendChild(h3);
        // p
        const p = document.createElement("p");
        p.textContent = oferta.Descripcion.split(" ").slice(0, 15).join(" ");
        // Append
        divOfertaInfo.appendChild(p);
        div.appendChild(divOfertaInfo);
        // cargar al div los demás datos de la oferta con el nombre del atributo y el valor
        for (const atributo in oferta) {
            if (atributo != "Nombre" && atributo != "Descripcion" && atributo != "Imagen") {
                const p = document.createElement("p");
                p.textContent = atributo + ": " + oferta[atributo];
                divOfertaInfo.appendChild(p);
            }
        }

        return div;
    }

    // Muestra la primera oferta al cargar la página
    mostrarOferta(currentIndex);

    const Usuarios = [
        {
            nickname: "JuanPerez",
            Nombre: "Juan",
            Apellido: "Perez",
            Email: "email1",
            img: "https://thispersondoesnotexist.com/"
        },
        {
            nickname: "MariaRodriguez",
            Nombre: "Maria",
            Apellido: "Rodriguez",
            Email: "email2",
            img: "https://thispersondoesnotexist.com/"
        },
        {
            nickname: "PedroGonzalez",
            Nombre: "Pedro",
            Apellido: "Gonzalez",
            Email: "email3",
            img: "https://thispersondoesnotexist.com/"
        },
        {
            nickname: "AnaLopez",
            Nombre: "Ana",
            Apellido: "Lopez",
            Email: "email4",
            img: "https://thispersondoesnotexist.com/"
        },
        {
            nickname: "JoseGarcia",
            Nombre: "Jose",
            Apellido: "Garcia",
            Email: "email5",
            img: "https://thispersondoesnotexist.com/"

        },
        {
            nickname: "LuciaMartinez",
            Nombre: "Lucia",
            Apellido: "Martinez",
            Email: "email6",
            img: "https://thispersondoesnotexist.com/"
        }
    ]

    // Función para mostrar la lista de postulantes con nombre e imagen
    function mostrarListaPostulantes(usuarios) {
        const listaContainer2 = document.querySelector(".postulantes-list ul");

        usuarios.forEach(usuario => {
            const li = document.createElement("li");
            li.className = "postulante-li";

            // Crear elemento de imagen
            const img = document.createElement("img");
            img.className = "postulante-img";
            img.alt = "Imagen de postulante";
            img.src = usuario.img;
            li.appendChild(img);

            // Crear elemento de nombre
            const h3 = document.createElement("h3");
            h3.textContent = usuario.nickname;
            li.appendChild(h3);

            listaContainer2.appendChild(li);
        });
    }

    // Llama a la función para mostrar la lista de postulantes
    mostrarListaPostulantes(Usuarios); */

    /*Postulacion*/

    var imgUsuarioPostulacion = document.getElementById("imgUsuarioPostulacion");
    var pUsuarioPostulacion = document.getElementById("pUsuarioPostulacion");
    var pMotivacion = document.getElementById("pMotivacion");
    var pCV = document.getElementById("pCV");
    var pFechaPostulacion = document.getElementById("pFechaPostulacion");
    var aNickPostulanteLogeado = document.getElementById("aNickPostulanteLogeado");
    var imgPostulanteLogeado = document.getElementById("imgPostulanteLogeado");

    $('#postEmergenteBoton').click(function () {
        $('#ventanaPostulacion').show();
    });

    $('#cerrarPostulacionBoton').click(function () {
        $('#ventanaPostulacion').hide();
    });
    

    $('.postulante-li').click(function () {
        var target = $(this).data('target');
        $(target).show();
    });

    $('#miPostEmergenteBoton').click(function () {
        var target = $(this).data('target');
        $(target).show();
    });

    $('.cerrarPostulacionBoton2').click(function () {
        var target = $(this).data('target');
        $(target).hide();
    });  
 
    /*
    $('.btnCambiarOferta').click(function () {
        var opcionSeleccionadaOferta = $('#hardcode-oferta-select').val();

       
            if (opcionSeleccionadaOferta=="O1"){
                $('#hardcode-oferta-select').val("O7");
            }else{
                $('#hardcode-oferta-select').val("O1");
            }

    });  

    /*Postulacion*/

}); 