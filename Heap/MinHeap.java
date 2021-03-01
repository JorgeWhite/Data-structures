/**
 *
 * @author luis
 * @param <T>
 */
public class MinHeap<T extends Comparable<T>> extends Heap<T> {
    
    public MinHeap(){
        super();
    }
    
    public MinHeap(Iterable i){
        super(i);
    }

    @Override
    protected boolean comparador(T elemento1, T elemento2) {
        return elemento1.compareTo(elemento2)<0;
    }
    
}
