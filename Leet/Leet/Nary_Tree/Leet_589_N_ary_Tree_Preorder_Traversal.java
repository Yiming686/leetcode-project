package Leet.Nary_Tree;

import java.util.ArrayList;
import java.util.List;

import Utils.SU;

public class Leet_589_N_ary_Tree_Preorder_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SU.ll("428. Serialize and Deserialize N-ary Tree\n" + 
				"");
	}

	public static List<Integer> preorder(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		preorder(root, result);
		return result;
	}

	private static void preorder(Node root, List<Integer> result) {
		if (root == null) {
			return;
		}
		result.add(root.val);
		for (Node node : root.children) {
			preorder(node, result);
		}
	}

//	class Node {
//		public int val;
//		public List<Node> children;
//
//		public Node() {
//		}
//
//		public Node(int _val) {
//			val = _val;
//		}
//
//		public Node(int _val, List<Node> _children) {
//			val = _val;
//			children = _children;
//		}
//	};

}
