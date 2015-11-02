package LeetCode.JavaTree;

public class LC_098_Validate_Binary_Search_Tree {

	//第一个方法，效率最高的，仅仅和当前node 的之前值对比
    //指向当前node之前的最小的node，用来了当前node比较 
	//可以是任何值，不影响结果    
    private  int lastVal = 0;
    //标记是第一个node吗？因为中序遍历，所以默认true，以后全部为false
    private boolean firstNode = true;
//    BEST Solution
    public boolean isValidBST(TreeNode root) {
    	//第一部分：Base Cases
        if (root == null) {
            return true;
        }
        //第二部分：遍历左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        //第三部分：处理当前node，分两种情况，分别处理
        //因为中序遍历，真正第一句是从这里开始执行的，所以第一次时，root是第一个node，以后都不是，所以整个程序里面没有一句是设置firstNode为true的
        //找到整个BST树的第一个node，执行如下两行
        if(firstNode == true) {
            firstNode = false;
            lastVal = root.val;
        //除此以外，当root不是整个BST树的第一个node，开始执行如下
        }else{
            if (lastVal >= root.val) {
                return false;
            }
            lastVal = root.val;
        }
        //第四部分：遍历右子树 
        if (!isValidBST(root.right)) {
            return false;
        }
        //第五部分：经历以上四步，现在可以给出结论，此时返回真
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

    //应用divide-conquer策略
    private ResultType validateHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        //求左子树的信息：是否BST以及最大最小值
        ResultType left = validateHelper(root.left);
            //求右子树的信息：是否BST以及最大最小值
        ResultType right = validateHelper(root.right);
        // 先根据左右子树的信息来判断
        if (!left.is_bst || !right.is_bst) {
            // if is_bst is false then minValue and maxValue are useless
            return new ResultType(false, 0, 0);
        }
        // 根据当前root和左右子树信息来判断,这才是BST的本质属性的判断
        // 考察点：注意等号不能少
        if (root.left != null && left.maxValue >= root.val || 
              root.right != null && right.minValue <= root.val) {
            return new ResultType(false, 0, 0);
        }
        //经过以上判断，当前是BST，并求最大最小值
        //考察点：拓展当前node的最大最小值范围
        return new ResultType(true, Math.max(root.val, right.maxValue), Math.min(root.val, left.minValue));
    }

}