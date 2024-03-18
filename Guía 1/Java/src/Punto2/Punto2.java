package Punto2;

import java.util.Scanner;

public class Punto2 {
    // Función para calcular el número de autobuses necesarios
    public static int calcularNumeroBuses(int sillasPorBus, int estudiantesGordos, int estudiantesFlacos) {
        // Calcula el total de sillas necesarias para los estudiantes gordos y flacos
        int sillasGordos = estudiantesGordos * 2;
        int sillasFlacos = estudiantesFlacos;

        // Calcula el total de sillas necesarias en total
        int totalSillas = sillasGordos + sillasFlacos;

        // Calcula el número de autobuses necesarios
        int numeroBuses = totalSillas / sillasPorBus;
        if (totalSillas % sillasPorBus != 0) {
            numeroBuses++; // Agrega un autobús adicional si hay sillas adicionales
        }

        return numeroBuses;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar la cantidad de sillas por bus
        System.out.print("Ingrese la cantidad de sillas por bus: ");
        int sillasPorBus = scanner.nextInt();

        // Solicitar la cantidad de estudiantes gordos
        System.out.print("Ingrese la cantidad de estudiantes gordos: ");
        int estudiantesGordos = scanner.nextInt();

        // Solicitar la cantidad de estudiantes flacos
        System.out.print("Ingrese la cantidad de estudiantes flacos: ");
        int estudiantesFlacos = scanner.nextInt();

        // Calcular el número de autobuses necesarios
        int numeroBuses = calcularNumeroBuses(sillasPorBus, estudiantesGordos, estudiantesFlacos);

        // Mostrar el resultado
        System.out.println("Se necesitan " + numeroBuses + " autobuses para llevar a todos los estudiantes al paseo.");

        scanner.close();
    }
}
