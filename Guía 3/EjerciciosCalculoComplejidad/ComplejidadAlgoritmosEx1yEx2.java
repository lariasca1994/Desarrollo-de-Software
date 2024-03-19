public class ComplejidadAlgoritmosEx1yEx2 {
    public static void analizarAlgoritmos() {
        StringBuilder resultadoBuilder = new StringBuilder();

        // Analizar algoritmo Ex1
        resultadoBuilder.append("Algoritmo Ex1:\n");
        resultadoBuilder.append("1. Llamada a buscar(a, elem): O(n log n)\n");
        resultadoBuilder.append("2. Ciclo externo (i = 0; i < n; ++i): O(n)\n");
        resultadoBuilder.append("   a. Operaciones constantes: O(1)\n");
        resultadoBuilder.append("   b. Ciclo interno (j = 0; j < n; ++j): O(n)\n");
        resultadoBuilder.append("      - Operaciones constantes: O(1)\n");
        resultadoBuilder.append("Complejidad total del algoritmo Ex1: O(n^2 + n log n) = O(n^2)\n\n");

        // Analizar algoritmo Ex2
        resultadoBuilder.append("Algoritmo Ex2:\n");
        resultadoBuilder.append("1. Operaciones constantes: O(1)\n");
        resultadoBuilder.append("2. Ciclo externo (i = 0; i < n; ++i): O(n)\n");
        resultadoBuilder.append("   a. Llamada a buscar(a, elem): O(n log n)\n");
        resultadoBuilder.append("   b. Operaciones constantes: O(1)\n");
        resultadoBuilder.append("   c. Ciclo interno (j = 0; j < n; ++j): O(n)\n");
        resultadoBuilder.append("      - Operaciones constantes: O(1)\n");
        resultadoBuilder.append("Complejidad total del algoritmo Ex2: O(n^2 + n log n) = O(n^2)\n\n");

        resultadoBuilder.append("Ambos algoritmos tienen la misma complejidad O(n^2), por lo que ninguno es mejor que el otro en términos de complejidad.\n");
        resultadoBuilder.append("Sin embargo, el algoritmo Ex2 realiza más operaciones y llamadas a la función buscar, lo que podría hacerlo más lento en la práctica.\n");

        System.out.println(resultadoBuilder.toString());
    }

    public static void main(String[] args) {
        analizarAlgoritmos();
    }
}