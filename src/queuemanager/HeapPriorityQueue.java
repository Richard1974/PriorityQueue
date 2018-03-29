/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 * Heap Priority Queue 
 * @author Richard Coldwell
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
        size = 0;
        heap = new Object[capacity];
    }

    
    // Adds and item to the heap if heap array is full throws exception
    @Override
    public void add(T item, int priority) throws QueueOverflowException 
    {
        if (isFull())
        {
            throw new QueueOverflowException();
        }
        heap[size] = new PriorityItem<>(item, priority);
        fixHeapSortUp(size);//called to sort the heap after adding new item
        size++;
    }
    
    
    //removes item at top of heap if heap empty throws exception
    @Override
    public void remove() throws QueueUnderflowException 
    {
        if (isEmpty()) 
        {
            throw new QueueUnderflowException();
        } 
        else 
        {
            heap[0] = heap[size-1];//moves last item to top of heap 
            fixHeapSortDown(0, size-1);//called to sort heap starting at the top
            size--;// reduce size of heap by 1 now item has been removed
        }
    }
    
    //used to sort heap after item has been added to queue
    private void fixHeapSortUp(int index)
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
    
    //used to sort heap after item has been deleted from top of heap
    private void fixHeapSortDown(int index, int lastHeapIndex)
    {  
        int childToSwap;
        while (index <= lastHeapIndex)
        {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            
            if (leftChild <= lastHeapIndex)
            {
                if (rightChild > lastHeapIndex)//if no right child need to swap left child
                {
                    childToSwap = leftChild;
                    
                }
                else //check which child is highest priority value if there are 2 children
                {
                    childToSwap = (((PriorityItem<T>) heap[leftChild]).getPriority() > ((PriorityItem<T>) heap[rightChild]).getPriority() ? leftChild : rightChild);
                    
                }
                //swaps the objects if the child has a higher priority than the parent
                if (((PriorityItem<T>) heap[index]).getPriority() < ((PriorityItem<T>) heap[childToSwap]).getPriority())
                {
                    Object tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                }
                else
                {
                    break;
                }
                index = childToSwap;
            }
            else
            {
                break;
            }
        }
    }

    // called to check if empty
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    //called to check if full
    public boolean isFull() 
    {
        return size == heap.length;
    }
    
    //gets the parent of the object
    public int getParent(int index)
    {
        return (index  - 1) / 2;
    }
    
    //gets the child and whether it is left child or not 
    public int getChild(int index, boolean left)
    {
        return 2 * index + (left? 1 : 2);
    }

    //returns item at top of queue
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return ((PriorityItem<T>) heap[0]).getItem();
        }
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
