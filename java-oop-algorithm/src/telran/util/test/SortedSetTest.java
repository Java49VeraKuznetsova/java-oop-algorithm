package telran.util.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import telran.util.Set;
import telran.util.SortedSet;
import telran.util.TreeSet;

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
	
		TreeSet<Integer> treeTest = new TreeSet<>();
		assertThrowsExactly(NoSuchElementException.class, () -> treeTest.first());
	}
	
	private TreeSet<Integer> getEmpty() {
		// TODO Auto-generated method stub
		return new TreeSet<>();
	}
	@Test
	void lastTest() {
		SortedSet<Integer> sortedSet = (SortedSet<Integer>)set;
		assertEquals(100, sortedSet.last());
		TreeSet<Integer> treeTest = new TreeSet<>();
		assertThrowsExactly(NoSuchElementException.class, () -> treeTest.last());
	}
	@Test
	void ceilingTest() {
		SortedSet<Integer> sortedSet = (SortedSet<Integer>)set;
		assertEquals(100, sortedSet.ceiling(100));
		assertEquals(null, sortedSet.ceiling(110));
		assertEquals(100, sortedSet.ceiling(90));
		assertEquals(50, sortedSet.ceiling(40));
		assertEquals(7, sortedSet.ceiling(4));
		assertEquals(-20, sortedSet.ceiling(-40));
		assertNull(sortedSet.ceiling(110));
		
		assertThrowsExactly(NullPointerException.class, () -> sortedSet.ceiling(null));
		
	}
	@Test
	void floorTest() {
		SortedSet<Integer> sortedSet = (SortedSet<Integer>)set;
		assertEquals(30, sortedSet.floor(30));
		assertEquals(null, sortedSet.floor(-40));
		assertEquals(7, sortedSet.floor(8));
		assertEquals(-20, sortedSet.floor(0));
		assertEquals(100, sortedSet.floor(110));
		assertEquals(50, sortedSet.floor(60));
		assertThrowsExactly(NullPointerException.class, () -> sortedSet.floor(null));
	}

}
