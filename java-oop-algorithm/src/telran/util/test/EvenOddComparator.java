package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer num1, Integer num2) {
		int res = -1;
		if (num1 % 2 == 0 && num2 % 2 == 0) 
			{
			res = Integer.compare(num1, num2);
			} 
		else if (num1 % 2 != 0 && num2 % 2 != 0)
		     {
				res = Integer.compare(num2, num1);
			}
				
		else if (num1 % 2 != 0 && num2 % 2 == 0)
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