package telran.util.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.ArrayList;
import telran.util.Collection;

public abstract class CollectionTest {
	private static final int BIG_LENGTH = 100000;
//TODO move tests of interface collection methods (5 methods) from ListTest
//	to here
	protected Integer[] numbers = {10, -20, 7, 50, 100, 30};
	protected Collection<Integer> collection;
	@BeforeEach
	void setUp() {
		collection = getCollection();
		for( int i = 0; i < numbers.length; i++) {
			collection.add(numbers[i]);
		}
	}
	abstract protected Collection<Integer> getCollection();
	
	@Test
	void testAdd() {
	assertTrue(collection.add(numbers[0]));
	assertEquals(numbers.length + 1, collection.size());
	}
	
	@Test
	void testRemovePattern() {
		Integer [] expectedNo10 = { -20, 7, 50, 100, 30};
		Integer [] expectedNo10_50 = { -20, 7,  100, 30};
		Integer [] expectedNo10_50_30 = { -20, 7,  100};
		assertTrue(collection.remove(numbers[0]));
		runTest(expectedNo10);
		Integer objToRemove = 50;
		assertTrue(collection.remove(objToRemove));
		runTest(expectedNo10_50);
		assertTrue(collection.remove((Integer)30));
		runTest(expectedNo10_50_30);
		assertFalse(collection.remove((Integer)50));
	}
	
	@Test
	void testRemoveIfAll() {
		assertTrue(collection.removeIf(a -> true));
		assertEquals(0, collection.size());
	}
	
	@Test
	void testToArrayForBigArray() {
		Integer bigArray[] = new Integer[BIG_LENGTH];
		for(int i = 0; i < BIG_LENGTH; i++) {
			bigArray[i] = 10;
		}
		Integer actualArray[] = collection.toArray(bigArray);
		int size = collection.size();
		for(int i = 0; i < size; i++) {
			assertEquals(numbers[i], actualArray[i]);
		}
		assertNull(actualArray[size]);
		assertTrue(bigArray == actualArray);
	}
	@Test
	void testToArrayForEmptyArray() {
		Integer actualArray[] =
				collection.toArray(new Integer[0]);
		assertArrayEquals(numbers, actualArray);
	}
	
	@Test
	void testRemoveIfPredicate() {
		Integer[] expected = {10, -20,  50, 100, 30};
		assertFalse(collection.removeIf(a -> a % 2 != 0
				&& a >= 10));
		assertTrue(collection.removeIf(a -> a % 2 != 0));
		runTest(expected);
		
	}
	
	@Test
	void iteratorTest() {
		int size = collection.size();
		Iterator<Integer> it1 = collection.iterator();
		Iterator<Integer> it2 = collection.iterator();
		it1.next();
		assertEquals(-20, it1.next());
		for (int i=0; i<size; i++) {
			it2.next();
		}
		assertThrows(NoSuchElementException.class,
				  ()-> it2.next());

		
		
	}
	// my first version:
	//abstract protected void runTest(Integer[] expected);
	
	
		protected void runTest(Integer[] expected) {
	//Yuri
			// Integer [] actual = collection.toArray(new Integer[0]);
		Integer [] actual = new Integer[collection.size()];
		actual = collection.toArray(actual);
		
		assertArrayEquals(expected, actual);
		
	}
	
}