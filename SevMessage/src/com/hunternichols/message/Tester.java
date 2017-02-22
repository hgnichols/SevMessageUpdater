package com.hunternichols.message;

import java.util.Arrays;

public class Tester {

	public static void main(String args[]) {

		System.out.println(new Tester().findMissingNumber("1 3 4 5"));
	}

	public int findMissingNumber(String sequence) {	
	      int missing = 0;
	    
	      String numbersTemp[] = sequence.split(" ");
	      int numbers[] = new int[numbersTemp.length];
	      int numberToCompare[] = new int[numbersTemp.length];
	      
	      for(int x = 0; x < numbersTemp.length; x++) {
	    	  
	    	  try {
	    		  
	    		  numbers[x] = Integer.parseInt(numbersTemp[x]); 
	    	  } catch (NumberFormatException e) {
	    		  
	    		  if(sequence.trim().length() == 0) {
	    			  
	    			  return 0;
	    		  } else {
	    			  
	    			  return 1;   
	    		  }
	    	  }
	    	  
	      }
	      
	      Arrays.sort(numbers);
	      for(int x = 0; x < numbersTemp.length; x++) {
	    	  
	    	  numberToCompare[x] = x + 1;
	      }
	      
	      for(int x = 0; x < numbers.length; x++) {
	    		  
	    	  if(numberToCompare[x] != numbers[x]) {
	    		  
	    		  return numberToCompare[x];
	    	  }
	      }
	      return missing;
	    }
}
