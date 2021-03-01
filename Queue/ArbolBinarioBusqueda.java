import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>
 * Clase para modelar árboles binarios de búsqueda genéricos.</p>
 *
 * <p>
 * Un árbol instancia de esta clase siempre cumple que:</p>
 * <ul>
 * <li>Cualquier elemento en el árbol es mayor o igual que todos sus
 * descendientes por la izquierda.</li>
 * <li>Cualquier elemento en el árbol es menor o igual que todos sus
 * descendientes por la derecha.</li>
 * </ul>
 *
 * @param <T>
 */
public class ArbolBinarioBusqueda<T extends Comparable<T>> extends ArbolBinario<T> {

    /* Clase privada para iteradores de árboles binarios ordenados. */
    private class Iterador implements Iterator<T> {

        /* Pila para recorrer los nodos por profundidad (DFS). */
        private Pila<Nodo> pila;

        /* Construye un iterador con el nodo recibido. */
        public Iterador() {
            if (raiz == null){
                throw new NoSuchElementException();
            }
            pila = new Pila<Nodo>();
            pila.push(raiz);
            while(pila.top().izquierdo != null){
                pila.push(pila.top().izquierdo);
            }
        }

        /* Nos dice si hay un elemento siguiente. */
        @Override
        public boolean hasNext() {
            return !pila.esVacia();
       	}

        /* Regresa el siguiente elemento en orden DFS in-order. */
        @Override
        public T next() {
                Nodo aux = pila.top();
                Nodo aux2 = pila.top();
                pila.pop();
                if (!aux.hayDerecho()){
                    return aux2.elemento;
                }
                if (aux.hayDerecho()) {
                    pila.push(aux.derecho);
                    aux = aux.derecho;
                }
                while (aux.hayIzquierdo()) {
                    pila.push(aux.izquierdo);
                    aux = aux.izquierdo;
                }
                return aux2.elemento;
        }
    }

    /**
     * Constructor que no recibe parámeteros. {@link ArbolBinario}.
     */
    public ArbolBinarioBusqueda() {

    }

    /**
     * Construye un árbol binario ordenado a partir de una colección. El árbol
     * binario ordenado tiene los mismos elementos que la colección recibida.
     *
     * @param coleccion la colección a partir de la cual creamos el árbol
     * binario ordenado.
     */
    public ArbolBinarioBusqueda(Coleccionable<T> coleccion) {
        super(coleccion);
        if (coleccion.getClass().equals(Cola.class)){
            Cola<T> aux = new Cola<T>();

            for (T elem : coleccion){
                aux.queue(elem);
            }
            for (T elem : aux){
                this.agregar(elem);
            }
            return;
        }
        for (T elem : coleccion){
            this.agregar(elem);
        }
    }

    /**
     * Método recursivo auxiliar que agrega un elemento contenido en el nodo nuevo.
     * Comienza las comparaciones desde el nodo n.
     *
     **/
    protected void agregaNodo(Nodo n, Nodo nuevo) {
            Nodo auxiliar = n;
            if (tamanio == 0){
                this.raiz = nuevo;
                raiz.padre = null;
                raiz.izquierdo = null;
                raiz.derecho = null;
                this.tamanio += 1;
                return;
            }
            while(auxiliar != null){
                if (nuevo.elemento.compareTo(auxiliar.elemento) < 0){
                    if (auxiliar.izquierdo == null){
                        auxiliar.izquierdo = nuevo;
                        nuevo.padre = auxiliar;
                        this.tamanio += 1;
                        auxiliar = null;
                    } else {
                        auxiliar = auxiliar.izquierdo;
                    }
                }  else {
                    if (auxiliar.derecho == null){
                        auxiliar.derecho = nuevo;
                        nuevo.padre = auxiliar;
                        this.tamanio += 1;
                        auxiliar = null;
                    } else {
                        auxiliar = auxiliar.derecho;
                    }

                }
            }

    }

    /**
     * Agrega un nuevo elemento al árbol. El árbol conserva su orden in-order.
     *
     * @param elemento el elemento a agregar.
     */
    @Override
    public void agregar(T elemento) {
        Nodo nuevo = nuevoNodo(elemento);
        agregaNodo(raiz, nuevo);
    }

    /**
     * Método auxiliar que elimina el nodo n. Notemos que en este punto
     * ya tenemos una referencia al nodo que queremos eliminar.
     **/
    protected Nodo eliminaNodo(Nodo n) {
        Nodo aux = n;
        if (this.tamanio == 1){
            this.vaciar();
            return aux;
        }
        if (n.esHojaIzq()){
            n.padre.izquierdo = null;
            this.tamanio -= 1;
            return aux;

        }
        if (n.esHojaDer()){
            n.padre.derecho = null;
            this.tamanio -= 1;
            return aux;
        }
        if (this.maximoEnSubarbolIzquierdo(n) == null){
            if (n.padre == null){
                this.raiz = n.derecho;
                n.derecho.padre = null;
            } else {
                n.padre.derecho = n.derecho;
                n.derecho.padre = n.padre;
            }
            this.tamanio -= 1;
        } else {
            Nodo max = this.maximoEnSubarbolIzquierdo(n);
            n.elemento = max.elemento;
            if (max == n.izquierdo){
                n.izquierdo = max.izquierdo;
                if (max.hayIzquierdo()){
                    max.izquierdo.padre = n;
                }
                this.tamanio -= 1;
                return aux;
            } else {
                max.padre.derecho = max.izquierdo;
                if (max.hayIzquierdo()) {
                    max.izquierdo.padre = max.padre;
                }
                this.tamanio -= 1;
                return aux;
            }
        }
        return aux;
    }

    /**
     * Elimina un elemento. Si el elemento no está en el árbol, no hace nada; si
     * está varias veces, elimina el primero que encuentre (in-order). El árbol
     * conserva su orden in-order.
     *
     * @param elemento el elemento a eliminar.
     */
    @Override
    public void eliminar(T elemento) {
        if (this.buscaNodo(raiz, elemento) == null){
            return;
        }
        Nodo n = buscaNodo(raiz, elemento);
        eliminaNodo(n);
    }

    /**
     * Método que encuentra el elemento máximo en el subárbol izquierdo
     **/
    private Nodo maximoEnSubarbolIzquierdo(Nodo n) {
        if (n.izquierdo == null){
            return null;
        }
        Nodo aux = n.izquierdo;
        while (aux.derecho != null){
                aux = aux.derecho;
        }
        return aux;
    }

    /**
     * Nos dice si un elemento está contenido en el arbol.
     *
     * @param elemento el elemento que queremos verificar si está contenido en
     * la arbol.
     * @return <code>true</code> si el elemento está contenido en el arbol,
     * <code>false</code> en otro caso.
     */
    @Override
    public boolean contiene(T elemento) {
        return buscaNodo(raiz, elemento) != null;
    }

    /**
     * Método que busca un a elemento en el árbol desde el nodo n
     **/
    protected Nodo buscaNodo(Nodo n, T elemento) {
        Nodo aux = n;
        while (aux != null){
            if (elemento.compareTo(aux.elemento) < 0){
                aux = aux.izquierdo;
            } else if (elemento.equals(aux.elemento)){
                return aux;
            } else {
                aux = aux.derecho;
            }
        }
        return aux;
    }

    /**
     * Rota el árbol a la derecha sobre el nodo recibido. Si el nodo no tiene
     * hijo izquierdo, el método no hace nada.
     *
     * @param nodo el nodo sobre el que vamos a rotar.
     */
    protected void rotacionDerecha(Nodo nodo) {
        if(!nodo.hayIzquierdo()){
            return;
        }
        Nodo aux = nodo.izquierdo.derecho;
        nodo.izquierdo.derecho = nodo;
        nodo.izquierdo.padre = nodo.padre;
        if (nodo == raiz){
            raiz = nodo.izquierdo;
            nodo.padre = nodo.izquierdo;
            nodo.izquierdo = aux;
            if (aux != null){
                aux.padre = nodo;
            }
            return;
        }

        if (nodo.padre.izquierdo == nodo){
            nodo.padre.izquierdo = nodo.izquierdo;
        }
        nodo.padre.derecho = nodo.izquierdo;
        nodo.padre = nodo.izquierdo;
        nodo.izquierdo = aux;
        if (aux != null){
            aux.padre = nodo;
        }
    }

    /**
     * Rota el árbol a la izquierda sobre el nodo recibido. Si el nodo no tiene
     * hijo derecho, el método no hace nada.
     *
     * @param nodo el nodo sobre el que vamos a rotar.
     */
    protected void rotacionIzquierda(Nodo nodo) {
        if (!nodo.hayDerecho()){
            return;
        }
        Nodo aux = nodo.derecho.izquierdo;
        nodo.derecho.izquierdo = nodo;
        nodo.derecho.padre = nodo.padre;
        if (nodo == raiz){
            raiz = nodo.derecho;
            nodo.padre = nodo.derecho;
            nodo.derecho = aux;
            if (aux != null){
                aux.padre = nodo;
            }
            return;
        }

        if (nodo.padre.izquierdo == nodo){
            nodo.padre.izquierdo = nodo.derecho;
        }
        nodo.padre.derecho = nodo.derecho;
        nodo.padre = nodo.derecho;
        nodo.derecho = aux;
        if (aux != null){
            aux.padre = nodo;
        }
    }

    /**
     * Regresa un iterador para iterar el árbol. El árbol se itera en orden.
     *
     * @return un iterador para iterar el árbol.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterador();
    }
    public void pruebaRotacionIzquierda(T elemento){
        Nodo nodo = this.buscaNodo(raiz, elemento);
        this.rotacionIzquierda(nodo);
    }

    public void pruebaRotacionDerecha(T elemento){
        Nodo nodo = this.buscaNodo(raiz, elemento);
        this.rotacionDerecha(nodo);
    }


}
