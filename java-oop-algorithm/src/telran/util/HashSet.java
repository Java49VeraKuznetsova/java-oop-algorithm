package telran.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;



public class HashSet<T> implements Set<T> {
    private static final int DEFAULT_HASH_TABLE_SIZE = 16;
	private int size;
    private LinkedList<T>[] hashTable;
    
    private class HashSetIterator implements Iterator<T> {
        boolean flNext = false;
        int currentIndex = 0;
        int currentIndexList = 0;
        LinkedList<T> currentList = hashTable[0];
		T res = null;
        T prev = null;
        // T current = currentList[currentIndexList];
       // T current = currentList.
        int prevIndex = -1;
        //TODO
       
     
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			while (currentIndex < hashTable.length && 
				  (currentList == null || 
				  // this is from webinar ??
				  currentList.size() == 0 ||
				  currentIndexList == currentList.size())) {
		            
			    currentIndex++;
				currentList = hashTable[currentIndex];
				currentIndexList = 0;
			}
					
			
			return currentIndex < hashTable.length;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
		  
			res = currentList.get(currentIndexList);
			
			//if (res != null) {
				flNext = true;
				
				currentIndexList++;
				prev = res;
				prevIndex = currentIndex;
			
		//	}
						
			return res;
		}
		@Override 
		public void remove() {
			//TODO
			if(!flNext) {
				throw new IllegalStateException();
			}
			
			hashTable[prevIndex].remove(prev);
			flNext = false;
			size--;
		}
    }
		@SuppressWarnings ("unchecked")
    	public HashSet(int hashTableSize) {
    		hashTable = new LinkedList[hashTableSize];
        	}
		
		public HashSet() {
			this(DEFAULT_HASH_TABLE_SIZE);
		}
    
	@Override
	public Iterator<T> iterator() {
		return new HashSetIterator();
	}

	@Override
	public boolean add(T obj) {
		boolean res = false;
		if(size >= 0.75 * hashTable.length) {
			recreation();
		}
		int index = getHashTableIndex(obj);
		if (hashTable[index] == null) {
			hashTable[index] = new LinkedList<>();
		}
		if (!hashTable[index].contains(obj)) {
			hashTable[index].add(obj);
			size++;
			res = true;
		}
		
		return res;
	}

	private void recreation() {
		
		HashSet<T> tmp = new HashSet<>(hashTable.length *2);
		for(int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null) {
				for (T obj : hashTable[i]) {
					tmp.add(obj);
				} 
			}
		} 
		this.hashTable = tmp.hashTable;
	}
	
      private int getHashTableIndex(T obj) {
		
		return Math.abs(obj.hashCode()) % hashTable.length;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean remove(T pattern) {
		boolean res = false;
		int index = getHashTableIndex(pattern);
		if (hashTable[index] != null) {
			res = hashTable[index].remove(pattern);
					}
		if (res) {
			size --; 
		}
		return res;
	}

	@Override
	public boolean contains(T pattern) {
		
			int index = getHashTableIndex(pattern);
			return hashTable[index] != null && 
					hashTable[index].contains(pattern);
	}

	@Override
	//FIXME method should be remove after writing iterator
	public T[] toArray(T[] ar) {
		int size = size();
		if (ar.length < size) {
			ar = Arrays.copyOf(ar, size);
		}
		int index = 0;
		// ЭТОТ МЕТОД ДОЛЖЕН БЫТЬ ПОСЛЕ ИФ, сейчас строка 124
		/*
		for(T obj: this) {
			ar[index++] = obj;
		}
		*/
		for (int i = 0; i < hashTable.length; i++) {
			LinkedList<T> list = hashTable[i];
			
		
			if (list != null) {
				
				//for(T obj: list) {
				for(T obj: this) {	
				ar[index++] = obj;
				}
			}
			
			
		}
		if (ar.length > size) {
			ar[size] = null;
		}

		return ar;
	
	}
   
}
