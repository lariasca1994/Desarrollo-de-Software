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

class ArbolBinario {
    Nodo raiz;

    ArbolBinario() {
        raiz = null;
    }

    void insertarNodo(char dato) {
        raiz = insertarNodoRecursivo(raiz, dato);
    }

    Nodo insertarNodoRecursivo(Nodo nodo, char dato) {
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

class Punto4 extends JFrame {
    private JTextArea textArea;
    private ArbolBinario arbol;

    public Punto4() {
        setTitle("Punto 4");
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
        reconstruirArbol(new char[]{'A', 'C', 'E', 'D', 'B', 'H', 'I', 'G', 'F'},
                new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'});

        mostrarResultados();
    }

    private void reconstruirArbol(char[] postorden, char[] inorden) {
        int indiceRaiz = buscarIndiceRaiz(inorden, postorden[postorden.length - 1]);
        arbol.raiz = new Nodo(postorden[postorden.length - 1]);

        if (indiceRaiz > 0) {
            char[] postordenIzquierda = new char[indiceRaiz];
            char[] inordenIzquierda = new char[indiceRaiz];
            for (int i = 0; i < indiceRaiz; i++) {
                postordenIzquierda[i] = postorden[i];
                inordenIzquierda[i] = inorden[i];
            }
            arbol.raiz.izquierdo = reconstruirArbolRecursivo(postordenIzquierda, inordenIzquierda);
        }

        if (indiceRaiz < inorden.length - 1) {
            char[] postordenDerecha = new char[inorden.length - indiceRaiz - 1];
            char[] inordenDerecha = new char[inorden.length - indiceRaiz - 1];
            int j = 0;
            for (int i = indiceRaiz + 1; i < inorden.length; i++) {
                postordenDerecha[j] = postorden[indiceRaiz + j];
                inordenDerecha[j] = inorden[i];
                j++;
            }
            arbol.raiz.derecho = reconstruirArbolRecursivo(postordenDerecha, inordenDerecha);
        }
    }

    private Nodo reconstruirArbolRecursivo(char[] postorden, char[] inorden) {
        if (postorden.length == 0)
            return null;

        int indiceRaiz = buscarIndiceRaiz(inorden, postorden[postorden.length - 1]);
        Nodo nodo = new Nodo(postorden[postorden.length - 1]);

        if (indiceRaiz > 0) {
            char[] postordenIzquierda = new char[indiceRaiz];
            char[] inordenIzquierda = new char[indiceRaiz];
            for (int i = 0; i < indiceRaiz; i++) {
                postordenIzquierda[i] = postorden[i];
                inordenIzquierda[i] = inorden[i];
            }
            nodo.izquierdo = reconstruirArbolRecursivo(postordenIzquierda, inordenIzquierda);
        }

        if (indiceRaiz < inorden.length - 1) {
            char[] postordenDerecha = new char[inorden.length - indiceRaiz - 1];
            char[] inordenDerecha = new char[inorden.length - indiceRaiz - 1];
            int j = 0;
            for (int i = indiceRaiz + 1; i < inorden.length; i++) {
                postordenDerecha[j] = postorden[indiceRaiz + j];
                inordenDerecha[j] = inorden[i];
                j++;
            }
            nodo.derecho = reconstruirArbolRecursivo(postordenDerecha, inordenDerecha);
        }

        return nodo;
    }

    private int buscarIndiceRaiz(char[] inorden, char dato) {
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