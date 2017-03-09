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
	
}
