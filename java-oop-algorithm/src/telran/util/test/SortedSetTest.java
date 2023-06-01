package telran.util.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import telran.util.Set;
import telran.util.SortedSet;

public abstract class SortedSetTest extends SetTest {

	@Override
	protected Integer[] getActual(Integer[] array, int size) {
		//System.out.println("Sorted test");
		return array;
	}
	@Test
	void firstTest() {
		SortedSet<Integer> sortedSet = (SortedSet<Integer>)set;
		assertEquals(-20, sortedSet.first());
	}
	@Test
	void lastTest() {
		SortedSet<Integer> sortedSet = (SortedSet<Integer>)set;
		assertEquals(100, sortedSet.last());
	}
	@Test
	void ceilingTest() {
		SortedSet<Integer> sortedSet = (SortedSet<Integer>)set;
		assertEquals(100, sortedSet.ceiling(100));
		assertEquals(null, sortedSet.ceiling(110));
		assertEquals(100, sortedSet.ceiling(90));
		assertEquals(50, sortedSet.ceiling(40));
		
	}
	@Test
	void floorTest() {
		SortedSet<Integer> sortedSet = (SortedSet<Integer>)set;
		//TODO test for the method floor
		assertEquals(30, sortedSet.floor(30));
		assertEquals(null, sortedSet.floor(-40));
		assertEquals(7, sortedSet.floor(8));
		assertEquals(-20, sortedSet.floor(0));
	}

}
