package Punto7;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Punto7 {

	// Función para calcular la distancia entre dos puntos
    public static double calcularDistancia(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
    }

    // Función para calcular la pendiente de la recta que une dos puntos
    public static double calcularPendiente(double x1, double y1, double x2, double y2) {
        return (y2 - y1) / (x2 - x1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar las coordenadas del primer punto
        System.out.println("Ingrese las coordenadas del primer punto:");
        System.out.print("x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("y1: ");
        double y1 = scanner.nextDouble();

        // Solicitar las coordenadas del segundo punto
        System.out.println("Ingrese las coordenadas del segundo punto:");
        System.out.print("x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("y2: ");
        double y2 = scanner.nextDouble();

        // Calcular la distancia entre los puntos usando la función
        double distancia = calcularDistancia(x1, y1, x2, y2);

        // Calcular la pendiente de la recta que une los puntos usando la función
        double pendiente = calcularPendiente(x1, y1, x2, y2);

        // Formatear los resultados para mostrar solo cuatro decimales
        DecimalFormat df = new DecimalFormat("#.####");
        String distanciaFormateada = df.format(distancia);
        String pendienteFormateada = df.format(pendiente);

        // Mostrar los resultados
        System.out.println("La distancia entre los puntos es: " + distanciaFormateada);
        System.out.println("La pendiente de la recta que une los puntos es: " + pendienteFormateada);

        scanner.close();
    }
	
}
