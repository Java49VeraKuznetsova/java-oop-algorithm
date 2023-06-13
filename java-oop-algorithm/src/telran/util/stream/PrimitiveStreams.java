package telran.util.stream;

import java.util.Random;

import telran.util.ArrayList;

public class PrimitiveStreams {
      static public int [] randomUnique (int nNumbers, int minInclusive, 
    		  int maxExclusive) {
    	  if (maxExclusive - minInclusive < nNumbers) {
    		  throw new IllegalArgumentException("imposibble to get the given amount of unique random numbersarray");
    	  }
    	  return new Random().ints(minInclusive, maxExclusive)
    			  .distinct()
    			  .limit(nNumbers)
    			  .toArray();
    			 
      }
      static public int [] shuffle(int[] array) {
    	  ArrayList <Integer> indexes = new ArrayList<>(array.length);
   	  
    	  new Random().ints(0, array.length)
    	  .distinct().
    	  limit(array.length).
    	  forEach(el -> indexes.add(array[el]));
    	  
    	  return indexes.stream()
    			  .mapToInt(n -> n)
    			  .toArray();
    	
    	    	
    	  
      }
      
      }
     
     

