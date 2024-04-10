<?php

namespace App\Http\Controllers;

class IndexController extends Controller{

	public function listEvents(){

		/* Se hace el llamado a la base de datos */

		/* Infromación de pruebas */

		$events = [['key' => 1, 'name' => 'Evento de comics', 'description' => 'Evento de actividades de comics, disfraz, comida, charlas, etc', 'img' => './images/event1.jpg'], ['key' => 2,'name' => 'Evento de comida', 'description' => 'Evento en el cuál aprenderas a cocinar y realizar tus platillos favoritos', 'img' => './images/event2.jpg']];

		return view('home.index', ['events' => $events]);
	}

}