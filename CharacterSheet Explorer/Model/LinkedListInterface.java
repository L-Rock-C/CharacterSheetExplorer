package Model;

public interface LinkedListInterface<E> 
{
    void addFirst(E value);
    void addLast(E value);
    boolean addAfter(E index, E value);
    
    E peekFirst();
    E peekLast();
    
    E search(E index);
    
    E removeFirst();
    E removeLast();
    E remove(E crit); 
    
	void show();
}
