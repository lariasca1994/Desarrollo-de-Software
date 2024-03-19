import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Nodo;
import ArbolBinario;

class Nodo {
    char dato;
    Nodo izquierdo;
    Nodo derecho;

    Nodo(char dato) {
        this.dato = dato;
        izquierdo = derecho = null;
    }
}

class ArbolBinario extends ArbolBinario {
    Nodo ancestroComun(Nodo nodo, char n1, char n2) {
        if (nodo == null || nodo.dato == n1 || nodo.dato == n2)
            return nodo;

        Nodo izquierdo = ancestroComun(nodo.izquierdo, n1, n2);
        Nodo derecho = ancestroComun(nodo.derecho, n1, n2);

        if (izquierdo != null && derecho != null)
            return nodo;

        return (izquierdo != null) ? izquierdo : derecho;
    }
}

    void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            inorden(nodo.derecho);
        }
    }

    void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            preorden(nodo.izquierdo);
            preorden(nodo.derecho);
        }
    }

    void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.izquierdo);
            postorden(nodo.derecho);
            System.out.print(nodo.dato + " ");
        }
    }

    int altura(Nodo nodo) {
        if (nodo == null)
            return 0;
        else {
            int alturaIzquierda = altura(nodo.izquierdo);
            int alturaDerecha = altura(nodo.derecho);
            return Math.max(alturaIzquierda, alturaDerecha) + 1;
        }
    }

    int peso(Nodo nodo) {
        if (nodo == null)
            return 0;
        else
            return peso(nodo.izquierdo) + peso(nodo.derecho) + 1;
    }

    int contarHojas(Nodo nodo) {
        if (nodo == null)
            return 0;
        else if (nodo.izquierdo == null && nodo.derecho == null)
            return 1;
        else
            return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }

    Nodo ancestroComun(Nodo nodo, char n1, char n2) {
        if (nodo == null || nodo.dato == n1 || nodo.dato == n2)
            return nodo;

        Nodo izquierdo = ancestroComun(nodo.izquierdo, n1, n2);
        Nodo derecho = ancestroComun(nodo.derecho, n1, n2);

        if (izquierdo != null && derecho != null)
            return nodo;

        return (izquierdo != null) ? izquierdo : derecho;
    }
}

class Punto2 extends JFrame {
    private JTextArea textArea;
    private ArbolBinario arbol;

    public Punto2() {
        setTitle("Punto 2");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton volverButton = new JButton("Volver");
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(volverButton, BorderLayout.SOUTH);

        setContentPane(panel);

        arbol = new ArbolBinario();
        arbol.insertarNodo('F');
        arbol.insertarNodo('B');
        arbol.insertarNodo('G');
        arbol.insertarNodo('A');
        arbol.insertarNodo('D');
        arbol.insertarNodo('I');
        arbol.insertarNodo('C');
        arbol.insertarNodo('E');
        arbol.insertarNodo('H');

        mostrarResultados();
    }

    private void mostrarResultados() {
        StringBuilder sb = new StringBuilder();
        sb.append("a. Altura: ").append(arbol.altura(arbol.raiz)).append("\n");
        sb.append("b. Número de niveles: ").append(arbol.altura(arbol.raiz) + 1).append("\n");
        sb.append("c. Ancestro común de la E y la A: ").append(arbol.ancestroComun(arbol.raiz, 'E', 'A').dato).append("\n");
        sb.append("d. Peso del árbol izquierdo de la F: ").append(arbol.peso(arbol.raiz.izquierdo)).append("\n");
        sb.append("e. Recorrido en inorden: ");
        arbol.inorden(arbol.raiz);
        sb.append("\n");
        sb.append("f. Recorrido en preorden: ");
        arbol.preorden(arbol.raiz);
        sb.append("\n");
        sb.append("g. Recorrido en postorden: ");
        arbol.postorden(arbol.raiz);
        sb.append("\n");
        sb.append("h. Recorrido por niveles: \n"); // Implementar recorrido por niveles
        sb.append("i. Hojas: ").append(arbol.contarHojas(arbol.raiz));

        textArea.setText(sb.toString());
    }
}