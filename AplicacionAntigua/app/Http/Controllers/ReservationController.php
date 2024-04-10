<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Http\Session;

class ReservationController extends Controller {


	public function reserved(Request $request){
		$dateStart = $request->input('date-start');
		$dateEnd = $request->input('date-end');
		/* Variables locales, mientras se espera la configuración de la base de datos */
		$starDatesReserved = ['2019-06-05', '2019-07-05', '2019-07-15', '2019-06-15'];
		$endDatesReserved = ['2019-06-09', '2019-07-09', '2019-07-20', '2019-06-20'];
		
		foreach ($starDatesReserved as $key => $value) {
			if($dateStart >= $value && $dateEnd <= $endDatesReserved[$key]){
				return "ocupped";
			}
		}

		return "reserved";
	}

}