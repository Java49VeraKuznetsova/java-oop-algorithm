package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import telran.util.*;

import org.junit.jupiter.api.Test;



class ArrayListTest  extends ListTest{

	@Override
	protected <T> List<T> getList() {
		return new ArrayList<>();
	}
	/*
	@Test
	void constractorExceptionTest() {
		Integer[] expected = { -20,  10, 30, 50, 100, 7, -17};
		Integer[] expected2 = {};
	assertThrowsExactly(IllegalArgumentException.class, 
				() -> new ArrayList());
	}
*/
	
}