package Punto8;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Punto8 {

	// Función para calcular el número de salones del nuevo edificio
    public static int calcularNumeroSalones(int numEstudiantes, int capacidadSalon) {
        return (int) Math.ceil((double) numEstudiantes / capacidadSalon);
    }

    // Función para calcular el número de pisos del nuevo edificio
    public static int calcularNumeroPisos(int numSalones, int salonesPorPiso) {
        return (int) Math.ceil((double) numSalones / salonesPorPiso);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el número de estudiantes que tiene la universidad
        System.out.print("Ingrese el número de estudiantes que tiene la universidad: ");
        int numEstudiantes = scanner.nextInt();

        // Solicitar la capacidad de un salón
        System.out.print("Ingrese la capacidad de un salón: ");
        int capacidadSalon = scanner.nextInt();

        // Solicitar el número de salones que tendrá un piso del edificio
        System.out.print("Ingrese el número de salones que tendrá un piso del edificio: ");
        int salonesPorPiso = scanner.nextInt();

        // Calcular el número de salones del nuevo edificio usando la función
        int numSalones = calcularNumeroSalones(numEstudiantes, capacidadSalon);

        // Calcular el número de pisos del nuevo edificio usando la función
        int numPisos = calcularNumeroPisos(numSalones, salonesPorPiso);

        // Formatear los resultados para mostrar solo cuatro decimales
        DecimalFormat df = new DecimalFormat("#.####");
        String numSalonesFormateado = df.format(numSalones);
        String numPisosFormateado = df.format(numPisos);

        // Mostrar los resultados
        System.out.println("El número de salones del nuevo edificio es: " + numSalonesFormateado);
        System.out.println("El número de pisos del nuevo edificio es: " + numPisosFormateado);

        scanner.close();
    }
	
}
