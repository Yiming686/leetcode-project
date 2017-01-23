package Lintcode.Array;


/*
Find Minimum in Rotated Sorted Array II

30:00
 Start
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.

Have you met this question in a real interview? Yes
Example
Tags
Related Problems
 Notes
Given [4,4,5,6,7,0,1,2] return 0


 */
public class Find_Minimum_in_Rotated_Sorted_Array_II {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] num = new int[]{3,4,5,1,1,1,1,1,2,2,3,3};

		int[] num = new int[]{3,3,3,3,3,3,3,3,22};
		System.out.println(""+findMin(num));
		System.out.println(""+findMinIndex(num));
	}

	
	//3.����м������������һ��Ԫ�أ���Ҫ���⴦��
//  3.1 ����м��������������һ��Ԫ�أ�˵����С�����ں��Σ� ��Χ��С���м��������һ��Ԫ�����ұ�����
//  3.2 ����м��������������һ��Ԫ�أ�����ֱ��ҳ����һ��Ԫ�ص��м��������м��������һ��Ԫ���������������С����Ȼ�����������С�����бȽϣ����ȡ��Сֵ��
    
    //worked, �ǵݹ�ⷨ, ���ظ�Ԫ��������С
    //��index�ĽǶȿ������ҵ�����ߵ��Ǹ���СԪ��
    public static int findMin(int[] num) {
        if(num == null || num.length == 0) return -1;
        int start = 0, end = num.length-1;
        while(start+1<end) {
            if(num[start] < num[end]) return num[start];
            int mid = start + (end-start)/2;
            if(num[mid]<num[end]) 
                end = mid;
            else if(num[mid]>num[end])
                start = mid + 1;
            else
                //�ر���num[mid]==num[end]�����
//                end--;
            	start++;
        }
        return num[start] <= num[end] ? num[start] : num[end];//�Ⱥź���Ҫ��
    }
    
    public static int findMinIndex(int[] num) {
        if(num == null || num.length == 0) return -1;
        int start = 0, end = num.length-1;
        while(start+1<end) {
        	System.out.println("start:end "+start + ":"+end);
//            if(num[start] < num[end]) return start;
            int mid = start + (end-start)/2;
            if(num[mid]<num[end]) 
                end = mid;//�˴��Ѿ����ұߵĿ��ܵ���Сֵ������
            else if(num[mid]>num[end])
                start = mid + 1;
            else
                //�ر���num[mid]==num[end]�����
//                end--;
            	start++;
        }
    	System.out.println("start:end "+start + ":"+end);
        return num[start] <= num[end] ? start : end;
    }


    //�ڶ��ֽⷨ���ǵݹ�ⷨ
    //worked, 
    public int findMin23(int[] nums) {
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
                // start = mid;   //Time Limit Exceeded, ����
            }
        }
        return nums[start];
    }
    
    //worked, �ǵݹ�ⷨ�� ���ظ�Ԫ��������С
    public int findMin76(int[] num) {
        int start = 0, end = num.length-1;
        while(start<end) {
            if(num[start] < num[end]) return num[start];
            int mid = start + (end-start)/2;
            if(num[mid]<num[end]) 
                end = mid;
            else if(num[mid]>num[end])
                start = mid + 1;
            else
                end--;
        }
        return num[start];
    }
    
    public int findMin33(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        int target = nums[nums.length - 1];
        
        // find the first element <= target
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        if (nums[start] <= target) {
            return nums[start];
        } else {
            return nums[end];
        }
    }


//worked
    public int findMin7(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        
        while(start + 1 < end){
            if(nums[start] < nums[end]) return nums[start];
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[start]){
                start = mid + 1;  // mid�п�����min�����Եñ���
            } else if(nums[mid] < nums[start]){
                end = mid; //mid�϶�����min�����ر���
                //start = mid;   //Ҳ����ȷ�ģ�������ͨ��
            }else{
                if(nums[mid] > nums[end]){
                    start = mid + 1;
                }else{
                    int min = nums[start];
                    for(int i = start + 1; i < end; i++){
                        min = Math.min(nums[i], min);
                    }
                    return min;
                }
            }
            
        }
        return nums[start] < nums[end] ? nums[start] : nums[end];
        
    }

//not worked, retest
    public int findMin99(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        // if(nums[start] < nums[end]) return nums[start];
        
        while(start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] < nums[end]){
                end = mid;  // mid�п�����min�����Եñ���
            } else if(nums[mid] > nums[end]){
                start = mid + 1; //mid�϶�����min�����ر���
                //start = mid;   //Ҳ����ȷ�ģ�������ͨ��
            }else{
                end--;
                // if(nums[start] < nums[end])
                //     end = mid - 1;
                // else
                //     start = mid;
            }
            
        }
        return nums[start];
        // return nums[start] < nums[end] ? nums[start] : nums[end];
        
    }
    public int findMinNoDup(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] < nums[end]){
                end = mid;  // mid�п�����min�����Եñ���
            } else{
                start = mid + 1; //mid�϶�����min�����ر���
                //start = mid;   //Ҳ����ȷ�ģ�������ͨ��
            }
        }
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }

}
