package telran.strings.test;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import telran.strings.*;

public class StringTests {
	private static final int N_STRINGS = 1000;
	private static final int N_RUNS = 10000;
	String[] strings = {"Hello", "Hello", "Hello"};
	String expected = "Hello#Hello#Hello";

	/*
	@Test
void joinBuilderTest() {
	JoinStrings js = new JoinStringsBuilderImpl();
	String[] strings = getStrings();
	String expected = getExpected();
	runTest(js, strings, expected);
}
@Test 
/*
void JoinStringsTest() {
	JoinStrings js = new JoinStringImpl();
	String[] strings = getStrings();
	String expected = getExpected();
	runTest(js, strings, expected);
}
private void runTest(JoinStrings js, String[] strings2, String expected2) {
	assertEquals(expected2,js.join(strings, "#"));
	
}
private String getExpected() {
	
	return expected;
}
private String[] getStrings() {
	
	return strings;
}

*/
	@Test
	void joinBuilderTest() {
		JoinStrings js = new JoinStringsBuilderImpl();
		String[] strings = getStrings();
	
		runTest(js, strings);
	}
void JoinStringsTest() {
	JoinStrings js = new JoinStringImpl();
	String[] strings = getStrings();
	String expected = getExpected();
	runTest(js, strings);
}
private void runTest(JoinStrings js, String[] strings2) {
	for (int i =0; i < N_RUNS; i++) {
		js.join(strings, "#");
	}
	
}
private String getExpected() {
	
	return expected;
}
private String[] getStrings() {
	String [] res = new String [N_STRINGS];
	for(int i = 0; i < N_STRINGS; i++) {
		res[i] = "Hello";
	}
	return res;
}
}
