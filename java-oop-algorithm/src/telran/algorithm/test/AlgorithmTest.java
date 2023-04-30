package telran.algorithm.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;


import telran.algorithm.*;



import org.junit.jupiter.api.Test;

class AlgorithmTest {
@BeforeEach
void setUp() {
	short [] arrayBig = new short[100000];
	for (int i = 0; i<100000; i++) {
		arrayBig[i]= (short)(Math.random() * Short.MAX_VALUE);
	}
}
	
	@Test
	void testSortShortPositive() {
		short [] array = new short[100000];
		for (int i = 0; i<100000; i++) {
			array[i]= (short)(Math.random() * Short.MAX_VALUE);
		}
		InitialAlgorithms.sortShortPositive(array);
		
		runSortedArrayTest(array);
	
	}



	@Test
	void testBubbleSort() {
		short [] array = new short[100000];
		for (int i = 0; i<100000; i++) {
			array[i]= (short)(Math.random() * Short.MAX_VALUE);
		}
		InitialAlgorithms.bubbleSort(array);
		
		runSortedArrayTest(array);
	}
/*
	@Test
	void testIsSum() {
		short [] expected1 = {1, 10, 5, 8, 7, 6};
	
	boolean fl = InitialAlgorithms.isSum(expected1, (short)13);
		//System.out.print(fl);
		assertTrue(InitialAlgorithms.isSum(expected1, (short) 13));
		assertFalse(InitialAlgorithms.isSum(expected1, (short) 25));
	}

	*/
	/*
	@Test
	void testGetMaxPositiveWithNegativeReflect() {
		short [] expected1 = {-2, 4, -10, 1, 12, -24, 10, -3, 2};
		short [] expected2 = {-2, 4, -10, 1, 12, -24, 9, -3, 5};
		assertEquals(10, InitialAlgorithms.getMaxPositiveWithNegativeReflect(expected1));
		assertEquals(-1, InitialAlgorithms.getMaxPositiveWithNegativeReflect(expected2));
	}
	*/
	
	private void runSortedArrayTest (short array[]) {
		for (int i=0; i < array.length-1; i++) {
			assertTrue(array[i]<=array[i+1]);
		}
		
	}

}
