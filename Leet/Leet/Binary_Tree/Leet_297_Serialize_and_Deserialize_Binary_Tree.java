package Leet.Binary_Tree;

import static Utils.TreeNodeUtils.printTree;

import java.util.LinkedList;
import java.util.Queue;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Leet_297_Serialize_and_Deserialize_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> root = TreeNodeUtils.fromStringToTree("{5,1,9,#,3,8,11,2,7,#,#,#,#,#,#,#,8,#,9}");
//		TreeNode<Integer> root = TreeNodeUtils.fromStringToTree("{1,2,#, 3,#, 4,#,#,#,#,#}");
//		TreeNode<Integer> root = TreeNodeUtils.fromStringToTree("{1,2,3,4,#,5,#,#,#,#,6,#}");
//		TreeNode<Integer> root = TreeNodeUtils.fromStringToTree("{}");

//		--- Pre Order -------------------------------
		printTree(root);
		String ser = serialize_preOrder(root);
		System.out.println("Pre Order   Ser: " + ser);

		TreeNode<Integer> root2 = deserialize_preOrder(ser);
		ser = serialize_preOrder(root2);
		System.out.println("Pre Order Deser: " + ser);
		printTree(root2);

//		--- Level Order when expand -------------------------------
		ser = serialize_level_order_expand(root);
		System.out.println("Level Order Expand   Ser: " + ser);
		
		root2 = deserialize_level_order_expand(ser);
		ser = serialize_level_order_expand(root2);
		System.out.println("Level Order Expand Deser: " + ser);
		printTree(root2);
		
//		--- Level Order when generate -------------------------------
		ser = serialize_level_order_generate(root);
		System.out.println("Level Order Generate   Ser: " + ser);

		root2 = deserialize_level_order_generate(ser);
		ser = serialize_level_order_generate(root2);
		System.out.println("Level Order Generate Deser: " + ser);
		printTree(root2);

	}

	private static final String SPLITER = ",";
	private static final String NULL_NODE_VALUE = "#";

	// ==========	By pre order ============    

	public static String serialize_preOrder(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}

	private static void serialize(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append(NULL_NODE_VALUE).append(SPLITER);
			return;
		}
		sb.append(root.val).append(SPLITER);
		serialize(root.left, sb);
		serialize(root.right, sb);
	}

	public static TreeNode deserialize_preOrder(String data) {
		if (data == null) {
			return null;
		}
		String[] arr = data.split(SPLITER);
		int[] pos = new int[1];
		return deserialize(arr, pos);
	}

	private static TreeNode deserialize(String[] arr, int[] pos) {
		if (arr[pos[0]].equals(NULL_NODE_VALUE)) {
			pos[0]++;
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(arr[pos[0]]));
		pos[0]++;
		root.left = deserialize(arr, pos);
		root.right = deserialize(arr, pos);
		return root;
	}

	// ==========	By level order, when expand ============    

	// public static String serialize(TreeNode root) {
	public static String serialize_level_order_expand(TreeNode root) {
		if (root == null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();//not good
		queue.offer(root);
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				sb.append(NULL_NODE_VALUE).append(SPLITER);
			} else {
				sb.append(node.val).append(SPLITER);
				queue.offer(node.left);
				queue.offer(node.right);
			}
		}
		return sb.toString();
	}

	// public static TreeNode deserialize(String str) {
	public static TreeNode deserialize_level_order_expand(String str) {
		if (str == null) {
			return null;
		}
		String[] arr = str.split(",");
		int index = 0;
		TreeNode root = new TreeNode(Integer.valueOf(arr[index++]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				continue;
			}
			if (arr[index].equals("#")) {
				node.left = null;
			} else {
				node.left = new TreeNode(Integer.valueOf(arr[index]));
			}
			queue.offer(node.left);//do sth before offer()
			index++;
			if (arr[index].equals("#")) {
				node.right = null;
			} else {
				node.right = new TreeNode(Integer.valueOf(arr[index]));
			}
			queue.offer(node.right);//do sth before offer()
			index++;
		}
		return root;
	}

	// ==========	By level order, when generate ============    

	private static String serialize_level_order_generate(TreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		sb.append(root.val).append(SPLITER);//do sth before offer()
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				continue;
			}
			sb = node.left == null ? sb.append(NULL_NODE_VALUE) : sb.append(node.left.val);
			sb.append(SPLITER);
			sb = node.right == null ? sb.append(NULL_NODE_VALUE) : sb.append(node.right.val);
			sb.append(SPLITER);
			
			queue.offer(node.left);//do sth before offer()
			queue.offer(node.right);//do sth before offer()
		}
		return sb.toString();
	}

	private static TreeNode<Integer> deserialize_level_order_generate(String data) {
		String[] arr = data.split(SPLITER);
		if (arr[0].equals(NULL_NODE_VALUE)) {
			return null;
		}
		int count = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.valueOf(arr[count]));//do sth before offer()
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				continue;
			}
			count++;
			node.left = arr[count].equals(NULL_NODE_VALUE) ? null : new TreeNode(Integer.valueOf(arr[count]));
			queue.offer(node.left);//do sth before offer()
			
			count++;
			node.right = arr[count].equals(NULL_NODE_VALUE) ? null : new TreeNode(Integer.valueOf(arr[count]));
			queue.offer(node.right);//do sth before offer()
		}
		return root;
	}

}
