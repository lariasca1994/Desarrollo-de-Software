package Punto9;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Punto9 {

	// Función para encontrar el mayor de dos números enteros
    public static int encontrarMayor(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.####");

        // Solicitar al usuario que ingrese dos números enteros
        System.out.print("Ingrese el primer número entero: ");
        int num1 = scanner.nextInt();

        System.out.print("Ingrese el segundo número entero: ");
        int num2 = scanner.nextInt();

        // Llamar a la función para encontrar el mayor número
        int mayor = encontrarMayor(num1, num2);

        // Mostrar el resultado
        System.out.println("El mayor número es: " + df.format(mayor));

        scanner.close();
    }
	
}
