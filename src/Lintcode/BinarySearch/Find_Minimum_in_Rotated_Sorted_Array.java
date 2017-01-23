package Lintcode.BinarySearch;

public class Find_Minimum_in_Rotated_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr = new int[]{4, 5, 6, 7, 0, 1, 2};
		System.out.println(""+findMin(arr));
	}
	
    //ֻ���������ߣ��������⿼���м������ߣ���Ȼ�󿴿�mid��˭�Ƚ��������յ�
    // �ݹ�ͷǵݹ鷽���ǳ����ƣ��ǵݹ���while�����仯�е�start��end
    // �ݹ���if�ڵݹ�����У�check start��end��Ȼ��ı����е�һ��
    // if��while��䣬������block�еĲ���һģһ��
    // findMinһ���ĳ��壬null���߳���Ϊ0ʱ����ô���أ�ʲôֵ�����أ�
    // �뻭���ݹ���
    
	//��һ�ֽⷨ���ǵݹ�ⷨ
    //worked��Ѱ����С�ķǵݹ�ⷨ����end��Ƚ�
    public int findMin2(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            if(nums[start] < nums[end]) return nums[start];
            int mid = start + (end - start)/2;
            if(nums[mid] < nums[end]){
                end = mid;  // mid�п�����min�����Եñ���
            } else{
                start = mid + 1; //mid�϶�����min�����ر���
                //start = mid;   //��Ϊ��������Ԫ�أ�����Ҳ����ȷ�ģ�������ͨ��
            }
        }
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }

    //�ڶ��ֽⷨ���ǵݹ�ⷨ
    //worked, as well
    public static int findMin(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while(start < end){
            //����һ�У�����֮��
            if(nums[start] < nums[end]) return nums[start];
            int mid = start + (end - start)/2;
            if(nums[mid] < nums[end]){
                end = mid;  // mid�п�����min�����Եñ���
            } else{
                start = mid + 1; //mid�϶�����min�����ر���
                // start = mid;   //������Ԫ��ʱ��Time Limit Exceeded, ����
            }
        }
        return nums[start];
    }
     
    //�����ֽⷨ���ݹ�ⷨ 
    //Ѱ����С�ĵݹ�ⷨ 
    public int findMin3(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        return helper(nums, 0, nums.length -1);
    }
    private int helper(int[] nums, int start, int end){
        if(nums == null || nums.length == 0) return -1;
        if(start + 1 >= end){
            return nums[start] < nums[end] ? nums[start] : nums[end];
        }
        int mid = start + (end - start)/2;
        if(nums[mid] < nums[end]){
            end = mid;
        } else{
            start = mid + 1;
        }
        return helper(nums, start, end);
    }


}
