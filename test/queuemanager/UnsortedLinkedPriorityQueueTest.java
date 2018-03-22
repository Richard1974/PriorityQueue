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
    
    
}
