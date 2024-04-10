<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It is a breeze. Simply tell Lumen the URIs it should respond to
| and give it the Closure to call when that URI is requested.
|
*/

$router->get('/', 'IndexController@listEvents');

$router->get('login', function(){
	return view('authentication.login');
});

/* Registro de usuario - Vista - Luis Arias*/
$router->get('sign-up', function(){
	return view('authentication.sign-up');
});

$router->post('reserved', 'ReservationController@reserved');

$router->get('scenarios', 'ScenariosController@scenarios');

$router->get('scenarios/{type}', 'ScenariosController@type');

$router->get('scenarios/{type}/reservation-form', 'ScenariosController@reservation');

$router->get('events/{id}', 'EventsController@event');