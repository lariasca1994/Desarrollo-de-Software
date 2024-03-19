public class ComplejidadAlgoritmoXXXXXX {
    public static void calcularComplejidad(int n) {
        StringBuilder resultadoBuilder = new StringBuilder();

        // Ciclo externo
        resultadoBuilder.append("Ciclo externo (i = 1; i <= n; i *= 5):\n");
        int iteracionesExternas = 0;
        for (int i = 1; i <= n; i *= 5) {
            iteracionesExternas++;
            resultadoBuilder.append("Iteración ").append(iteracionesExternas).append(": i = ").append(i).append("\n");

            // Ciclo medio
            resultadoBuilder.append("  Ciclo medio (j = 1; j <= n; j += 2):\n");
            int iteracionesMedias = 0;
            for (int j = 1; j <= n; j += 2) {
                iteracionesMedias++;
                resultadoBuilder.append("    Iteración ").append(iteracionesMedias).append(": j = ").append(j).append("\n");
            }
            resultadoBuilder.append("  Total iteraciones del ciclo medio: ").append(iteracionesMedias).append("\n");

            // Ciclo interno
            resultadoBuilder.append("  Ciclo interno (k = n; k >= 1; k /= 2):\n");
            int iteracionesInternas = 0;
            for (int k = n; k >= 1; k /= 2) {
                iteracionesInternas++;
                resultadoBuilder.append("    Iteración ").append(iteracionesInternas).append(": k = ").append(k).append("\n");
            }
            resultadoBuilder.append("  Total iteraciones del ciclo interno: ").append(iteracionesInternas).append("\n\n");
        }
        resultadoBuilder.append("Total iteraciones del ciclo externo: ").append(iteracionesExternas).append("\n");

        // Complejidad final
        resultadoBuilder.append("\nComplejidad final:\n");
        resultadoBuilder.append("Ciclo externo: O(log n)\n");
        resultadoBuilder.append("Ciclo medio: O(n)\n");
        resultadoBuilder.append("Ciclo interno: O(log n)\n");
        resultadoBuilder.append("Complejidad total: O(n log n)\n");

        System.out.println(resultadoBuilder.toString());
    }

    public static void main(String[] args) {
        int n = 100; // Ejemplo con n = 100
        calcularComplejidad(n);
    }
}