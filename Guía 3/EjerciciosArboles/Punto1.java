import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import Nodo;
import ArbolBinario;

class Nodo {
    int dato;
    Nodo izquierdo;
    Nodo derecho;

    Nodo(int dato) {
        this.dato = dato;
        izquierdo = derecho = null;
    }
}

class ArbolBinario {
    Nodo raiz;

    ArbolBinario() {
        raiz = null;
    }

    void insertarNodo(int dato) {
        raiz = insertarNodoRecursivo(raiz, dato);
    }

    Nodo insertarNodoRecursivo(Nodo nodo, int dato) {
        if (nodo == null) {
            nodo = new Nodo(dato);
            return nodo;
        }

        if (dato < nodo.dato)
            nodo.izquierdo = insertarNodoRecursivo(nodo.izquierdo, dato);
        else if (dato > nodo.dato)
            nodo.derecho = insertarNodoRecursivo(nodo.derecho, dato);

        return nodo;
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

    List<Integer> obtenerRama(Nodo nodo, List<Integer> rama) {
        if (nodo == null)
            return rama;

        rama.add(nodo.dato);

        if (nodo.izquierdo != null)
            rama = obtenerRama(nodo.izquierdo, rama);

        if (nodo.derecho != null)
            rama = obtenerRama(nodo.derecho, rama);

        return rama;
    }
}

class Punto1 extends JFrame {
    private JTextArea textArea;
    private ArbolBinario arbol;

    public Punto1() {
        setTitle("Punto 1");
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
        arbol.insertarNodo(27);
        arbol.insertarNodo(14);
        arbol.insertarNodo(35);
        arbol.insertarNodo(10);
        arbol.insertarNodo(19);
        arbol.insertarNodo(31);
        arbol.insertarNodo(42);

        mostrarResultados();
    }

    private void mostrarResultados() {
        StringBuilder sb = new StringBuilder();
        sb.append("a. Peso: ").append(arbol.peso(arbol.raiz)).append("\n");
        sb.append("b. Altura: ").append(arbol.altura(arbol.raiz)).append("\n");
        sb.append("c. Hojas: ").append(arbol.contarHojas(arbol.raiz)).append("\n");
        List<Integer> rama = new ArrayList<>();
        sb.append("d. Una rama: ").append(arbol.obtenerRama(arbol.raiz, rama)).append("\n");
        sb.append("e. Recorrido en inorden: ");
        arbol.inorden(arbol.raiz);
        sb.append("\n");
        sb.append("f. Recorrido en preorden: ");
        arbol.preorden(arbol.raiz);
        sb.append("\n");
        sb.append("g. Recorrido en postorden: ");
        arbol.postorden(arbol.raiz);

        textArea.setText(sb.toString());
    }
}