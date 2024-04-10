package Model;

public class Queue<T> implements QueueInterface<T> 
{
	public class QueueNode
	{
        public T data;    
        public QueueNode next;    
                
        public QueueNode(T data) 
        {        	
            this.data = data;    
            this.next = null;
        }   

        
    }

    private QueueNode head;
    private QueueNode tail;
    private long size;

    public Queue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

    @Override
    public void add(T value)
    {
        QueueNode node = new QueueNode(value);

        if(isEmpty())
        {
            head = node;
            tail = node;
        }
        else
        {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    @Override
    public T remove()
    {
        QueueNode node = head;

        T returnData = null;

        if(!isEmpty())
        {
            returnData = head.data;
            if(head == tail)
            {
                head = null;
                tail = null;
            }
            else
            {
                node.next = null;

                size--;
            }
        }
        else
        {
            System.out.println("Lista vazia");
        }
        return returnData;
    }

    @Override
    public T peek()
    {
        if (!isEmpty())
        {
            System.out.println("Lista vazia");
            return null;
        }

        return head.data;
    }

    @Override
    public boolean isEmpty()
    {
        return (head == null);
    }

    public QueueNode getHead() {
        return head;
    }

    public void setHead(QueueNode head) {
        this.head = head;
    }

    public QueueNode getTail() {
        return tail;
    }

    public void setTail(QueueNode tail) {
        this.tail = tail;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
