package Lintcode.Array.Permutation;

/**
Permutation Index Show result 

Given a permutation which contains no repeated number, find its index in all the permutations of these numbers, which are ordered in lexicographical order. The index begins at 1.

Have you met this question in a real interview? Yes
Example
Given [1,2,4], return 1.

Related Problems Expand 
Medium Next Permutation II 33 %
Medium Previous Permutation 

*
 */
public class Permutation_Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    //best than jiuzhang solution
	public long permutationIndex(int[] permutation) {
		// Write your code here
		long index = 0;
		long position = 2;// position 1 is paired with factor 0 and so is
							// skipped
		long factor = 1;
		for (int p = permutation.length - 2; p >= 0; p--) {
			long successors = 0;//表示在p之后有多少个比他小
			for (int q = p + 1; q < permutation.length; q++) {
				if (permutation[q] < permutation[p]) {
					successors++;
				}
			}
			index += (successors * factor);
			factor *= position;
			position++;
		}
		index = index + 1;
		return index;
	}

}
