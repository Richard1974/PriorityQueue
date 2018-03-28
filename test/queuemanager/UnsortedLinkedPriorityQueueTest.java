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
public class UnsortedLinkedPriorityQueueTest extends PriorityQueueTest{
    
    public UnsortedLinkedPriorityQueueTest() {
    }
    
    @Before
    @Override
    public void setUp() {
        q = new UnsortedLinkedPriorityQueue<>();
    }
    
     //************************************************************
    //***  WHITE BOX TESTING RELEVANT TO THIS IMPLEMENTATION   ***
    //************************************************************
    
    //*******************************************
    //** add() Tests                       **
    //*******************************************
    
    //** add() WhiteBox Test 01
    //** add 2 people to queue highest rank first and check order in queue
    @Test
    public void wbTestAddHighestFirst() throws Exception 
    {
        System.out.println("add 2 people to queue highest first");
        Person person = new Person("Richard");
        int priority = 10;        
        q.add(person, priority);
        person = new Person("James");
        priority = 5;        
        q.add(person, priority);
        String expResult = "[(James, 5), (Richard, 10)]";
        String result = q.toString();
        assertEquals(expResult, result);
    }
    
    //** add() WhiteBox Test 02
    //** add 2 people to queue lowest rank first and check order in queue
    @Test
    public void wbTestAddHighestSecond() throws Exception 
    {
        System.out.println("add 2 people to queue highest first");
        Person person = new Person("Richard");
        int priority = 38;        
        q.add(person, priority);
        person = new Person("James");
        priority = 105;        
        q.add(person, priority);
        String expResult = "[(James, 105), (Richard, 38)]";
        String result = q.toString();
        assertEquals(expResult, result);
    }
    
    //** add() WhiteBox Test 03
    //** add 5 people to queue in mixed order of priority and check they are ordered correctly
    @Test
    public void wbTestAddMixedOrder() throws Exception 
    {
        System.out.println("add 5 people to queue mixed order");
        Person person = new Person("Richard");
        int priority = 38;        
        q.add(person, priority);
        person = new Person("James");
        priority = 105;        
        q.add(person, priority);
        person = new Person("Gemma");
        priority = 49; 
        q.add(person, priority);
        person = new Person("Natahsa");
        priority = 106; 
        q.add(person, priority);
        person = new Person("Ann");
        priority = 25; 
        q.add(person, priority);
        String expResult = "[(Ann, 25), (Natahsa, 106), (Gemma, 49), (James, 105), (Richard, 38)]";
        String result = q.toString();
        assertEquals(expResult, result);
    }
   
    
    //*******************************************
    //** remove() Tests                        **
    //******************************************* 
    
     //** remove() WhiteBox Test 01
    //*  removes 1 person from a queue of 2
    @Test
    public void wbRemoveFromQueueOfTwo() throws Exception 
    {
        System.out.println("remove a person from a queue of 2 people");
        Person person = new Person("Richard");
        int priority = 38;        
        q.add(person, priority);
        person = new Person("James");
        priority = 105;        
        q.add(person, priority);
        q.remove();
        String expResult = "[(Richard, 38)]";
        String result = q.toString();
        assertEquals(expResult, result);
    }
    
     //** remove() WhiteBox Test 02
    //*  removes 1 person from a queue of 5
    @Test
    public void wbRemoveFromQueueOfFive() throws Exception 
    {
        System.out.println("remove a person from a queue of 5 people");
        Person person = new Person("Richard");
        int priority = 38;        
        q.add(person, priority);
        person = new Person("James");
        priority = 105;        
        q.add(person, priority);
        person = new Person("Gemma");
        priority = 49; 
        q.add(person, priority);
        person = new Person("Natahsa");
        priority = 106; 
        q.add(person, priority);
        person = new Person("Ann");
        priority = 25; 
        q.add(person, priority);
        q.remove();
        String expResult = "[(Ann, 25), (Gemma, 49), (James, 105), (Richard, 38)]";
        String result = q.toString();
        assertEquals(expResult, result);
    }
    
}
