package telran.algorithm;

import static org.junit.jupiter.api.Assertions.*;

import static telran.algorithm.InitialAlgorithms.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static telran.algorithm.InitialAlgorithms.*;
//import  telran.algorithm.InitialAlgorithms.*;
class InitialAlgorithmsTest {
int N_NUMBERS = 100000;
 short[] array;

 void setUpBigArray() {
	 
	 array = new short[N_NUMBERS];
	 for(int i = 0; i < N_NUMBERS; i++) {
		 array[i] = (short) (Math.random() * Short.MAX_VALUE);
	 }
 }
	@Test
	@Disabled
	void bubbleSortTest() {
		setUpBigArray();
		bubbleSort(array);
		runTest();
	}
	@Test
	void SortPositiveShortTest() {
		setUpBigArray();
		sortShortPositive(array);
		runTest();
	}
	private void runTest() {
		for(int i = 1; i < N_NUMBERS; i++) {
			assertTrue(array[i - 1] <= array[i]);
		}
		
	}
	@Test
	void isSum2Test() {
		short[] array = {30000, 1, 5, 2, 10000, 0, 500,0};
		short[] array1 = {30000, 1, 5, 2, 10000, 0, 500,0, Short.MAX_VALUE};
		assertTrue(isSum2(array, (short)30000));
		assertTrue(isSum2(array, (short)7));
		assertFalse(isSum2(array, (short)30003));
		assertFalse(isSum2(array, (short)8));
		assertTrue(isSum2(array1, Short.MIN_VALUE));
		
	}
	@Test
	void getMaxPositiveWithNegativeTest() {
		short[] array = {1, 1, 1, -1, 20, 100,200, 100 -100, -100, -20, -40, 80};
		short[] array1 = {-40, 1, -40, -6, 2, 3, 40};
		short[] array2 = {40, 1, 2, 3, 40, -30};
		assertEquals(100,
				getMaxPositiveWithNegativeReflect(array));
		assertEquals(40,
				getMaxPositiveWithNegativeReflect(array1));
		assertEquals(-1,
				getMaxPositiveWithNegativeReflect(array2));
	}
	

	@Test
	void maxValueComplexityNTest() {
		
		assertEquals(Integer.MAX_VALUE, getmaxValueComplexityN());
	}
	
	@Test
	void maxValueComplexityLogNTest() {
		
		assertEquals(Integer.MAX_VALUE, getmaxValueComplexityLogN());
	}
	
	
	@Test
	void binarySearch2Test () {
		Integer [] array = 
			{-5,-3,1,2,3,3,3,3,5,6,7,8,9,10,11,12,12,13,14,15,16};

		assertEquals(4, binarySearch2(array, 3, Comparator.naturalOrder()));
		assertEquals(4, binarySearch2(array, 3, ((a, b) -> a - b)));
		assertEquals(-1, binarySearch2(array, 100, Comparator.naturalOrder()));
		assertEquals(20, binarySearch2(array, 16, Comparator.naturalOrder()));
		assertEquals(0, binarySearch2(array, -5, Comparator.naturalOrder()));
		assertEquals(15, binarySearch2(array, 12, Comparator.naturalOrder()));

	}
	
	private Integer getmaxValueComplexityN() {
		int res = 1;
		while (res > 0) {			res++;
		}
		return res-1;
	}
	private Integer getmaxValueComplexityLogN() {
		int res = 1;
		while (res > 0) {
			 res*=2;
		}
		return res-1;
	}
	
}
