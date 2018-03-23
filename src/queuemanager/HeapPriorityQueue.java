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
public class HeapPriorityQueue<T> implements PriorityQueue<T> {
    
    /**
     * Where the data is actually stored.
     */
    private  Object[] heap;

    /**
     * The size of the storage array.
     */
    private int size;
    
    

    /**
     * Create a new empty queue of the given size.
     *
     * @param capacity
     */
    public HeapPriorityQueue(int capacity) 
    {
        heap = new Object[capacity];
    }

    

   @Override
    public void add(T item, int priority) throws QueueOverflowException 
    {
        if (isFull())
        {
            throw new QueueOverflowException();
        }
        heap[size] = new PriorityItem<>(item, priority);
        fixHeapAbove(size);
        size++;
    }
    
    private void fixHeapAbove(int index)
    {   
        Object newObject = ((PriorityItem<T>) heap[index]);
        int newValue = ((PriorityItem<T>) heap[index]).getPriority();
        while (index > 0 && newValue > ((PriorityItem<T>) heap[getParent(index)]).getPriority())
        {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newObject;
    }

    

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == heap.length;
        
    }
    
    
    public int getParent(int index)
    {
        return (index  - 1) / 2;
    }
//*****************************************************
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return null;
        }
    }
    
    @Override
    public void remove() throws QueueUnderflowException {
        
    
    }
    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + heap[i];
        }
        result = result + "]";
        return result;
    }
}
