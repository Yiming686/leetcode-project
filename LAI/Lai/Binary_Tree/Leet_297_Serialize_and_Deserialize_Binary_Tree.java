package Lai.Binary_Tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Leet_297_Serialize_and_Deserialize_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> root1 = TreeNodeUtils.fromStringToTree(TreeNodeUtils.BINARY_TREE_BACK_SLASH_BACK_SLASH_DEFAULT_STRING);
		TreeNodeUtils.printTree(root1);
//		TreeNode root = TreeNodeUtils.fromStringToTree(TreeNodeUtils.BINARY_TREE_COMPLETE_DEFAULT_STRING);
		String str = serialize(root1);
		System.out.println(str);
		TreeNode<Integer> root2 = deserialize(str);		
//		TreeNodeUtils.printTree(root2);
		System.out.println(TreeNodeUtils.areSame(root1, root2));
		TreeNodeUtils.printTree(root2);
	}
	
    public static String serialize(TreeNode root) {
        if(root == null){
            return null;
        }        
        String left = serialize(root.left);        
        String right = serialize(root.right);
        String str = ""+root.val;
        return str + "," + left + "," + right;
    }
    
    public static TreeNode deserialize(String data) {
        if (data == null) {
			return null;
		}
		String[] strArr = data.split(",");
        int[] pos = new int[1];
        return deserialize(strArr, pos);
    }

    private static TreeNode deserialize(String[] data, int[] pos) {
        if (data == null) {
			return null;
		}
        if(pos[0] >= data.length){
            return null;
        }
        if(data[pos[0]].equals("null")){
        		pos[0]++;
            return null;
        }
		TreeNode root = new TreeNode(Integer.valueOf(data[pos[0]]));
        pos[0]++;
        root.left = deserialize(data, pos);
        root.right = deserialize(data, pos);
        return root;
        
    }

//   ==========	By level order ==============================================================================
    public static String serialize_by_level_order(TreeNode root) {
		if (root == null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();//not good
		queue.offer(root);
		String prefix = "";
		StringBuilder sb = new StringBuilder();		
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < queue.size(); i++) {
				TreeNode node = queue.poll();
				if (node == null) {
					sb.append(prefix);
					sb.append("null");
				} else {
					sb.append(prefix);
					sb.append("" + node.val);
					queue.offer(node.left);
					queue.offer(node.right);
				}
				prefix = ",";
			}
			
		}
		return sb.toString();
	}
    
	public static TreeNode deserialize_by_level_order(String str) {
		if (str == null) {
			return null;
		}
		String[] strArr = str.split(",");
		int index = 0;
		TreeNode root = new TreeNode(Integer.valueOf(strArr[index++]));
		Queue<TreeNode> queue = new LinkedList<>();//not good
		queue.offer(root);
		StringBuilder sb = new StringBuilder();		
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < queue.size(); i++) {
				TreeNode node = queue.poll();
				if(node == null) {
					continue;
				}
				if(strArr[index].equals("null")) {
					node.left = null;
				}else {
					node.left = new TreeNode(Integer.valueOf(strArr[index]));
				}
				queue.offer(node.left);
				index++;
				if(strArr[index].equals("null")) {
					node.right = null;
				}else {
					node.right = new TreeNode(Integer.valueOf(strArr[index]));
				}
				queue.offer(node.right);
				index++;
			}
		}
		return root;
	}
//  ==========END	By level order ==============================================================================
	
//	public static String serialize(TreeNode root) {
//		if (root == null) {
//			return null;
//		}
//		// Queue<TreeNode> queue = new ArrayQueue<>();//not good
//		Queue<TreeNode> queue = new LinkedList<>();//not good
////		Set<TreeNode> set = new HashSet<>();
//		queue.offer(root);
////		set.add(root);
//		String prefix = "";
//		StringBuilder sb = new StringBuilder();		
//		while (!queue.isEmpty()) {
//			int size = queue.size();
//			for (int i = 0; i < queue.size(); i++) {
//				TreeNode node = queue.poll();
//				if (node == null) {
//					sb.append(prefix);
//					sb.append("null");
//				} else {
//					sb.append(prefix);
//					sb.append("" + node.val);
//					queue.offer(node.left);
//					queue.offer(node.right);
//				}
//				prefix = ",";
//			}
//			
//		}
//		return sb.toString();
//	}
//	public static TreeNode<Integer> deserialize(String str) {
//		if (str == null) {
//			return null;
//		}
//		// Queue<TreeNode> queue = new ArrayQueue<>();//not good
//		String[] strArr = str.split(",");
//		int index = 0;
//		TreeNode<Integer> root = new TreeNode<>(Integer.valueOf(strArr[index++]));
//		Queue<TreeNode<Integer>> queue = new LinkedList<>();//not good
//		queue.offer(root);
//		StringBuilder sb = new StringBuilder();		
//		while (!queue.isEmpty()) {
//			int size = queue.size();
//			for (int i = 0; i < queue.size(); i++) {
//				TreeNode<Integer> node = queue.poll();
//				if(node == null) {
//					continue;
//				}
//				if(strArr[index].equals("null")) {
//					node.left = null;
//				}else {
//					node.left = new TreeNode<>(Integer.valueOf(strArr[index]));
//				}
//				queue.offer(node.left);
//				index++;
//				if(strArr[index].equals("null")) {
//					node.right = null;
//				}else {
//					node.right = new TreeNode<>(Integer.valueOf(strArr[index]));
//				}
//				queue.offer(node.right);
//				index++;
//			}
//		}
//		return root;
//	}

}
