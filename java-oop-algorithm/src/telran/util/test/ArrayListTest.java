package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import telran.util.ArrayList;
//import telran.util.List;
import telran.util.*;

class ArrayListTest {
List<Integer> list;
Integer[] numbers = {10, -20, 7, 50, 100, 30};

@BeforeEach
void setUp() {
	list = new ArrayList<>(1);
	for(int i = 0; i < numbers.length; i++) {
		list.add(numbers[i]);
	}
}

	@Test
	void testAdd() {
		assertTrue(list.add(numbers[0]));
		assertEquals(numbers.length+1, list.size());
		
		/* Old testes
		ArrayList<Integer> numbers = new ArrayList<>();
		ArrayList<String> strings = new ArrayList<>();
		numbers.add(5);
		numbers.add(10);
		strings.add("abc");
		assertEquals(2, numbers.size());
		assertEquals(1, strings.size());
		*/
		
	};

	@Test
	void TestAddIndex() {
		/*
		ArrayList<Integer> object = new ArrayList<>();
		object.add(5);
		object.add(10);
		object.add(15);
		object.add(20);
		object.add(25);
		object.add(2, 100);
		object.add(0, 50);
		object.add(7, 30);
	    assertEquals(5, object.get(1));
		assertEquals(25, object.get(6));
		assertEquals(10, object.get(2));
		assertEquals(50, object.get(0));
		assertEquals(100, object.get(3));
		assertEquals(15, object.get(4));
		assertEquals(20, object.get(5));
		assertEquals(30, object.get(7));
		
		assertEquals(8, object.size());
		*/
		Integer [] expected0_500 = {500, 10, -20, 7, 50, 100, 30};
		Integer [] expected0_500_3_700 = {500, 10, -20, 700, 7, 50, 100, 30};
	    Integer [] expected0_500_3_700_8_300 = 	
	    	{500, 10, -20, 700, 7, 50, 100, 30, 300};
	    list.add(0, 500);
	    runTest(expected0_500);
	    list.add(3, 700);
	    runTest(expected0_500_3_700);
	    list.add(8, 300);
	    runTest(expected0_500_3_700_8_300);
	}
	@Test
	void testGetIndex() {
		assertEquals(10, list.get(0));
	}

	@Test
	void TestRemoveIndex() {
		Integer [] expectedNo10 = {-20, 7, 50, 100, 30};
		Integer [] expectedNo10_50 = {-20, 7,  100, 30};
		Integer [] expectedNo10_50_30 = {-20, 7,  100};
		assertEquals(10, list.remove(0));
		runTest(expectedNo10);
		assertEquals(50, list.remove(2));
		runTest(expectedNo10_50);
		assertEquals(30, list.remove(3));
		runTest(expectedNo10_50_30);
		
		/*
		ArrayList<Integer> object = new ArrayList<>();
		object.add(5);
		object.add(10);
		object.add(15);
		object.add(20);
		object.add(25);
		object.add(30);
	    object.remove(0);
	    object.remove(2);
		object.remove(3);
		assertEquals(10, object.get(0));
		assertEquals(15, object.get(1));
		assertEquals(25, object.get(2));
		assertEquals(3,object.size());
		*/
	}
	@Test
	void testIndexOf() {
	list.add(3,10);
	assertEquals(0, list.indexOf(10));
	assertEquals(-1, list.indexOf(null));
	}
	private void runTest(Integer[] expected) {
		int size = list.size();
		Integer [] actual = new Integer[expected.length];
		
		for(int i=0; i < size; i++) {
			actual[i] = list.get(i);
		}
		assertArrayEquals(expected, actual);
	}

}
