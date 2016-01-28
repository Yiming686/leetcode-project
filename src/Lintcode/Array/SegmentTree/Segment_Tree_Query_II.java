package Lintcode.Array.SegmentTree;

/**

Segment Tree Query II

For an array, we can build a SegmentTree for it, each node stores an extra attribute count to denote the number of elements in the the array which value is between interval start and end. (The array may not fully filled by elements)

Design a query method with three parameters root, start and end, find the number of elements in the in array's interval [start, end] by the given root of value SegmentTree.

Have you met this question in a real interview? Yes
Example
For array [0, 2, 3], the corresponding value Segment Tree is:

                     [0, 3, count=3]
                     /             \
          [0,1,count=1]             [2,3,count=2]
          /         \               /            \
   [0,0,count=1] [1,1,count=0] [2,2,count=1], [3,3,count=1]
query(1, 1), return 0

query(1, 2), return 1

query(2, 3), return 2

query(0, 2), return 2

Note
It is much easier to understand this problem if you finished Segment Tree Buildand Segment Tree Query first.

Tags Expand 
LintCode Copyright Binary Tree Segment Tree


Related Problems Expand 
Medium Segment Tree Modify 36 %
Medium Segment Tree Query 34 %
Medium Segment Tree Build

 *
 *
 *
 */
public class Segment_Tree_Query_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
