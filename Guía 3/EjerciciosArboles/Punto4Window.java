import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Punto4Window extends JFrame {
    private JLabel enunciadoLabel;
    private ArbolComponent arbolComponent;

    public Punto4Window() {
        setTitle("Punto 4");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Crear un panel para mostrar los resultados
        JPanel resultsPanel = new JPanel(new BorderLayout());

        // Agregar una etiqueta con el enunciado del punto 4
        enunciadoLabel = new JLabel("<html>4. Reconstruya el árbol binario que posee los siguientes recorridos:<br><br>" +
                "Postorden: A -- C -- E -- D -- B -- H -- I -- G -- F<br>" +
                "Inorden: A -- B -- C -- D -- E -- F -- G -- H -- I</html>");
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
        char[] postorden = {'A', 'C', 'E', 'D', 'B', 'H', 'I', 'G', 'F'};
        char[] inorden = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        Nodo raiz = reconstruirArbol(postorden, inorden);

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
        char valor;
        Nodo izquierda;
        Nodo derecha;

        Nodo(char valor) {
            this.valor = valor;
        }
    }

    private Nodo reconstruirArbol(char[] postorden, char[] inorden) {
        Map<Character, Integer> indices = new HashMap<>();
        for (int i = 0; i < inorden.length; i++) {
            indices.put(inorden[i], i);
        }
        return reconstruirArbolAux(postorden, postorden.length - 1, 0, inorden, 0, inorden.length - 1, indices);
    }

    private Nodo reconstruirArbolAux(char[] postorden, int postordenDer, int postordenIzq, char[] inorden, int inordenIzq, int inordenDer, Map<Character, Integer> indices) {
        if (postordenIzq > postordenDer || inordenIzq > inordenDer) {
            return null;
        }

        char raizValor = postorden[postordenDer];
        Nodo raiz = new Nodo(raizValor);

        int inordenRaizIndice = indices.get(raizValor);
        int izquierdaSize = inordenRaizIndice - inordenIzq;

        raiz.izquierda = reconstruirArbolAux(postorden, postordenIzq + izquierdaSize - 1, postordenIzq, inorden, inordenIzq, inordenRaizIndice - 1, indices);
        raiz.derecha = reconstruirArbolAux(postorden, postordenDer - 1, postordenIzq + izquierdaSize, inorden, inordenRaizIndice + 1, inordenDer, indices);

        return raiz;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Punto4Window punto4Window = new Punto4Window();
            punto4Window.setVisible(true);
        });
    }
}