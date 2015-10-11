package LeetCode.JavaTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Binary Tree Right Side View Total Accepted: 12071 Total Submissions: 44627 My Submissions Question Solution 
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

Credits:
Special thanks to @amrsaqr for adding this problem and creating all test cases.

Hide Tags Tree Depth-first Search Breadth-first Search

 */

public class LC_199_Binary_Tree_Right_Side_View {

//	Accepted, 完全是BFS，加了两行代码
//	  List<Integer> rst = new ArrayList<Integer>();
//    if(i == size -1) rst.add(head.val);

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        ArrayList result = new ArrayList();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                if(i == size -1) rst.add(head.val);
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }

        return rst; 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	jiuzhang解法：DFS
	public class Solution {
	    private void dfs(HashMap<Integer, Integer> depthToValue, TreeNode node, int depth) {
	        if (node == null) {
	            return;
	        }
	        
	        depthToValue.put(depth, node.val);
	        dfs(depthToValue, node.left, depth + 1);
	        dfs(depthToValue, node.right, depth + 1);
	    }
	    
	    public List<Integer> rightSideView(TreeNode root) {
	        HashMap<Integer, Integer> depthToValue = new HashMap<Integer, Integer>();
	        dfs(depthToValue, root, 1);
	        
	        int depth = 1;
	        List<Integer> result = new ArrayList<Integer>();
	        while (depthToValue.containsKey(depth)) {
	            result.add(depthToValue.get(depth));
	            depth++;
	        }
	        return result;
	    }
	}
}
