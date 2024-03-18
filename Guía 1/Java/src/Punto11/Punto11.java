package Punto11;

import java.util.Scanner;

public class Punto11 {

	// Función para obtener la cifra de las decenas de un número entero de dos cifras
    public static int obtenerDecenas(int numero) {
        return numero / 10;
    }

    // Función para obtener la cifra de las unidades de un número entero de dos cifras
    public static int obtenerUnidades(int numero) {
        return numero % 10;
    }

    // Función para convertir un dígito en romano
    public static String convertirDigitoARomano(int digito) {
        switch (digito) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            default:
                return ""; // Para el cero, retorna una cadena vacía
        }
    }

    // Función para convertir un dígito en romano de las decenas
    public static String convertirDecenasARomano(int digito) {
        switch (digito) {
            case 1:
                return "X";
            case 2:
                return "XX";
            case 3:
                return "XXX";
            case 4:
                return "XL";
            case 5:
                return "L";
            default:
                return ""; // Para otros casos, retorna una cadena vacía
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese un número entero
        System.out.print("Ingrese un número entero entre 1 y 99: ");
        int numero = scanner.nextInt();

        // Verificar si el número tiene menos de 3 cifras y no es negativo
        if (numero > 0 && numero < 100) {
            // Obtener las decenas y las unidades
            int decenas = obtenerDecenas(numero);
            int unidades = obtenerUnidades(numero);

            // Convertir las decenas y las unidades a números romanos
            String romanoDecenas = convertirDecenasARomano(decenas);
            String romanoUnidades = convertirDigitoARomano(unidades);

            // Mostrar el número en romano
            System.out.println("El número en romano es: " + romanoDecenas + romanoUnidades);
        } else {
            // Mostrar un mensaje de error si el número no cumple con los requisitos
            System.out.println("Error: El número debe ser un entero positivo entre 1 y 99.");
        }

        scanner.close();
    }
	
}
