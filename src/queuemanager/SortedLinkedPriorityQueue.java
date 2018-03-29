package queuemanager;

/**
 * Sorted Linked Priority Queue
 * @author Richard Coldwell
 */
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T>{
    
    private ListNode<T> top;
    private Object storage;
    private Object topStorage;
    
    ListNode<T> current; 
    private Object currentStorage;
    ListNode<T> previous; 
    ListNode<T> newNode;
    
    public SortedLinkedPriorityQueue()
    {
        top = null;
    }
    
    //returns item at the top of the queue
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            storage = top.getItem();
            return ((PriorityItem<T>) storage).getItem();   
        }
    }
    
    // adds item to queue in th ecorrect position
    @Override
    public void add(T item, int priority) throws QueueOverflowException 
    {
        current = null;
        //if top is not null get a reference to it
        if (top != null)
        {
            topStorage = top.getItem();
            ((PriorityItem<T>) topStorage).getItem(); 
        }

        // if the top item is null or the new item has a higher priority than the 
        // current top item place new item at top
        if (top == null || ((PriorityItem<T>) topStorage).getPriority() < priority)
        {  
            storage = new PriorityItem<>(item, priority);
            top = new ListNode<T> ((T) storage, top);
        }  
        else
        {
            current = top;
            currentStorage = top.getItem();

            while (current != null)
            {
                currentStorage = current.getItem();
                if (((PriorityItem<T>) currentStorage).getPriority() < priority) break;
                previous = current;
                current = current.getNext();
            }
            storage = new PriorityItem<>(item, priority);
            newNode = new ListNode<T> ((T) storage, current);
            previous.setNext (newNode);
        }
    }  
    
    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            top = top.getNext();
        }
    }
    
    @Override
    public boolean isEmpty() 
    {
        return top == null;
    }
    
    @Override
    public String toString() 
    {
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
