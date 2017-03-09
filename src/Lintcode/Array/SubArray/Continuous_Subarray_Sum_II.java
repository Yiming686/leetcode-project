package Lintcode.Array.SubArray;

/**

Continuous_Subarray_Sum

Return Max Subarray Sum


Given an array of integers (positive and negative) find the largest continuous sum.
input: 1, -3, 5, 2, 4, 7, -8, 5, 2, 19
output: 5 + 2 +4 +7 -8 + 5+2+19 = 36

input: 1, -3, 5, 2, 4, 7, -8, 5, 2
output: 5 + 2 +4 +7 = 18

 *
 *
 */
public class Continuous_Subarray_Sum_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, -3, 5, 2, 4, 7, -8, 5, 2, 19};
		System.out.println(""+getLargestCountinousSum2(arr));
		arr = new int[]{1, -3, 5, 2, 4, 7, -8, 5, 2};
		System.out.println(""+getLargestCountinousSum2(arr));
	}

	public static int getLargestCountinousSum(int[] array){
	    if(array == null || array.length == 0){
	        throw new IllegalArgumentException();
	    }
	    
	    int localMax  = array[0];
	    int globalMax = array[0];
	    
	    int len = array.length;
	    
	    for(int i = 1; i < len; i++){
	    	System.out.println("localMax,globalMax:: "+localMax +", "+ globalMax);
	          if(localMax < 0){
	              localMax = array[i];  
	          }else{
	              localMax = localMax + array[i];                  
	          }       
	          if(localMax > globalMax){
	            globalMax = localMax;                 
	          }         
	    }
	    return globalMax;
	}
	
	public static int getLargestCountinousSum2(int[] array){
	    if(array == null || array.length == 0){
	        throw new IllegalArgumentException();
	    }
	    
	    int localMax  = 0;
	    int globalMax = 0;
	    
	    int len = array.length;
	    
	    for(int i = 0; i < len; i++){
	    	System.out.println("localMax,globalMax:: "+localMax +", "+ globalMax);
	          localMax = Math.max(array[i], localMax+array[i]);
	          globalMax = Math.max(globalMax, localMax);
	    }
	    return globalMax;
	}

	
}
