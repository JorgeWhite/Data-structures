import java.util.NoSuchElementException;

/**
 * <p>
 * Clase abstracta para modelar la estructura de datos Arbol Binario</p>
 * Puesto que todos los árboles binarios comparten algunas características
 * similares, esta clase sirve perfectamente para modelarlas. Sin embargo no es
 * lo suficientemente específica para modelar algun árbol completamente. Por lo
 * que la implementación final depende de las clases concretas que hereden de
 * ésta.</p>
 *
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 * @version 1.0
 * @param <T>
 */

public abstract class ArbolBinario<T> implements Coleccionable<T> {

    /**
     * Clase interna protegida para nodos.
     */
    protected class Nodo {

        public Nodo() {

        }

        /**
         * El elemento del nodo.
         */
        public T elemento;
        /**
         * Referencia a los nodos padre, e hijos.
         */
        public Nodo padre, izquierdo, derecho;

        /**
         * Constructor único que recibe un elemento.
         *
         * @param elemento el elemento del nodo.
         */
        public Nodo(T elemento) {
            this.elemento = elemento;
            this.padre = null;
            this.derecho = null;
            this.izquierdo = null;

        }

        /**
         * Nos dice si el nodo tiene un padre.
         *
         * @return <tt>true</tt> si el nodo tiene padre,
         * <tt>false</tt> en otro caso.
         */
        public boolean hayPadre() {
            if (this.padre == null){
                return false;
            }
            return true;
        }

        /**
         * Nos dice si el nodo tiene un izquierdo.
         *
         * @return <tt>true</tt> si el nodo tiene izquierdo,
         * <tt>false</tt> en otro caso.
         */
        public boolean hayIzquierdo() {
            if (this.izquierdo != null){
                return true;
            }
            return false;
        }

        /**
         * Nos dice si el nodo tiene un derecho.
         *
         * @return <tt>true</tt> si el nodo tiene derecho,
         * <tt>false</tt> en otro caso.
         */
        public boolean hayDerecho() {
            if (this.derecho != null){
                return true;
            }
            return false;
        }

        /**
         * Regresa la altura del nodo.
         *
         * @return la altura del nodo.
         */
        public int altura() {
            if (this.izquierdo== null && this.derecho == null){
                return 1;
            }
            if (this.izquierdo == null){
                return 1 + this.derecho.altura();
            }
            if (this.derecho == null){
                return 1 + this.izquierdo.altura();
            }
            return 1 + Math.max(this.izquierdo.altura(), this.derecho.altura());
        }


        /**
         * Compara el nodo con otro objeto. La comparación es
         * <em>recursiva</em>. Las clases que extiendan {@link Nodo} deben
         * sobrecargar el método {@link Nodo#equals}.
         *
         * @param o el objeto con el cual se comparará el nodo.
         * @return <code>true</code> si el objeto es instancia de la clase
         * {@link Nodo}, su elemento es igual al elemento de éste nodo, y los
         * descendientes de ambos son recursivamente iguales; <code>false</code>
         * en otro caso.
         */
        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            @SuppressWarnings("unchecked")
            Nodo nodo = (Nodo) o;
            return elemento.equals(nodo.elemento);

        }

        /**
         * Regresa una representación en cadena del nodo.
         *
         * @return una representación en cadena del nodo.
         */
        @Override
        public String toString() {
            return elemento.toString();
        }

        // Método auxiliar que calcula el inorder de un nodo.

        public Lista<T> inOrdenAux() {
            if (this.izquierdo == null && this.derecho == null){
                Lista auxiliar = new Lista();
                auxiliar.agregar(this.elemento);
                return auxiliar;
            }
            if (this.izquierdo == null){
                Lista auxiliar = new Lista(this.derecho.inOrdenAux());
                auxiliar.agregar(this.elemento);
                return auxiliar;
            }
            if (this.derecho == null){
                Lista auxiliar = new Lista(this.izquierdo.inOrdenAux());
                auxiliar.agregarAlFinal(this.elemento);
                return auxiliar;
            }
            Lista auxiliar1 = new Lista(this.izquierdo.inOrdenAux());
            Lista<T> auxiliar2 = new Lista<T>(this.derecho.inOrdenAux());
            auxiliar1.agregarAlFinal(this.elemento);
            for (T elem : auxiliar2){
                auxiliar1.agregarAlFinal(elem);
            }
            return auxiliar1;


        }

        //Método auxiiiar para calcular el preorden de un nodo.
        public Lista<T> preOrdenAux() {
            if (this.izquierdo == null && this.derecho == null){
                Lista auxiliar = new Lista();
                auxiliar.agregar(this.elemento);
                return auxiliar;
            }
            if (this.izquierdo == null){
                Lista auxiliar = new Lista(this.derecho.preOrdenAux());
                auxiliar.agregar(this.elemento);
                return auxiliar;
            }
            if (this.derecho == null){
                Lista auxiliar = new Lista(this.izquierdo.preOrdenAux());
                auxiliar.agregar(this.elemento);
                return auxiliar;
            }
            Lista aux1 = new Lista(this.izquierdo.preOrdenAux());
            Lista<T> aux2 = new Lista<T>(this.derecho.preOrdenAux());
            aux1.agregar(this.elemento);
            for (T elem : aux2){
                aux1.agregarAlFinal(elem);
            }
            return aux1;

        }

        //Método auxiliar para calcular el postorden de un nodo.
        public Lista<T> postOrdenAux() {
            if (this.izquierdo == null && this.derecho == null){
                Lista aux = new Lista();
                aux.agregar(this.elemento);
                return aux;
            }
            if (this.izquierdo == null){
                Lista aux = new Lista(this.derecho.postOrdenAux());
                aux.agregarAlFinal(this.elemento);
                return aux;
            }
            if (this.derecho == null){
                Lista aux = new Lista(this.izquierdo.postOrdenAux());
                aux.agregarAlFinal(this.elemento);
                return aux;
            }
            Lista aux1 = new Lista(this.izquierdo.postOrdenAux());
            Lista<T> aux2 = new Lista<T>(this.derecho.postOrdenAux());
            for (T elem : aux2){
                aux1.agregarAlFinal(elem);
            }
            aux1.agregarAlFinal(this.elemento);
            return aux1;
        }

        public boolean esHoja(){
            if (this.hayDerecho() == false && this.hayIzquierdo() == false){
                return true;
            }
            return false;
        }

        public boolean esHojaIzq(){
            if (this.esHoja() && this.padre.izquierdo == this){
                return true;
            }
            return false;
        }

        public boolean esHojaDer(){
            if (this.esHoja() && this.padre.derecho == this){
                return true;
            }
            return false;
        }


    }

    /**
     * La raíz del árbol.
     */
    protected Nodo raiz;
    /**
     * El número de elementos
     */
    protected int tamanio;

    /**
     * Constructor sin parámetros.
     */
    public ArbolBinario() {
    }

    /**
     * Construye un árbol binario a partir de una colección. El árbol binario
     * tendrá los mismos elementos que la colección recibida.
     *
     * @param iterable
     */
    public ArbolBinario(Iterable<T> iterable) {

    }

    /**
     * Construye un nuevo nodo, usando una instancia de {@link Nodo}. Para crear
     * nodos se debe utilizar este método en lugar del operador
     * <code>new</code>, para que las clases herederas de ésta puedan
     * sobrecargarlo y permitir que cada estructura de árbol binario utilice
     * distintos tipos de nodos.
     *
     * @param elemento el elemento dentro del nodo.
     * @return un nuevo nodo con el elemento recibido dentro del mismo.
     */
    protected Nodo nuevoNodo(T elemento) {
        return new Nodo(elemento);
    }

    /**
     * Regresa la altura del árbol. La altura de un árbol es la altura de su
     * raíz.
     *
     * @return la altura del árbol.
     */
    public int altura() {
        if (raiz == null){
            return 0;
        }
        return raiz.altura();
    }

    /**
     * Regresa el número de elementos que se han agregado al árbol.
     *
     * @return el número de elementos en el árbol.
     */
    @Override
    public int getTamanio() {
        return tamanio;
    }

    /**
     * Regresa el nodo que contiene la raíz del árbol.
     *
     * @return el nodo que contiene la raíz del árbol.
     * @throws NoSuchElementException si el árbol es vacío.
     */
    protected Nodo raiz() {
        if (this.raiz == null){
            throw new NoSuchElementException();
        }
        return (this.raiz);
    }

    /**
     * Nos dice si el árbol es vacío.
     *
     * @return <code>true</code> si el árbol es vacío, <code>false</code> en
     * otro caso.
     */
    @Override
    public boolean esVacia() {
        if (this.raiz == null){
            return true;
        }
        return false;
    }

    /**
     * Limpia el árbol de elementos, dejándolo vacío.
     */
    public void vaciar() {
        this.raiz.derecho = null;
        this.raiz.izquierdo = null;
        this.raiz = null;
        this.tamanio = 0;

    }


    /**
     * Regresa una Cola con el los elementos en inorden del árbol.
     *
     * @return Cola con los elementos del arbol.
     */
    public Lista<T> inOrden() {
        // Al estar agregando elementos de una lista a una cola, necesito primero invertir la lista para que la cola tenga el orden deseado.
        Lista lista_aux = new Lista();
        for (T elem : raiz.inOrdenAux()){
            lista_aux.agregar(elem);
        }
        Cola c = new Cola(lista_aux);
        return c;
    }

    /**
     * Regresa una Cola con el los elementos en inorden del árbol.
     *
     * @return Cola con los elementos del arbol.
     */
    public Lista<T> preOrden() {
        // Al estar agregando elementos de una lista a una cola, necesito primero invertir la lista para que la cola tenga el orden deseado.
        Lista lista_aux = new Lista();
        for (T elem : this.raiz.preOrdenAux()){
            lista_aux.agregar(elem);
        }
        Cola c = new Cola(lista_aux);
        return c;
    }

    /**
     * Regresa una Cola con el los elementos en inorden del árbol.
     *
     * @return Cola con los elementos del arbol.
     */
    public Lista<T> postOrden() {
        // Al estar agregando elementos de una lista a una cola, necesito primero invertir la lista para que la cola tenga el orden deseado.
        Lista lista_aux = new Lista();
        for (T elem : this.raiz.postOrdenAux()){
            lista_aux.agregar(elem);
        }
        Cola c = new Cola(lista_aux);
        return c;
    }

    /**
     * Compara el árbol con un objeto.
     *
     * @param o el objeto con el que queremos comparar el árbol.
     * @return <code>true</code> si el objeto recibido es un árbol binario y los
     * árboles son iguales; <code>false</code> en otro caso.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        @SuppressWarnings("unchecked")
        ArbolBinario<T> arbol = (ArbolBinario<T>) o;
        if (this.inOrden().equals(arbol.inOrden()) && this.preOrden().equals(arbol.preOrden())){
            return true;
        }

        return false;
    }

    /**
     * Regresa una representación en cadena del árbol.
     *
     * @return una representación en cadena del árbol.
     */
    @Override
    public String toString() {

        if (raiz == null) {
            return "";
        }

        boolean[] r = new boolean[altura() + 1];
        for (int i = 0; i < altura() + 1; i++) {
            r[i] = false;
        }
        return cadena(raiz, 0, r);

    }

    private String cadena(Nodo v, int n, boolean[] r) {
        String s = v + "\n";
        r[n] = true;
        if (v.izquierdo != null && v.derecho != null) {
            s += dibujaEspacios(n, r);
            s += "├─›";
            s += cadena(v.izquierdo, n + 1, r);
            s += dibujaEspacios(n, r);
            s += "└─»";
            r[n] = false;
            s += cadena(v.derecho, n + 1, r);
        } else if (v.izquierdo != null) {
            s += dibujaEspacios(n, r);
            s += "└─›";
            r[n] = false;
            s += cadena(v.izquierdo, n + 1, r);
        } else if (v.derecho != null) {
            s += dibujaEspacios(n, r);
            s += "└─»";
            r[n] = false;
            s += cadena(v.derecho, n + 1, r);
        }
        return s;
    }

    private String dibujaEspacios(int n, boolean[] r) {
        String s = "";
        for (int i = 0; i < n; i++) {
            if (r[i]) {
                s += "│  ";
            } else {
                s += "   ";
            }
        }
        return s;
    }
}
