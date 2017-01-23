package Lintcode.Array.Sum;

import java.util.Arrays;

public class Three_Sum_Closet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//˼·��������ɣ����򲻺�����������ĺ�
	//�����еı�������ҳ����µ�	
	//���������߼�������һ������ͣ���ѭ���и��£��˳�ѭ���󣬷��������
    //worked, perfect implementation
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return Integer.MAX_VALUE;
        Arrays.sort(nums);
        int len = nums.length;
        int closestSum = nums[0] + nums[1] + nums[len-1];//�����������
        for(int i = 0; i+2 < len; i++){
            if (i != 0 && nums[i] == nums[i - 1]) {
				continue; 
			}
            int left = i+1;
            int right = len-1;            
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target){
                    return target;
                }else if(sum < target){
                    left++;
                }else{
                    right--;
                }
                //�����߼����µ������ͱȾ������;���target�������滻֮
                if(Math.abs(sum-target) < Math.abs(closestSum - target)){
                    closestSum = sum;        
                }
            }
        }
        return closestSum;
    }


}
