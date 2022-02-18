package Lai.DB16.DP_III;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LC_198_House_Robber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Map<Integer, Integer> map = new HashMap<>();
	    
//	      Iterator it = map..iterator();
	      Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
	      while(it.hasNext()){
	        Map.Entry<Integer, Integer> entry = it.next();
	        Integer count = entry.getValue();
	        if(count == 1){
	          it.remove();
	        }else{
	          entry.setValue(count - 1);
	        }
	      }

	}
//  �������⣺Ϊʲô�ֲ�������ȫ������أ�������ǣ�������
//  ��Ϊ��robMax��notRobMax���ǵ��������ģ��������һ��һ��������
 public int rob(int[] nums) {
     if(nums == null || nums.length == 0){
         return 0;
     }
     int robMax = 0;//�Ե�ǰ��β�������ã�  ���õ������ֵ��������ò���δ֪
     int notRobMax = 0;//�Ե�ǰ��β�����Ҳ��ã����õ������ֵ, ������ò���δ֪
     for(int val : nums){
         int temp = robMax;
         robMax = notRobMax + val;
         notRobMax = Math.max(notRobMax, temp);                        
     }
     return Math.max(robMax, notRobMax);
 }
 
 //����һ����Ŀ�� ���������Ķ���ͺ��岢��һ����
 public static long houseRobber(int[] A) {
     // write your code here
     if(A == null || A.length == 0){
         return 0;
     }
     if(A.length == 1){
         return A[0];
     }
     if(A.length == 2){
         return Math.max(A[1], A[0]);
     }
     long prevPrevMax = A[0];
     long prevMax = Math.max(A[1], A[0]);
     
     for(int i = 2; i< A.length; i++){
         long currMax = Math.max(prevMax, prevPrevMax + A[i]);
         prevPrevMax = prevMax;
         prevMax = currMax;
     }
     return prevMax;
 }

 // �����д��
 public long houseRobber_WRONG(int[] A) {
     // write your code here
     if(A == null || A.length == 0){
         return 0;
     }
     long[] max = new long[A.length];
     if(A.length == 1){
         max[0] = A[0];
         return max[0];
     }
     if(A.length == 2){
         max[1] = Math.max(A[1], A[0]);
         return max[1];
     }
     for(int i = 2; i< A.length; i++){
         max[i] = Math.max(max[i-1], max[i-2] + A[i]);
     }
     return max[A.length - 1];
 }


}
