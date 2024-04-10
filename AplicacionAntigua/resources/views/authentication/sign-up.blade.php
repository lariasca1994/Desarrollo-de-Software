@extends('layout.index')

@section('custom_css')
<link rel="stylesheet" type="text/css" href="{{ url('/css/login.css') }}">
@endsection

@section('content')
<div class="container">
	<div class="row">
		<div class="col-12 sign-in">
			<div class="text-center">
				<h1>Registro de Usuario</h1>
				<p>Bienvenido esperamos que tu encuentres lo que buscas.</p>
			</div>
			<form>
				<div class="from-group">
					<label for="name"><b>Nombre</b></label>
					<input type="text" name="name" id="name" class="form-control" required>
				</div>
				<div class="form-group">
					<label for="email"><b>E-mail</b></label>
					<input type="email" name="email" id="email" class="form-control" placeholder="Ingrese el correo electrónico" required>
					<small id="emailHelp" class="form-text text-error emailHelp"></small>
				</div>
				<div class="form-group">
					<label for="password"><b>Contraseña</b></label>
					<input type="password" name="password" id="password" class="form-control" required>
				</div>
				<button class="btn btn-primary complete-btn">Ingresar</button>
			</form>
			<span class="message-sign-up">Ya tienes cuenta?. Ingresa <a href="{{ URL('login') }}">AQUÍ</a></span>
		</div>
	</div>
</div>
@endsection