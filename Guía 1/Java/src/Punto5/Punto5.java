package Punto5;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Punto5 {

    // Función para calcular el área de un círculo
    public static double calcularAreaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }

    // Función para calcular el área de la corona circular
    public static double calcularAreaCorona(double radioGrande, double radioPequeno) {
        double areaCirculoGrande = calcularAreaCirculo(radioGrande);
        double areaCirculoPequeno = calcularAreaCirculo(radioPequeno);
        return areaCirculoGrande - areaCirculoPequeno;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el radio grande (R)
        System.out.print("Ingrese el radio grande (R) del círculo: ");
        double radioGrande = scanner.nextDouble();

        // Solicitar el radio pequeño (r)
        System.out.print("Ingrese el radio pequeño (r) del círculo: ");
        double radioPequeno = scanner.nextDouble();

        // Calcular el área de la corona circular usando la función
        double areaCorona = calcularAreaCorona(radioGrande, radioPequeno);

        // Formatear el resultado para mostrar solo cuatro decimales
        DecimalFormat df = new DecimalFormat("#.####");
        String areaCoronaFormateada = df.format(areaCorona);

        // Mostrar el resultado
        System.out.println("El área de la corona circular es: " + areaCoronaFormateada);

        scanner.close();
    }
	
}
