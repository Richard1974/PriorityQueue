/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author Richard Coldwell
 */
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T>{
    
    private ListNode<T> top;
    private Object storage;
    private Object topStorage;
    
    public SortedLinkedPriorityQueue()
    {
        top = null;
    }
    
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            storage = top.getItem();
            return ((PriorityItem<T>) storage).getItem();                   
                      
        }
    }
    
     @Override
    public void add(T item, int priority) throws QueueOverflowException {
       
    ListNode<T> current;  
    
    if (top != null){
         topStorage = top.getItem();
    ((PriorityItem<T>) topStorage).getItem(); 
    System.out.println(((PriorityItem<T>) topStorage).getPriority());
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
        Object currentObject = top.getItem();

        while (current.getNext() != null && ((PriorityItem<T>) currentObject).getPriority() > priority)
        {
            current = current.getNext();
            currentObject = current.getItem();
        }
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
    public boolean isEmpty() {
        return top == null;
    }
    
    @Override
    public String toString() {
        String result = "[";
       for (ListNode<T> node = top; node != null; node = node.getNext()) 
       {
            if (node != top) {
                result = result + ", ";
            }
            result += node.getItem();
            
 
                    
        }
        result = result + "]";
        return result;
    }
    
}
