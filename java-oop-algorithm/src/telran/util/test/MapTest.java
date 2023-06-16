package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import telran.util.Map;

import org.junit.jupiter.api.Test;

abstract class MapTest {
String[] keys = {"lmn", "abc", "ab", "a"};
Integer[] values = {3, 2, 2, 1};
protected Map<String, Integer> map;
    @BeforeEach
    void setUp() {
    	for (int i = 0; i < keys.length; i++) {
    		map.put(keys[i], values[i]);
    	}
    }

	@Test
	void getTest() {
		for(int i = 0; i < keys.length; i++) {
			assertEquals(values[i], map.get(keys[i]));
		}
	}
	@Test
	void containsKeyTest() {
	
		assertTrue(map.containsKey("lmn"));
		assertTrue(map.containsKey("a"));
		assertFalse(map.containsKey("bbb"));
		
	}
	@Test
	void containsValueTest() {
		assertTrue(map.containsValue(1)); 
		assertTrue(map.containsValue(2));
		assertFalse(map.containsValue(344));
	}
	
	@Test
	void removeTest() {
		map.remove("abc");
		map.remove("a");
		assertFalse(map.containsKey("abc"));
		assertFalse(map.containsValue(1));
		assertTrue (map.containsValue(2));
		
	}

}
