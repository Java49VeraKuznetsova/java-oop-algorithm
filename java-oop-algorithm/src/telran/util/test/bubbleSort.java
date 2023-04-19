package telran.util.test;

import java.util.Comparator;

// better correct name to IntegerComparator
public class bubbleSort implements Comparator<Integer> {

	@Override
	public int compare(Integer num1, Integer num2) {
		
		return Integer.compare(num1, num2);
		// or return num1.compareTo(num2);
		
	}
	
	

}
