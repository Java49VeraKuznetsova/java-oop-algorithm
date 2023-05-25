package telran.util.test;

import telran.util.*;

public class HashSerTest extends SetTest {

	@Override
	protected <T> Set<T> getSet() {
		
		return new HashSet<>(3);
	}

}
