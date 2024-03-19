import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JPanel panelPrincipal;
    private JComboBox<String> puntoComboBox;
    private JPanel panelEjercicios;

    public Main() {
        setTitle("Complejidad de Algoritmos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelPrincipal = new JPanel(new BorderLayout());

        puntoComboBox = new JComboBox<>(new String[]{"Seleccione una opción", "1", "2", "3"});
        puntoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarPantalla();
            }
        });
        panelPrincipal.add(puntoComboBox, BorderLayout.NORTH);

        panelEjercicios = new JPanel(new CardLayout());
        panelEjercicios.add(new JTextArea("1. Para cada uno de los tiempos que toma un algoritmo en terminar, demostrar que cada uno es de la complejidad dada:\n\n" +
                "a) T₀(n) = 2n^3 - 3n^2 + 1 es O(n^3)\n" +
                "b) T₁(n) = n^5 + 4^2 - √n + 1 es O(n^5)\n" +
                "c) T₂(n) = n^2 log n + 2n^4 + √(2n) es O(n^4)"), "1");
        panelEjercicios.add(new JTextArea("2. Calcule paso a paso la complejidad del siguiente algoritmo:\n\n" +
                "void XXXXXX(int n) {\n" +
                "    int x = 0;\n" +
                "    for (int i = 1; i <= n; i *= 5) {\n" +
                "        for (int j = 1; j <= n; j += 2) {\n" +
                "            x = x + j;\n" +
                "        }\n" +
                "        for (int k = n; k >= 1; k /= 2) {\n" +
                "            x = x + 1;\n" +
                "        }\n" +
                "    }\n" +
                "}"), "2");
        panelEjercicios.add(new JTextArea("3. Suponga que se tienen los siguientes dos algoritmos para resolver el mismo problema, y suponga que la función buscar tiene complejidad O(n log n)\n\n" +
                "boolean Ex1(int[] a, int elem) {   |   boolean Ex2(int[] a, int elem) {\n" +
                "    int pos = buscar(a, elem);     |       int n = a.length;\n" +
                "    int n = a.length;              |       int x = 0;\n" +
                "    int x = pos;                   |       for (int i = 0; i < n; ++i) {\n" +
                "    for (int i = 0; i < n; ++i) { |           int pos = buscar(a, elem);\n" +
                "        x += 2;                    |           x += pos + 2;\n" +
                "        for (int j = 0; j < n; ++j) {|           for (int j = 0; j < n; ++j) {\n" +
                "            if (a[j] > a[pos]) {   |               if (a[j] > a[pos]) {\n" +
                "                x++;               |                   x++;\n" +
                "            }                      |               }\n" +
                "        }                          |           }\n" +
                "    }                              |       }\n" +
                "    return x > elem;               |       return x > elem;\n" +
                "}                                  |   }\n\n" +
                "Indique cuál de los dos algoritmos se queda para resolver el problema. Justifique su respuesta."), "3");
        panelPrincipal.add(panelEjercicios, BorderLayout.CENTER);

        add(panelPrincipal);
        setVisible(true);
    }

    private void cambiarPantalla() {
        String opcionSeleccionada = (String) puntoComboBox.getSelectedItem();
        CardLayout cardLayout = (CardLayout) panelEjercicios.getLayout();
        cardLayout.show(panelEjercicios, opcionSeleccionada);

        if (opcionSeleccionada.equals("2")) {
            ComplejidadAlgoritmoXXXXXX.calcularComplejidad(100); // Ejemplo con n = 100
        } else if (opcionSeleccionada.equals("3")) {
            ComplejidadAlgoritmosEx1yEx2.analizarAlgoritmos();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}