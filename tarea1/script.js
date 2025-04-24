document.addEventListener("DOMContentLoaded", function () {
    $('.opcionales_Empresa, .opcionales_Postulante').hide();

    $('.message a').click(function () {
        $('form').animate({ height: "toggle", opacity: "toggle" }, "slow");
    });

    $('input[type="radio"]').change(function () {
        var opcionSeleccionada = $(this).val();
        if (opcionSeleccionada == "Empresa") {
            $('.opcionales_Empresa').show();
            $('.opcionales_Postulante').hide();
        } else {
            $('.opcionales_Postulante').show();
            $('.opcionales_Empresa').hide();
        }
    });
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
            Imagen: "https://cdn.shopify.com/s/files/1/0268/3679/5582/files/influencers_ganancias_rentabilidad_ingresos_480x480.jpg?v=1640470032"
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
            Imagen: "https://www.computing.es/wp-content/uploads/2022/11/13628_20.jpg"
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
            Imagen: "https://www.dipe.es/wp-content/uploads/2020/09/Cu%C3%A1l-es-la-labor-de-un-content-manager-y-cu%C3%A1les-son-sus-funciones-1.jpg"
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
            Imagen: "https://blog.hubspot.es/hubfs/media/servicioalclienteadistancia.jpeg"
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
            Imagen: "https://www.salesforce.com/content/dam/blogs/br/2021/por-que-investir-em-marketing-digital.jpg"
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
            Imagen: "https://img.freepik.com/vector-gratis/ilustracion-concepto-auditoria_114360-6727.jpg?w=826&t=st=1693992554~exp=1693993154~hmac=5a6ff9efff15e129aeb3161b6d1cadd68b02065d30dedcaccb2aa958bef14c83"
        }

    ]
    const listaOfertas = document.querySelector(".oferta-laboral-home-container");
    ofertas.forEach(oferta => {
        // Div
        const div = document.createElement("div");
        div.className = "oferta-laboral-container"
        // Img
        const img = document.createElement("img")
        img.className = "oferta-laboral-img"
        img.alt = "Oferta laboral";
        img.src = oferta.Imagen;
        div.appendChild(img);
        // Div
        const divOfertaInfo = document.createElement("div");
        divOfertaInfo.className = "oferta-laboral-info-container"
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
        listaOfertas.appendChild(div)
    });

    $('.oferta-laboral-container').click(function () {/*Ir a la página de oferta laboral*/ alert("No está implementado todavía, gil!") })

});

// altaofertalaboral
const TipoPublicacion = [
    {
        Nombre: "Premium",
        Descripcion: "Obtén máxima visibilidad",
        Exposicion: "1",
        Duracion: "30",
        Costo: "4000",
        FechaDeAlta: new Date("2023", "08", "10"),
    },
    
    {   
        Nombre: "Destacada",
        Descripcion: "Destaca tu anuncio",
        Exposicion: "2",
        Duracion: "15",
        Costo: "500",
        FechaDeAlta: new Date("2023", "08", "05"),

    },
        {Nombre: "Estándar",
        Descripcion: "Mejora la posición de tu anuncio",
        Exposicion: "3",
        Duracion: "20",
        Costo: "150",
        FechaDeAlta: new Date("2023", "08", "15"),
    },

    {   Nombre: "Básica",
        Descripcion: "Publica de forma sencilla en la lista de ofertas",
        Exposicion: "4",
        Duracion: "7",
        Costo: "50",
        FechaDeAlta: new Date("2023", "08", "07"),
    }
   ]