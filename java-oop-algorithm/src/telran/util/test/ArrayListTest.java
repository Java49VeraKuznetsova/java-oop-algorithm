package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.util.ArrayList;

class ArrayListTest {

	@Test
	void testAdd() {
		ArrayList<Integer> numbers = new ArrayList<>();
		ArrayList<String> strings = new ArrayList<>();
		numbers.add(5);
		numbers.add(10);
		strings.add("abc");
		assertEquals(2, numbers.size());
		assertEquals(1, strings.size());
	};

	@Test
	void TestAddIndex() {
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
		
		}
	
	@Test
	void TestRemoveIndex() {
		ArrayList<Integer> object = new ArrayList<>();
		object.add(5);
		object.add(10);
		object.add(15);
		object.add(20);
		object.add(25);
		object.add(30);
	    object.remove(0);
	    object.remove(2);
		object.remove(4);
		assertEquals(10, object.get(0));
		assertEquals(15, object.get(1));
		assertEquals(25, object.get(2));
		assertEquals(3,object.size());
	}
}
