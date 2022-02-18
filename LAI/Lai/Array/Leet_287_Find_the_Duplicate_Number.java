package Lai.Array;

public class Leet_287_Find_the_Duplicate_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//brute force: O(N^2)
	
	//Time: O(NlogN), Space: O(1)
	public int findDuplicate_NlogN(int[] nums) {
		// public int findDuplicate(int[] nums) {        
		int left = 1;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (numOfSmallerEqual(nums, mid) > mid) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;//or right        
	}

	//Time: O(NlogN), Space: O(1)
	private int numOfSmallerEqual(int[] nums, int num) {
		int count = 0;
		for (int val : nums) {
			if (val <= num) {
				count++;
			}
		}
		return count;
	}

	//Time: O(N), Space: O(1)
	public int findDuplicate_n1(int[] nums) {
		// public int findDuplicate(int[] nums) {                 
		if (nums == null || nums.length == 0) {
			return 1;
		}
		int slow = nums[0];
		int fast = nums[slow];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		fast = nums[0];//fastָ���һ��Ԫ��
		slow = nums[slow];//slowָ����һ��Ԫ��
		// fast   = 0;//worked, fast Ҫָ���һ��
//         �����ѭ����ʼ��fastָ���һ��Ԫ�أ�slowָ��
		while (fast != slow) {
			fast = nums[fast];
			slow = nums[slow];
		}
		return fast;
	}

	//Time: O(N), Space: O(1)
	public int findDuplicate_n2(int[] nums) {
		// public int findDuplicate(int[] nums) {                 
		if (nums == null || nums.length == 0) {
			return 1;
		}
		// int slow = nums[0];
		// int fast = nums[slow];
		int slow = 0;
		int fast = 0;
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);
//          not looks good
		// while(true){
		//     slow = nums[slow];
		//     fast = nums[nums[fast]];            
		//     if(slow == fast){
		//         break;
		//     }
		// }

		slow = 0;
		while (fast != slow) {
			fast = nums[fast];
			slow = nums[slow];
		}
		return fast;
	}

	// public int findDuplicate_O1(int[] nums) {                 
	public int findDuplicate(int[] nums) {
		int res = 0, n = nums.length;
		for (int i = 0; i < 32; ++i) {
			//ֻ����iλ
			int bit = (1 << i), cnt1 = 0, cnt2 = 0;
			for (int k = 0; k < n; ++k) {
				if ((k & bit) > 0)
					++cnt1;//0--n-1�ж��ٸ�1���ڵ�iλ
				if ((nums[k] & bit) > 0)
					++cnt2;//Ԫ��index from 0--n-1�� �ж��ٸ�1���ڵ�iλ
			}
			if (cnt2 > cnt1)
				res += bit;
		}
		return res;
	}
}
