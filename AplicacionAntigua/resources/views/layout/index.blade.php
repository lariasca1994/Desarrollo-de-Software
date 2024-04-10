<!DOCTYPE html>
<html>
<head>
	<title>Aplicación de reserva de espacios</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="{{ url('/css/index.css') }}">
	@yield('custom_css')
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container">
		  <a class="navbar-brand nav-color" href="/">R-APP</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarText">
		    <ul class="navbar-nav mr-right">
		      <li class="nav-item active">
		        <a class="nav-link nav-color" href="/">Inicio <span class="sr-only">(current)</span></a>
		      </li>
		      <!-- Validar cuando el usuario este logeado -->
		      <li class="nav-item active">
		        <a class="nav-link nav-color" href="{{ url('scenarios') }}">Escenarios</a>
		      </li>
		      
		      <li class="nav-item">
		        <a class="nav-link nav-color" href="{{ URL('login') }}">Iniciar Sesión</a>
		      </li>
		    </ul>
		  </div>
	  	</div>
	</nav>

	@yield('content')

	<div class="sections" id="footer">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-4 col-sm-12">
					<h2>Acerca de nosotros</h2>
					<p>Empresa especializada en reservas y adquisición de espacios en corferias, que nacio en el año 2018 a partir de los problemas de contacto con corferias. Actualmente somos los únicos prestadores de este servicio.</p>
				</div>
				<div class="col-md-4 col-sm-12">
					<h2>Mapa de google <h2>
					<div id="map"></div>
				</div>
				<div class="col-md-4 col-sm-12">
					<table>
						<tbody>
							<tr>
								<td class="space"><i class="fab fa-twitter"></i></td>
								<td class="custom-border">Twitter</td>
							</tr>
							<tr>
								<td class="space"><i class="fab fa-facebook-f"></i></td>
								<td class="custom-border">Facebook</td>
							</tr>
							<tr>
								<td class="space"><i class="fab fa-instagram"></i></td>
								<td class="custom-border">Instagram</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<footer id="copy">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-4 col-sm-12 text-center">
					Copyright &copy; 2019
				</div>	
			</div>
		</div>
	</footer>


	<script>
    function initMap(){
  
      var options = {
       
		zoom:16,
        center:{lat: 4.6296700,lng:-74.0904500 }
      }

 
      var map = new google.maps.Map(document.getElementById('map'), options);


      google.maps.event.addListener(map, 'click', function(event){
  
      
      });


    
      var markers = [
        {
          coords:{lat: 4.6296700,lng:-74.0904500 },
          iconImage:'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
          content:'<h4>Centro de convenciones Corferias</h4>'
        }
      ];

    
      for(var i = 0;i < markers.length;i++){

        addMarker(markers[i]);
      }

  
      function addMarker(props){
        var marker = new google.maps.Marker({
          position:props.coords,
          map:map,
       
        });

   
        if(props.iconImage){
     
          marker.setIcon(props.iconImage);
        }


        if(props.content){
          var infoWindow = new google.maps.InfoWindow({
            content:props.content
          });

          marker.addListener('click', function(){
            infoWindow.open(map, marker);
          });
        }
      }
    }
  </script>

<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC4lOLe8XxFnB1npXkHuiR-XiOPTQBeb0g&callback=initMap"> </script>


	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	@yield('custom_js')
</body>
</html>