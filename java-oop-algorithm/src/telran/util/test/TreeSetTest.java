package telran.util.test;

import telran.util.Set;
import telran.util.TreeSet;

public class TreeSetTest extends SetTest {

	@Override
	protected <T> Set<T> getSet() {
		// TODO Auto-generated method stub
		
		return new TreeSet<>();
		
	}

}
