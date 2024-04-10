@extends('layout.index')

@section('custom_css')
<link rel="stylesheet" type="text/css" href="{{ url('/css/list.css') }}">
@endsection

@section('content')
	<div class="container scnearios">
		<div class="row">
			<div class="col-lg-12 col-sm-12">
				<h1>Escenarios disponibles</h1>
			</div>

			@foreach($data as $scenario)
				<div class="col-lg-6 col-sm-12">
					<figure class="figure">
						<img src="{{ url($scenario['img']) }}">
						<figcaption class="figure-caption">{{ $scenario['name'] }}</figcaption>
					<figure class="figure">
					<div class="text-center button-margin">
						<a href="{{ url('scenarios', ['type' => $scenario['key']]) }}/reservation-form" class="btn btn-success">Rentar</a>
						<a href="{{ url('scenarios', ['type' => $scenario['key']]) }}" class="btn btn-primary">Más info</a>
					</div>
				</div>
			@endforeach
		</div>
	</div>
@endsection