package Lintcode;

public class Sort_Colors {

    public void sortColors(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return;
        
        int i = 0;
        int j = nums.length - 1;
        
        while(i<=j){
            while(i<=j && nums[i] == 0 ) i++;
            while(i<=j && nums[j] > 0) j --;
            if(i<=j){
                nums[i]^=nums[j];
                nums[j]^=nums[i];
                nums[i]^=nums[j];
            }
        }
        j = nums.length - 1;
        while(i<=j){
            while(i<=j && nums[i] == 1 ) i++;
            while(i<=j && nums[j] == 2) j --;
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
