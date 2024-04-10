$( document ).ready(function() {
	const IMAGENES = [
        '/images/slide1.jpg',
        '/images/slide2.jpg',
        '/images/slide3.jpg'
    ];

    let posicionActual = 0;
    let $botonRetroceder = document.querySelector('#retroceder');
    let $botonAvanzar = document.querySelector('#avanzar');
    let $imagen = document.querySelector('#imagen');

    function pasarFoto() {
        if(posicionActual >= IMAGENES.length - 1) {
            posicionActual = 0;
        } else {
            posicionActual++;
        }
        renderizarImagen();
    }

    function retrocederFoto() {
        if(posicionActual <= 0) {
            posicionActual = IMAGENES.length - 1;
        } else {
            posicionActual--;
        }
        renderizarImagen();
    }

    function renderizarImagen () {
        $imagen.style.backgroundImage = `url(${IMAGENES[posicionActual]})`;
    }

    $botonAvanzar.addEventListener('click', pasarFoto);
    $botonRetroceder.addEventListener('click', retrocederFoto);

    renderizarImagen();

    $("#reser").submit((e) => {
        e.preventDefault();

        $.ajax({
            url: $("#reser").attr('action'),
            type: "POST",
            data: $("#reser").serialize(),
            success: function(data){
                if(data == "ocupped"){
                    $("#reser").hide();
                    $('h1.text-center').after(
                        '<div class="alert alert-warning alert-dismissible fade show" role="alert"><h4><strong>Ohh Lo sentimos!</strong></h4> <p>Este escenario ya se encuentra reservado en las fechas escogidas, te recomendamos ver algunas de nuestras otras opciones.</p><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>'
                    );
                }else{
                    $("#reser").hide();
                    $('h1.text-center').after(
                        '<div class="alert alert-success alert-dismissible fade show" role="alert"><h4><strong>Reservado!</strong></h4> <p>Se ha reservado el escenario, un ascesor te contactará lo antes posible para realizar unos últimos detalles.</p><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>'
                    );
                }
            }
        });
    });
});