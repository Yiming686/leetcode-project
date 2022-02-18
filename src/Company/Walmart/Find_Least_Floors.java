package Company.Walmart;

import java.util.Arrays;

/**

有一个arr存放房子的高度。另外给一个int m。问“加盖多少层可以有至少m个房子一样高”。

例子：
arr = {1, 5, 2, 4, 1}, m = 3
ans = 2, 因为把两个层高为1的各加盖一层就有3个一样高的。

arr = {1, 5, 3, 4, 1}, m = 3
ans = 3, 加盖3和4到5层。.1point3acres缃�

arr = {1, 1, 2}, m = 2
ans = 0

我用了TreeMap<floorLevel, numOfFloorsAtThisLevel>. 然后从高到低两层循环找。超时。。

大家帮忙想想有什么更好的办法

 *
 */
public class Find_Least_Floors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{1, 5, 2, 4, 1};
		int n = 3;
		arr = new int[]{1, 5, 3, 4, 1};
		n= 3;
//		arr = new int[]{1, 1, 2};
//		n= 2;
		System.out.println(""+findLeastFloors2(arr, n));
	}

	private static int findLeastFloors(int[] arr, int n) {
		// TODO Auto-generated method stub
		if(arr == null || arr.length < n){
			return -1;
		}
		int len = arr.length;
		Arrays.sort(arr);
		System.out.println(""+Arrays.toString(arr));
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int i = 0; i < n; i++){
			sum += arr[n-1] - arr[i];
		}
		min = sum;	
		System.out.println("min: "+ min);
		for(int i = n; i < len; i++){
			sum = sum - arr[i] + arr[i-n];
			sum = sum + n * (arr[i] - arr[i-1]);
			System.out.println("min:sum "+ min +", " +sum);
			min = Math.min(min, sum);
		}
		return min;
	}

	private static int findLeastFloors2(int[] arr, int n) {
		// TODO Auto-generated method stub
		if(arr == null || arr.length < n){
			return -1;
		}
		int len = arr.length;
		int maxVal = Integer.MIN_VALUE;
		int minVal = Integer.MAX_VALUE;
		for(int i = 0; i < len; i++){
			maxVal = Math.max(maxVal, arr[i]);
			minVal = Math.min(minVal, arr[i]);
		}
		int newLen = maxVal - minVal + 1;
		int[] newArr = new int[newLen];
		for(int i = 0; i < len; i++){
			newArr[arr[i]-minVal]++; 
		}
		System.out.println(""+Arrays.toString(arr));
		System.out.println(""+Arrays.toString(newArr));
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int i = 0; i < newLen; i++){
			sum += arr[n-1] - arr[i];
		}
		min = sum;	
		System.out.println("min: "+ min);
		for(int i = n; i < len; i++){
			sum = sum - arr[i] + arr[i-n];
			sum = sum + n * (arr[i] - arr[i-1]);
			System.out.println("min:sum "+ min +", " +sum);
			min = Math.min(min, sum);
		}
		return min;
	}

}
