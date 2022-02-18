package Lintcode.BinaryTree.Path.Sum;

import java.util.HashMap;
import java.util.Map;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

/**


437. Path Sum III   

Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 15210
Total Submissions: 39422
Difficulty: Easy
Contributors: Stomach_ache
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
Subscribe to see which companies asked this question

Hide Tags Tree
Hide Similar Problems (E) Path Sum (M) Path Sum II


 *
 */
public class Path_Sum_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String TreeNodeStrIn ="{1,2,3,4,5,6,7,8,9,10}";
		String TreeNodeStrIn ="[10,5,-3,3,2,null,11,3,-2,null,1]";
//		String TreeNodeStrIn ="{1,2,3,4,5,6,7,8,9,10,#,1,#,#,#,#,#,#,2}";
		TreeNode<Integer>  root = TreeNodeUtils.fromStringToTree(TreeNodeStrIn, TreeNode.class, Integer.class);
		TreeNodeUtils.printTree(root);
		
		System.out.println(""+pathSum(root, 8));
//		System.out.println(""+pathSum11(root, 8));
		
	}

    public static int pathSum(TreeNode<Integer> root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  //Default sum = 0 has one count
        return helper(root, 0, sum, map); 
    }
    
    //BackTrack one pass
    public static int helper(TreeNode<Integer>  root, int sum, int target, Map<Integer, Integer> map){
        if(root == null)
            return 0;
        sum += root.val;
        int res = map.getOrDefault(sum - target, 0);    //See if there is a subarray sum equals to target
        map.put(sum, map.getOrDefault(sum, 0)+1);
        //Extend to left and right child
        res += helper(root.left, sum, target, map) + helper(root.right, sum, target, map);
        map.put(sum, map.get(sum)-1);   //Remove the current node so it wont affect other path
        System.out.println(""+map);
        return res;
    }

    
    public static int pathSum11(TreeNode<Integer>  root, int sum) {
        if(root == null)
            return 0;
        return dfs(root, sum)+pathSum(root.left, sum)+pathSum(root.right, sum);
    }
// 从roo到叶子节点等于sum的个数
    private static int dfs(TreeNode<Integer> root, int sum){
//    	System.out.println(""+sum);
        int res = 0;
        if(root == null)
            return res;
        if(sum == root.val){
        	res++;
        	System.out.println("++");        	
        }
        res+=dfs(root.left,sum - root.val);
        res+=dfs(root.right,sum - root.val);
        return res;
    }

}
