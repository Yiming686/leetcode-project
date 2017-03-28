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
	
//	worked, for BT and BST when two nodes loactaed in the tree
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
    
    
//    Worked, Best solution: works for BT and BST
    //����node1��node2����Ϊnull�����������棬����Ϊͬһ��node������LCA�����򶼷���null
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
        //ͳ�Ƹ���������ôд�������״���
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

//    �ݹ�������Ҵ�����Ҫ�ĸ���ֵ
    public static ResultType helper(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null){
        	return new ResultType(false, false, null);//Ҷ�ӽڵ���ӽڵ�
        }
//            ����ȡ�������������µı���������ֵ
        ResultType left = helper(root.left, node1, node2);
        ResultType right = helper(root.right, node1, node2);
        
        boolean isNode1Found = left.isNode1Found || right.isNode1Found || root == node1;//A�����������Ƿ����
        boolean isNode2Found = left.isNode2Found || right.isNode2Found || root == node2;//B�����������Ƿ����
        
        if (root == node1 || root == node2){
        	return new ResultType(isNode1Found, isNode2Found, root);//root����Ҫ�ҵ�node��AB�����ڣ�node����LCA�����������AҲ������B
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
	    public boolean isNode1Found;//����A��������ھ���node
	    public boolean isNode2Found;//����B��������ھ���node
	    public TreeNode node;//AB�����ڣ�node����LCA�����������AҲ������B
	    ResultType(boolean a, boolean b, TreeNode n) {
	        isNode1Found = a;
	        isNode2Found = b;
	        node = n;
	    }
	}


}
