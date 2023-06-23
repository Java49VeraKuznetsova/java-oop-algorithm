package telran.strings;

public  class JoinStringsPerformanceTest extends PerformanceTest implements JoinStrings {
	String[] strings;
    JoinStrings joinStrings;
	
	public JoinStringsPerformanceTest(String testName, int nRuns, String[] strings, JoinStrings joinStrings) {
	super(testName, nRuns);
	this.strings = strings;
	this.joinStrings = joinStrings;
}
	
// ????????
	@Override
	public String join(String[] strings, String delimiter) {
		//  Auto-generated method stub
		return joinStrings.join(strings, delimiter);
	}


	@Override
	protected void runTest() {
		
		join (strings, "#");
	}

}
