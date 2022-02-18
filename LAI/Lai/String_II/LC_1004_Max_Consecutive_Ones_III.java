package Lai.String_II;

import static Utils.ArrayUtils.printf;
import static Utils.TreeNodeUtils.BINARY_TREE_NULL_NODE;

import java.util.LinkedList;
import java.util.TreeMap;

import Utils.ArrayUtils;
public class LC_1004_Max_Consecutive_Ones_III {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
//		LinkedList
		// TODO Auto-generated method stub
//		int[] arr = {1,1,1,0,0,0,1,1,1,1,0}; 
		int[] arr = ArrayUtils.buildIntArrayWithDup(9, 0, 1); 
		int k = 2;
//		printIntArray(arr);
		System.out.println(""+longestOnes(arr, k));
	}

//	3ms 
	public static int longestOnes(int[] arr, int k) {
		int i = 0;
		int j;
		//k表示目前[i,j]里面顶多出现k个0
		for (j = 0; j < arr.length; j++) {
			printf("i:j:k %d:%d:%d \n", i, j, k);
			if (arr[j] == 0) {//只要是0，k--
				k--;
			}
			// if(K<0 && A[i++]==0) {//当k<0,直到k<0,
			//     K++;                   
			// }
			if (k < 0) {//当k<0,直到k<0,
				if (arr[i] == 0) {
					k++;
				}
				i++;
			}
		}
		printf("i:j:k %d:%d:%d \n", i, j, k);
		return j - i;//最大的
	}
	
    //     2ms
    public int longestOnes_2ms(int[] arr, int k) {
        int b = 0, f = 0;
       
        while (f < arr.length) {
            k -= 1 - arr[f++]; 
            
            if (k < 0) k += 1 - arr[b++];
        }
        
        return f-b;
    }


}
