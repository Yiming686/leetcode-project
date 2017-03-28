package Lintcode.BinaryTree;

public class LCA_Lowest_Common_Ancestor_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNode.fromStringToTree("{4,3,7,#,#,5,6}");
		System.out.println(""+TreeNode.convertToString(root));
		TreeNode node1 = root.left;
		TreeNode node2 = root.right.left;
//		node2 = new TreeNode(78);
		TreeNode comm = lowestCommonAncestor3( root,  node1, node2);
		System.out.println("findLowestCommonAncestorBT: "+ findLowestCommonAncestorBT(root, node1,node2).val);
		System.out.println(""+ (comm == null ? null : comm.val));
	}
	
//	����˷���ֱ�ӷ���LCA������ʲô���⣿TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B)
//	A����������B������������ô����������null������������null������root������A������B��
//	A��B���������ϣ���ô����������null������������null������root������A������B��
//	������������������֣���һ���������LCA��
	
	
//	Ҫ�ش�������ǣ�����ô�ͽ�������ڵ㲻����������
//	�������ڵ㲻��������ʱ����null
//	�˷�����ͨ�õģ������κ������������
    public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ResultType result = helper(root, A, B);
        if (result.doesExistA && result.doesExistB)
            return result.node;
        else
            return null;
    }

//    �ݹ�������Ҵ�����Ҫ�ĸ���ֵ
    public static ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null){
        	return new ResultType(false, false, null);//Ҷ�ӽڵ���ӽڵ�
        }
//            ����ȡ�������������µı���������ֵ
        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);
        
        boolean doesExistA = left.doesExistA || right.doesExistA || root == A;//A�����������Ƿ����
        boolean doesExistB = left.doesExistB || right.doesExistB || root == B;//B�����������Ƿ����
     System.out.println("UUU: "+root.val);   
//        ���ȴ���root == A || root == B����doesExistA��doesExistB��ʶ����A����B
        if (root == A || root == B){
        	return new ResultType(doesExistA, doesExistB, root);//root����Ҫ�ҵ�node��AB�����ڣ�node����LCA�����������AҲ������B
        }
//        root�Ȳ���AҲ����B��
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
	    public boolean doesExistA;//����A��������ھ���node
	    public boolean doesExistB;//����B��������ھ���node
	    public TreeNode node;//AB�����ڣ�node����LCA�����������AҲ������B��null��ʾ������
	    ResultType(boolean a, boolean b, TreeNode n) {
	        doesExistA = a;
	        doesExistB = b;
	        node = n;
	    }
	}
	
	//findLowestCommonAncestor
    //worked, it wors for BT and BST,  this one works if two nodes are not given in the tree
    public static TreeNode findLowestCommonAncestorBT(TreeNode root, TreeNode node1, TreeNode node2) {
        if(root == null || node1 == null || node2 == null){
           return null;
        }        
        int[] count = new int[1];
//        �������У��������ֺ�������worked��
        TreeNode node = findLowestCommonAncestorBT(root, node1, node2, count);
//        TreeNode node = findLowestCommonAncestorBST(root, node1, node2, count);
//        System.out.println("count[0]: "+count[0]);
        if (count[0] == 2)
            return node;
        else
            return null;
    }

    //it only works for BT or BST,  this one works even two nodes are not in the tree
   static TreeNode findLowestCommonAncestorBT(TreeNode root, TreeNode node1, TreeNode node2, int[] count){
       if(root == null || node1 == null || node2 == null){
           return null;
       }
       TreeNode left =  findLowestCommonAncestorBT(root.left,  node1, node2, count);
       TreeNode right = findLowestCommonAncestorBT(root.right, node1, node2, count);
       if(root == node1 || root == node2){
    	   if(root == node1){
    		   count[0]++;
    	   } 
    	   if(root == node2){
    		   count[0]++;
    	   }
    	   return root;
       } 
    
        if(left!=null && right != null){
             return root;
        }
        if(left != null){
             return left;
        }
        if(right != null){
             return right;
        }
        return null;
   }

	
}
