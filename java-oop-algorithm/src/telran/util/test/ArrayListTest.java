package telran.util.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import telran.util.ArrayList;
//import telran.util.List;
import telran.util.*;

class ArrayListTest {
	private static final int BIG_LENGTH = 100000;
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
	
		
	};

	@Test
	void TestAddIndex() {
		
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
		
	
	}
	@Test
	void testIndexOf() {
	list.add(3,10);
	
	assertEquals(0, list.indexOf(10));
	assertEquals(-1, list.indexOf(null));
	}
	@Test
	void testLastIndexOf() {
		
		list.add(3,10);
		assertEquals(6,list.lastIndexOf(30));
		assertEquals(3,list.lastIndexOf(10));
		assertEquals(1,list.lastIndexOf(-20));
		assertEquals(-1, list.lastIndexOf(null));
		list.add(10);
		assertEquals(7,list.lastIndexOf(10));
	}
	// this is mine

	@Test
	void testToArrayForBigArray() {
		Integer bigArray[] = new Integer[BIG_LENGTH];
		for(int i = 0; i < BIG_LENGTH; i++) {
			bigArray[i] = 10;
		}
		Integer actualArray[] = list.toArray(bigArray);
		int size = list.size();
		for(int i = 0; i < size; i++) {
			assertEquals(numbers[i], actualArray[i]);
		}
		assertNull(actualArray[size]);
		assertTrue(bigArray == actualArray);
	}
	@Test
	void testToArrayForEmptyArray() {
		Integer actualArray[] =
				list.toArray(new Integer[0]);
		assertArrayEquals(numbers, actualArray);
	}
	// this is Yuri's
	@Test
	void testRemovePattern() {
		Integer [] expectedNo10 = { -20, 7, 50, 100, 30};
		Integer [] expectedNo10_50 = { -20, 7,  100, 30};
		Integer [] expectedNo10_50_30 = { -20, 7,  100};
		assertTrue(list.remove(numbers[0]));
		runTest(expectedNo10);
		Integer objToRemove = 50;
		assertTrue(list.remove(objToRemove));
		runTest(expectedNo10_50);
		assertTrue(list.remove((Integer)30));
		runTest(expectedNo10_50_30);
		assertFalse(list.remove((Integer)50));
	}
	
	@Test
	void testSort() {
		Integer expected[] = {-20, 7, 10, 30,  50, 100 };
		list.sort();
		assertArrayEquals(expected,
				list.toArray(new Integer[0]));
	}
	@Test
	void testSortPersons() {
		List<Person> persons = new ArrayList<>();
		Person p1 = new Person(123, 25, "Vasya");
		Person p2 = new Person(124, 20, "Asaf");
		Person p3 = new Person(120, 50, "Arkady");
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		Person expected[] = {p3, p1, p2};
		persons.sort();
		assertArrayEquals(expected, persons.toArray(new Person[0]));
	}
	@Test
	void testSortPersonsByAge() {
		List<Person> persons = new ArrayList<>();
		Person p1 = new Person(123, 25, "Vasya");
		Person p2 = new Person(124, 20, "Asaf");
		Person p3 = new Person(120, 50, "Arkady");
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		Person expected[] = {p3, p1, p2};
		persons.sort(new PersonsAgeComparator());
		assertArrayEquals(expected,
				persons.toArray(new Person[0]));
		
	}
    @Test
	void testEvenOddComparator() {
		
		Integer [] expectedOld = {10, -20, 7, 50, 100, 30, 17, 3}; 
		Integer [] expectedNew = {-20, 10, 30, 50, 100, 17, 7, 3};
		
		list.add(17);
		list.add(3);
	
		assertArrayEquals(expectedOld,
			list.toArray(new Integer[0]));
		
		list.sort(new EvenOddComparator());
	
		
		assertArrayEquals(expectedNew,
			list.toArray(new Integer[0]));
		
	}
			
	@Test
	void testSort2() {
		Integer expected[] = {-20, 7, 10, 30,  50, 100 };
		list.sort(new bubbleSort());
		assertArrayEquals(expected,
				list.toArray(new Integer[0]));
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
/*
@Test
void testRemovePattern () {

	// remove 30
	assertTrue(list.remove(list.get(5)));
	assertFalse(list.remove(list.get(5)));
	Integer x = -20;
	Integer y = 30;
	
	// add -20 in the middle and in the end
	list.add(3, x);
	list.add(5, x);
;
	// check - that we remove 30 in line 133;
	assertFalse(list.remove(y));
	//remove -20 with index 1, -20 by index 2 and 4 - is in the list
	assertTrue (list.remove(x));
	assertEquals(7, list.get(1));
	assertEquals(-20, list.get(2));
	assertEquals(-20, list.get(4));
	assertTrue (list.remove(x));
	assertEquals(7, list.get(1));
	assertEquals(-20, list.get(3));
	assertTrue(list.remove(x));
	//no more -20
	assertFalse(list.remove(x));
}
*/
// This is mine
/*
@Test
void testToArray () {
	Integer[] numbers2 = {10, -20, 7, 50, 100, 30, null};
	
	
	Integer[] arr1 = new Integer[list.size()];
	Integer[] arr2 = new Integer[list.size()-1];
	Integer[] arr3 = new Integer[list.size()+1];
	
		
	assertArrayEquals(numbers, list.toArray(arr1));
	assertArrayEquals(numbers, list.toArray(arr2));
	assertArrayEquals(numbers2, list.toArray(arr3));
	

	
}
*/
