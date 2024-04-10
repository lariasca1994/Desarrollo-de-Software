@extends('layout.index')

@section('custom_css')
<link rel="stylesheet" type="text/css" href="{{ url('/css/event.css') }}">
@endsection

@section('content')

<div class="container contex">

	<h1>{{ $data['name'] }}</h1>
	
	<p class="stilep">{{ $data['desc'] }}</p>
	
	<div class="container">
	
		<div class="row">
			<div class="col-sm-4  espaciado ">
				
				<h5 estiloinfo>Desde: {{ $data['start'] }}</h5>
				<h5>Hasta: {{ $data['end'] }}</h5>
				<h5>Hora: De {{ $data['hours'] }}</h5>
				<h5>Direccion: Cra. 37 #24-67, Bogotá</h5>
				<!--<a href="#" class="estiloa">Escenarios</a>-->
			</div>
			
			<div class="col-sm-8 moverimagen ">
				<img class="img-fluid" src="{{ url($data['img']) }}" >
			</div>
		</div>	
	</div>
</div>

@endsection