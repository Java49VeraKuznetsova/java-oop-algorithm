package telran.algorithm;

public class MemoryService {
public static int getMaxAvailableSize() {

	
//	boolean running = true;
	int left = 0;
	int right = Integer.MAX_VALUE;
	int middle = right/2;
	int res=0;

	
	
	while (left<= right) {
		
		try {
			byte[]array = new byte[middle];
			//running = false;

			left = middle+1;
			res = middle;
			array = null;
	
			
		} catch(OutOfMemoryError e) {
			
			right = middle-1;
	
		}
	
		middle = left/2 + right/2;
	}
	return res;
	
}
}
/*
public static <T> int binarySearch(T [] array, T key, Comparator<T> comp) {
	int leftIndex = 0;
	int rightIndex = array.length-1;
	int middleIndex = rightIndex / 2;
	int compRes = 0;
	while (leftIndex <= rightIndex && 
			(compRes = comp.compare(key, array[middleIndex])) != 0) {
	if (compRes > 0) {
		//move to right part of the array
		leftIndex = middleIndex+1;
			} else {
				rightIndex = middleIndex -1;
			}
	middleIndex = (leftIndex+rightIndex)/2;
	}
	return leftIndex > rightIndex ? -1 : middleIndex;

}
*/