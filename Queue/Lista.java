import java.util.Iterator;
import java.util.NoSuchElementException;


public class Lista<T> implements Listable<T> {

    /* Clase interna para construir la estructura */
    protected class Nodo {
        /* Referencias a los nodos anterior y siguiente */
        public Nodo anterior, siguiente;

        /* El elemento que almacena un nodo */
        public T elemento;

        /* Unico constructor de la clase */
        public Nodo(T elemento) {
            this.elemento = elemento;
        }

        public boolean equals(Nodo n) {
            if (n == null) {
                return (false);
            } else {
                if (n.elemento == this.elemento){
                    return (true);
                }
                else {
                    return (false);
                }
            }

        }
    }

    /* Atributos de la lista */
    protected Nodo cabeza, cola;
    protected int longitud;

    /**
     * Constructor por omisión de la clase, no recibe parámetros.
     * Crea una nueva lista con longitud 0.
     **/
    public Lista() {
        this.cabeza = null;
        this.cola = null;
        this.longitud = 0;
    }

    /**
     * Método que nos dice si las lista está vacía.
     *
     * @return <code>true</code> si el conjunto está vacío, <code>false</code>
     * en otro caso.
     */
    @Override
    public boolean esVacia() {
        if (this.cabeza == null) {
            return (true);
        } else {
            return (false);
        }
    }

    /**
     * Método para eliminar todos los elementos de una lista
     */
    @Override
    public void vaciar() {
        this.cabeza = null;
        this.cola = null;
        this.longitud = 0;
    }

    /**
     * Método para obtener el tamaño de la lista
     *
     * @return tamanio Número de elementos de la lista.
     **/
    @Override
    public int getTamanio() {
        return (this.longitud);
    }

    /**
     * Método para obtener el primer elemento.
     */
    @Override
    public T getPrimero() throws NoSuchElementException {
        if (cabeza == null){
            throw new NoSuchElementException();
        } else {
            return (cabeza.elemento);
        }
    }

    /**
     * Método para obtener el último elemento.
     */
    public T getUltimo() throws NoSuchElementException {
        if (cola == null) {
            throw new NoSuchElementException();
        } else {
            return (cola.elemento);
        }
    }

    /**
     * Método para agregar un elemento a la lista.
     *
     * @param elemento Objeto que se agregará a la lista.
     */
    @Override
    public void agregar(T elemento) {
        if (elemento == null){
            throw new IllegalArgumentException();
        } else {
            Nodo nuevo = new Nodo(elemento);
            if (cabeza == null) {
                this.cabeza = nuevo;
                this.cola = nuevo;
            } else {
                this.cabeza.anterior = nuevo;
                nuevo.anterior = null;
                nuevo.siguiente = cabeza;
                this.cabeza = nuevo;
            }
            this.longitud += 1;
        }
    }

    /**
     * Método para agregar al final un elemento a la lista.
     *
     * @param elemento Objeto que se agregará al inicio de la lista.
     */
    public void agregarAlFinal(T elemento) throws IllegalArgumentException {
        if (elemento == null){
            throw new IllegalArgumentException();
        } else {
            Nodo nuevo = new Nodo(elemento);
            if (cabeza == null) {
                this.cabeza = nuevo;
                this.cola = nuevo;
            } else {
                this.cola.siguiente = nuevo;
                nuevo.anterior = cola;
                nuevo.siguiente = null;
                this.cola = nuevo;
            }
            this.longitud += 1;
        }
    }


    /**
     * Constructor copia de la clase. Recibe una lista con elementos.
     * Crea una nueva lista exactamente igual a la que recibimos como parámetro.
     *
     * @param l
     **/
    public Lista(Lista<T> l) {
        for (T elem : l) {
            this.agregarAlFinal(elem);
        }
    }

    /**
     * Método que devuelve una copia exacta de la lista
     *
     * @return la copia de la lista.
     */
    @Override
    public Lista<T> copia() {
        Lista<T> laCopia = new Lista<T>();
        for (T elem : this){
            laCopia.agregarAlFinal(elem);
        }
        return laCopia;
    }

    /**
     * Método que devuelve una copia de la lista, pero en orden inverso
     *
     * @return Una copia con la lista l revés.
     */
    @Override
    public Lista<T> reversa() {
        Lista<T> alreves = new Lista<>();
        for (T elem : this){
            alreves.agregar(elem);
        }
        return (alreves);
    }

    /**
     * Constructor de la clase que recibe parámetros.
     * Crea una nueva lista con los elementos de la estructura iterable que recibe como parámetro.
     *
     * @param iterable
     **/
    public Lista(Iterable<T> iterable) {
        for (T elem : iterable) {
            this.agregar(elem);
        }
    }

    /**
     * Método para eliminar el primer elemento de la lista.
     */
    @Override
    public void eliminarPrimero() throws NoSuchElementException {
        if (longitud == 0){
            throw new NoSuchElementException();
        } else if (longitud == 1){
            this.cabeza = null;
            this.cola = null;
            this.longitud = 0;
        } else {
            this.cabeza = cabeza.siguiente;
            this.cabeza.anterior = null;
            this.longitud -= 1;
        }
    }

    /**
     * Método para eliminar el último elemento de la lista.
     */
    public void eliminarUltimo() throws NoSuchElementException {
        if (longitud == 0) {
            throw new NoSuchElementException();
        } else if (longitud == 1){
            this.cabeza = null;
            this.cola = null;
            this.longitud = 0;
        } else {
            this.cola = cola.anterior;
            this.cola.siguiente = null;
            longitud -= 1;
        }
    }

    /* Método auxiliar para obtener una referencia a un nodo con un elemento
    específico. Si no existe tal nodo, devuelve <code> null </code> */
    private Nodo getNodo(T elem) throws NoSuchElementException {
        if (elem == null){
            throw new NoSuchElementException();
        } else {
            Nodo aux = cabeza;
            while (aux != null){
                if (aux.elemento == elem){
                    return (aux);
                } else {
                    aux = aux.siguiente;
                }
            }
            return (null);
        }
    }

    /**
     * Método para verificar si un elemento pertenece a la lista.
     *
     * @param elemento Objeto que se va a buscar en la lista.
     * @return <code>true</code> si el elemento esta en el lista y false en otro caso.
     */
    @Override
    public boolean contiene(T elemento) throws NoSuchElementException {
        if (elemento == null) {
            throw new NoSuchElementException();
        } else {
            if (getNodo(elemento) == null) {
                return (false);
            } else {
                return (true);
            }
        }
    }

    /**
     * Método para eliminar un elemento de la lista.
     *
     * @param elemento Objeto que se eliminara de la lista.
     *                 todo
     */
    @Override
    public void eliminar(T elemento) throws NoSuchElementException {
        if (getNodo(elemento) == null){
            return;
        }
        if (elemento == null){
            throw new NoSuchElementException();
        } else {
            Nodo aux = getNodo(elemento);
            if (longitud == 0) {
                return;
            } else if (longitud == 1) {
                this.cabeza = null;
                this.cola = null;
                this.longitud = 0;
                return;
            } else {
                if (aux == cabeza){
                    eliminarPrimero();
                    return;
                } else if (aux == cola){
                    eliminarUltimo();
                    return;
                } else {
                    aux.anterior.siguiente = aux.siguiente;
                    aux.siguiente.anterior = aux.anterior;
                }
                this.longitud -= 1;
            }
        }
    }

    /**
     * Método que devuelve la posición en la lista que tiene la primera
     * aparición del <code> elemento</code>.
     *
     * @param elemento El elemnto del cuál queremos saber su posición.
     * @return i la posición del elemento en la lista, -1, si no se encuentra en ésta.
     */
    @Override
    public int indiceDe(T elemento) throws NoSuchElementException {
        if (elemento == null) {
            throw new NoSuchElementException();
        }
        if (getNodo(elemento) == null){
            return (-1);
        } else {
            int aux = 0;
            for (T elemaux : this){
                if (elemaux != elemento){
                    aux += 1;
                } else {
                    return (aux);
                }
            }
            return (aux);
        }
    }

    /**
     * Método que nos devuelve el elemento que esta en la posición i
     *
     * @param i La posición cuyo elemento deseamos conocer.
     * @return <code> elemento </code> El elemento que contiene la lista,
     * <code>null</code> si no se encuentra
     * @throws IndexOutOfBoundsException Si el índice es < 0 o >longitud()
     */
    @Override
    public T getElemento(int i) throws IndexOutOfBoundsException {
        if (i < 0){
            throw new IndexOutOfBoundsException();
        }
        if (i > longitud) {
            throw new IndexOutOfBoundsException();
        } else {
            int aux = 0;
            for(T elem : this){
                if (i != aux){
                    aux += 1;
                } else {
                    return (elem);
                }
            }
        }
        return (null);
    }

    @Override
    public String toString() {
        if (esVacia()) {
            return "[]";
        }
        Nodo nodo = cabeza;
        String cad = "[" + nodo.elemento;
        while (nodo.siguiente != null) {
            nodo = nodo.siguiente;
            cad += ", " + nodo.elemento;
        }
        return cad + "]";
    }

    private class IteradorLista implements Iterator<T> {
        /* La lista a recorrer*/
        /* Elementos del centinela que recorre la lista*/
        private Lista<T>.Nodo siguiente;

        public IteradorLista() {
            this.siguiente = cabeza;
        }

        @Override
        public boolean hasNext() {
            if (this.siguiente == null) {
                return (false);
            } else {
                return (true);
            }
        }

        @Override
        public T next() {
            T aux = this.siguiente.elemento;
            this.siguiente = this.siguiente.siguiente;
            return (aux);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    /**
     * Método que devuelve un iterador sobre la lista
     *
     * @return java.util.Iterador -- iterador sobre la lista
     */
    @Override
    public java.util.Iterator<T> iterator() {
        return new IteradorLista();
    }

    /**
     * Método que nos dice si una lista es igual que otra.
     *
     * @param o objeto a comparar con la lista.
     * @return <code>true</code> si son iguales, <code>false</code> en otro caso.
     */
    @Override
    public boolean equals(Object o) {
        @SuppressWarnings("unchecked") Lista<T> lista = (Lista<T>) o;
        if (o == null){
            return (false);
        }
        Iterator<T> iterador = this.iterator();
        Iterator<T> iteraux = lista.iterator();
        while (iterador.hasNext() && iteraux.hasNext()){
            if (!(iterador.next().equals(iteraux.next()))){
                return (false);
            }
        }
        return (true);
    }





}

