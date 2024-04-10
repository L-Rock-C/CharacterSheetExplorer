package Model;

public interface QueueInterface<T> 
{
    void add(T value);
    T remove();

    T peek();

    boolean isEmpty();
        
}
