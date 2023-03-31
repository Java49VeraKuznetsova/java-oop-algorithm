package telran.util;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
	//for one test only!
private static final int DEFAULT_CAPACITY = 5;
//private static final int DEFAULT_CAPACITY = 16;
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		
		return array[index];
	}

}
