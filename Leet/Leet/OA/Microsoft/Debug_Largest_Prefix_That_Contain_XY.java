package Leet.OA.Microsoft;


/**
Given X, Y, and int[] arr, if 0<= P <= N, N is the length of arr, 
that from arr[0] to arr[P], must contains the same number of X and Y,
find the largest P, and return largest P. return -1, if X,Y are not found!

 *
 */
public class Debug_Largest_Prefix_That_Contain_XY {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int X = 7;
//		int Y = 42;
//		int[] arr = {6, 42,11,7,1,42};
		int X = 77;
		int Y = 472;
		int[] arr = {6,42,11,7,1,42};
		System.out.println(""+findLargestIndex00(X, Y, arr));
		System.out.println(""+findLargestIndex11(X, Y, arr));
	}

	private static int findLargestIndex11(int X, int Y, int[] arr) {
		int result = -1;
		int len = arr.length;
		int nX = 0;
		int nY = 0;
		for(int i = 0; i < len; i++) {
			if(arr[i] == X) {
				nX++;
			}else if(arr[i] == Y){
				nY++;
			}
			if(nX == nY) {
				result = i;
			}
		}
		return result = nX == 0 ? -1 : result;
	}

	private static int findLargestIndex00(int X, int Y, int[] arr) {
		int result = -1;
		int len = arr.length;
		int nX = 0;
		int nY = 0;
		for(int i = 0; i < len; i++) {
			if(arr[i] == X) {
				nX++;
			}else if(arr[i] == Y){
				nY++;
			}
			if(nX == nY) {
//			if(nX == nY && nX > 0) {
				result = i;
			}
		}
		return result;
	}
	
}
