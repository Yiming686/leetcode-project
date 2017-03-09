package Lintcode.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
Binary Tree Serialization

 Description
 Notes
 Testcase
 Judge
Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.

There is no limit of how you deserialize or serialize a binary tree, you only need to make sure you can serialize a binary tree to a string and deserialize this string to the original structure.

Have you met this question in a real interview? Yes
Example
An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:

  3
 / \
9  20
  /  \
 15   7
Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.

You can use other method to do serializaiton and deserialization.

Tags 
Binary Tree Microsoft Yahoo
Related Problems 
Hard Trie Serialization 35 %
Medium Tiny Url 28 %
Medium Search Range in Binary Search Tree 37 %


 *
 *
 */
public class Binary_Tree_Serialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String TreeNodeStrIn ="{1,2,4,2,3}";
		TreeNodeStrIn ="{1,2,3,#,#,4,5,#,#,#,6,7,#}";
		TreeNodeStrIn ="{3,9,20,#,#,15,7}";
		TreeNodeStrIn ="{1,2,3,#,#,4,#,5,#,6,#,7,#}";
		TreeNodeStrIn ="{1,2,3,#,#,#,#}";
		TreeNodeStrIn ="{1,#,2}";
//		TreeNodeStrIn ="{3}";
		TreeNode root = TreeNode.fromStringToTree(TreeNodeStrIn);
//		System.out.println(""+serialize11(root));
//		System.out.println(""+serialize12(root));
//		String str = "{7}";
//		System.out.println(""+TreeNode.convertToString(deserialize44(str)));
		System.out.println(""+TreeNode.convertToString(deserialize44(TreeNodeStrIn)));

	}
	
    public static TreeNode deserialize44(String data) {
        if (data == null || !data.startsWith("{") ||!data.endsWith("}")|| data.equals("{}")) {
            return null;
        }
        
        //�������ϣ�һ�����飬һ��list��listΪ��
        String[] vals = data.substring(1, data.length() - 1).split(",");
        int len = vals.length;
        int index = 0;
        TreeNode root = new TreeNode(Integer.valueOf(vals[index++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node!=null){
                    if(index < len && !vals[index].equals("#")){
                        node.left = new TreeNode(Integer.valueOf(vals[index++]));
                    }else{
                        node.left = null;
                    }
                    if(index < len &&!vals[index].equals("#")){
                        node.right = new TreeNode(Integer.valueOf(vals[index++]));
                    }else{
                        node.right = null;
                    }
                    queue.offer(node.left);
                    queue.offer(node.right);
                }else{
                    
                }
            }
        }
        return root;
    }

    public static String serialize11(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        //����һ��node��list
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
//        while (list.get(list.size() - 1) == null) {
//            list.remove(list.size() - 1);
//        }
        //������ˣ�����node list����String
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(list.get(0).val);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == null) {
                // sb.append(",null");
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(list.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }
	
    public static String serialize12(TreeNode root) {
        String result = "";
        if(root == null) return result;
        result += "[";
        String prefix = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node != null){
                    result += prefix + node.val;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }else{
                    result += prefix + "#";
                }
            }
            prefix = ",";
        }
//        while(result.endsWith(",#")){
//            result = result.substring(0, result.length() - 2);
//        }
        result += "]";
        return result;
    }

    
    public static TreeNode deserialize11(String data) {
        if (data.equals("{}")) {
            return null;
        }
        //�������ϣ�һ�����飬һ��list��listΪ��
        String[] vals = data.substring(1, data.length() - 1).split(",");
        List<TreeNode> list = new ArrayList<TreeNode>();
        
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        list.add(root);
        int index = 0;
        boolean isLeftChild = true;
        //���������ֻҪ����null���������µ�node���������Ӻ�
        //���������null������ֻ����ռλ�����Բ���������node
        //ѭ������i��isLeftChild �� index 
        for (int i = 1; i < vals.length; i++) {
            // index = (i-1)/2;
            // if (!vals[i].equals("null")) {
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
                index++;//ѭ����������������ʱ�����ӣ����Һ��Ӳ������һ��
            }
            // index = i/2;
            isLeftChild = !isLeftChild;//ѭ������
        }
        return root;
    }
 
    
}
