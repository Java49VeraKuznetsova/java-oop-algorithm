package telran.strings;

public abstract class PerformanceTest {
 String testName;
 int nRuns;
 
 public PerformanceTest(String testName, int nRuns) {
	this.testName = testName;
	this.nRuns = nRuns;
}
 
/*
 public String getTestName() {
	return testName;
}

public void setTestName(String testName) {
	this.testName = testName;
}

public int getnRuns() {
	return nRuns;
}

public void setnRuns(int nRuns) {
	this.nRuns = nRuns;
}
*/
protected abstract void runTest();
 
 public void run() {
	 long timesBegin = System.currentTimeMillis();
	 for (int i = 0; i < nRuns; i++) {
		 runTest();
	 }
	 long timesEnd = System.currentTimeMillis();
	 System.out.println("Value of nRun:  " + nRuns);
	 System.out.println("Test name: " + testName);
	 System.out.println("Running time: " + (timesEnd-timesBegin));
	 
 }
}
