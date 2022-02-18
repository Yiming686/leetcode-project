package Lai.Binary_Search_Tree;

import static Utils.TreeNodeUtils.toStr;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import Utils.StringUtils;
import Utils.StringUtils.toStr;
import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;
import sun.tools.jar.resources.jar;

public class Lai_504_Closest_Number_In_Binary_Search_Tree_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new String[]{"2147483647"}), 0.0, 1
//		new String[]{"7","3","16","2","5","11","18","1","#","4","6","#","12","#","20"}), 5.0, 3
//	expected [4, 5, 6] but was: [5, 6, 4]
		System.out.println("" + Integer.MAX_VALUE);
//		TreeNode root = TreeNodeUtils.fromStringToTree("2147483647");
//		TreeNode root = TreeNodeUtils.fromStringToTree({"7","3","16","2","5","11","18","1","#","4","6","#","12","#","20"});
//		double target = 0.0;
//		int k = 1;

//		TreeNode root = TreeNodeUtils.fromStringToTree(new String[]{"7","3","16","2","5","11","18","1","#","4","6","#","12","#","20"});		
//		TreeNodeUtils.printTree(root);
//		double target = 5.0;
//		int k = 3;
//		TreeNode root = TreeNodeUtils.fromStringToTree(new String[]{"4","2","7","1","3","#","9"});		
//		TreeNodeUtils.printTree(root);
//		double target = 3.0;
//		int k = 6;
//		new String[]{"8","5","10","3","7","9","#","1","4","6","#","#","#","#","2"}), 100.0, 100
		TreeNode root = TreeNodeUtils.fromStringToTree(
				new String[] { "8", "5", "10", "3", "7", "9", "#", "1", "4", "6", "#", "#", "#", "#", "2" });
		TreeNodeUtils.printTree(root);
		double target = 7.0;
		int k = 4;

//		System.out.println(""+toStr(closestKValues_to_List(root, target, k)));
		System.out.println("" + StringUtils.toStr(closestKValues(root, target, k)));
	}

	public static int[] closestKValues(TreeNode<Integer> root, double target, int k) {
		if (root == null) {
			return null;
		}
		Deque<TreeNode<Integer>> stackToNext = new ArrayDeque<>();
		Deque<TreeNode<Integer>> stackToPrev = new ArrayDeque<>();
		initStack(stackToPrev, stackToNext, root, target);
		LinkedList<Integer> list = new LinkedList<>();
		if (stackToPrev.peekFirst().val == target) {
			list.addLast(stackToPrev.peekFirst().val);
			stackToPrev.pollFirst();
			// k--;
		}
		int[] result = new int[k];
		TreeNode<Integer> next = next(stackToNext);
		TreeNode<Integer> prev = next(stackToPrev);
		for (int i = 0; i < k - 1; i++) {
			if (prev == null && next == null) {
				break;
			} else if (prev == null) {
				list.addLast(next.val);
				next = next(stackToNext);
			} else if (next == null) {
				list.addFirst(prev.val);
				prev = next(stackToPrev);
			} else {
				if (Math.abs(next.val - target) < Math.abs(prev.val - target)) {
					list.addLast(next.val);
					next = next(stackToNext);
				} else {
					list.addFirst(prev.val);
					prev = next(stackToPrev);
				}
			}

		}
		for (int i = 0; i < k; i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	//寻找target一直到null，从root到null用target分隔开两段，左段<=,右段>, 
	private static void initStack(Deque<TreeNode<Integer>> stackToPrev, Deque<TreeNode<Integer>> stackToNext, TreeNode root, double target) {
		TreeNode<Integer> curr = root;
		while (curr != null) {
			if (curr.val == target) {
				stackToPrev.offerFirst(curr);
				curr = curr.right;
			} else if (curr.val > target) {
				stackToNext.offerFirst(curr);
				curr = curr.left;
			} else {
				stackToPrev.offerFirst(curr);
				curr = curr.right;
			}
		}
	}

	private static TreeNode next(Deque<TreeNode<Integer>> stackToNext) {
		if (stackToNext.isEmpty()) {
			return null;
		}
		TreeNode next = stackToNext.pollFirst();
		TreeNode curr = next.right;
		while (curr != null) {
			stackToNext.offerFirst(curr);
			curr = curr.left;
		}
		return next;
	}

	private static TreeNode prev(Deque<TreeNode<Integer>> stackToPrev) {
		if (stackToPrev.isEmpty()) {
			return null;
		}
		TreeNode prev = stackToPrev.pollFirst();
		TreeNode curr = prev.left;
		while (curr != null) {
			stackToPrev.offerFirst(curr);
			curr = curr.right;
		}
		return prev;
	}

//	wrong， because the stacks are not well maintained.
	public static int[] closestKValues55(TreeNode<Integer> root, double target, int k) {
		if (root == null) {
			return null;
		}
		Deque<TreeNode> stackToNext = new ArrayDeque<>();
		Deque<TreeNode> stackToPrev = new ArrayDeque<>();
		TreeNode<Integer> curr = root;
		while (curr != null) {
			if (curr.val == target) {
				stackToPrev.offerFirst(curr);
//				stackToNext.offerFirst(curr);
				curr = curr.right;
//				break;
			} else if (curr.val > target) {
//				stackToPrev.offerFirst(curr);
				stackToNext.offerFirst(curr);
				curr = curr.left;
			} else {
				stackToPrev.offerFirst(curr);
//				stackToNext.offerFirst(curr);
				curr = curr.right;
			}
		}
		//curr == null, find left and right node
		TreeNode left = null;
		TreeNode right = null;
//		curr = stackToPrev.pollFirst();
		TreeNode[] prev = new TreeNode[] { curr };
		TreeNode[] next = new TreeNode[] { curr };
		System.out.println("next:(6):" + next(stackToNext, next).val);
		System.out.println("next:(7):" + next(stackToNext, next).val);
		System.out.println("next:(8):" + next(stackToNext, next).val);
		System.out.println("prev:(4):" + prev(stackToPrev, prev).val);
		System.out.println("prev:(3):" + prev(stackToPrev, prev).val);
		System.out.println("prev:(2):" + prev(stackToPrev, prev).val);
		if (curr.val > target) {
			left = prev(stackToPrev, prev);
			right = curr;
		} else {
			left = curr;
			right = next(stackToNext, next);
		}

		int[] result = new int[k];
		// find first
		TreeNode<Integer> first = left;
		TreeNode<Integer> last = right;
		TreeNode prevFirst = left;
		TreeNode prevLast = right;

		int count = k;
		while (first != null && last != null && count > 0) {
			if (Math.abs(first.val - target) < Math.abs(last.val - target)) {
				prev[0] = first;
				prevFirst = first;
				first = prev(stackToPrev, prev);
			} else {
				next[0] = last;
				prevLast = last;
				last = prev(stackToNext, next);
			}
			count--;
		}
		// if(first == null){
		//   first = prevFirst;
		// }
		if (last == null) {
			while (first != null && count > 0) {
				prev[0] = first;
				prevFirst = first;
				first = prev(stackToPrev, prev);
				count--;
			}
		}
		first = prevFirst;
		// from first to kth
		for (int i = 0; i < k; i++) {
			result[i] = first.val;
			next[0] = first;
			first = next(stackToPrev, next);
		}
		return result;
	}

	private static TreeNode next(Deque<TreeNode> stack, TreeNode[] nodes) {
		TreeNode node = stack.pollFirst();//第二次遇到
		TreeNode curr = node.right;
		while (curr != null) {
			stack.offerFirst(curr);
			curr = curr.left;
		}
		return node;
	}

	private static TreeNode prev(Deque<TreeNode> stack, TreeNode[] nodes) {
		TreeNode node = stack.pollFirst();//第二次遇到
		TreeNode curr = node.left;
		while (curr != null) {
			stack.offerFirst(curr);
			curr = curr.right;
		}
		return node;
	}

	private static TreeNode next3(Deque<TreeNode> stack, TreeNode[] nodes) {
		TreeNode node = stack.pollFirst();
		TreeNode curr = node.right;

		TreeNode node2 = null;
		while (curr != null || !stack.isEmpty()) {
			if (curr != null) {
				stack.offerFirst(curr);
				curr = curr.left;
			} else {
//                node2 = stack.pollFirst();
				node2 = stack.peekFirst();
				curr = node2.right;
				break;
			}

		}
//		nodes[0] = node2;
		return node2;
	}

	private static TreeNode prev3(Deque<TreeNode> stack, TreeNode[] nodes) {
		TreeNode node = stack.pollFirst();
		TreeNode curr = node.left;

		TreeNode node2 = null;
		while (curr != null || !stack.isEmpty()) {
			if (curr != null) {
				stack.offerFirst(curr);
				curr = curr.right;
			} else {
//                node2 = stack.pollFirst();
				node2 = stack.peekFirst();
				curr = node2.left;
				break;
			}

		}
//		nodes[0] = node2;
		return node2;
	}

	private static TreeNode next0(Deque<TreeNode> stack, TreeNode[] node) {
		if (node[0] != null || !stack.isEmpty()) {
			while (node[0] != null) {
				stack.offerFirst(node[0]);
				node[0] = node[0].left;
			}
			TreeNode next = stack.pollFirst();
			node[0] = next.right;
			return next;
		} else {
			return null;
		}
	}

	private static TreeNode prev2(Deque<TreeNode> stack, TreeNode[] node) {
		if (node[0] != null || !stack.isEmpty()) {
			while (node[0] != null) {
				stack.offerFirst(node[0]);
				// node[0] = node[0].left;
				node[0] = node[0].right;
			}
			TreeNode prev = stack.pollFirst();
			node[0] = prev.left;
			return prev;
		} else {
			return null;
		}
	}

	public static int[] closestKValues_to_List(TreeNode<Integer> root, double target, int k) {
		LinkedList<Integer> list = new LinkedList<>();
		traverse(root, list);
		System.out.println("" + list);
		int left = largestSmallerOrEqual(list, target);
		int right = left + 1;
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			if (right >= list.size() || left >= 0 && target - list.get(left) < list.get(right) - target) {
//				result[i] = list.get(left--);
				left--;
			} else {
//				result[i] = list.get(right++);
				right++;
			}
		}
		left++;
		for (int i = 0; i < k; i++) {
			result[i] = list.get(left++);
		}
		return result;
	}

	private static int largestSmallerOrEqual(LinkedList<Integer> list, double target) {
		int left = 0;
		int right = list.size() - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			int val = list.get(mid);
			if (val - target == 0.) {
				// if(Math.abs(val - target) < 0.0001){        
				return mid;
			} else if (val < target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (list.get(right) <= target) {
			return right;
		}
		if (list.get(left) <= target) {
			return left;
		}
		return -1;
	}

	private static void traverse(TreeNode<Integer> root, LinkedList<Integer> list) {
		if (root == null) {
			return;
		}
		traverse(root.left, list);
		list.add(root.val);
		traverse(root.right, list);
	}

}
