package Punto6;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Punto6 {

    // Función para calcular el área de un rectángulo a partir de su base y altura
    public static double calcularAreaRectangulo(double base, double altura) {
        return base * altura;
    }

    // Función para calcular la hipotenusa de un triángulo rectángulo a partir de sus catetos
    public static double calcularHipotenusa(double cateto1, double cateto2) {
        return Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
    }

    // Función para calcular el área de un triángulo a partir de su base y altura
    public static double calcularAreaTriangulo(double base, double altura) {
        return 0.5 * base * altura;
    }

    // Función para calcular el perímetro del terreno a partir de los lados A, B, C
    public static double calcularPerimetroTerreno(double ladoA, double ladoB, double ladoC) {
        // Encontrar la hipotenusa del triángulo formado por los lados A, B
        double hipotenusa = calcularHipotenusa(ladoA, ladoB);
        
        // Sumar la hipotenusa al lado C para obtener el perímetro
        return ladoC + hipotenusa + ladoA + ladoB;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar las dimensiones de los lados del terreno
        System.out.print("Ingrese la longitud del lado A del terreno: ");
        double ladoA = scanner.nextDouble();

        System.out.print("Ingrese la longitud del lado B del terreno: ");
        double ladoB = scanner.nextDouble();

        System.out.print("Ingrese la longitud del lado C del terreno: ");
        double ladoC = scanner.nextDouble();

        // Calcular el área del terreno usando la función de área del triángulo (base x altura)
        double areaTerreno = calcularAreaTriangulo(ladoB, ladoA);

        // Calcular el perímetro del terreno usando la función de perímetro del terreno
        double perimetroTerreno = calcularPerimetroTerreno(ladoA, ladoB, ladoC);

        // Formatear los resultados para mostrar solo cuatro decimales
        DecimalFormat df = new DecimalFormat("#.####");
        String areaFormateada = df.format(areaTerreno);
        String perimetroFormateado = df.format(perimetroTerreno);

        // Mostrar los resultados
        System.out.println("El área del terreno es: " + areaFormateada);
        System.out.println("El perímetro del terreno es: " + perimetroFormateado);

        scanner.close();
    }
	
}
