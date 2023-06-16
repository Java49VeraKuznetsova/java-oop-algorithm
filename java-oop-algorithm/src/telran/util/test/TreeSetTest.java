package telran.util.test;

import telran.util.TreeSet;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.ArrayList;
import telran.util.Set;

public class TreeSetTest extends SortedSetTest {
TreeSet<Integer> treeSet;
@BeforeEach
@Override
void setUp() {
	super.setUp();
	treeSet = (TreeSet<Integer>) set;
}
	@Override
	protected <T> Set<T> getSet() {
		
		return new TreeSet<>();
	}
//	@Override
//	@Test
//	void clearPerformance() {
//		
//	}
	@Test
	void displayTree() {
		treeSet.setInitialLevel(5);
		treeSet.setSpacesPerLevel(3);
		treeSet.displayRotated();
	}
	@Test
	void widthTest() {
		assertEquals(3, treeSet.width());
	}
	@Test
	void heightTest() {
		assertEquals(3, treeSet.height());
	}
	@Test
	void balanceTest() {
		TreeSet<Integer> treeBalanced = new TreeSet<>();
		int [] array = getRandomArray(255);
		fillCollection(treeBalanced, array);
		treeBalanced.balance();
		assertEquals(8, treeBalanced.height());
		assertEquals(128, treeBalanced.width());
	}
	
	@Test
	void balanceTestFromSorted() {
		int height = 18;
		int nNumbers = (int) Math.pow(2, height);
		//int [] array = getRandomArray(nNumbers - 1);
		int [] array = new int[nNumbers - 1];
		for(int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		TreeSet<Integer> treeBalanced = new TreeSet<>();
		//Arrays.sort(array);
		balanceOrder(array);
		fillCollection(treeBalanced, array);
		
		assertEquals(height, treeBalanced.height());
		assertEquals(nNumbers / 2, treeBalanced.width());
		
	}
	private void balanceOrder(int[] array) {
		
		//reorder array such that adding to tree will get a balanced tree
		int right = array.length-1;
		int left = 0;
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
	
		balanceOrder (array, left, right, arrayList);
		Integer [] arrayNew = arrayList.toArray(new Integer [0]);
		for (int i = 0; i < array.length; i++) {
			array[i] = arrayNew[i];
		}
		 
		
		
	}
		private void balanceOrder(int[] array, int left, int right, ArrayList<Integer> arrayList) {
		
			//Integer currentEl;
			
			if (left <= right) {
				int arrayIndex = (left+right) / 2;
				
				arrayList.add(array[arrayIndex]);
				 balanceOrder(array, left, arrayIndex-1, arrayList);
			
				 balanceOrder(array,  arrayIndex+1, right, arrayList);
			
				
			}
			
		}
	
	@Test
	void inversionTreeTest() {
		Integer[] expected = {100, 50, 30, 10, 7, -20};
		
		treeSet.inversion();
		
	    assertArrayEquals(expected, treeSet.toArray(new Integer[0]));
	   assertTrue(treeSet.contains(100));
	}

}