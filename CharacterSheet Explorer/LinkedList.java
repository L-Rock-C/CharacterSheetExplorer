package Model;

public class LinkedList<E> extends Queue<E> implements LinkedListInterface<E>
{
    public E getData(QueueNode node)
    {
        E returnData = null;

        return returnData;
    }

    @Override
    public void addFirst(E value) 
    {
        if(isEmpty())
        {
            add(value);
        }
        else
        {
            QueueNode node = new QueueNode(value);
            
            node.next = getHead();
            setHead(node);
        }

        setSize(getSize() + 1);
    }
    
    @Override
    public void addLast(E value) 
    {
        add(value);
        setSize(getSize() + 1);
    }

    @Override
    public boolean addAfter(E index, E value) 
    {
        QueueNode p = searchNode(index);

	    if( p == null )	{    // Verifica se o criterio existe
	        return false;
	    }
	    else
	    {
	        // Novo elemento 
	        QueueNode novo = new QueueNode(value);

	        // Atualiza tail quando o elemento critério é o último
	        if(p.next == null) {
	        	setTail(novo);;
	        }
	        
	    	// Anexa (dicas: comece atribuindo os campos null)
	        novo.next = p.next;
		    p.next = novo;
		    
		    setSize(getSize() + 1);

		    return true;
	    }
    }

    @Override
    public E peekFirst() 
    {
        E returnData = peek();

        return returnData;
    }

    @Override
    public E peekLast() 
    {
        if (getTail() == null) {
            return null;
        }
        else {
            return getTail().data;
        }
    }

    public QueueNode searchNode(E index)
    {
        QueueNode p = getHead();		// ponteiro temporario

	    while( p != null )
	    {
	        if( p.data.equals(index) ) {
	            return p;
	        }
	        p = p.next;
	    }
	    
	    return null;
    }

    @Override
    public E search(E index) 
    {
        QueueNode p = searchNode(index);
		
		if(p == null) {
			return null;
		} else {
			return p.data;
		}
    }

    @Override
    public E removeFirst() {
        QueueNode p = getHead();
		E dadoRetorno = null;

		if( getHead() == null ) {
	    }
		else
		{
			dadoRetorno = getHead().data;
			
			if (getHead() == getTail()) 
			{
                setHead(null);;
                setTail(null);;
            } 
			else {
                setHead(getHead().next);
			}
			
			p.next = null; // isola elemento removido
			
			setSize(getSize() + 1);
		}

		return dadoRetorno;
    }

    @Override
    public E removeLast() {
        E dadoRetorno = null;

        if (getTail() == null) {
        	System.out.println("Lista Vazia!!! \n");
            return null;
        }
        else 
        {
            dadoRetorno = getTail().data;
            
            if (getHead() == getTail()) 
            {
            	setHead(null);;
            	setTail(null);;
            } 
            else 
            {
        		QueueNode p = getHead();
                while (p.next != getTail()) {
                	p = p.next;
                }
                                
                setTail(p);;
                getTail().next = null;
            }
            
            setSize(getSize() - 1);;
        }

        return dadoRetorno;
    }

    private QueueNode searchBefore(E index)
	{
	    QueueNode p = getHead();
		QueueNode anterior = null;

	    while (p != null)
	    {
	    	anterior = p;
	        p = p.next;
	        
	        if (p != null && p.data.equals(index) ) {
	           return anterior;
	        }
	    }
	    
	    return null;
	}

    @Override
    public E remove(E index) {
        QueueNode anterior = null;
		QueueNode removido = null;

		if( getHead() == null ) {
	        return null;
	    }

		anterior = searchBefore(index);

		if( anterior == null ) 
		{
			if( getHead().data.equals(index) == false )
			{
		        return null;
			}
			else
			{
				return removeFirst();
			}
		}
		else
		{	
			removido = anterior.next;

			if(removido == getTail()) {
				return removeLast();
			}
			else {
				anterior.next = removido.next;
		        removido.next = null;
		        setSize(getSize() - 1);;
		        
				return removido.data;
			}
		}

    }

    @Override 
    public void show()
    {
        QueueNode p = getHead();

		if(p == null) {
			System.out.println("LISTA VAZIA \n");
		}
		else 
	    {
	        while( p != null )
	        {
	            System.out.println("Data: " + p.data );
	            p = p.next;
	        }
	    }
		
		System.out.println("Size = " + getSize() + "\n");
    }

    public LinkedList<E> getLinkedList()
    {
        QueueNode p = getHead();
        LinkedList<E> linkedList = new LinkedList<>();

        if(isEmpty())
        {
            System.out.println("Lista vazia");
        }
        else
        {
            while(p != null)
            {
                linkedList.add(p.data);
                p = p.next;
            }
        }

        return linkedList;
    }   
}