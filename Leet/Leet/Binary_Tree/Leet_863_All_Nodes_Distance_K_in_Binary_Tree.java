package Leet.Binary_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import Utils.TreeNodeUtils.TreeNode;

public class Leet_863_All_Nodes_Distance_K_in_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> result = new ArrayList();
		if (root == null) {
			return result;
		}
		List<TreeNode> list = new ArrayList();
		Map<TreeNode, TreeNode> node2ParentMap = new HashMap();
		dfs(root, null, node2ParentMap);
		Queue<TreeNode> queue = new LinkedList();
		queue.add(target);
		Set<TreeNode> visited = new HashSet();
		visited.add(target);
		int dist = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (dist == k) {//if its self, when k == 0
					list.add(node);
				} else {
					if (node.left != null && visited.add(node.left)) {
						queue.offer(node.left);
					}
					if (node.right != null && visited.add(node.right)) {
						queue.offer(node.right);
					}
					TreeNode par = node2ParentMap.get(node);
					if (par != null && visited.add(par)) {
						queue.offer(par);
					}
				}
			}
			dist++;
		}
		for(TreeNode<Integer> node : list) {
			result.add(node.val);
		}
		return result;
	}

	public static void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> node2ParentMap) {
		if (node == null) {
			return;
		}
		node2ParentMap.put(node, parent);
		dfs(node.left, node, node2ParentMap);
		dfs(node.right, node, node2ParentMap);
	}

}
