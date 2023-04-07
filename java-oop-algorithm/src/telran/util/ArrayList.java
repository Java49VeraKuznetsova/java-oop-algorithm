package telran.util;

import java.util.Arrays;

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
		// Auto-generated method stub
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
		//  Auto-generated method stub
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
		//  Auto-generated method stub
		T res = array[index];
		return res;
	}
	@Override
	public boolean remove(T pattern) {
		// TODO Auto-generated method stub
		int index = indexOf(pattern);
		boolean res = false;
		if (index >= 0) {
			remove(index);
			res= true;
		}
		
		return res;
	}
	@Override
	public T[] toArray(T[] array) {
		// TODO Auto-generated method stub
		T[] arrayNew  = array;
		//Integer[] arr1 = new Integer[list.size()];
		if (arrayNew.length < size) {
			
			arrayNew = Arrays.copyOf(array, size);
		//	arrayNew = (T[]) Arrays.copyOf(array, size, arrayNew.getClass());
		/*	
			arrayNew = (T[])new Object[size];
			System.arraycopy(array, 0, arrayNew, 0, size);
			*/
		}
		else {
			System.arraycopy(array, 0, arrayNew, 0, size);
			if (arrayNew.length > size) {
				arrayNew[size] = null;
			}
		}
		return arrayNew;
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
		// TODO Auto-generated method stub
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

}
