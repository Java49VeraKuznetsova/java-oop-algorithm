package telran.strings;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import telran.strings.*;

public class JoinStringsPerformanceAppl {

	private static final int N_STRINGS = 1000;
	private static final int N_RUNS = 1000;
	private static final String BASE_PACKAGE = "telran.strings.";

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		String[] strings = getStrings();
	//	String testNameString = getTestName("JoinStringsImpl");
	//	String testNameStringBuilder = getTestName("JoinStringsBuilderImpl");
		if(args.length < 1) {
			System.out.println("Too few arguments: must be name of class");
		} else {
			try {
				Class<JoinStrings> clazz = (Class<JoinStrings>) Class.forName(BASE_PACKAGE + args[0]);
				Constructor<JoinStrings> constructor = clazz.getConstructor();
				JoinStrings joinStrings = constructor.newInstance();
				String testNameString = getTestName(args[0]);
				JoinStringsPerformanceTest testString = new JoinStringsPerformanceTest(testNameString, N_RUNS, strings,
						joinStrings);
				testString.run();
			} catch (ClassNotFoundException e) {
				System.out.println("Wrong className:  " + args[0]);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
	
		//JoinStringsImpl jsi = new JoinStringsImpl();
		//JoinStringsBuilderImpl jsbi = new JoinStringsBuilderImpl();
	/*
		JoinStringsPerformanceTest testStringBuilder =
				new JoinStringsPerformanceTest(testNameStringBuilder, N_RUNS,
strings, jsbi);
		JoinStringsPerformanceTest testString =
				new JoinStringsPerformanceTest(testNameString, N_RUNS,
strings, jsi);
		testStringBuilder.run();
		testString.run();
		*/
	}

	private static String getTestName(String className) {
		
		return String.format("%s; Number of the strings is %d", className, N_STRINGS);
	}

	private static String[] getStrings() {
		String[] res = new String[N_STRINGS];
		Arrays.fill(res, "string");
		return res;
	}

}