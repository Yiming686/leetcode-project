package Leet.Sliding_Window;

import static Utils.ArrayUtils.print;
import static Utils.ArrayUtils.printf;

import java.util.Arrays;

public class Leet_1040_Moving_Stones_Until_Consecutive_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] stones = { 7, 4, 9 };
//		int[] stones = { 6,5,4,3,10 };
		int[] stones = { 3,4,5,6,8};
		print(numMovesStonesII(stones));
	}

	public static int[] numMovesStonesII(int[] stones) {
		Arrays.sort(stones);
		return new int[] { findMin(stones), findMax(stones) };
	}

	static int findMin(int[] stones) {
		int n = stones.length;
		int slow = 0;
		int min = n;
		for (int fast = 0; fast < n; ++fast) { // first move fast pointer, 
			while (stones[fast] - stones[slow] + 1 > n) {//符合，移动到最小或最近或shortest处
				slow++; // if window is over, move slow pointer
			}
			int count = fast - slow + 1;
			if (count == n - 1 && stones[fast] - stones[slow] == n - 2) {
				min = Math.min(min, 2);//1 or 2
				if(2 <= min) {
					min = 2;
					printf("slow:fast:count::%d:%d:%d", slow, fast,count);
				}
			} else {
				int gapcount = n - count;
//				min = Math.min(min, gapcount);
				if(gapcount <= min ) {
					min = gapcount;
					printf("slow:fast:gapcount::%d:%d:%d", slow, fast,gapcount);
				}
			}
		}
		return min;
	}

	static int findMax(int[] stones) {
		int sum = 0;
		for (int i = 1; i < stones.length; ++i) {
			sum += stones[i] - stones[i - 1] - 1;
		}
		int n = stones.length;
		if (n >= 1 && stones[1] != stones[0] + 1) { // single element gap at the beginning
			if (n >= 2 && stones[n - 1] != stones[n - 2] + 1) { // single element end at the end 
				int gap1 = stones[1] - stones[0] - 1;
				int gap2 = stones[n - 1] - stones[n - 2] - 1;
				return sum - Math.min(gap1, gap2);
			}
		}
		return sum;
	}

}
