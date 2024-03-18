package Punto10;

import java.util.Scanner;

public class Punto10 {

	// Función para aplicar la operación aritmética y retornar el resultado
    public static int aplicarOperacion(int num1, int num2, String operador) {
        int resultado = 0;
        switch (operador) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    System.out.println("Error: División por cero.");
                }
                break;
            case "%":
                resultado = num1 % num2;
                break;
            case "**":
                resultado = (int) Math.pow(num1, num2);
                break;
            default:
                System.out.println("Error: Operador no válido.");
        }
        return resultado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese dos números enteros y un operador
        System.out.print("Ingrese el primer número entero: ");
        int num1 = scanner.nextInt();

        System.out.print("Ingrese el segundo número entero: ");
        int num2 = scanner.nextInt();

        System.out.print("Ingrese el operador aritmético (+, -, *, /, %, **): ");
        String operador = scanner.next();

        // Aplicar la operación aritmética usando la función
        int resultado = aplicarOperacion(num1, num2, operador);

        // Mostrar el resultado
        System.out.println("El resultado de la operación es: " + resultado);

        scanner.close();
    }
	
}
