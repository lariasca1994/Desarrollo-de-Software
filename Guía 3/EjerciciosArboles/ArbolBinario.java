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