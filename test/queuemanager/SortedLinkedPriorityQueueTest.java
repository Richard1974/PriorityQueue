package queuemanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Sorted Linked Testing
 * @author Richard Coldwell
 */
public class SortedLinkedPriorityQueueTest extends PriorityQueueTest{
    
    public SortedLinkedPriorityQueueTest() {
    }
    
    @Before
    @Override
    public void setUp() {
        q = new SortedLinkedPriorityQueue<>();
    }
    
      /**
//     * Test of add method, of class PriorityQueue.
//     * Add an item to the end of a sorted array
//     */
    @Test
    public void testAddEndSorted() throws Exception {
        System.out.println("add a person to the end of a sorted queue using .add(person, priority)");
        Person person = new Person("Richard");
        int priority = 20;        
        q.add(person, priority);
        person = new Person("James");
        priority = 11;        
        q.add(person, priority);
        
        String expResult = "[(Richard, 20), (James, 11)]";
        String result = q.toString();
        assertEquals(expResult, result);
        System.out.println(q.toString());
        
    }
    
}