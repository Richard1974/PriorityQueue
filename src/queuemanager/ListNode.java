package queuemanager;

/**
 * List Node
 * @author Richard Coldwell
 */
public class ListNode<T> {
    
    private T item ;
    private ListNode<T> next;
    
    public ListNode(T item, ListNode<T> next)
    {
        this.item = item;
        this.next = next;
    }
    
    public T getItem()
    {
        return item;
    }
    
    public ListNode<T> getNext()
    {
        return next;
    }
    public void setNext(ListNode<T> next)
    {
        this.next = next;
    }   
}
