/**
 * <p>
 * Clase para árboles AVL.</p>
 *
 * <p>
 * Un árbol AVL cumple que para cada uno de sus nodos, la diferencia entre la
 * áltura de sus subárboles izquierdo y derecho está entre -1 y 1.</p>
 *
 * @param <T>
 */
public class ArbolAVL<T extends Comparable<T>> extends ArbolBinarioBusqueda<T> {

    /**
     * Clase interna protegida para nodos de árboles AVL. La única diferencia
     * con los nodos de árbol binario, es que tienen una variable de clase para
     * la altura del nodo.
     */
    protected class NodoAVL extends ArbolBinario.Nodo {

        /**
         * La altura del nodo.
         */
        protected int altura;

        /**
         * Constructor único que recibe un elemento.
         *
         * @param elemento el elemento del nodo.
         */
        public NodoAVL(T elemento) {
            this.padre = null;
            this.elemento = elemento;
            this.derecho = null;
            this.izquierdo = null;
            this.altura = 1;
        }
	
	/**
	 * Recomendamos usar este método auxiliar para que en el método público
	 * hagas el cast del objeto o, a NodoAVL y dejar el trabajo a este método.
  	 * Si no quieres usarlo, siéntete libre de eliminar esta firma.
	 */
        private boolean equals(NodoAVL v, NodoAVL v2) {
            return v.elemento == v2.elemento && v.altura == v2.altura;
        }

        /**
         * Compara el nodo con otro objeto. La comparación es
         * <em>recursiva</em>.
         *
         * @param o el objeto con el cual se comparará el nodo.
         * @return <code>true</code> si el objeto es instancia de la clase
         * {@link NodoAVL}, su elemento es igual al elemento de éste nodo, los
         * descendientes de ambos son recursivamente iguales, y las alturas son
         * iguales; <code>false</code> en otro caso.
         */
        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (getClass() != o.getClass()) {
                return false;
            }
            @SuppressWarnings("unchecked")
            NodoAVL nodo = (NodoAVL) o;
            return this.inOrdenAux() == nodo.inOrdenAux() && this.preOrdenAux() == nodo.preOrdenAux();
        }

        @Override
        public String toString() {
            String s = super.toString();
            return s += " alt=" + altura;
        }
    }

    public ArbolAVL() {

    }

    public ArbolAVL(Coleccionable<T> coleccion) {
        super(coleccion);
    }

    private void actualizaAltura(NodoAVL v) {
        if (v == null){
            v.altura = 0;
        }
        if (v.esHoja()){
            v.altura = 1;
        }
        int alt_izq = 0;
        int alt_der = 0;

        if (v.izquierdo != null){
            alt_izq = (nodoAVL(v.izquierdo)).altura;
        }
        if (v.derecho != null){
            alt_der = (nodoAVL(v.derecho)).altura;
        }
        v.altura = 1 + Math.max(alt_izq, alt_der);
    }


    //Método auxiliar que nos da el balance de un nodoAVL.
    private int balance(NodoAVL nodo){
        if (nodo.esHoja()){
            return 0;
        }
        if (nodo.derecho == null){
            return nodoAVL(nodo.izquierdo).altura;
        }
        if (nodo.izquierdo == null){
            return -nodoAVL(nodo.derecho).altura;
        }
        return nodoAVL(nodo.izquierdo).altura - nodoAVL(nodo.derecho).altura;
    }

    private void rebalancea(NodoAVL nodo) {
        if (nodo == null){
            return;
        }
        if (this.balance(nodo) == 2){
            if (this.balance(nodoAVL(nodo.izquierdo)) == -1){
                this.rotacionIzquierda(nodo.izquierdo);
                this.actualizaAltura(nodoAVL(nodo.izquierdo.izquierdo));
            }
            this.rotacionDerecha(nodo);
        }
        if (this.balance(nodo) == -2){
            if (this.balance(nodoAVL(nodo.derecho)) == 1){
                this.rotacionDerecha(nodo.derecho);
                this.actualizaAltura(nodoAVL(nodo.derecho.derecho));
            }
            this.rotacionIzquierda(nodo);
        }
        this.actualizaAltura(nodo);
        this.rebalancea(nodoAVL(nodo.padre));
    }

    /**
     * Agrega un nuevo elemento al árbol. El método invoca al método {@link
     * ArbolBinarioBusqueda#agregaNodo}, y después balancea el árbol girándolo como
     * sea necesario. La complejidad en tiempo del método es <i>O</i>(log
     * <i>n</i>) garantizado.
     *
     * @param elemento el elemento a agregar.
     */
    @Override
    public void agregar(T elemento) {
        NodoAVL aux = new NodoAVL(elemento);
        super.agregaNodo(raiz, aux);
        NodoAVL aux2 = aux;
        while (aux2 != null){
            this.actualizaAltura(aux2);
            aux2 = nodoAVL(aux2.padre);
        }
        aux2 = aux;
        while(aux2 != null){
            if (Math.abs(this.balance(aux2)) == 2){
                this.rebalancea(aux2);
                return;
            }
            aux2 = nodoAVL(aux2.padre);
        }
    }

    /**
     * Elimina un elemento del árbol. El método elimina el nodo que contiene el
     * elemento, y gira el árbol como sea necesario para rebalancearlo. La
     * complejidad en tiempo del método es <i>O</i>(log <i>n</i>) garantizado.
     *
     * @param elemento el elemento a eliminar del árbol.
     */
    @Override
    public void eliminar(T elemento) {
        Nodo aux = super.buscaNodo(raiz, elemento);
        Nodo aux2 = super.eliminaNodo(aux);
        NodoAVL aux3 = nodoAVL(aux2);
        while(aux2 != null){
            this.actualizaAltura(nodoAVL(aux2));
            aux2 = nodoAVL(aux2.padre);
        }
        while(aux3 != null){
            if (Math.abs(this.balance(aux3)) == 2){
                this.rebalancea(aux3);
                return;
            }
            aux3 = nodoAVL(aux3.padre);
        }
    }

    private int getAltura(Nodo nodo) {
        if (nodo == null){
            return 0;
        }
        return nodoAVL(nodo).altura;
    }

    /**
     * Convierte el nodo (visto como instancia de {@link
     * Nodo}) en nodo (visto como instancia de {@link
     * NodoAVL}). Método auxililar para hacer este cast en un único lugar.
     *
     * @param nodo el nodo de árbol binario que queremos como nodo AVL.
     * @return el nodo recibido visto como nodo AVL.
     */
    protected NodoAVL nodoAVL(Nodo nodo) {
        return (NodoAVL) nodo;
    }
}
