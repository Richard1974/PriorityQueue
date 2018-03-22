package queuemanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Priority Queue Testing
 * @author Richard Coldwell
 */
public abstract class PriorityQueueTest {
    
    public PriorityQueue<Person> q; 
    
    public PriorityQueueTest() {
    }
    
    
    @Before
    public abstract void setUp();
    
    
    
    /**
     * Test of isEmpty method, of class PriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("is the queue empty using isEmpty()");
        boolean expResult = true;
        boolean result = q.isEmpty();
        assertEquals(expResult, result);
        
    }
    
       /**
//     * Test of add method, of class PriorityQueue.
//     * Add an item to an empty queue
//     */
    @Test
    public void testAddEmpty() throws Exception {
        System.out.println("add a person to an empty queue using .add(person, priority)");
        Person person = new Person("Richard");
        int priority = 11;        
        q.add(person, priority);
        
        String expResult = "[(Richard, 11)]";
        String result = q.toString();
        assertEquals(expResult, result);
        
    }
 
    
  
     /**
//     * Test of head method, of class PriorityQueue.
//     */
    @Test
    public void testHeadOnePerson() throws Exception {
        
        System.out.println("Find Head when one person in queue using .head().getName()");
        Person person = new Person("Richard");
        int priority = 108;        
        q.add(person, priority);
        String expResult = "Richard";
        String result = q.head().getName();
        assertEquals(expResult, result);
    }
        /**
//     * Test of head method, of class PriorityQueue.
//     */
    @Test
    public void testHeadTwoPeople() throws Exception {
        System.out.println("Find Head when two people are in queue using .head().getName()");
        Person person = new Person("Richard");
        int priority = 11;        
        q.add(person, priority);
        person = new Person("James");
        priority = 12;
        q.add(person, priority);
        String expResult = "James";
        String result = q.head().getName();
        assertEquals(expResult, result);
    }
    
    
       /**
//     * Test of head method, of class PriorityQueue.
//     */
    @Test
    public void testHeadLotsOfPeople() throws Exception {
        System.out.println("Find Head when lots people are in queue using .head().getName()");
        Person person = new Person("Richard");
        int priority = 11;        
        q.add(person, priority);
        person = new Person("James");
        priority = 12;
        q.add(person, priority);
        person = new Person("Gemma");
        priority = 77;
        q.add(person, priority);
        person = new Person("Natasha");
        priority = 45;
        q.add(person, priority);
        person = new Person("Ann");
        priority = 5;
        q.add(person, priority);
        person = new Person("Malcolm");
        priority = 34;
        q.add(person, priority);
        String expResult = "Gemma";
        String result = q.head().getName();
        assertEquals(expResult, result);
    }
    


//
//    /**
//     * Test of remove method, of class PriorityQueue.
//     */
//    @Test
//    public void testRemove() throws Exception {
//        System.out.println("remove");
//        PriorityQueue instance = new PriorityQueueImpl();
//        instance.remove();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    
//
//    /**
//     * Test of toString method, of class PriorityQueue.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        PriorityQueue instance = new PriorityQueueImpl();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    public class PriorityQueueImpl implements PriorityQueue {
//
//        public void add(T item, int priority) throws QueueOverflowException {
//        }
//
//        public T head() throws QueueUnderflowException {
//            return null;
//        }
//
//        public void remove() throws QueueUnderflowException {
//        }
//
//        public boolean isEmpty() {
//            return false;
//        }
//
//        public String toString() {
//            return "";
//        }
//    }
    
}
