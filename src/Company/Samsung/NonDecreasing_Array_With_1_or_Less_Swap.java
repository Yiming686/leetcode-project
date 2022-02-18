package Company.Samsung;

import static org.junit.Assert.*;

import org.junit.Test;

public class NonDecreasing_Array_With_1_or_Less_Swap {

	@Test
	public void testBuildNonDecreasingArray(){
		assertTrue(canBuildNonDecreasingArray(new int[]{1}));
		assertFalse(canBuildNonDecreasingArray(new int[]{1,5,8,3}));
		assertTrue(canBuildNonDecreasingArray(new int[]{3,2,1}));
		assertTrue(canBuildNonDecreasingArray(new int[]{1,5,3,3,7}));
		assertTrue(canBuildNonDecreasingArray(new int[]{1,2,3,4,5,6,7,8,9,10}));//sorted, true
		assertFalse(canBuildNonDecreasingArray(new int[]{1,2,3,14,5,6,7,8,9,10}));//false
		assertTrue(canBuildNonDecreasingArray(new int[]{1,2,3,14,5,6,7,8,9,10,4}));//false
		assertFalse(canBuildNonDecreasingArray(new int[]{1,2,8,4,5,6,7,9,10}));//false
		assertFalse(canBuildNonDecreasingArray(new int[]{1,3,9,5,7,8}));//false
		assertTrue(canBuildNonDecreasingArray(new int[]{1,3,7,5,9}));//true
		assertFalse(canBuildNonDecreasingArray(new int[]{1,4,5,6,7,2}));//false
		
		assertTrue(canBuildNonDecreasingArray(new int[]{1,2,5,4,3,6,7,8,9,10}));//true
		assertTrue(canBuildNonDecreasingArray(new int[]{1,2,7,4,5,6,3,8,9,10}));//true

		assertFalse(canBuildNonDecreasingArray(new int[]{1,2,7,4,3,5,6,7,8,9,10}));//false
		assertFalse(canBuildNonDecreasingArray(new int[]{1,2,9,4,5,6,3,7,8,9,10}));//false
		
		assertTrue(canBuildNonDecreasingArray(new int[]{1,2,6,4,4,4,4,6,6,8,9,10}));//true
		assertFalse(canBuildNonDecreasingArray(new int[]{1,2,6,6,4,4,4,4,6,6,8,9,10}));//false
		assertFalse(canBuildNonDecreasingArray(new int[]{1,2,9,4,4,4,4,6,6,8,9,10}));//false
		
		
	}
//	public static boolean canBuildNonDecreasingArray(int[] arr){
//	    if(arr==null)
//	        return false;   
//	    boolean flag=true;
//	    for(int i=0;i<arr.length-1;i++){    
//	        if(arr[i]>arr[i+1]){            
//	            if(flag)
//	                return false;
//	            int j=i+2;
//	            while(j<arr.length && arr[j]>=arr[i+1])
//	                j++;            
//	            if(j>=arr.length)
//	                return false;           
//	            swap(arr, i, j);
//	            flag=true;
//	        }
//	    }
//	    return true;
//	}
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {1,5,8,3};
//		System.out.println(""+canBuildNonDecreasingArray(new int[]{1,5,3,3,7}));
//		System.out.println(""+canBuildNonDecreasingArray(new int[]{1,2,3,14,5,6,7,8,9,10}));
//		System.out.println("True: "+canBuildNonDecreasingArray(new int[]{3,2, 1}));
//		System.out.println("1,2,3,4,5,6,7,8,9,10}: "+canBuildNonDecreasingArray(new int[]{1,2,3,4,5,6,7,8,9,10}));
//		System.out.println("1,2,3: "+canBuildNonDecreasingArray(new int[]{1,2,3}));
//		System.out.println("1,5,8,3: "+canBuildNonDecreasingArray(new int[]{1,5,8,3}));
//		System.out.println("1,8,5,6: "+canBuildNonDecreasingArray(new int[]{1,8,5,6}));
//		System.out.println(""+canBuildNonDecreasingArray(new int[]{1,2,3,10,4,4,4,4,5,6,7,8,9,11,12,13,14,15,16}));
		
//		System.out.println("False: "+canBuildNonDecreasingArray(new int[]{1,2,3,14,5,6,7,8,9,10}));
		System.out.println("False: "+canBuildNonDecreasingArray(new int[]{1,2,3,14,5,6,7,8,9,4}));
//		System.out.println("False: "+canBuildNonDecreasingArray(new int[]{1,2,6,6,4,4,4,4,6,6,8,9,10}));
//		System.out.println("False: "+canBuildNonDecreasingArray(new int[]{1,2,7,4,3,5,6,7,8,9,10}));
//		System.out.println("True: "+canBuildNonDecreasingArray(new int[]{1,2,7,4,5,6,3,8,9,10}));
//		System.out.println("False: "+canBuildNonDecreasingArray(new int[]{1,2,9,4,5,6,3,7,8,9,10}));
//		System.out.println("False: "+canBuildNonDecreasingArray(new int[]{2,5,3,3,7}));
//		System.out.println("False: "+canBuildNonDecreasingArray(new int[]{2,5,3,4,7}));
//		25337
	}
	
	private static boolean canBuildNonDecreasingArray(int[] A){
		int leftOfFirst = Integer.MIN_VALUE;
		int rightOfFirst = Integer.MAX_VALUE;
		int leftOfSecond = Integer.MIN_VALUE;
		int rightOfSecond = Integer.MAX_VALUE;
		int len = A.length;
		int count = 0;
		int indexOfFirst = -1;
		int indexOfSecond = -1;
		for(int i = 0; i + 1 < len; i++ ){
			if(A[i] > A[i+1]){
				count++;
				if(count == 1){
					//update indexOfFirst,  leftOfFirst, rightOfFirst;
					//update indexOfSecond, leftOfSecond, rightOfSecond;
					indexOfFirst = i;
					if(i-1 >= 0){//update leftOfFirst
						leftOfFirst = A[i-1];
					} 
					//return false in the following case
					rightOfFirst = A[i+1];
					if(rightOfFirst < leftOfFirst){
						return false;
					}
					
					indexOfSecond = indexOfFirst + 1;//1, len - 1
					leftOfSecond = A[indexOfSecond];
					if(indexOfSecond + 1 < len ){//update rightOfSecond
						if(A[indexOfSecond] < A[indexOfSecond + 1]){
							rightOfSecond = A[indexOfSecond+1];
						}else{
							int temp = indexOfSecond+2;
							while(temp < len && A[temp] == A[indexOfSecond]){
								i = temp;
								temp++;
							}
							if(temp < len){
								rightOfSecond = A[temp];
							}
						}
					} 

				}else if(count == 2){
					//update indexOfSecond, leftOfSecond, rightOfSecond;
					indexOfSecond = i + 1;
					leftOfSecond = A[i];
					if(i + 2 < len){//update rightOfSecond
						rightOfSecond = A[i+2];
					}else{
						rightOfSecond = Integer.MAX_VALUE;	
					} 
					//return false in the following case
					if(A[indexOfSecond] < leftOfFirst || A[indexOfSecond] > rightOfFirst || A[indexOfFirst] < leftOfSecond || A[indexOfFirst] > rightOfSecond){
						return false;
					}
				}else{
					return false;
				}
			}
		}
		if(count > 2){
			return false;
		}else if(count == 2){
			if(leftOfFirst <= A[indexOfSecond] && A[indexOfSecond] <= rightOfFirst && leftOfSecond <= A[indexOfFirst] && A[indexOfFirst] <= rightOfSecond){
				return true;
			}else{
				return false;
			}
		}else if(count == 1){
			if(leftOfFirst <= A[indexOfSecond] && A[indexOfFirst] <= rightOfSecond){
				return true;
			}else{
				return false;
			}
		}else{
			return true;
		}
	}
}

//
//def check_one_swap(s):
//	n = len(s)
//	first = second = -1
//	if n == 1:
//		return true
//	for i in range(n-1):
//		if s[i+1] >= s[i]:
//			continue
//		else:
//			if first == -1:
//				first = i
//				second = i + 1
//			elif second == first + 1:
//				second = i + 1
//			else:
//				return false
//	return s[first] >= s[second - 1] and s[second] <= s[first + 1] and (True if first == 0 else s[second] >= s[first - 1]) and (True if second == n -1 else s[first] <= s[second + 1])
//