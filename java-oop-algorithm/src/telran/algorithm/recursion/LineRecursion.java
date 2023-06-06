package telran.algorithm.recursion;

public class LineRecursion {
    public static long factorial (int n) {
    	long res =1;
    	if (n < 0) {
    		throw new IllegalArgumentException("Cannot be negative value");
    	}
    	if(n > 1) {
    		res = n * factorial(n-1);
    	}
    	return res;
    }
    public static long pow(int a, int b) {
    	//a - any number
    	//b - any positive number or zero
    	if (b < 0) {
    		throw new IllegalArgumentException("Pow cannot be negative value");
    	    	}
    	long res = 1;
    	if (b > 0) {
    		res = a * pow (a, b-1); // a^b = a * a^(b-1)
    	
    	}
    	return res;
    }
    
    public static long power(int a, int b) {
    	//a - any number
    	//b - any positive number or zero
    	if (b < 0) {
    		throw new IllegalArgumentException("Pow cannot be negative value");
    	    	}
    int aAbs = Math.abs(a);
	
	long res = aAbs;
	if (b>0) {
	
          res += power(a, b-1);
	}
    	return sumNumber(a);
    }
    
    public static long sumNumber(int a) {
		// TODO Auto-generated method stub
    	//long sum = 1;
    	int aAbs = Math.abs(a);
    	int count = 1;
    	long sum = aAbs;
    	if (aAbs < 2) {
			sum = aAbs;
		} else if (count < aAbs) {
    	
    		sum+= (aAbs-count)+sumNumber(aAbs-1); 
    		count=count-1;
    	}
    	
		return sum;
	}
	public static long sum (int[] array) {
    	return sum(0, array);
    }
	private static long sum(int firstIndex, int[] array) {
		long sum = 0;
		if(firstIndex < array.length)
		{
			sum = array[firstIndex] + sum(firstIndex+1, array);
		}
		return sum; 
	}
	public static int [] reverse (int[] array) {
		return reverse(array, 0, array.length-1);
	}
	private static int[] reverse(int[] array, int left, int right) {
		
		if(left < right) {
			array[left] = array[left] + array[right];
			array[right] = array[left] - array[right];
			array[left] = array[left] - array[right];
			reverse(array, left+1, right -1);
		}
		return array;
	}
	public static long square(int x) {
				// no cycles
		//only arithmetic operation +
		//no static variables
		//no additional fields
		// x  any int number;
		int xAbs = Math.abs(x);
		long res=xAbs;
		int count = 1;
		
		if (xAbs < 2) {
			res = xAbs;
		} else if (count < xAbs) {
			
			res+= (xAbs-count)+square(xAbs-1);
			count=count+1;
			
		}
	
		return res;
	}
	public static boolean isSubstring(String string, String substr) {
		// TODO write function
		// returns true if a given 'substr' is indeed the //substring of a given `string`
		/* Challenges: 1. To apply only following methods of the class String: charAt(int ind); 
		String substring(int ind);
		 int length();
		2. No cycles;*/
		char currentSymbol = string.charAt(0);
		
				
		return false;
	}


}
