package Lintcode.BinaryTree;

import static org.junit.Assert.*;

import org.junit.Test;

import Lintcode.Array.Interval.The_Skyline_Problem;

/**

 Lowest Common Ancestor

 Description
 Notes
 Testcase
 Judge
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

 Notice

Assume two nodes are exist in tree.

Have you met this question in a real interview? Yes
Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7

Tags 
LintCode Copyright LinkedIn Binary Tree Facebook



 *
 */
public class LCA_Lowest_Common_Ancestor {

	@Test
	public void testLowestCommonAncestor4(){
		TreeNode root = TreeNode.fromStringToTree("{1,2,3,4,5,6,7,#,#,#,#,8,#,#,#,#,#}");
		TreeNode A = root.left.left;//4
		TreeNode B = root.left.right;//5
//		System.out.println(""+lowestCommonAncestor4(root,  q, p));
		assertEquals(2, lowestCommonAncestor4(root,  A, B).val);
		assertEquals(lowestCommonAncestor3(root,  A, B).val, lowestCommonAncestor4(root,  A, B).val);
		A = root.right.right;//7
		B = root.right.left.left;//8
		assertEquals(3, lowestCommonAncestor4(root,  A, B).val);
		assertEquals(lowestCommonAncestor3(root,  A, B).val, lowestCommonAncestor4(root,  A, B).val);
		A = root.left.left;//4
		B = root.right.right;//7
		assertEquals(1, lowestCommonAncestor4(root,  A, B).val);
		assertEquals(lowestCommonAncestor3(root,  A, B).val, lowestCommonAncestor4(root,  A, B).val);
		A = root.left.left;//4
		B = root.right.right;//7
		assertEquals(1, lowestCommonAncestor4(root,  A, B).val);
		assertEquals(lowestCommonAncestor3(root,  A, B).val, lowestCommonAncestor4(root,  A, B).val);
		A = root;//1
		B = root;//1
		assertEquals(1, lowestCommonAncestor4(root,  A, B).val);
		assertEquals(lowestCommonAncestor3(root,  A, B).val, lowestCommonAncestor4(root,  A, B).val);
		A = root.left.right;//4
		B = root.left.right;//4
		assertEquals(5, lowestCommonAncestor4(root,  A, B).val);
		assertEquals(lowestCommonAncestor3(root,  A, B).val, lowestCommonAncestor4(root,  A, B).val);
		assertTrue("",2==2);
		assertArrayEquals(new int[0], new int[0]);
//		assertSame(expected, actual);


	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNode.fromStringToTree("{4,3,7,#,#,5,6}");
		System.out.println(""+TreeNode.convertToString(root));
		TreeNode p = root;
		TreeNode q = root.right.right;
		System.out.println(""+ lowestCommonAncestor4( root,  root, root));
		System.out.println(""+ lowestCommonAncestor4( root,  null, root.right.left));
		System.out.println(""+ lowestCommonAncestor4( root,  root.right.left, null));
		System.out.println(""+ lowestCommonAncestor4( null,  root.right.left, null));
		System.out.println(""+ lowestCommonAncestor4( root,  root.left, root.left));
		System.out.println("4,7,7 "+ lowestCommonAncestor4( root,  root.right, root.right));
		System.out.println("4,5,5 "+ lowestCommonAncestor4( root,  root.right.left, root.right.left));
		System.out.println(""+ lowestCommonAncestor4( root,  root.right.right, new TreeNode(5)));
		System.out.println(""+ lowestCommonAncestor4( root,  new TreeNode(5), root.left.left));
		
//		q = new TreeNode(99);
		p = new TreeNode(78);
		System.out.println(""+ lowestCommonAncestor4( root,  q, p));
	}
	
//本质：在树里面找A,B的最近公共祖先，但是树与2节点可能出现5种情况，原始树占据一种情况，如果是原始树则返回的是LCA，
//	   如果不是原始树则不一定是LCA
//本质：找树里面是否存在两个节点中的一个，但是是前序遍历查找，前序查找不是，就divideAndconquer再判断，所以对原始树一旦发现，
//	   此节点就是LCA，对于非原始树就不好说了

	// 注意：递归时，树不停变换，两个节点保持不变，所以遍历时就会有很多种树存在
    // 第一种：两个节点都在树里面
    // 第二种：两个节点都在树里面，其中一个是root
    // 第三种：两个节点都不在树里面
	// 第四种：两个节点中有一个在树里面
	// 第四种：两个节点中有一个在树里面，并且是root
    // 对于原始树的根节点，保证两个节点都在树里面的，那么返回的Treeode就是我们所求
    // 对于两个节点都不在树里面的树，那么返回的null
    // 对于两个节点中有一个节点在树里面的树，那么返回的TreeNode
	
//	worked, for BT and BST when two nodes loactaed in the tree
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root == null || A == null || B == null) return null;
        //如此定义：如果有一个和数的根一样，最近公共祖先就是此根
        //去遍历吧，总会遇到的
        if(A == root || B == root) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        if(left!=null && right != null) return root;
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }
    
    
//    Worked, Best solution: works for BT and BST
    //仅仅node1和node2都不为null，且在树里面，可以为同一个node，返回LCA，否则都返回null
    public static TreeNode lowestCommonAncestor4(TreeNode root, TreeNode node1, TreeNode node2) {
        if(root == null || node1 == null || node2 == null) return null;
    	int[] count = new int[1];
    	TreeNode node = helper(root, node1, node2, count);
        if (count[0] == 2)
            return node;
        else
            return null;
    }

    //Worked, Best solution
    private static TreeNode helper(TreeNode root, TreeNode node1, TreeNode node2, int[] count) {
		// TODO Auto-generated method stub
        if(root == null) return null;
        //统计个数必须这么写，很容易错误
        if(root == node1 || root == node2){
        	if(root == node1){
        		count[0]++;
        	} 
        	if(root == node2){
        		count[0]++;
        	}
        	return root;
        }
        
        TreeNode left = helper(root.left, node1, node2, count);
        TreeNode right = helper(root.right, node1, node2, count);
        
        if(left!=null && right != null) return root;
        if(left != null) return left;
        if(right != null) return right;
        return null;
	}

    
//    worked, too more code, works for BT and BST
	public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode node1, TreeNode node2) {
        // write your code here
        ResultType result = helper(root, node1, node2);
        if (result.isNode1Found && result.isNode2Found)
            return result.node;
        else
            return null;
    }

//    递归遍历并且带回需要的各种值
    public static ResultType helper(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null){
        	return new ResultType(false, false, null);//叶子节点的子节点
        }
//            这里取消掉了自上向下的遍历，返回值
        ResultType left = helper(root.left, node1, node2);
        ResultType right = helper(root.right, node1, node2);
        
        boolean isNode1Found = left.isNode1Found || right.isNode1Found || root == node1;//A在整个树上是否存在
        boolean isNode2Found = left.isNode2Found || right.isNode2Found || root == node2;//B在整个树上是否存在
        
        if (root == node1 || root == node2){
        	return new ResultType(isNode1Found, isNode2Found, root);//root就是要找的node，AB都存在，node就是LCA，否则可能是A也可能是B
        }
        if (left.node != null && right.node != null){
        	return new ResultType(isNode1Found, isNode2Found, root);
        }
        if (left.node != null){
        	return new ResultType(isNode1Found, isNode2Found, left.node);
        }
        if (right.node != null){
        	return new ResultType(isNode1Found, isNode2Found, right.node);
        }
        return new ResultType(isNode1Found, isNode2Found, null);
    }

	
	static class ResultType {
	    public boolean isNode1Found;//存在A吗，如果存在就是node
	    public boolean isNode2Found;//存在B吗，如果存在就是node
	    public TreeNode node;//AB都存在，node就是LCA，否则可能是A也可能是B
	    ResultType(boolean a, boolean b, TreeNode n) {
	        isNode1Found = a;
	        isNode2Found = b;
	        node = n;
	    }
	}


}
