import static org.junit.Assert.*;

/**
 * Created by susanna on 3/8/16.
 */


public class LRUCacheTest {
    LRUCache<String, Integer> c = new LRUCache<String, Integer>(3);


    @org.junit.Test
    public void testPut() throws Exception {
        c.put("Andy",5);
        c.put("Thomas",6);
        assertEquals(2,c.currentSize());
    }

    @org.junit.Test
    public void testGet() throws Exception {
        c.put("Mike",10);
        int value = c.get("Mike");
        assertEquals(10,value);
    }

    @org.junit.Test
    public void testRemove() throws Exception {
        c.remove("Andy");
        assertNull(c.get("Andy"));

    }

    @org.junit.Test
    public void testRemoveAll() throws Exception {
        c.removeAll();
        assertNull(c.get("Mike"));
        assertNull(c.get("Thomas"));

    }
}