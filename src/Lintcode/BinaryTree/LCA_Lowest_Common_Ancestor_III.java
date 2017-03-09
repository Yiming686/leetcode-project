package Lintcode.BinaryTree;

public class LCA_Lowest_Common_Ancestor_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNode.fromStringToTree("{4,3,7,#,#,5,6}");
		System.out.println(""+TreeNode.convertToString(root));
		TreeNode p = root.left;
		TreeNode q = root.right.left;
		q = new TreeNode(78);
		TreeNode comm = lowestCommonAncestor3( root,  q, p);
		System.out.println(""+ (comm == null ? null : comm.val));
	}
	
//	如果此方法直接返回LCA，会有什么问题？TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B)
//	A在左子树，B在右子树：那么左子树返回null，右子树返回null，而且root不等于A不等于B。
//	A和B都不在树上：那么左子树返回null，右子树返回null，而且root不等于A不等于B。
//	以上两种情况不能区分，第一种情况是有LCA的
	
	
//	要回答的问题是？这怎么就解决了两节点不在树的问题
//	允许两节点不在树，此时返回null
//	此方法是通用的，不论任何情况都是适用
    public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ResultType result = helper(root, A, B);
        if (result.doesExistA && result.doesExistB)
            return result.node;
        else
            return null;
    }

//    递归遍历并且带回需要的各种值
    public static ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null){
        	return new ResultType(false, false, null);//叶子节点的子节点
        }
//            这里取消掉了自上向下的遍历，返回值
        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);
        
        boolean doesExistA = left.doesExistA || right.doesExistA || root == A;//A在整个树上是否存在
        boolean doesExistB = left.doesExistB || right.doesExistB || root == B;//B在整个树上是否存在
     System.out.println("UUU: "+root.val);   
//        首先处理root == A || root == B，用doesExistA和doesExistB来识别是A还是B
        if (root == A || root == B){
        	return new ResultType(doesExistA, doesExistB, root);//root就是要找的node，AB都存在，node就是LCA，否则可能是A也可能是B
        }
//        root既不是A也不是B了
        if (left.node != null && right.node != null){
        	return new ResultType(doesExistA, doesExistB, root);
        }
        if (left.node != null){
        	return new ResultType(doesExistA, doesExistB, left.node);
        }
        if (right.node != null){
        	return new ResultType(doesExistA, doesExistB, right.node);
        }
        return new ResultType(doesExistA, doesExistB, null);
    }

	
	static class ResultType {
	    public boolean doesExistA;//存在A吗，如果存在就是node
	    public boolean doesExistB;//存在B吗，如果存在就是node
	    public TreeNode node;//AB都存在，node就是LCA，否则可能是A也可能是B，null表示不存在
	    ResultType(boolean a, boolean b, TreeNode n) {
	        doesExistA = a;
	        doesExistB = b;
	        node = n;
	    }
	}
	
}
