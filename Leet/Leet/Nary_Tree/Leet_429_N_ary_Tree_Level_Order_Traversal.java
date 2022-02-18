package Leet.Nary_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leet_429_N_ary_Tree_Level_Order_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		levelOrder(root, result);
		return result;
	}

	private void levelOrder(Node root, List<List<Integer>> result) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				list.add(node.val);
				for (Node child : node.children) {
					queue.offer(child);
				}
			}
			result.add(list);
		}
	}

}
