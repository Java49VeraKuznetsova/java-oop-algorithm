package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer num1, Integer num2) {
		int res = -1;
		boolean evenNum1 = (num1 % 2 == 0);
		boolean evenNum2 = (num2 % 2 == 0);
		if (evenNum1 && evenNum2) 
			{
			res = Integer.compare(num1, num2);
			} 
		else if (!evenNum1 && !evenNum2)
		     {
				res = Integer.compare(num2, num1);
			}
				
		else if (!evenNum1 && evenNum2)
		{
			res = 1;
		}
	
		return res;
	}

}

/*
 
 return Integer.compare(person2.getAge(),
				person1.getAge());

*/