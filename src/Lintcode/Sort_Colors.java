package Lintcode;

public class Sort_Colors {

    public void sortColors(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return;
        
        int i = 0;
        int j = nums.length - 1;
        
        while(i<=j){
            while(i<=j && nums[i] == 0 ) i++;//iָ�����0�ģ�����������Сֵ
            while(i<=j && nums[j] > 0) j --; //jָ�����С��0�ģ���������Сֵ
            if(i<=j){
                nums[i]^=nums[j];
                nums[j]^=nums[i];
                nums[i]^=nums[j];
            }
        }
        j = nums.length - 1;
        while(i<=j){
            while(i<=j && nums[i] == 1 ) i++;//iָ�����1��
            while(i<=j && nums[j] == 2) j --;//jָ�����С��0��
            if(i<=j){
                nums[i]^=nums[j];
                nums[j]^=nums[i];
                nums[i]^=nums[j];
            }
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
