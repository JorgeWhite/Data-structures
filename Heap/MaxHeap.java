/**
 *
 * @author luis
 * @param <T>
 */
public class MaxHeap<T extends Comparable<T>> extends Heap<T> {

    public MaxHeap(){
        super();
    }
    
    public MaxHeap(Iterable i){
        super(i);
    }

    @Override
    protected boolean comparador(T elemento1, T elemento2) {
        return elemento2.compareTo(elemento1)<0; 
    }
    
}
