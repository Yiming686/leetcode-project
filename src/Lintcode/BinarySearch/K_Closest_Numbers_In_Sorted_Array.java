package Lintcode.BinarySearch;

public class K_Closest_Numbers_In_Sorted_Array {

    public static int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        //base cases
        int[] arr = new int[k];
        if(A==null || A.length == 0 || k <= 0) return arr;
        //初始化变量：针对一个元素，两个元素和三个元素以上的情况
        int len = A.length;
        int start = 0;
        int end = len - 1;
        //此时处理有三个以上元素
        while(start + 1 < end){
            //先求mid
            int mid = start + (end - start)/2;
            //计算数值
            int leftAbs = Math.abs(A[mid] - target);
            int rightAbs = Math.abs(A[mid+1] - target);
            //比较数值，然后不是移动start或者end，都必须动起来
            //条件非常重要：当absRight>absLeft，向右找，反之，向左找；而且必须包含mid
            if(rightAbs>leftAbs){
                end = mid;
            }else{
                start = mid;
            }
        }
        //此时处理只有一个或者两个元素
        int leftAbs = Math.abs(A[start] - target);
        int rightAbs = Math.abs(A[end] - target);
        //得到所求元素的下表
        int curr = (rightAbs >= leftAbs) ? start: end; 
        
        //第0个元素已经找到
        arr[0] = A[curr];
        
        //用两个指针，递增查找，剩下的k-1个值，并且插入数组中
        int left = curr - 1;
        int right = curr + 1;
        //i为index，因为递增查找的缘故，所以i必须递增
        //所以必须记得，i必须在4个地方出现，1初始化，2check，3赋值，4递增
        int i  = 1;
        while( i < k ){
            //如果left和right都在有效范围[0， len-1]内
            //left肯定小于len，right肯定大于0,并且left--，right++
            if(left >=0  && right < len ){
                 leftAbs = Math.abs(A[left] - target);
                 rightAbs = Math.abs(A[right] - target);
                 if(leftAbs <= rightAbs){
                     curr = left;
                     left--;
                 }else{
                     curr = right;
                     right++;
                 }
                arr[i] = A[curr];
            //left超出[0, len-1]范围
            }else if(left < 0){
                arr[i] = A[right];
                right++;
            }else{
                arr[i] = A[left];
                left--;
            }
            i++;
        }
        return arr;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,4,8,12,16,28,38};
		int target = 26;
		int k = 4;
		int[] arr = kClosestNumbers(A, target, k);
//		System.out.println(""+Arrays.asList(kClosestNumbers(A, target, k)));
		for(int i : arr){
			System.out.print(" "+i);
		}
	}

}
