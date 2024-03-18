package Punto14;

import java.util.Scanner;

public class Punto14 {

	// Función para obtener el nombre del hermano mayor
    public static String obtenerHermanoMayor(String nombre1, int edad1, String nombre2, int edad2, String nombre3, int edad3) {
        if (edad1 > edad2 && edad1 > edad3) {
            return nombre1;
        } else if (edad2 > edad1 && edad2 > edad3) {
            return nombre2;
        } else {
            return nombre3;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese los nombres y edades de los tres hermanos
        System.out.println("Ingrese el nombre y la edad del primer hermano:");
        System.out.print("Nombre: ");
        String nombre1 = scanner.nextLine();
        System.out.print("Edad: ");
        int edad1 = scanner.nextInt();

        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.println("Ingrese el nombre y la edad del segundo hermano:");
        System.out.print("Nombre: ");
        String nombre2 = scanner.nextLine();
        System.out.print("Edad: ");
        int edad2 = scanner.nextInt();

        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.println("Ingrese el nombre y la edad del tercer hermano:");
        System.out.print("Nombre: ");
        String nombre3 = scanner.nextLine();
        System.out.print("Edad: ");
        int edad3 = scanner.nextInt();

        // Obtener el nombre del hermano mayor usando la función
        String hermanoMayor = obtenerHermanoMayor(nombre1, edad1, nombre2, edad2, nombre3, edad3);

        // Mostrar el nombre del hermano mayor
        System.out.println("El hermano mayor es: " + hermanoMayor);

        scanner.close();
    }
	
}
