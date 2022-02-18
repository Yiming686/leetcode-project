package Leet.OA.Microsoft;

import Utils.ArrayUtils;

public class Particle_Velocity {

	public static void main(String[] args) {
//		int[] input = { 1,3,5,7,9 };//6
//		int[] input = { 7,7,7,7 };//3
//		int[] input = { 3,-1,-5,-9 };//3
//		int[] input = { 1, 1, 2, 5, 7 };//0
//		int[] input = { -1, 1, 3, 3, 3, 2, 3, 2, 1, 0 };//5
		int[] input = ArrayUtils.buildIntArrayWithDupSorted(44, -66, 66);
//		int result = solution33(input);
		System.out.println(solution1(input));
		System.out.println(solution2(input));
		System.out.println(solution_Me(input));
	}

	public static int solution_Me(int[] inputs) {
		if (inputs.length < 3) {
			return 0;
		}
		int sum = 0;
		int count = 0;
		int prev = 0;
		for (int i = 1; i < inputs.length; i++) {
			int curr = inputs[i] - inputs[i - 1];
			if (curr == prev) {
				count++;
			} else {
				count = 1;
//				System.out.println("i: "+i);
			}
			prev = curr;
			if (count >= 2) {
				sum += count - 1;
			}
		}
		if (count > 1_000_000_000) {
			return -1;
		}
		return sum;
	}
	
	public static int solution1(int... a) {
	    int totalPeriods = 0;//
	    for (int i = 0; i < a.length; i++) {
	    	int count = 0;
	        while (i + 2 < a.length && a[i + 1] - a[i] == a[i + 2] - a[i + 1]) {
	            count++;
	            totalPeriods += count;
	            i++;
	        }
	    }
	    return totalPeriods < 1_000_000_000 ? totalPeriods : -1;
	}

	public static int solution2(int[] inputs) {
		if (inputs.length < 3) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < inputs.length - 2; i++) {
			if (inputs[i + 2] - inputs[i + 1] == inputs[i + 1] - inputs[i]) {
				count++;
				for (int j = i + 3; j < inputs.length; j++) {
					if (inputs[j] - inputs[j - 1] == inputs[i + 2] - inputs[i + 1]) {
						count++;
					}
				}
			}
		}
		if (count > 1000000000) {
			return -1;
		}
		return count;
	}

}
