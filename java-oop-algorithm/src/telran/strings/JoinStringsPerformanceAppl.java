package telran.strings;

public class JoinStringsPerformanceAppl {

	private static final int N_STRINGS = 1000;
	public static void main(String[] args) {
		//  Auto-generated method stub
    String[] strings = getStrings();
      
      
    String testNameBuilder = "JoinStringsBuilderImpl test array contains " + N_STRINGS + " value";
    JoinStrings jsBuilder = new JoinStringsBuilderImpl();
    
    JoinStringsPerformanceTest testBuilder 
    = new JoinStringsPerformanceTest(testNameBuilder,N_STRINGS, strings,jsBuilder);
    testBuilder.run();
    
    String testNameStrings = "JoinStringImpl test array contains " + N_STRINGS + " value";
    JoinStrings jsStrings = new JoinStringsImpl();
  
   JoinStringsPerformanceTest testStrings 
   = new JoinStringsPerformanceTest(testNameStrings, N_STRINGS, strings, jsStrings);
    testStrings.run();
 
	}
	private static String[] getStrings() {
		String [] res = new String [N_STRINGS];
		for(int i = 0; i < N_STRINGS; i++) {
			res[i] = "Hello";
		}
		return res;
	}
}