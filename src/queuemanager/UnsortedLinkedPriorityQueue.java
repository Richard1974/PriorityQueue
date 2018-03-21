/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author coldw
 */
public class UnsortedLinkedPriorityQueue<T> implements PriorityQueue<T> {
    
private ListNode<T> top;
    private Object storage;
    private Object topStorage;
    
    ListNode<T> current; 
    private Object currentStorage;
    ListNode<T> previous; 
    private Object previousStorage;
    ListNode<T> newNode;
    
    public UnsortedLinkedPriorityQueue()
    {
        top = null;
    }
    
    @Override
    public T head() throws QueueUnderflowException 
    {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            storage = top.getItem();
            return ((PriorityItem<T>) storage).getItem();                   
                      
        }
    }
    
     @Override
    public void add(T item, int priority) throws QueueOverflowException 
    {
        storage = new PriorityItem<>(item, priority);
        top = new ListNode<T> ((T) storage, top);
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
