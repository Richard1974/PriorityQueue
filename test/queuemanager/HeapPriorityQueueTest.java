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
 * Heap Testing
 * @author Richard Coldwell
 */
public class HeapPriorityQueueTest extends PriorityQueueTest{
    
    public HeapPriorityQueueTest() {
    }
    
    @Before
    @Override
    public void setUp() {
        q = new HeapPriorityQueue<>(8);
    }
    
    //************************************************************
    //***  WHITE BOX TESTING RELEVANT TO THIS IMPLEMENTATION   ***
    //************************************************************
    
    //*******************************************
    //** add() Tests                       **
    //*******************************************
    
    //** add() WhiteBox Test 01
    //** add 3 people to queue expected max heap shown below
    //**                
    //**                     10
    //**                    /  \
    //**                   5    8
    @Test
    public void wbTestAddTestOne() throws Exception 
    {
        System.out.println("Add 3 to queue and check sorts correctly");
        Person person = new Person("Richard");
        int priority = 10;        
        q.add(person, priority);
        person = new Person("James");
        priority = 5;        
        q.add(person, priority);
        person = new Person("Gemma");
        priority = 8;        
        q.add(person, priority);
        String expResult = "[(Richard, 10), (James, 5), (Gemma, 8)]";
        String result = q.toString();
        assertEquals(expResult, result);
    }
    
    //** add() WhiteBox Test 02
    //** add 3 people to queue expected max heap shown below
    //**                
    //**                     10
    //**                    /  \
    //**                   8    5
    @Test
    public void wbTestAddTestTwo() throws Exception 
    {
        System.out.println("Add 3 to queue and check sorts correctly");
        Person person = new Person("Richard");
        int priority = 10;        
        q.add(person, priority);
        person = new Person("Gemma");
        priority = 8;        
        q.add(person, priority);
        person = new Person("James");
        priority = 5;        
        q.add(person, priority);
        
        String expResult = "[(Richard, 10), (Gemma, 8), (James, 5)]";
        String result = q.toString();
        assertEquals(expResult, result);
    }
    
    //** add() WhiteBox Test 03
    //** add 3 people to queue expected max heap shown below
    //**                
    //**                     15
    //**                    /  \
    //**                   8    10
    @Test
    public void wbTestAddTestThree() throws Exception 
    {
        System.out.println("Add 3 to queue and check sorts correctly");
        Person person = new Person("Richard");
        int priority = 10;        
        q.add(person, priority);
        person = new Person("Gemma");
        priority = 8;        
        q.add(person, priority);
        person = new Person("James");
        priority = 15;        
        q.add(person, priority);
        
        String expResult = "[(James, 15), (Gemma, 8), (Richard, 10)]";
        String result = q.toString();
        assertEquals(expResult, result);
    }
    
    //** add() WhiteBox Test 04
    //** add 6 people to queue expected max heap shown below
    //**                
    //**                     19
    //**                    /   \
    //**                   17    16
    //**                  /  \   / 
    //**                 7   15 10  
   
    @Test
    public void wbTestAddTestFour() throws Exception 
    {
        System.out.println("Add 6 to queue and check sorts correctly");
        Person person = new Person("Richard");
        int priority = 15;        
        q.add(person, priority);
        person = new Person("Gemma");
        priority = 19;        
        q.add(person, priority);
        person = new Person("James");
        priority = 10;        
        q.add(person, priority);
        person = new Person("Natasha");
        priority = 7;        
        q.add(person, priority);
        person = new Person("Helen");
        priority = 17;        
        q.add(person, priority);
        person = new Person("Keith");
        priority = 16;        
        q.add(person, priority);
        String expResult = "[(Gemma, 19), (Helen, 17), (Keith, 16), (Natasha, 7), (Richard, 15), (James, 10)]";
        String result = q.toString();
        assertEquals(expResult, result);
    }
    
    
    //*******************************************
    //** remove() Tests                        **
    //******************************************* 
    
     //** remove() WhiteBox Test 01
    //*  removes 1 person from a queue of 3
    //**                after adds        after remove
    //**                     15               10
    //**                    /  \             /
    //**                   8    10          8
    @Test
    public void wbRemoveFromTestOne() throws Exception 
    {
        System.out.println("remove a person from a queue of 3 people");
        Person person = new Person("Richard");
        int priority = 10;        
        q.add(person, priority);
        person = new Person("Gemma");
        priority = 8;        
        q.add(person, priority);
        person = new Person("James");
        priority = 15;        
        q.add(person, priority);
        q.remove();
        String expResult = "[(Richard, 10), (Gemma, 8)]";
        String result = q.toString();
        assertEquals(expResult, result);
    }
    
    //** remove() WhiteBox Test 02
    //** add 3 people to queue expected max heap shown below
    //**                after adds       after remove
    //**                     19            17
    //**                    /   \         /  \
    //**                   17    16      15  16
    //**                  /  \   /      /  \
    //**                 7   15 10     7   10
   
    @Test
    public void wbRemoveFromTestTwo() throws Exception 
    {
        System.out.println("wbRemoveFromTestTwo");
        Person person = new Person("Richard");
        int priority = 15;        
        q.add(person, priority);
        person = new Person("Gemma");
        priority = 19;        
        q.add(person, priority);
        person = new Person("James");
        priority = 10;        
        q.add(person, priority);
        person = new Person("Natasha");
        priority = 7;        
        q.add(person, priority);
        person = new Person("Helen");
        priority = 17;        
        q.add(person, priority);
        person = new Person("Keith");
        priority = 16;        
        q.add(person, priority);
        q.remove();
        String expResult = "[(Helen, 17), (Richard, 15), (Keith, 16), (Natasha, 7), (James, 10)]";
        String result = q.toString();
        assertEquals(expResult, result);
    }
}
