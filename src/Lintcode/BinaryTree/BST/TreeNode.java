package Lintcode.BinaryTree.BST;

import java.util.ArrayList;

public class TreeNode {
	int val;
	int liss;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		super();
		this.val = val;
	}
	public static TreeNode defaultTenNodeTree = fromStringToTree("{1,2,3,4,5,6,7,8,9,10}");

//	public static TreeNode deserialize(String data) {
    public static TreeNode fromStringToTree(String data) {
        if (data.equals("{}")) {
            return null;
        }
        //待处理集合，一个数组，一个list，list为空
        //生成一个node的list,此list不包含null节点,只用来连接node
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        list.add(root);
        int index = 0;
        boolean isLeftChild = true;
        //数组里面的只要不是null必须生成新的node，并且连接好
        //数组里面的null不处理，只用来占位，所以不会生成新node
        //循环变量i，isLeftChild 和 index 
        for (int i = 1; i < vals.length; i++) {
            // index = (i-1)/2;
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    list.get(index).left = node;
                } else {
                    list.get(index).right = node;
                }
                list.add(node);
            }
            if (!isLeftChild) {
                index++;
            }
            // index = i/2;
            isLeftChild = !isLeftChild;
        }
        return root;
    }

//    public static String serialize(TreeNode root) {
    public static String fromTreeToString(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        //生成一个node的list,此list包含null节点
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        //此时queue size是动态增长的
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            //[考点]精彩之处，是null跳过，不会死循环，size不会增长
            if (node == null) {
                continue;
            }
            //[考点]精彩之处，不用考察是否是null，闭着眼睛加入
            list.add(node.left);
            list.add(node.right);
        }
       //去除list后面的可能的null
        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }
        //下面简单了，根据node list生成String
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(list.get(0).val);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(list.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

}
