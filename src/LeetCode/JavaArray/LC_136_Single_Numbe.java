package LeetCode.JavaArray;

public class LC_136_Single_Numbe {

//	[�����] int num = 0; ������κ����������κ�����
//	�κ�������Լ�����0
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
