package telran.algorithm;

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
		 boolean flUnSort = true;
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
	 // loop doesn't end
	 public static boolean isSum(short[]array, short sum) {
		 //returns true if there are two numbers in the given array,
		 //sum of which equals the given sum value
		 //Otherwise false
		 //TODO
	    sortShortPositive(array);
		
		 int begInd  = 0;
		 int endInd = array.length-1;
		 boolean fl = false;
		 
		 do {
			 //why additional short?
			 short curSum = (short) (array[begInd]+array[endInd]);
			 if (curSum < sum) {
				 begInd++;
			 }
			 else if (curSum > sum) {
				 endInd--;
			 }
			 else {
				 fl = true;
				 }
		 } while(begInd != endInd);
		 
		 return fl;
	 }
	 // error
	 public static short getMaxPositiveWithNegativeReflect(short[] array) {
		 //return maximal positive number, for which there is the negative image
		 //if there are not such numbers at all the method returns -1
		 //TODO
		 short res = -1;
		 int begInd = 0;
		 int endInd = array.length-1;
		 sortShortPositive(array);
		 do {
			 if (Math.abs(array[begInd]) > array[endInd]) {
				 begInd++;
			 }
			 else if (Math.abs(array[begInd]) < array[endInd]) {
				 endInd--;
			 }
			 else {
				if (array[endInd] > res) {
					res = array[endInd];
					 begInd++;
				
				}
			 }
		 } while (begInd != endInd || array[begInd]<0);
		 return res;
	 }

}
