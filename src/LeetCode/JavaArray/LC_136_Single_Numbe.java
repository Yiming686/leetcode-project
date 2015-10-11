package LeetCode.JavaArray;

public class LC_136_Single_Numbe {

//	[考察点] int num = 0; 零异或任何数，等于任何数；
//	任何数异或自己等于0
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0 ) return Integer.MIN_VALUE;

		int num = 0;
		for(int i = 0; i< nums.length; i++){
			num ^= nums[i];
		}
		return num;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
