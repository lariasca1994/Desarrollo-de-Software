import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Punto5Window extends JFrame {
    private JLabel enunciadoLabel;
    private ArbolComponent arbolComponent;

    public Punto5Window() {
        setTitle("Punto 5");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Crear un panel para mostrar los resultados
        JPanel resultsPanel = new JPanel(new BorderLayout());

        // Agregar una etiqueta con el enunciado del punto 5
        enunciadoLabel = new JLabel("<html>5. Reconstruya el árbol binario que posee los siguientes recorridos:<br><br>" +
                "Preorden: 59 -- 37 -- 28 -- 16 -- 43 -- 48 -- 74 -- 80 -- 79<br>" +
                "Inorden: 16 -- 28 -- 37 -- 43 -- 48 -- 59 -- 74 -- 79 -- 80</html>");
        resultsPanel.add(enunciadoLabel, BorderLayout.NORTH);

        // Agregar un componente personalizado para mostrar el árbol
        arbolComponent = new ArbolComponent();
        resultsPanel.add(arbolComponent, BorderLayout.CENTER);

        // Crear un botón "Volver"
        JButton volverButton = new JButton("Volver");
        volverButton.addActionListener(e -> dispose());
        resultsPanel.add(volverButton, BorderLayout.SOUTH);

        add(resultsPanel);

        // Reconstruir el árbol binario a partir de los recorridos
        int[] preorden = {59, 37, 28, 16, 43, 48, 74, 80, 79};
        int[] inorden = {16, 28, 37, 43, 48, 59, 74, 79, 80};
        Nodo raiz = reconstruirArbol(preorden, inorden);

        // Dibujar el árbol reconstruido
        arbolComponent.setArbol(raiz);
    }

    // Componente personalizado para mostrar el árbol
    private class ArbolComponent extends JComponent {
        private Nodo raiz;

        public void setArbol(Nodo raiz) {
            this.raiz = raiz;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            dibujarArbol(g2d, raiz, getWidth() / 2, 20, getWidth() / 4);
        }

        private void dibujarArbol(Graphics2D g2d, Nodo nodo, int x, int y, int separacion) {
            if (nodo == null) {
                return;
            }

            g2d.drawOval(x - 15, y - 15, 30, 30);
            g2d.drawString(String.valueOf(nodo.valor), x, y + 5);

            if (nodo.izquierda != null) {
                int newX = x - separacion / 2;
                g2d.drawLine(x, y, newX, y + 50);
                dibujarArbol(g2d, nodo.izquierda, newX, y + 50, separacion / 2);
            }

            if (nodo.derecha != null) {
                int newX = x + separacion / 2;
                g2d.drawLine(x, y, newX, y + 50);
                dibujarArbol(g2d, nodo.derecha, newX, y + 50, separacion / 2);
            }
        }
    }

    private static class Nodo {
        int valor;
        Nodo izquierda;
        Nodo derecha;

        Nodo(int valor) {
            this.valor = valor;
        }
    }

    private Nodo reconstruirArbol(int[] preorden, int[] inorden) {
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < inorden.length; i++) {
            indices.put(inorden[i], i);
        }
        return reconstruirArbolAux(preorden, 0, preorden.length - 1, inorden, 0, inorden.length - 1, indices);
    }

    private Nodo reconstruirArbolAux(int[] preorden, int preordenIzq, int preordenDer, int[] inorden, int inordenIzq, int inordenDer, Map<Integer, Integer> indices) {
        if (preordenIzq > preordenDer || inordenIzq > inordenDer) {
            return null;
        }

        int raizValor = preorden[preordenIzq];
        Nodo raiz = new Nodo(raizValor);

        int inordenRaizIndice = indices.get(raizValor);
        int izquierdaSize = inordenRaizIndice - inordenIzq;

        raiz.izquierda = reconstruirArbolAux(preorden, preordenIzq + 1, preordenIzq + izquierdaSize, inorden, inordenIzq, inordenRaizIndice - 1, indices);
        raiz.derecha = reconstruirArbolAux(preorden, preordenIzq + izquierdaSize + 1, preordenDer, inorden, inordenRaizIndice + 1, inordenDer, indices);

        return raiz;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Punto5Window punto5Window = new Punto5Window();
            punto5Window.setVisible(true);
        });
    }
}