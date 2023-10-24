package telran.strings;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import telran.strings.*;

public class JoinStringsPerformanceAppl {

	private static final int N_STRINGS = 1000;
	private static final int N_RUNS = 1000;
	private static final String BASE_PACKAGE = "telran.strings.";

	@SuppressWarnings("unchecked")
	public static void main(String[] args)  {
		
		if(args.length < 1) {
			System.out.println("Too few arguments: must be name of class");
		} else {
			String[] strings = getStrings();
					
				for(String className : args) {
			try {
				Class<JoinStrings> clazz = (Class<JoinStrings>) Class.forName(BASE_PACKAGE + className);
				Constructor<JoinStrings> constructor = clazz.getConstructor();
				JoinStrings joinStrings = constructor.newInstance();
				String testNameString = getTestName(className);
				JoinStringsPerformanceTest testString = new JoinStringsPerformanceTest(testNameString, N_RUNS, strings,
						joinStrings);
				testString.run();
			} catch (ClassNotFoundException e) {
				System.out.println("Wrong className:  " + className);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			}
		}
	
	
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