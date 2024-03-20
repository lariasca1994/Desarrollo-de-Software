import javax.swing.*;
import java.awt.*;

public class Punto1Window extends JFrame {
    private JLabel enunciadoLabel;
    private ArbolComponent arbolComponent;

    public Punto1Window() {
        setTitle("Punto 1");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Crear un panel para mostrar los resultados
        JPanel resultsPanel = new JPanel(new BorderLayout());

        // Agregar una etiqueta con el enunciado del punto 1
        enunciadoLabel = new JLabel("<html>1. Para el siguiente árbol binario:<br><br>" +
                "Presente:<br>" +
                "a. Peso: <b>11</b><br>" +
                "b. Altura: <b>5</b><br>" +
                "c. Hojas: <b>74, 81, 57, 50, 39</b><br>" +
                "d. Una rama: <b>55, 48, 33, 76, 78</b><br>" +
                "Recorrido en inorden: <b>39, 33, 48, 50, 55, 57, 64, 74, 76, 78, 81</b><br>" +
                "e. Recorrido en preorden: <b>64, 55, 48, 33, 39, 50, 57, 76, 74, 78, 81</b><br>" +
                "f. Recorrido en postorden: <b>39, 33, 50, 48, 55, 57, 74, 76, 78, 81, 64</b></html>");
        resultsPanel.add(enunciadoLabel, BorderLayout.NORTH);

        // Agregar un componente personalizado para mostrar el árbol
        arbolComponent = new ArbolComponent();
        resultsPanel.add(arbolComponent, BorderLayout.CENTER);

        // Crear un botón "Volver"
        JButton volverButton = new JButton("Volver");
        volverButton.addActionListener(e -> dispose());
        resultsPanel.add(volverButton, BorderLayout.SOUTH);

        add(resultsPanel);

        // Construir el árbol binario
        Nodo raiz = new Nodo(64);
        raiz.izquierda = new Nodo(55);
        raiz.izquierda.izquierda = new Nodo(48);
        raiz.izquierda.izquierda.izquierda = new Nodo(33);
        raiz.izquierda.izquierda.izquierda.derecha = new Nodo(39);
        raiz.izquierda.izquierda.derecha = new Nodo(50);
        raiz.izquierda.derecha = new Nodo(57);
        raiz.derecha = new Nodo(76);
        raiz.derecha.izquierda = new Nodo(74);
        raiz.derecha.derecha = new Nodo(78);
        raiz.derecha.derecha.derecha = new Nodo(81);

        // Dibujar el árbol
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Punto1Window punto1Window = new Punto1Window();
            punto1Window.setVisible(true);
        });
    }
}