package Lintcode.BinaryTree;

import java.util.ArrayList;

public class TreeNode {
	public int val;
//	int liss;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int val) {
		super();
		this.val = val;
	}
//	public static TreeNode defaultTenNodeTree = fromStringToTree("{1,2,3,4,5,6,7,8,9,10}");

//	public static TreeNode deserialize(String data) {
//	How to support "null" and "#" as well
    public static TreeNode fromStringToTree(String data) {
        if (data.equals("{}")) {
            return null;
        }
        data = data.trim();//remove spaces
        //�������ϣ�һ�����飬һ��list��listΪ��
        //����һ��node��list,��list������null�ڵ�,ֻ��������node
        if(!data.substring(0, 1).equals("{")) {
        		throw new IllegalArgumentException("[ERROR] MUST START WITH '{'! ");
        }
        if(!data.substring(data.length() - 1, data.length()).equals("}")) {
//    			System.out.println("[ERROR] MUST START WITH '}'! ");
    			throw new IllegalArgumentException("[ERROR] MUST START WITH '}'!");
        }
        

        String[] vals = data.substring(1, data.length() - 1).trim().split(" *, *");
        
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        list.add(root);
        int index = 0;
        boolean isLeftChild = true;
        //���������ֻҪ����null���������µ�node���������Ӻ�
        //���������null������ֻ����ռλ�����Բ���������node
        //ѭ������i��isLeftChild �� index 
        for (int i = 1; i < vals.length; i++) {
            // index = (i-1)/2;
            if (!vals[i].equals("#") && !vals[i].equals("null")) {
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

    public static String convertToString(TreeNode root){
    	return convertToString(root, "#");
    }
    
    public static String convertToString(TreeNode root, String specialCharacterForNull) {
        if (root == null) {
            return "{}";
        }
        //����һ��node��list,��list����null�ڵ�
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        //��ʱqueue size�Ƕ�̬������
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            //[����]����֮������null������������ѭ����size��������
            if (node == null) {
                continue;
            }
            //[����]����֮�������ÿ����Ƿ���null�������۾�����
            list.add(node.left);
            list.add(node.right);
        }
       //ȥ��list����Ŀ��ܵ�null
        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }
        //������ˣ�����node list����String
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(list.get(0).val);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == null) {
                sb.append(","+specialCharacterForNull);
            } else {
                sb.append(",");
                sb.append(list.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    
    
	@Override
	public String toString() {
		return "TreeNode [val=" + val + "]";
	}

    
}
