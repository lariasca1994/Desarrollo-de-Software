import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
}

class Punto5 extends JFrame {
    private JTextArea textArea;
    private ArbolBinario arbol;

    public Punto5() {
        setTitle("Punto 5");
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
        reconstruirArbol(new int[]{59, 37, 28, 16, 43, 48, 74, 80, 79},
                new int[]{16, 28, 37, 43, 48, 59, 74, 79, 80});

        mostrarResultados();
    }

    private void reconstruirArbol(int[] preorden, int[] inorden) {
        int indiceRaiz = buscarIndiceRaiz(inorden, preorden[0]);
        arbol.raiz = new Nodo(preorden[0]);

        if (indiceRaiz > 0) {
            int[] preordenIzquierda = new int[indiceRaiz];
            int[] inordenIzquierda = new int[indiceRaiz];
            for (int i = 0; i < indiceRaiz; i++) {
                preordenIzquierda[i] = preorden[i + 1];
                inordenIzquierda[i] = inorden[i];
            }
            arbol.raiz.izquierdo = reconstruirArbolRecursivo(preordenIzquierda, inordenIzquierda);
        }

        if (indiceRaiz < inorden.length - 1) {
            int[] preordenDerecha = new int[inorden.length - indiceRaiz - 1];
            int[] inordenDerecha = new int[inorden.length - indiceRaiz - 1];
            int j = 0;
            for (int i = indiceRaiz + 1; i < inorden.length; i++) {
                preordenDerecha[j] = preorden[indiceRaiz + 1 + j];
                inordenDerecha[j] = inorden[i];
                j++;
            }
            arbol.raiz.derecho = reconstruirArbolRecursivo(preordenDerecha, inordenDerecha);
        }
    }

    private Nodo reconstruirArbolRecursivo(int[] preorden, int[] inorden) {
        if (preorden.length == 0)
            return null;

        int indiceRaiz = buscarIndiceRaiz(inorden, preorden[0]);
        Nodo nodo = new Nodo(preorden[0]);

        if (indiceRaiz > 0) {
            int[] preordenIzquierda = new int[indiceRaiz];
            int[] inordenIzquierda = new int[indiceRaiz];
            for (int i = 0; i < indiceRaiz; i++) {
                preordenIzquierda[i] = preorden[i + 1];
                inordenIzquierda[i] = inorden[i];
            }
            nodo.izquierdo = reconstruirArbolRecursivo(preordenIzquierda, inordenIzquierda);
        }

        if (indiceRaiz < inorden.length - 1) {
            int[] preordenDerecha = new int[inorden.length - indiceRaiz - 1];
            int[] inordenDerecha = new int[inorden.length - indiceRaiz - 1];
            int j = 0;
            for (int i = indiceRaiz + 1; i < inorden.length; i++) {
                preordenDerecha[j] = preorden[indiceRaiz + 1 + j];
                inordenDerecha[j] = inorden[i];
                j++;
            }
            nodo.derecho = reconstruirArbolRecursivo(preordenDerecha, inordenDerecha);
        }

        return nodo;
    }

    private int buscarIndiceRaiz(int[] inorden, int dato) {
        for (int i = 0; i < inorden.length; i++) {
            if (inorden[i] == dato)
                return i;
        }
        return -1;
    }

    private void mostrarResultados() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recorrido en inorden: ");
        arbol.inorden(arbol.raiz);
        sb.append("\n");
        sb.append("Recorrido en preorden: ");
        arbol.preorden(arbol.raiz);
        sb.append("\n");
        sb.append("Recorrido en postorden: ");
        arbol.postorden(arbol.raiz);

        textArea.setText(sb.toString());
    }
}