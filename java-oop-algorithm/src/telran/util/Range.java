package telran.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import telran.util.LinkedList;

public class Range implements Iterable<Integer> {
	private int min;
	private int max;
	private int prevEl;
	// Collection - in webinar
	//List<Integer> list; // as on webinar
	List<Integer> list = new LinkedList<Integer>();
	public Range(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("min must be less than max");
		}
		this.min = min;
		this.max = max;
		//
		//list = new LinkedList<Integer>(); // as on webinar
	}
	private class RangeIterator implements Iterator<Integer> {
		int current = min;
		boolean flNext = false;
		
		
		
		@Override
		public boolean hasNext() {
			
			while (list.contains(current)&& current < max) {
				current++;
			}
			
			return current < max;
		}

		@Override
		public Integer next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			
			prevEl = current;
			flNext = true;
			return current++;
			
		}
		@Override
		public void remove() {
			//TODO
			if(!flNext) {
				throw new IllegalStateException();
			}
		
				list.add(prevEl);
				flNext = false;
							
		}	
		
	}
	
	@Override
	public Iterator<Integer> iterator() {
		
		return new RangeIterator();
	}
	public Integer[] toArray() {
		//!!
		//Integer [] array = new Integer[max - min];
		Integer[] array = new Integer[max - min - list.size()];
		int index = 0;
		//First way
//		for(Integer num: this) {
//			array[index++] = num;
//		}
		//Second way
		Iterator<Integer> it = iterator();
		while(it.hasNext()) {
			array[index++] = it.next();
		}
		
		return array;
	}
	public boolean removeIf(Predicate<Integer> predicate) {
		//TODO
		int oldSize = max-min-list.size();
		Iterator<Integer> it = iterator();
		while (it.hasNext()) {
			Integer num = it.next();
			if(predicate.test(num)) {
				it.remove();
				}
		}
		
		
		return oldSize < list.size();
	}
	

}