@extends('layout.index')

@section('custom_css')
<link rel="stylesheet" type="text/css" href="{{ url('/css/home.css') }}">
@endsection

@section('content')
<div id="principal">
	<div class="row align-items-center text-center">
		<div class="col-lg-6 offset-lg-3">
			<h1>Aplicación de Reservas</h1>
			<p>Realiza la reserva de pabellones en el centro de evento de corferias a un menor precio</p>
			<button class="btn more">Ver más</button>
		</div>
	</div>
</div>

<div id="why" class="sections text-center">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-sm-12 titles">
				<h2>Sobre nosotros</h2>
				<p>Empresa especializada en reservas y adquisición de espacios en corferias</p>
			</div>
			<div class="col-lg-4 col-sm-12 box-shadow">
				<img src="./images/imagen1.png" alt="reservaciones">
				<h3>Reservaciones</h3>
				<p>Reserva de espacios en poco tiempo.</p>
			</div>
			<div class="col-lg-4 col-sm-12 box-shadow">
				<img src="./images/imagen2.png" alt="bajo costo">
				<h3>Bajo Costo</h3>
				<p>Bajos precios de reserva para una excelente experiencia.</p>
			</div>
			<div class="col-lg-4 col-sm-12 box-shadow">
				<img src="./images/imagen3.png" alt="especializada">
				<h3>Personas Especializadas</h3>
				<p>Contamos con personas capacitadas para resolver tus dudas.</p>
			</div>
		</div>
	</div>
</div>

<div class="sections" id="events">
	<div class="container">
		<div class="row text-center">
			<div class="col-lg-12 col-sm-12 titles">
				<h2>Eventos</h2>
				<p>Descubre cuáles son nuestros siguientes eventos</p>
			</div>

			@foreach($events as $event)
				<div class="col-lg-6 col-sm-12">
					<img src="{{ $event['img'] }}" alt="Evento 1" class="events titles">
					<h3><a href="{{ url('events', ['id' => $event['key']]) }}" class="link-event">{{ $event['name'] }}</a></h3>
					<p>{{ $event['description'] }}</p>
				</div>
			@endforeach
		</div>
	</div>
</div>

<div class="sections">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-sm-12 titles">
				<h2 class="text-center">Contáctenos</h2>
				<p class="text-center">Tienes alguna duda, sugerencia o reclamo. Escríbenos y te responderemos lo más rápido posible</p>
				<form>
					<div class="form-group">
						<label for="name"><b>Nombre</b></label>
						<input type="text" name="name" id="name" class="form-control" placeholder="Jhon Doe" required>
					</div>

					<div class="form-group">
						<label for="email"><b>E-mail</b></label>
						<input type="email" name="email" id="email" class="form-control" placeholder="Ingrese el correo electrónico" required>
					</div>
					<div class="form-group">
						<label for="message"><b>¿Qué necesitas?</b></label>
						<textarea id="message" class="form-control" required></textarea>
					</div>
					<div class="row justify-content-center text-center">
						<div class="col-4">
							<button class="btn btn-primary text-center">Enviar</button>
						</div>
					</div>
				</form>		
			</div>
		</div>
	</div>
</div>
@endsection