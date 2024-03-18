package Punto12;

import java.util.Scanner;

public class Punto12 {

	// Función para obtener el nombre del día siguiente
    public static String obtenerDiaSiguiente(String dia) {
        switch (dia.toLowerCase()) {
            case "lunes":
                return "martes";
            case "martes":
                return "miércoles";
            case "miércoles":
                return "jueves";
            case "jueves":
                return "viernes";
            case "viernes":
                return "sábado";
            case "sábado":
                return "domingo";
            case "domingo":
                return "lunes";
            default:
                return "Día no válido"; // En caso de un día no reconocido
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese el nombre de un día
        System.out.print("Ingrese el nombre de un día (en minúsculas): ");
        String dia = scanner.nextLine();

        // Obtener el nombre del día siguiente usando la función
        String diaSiguiente = obtenerDiaSiguiente(dia);

        // Mostrar el nombre del día siguiente
        System.out.println("El día siguiente a " + dia + " es " + diaSiguiente);

        scanner.close();
    }
	
}
