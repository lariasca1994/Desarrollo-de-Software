package Punto13;

import java.util.Scanner;

public class Punto13 {

	// Función para calcular el valor del aumento salarial
    public static double calcularAumento(double sueldoActual) {
        double aumento;
        if (sueldoActual <= 800000) {
            aumento = sueldoActual * 0.10;
        } else if (sueldoActual > 800000 && sueldoActual <= 1200000) {
            aumento = sueldoActual * 0.08;
        } else {
            aumento = sueldoActual * 0.05;
        }
        return aumento;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese el sueldo actual del empleado
        System.out.print("Ingrese el sueldo actual del empleado: ");
        double sueldoActual = scanner.nextDouble();

        // Calcular el valor del aumento usando la función
        double aumento = calcularAumento(sueldoActual);

        // Calcular el nuevo salario sumando el aumento al sueldo actual
        double nuevoSalario = sueldoActual + aumento;

        // Mostrar el valor del aumento y el nuevo salario
        System.out.println("El valor del aumento es: $" + aumento);
        System.out.println("El nuevo salario del empleado es: $" + nuevoSalario);

        scanner.close();
    }
	
}
