package Leet.Binary_Tree.View;

import static Utils.TreeNodeUtils.printTreeByTP;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Leet_987_Vertical_Order_Traversal_of_a_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode<Integer> root = TreeNodeUtils
//		.fromStringToTree("{5,1,9,#,3,8,11,2,#,#,6,#,#,7,#,#,9,8,#, #,10, 9,#,#,12,18,#,#,#}");
//		TreeNode<Integer> root = TreeNodeUtils
//				.fromStringToTree("{5,1,9,#,3,8,11,2,#,#,6,#,#,7,#,#,9,8,#, #,10, 9,#,#,12,#,#, #,20, #, 33}");
//		TreeNode<Integer> root = TreeNodeUtils.fromStringToTree("[0,2,1,3,null,null,null,4,5,null,7,6,null,10,8,11,9]");
		TreeNode<Integer> root = TreeNodeUtils.fromStringToTree(
				"[0,2,1,3,null,5,22,9,4,12,25,null,null,13,14,8,6,null,null,null,null,null,27,24,26,null,17,7,null,28,null,null,null,null,null,19,null,11,10,null,null,null,23,16,15,20,18,null,null,null,null,null,21,null,null,29]");
//TreeNodeUtils.printTree(root);
//TreeNodeUtils.printTreeByTP(root, false);
//TreeNodeUtils.printTreeByTP(root);
//printTree(root);
		printTreeByTP(root, true);
		System.out.println("verticalTraversal: " + verticalTraversal(root));
		TreeSet<Integer> set = new TreeSet<>();
	}

	public static List<List<Integer>> verticalTraversal(TreeNode root) {
		// Each location is a node's x position, y position, and value
		List<Location> locations = new ArrayList();
		dfs(locations, root, 0, 0);
		Collections.sort(locations);
		List<List<Integer>> ans = new ArrayList();
		ans.add(new ArrayList<Integer>());
		int prev = locations.get(0).x;
		for (Location loc : locations) {
			// If the x value changed, it's part of a new report.
			if (loc.x != prev) {
				prev = loc.x;
				ans.add(new ArrayList<Integer>());
			}
			// We always add the node's value to the latest report.
			ans.get(ans.size() - 1).add(loc.val);
		}
		return ans;
	}

	public static void dfs(List<Location> locations, TreeNode<Integer> node, int x, int y) {
		if (node == null) {
			return;
		}
		locations.add(new Location(x, y, node.val));
		dfs(locations, node.left, x - 1, y + 1);
		dfs(locations, node.right, x + 1, y + 1);
	}
	
	static class Location implements Comparable<Location> {
		int x, y, val;
		
		public Location(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
		
		@Override
		public int compareTo(Location that) {
			if (this.x != that.x)
				return Integer.compare(this.x, that.x);
			else if (this.y != that.y)
				return Integer.compare(this.y, that.y);
			else
				return Integer.compare(this.val, that.val);
		}
	}
	

	//not work, because if nodes that have the same coordinates are not sorted
	public static List<List<Integer>> verticalTraversal_00(TreeNode<Integer> root) {
		LinkedList<List<Integer>> result = new LinkedList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		if (root == null) {
			return result;
		}
		int minCol = 0;
		int maxCol = 0;
		Deque<NodeWithColumn> queue = new ArrayDeque<>();
		queue.offer(new NodeWithColumn(root, 0));
		List<Integer> currList = new ArrayList<>();
		currList.add(root.val);
		map.put(0, currList);
		result.addFirst(currList);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				NodeWithColumn currNode = queue.poll();
//				System.out.println(""+curr.node.val);
				if (currNode.node.left != null) {
					//possible to update minCol
					if (currNode.col == minCol) {
						minCol--;
						currList = new ArrayList<>();
						currList.add(currNode.node.left.val);
						map.put(minCol, currList);
						result.addFirst(currList);
					} else {
						currList = map.get(currNode.col - 1);
						currList.add(currNode.node.left.val);
					}
					queue.offer(new NodeWithColumn(currNode.node.left, currNode.col - 1));
				}
				if (currNode.node.right != null) {
					//possible to update maxCol
					if (currNode.col == maxCol) {
						maxCol++;
						currList = new ArrayList<>();
						currList.add(currNode.node.right.val);
						map.put(maxCol, currList);
						result.addLast(currList);
					} else {
						currList = map.get(currNode.col + 1);
						currList.add(currNode.node.right.val);
					}
					queue.offer(new NodeWithColumn(currNode.node.right, currNode.col + 1));
				}
			}
		}

		return result;
	}

	public static List<Integer> topSideView_ite(TreeNode<Integer> root) {
		LinkedList<Integer> result = new LinkedList<>();//
		if (root == null) {
			return result;
		}
		int minCol = 0;
		int maxCol = 0;
		Deque<NodeWithColumn> queue = new ArrayDeque<>();
		queue.offer(new NodeWithColumn(root, 0));
		result.addFirst(root.val);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				NodeWithColumn curr = queue.poll();
//				System.out.println(""+curr.node.val);
				if (curr.node.left != null) {
					//possible to update minCol
					if (curr.col == minCol) {
						minCol--;
						result.addFirst(curr.node.left.val);
					}
					queue.offer(new NodeWithColumn(curr.node.left, curr.col - 1));
				}
				if (curr.node.right != null) {
					//possible to update maxCol
					if (curr.col == maxCol) {
						maxCol++;
						result.addLast(curr.node.right.val);
					}
					queue.offer(new NodeWithColumn(curr.node.right, curr.col + 1));
				}
			}
		}
		return result;
	}

	static class NodeWithColumn {
		TreeNode<Integer> node;
		int col;

		public NodeWithColumn(TreeNode node, int col) {
			this.node = node;
			this.col = col;
		}
	}

}
