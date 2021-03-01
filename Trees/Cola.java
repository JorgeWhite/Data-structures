import java.util.NoSuchElementException;

/**
 * <p> Clase concreta para modelar la estructura de datos Cola</p>
 * <p>Esta clase implementa una Cola genérica, es decir que es homogénea pero
 * puede tener elementos de cualquier tipo.
 * @author Luis Manuel Martinez Damaso <luismanuel@ciencias.unam.mx>
 * @version 1.0
 * @param <T> Tipo que tienen los objetos que guarda esta cola.
 */
public class Cola<T> extends Lista<T> implements Encolable<T> {


    /**
     * Constructor por omisión de la clase.
     */
    public Cola() {
        //Aqui no hay que hacer nada,
        //ya que los valores por default nos sirven al crear un objeto.
    }

    /**
     * Constructor de la clase que recibe parámetros.
     * Crea una nueva cola con los elementos de la estructura iterable que recibe como parámetro.
     * @param iterable El objeto que se recibe como parámetro.
     */
    public Cola(Iterable<T> iterable) {
        for (T elem : iterable){
            this.queue(elem);
        }
    }

    /**
     * Constructor de la clase que recibe parámetros.
     * Crea una nueva cola con los elementos de la estructura iterable que recibe como parámetro.
     */
    public Cola(Cola<T> c) {
        Cola<T> auxiliar = new Cola<T>();
        for (T elem : c){
            auxiliar.queue(elem);
        }
        for (T elemento : auxiliar){
            this.queue(elemento);
        }
    }



    /**
     * Agrega un elemento en el rabo de la Cola.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     * <code>null</code>.
     */
    @Override
    public void queue(T elemento) throws IllegalArgumentException{
        if(elemento == null){
            throw new IllegalArgumentException();
        }
        Nodo aux = new Nodo(elemento);
        if (longitud == 0){
            this.cabeza = aux;
            this.cola = aux;
            this.cabeza.anterior = null;
            longitud += 1;
            return;
        }
        aux.siguiente = cabeza;
        aux.anterior = null;
        cabeza.anterior = aux;
        this.cabeza = aux;
        this.longitud += 1;
    }

    /**
     * Elimina el elemento del inicio de la Cola y lo regresa.
     * @throws NoSuchElementException si la cola es vacía
     * @return el elemento en el inicio de la Cola.
     */
    @Override
    public T dequeue() throws NoSuchElementException{
        if (longitud == 0){
            throw new NoSuchElementException();
        }
        T aux = cola.elemento;
        if (longitud == 1){
            this.cabeza = null;
            this.longitud = 0;
            return (aux);
        } else {
            this.cola = cola.anterior;
            this.cola.siguiente = null;
            this.longitud -= 1;
            return (aux);
        }
    }


    /**
     * Nos permite ver el elemento en el inicio de la Cola
     *
     * @return el siguiente elemento a desencolar.
     */
    @Override
    public T peek() throws NoSuchElementException{
        return (cola.elemento);
    }

    /**
     * Método para agregar un elemento a la Cola.
     * @param elemento Objeto que se agregará a la Cola.
     */
    @Override
    public void agregar(T elemento){
        throw new UnsupportedOperationException("No se puede hacer esta operación. Para agregar elementos a una cola usa el método queue(elemento)");
    }

    /**
     * Método para agregar al final un elemento a la Cola. Este método
     * no debería ser llamado. Por eso va a devolver una excepción.
     * @param elemento Objeto que se agregará al inicio de la Cola.
     */
    @Override
    public void agregarAlFinal(T elemento) {
        throw new UnsupportedOperationException("No se puede hacer esta operación. Para agregar elementos a una cola usa el método queue(elemento)");
    }

    /**
     * Método para obtener el primer elemento. Este método
     * no debería ser llamado. Por eso va a devolver una excepción.
     * @return
     */
    @Override
    public T getPrimero() {
        throw new UnsupportedOperationException();
    }

    /**
     * Método para obtener el último elemento. Este método
     * no debería ser llamado. Por eso va a devolver una excepción.
     * @return
     */
    @Override
    public T getUltimo() {
        throw new UnsupportedOperationException();
    }


    /**
     * Método para eliminar especifico de la Cola. Este método
     * no debería ser llamado. Por eso va a devolver una excepción.
     * @param elemento Objeto que se eliminara de la Cola.
     * todo
     */
    @Override
    public void eliminar(T elemento) {
        throw new UnsupportedOperationException("No se puede hacer esta operación. Para agregar elementos a una cola usa el método dequeue()");
    }

    /**
     * Método para eliminar el primer elemento de la Cola. Este método
     * no debería ser llamado. Por eso va a devolver una excepción.
     */
    @Override
    public void eliminarPrimero() {
        throw new UnsupportedOperationException("No se puede hacer esta operación. Para agregar elementos a una cola usa el método dequeue()");
    }

    /**
     * Método para eliminar el primer elemento de la Cola. Este método
     * no debería ser llamado. Por eso va a devolver una excepción.
     */
    @Override
    public void eliminarUltimo() {
        throw new UnsupportedOperationException("No se puede hacer esta operación. Para agregar elementos a una cola usa el método dequeue()");
    }


    @Override
    public String toString() {
        String s = "[";
        Nodo n = this.cabeza;
        while (n != null) {
            if (n.siguiente == null) {
                s += n.elemento;
            } else {
                s += n.elemento + ",";
            }
            n = n.siguiente;
        }
        s += "]";
        return s;

    }

}

