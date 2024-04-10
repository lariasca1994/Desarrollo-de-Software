<?php

namespace App\Http\Controllers;

class ScenariosController extends Controller {

	public function scenarios() {
		$scenarios = [['key' => 'alfa', 'name' => 'Escenario 1 - Alfa', 'img' => '/images/slide1.jpg'], ['key' => 'beta', 'name' => 'Escenario 2 - Beta', 'img' => '/images/slide2.jpg'], ['key' => 'omega', 'name' => 'Escenario 3 - Omega', 'img' => '/images/slide3.jpg'], ['key' => 'metro', 'name' => 'Escenario 4 - Metro', 'img' => '/images/slide1.jpg']];

		return view('scenarios.list', ['data' => $scenarios]);
	}

	public function type($type){

		/* Configuración del llamado a la base de datos donde el nombre sea igual type */

		$scenario = ['name' => 'Escenario 1 - ALFA', 'price' => '15.000.000', 'desc1' => 'Económico, pero cuenta con grandes salones de exposición y presentación.', 'desc2' => 'Cuenta con una amplia gama de salones y cada salón cuenta con espacio amplio de trabajo.', 'desc3' => 'Cuenta con diferentes tarimas, exclusividad a camerinos y estos a su vez cuenta con baños privados.', 'desc4' => 'Capacidad para 1500 personas y disponibilidad de mesas y sillas.', 'img1' => '/images/slide1.jpg', 'img2' => '/images/slide2.jpg', 'img3' => '/images/slide3.jpg', 'img4' => '/images/event1.jpg'];

		return view('scenarios.details', ['data' => $scenario]);
	}


	public function reservation($type){
		$scenario = ['name' => 'Escenario 1 - ALFA', 'price' => '15.000.000', 'desc1' => 'Económico, pero cuenta con grandes salones de exposición y presentación.', 'desc2' => 'Cuenta con una amplia gama de salones y cada salón cuenta con espacio amplio de trabajo.', 'desc3' => 'Cuenta con diferentes tarimas, exclusividad a camerinos y estos a su vez cuenta con baños privados.', 'desc4' => 'Capacidad para 1500 personas y disponibilidad de mesas y sillas.', 'img1' => '/images/slide1.jpg', 'img2' => '/images/slide2.jpg', 'img3' => '/images/slide3.jpg', 'img4' => '/images/event1.jpg'];

		return view('reservation.form', ['data' => $scenario]);
	}
}