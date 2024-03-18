package Punto3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Punto3 {
	
    // Función para calcular la longitud de la escalera
    public static double calcularLongitudEscalera(double altura, double angulo) {
        // Convertir el ángulo de grados a radianes
        double anguloRadianes = Math.toRadians(angulo);
        
        // Calcular la longitud de la escalera usando la tangente del ángulo
        double longitud = altura / Math.tan(anguloRadianes);
        
        return longitud;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar la altura de la escalera
        System.out.print("Ingrese la altura de la escalera (en metros): ");
        double altura = scanner.nextDouble();

        // Solicitar el ángulo de inclinación en grados
        System.out.print("Ingrese el ángulo de inclinación de la escalera (en grados): ");
        double angulo = scanner.nextDouble();

        // Calcular la longitud de la escalera usando la función
        double longitud = calcularLongitudEscalera(altura, angulo);

        // Formatear el resultado para mostrar solo dos decimales
        DecimalFormat df = new DecimalFormat("#.##");
        String longitudFormateada = df.format(longitud);

        // Mostrar el resultado
        System.out.println("La longitud de la escalera es: " + longitudFormateada + " metros.");

        scanner.close();
    }
}
