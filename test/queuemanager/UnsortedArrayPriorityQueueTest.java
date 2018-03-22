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
public class UnsortedArrayPriorityQueueTest extends PriorityQueueTest{
    
    public UnsortedArrayPriorityQueueTest() {
    }
    
   
    
    @Before
    @Override
    public void setUp() {
        q = new UnsortedArrayPriorityQueue<Person>(8);
    }
    
    
    
}
