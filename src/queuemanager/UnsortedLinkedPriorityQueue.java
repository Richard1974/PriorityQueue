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
            //storage = top.getItem();
            //return ((PriorityItem<T>) storage).getItem();                   
            highestNode = top;
            current = top.getNext();
            
            //currentStorage = current.getItem();
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
                
            /*highestNode = top;
            highestStorage = top.getItem();
            current = top.getNext();
            currentStorage = current.getItem();
            //previous = top;
            System.out.println("Before WHile Loop current priority" + ((PriorityItem<T>) currentStorage).getPriority() );
            System.out.println("Before While Loop highest priority" + ((PriorityItem<T>) highestStorage).getPriority() );
            while (current != null)
            {
                if (((PriorityItem<T>) currentStorage).getPriority()  > ((PriorityItem<T>) highestStorage).getPriority())
                {
                    highestPreviousNode = previous;
                    highestNode = current;
                    //highestStorage = highestNode.getItem();
                }
                previous = current;
                current = current.getNext();
                System.out.println("current priority" + ((PriorityItem<T>) currentStorage).getPriority() );
                System.out.println("highest priority" + ((PriorityItem<T>) highestStorage).getPriority() );
                 
            }*/
           // highestStorage = top.getItem();
           // System.out.println("Highest priority value is " + ((PriorityItem<T>) highestStorage).getPriority());
           // highestPreviousNode.setNext(current.getNext());
            
                       
        
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
