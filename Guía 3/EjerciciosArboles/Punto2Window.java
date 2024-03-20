import javax.swing.*;
import java.awt.*;

public class Punto2Window extends JFrame {
    private JLabel enunciadoLabel;
    private ArbolComponent arbolComponent;

    public Punto2Window() {
        setTitle("Punto 2");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Crear un panel para mostrar los resultados
        JPanel resultsPanel = new JPanel(new BorderLayout());

        // Agregar una etiqueta con el enunciado del punto 2
        enunciadoLabel = new JLabel("<html>2. Para el siguiente árbol binario:<br><br>" +
                "Indique:<br>" +
                "a. Altura: <b>4</b><br>" +
                "b. Número de niveles: <b>4</b><br>" +
                "c. Ancestro común de la E y la A: <b>B</b><br>" +
                "d. Peso del árbol izquierdo de la F: <b>3</b><br>" +
                "e. Recorrido en inorden: <b>C, D, E, B, A, F, G, I, H</b><br>" +
                "f. Recorrido en preorden: <b>F, B, A, D, C, E, G, I, H</b><br>" +
                "g. Recorrido en postorden: <b>A, C, E, D, B, H, I, G, F</b><br>" +
                "h. Recorrido por niveles: <b>4</b><br>" +
                "i. Hojas: <b>A, C, E, H</b></html>");
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
        Nodo raiz = new Nodo('F');
        raiz.izquierda = new Nodo('B');
        raiz.izquierda.izquierda = new Nodo('A');
        raiz.izquierda.derecha = new Nodo('D');
        raiz.izquierda.derecha.izquierda = new Nodo('C');
        raiz.izquierda.derecha.derecha = new Nodo('E');
        raiz.derecha = new Nodo('G');
        raiz.derecha.derecha = new Nodo('I');
        raiz.derecha.derecha.izquierda = new Nodo('H');

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
        char valor;
        Nodo izquierda;
        Nodo derecha;

        Nodo(char valor) {
            this.valor = valor;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Punto2Window punto2Window = new Punto2Window();
            punto2Window.setVisible(true);
        });
    }
}