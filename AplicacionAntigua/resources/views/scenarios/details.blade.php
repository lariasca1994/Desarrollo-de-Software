@extends('layout.index')

@section('custom_css')
<link rel="stylesheet" type="text/css" href="{{ url('/css/list.css') }}">
@endsection

@section('content')
	<div class="container scnearios">
		<div class="row">
			<div class="col-lg-12 col-sm-12">
				<h1>{{ $data['name'] }}</h1>
			</div>

			<div class="col-lg-6 col-sm-12">
				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<img src="{{ url($data['img1']) }}" alt="imagen 1">
					</div>
					<div class="col-lg-6 col-sm-12">
						<h3>Economía</h3>
						<p>{{ $data['desc1'] }}</p>
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-sm-12">
				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<img src="{{ url($data['img2']) }}" alt="imagen 2">
					</div>
					<div class="col-lg-6 col-sm-12">
						<h3>Amplio</h3>
						<p>{{ $data['desc2'] }}</p>
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-sm-12">
				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<img src="{{ url($data['img3']) }}" alt="imagen 3">
					</div>
					<div class="col-lg-6 col-sm-12">
						<h3>Características</h3>
						<p>{{ $data['desc3'] }}</p>
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-sm-12">
				<div class="row">
					<div class="col-lg-6 col-sm-12">
						<img src="{{ url($data['img4']) }}" alt="imagen 4">
					</div>
					<div class="col-lg-6 col-sm-12">
						<h3>Otros</h3>
						<p>{{ $data['desc4'] }}</p>
					</div>
				</div>
			</div>
		</div>
	</div>
@endsection