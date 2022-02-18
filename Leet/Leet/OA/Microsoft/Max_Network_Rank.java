package Leet.OA.Microsoft;

import Utils.SU;

//Cities are numbered from 1 to N,
//N cities and M roads, size of A and B is M
// maximal network rank
public class Max_Network_Rank {
	public static void main(String[] args) {
//		int[] A = {1, 2, 3, 3};
//		int[] B = {2, 3, 1, 4};
		int[] A = {1, 2, 4, 5};
		int[] B = {2, 3, 5, 6};
		int N = 6;
		System.out.println(""+maxNetworkRank(A, B, N));
		SU.ll("Min Deletions To Obtain String in Right Format" + 
				"");
	}
	private static int maxNetworkRank(int[] A, int[] B, int N) {
		int[] edgeCount = new int[N];

		for (int i = 0; i < A.length; i++) {
			edgeCount[A[i] - 1]++;
			edgeCount[B[i] - 1]++;
		}

		int maxRank = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			int rank = edgeCount[A[i] - 1] + edgeCount[B[i] - 1] - 1;
			if (rank > maxRank) {
				maxRank = rank;
			}
		}
		return maxRank;
	}
}
