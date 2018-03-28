/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author coldw
 */
public class HeapPriorityQueueTest extends PriorityQueueTest{
    
    public HeapPriorityQueueTest() {
    }
    
   @Before
    @Override
    public void setUp() {
        q = new HeapPriorityQueue<>(8);
    }
    
     /**
//     * Test of add method, of class PriorityQueue.
//     * Add 3 items to heap 3rd one will be top of heap 
//     */
    @Test
    public void testAddThreeToHeap() throws Exception {
        System.out.println("add a person to the end of a sorted queue using .add(person, priority)");
        Person person = new Person("James");
        int priority = 45;        
        q.add(person, priority);
        person = new Person("Lee");
        priority = 40;        
        q.add(person, priority);
        person = new Person("Gemma");
        priority = 56;        
        q.add(person, priority);
        
        
        String expResult = "[(Gemma, 56), (Lee, 40), (James, 45)]";
        String result = q.toString();
        assertEquals(expResult, result);
        
    }
    
    
    
}
