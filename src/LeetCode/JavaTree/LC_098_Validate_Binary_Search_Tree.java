package LeetCode.JavaTree;

public class LC_098_Validate_Binary_Search_Tree {

	//��һ��������Ч����ߵģ������͵�ǰnode ��֮ǰֵ�Ա�
    //ָ��ǰnode֮ǰ����С��node�������˵�ǰnode�Ƚ� 
	//�������κ�ֵ����Ӱ����    
    private  int lastVal = 0;
    //����ǵ�һ��node����Ϊ�������������Ĭ��true���Ժ�ȫ��Ϊfalse
    private boolean firstNode = true;
//    BEST Solution
    public boolean isValidBST(TreeNode root) {
    	//��һ���֣�Base Cases
        if (root == null) {
            return true;
        }
        //�ڶ����֣�����������
        if (!isValidBST(root.left)) {
            return false;
        }
        //�������֣�����ǰnode��������������ֱ���
        //��Ϊ���������������һ���Ǵ����￪ʼִ�еģ����Ե�һ��ʱ��root�ǵ�һ��node���Ժ󶼲��ǣ�����������������û��һ��������firstNodeΪtrue��
        //�ҵ�����BST���ĵ�һ��node��ִ����������
        if(firstNode == true) {
            firstNode = false;
            lastVal = root.val;
        //�������⣬��root��������BST���ĵ�һ��node����ʼִ������
        }else{
            if (lastVal >= root.val) {
                return false;
            }
            lastVal = root.val;
        }
        //���Ĳ��֣����������� 
        if (!isValidBST(root.right)) {
            return false;
        }
        //���岿�֣����������Ĳ������ڿ��Ը������ۣ���ʱ������
        return true;
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class LC_098_Validate_Binary_Search_Tree2 {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    class ResultType {
        boolean is_bst;
        int maxValue, minValue;
        
        ResultType(boolean is_bst, int maxValue, int minValue) {
            this.is_bst = is_bst;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        ResultType r = validateHelper(root);
        return r.is_bst;
    }

    //Ӧ��divide-conquer����
    private ResultType validateHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        //������������Ϣ���Ƿ�BST�Լ������Сֵ
        ResultType left = validateHelper(root.left);
            //������������Ϣ���Ƿ�BST�Լ������Сֵ
        ResultType right = validateHelper(root.right);
        // �ȸ���������������Ϣ���ж�
        if (!left.is_bst || !right.is_bst) {
            // if is_bst is false then minValue and maxValue are useless
            return new ResultType(false, 0, 0);
        }
        // ���ݵ�ǰroot������������Ϣ���ж�,�����BST�ı������Ե��ж�
        // ����㣺ע��ȺŲ�����
        if (root.left != null && left.maxValue >= root.val || 
              root.right != null && right.minValue <= root.val) {
            return new ResultType(false, 0, 0);
        }
        //���������жϣ���ǰ��BST�����������Сֵ
        //����㣺��չ��ǰnode�������Сֵ��Χ
        return new ResultType(true, Math.max(root.val, right.maxValue), Math.min(root.val, left.minValue));
    }

}