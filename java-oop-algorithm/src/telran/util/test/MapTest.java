package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import telran.util.Collection;
import telran.util.Map;
import telran.util.Map.Entry;
import telran.util.Set;

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
		assertThrowsExactly(NullPointerException.class, 
				() -> map.containsKey(null));
		for (Integer value: values) {
			assertTrue(map.containsValue(value));
			assertFalse(map.containsValue(value+100));
		}
		
	}
	@Test
	void containsValueTest() {
		assertTrue(map.containsValue(1)); 
		assertTrue(map.containsValue(2));
		assertFalse(map.containsValue(344));
		assertThrowsExactly(NullPointerException.class, 
				() -> map.containsValue(null));
		for (String key: keys) {
			assertTrue (map.containsKey(key));
			assertFalse (map.containsKey(key+"bbb"));
		}
	}
	
	@Test
	void removeTest() {
		
		map.remove("abc");
		map.remove("a");
		assertFalse(map.containsKey("abc"));
		assertFalse(map.containsValue(1));
		assertTrue (map.containsValue(2));
		
		assertEquals(map.entrySet().size(), keys.length-2);
		assertThrowsExactly(NullPointerException.class, 
				() -> map.remove(null));
	
	}
	
	@Test
	void getOrDefaultTest () {
			for (String key: keys) {
			assertEquals(map.getOrDefault(key, 345), map.get(key));
					}
			assertEquals(map.getOrDefault("bbb", 345), 345);
	}
   @Test
   void putIfAbsentTest () {
	   int oldSize = map.entrySet().size();
	   
		   assertEquals(map.putIfAbsent(keys[0]+"bbb", 345), null);
		  map.putIfAbsent(keys[1], 100);
	   
	  assertTrue(map.containsValue(345));
	  assertFalse(map.containsValue(100));
	 assertEquals(map.entrySet().size(), oldSize+1);
   }
	@Test
	void putTest () {
		int sizeOld = map.entrySet().size();
		map.put("bbb", 345);
		map.put("lmn", 100);
		Collection <Integer> resValues = map.values();
		assertTrue(resValues.contains(345));
		assertTrue(resValues.contains(100));
		assertFalse(resValues.contains(3));
		assertEquals(sizeOld+1, resValues.size());
	
		//assertThrowsExactly(NullPointerException.class, 
			//	() -> map.put(null,345));
		map.put("bbb+", null);
		
	}
	@Test
	void valuesTest () {
		Collection<Integer> col = map.values();
		for (Integer value: values) {
			assertTrue(col.contains(value));
		}
		for (Integer value: values) {
			assertFalse(col.contains(value+100));
		}
		assertEquals(values.length, col.size());
	}
	@Test
	void keySetTest () {
		Set<String> resKey = map.keySet();
		for (String key: resKey) {
			map.containsKey(key);
		}
		assertEquals(resKey.size(), map.entrySet().size());
	}
	@Test 
	void entrySetTest () {
		Set<Entry<String,Integer>> setRes = map.entrySet();
		assertEquals(map.entrySet().size(), setRes.size());
		for (String key: keys) {
			Entry<String, Integer> entry = new Entry<>(key, null);
			assertEquals(map.get(key), setRes.get(entry).getValue());
		}
		
		
	}
}
