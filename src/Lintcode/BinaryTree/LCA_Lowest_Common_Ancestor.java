package Lintcode.BinaryTree;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNode.fromStringToTree("{4,3,7,#,#,5,6}");
		System.out.println(""+TreeNode.convertToString(root));
		TreeNode p = root.left;
		TreeNode q = root.right.left;
		q = new TreeNode(78);
		System.out.println(""+ lowestCommonAncestor( root,  q, p).val);
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

}
