package practice.collections.arraycollection;

import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.*;

public class ArrayCollectionTest {

    @Test
    public void testSizeWhenSizeIs0() throws Exception {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        assertEquals(0, testInstance.size());
    }

    @Test
    public void testIsEmptyWhenEmpty() throws Exception {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        assertTrue(testInstance.isEmpty());
    }

    @Test
    public void testToArrayWhenInputArrayHaveSizeOne() throws Exception {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);

        final Integer[] input = new Integer[1];

        final Integer[] result = testInstance.toArray(input);
        assertNotEquals(input, result);
        assertEquals((Integer)1, result[0]);
        assertEquals((Integer)2, result[1]);
        assertEquals((Integer)3, result[2]);
        assertEquals(3, result.length);
    }

    @Test
    public void testToArrayWhenInputArrayHaveCorrectSize() throws Exception {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);

        final Integer[] input = new Integer[3];

        final Integer[] result = testInstance.toArray(input);
        assertEquals(input, result);
    }

    @Test
    public void testContains() throws Exception {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);

        assertTrue(testInstance.contains(1));
        assertFalse(testInstance.contains(0));
    }

    @Test
    public void testAdd() throws Exception {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(1);

        assertEquals(2, testInstance.size());
        assertFalse(testInstance.isEmpty());
    }

    @Test
    public void testRemoveFirstElement() throws Exception {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.remove(1);

        assertEquals(1, testInstance.size());
        assertFalse(testInstance.isEmpty());
    }

    @Test
    public void testRemoveLastElement() throws Exception {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.remove(2);

        assertEquals(1, testInstance.size());
        assertFalse(testInstance.isEmpty());
    }

    @Test
    public void testContainsAll() throws Exception {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        final Collection<Integer> testInstance2 = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);

        testInstance2.add(2);
        testInstance2.add(1);

        assertTrue(testInstance.containsAll(testInstance2));
    }

    @Test
    public void testAddAll() throws Exception {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);

        testInstance.add(3);
        testInstance.add(4);

        assertTrue(testInstance.contains(3));
        assertTrue(testInstance.contains(4));
    }

    @Test
    public void testRemoveAll() throws Exception {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        final Collection<Integer> testInstance2 = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);

        testInstance2.add(2);
        testInstance2.add(3);

        testInstance.removeAll(testInstance2);

        assertEquals(1, testInstance.size());
        assertTrue(testInstance.contains(1));
    }

    @Test
    public void testRetainAll() throws Exception {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        final Collection<Integer> testInstance2 = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);

        testInstance2.add(2);
        testInstance2.add(3);

        testInstance.retainAll(testInstance2);

        assertEquals(1, testInstance.size());
        assertTrue(testInstance.contains(2));
    }

    @Test
    public void testClear() throws Exception {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(1);

        testInstance.clear();

        assertTrue(testInstance.isEmpty());
        assertEquals(0, testInstance.size());
    }

    @Test
    public void testRemoveBeforeNext() throws Exception {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(2);

        final Iterator<Integer> iter = testInstance.iterator();
        try {
            iter.remove();
            fail("remove do not throw the Exception when called before next");
        } catch (final IllegalStateException e) {}
    }

    @Test
    public void testNextOnEmptyCollection() throws Exception {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);

        final Iterator<Integer> iter = testInstance.iterator();
        iter.next();
        iter.remove();
        iter.next();
        iter.remove();
        try {
            iter.next();
            fail("next do not throw the Exception when no more ellements");
        } catch (final java.util.NoSuchElementException e) {}
    }

    @Test
    public void testRemoveTwoTimeInTheRow() throws Exception {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);

        final Iterator<Integer> iter = testInstance.iterator();
        iter.next();
        iter.remove();
        assertEquals("Expected collection size is 1, however actual is not", 1, testInstance.size());
        try {
            iter.remove();
            fail("remove do not throw the Exception when called twice");
        } catch (final IllegalStateException e) {}
    }

}