package LeetCode.JavaArray;

/*
 * Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.

 Hide Tags Array

 ����
 ��������Ͱ����(bucket sort)��ÿ��A[i]!= i+1 ��ʱ�򣬽�A[i] ��A[A[i]-1] ������ֱ���޷�
 ����Ϊֹ����ֹ������A[i]== A[A[i]-1]��
 ����
 // LeetCode, First Missing Positive
 // ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)
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
 �����Ŀ
 Sort Colors, ����6.5
 */
public class LC_041_First_Missing_Positive {

//	��˼·������0��n-1�������������򣺷���С��1������n��������ֻ��Դ�1��n���ֽ������潻������Ҫ��Ȼ���쳣��Ҳû������
//	�����Ԫ��û�кʹ�1��n��Ӧ�ϣ����������Ӧ���ڵ�λ���ϵ�Ԫ�ػ�����Ȼ��i--��Ŀ���Ǽ������½���������Ԫ�ؽ���ͬ���Ĵ���
//	�������ͬ����������򡣱���i����ԭ�ز��������ᵹ�˵�
//	�����㣬������������
//	Ȼ���ͷ��β�ٴα���,һ������û�к�1��n��Ӧ�ϵ�Ԫ��,��������
//	���ǡ���Ǵ�1��n�����,�Ǿͷ���n+1
//	���״�㡿i���Ǽ�һ���Խ�������Ԫ�أ�Ҫ���д���iλ�ñ��ֲ���
//	���״�㡿����check�߽磬һ��������Ԫ�ز��ڴ�1��n��Χ�ڣ�ֱ��������
//	���״�㡿ʲô����������Ԫ�ز���λ�ã�����λ��Ԫ�ز���
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
					// ���������ģ�����Ҫ��������
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
