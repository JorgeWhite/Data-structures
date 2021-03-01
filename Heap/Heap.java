import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Clase abstracta para modelar montículos. Las clases concretas pueden ser un montículo mínimo
 * o máximo.
 */
public abstract class Heap<T extends Comparable<T>> implements Coleccionable<T> {

    /**
     * Clase interna para modelar el iterador
     */
    private class Iterador implements Iterator<T> {

        private int siguiente;

        @Override
        public boolean hasNext() {

            return arreglo[siguiente] != null;
        }

        @Override
        public T next() {
            siguiente = siguiente + 1;
            return arreglo[siguiente - 1];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    /**
     * Arreglo donde se almacenarán los elementos del montículo.
     **/
    private T[] arreglo;
    /**
     * Cantidad de elementos almacenados en el montículo.
     **/
    private int tamanio;
    
    
    /* Truco para crear arreglos genéricos. Es necesario hacerlo así por cómo
       Java implementa sus genéricos; de otra forma obtenemos advertencias del
       compilador. */
    @SuppressWarnings("unchecked") private T[] creaArregloGenerico(int n) {
        return (T[])(new Comparable[n]);
    }

    /**
     * Constructor que no recibe parámetros, crea un arreglo de un tamaño arbitrario.
     * Se recomienda que sea de un tamaño que sea una potencia de 2.
     **/
    public Heap() {
        this.arreglo = creaArregloGenerico(2 * 2 * 2 * 2 * 2);
        this.tamanio = 0;
    }

    /**
     * Constructor que recibe una estructura iterable como parámetro.
     * Agrega todos los elementos en el orden en que se recorre la estructura dada.
     **/
    public Heap(Iterable<T> it) {
        this.tamanio = 0;
        this.arreglo = creaArregloGenerico(2 * 2 * 2 * 2 * 2);
        for (T elem : it){
            agregar(elem);
        }
    }
    
    /**
     * Método abstracto que se va a usar para comparar dos elementos del heap.
     * Se deja la implementación a las clases concretas, pues dependiendo de éstas el orden es
     * uno o el inverso, según sea el caso.
     * @param elemento1
     * @param elemento2
     * @return true si elemento1 tiene mayor prioridad que elemento2, false en otro caso
     */
    abstract protected boolean comparador(T elemento1,T elemento2);


    /**
     * Método que nos da la posición del padre del índice dado
     **/
    private int padre(int indiceElemento) {
        return (indiceElemento - 1)/2;
    }

    /**
     * Método que nos da la posición del hijo izquierdo del índice dado
     **/
    private int izquierdo(int indiceElemento) {
        return (2*indiceElemento) + 1;
    }

    /**
     * Método que nos da la posición del hijo derecho del índice dado
     **/
    private int derecho(int indiceElemento) {
        return (2*indiceElemento) + 2;
    }

    @Override
    public void agregar(T elemento) {
        if (tamanio == arreglo.length){
            T[] arreglo_aux = creaArregloGenerico(2 * tamanio);
            for (int i = 0; i < arreglo.length; i++){
                arreglo_aux[i] = arreglo[i];
            }
            this.arreglo = arreglo_aux;
        }
        if (tamanio == 0){
            this.arreglo[0] = elemento;
            this.tamanio = 1;
            return;
        }
        if (tamanio < arreglo.length){
            this.arreglo[tamanio] = elemento;
            this.tamanio += 1;
            rebalanceaHaciaArriba(tamanio - 1);
        }
    }
    
    /**
     * Metodo para eliminar el elemento que se encuentra en el tope del heap.
     * El método devuelve el valor eliminado.
     */
    public T eliminarTope() {
        T aux = arreglo[0];
        intercambia(0, tamanio - 1);
        this.arreglo[tamanio -1] = null;
        this.tamanio -= 1;
        rebalanceaHaciaAbajo(0);
        return aux;
    }

    /**
     * Método para intercambiar dos elementos en los índices i y j.
     * Antes de usarse debemos asegurarnos de que los índices sean válidos.
     **/
    private void intercambia(int i, int j) {
        if (i >= tamanio || j >= tamanio ){
            throw new NoSuchElementException();
        }
        T aux = arreglo[i];
        this.arreglo[i] = this.arreglo[j];
        this.arreglo[j] = aux;
    }

    /**
     * Metodo que se encarga de hacer el rebalanceo cuando agregamos un elemento.
     * @param indiceElemento
     */
    private void rebalanceaHaciaArriba(int indiceElemento) {
        while(indiceElemento >= 0){
            if (comparador(arreglo[indiceElemento], arreglo[padre(indiceElemento)])){
                intercambia(indiceElemento, padre(indiceElemento));
                indiceElemento = padre(indiceElemento);
            } else {
                return;
            }
        }
    }

    /**
     * Metodo que se encarga de hacer el rebalanceo cuando eliminamos un elemento.
     * @param indiceElemento
     */
    private void rebalanceaHaciaAbajo(int indiceElemento) {
        while (indiceItercambiable(izquierdo(indiceElemento), derecho(indiceElemento)) != -1){
            if (!comparador(arreglo[indiceElemento], arreglo[indiceItercambiable(izquierdo(indiceElemento), derecho(indiceElemento))])){
                indiceElemento = indiceItercambiable(izquierdo(indiceElemento), derecho(indiceElemento));
                intercambia(indiceElemento, padre(indiceElemento));
            } else {
                   return;
            }
        }
    }

    /**
     * Método que nos dice cuál es el índice del elemento que tenemos que intercambiar con el padre.
     * Se utiliza en rebalanceaHaciaAbajo.
     * Si no hay que hacer intercambios porque ya no hay hijos, debe devolver -1.
     **/
    private int indiceItercambiable( int i, int j) {
        if (i >= tamanio && j < tamanio){
            return j;
        } else if (i < tamanio && j >= tamanio){
            return i;
        }
        if (i >= tamanio && j >= tamanio){
            return -1;
        }
        if (comparador(arreglo[i], arreglo[j])){
            return i;
        } else {
            return j;
        }
    }

    /**
     * Metodo para obtener el elemento que se encuentra en el tope del heap
     * @return
     * @throws NoSuchElementException
     */
    public T obtenerPrioritario() throws NoSuchElementException{
        if (esVacia()){
            throw new NoSuchElementException();
        } else {
            return this.arreglo[0];
        }
    }

    @Override
    public void eliminar(T elemento) throws NoSuchElementException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean contiene(T elemento) {
        for (int i = 0; i < tamanio; i++){
            if (arreglo[i].equals(elemento)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean esVacia() {
        return tamanio == 0;
    }

    @Override
    public int getTamanio() {
        return tamanio;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterador();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        @SuppressWarnings("unchecked")
        Heap<T> heap = (Heap<T>) o;
        if (tamanio != heap.tamanio){
            return false;
        }
        int aux = 0;
        for (int i = 0; i < tamanio; i++){
            if (arreglo[i].compareTo(heap.arreglo[i]) == 0){
                aux += 1;
            }
        }
        if (aux == tamanio){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (esVacia()) {
            return "[]";
        }
        String s = "[";
        for (int i = 0; i < tamanio - 1; i++) {
            s += arreglo[i] + ", ";
        }
        s += arreglo[tamanio-1] + "]";

        return s;
    }

}
