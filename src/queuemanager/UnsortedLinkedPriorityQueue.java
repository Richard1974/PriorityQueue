package queuemanager;

/**
 * Unsorted Linked Priority Queue
 * @author Richard Coldwell
 */
public class UnsortedLinkedPriorityQueue<T> implements PriorityQueue<T> 
{
    
    private ListNode<T> top;
    private Object storage;
   
    
    ListNode<T> current; 
    private Object currentStorage;
    ListNode<T> previous; 
    
    ListNode<T> highestNode;
    private Object highestStorage;
    ListNode<T>highestPreviousNode;
    
    public UnsortedLinkedPriorityQueue()
    {
        top = null;
    }
    
    @Override
    public T head() throws QueueUnderflowException 
    {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else 
        {                   
            highestNode = top;
            current = top.getNext();
            highestStorage = highestNode.getItem();
            if (current == null)
            {
                System.out.println("current is null and highest is therefore top item" + highestNode + " " +current);
            }
            else
            {
                while (current != null)
                {
                    currentStorage = current.getItem();
                    if (((PriorityItem<T>) highestStorage).getPriority() < ((PriorityItem<T>) currentStorage).getPriority())
                    {
                        highestPreviousNode = previous;
                        highestNode = current;
                        highestStorage = highestNode.getItem();
                    }
                    previous = current;
                    current = current.getNext();
                }
            }        
        }
        storage = highestNode.getItem();
            return ((PriorityItem<T>) storage).getItem();
    }
    
    @Override
    public void add(T item, int priority) throws QueueOverflowException 
    {
        storage = new PriorityItem<>(item, priority);
        top = new ListNode<T> ((T) storage, top);
    }
    
    @Override
    public void remove() throws QueueUnderflowException 
    {
        if (isEmpty()) 
        {
            throw new QueueUnderflowException();
        } 
        else 
        {
            highestNode = top;
            current = highestNode.getNext();
            highestPreviousNode  = null;
            previous = top;
            highestStorage = highestNode.getItem();
            if (current == null)
            {
                top = null;
            }
            else
            {
                while (current != null)
                {
                    currentStorage = current.getItem();
                     
                    if (((PriorityItem<T>) highestStorage).getPriority() < ((PriorityItem<T>) currentStorage).getPriority())
                    {
                        highestPreviousNode = previous;
                        highestNode = current;
                        highestStorage = highestNode.getItem();
                    } 
                    previous = current;
                    current = current.getNext();
                }
                if (highestPreviousNode != null)
                {
                highestPreviousNode.setNext(highestNode.getNext());
                }
                else
                {
                   top = highestNode.getNext();
                }
            }      
        }
    }
    
    @Override
    public boolean isEmpty() 
    {
        return top == null;
    }
    
    @Override
    public String toString() {
        String result = "[";
        for (ListNode<T> node = top; node != null; node = node.getNext()) 
        {
            if (node != top) 
            {
                result = result + ", ";
            }
            result += node.getItem();
        }
        result = result + "]";
        return result;
    }
}
