package com.zhandev.array;
import java.util.*;

/**
 * Given an array and a target number, 
 * find a and b in the array meeting the requirement of a + b = target number. 
 *
 */
public class FindAandBInArrayEqualsSum {
	public static void main(String[] args) {
	   
	   int[] array = {5,1,3,6,8,9,2};
	   int number = 9; // if 9 is the target number, the output should be [1,4]
	   
	   // copy the given array 
	   // used to get the index in the original array
	   int[] originalArray = array.clone();
	   
	   Arrays.sort(array);
	   
	   // get the index in the sorted array
	   int[] indexArray = findIndexArray(array, number);
	   
	   // if can't find, print out error message
	   if (indexArray[0] == -1) {
		   System.out.println("Can't find result.");
	   }
	   
	   /*
	    * get index in the original array instead of sorted array
	    */
	   for (int k = 0; k < originalArray.length; k++) {
		   if (array[indexArray[0]] == originalArray[k]) {
			   indexArray[0] = k;
			   break;
		   }
	   }
	   for (int k = 0; k < originalArray.length; k++) {
		   if (array[indexArray[1]] == originalArray[k] && indexArray[0] != k) {
			   indexArray[1] = k;
			   break;
		   }
	   }
	   
	   System.out.println(Arrays.toString(indexArray));  
	}

	public static int[] findIndexArray(int[] array, int targetNumber) {
	    int[] indexArray = new int[2];
	    int anotherNum = 0;
	    int indexOfAnotherNum = -1;
	    
	    for (int i = 0; i < array.length; i++) {
	        anotherNum = targetNumber - array[i];
	        indexOfAnotherNum = biSearch(array, anotherNum);
	        
	        if (indexOfAnotherNum == -1) {
	        	continue;
	        }
	        
	        indexArray[0] = i; 
	        indexArray[1] = indexOfAnotherNum;
	        
	        return indexArray;
	    }

	    int[] errorArray = {-1, -1};
	    return errorArray;
	}

	/*
	 * Another way to find the index array.
	 */
	public static int[] findIndexArray2(int[] array, int targetNumber) {
	    int[] indexArray = new int[2];
	    int i = 0;
	    int j = array.length - 1;
	    
	    while (i <= j) {
	    	if (array[i] + array[j] == targetNumber) {
	    		indexArray[0] = i; 
		        indexArray[1] = j;
	    		return indexArray;
	    	} else if(array[i] + array[j] < targetNumber) {
	    		i++;
	    	} else {
	    		j--;
	    	}
	    }
	    
	    indexArray[0] = -1; 
        indexArray[1] = -1;
 	    return indexArray;
	}

	
	public static int biSearch(int[] array, int targetNumber){
        int low = 0;
        int high = array.length - 1;
        int mid;
        
        while(low <= high){
        	mid = (low + high) / 2;
            if(array[mid] == targetNumber){
                return mid;
            } else if(array[mid] < targetNumber){
                low = mid + 1; 
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
