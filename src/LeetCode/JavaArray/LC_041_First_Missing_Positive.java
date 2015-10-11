package LeetCode.JavaArray;

/*
 * Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.

 Hide Tags Array

 分析
 本质上是桶排序(bucket sort)，每当A[i]!= i+1 的时候，将A[i] 与A[A[i]-1] 交换，直到无法
 交换为止，终止条件是A[i]== A[A[i]-1]。
 代码
 // LeetCode, First Missing Positive
 // 时间复杂度O(n)，空间复杂度O(1)
 class Solution {
 public:
 int firstMissingPositive(int A[], int n) {
 bucket_sort(A, n);
 for (int i = 0; i < n; ++i)
 if (A[i] != (i + 1))
 return i + 1;
 return n + 1;
 }
 private:
 static void bucket_sort(int A[], int n) {
 for (int i = 0; i < n; i++) {
 while (A[i] != i + 1) {
 if (A[i] <= 0 || A[i] > n || A[i] == A[A[i] - 1])
 break;
 swap(A[i], A[A[i] - 1]);
 }
 }
 }
 };
 相关题目
 Sort Colors, 见§6.5
 */
public class LC_041_First_Missing_Positive {

//	【思路】：从0到n-1遍历，遍历规则：发现小于1，大于n的跳过，只针对从1到n数字进行下面交换处理，要不然报异常，也没有意义
//	如果当元素没有和从1到n对应上，则把它和他应该在的位置上的元素互换，然后i--的目的是继续对新交换回来的元素进行同样的处理
//	处理规则，同上面遍历规则。变量i顶多原地不动，不会倒退的
//	如此这般，遍历结束即可
//	然后从头到尾再次遍历,一旦发现没有和1到n对应上的元素,立即返回
//	如果恰好是从1到n排序的,那就返回n+1
//	【易错点】i忘记减一，对交换来的元素，要进行处理，i位置保持不动
//	【易错点】忘记check边界，一旦待处理元素不在从1到n范围内，直接跳过。
//	【易错点】什么交换条件？元素不在位置，俩个位置元素不等
//Accepted
	public int firstMissingPositive2(int[] nums) {
		if (nums == null)
			return -1;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] > 0 && nums[i] <= len) {
				if (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
					int temp = nums[nums[i] - 1];
					nums[nums[i] - 1] = nums[i];
					nums[i] = temp;
					// 交换回来的，还需要继续检验
					i--;
				}
			}
		}
		for (int i = 0; i < len; i++) {
			if (nums[i] != i + 1)
				return i + 1;
		}
		return len + 1;
	}

	// one solution
	public int firstMissingPositive(int[] nums) {
		bucket_sort(nums);
		int n = nums.length;
		for (int i = 0; i < n; ++i)
			if (nums[i] != (i + 1))
				return i + 1;
		return n + 1;
	}

	void bucket_sort(int nums[]) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			while (nums[i] != i + 1) {
				if (nums[i] <= 0 || nums[i] > n || nums[i] == nums[nums[i] - 1])
					break;
				swap(nums, i, nums[i] - 1);
			}
		}
	}

	void swap(int[] nums, int a, int b) {
		nums[a] = nums[a] ^ nums[b];
		nums[b] = nums[a] ^ nums[b];
		nums[a] = nums[a] ^ nums[b];
	}

	// the following swap does not work, because num[i] changed before using it
	// again

	// int temp = nums[i];
	// nums[i] = nums[nums[i] - 1];
	// nums[nums[i] - 1] = temp;

	// not work, because swap does not work
	void bucket_sort2(int nums[]) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			while (nums[i] != i + 1) {
				if (nums[i] <= 0 || nums[i] > n || nums[i] == nums[nums[i] - 1])
					break;
				swap(nums[i], nums[nums[i] - 1]);
			}
		}
	}

	void swap(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
