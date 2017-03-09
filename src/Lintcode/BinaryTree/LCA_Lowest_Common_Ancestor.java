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
	
//���ʣ�����������A,B������������ȣ���������2�ڵ���ܳ���5�������ԭʼ��ռ��һ������������ԭʼ���򷵻ص���LCA��
//	   �������ԭʼ����һ����LCA
//���ʣ����������Ƿ���������ڵ��е�һ����������ǰ��������ң�ǰ����Ҳ��ǣ���divideAndconquer���жϣ����Զ�ԭʼ��һ�����֣�
//	   �˽ڵ����LCA�����ڷ�ԭʼ���Ͳ���˵��

	// ע�⣺�ݹ�ʱ������ͣ�任�������ڵ㱣�ֲ��䣬���Ա���ʱ�ͻ��кܶ���������
    // ��һ�֣������ڵ㶼��������
    // �ڶ��֣������ڵ㶼�������棬����һ����root
    // �����֣������ڵ㶼����������
	// �����֣������ڵ�����һ����������
	// �����֣������ڵ�����һ���������棬������root
    // ����ԭʼ���ĸ��ڵ㣬��֤�����ڵ㶼��������ģ���ô���ص�Treeode������������
    // ���������ڵ㶼�����������������ô���ص�null
    // ���������ڵ�����һ���ڵ����������������ô���ص�TreeNode
	
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root == null || A == null || B == null) return null;
        //��˶��壺�����һ�������ĸ�һ��������������Ⱦ��Ǵ˸�
        //ȥ�����ɣ��ܻ�������
        if(A == root || B == root) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        if(left!=null && right != null) return root;
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }

}
