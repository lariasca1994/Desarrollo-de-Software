package Punto1;

public class Punto1 {
	// Método estático para calcular f(x, y)
    public static double calcularFuncion(double x, double y) {
        return x*x + 2*x*y + y*y;
    }

    public static void main(String[] args) {
        // Valores de prueba para x y y
        double x = 2.5;
        double y = 3.7;

        // Calcular f(x, y)
        double resultado = calcularFuncion(x, y);

        // Mostrar el resultado
        System.out.println("El valor de la función f(" + x + ", " + y + ") es: " + resultado);
    }
}
