package JavaInterviewQueston;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection_Of_Two_Arrays {

//	Write a method to compute the intersection (common elements) of two arrays of integers
//
//	arr1 = [1,4,4,4,3,2,2,2,5,7]
//	arr2 = [1,1,4,4,3,3,2,2,6]
//	ans = [1,4,4,3,2,2]

	public static List<Integer> computeIntersection2(int[] arr1, int[] arr2){	
	    if(arr1==null || arr2==null) return null;
	    List<Integer> result = new ArrayList<Integer>();
	    Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
	    Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
	    for(int i = 0; i< arr1.length; i++){
	        if(!map1.containsKey(arr1[i])){
	            map1.put(arr1[i], 1);
	        }else{
	            map1.put(arr1[i], map1.get(arr1[i])+1);
	        }
	    }
	    for(int i = 0; i< arr2.length; i++){
	        if(!map2.containsKey(arr2[i])){
	            map2.put(arr2[i], 1);
	        }else{
	            map2.put(arr2[i], map2.get(arr2[i])+1);
	        }
	    }
	   
	    for(Integer key: map2.keySet()){
            int count = map2.get(key);
            for(int j = 0; j<count; j++){
                result.add(key);
            }
	    }
	    
	    return result;
	}
	
public static List<Integer> computeIntersection1(int[] arr1, int[] arr2){	
    if(arr1==null || arr2==null) return null;
    List<Integer> result = new ArrayList<Integer>();
    Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
    Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
    for(int i = 0; i< arr1.length; i++){
        if(!map1.containsKey(arr1[i])){
            map1.put(arr1[i], 1);
        }else{
            map1.put(arr1[i], map1.get(arr1[i])+1);
        }
    }
    for(int i = 0; i< arr2.length; i++){
        if(!map2.containsKey(arr2[i])){
            map2.put(arr2[i], 1);
        }else{
            map2.put(arr2[i], map2.get(arr2[i])+1);
        }
    }
   
    for(Integer key: map1.keySet()){
        if(map2.containsKey(key)){
            int count = Math.min(map1.get(key), map2.get(key));
            for(int j = 0; j<count; j++){
                result.add(key);
            }
        }
    }
    
    return result;
}
public static int[] computeIntersection(int[] arr1, int[] arr2){
    if(arr1==null || arr1.length == 0) return null;
    if(arr2==null || arr2.length == 0) return null;

	Arrays.sort(arr1);
	Arrays.sort(arr2);
    
    int len1 = arr1.length;
    int len2 = arr2.length;
    
    int i = 0;
    int j = 0;
    while(i < len1){
    	int prevVal = arr1[i];
    	while( j < len2 && arr2[j] < prevVal){
    		j++;
    	}
    	if(j == len2){
    		arr1[i++] = Integer.MIN_VALUE;
    		continue;
    	} 
    	
    	while(i<len1 && j<len2 && arr2[j] == arr1[i]){
    		i++;
    		j++;
    	}
    	while( i < len1 && arr1[i]== prevVal){
    		arr1[i] = Integer.MIN_VALUE;
    		i++;
    	}
    }
    
	return arr1;
}

    public static int[] computeIntersection3(int[] arr1, int[] arr2){
        if(arr1==null || arr1.length == 0) return null;
        if(arr2==null || arr2.length == 0) return null;

Arrays.sort(arr1);
Arrays.sort(arr2);
        
        int len1 = arr1.length;
        int len2 = arr2.length;
        
        int i = 0;
        int j = 0;
        while(i < len1){
        	int prevVal = arr1[i];
        	while( j < len2 && arr2[j] < prevVal){
        		j++;
        	}
        	if(j == len2){
        		arr1[i++] = Integer.MIN_VALUE;
        		continue;
        	} 
        	
        	while(i<len1 && j<len2 && arr2[j] == arr1[i]){
        		i++;
        		j++;
        	}
        	while( i < len1 && arr1[i]== prevVal){
        		arr1[i] = Integer.MIN_VALUE;
        		i++;
        	}
        }
//        int left = 0;
//        int right = len1;
//        while(left<right){
//        	while(left<right && arr1[left]!=Integer.MIN_VALUE){
//        		left++;
//        	}
//        	while(left< len1 && right < len1 && left<right && arr1[right]!= Integer.MIN_VALUE ){
//        		right --;
//        	}
//        	if(left< len1 && right < len1 && left<right){
//        		arr1[left]^=arr2[right];
//        		arr1[right]^=arr2[left];
//        		arr1[left]^=arr2[right];
//        	}
//   
//        }
        
		return arr1;
    }
	    public static void main(String[] args) {
//	    	int[] arr1 = {1,4,4,4,3,2,2,2,5,7};
//	    	int[] arr2 = {1,1,4,4,3,3,2,2,6};
	    	int[] arr2 = {1,4,8,4,8,4,3,2,8,2,2,5,7};
	    	int[] arr1 = {8,1,1,2,8,8,2,3,3,4,8,4,6,7,8,7,7,8};
//	    	ans = [1,4,4,3,2,2]
//	    	Arrays.sort(arr1);
//	    	Arrays.sort(arr2);
	    	System.out.println(Arrays.toString(arr1));
	    	System.out.println(Arrays.toString(arr2));
	    	Arrays.sort(arr1);
	    	Arrays.sort(arr2);
	    	System.out.println(Arrays.toString(arr1));
	    	System.out.println(Arrays.toString(arr2));
	    	System.out.println(Arrays.toString(computeIntersection(arr1, arr2)));

	    	System.out.println(computeIntersection1(arr1,arr2));

	    }
	
}
