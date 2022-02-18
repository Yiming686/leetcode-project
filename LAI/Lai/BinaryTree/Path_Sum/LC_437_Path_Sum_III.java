package Lai.BinaryTree.Path_Sum;

import java.util.HashMap;
import java.util.Map;

import Utils.StringUtils;
import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TP;
import Utils.TreeNodeUtils.TreeNode;

/**

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



 *
 */
public class LC_437_Path_Sum_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNodeUtils.fromStringToTree("[10,5,-3,3,2,null,11,3,-2,null,1]");
//		TreeNode root = TreeNodeUtils.fromStringToTree("[0,1,1]");
//		TreeNode root = TreeNodeUtils.fromStringToTree("[5,-8,#,3,10,5,5]");
//		TreeNodeUtils.printTree(root);
		TreeNodeUtils.printTreeByTP(root);
//		System.out.println(""+pathSum(root, 2));
		System.out.println(""+pathSum(root, 8));
		
//		TreeNodeUtils.printTreeByTP(root);
//		System.out.println(""+pathSum(root, 1));
	}
	
    public static int pathSum(TreeNode root, int sum) {
//        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        TP tp = TP.build("", "11110", "root", null);
        int count = pathSum(map, root, 0, sum, tp); TP.build("root", null, count, map, StringUtils.toStr(root), 0, sum);//进来再加，
        tp.print();
        return count;
    }
//    map 表明截止当前root之前
//    计算count之前，只需要计算出来包含当前节点的preSum，然后把<preSum，+1>放入map
   private static int pathSum(Map<Integer, Integer> map, TreeNode<Integer> root, int preSum, int target, TP paraTp){
	   if(root == null) {
		   return 0;
	   }
	   preSum += root.val;
	   if(map.getOrDefault(preSum - target, 0) != 0) {paraTp.mark();}
	   int count = map.getOrDefault(preSum - target, 0);
	   map.put(preSum, map.getOrDefault(preSum, 0)+ 1);
       count += pathSum(map, root.left, preSum, target, TP.build(paraTp, count, map,StringUtils.toStr(root.left), preSum, target));
       count += pathSum(map, root.right, preSum, target, TP.build(paraTp, count, map, StringUtils.toStr(root.right), preSum, target));
       map.put(preSum, map.get(preSum) - 1);
       return count; 
    }

}
