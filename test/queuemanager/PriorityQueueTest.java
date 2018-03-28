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
    
       
    //************************************************************
    //***  BLACK BOX TESTING RELEVANT TO ALL IMPLEMENTATIONS   ***
    //************************************************************
    
    //*******************************************
    //** isEmpty() Tests                       **
    //*******************************************
    
    //** isEmpty() Blackbox Test 01
    //*  Will return True if the queue is Empty
    @Test
    public void bbTestIsEmpty() 
    {
        System.out.println("is the queue empty using isEmpty()");
        boolean expResult = true;
        boolean result = q.isEmpty();
        assertEquals(expResult, result);
    }
    
    //*******************************************
    //** head() Tests                          **
    //******************************************* 
     
    //** head() Blackbox Test 01
    //*  Will throw exception if queue is empty
    @Test(expected = QueueUnderflowException.class) 
    public void bbTestHeadEmpty() throws Exception 
    {
        System.out.println("Find Head when queue is Empty");
        String expResult = "Queue is empty";
        String result = q.head().getName();
        assertEquals(expResult, result);
    }
  
    //** head() Blackbox Test 02
    //** Will display name at head of a queue containing 1 item
    @Test
    public void bbTestHeadOnePerson() throws Exception 
    {
        System.out.println("Find Head when one person in queue");
        Person person = new Person("Richard");
        int priority = 108;        
        q.add(person, priority);
        String expResult = "Richard";
        String result = q.head().getName();
        assertEquals(expResult, result);
    }
    
    //** head() Blackbox Test 03
    //** Will display name at head of a queue containing 2 items
    @Test
    public void bbTestHeadTwoPeople() throws Exception 
    {
        System.out.println("Find Head when two people are in queue");
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
    
    
    //** head() Blackbox Test 04
    //** Will display name at head of a queue containing 7 items
    @Test
    public void bbTestHeadLotsOfPeople() throws Exception {
        System.out.println("Find Head when lots people are in queue");
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
    
    //*******************************************
    //** add() Tests                          **
    //******************************************* 
     
    //** add() Blackbox Test 01
    //*  adds 1 person to an empty queue
    @Test
    public void bbTestAddEmpty() throws Exception 
    {
        System.out.println("add a person to an empty queue");
        Person person = new Person("Richard");
        int priority = 88;        
        q.add(person, priority);
        String expResult = "[(Richard, 88)]";
        String result = q.toString();
        assertEquals(expResult, result);
    }
    
    //*******************************************
    //** remove() Tests                        **
    //******************************************* 
     
    //** remove() Blackbox Test 01
    //*  removes 1 person from a queue of 1
    @Test
    public void bbRemoveFromQueueOfOne() throws Exception 
    {
        System.out.println("remove a person from a queue of 1 person");
        Person person = new Person("Richard");
        int priority = 88;        
        q.add(person, priority);
        q.remove();
        boolean expResult = true;
        boolean result = q.isEmpty();
        assertEquals(expResult, result);
    }
    
     //** remove() Blackbox Test 02
    //*  removes 1 person from an empty queue
    @Test (expected = QueueUnderflowException.class)
    public void bbRemoveFromEmptyQueue() throws Exception 
    {
        System.out.println("remove a person from an empty queue");
        q.remove();
        boolean expResult = true;
        boolean result = q.isEmpty();
        assertEquals(expResult, result);
    }

}
