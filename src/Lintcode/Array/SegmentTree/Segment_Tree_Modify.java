package Lintcode.Array.SegmentTree;

/**

Segment Tree Modify Show result 

For a Maximum Segment Tree, which each node has an extra value max to store the maximum value in this node's interval.

Implement a modify function with three parameter root, index and value to change the node's value with [start, end] = [index, index] to the new given value. Make sure after this change, every node in segment tree still has the max attribute with the correct value.

Have you met this question in a real interview? Yes
Example
For segment tree:

                      [1, 4, max=3]
                    /                \
        [1, 2, max=2]                [3, 4, max=3]
       /              \             /             \
[1, 1, max=2], [2, 2, max=1], [3, 3, max=0], [4, 4, max=3]
if call modify(root, 2, 4), we can get:

                      [1, 4, max=4]
                    /                \
        [1, 2, max=4]                [3, 4, max=3]
       /              \             /             \
[1, 1, max=2], [2, 2, max=4], [3, 3, max=0], [4, 4, max=3]
or call modify(root, 4, 0), we can get:

                      [1, 4, max=2]
                    /                \
        [1, 2, max=2]                [3, 4, max=0]
       /              \             /             \
[1, 1, max=2], [2, 2, max=1], [3, 3, max=0], [4, 4, max=0]
Note
We suggest you finish problem Segment Tree Build and Segment Tree Query first.

Challenge
Do it in O(h) time, h is the height of the segment tree.

Tags Expand 
LintCode Copyright Binary Tree Segment Tree


Related Problems Expand 
Medium Segment Tree Query II 27 %
Medium Segment Tree Query 34 %
Medium Segment Tree Build


 *
 *
 */
public class Segment_Tree_Modify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    //Jiuzhang, worked, not better than mine
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if(root.start == index && root.end == index) { // 查找到
            root.max = value;
            return;
        }
        
        // 查询
        int mid = (root.start + root.end) / 2;
        if(root.start <= index && index <=mid) {
            modify(root.left, index, value);
        }
        
        if(mid < index && index <= root.end) {
            modify(root.right, index, value);
        }
        //更新
        root.max = Math.max(root.left.max, root.right.max);
    } 
    //My solution, worked, best solution
    public void modify3(SegmentTreeNode root, int index, int value) {
        // write your code here
        if(root == null) return;
        if(index < root.start || index > root.end) return;
        if(root.start == root.end && root.start == index){
            root.max = value;
            return;
        }
        int mid = root.start + (root.end - root.start)/2;
        if(index <= mid){
            modify(root.left, index, value);
        }else{
            modify(root.right, index, value);
        }
        root.max = Math.max(root.left.max, root.right.max);
        
    }
    
    //worked
    // public void modify(SegmentTreeNode root, int index, int value) {
    //     // write your code here
    //     if(root == null) return;
    //     if(index < root.start || index > root.end) return;
    //     modify(root, root.start, root.end, index, value);
    // }
    // public void modify(SegmentTreeNode root, int start, int end, int index, int value) {
    //     if(root == null) return;
    //     if(root.start == root.end && root.start == index){
    //         root.max = value;
    //         return;
    //     }
    //     int mid = start + (end - start)/2;
    //     if(index <= mid){
    //         // modify(root.left, start, index, index, value);//这个是不对的
    //         modify(root.left, start, mid, index, value);
    //     }else{
    //         // modify(root.right, index, end, index, value);//这个是不对的
    //         modify(root.right, mid+1, end, index, value);
    //     }
    //     root.max = Math.max(root.left.max, root.right.max);
        
    // }


}
