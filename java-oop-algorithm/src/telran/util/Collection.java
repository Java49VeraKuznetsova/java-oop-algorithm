package telran.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Predicate;

public interface Collection<T> extends Iterable<T>{
boolean add(T obj);
int size();
boolean remove(T pattern);
//T[] toArray(T[] array);
boolean removeIf(Predicate<T> predicate);
boolean contains(T pattern);

default boolean isEqual(T object, T pattern) {

	return pattern == null  ? object == pattern : pattern.equals(object);
}

default T[] toArray(T[] ar) {
	int index=0;
	int size = size();
	Iterator<T> it = iterator();
		
	if (ar.length < size) {
		ar = Arrays.copyOf(ar, size);
	}
	
	while(it.hasNext()) {
		 ar[index++]= it.next();
	 }

	
	if (ar.length > size) {
		ar[size] = null;
	}
	
	return ar;
}
}
