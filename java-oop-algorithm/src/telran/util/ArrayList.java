package telran.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class ArrayList<T> implements List<T> {
	//for one test only!
//private static final int DEFAULT_CAPACITY = 5;
private static final int DEFAULT_CAPACITY = 16;
private T[] array;
private int size;
@SuppressWarnings("unchecked")
public ArrayList(int capacity) {
	array = (T[]) new Object[capacity];

}
public ArrayList() {
	this(DEFAULT_CAPACITY);
}
	@Override
	public boolean add(T obj) {
		if(size == array.length) {
			reallocate();
		}
		array[size] = obj;
		size++;
		return true;
	}
private void reallocate () {
	array = Arrays.copyOf(array, array.length*2);
}
	@Override
	public int size() {
		
		return size;
	}

	@Override
	public void add(int index, T obj) {
		  
			checkIndexException(index, size, false);
		/*
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(index);
		}
		*/
		if(size == array.length) {
			reallocate();
		}
		//System.arraycopy(array, 0, array, 0, index);
		
	 System.arraycopy(array, index, array, index+1, size-index);
		
		array[index] = obj;
		size++;
		
		
	}

	@Override
	public T remove(int index) {
		// repeat of the code here and in get:
		/*
   if (index <0 || index >= size) {
	   throw new IndexOutOfBoundsException(index);
   }

  */
    checkIndexException(index, size, true);
		T remObj = array[index];
		//this is not necessary, because doesn't copy array
		//System.arraycopy(array, 0, array, 0, index);
		System.arraycopy(array, index+1, array, index, size-1-index);
		// here we copy end with nulls
	  //  System.arraycopy(array, index, array, index+1, array.length-1-index);
	    size--;
		return remObj;
	}

	@Override
	public T get(int index) {
		// repeat of the code here and in remove and in add:
				/*
		   if (index <0 || index >= size) {
			   throw new IndexOutOfBoundsException(index);
		   }

		  */
		checkIndexException(index, size, true);
		
		T res = array[index];
		return res;
	}
	
	private static void checkIndexException(int index, int size, boolean eq) {
		if (eq) {
		if (index <0 || index >= size) {
			   throw new IndexOutOfBoundsException(index);
		   }
		} else {
			if (index <0 || index > size) {
				   throw new IndexOutOfBoundsException(index);
			   }
		}
	}
	@Override
	public boolean remove(T pattern) {
	
		int index = indexOf(pattern);
		boolean res = false;
		if (index >= 0) {
			remove(index);
			res= true;
		}
		
		return res;
	}

	@Override
	public int indexOf(T pattern) {
		int res = -1;
		int index = 0;
		while (index < size && res == -1) {
			if (isEqual(array[index], pattern)) {
				res = index;
			}
			index++;
		}
		return res;
	}
	private boolean isEqual(T object, T pattern) {
		
		return pattern == null ? object == pattern :
			pattern.equals(object);
	}
	@Override
	public int lastIndexOf(T pattern) {
		int res = -1;
		int index = size-1;
		while (index >= 0 && res == -1) {
			if (isEqual(array[index], pattern)) {
				res = index;
			}
			index--;
		}
		
		return res;
	}
	// Yuri's code
	@Override
	public T[] toArray(T[] ar) {
		if (ar.length < size) {
			ar = Arrays.copyOf(ar, size);
		}
		System.arraycopy(array, 0, ar, 0, size);
		if (ar.length > size) {
			ar[size] = null;
		}

		return ar;
	}
	
	@Override
	public void sort() {
		Arrays.sort(array, 0, size);
		
	}
	
	/*
	@Override
	public void sort() {
		sort((Comparator<T>)Comparator.naturalOrder());
		}
*/
	/*
	@Override
	public void sort(Comparator<T> comp) {
		Arrays.sort(array,  0, size, comp);
					
	}
	*/
	@Override
	public void sort (Comparator<T> comp) {
		// may by shorter - as a webinar
		for (int i=0; i<size-1; i++) {
           for (int j=0; j<size-1-i; j++) {
          if(comp.compare(array[j], array[j+1])>0){
        	 T tmp = array[j+1];
        	 array[j+1] = array[j];
        	 array[j] = tmp;
        	}
			}
		}
		
	}
	@Override
	public int indexOf(Predicate<T> predicate) {
		int res = -1;
		int index = 0;
		while (index < size && res == -1) {
			if (predicate.test(array[index])) {
				res = index;
			}
			index++;
		}
		return res;
		
	}
	@Override
	public int lastIndexOf(Predicate<T> predicate) {
		//  Auto-generated method stub
		int res = -1;
		int index = size-1;
		while (index >= 0 && res == -1) {
			if (predicate.test(array[index])) {
				res = index;
			}
			index--;
		}
		return res;
	}
	@Override
	public boolean removeIf(Predicate<T> predicate) {
		//  Auto-generated method stub
		/* This is my code
		boolean res = false;
	
		for (int i=size-1; i>=0; i--) {
			if (predicate.test(array[i])) {
				remove(i);
				res = true;  
			}
		}
	
		return res;
		*/
		int oldSize = size;
		//int i=0;
		/* correct from Yuri
		while (i < size) {
			if (predicate.test(array[i])) {
				remove(i);
			} else {
				i++;
			}
		}
		
		*/
		// code in CW 
		for (int i = size -1; i>=0; i--) {
			if (predicate.test(array[i])) {
				remove(i);
			}
		}
		return oldSize > size;
	}

	
	

	

}
