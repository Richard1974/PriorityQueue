package queuemanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *  Sorted Array Testing
 * @author Richard Coldwell
 */
public class SortedArrayPriorityQueueTest extends PriorityQueueTest{
    
    public SortedArrayPriorityQueueTest() {
    }
    
    
    
    @Before
    @Override
    public void setUp() {
        q = new SortedArrayPriorityQueue<Person>(8);
    }
    
    
 
    
    
    
}