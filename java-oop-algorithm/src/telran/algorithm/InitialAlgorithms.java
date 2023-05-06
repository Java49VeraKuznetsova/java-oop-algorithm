package telran.algorithm;

import java.util.Comparator;

public class InitialAlgorithms {
	 public static void sortShortPositive(short [] array) {
		 //array - array of the positive short numbers
		 int [] helper = new int[Short.MAX_VALUE]; 
		 //helper[index] => count of occurrences for number index of array
		 //helper[1000] =2 => number 1000 occurs twice in the source array
		 //helper[2] = 0; => now number 2 in sours array
		 for(int i = 0; i < array.length; i++) {
			 helper[array[i]]++;
		 }
		 int ind =0;
		 for(int i=0; i<helper.length; i++) {
			 for(int j= 0; j<helper[i]; j++) {
				 array[ind++]=(short) i;
			 }
		 }
		 
	 }
	 
	 public static void bubbleSort(short[] array) {
		 int n = array.length;
		 //boolean flUnSort = true;
		 //Yuri:
		 boolean flUnSort = false;
		 do {
			 flUnSort = false;
			 n--;
			 for (int i = 0; i<n; i++) {
				 if (array[i]>array[i+1]) {
					 swap (i, array);
					 flUnSort = true;
				 }
			 }
		 } while (flUnSort);
		 
	 }
	 // why static??
	 private static void swap(int i, short[] array) {
			short tmp = array[i];
			array[i] = array[i + 1];
			array[i + 1] = tmp;
			
		}
	 // Yuri's code
	 
	 
	 
	 
	 
	 
	 public static boolean isSum2(short[]array, short sum) {
		 // array of the positive short numbers
		 //returns true if there are two numbers in the given array,
		 //sum of which equals the given sum value
		 //Otherwise false
		 int helperSize = sum < 0 ? Short.MAX_VALUE + 1 : sum + 1;
			boolean[] helper = new boolean[helperSize];
			boolean res = false;
			int index = 0;
			while (index < array.length && !res) {
				short value = array[index];
				short secondValue = (short) (sum - value);
				if (secondValue >= 0) {
					if (helper[secondValue]) {
						res = true;
					} else {
						helper[value] = true;
					}
				}
				index++;
			}
			return res;
	   
	 
	 }
	 
	
	 public static short getMaxPositiveWithNegativeReflect(short[] array) {
		 //return maximal positive number, for which there is the negative image
		 //if there are not such numbers at all the method returns -1
		 //TODO
			short res = -1;
			byte[] helper = new byte[Short.MAX_VALUE];
			short candidate = -1;
			for (int i = 0; i < array.length; i++) {
				candidate = (short) Math.abs(array[i]);
				if (array[i] < 0) {

					res = getRes(res, helper, candidate, 1);
				} else {
					res = getRes(res, helper, candidate, -1);
				}
			}

			return res;
	 }

	 private static short getRes(short res, byte[] helper, short candidate, int sign) {
			if (helper[candidate] == 1 * sign && candidate > res) {
				res = candidate;
			} else if (helper[candidate] == 0) {
				helper[candidate] =  (byte) (-1 * sign);
			}
			return res;
		}
	 // CW 8
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
	public static <T> int binarySearch2(T [] array, T key, Comparator<T> comp) {
		int leftIndex = 0;
		int rightIndex = array.length-1;
		int middleIndex = rightIndex / 2;
		int compRes = 0;
		int currentIndex=-1;
		int res = -1;
		
		do {
			
		
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
		if (leftIndex <= rightIndex) {
			currentIndex = middleIndex;
			rightIndex = middleIndex-1;
			middleIndex = (leftIndex+rightIndex)/2;
		}
		} while (leftIndex <= rightIndex);
		
		
		
		return currentIndex;
	
	}
	// HW 8
	public static <T> int binarySearch(T[] array, T key, Comparator<T> comp) {
		int left = 0;
		int right = array.length - 1;
		int middle = right / 2;
		while (left <= right && comp.compare(key, array[left])!= 0) {
			if (comp.compare(key, array[middle]) <= 0) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (right + left) / 2;
		}
		return left < array.length && comp.compare(key, array[left])== 0 ?
				left : -left - 1;
	}
}



