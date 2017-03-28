package Company.Amazon;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Stack;

import Lintcode.BinaryTree.TreeNode;

/**

A binary search tree (BST) is defined as a binary tree in which each node satisfies the property 
such that its value is larger than the value of every node in its left subtree, and 
less than or equal to the value of every node in its right subtree. The distance 
between two values in a binary search tree is the minimum number of edges traversed 
to reach from one value to the other.

Given a list of n unique integers, construct a BST by inserting each integer in the given order
 without rebalancing the tree. Then, find the distance between the two given nodes, node1 and node2, 
 of the BST. In case, either node1 or node2 is not present in the tree, return -1. 

Input
The input to the function/method consists of four arguments - 
values, representing a list of integers;
n, an integer representing the number of elements in the list; 
node1, an integer representing the first node and 
node2, an integer representing the second node.

Output
Return an integer representing the distance between node1 and node2, else return -1, 
if either node1 or node2 is not present in the tree.

[9,7,5,3,1], 5,7,20       ==> -1
[5,6,3,1,2,4] 6,2,4  ==>  3

 *
 *
 */
public class BST_Distance {

	public static void main(String[] args) {
//		Stack<Integer> stack = new Stack();

//		System.out.println(""+Character.isLetter('a'));
//		System.out.println(""+Character.isLetter('f'));
//		System.out.println(""+Character.isLetter('.'));
//		System.out.println(""+Character.isLetter(' '));
//		System.out.println(""+Character.isLetter('B'));
//		System.out.println(""+Character.isLetter('P'));
//		System.out.println(""+Character.isDigit('P'));
//		System.out.println(""+Character.isDigit('c'));
//		System.out.println(""+Character.isDigit('6'));
//		System.out.println(""+Character.isDigit('0'));
		
		int[] arr = { 5, 6, 3, 1, 2, 4 };
//		System.out.println(""+TreeNode.convertToString(help(arr)));
		System.out.println(""+Arrays.toString(arr));
		System.out.println("" + bstDistance(arr, arr.length, 2, 4));
//		for(int i = 0; i<arr.length; i++){
//			System.out.println("3 <--> "+arr[i]+", Distance is: " + bstDistance(arr, arr.length, 3, arr[i]));
//		}
	}

	
	public static int bstDistance(int[] values, int n, int node1, int node2) {
		// WRITE YOUR CODE HERE
		if (n == 0) {
			return -1;
		}
//		As required, construct a BST， 依次插入node，成功返回true，失败返回false
		TreeNode root = new TreeNode(values[0]);
		for (int i = 1; i < n; i++) {
			if (!help(root, values[i])) {
				return -1;
			}
		}
//		System.out.println(""+TreeNode.convertToString(root));
//		树建立好了，开始计算距离
		int[] found = new int[1];
		int result = find(root, node1, node2, found);
		return found[0] == 2 ? result : -1;//如果都发现，返回距离
	}

	// METHOD SIGNATURE ENDS

//	当前BST树里面插入一个node包含这个value, 返回插入是否成功
	private static boolean help(TreeNode root, int val) {
		if (val > root.val) {
			if (root.right == null) {
				TreeNode newNode = new TreeNode(val);
				root.right = newNode;
			} else {
				help(root.right, val);
			}
		} else if (val < root.val) {
			if (root.left == null) {
				TreeNode newNode = new TreeNode(val);
				root.left = newNode;
			} else {
				help(root.left, val);
			}
		} else {
			// no duplicate
			return false;
		}
		return true;
	}

//	在树root，寻找a和b并计算a到b之间的距离，found统计找到几个
	private static int find(TreeNode root, int a, int b, int[] found) {
		if (root == null) {
			return -1;
		}

		int left  = find(root.left,  a, b, found);//返回距离
		int right = find(root.right, a, b, found);//返回距离
//		System.out.println(MessageFormat.format("==> root:{0},a:{1},b:{2} ", root.val,a,b));
		System.out.println(MessageFormat.format("==> root:{0},a:{1},b:{2},left:{3},right:{4} ", root.val,a,b, left, right));
		if (root.val == a || root.val == b) {
			if(a == b) return 0;
			found[0]++;
			if (left != -1 || right != -1) {//左找到或者右找到
				return left == -1 ? right : left;
			} else {
				return 1;//都没有找到,距离为1
			}
		} else {
			if (left == -1 && right == -1) {
				return -1;
			} else if (left == -1 || right == -1) {
				if (found[0] == 2) {
					return left == -1 ? right : left;
				} else {
					return left == -1 ? right + 1 : left + 1;
				}
			} else {
				return left + right;
			}
		}
//		if(a==b) return 0;
	}

	private static TreeNode build(int[] arr) {
		if(arr == null) return null;
		Arrays.sort(arr);
		return build(arr, 0, arr.length - 1);
	}
	private static TreeNode build(int[] arr, int start, int end) {
		if(arr == null) return null;
		if(start > end) return null;
		int mid = start + (end - start)/2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = build(arr, start, mid-1);
		root.right = build(arr, mid + 1,end);
		return root;
	}
	
	private static void insertNode(TreeNode root, int val) {
		if (val > root.val) {
			if (root.right == null) {
				TreeNode newNode = new TreeNode(val);
				root.right = newNode;
			} else {
				insertNode(root.right, val);
			}
		} else if (val < root.val) {
			if (root.left == null) {
				TreeNode newNode = new TreeNode(val);
				root.left = newNode;
			} else {
				insertNode(root.left, val);
			}
		} else {
			// no duplicate
		}
	}

	
	public static int totalScore(String[] blocks, int n)
	{
		// WRITE YOUR CODE HERE
		// assume there is no integer overflow
		Stack<Integer> stack = new Stack<Integer>();
		if (blocks == null || blocks.length == 0) {
			return 0;
		}
		for (int i = 0; i < n; i++) {
			// assume is there is any sign or null in the blocks, just ignore it
			String sign = blocks[i];
			if (sign == null) {
				continue;
			}
			if (sign.equals("X")) {
				int peek = 0;
				if (stack.size() > 0) {
					peek = stack.peek();
				}
				stack.push(peek * 2);
			} else if (sign.equals("Z")) {
				if (stack.size() > 0) {
					stack.pop();
				}
			} else if (sign.equals("+")) {
				int peek1 = 0, peek2 = 0;
				if (stack.size() > 0) {
					peek1 = stack.pop();
					if (stack.size() > 0) {
						peek2 = stack.peek();
					}
					stack.push(peek1);
				}

				stack.push(peek1 + peek2);
			} else {
				int num = Integer.valueOf(sign);
				stack.push(num);
			}
		}
		int count = 0;
		while (stack.size() > 0) {
			count += stack.pop();
		}
		return count;		
	}

}


//public static int bstDistance2(int[] values, int n, int node1, int node2) {
//	if (n == 0) {
//		return -1;
//	}
//	TreeNode root = new TreeNode(values[0]);
//	for (int i = 1; i < n; i++) {
//		if (!help(root, values[i])) {
//			return -1;
//		}
//	}
//	int[] found = new int[1];
//	int result = find(root, node1, node2, found);
//	return found[0] == 2 ? result : -1;
//}
//
//// METHOD SIGNATURE ENDS
//
////当前BST树里面插入一个node包含这个value, 返回插入是否成功
//private static boolean help(TreeNode root, int val) {
//	if (val > root.val) {
//		if (root.right == null) {
//			TreeNode newNode = new TreeNode(val);
//			root.right = newNode;
//		} else {
//			help(root.right, val);
//		}
//	} else if (val < root.val) {
//		if (root.left == null) {
//			TreeNode newNode = new TreeNode(val);
//			root.left = newNode;
//		} else {
//			help(root.left, val);
//		}
//	} else {
//		// no duplicate
//		return false;
//	}
//	return true;
//}
//
//private static int find(TreeNode root, int a, int b, int[] found) {
//	if (root == null) {
//		return -1;
//	}
//
//	int left  = find(root.left,  a, b, found);
//	int right = find(root.right, a, b, found);
//	if (root.val == a || root.val == b) {
//		found[0]++;
//		if (left != -1 || right != -1) {
//			return left == -1 ? right : left;
//		} else {
//			return 1;
//		}
//	} else {
//		if (left == -1 && right == -1) {
//			return -1;
//		} else if (left == -1 || right == -1) {
//			if (found[0] == 2) {
//				return left == -1 ? right : left;
//			} else {
//				return left == -1 ? right + 1 : left + 1;
//			}
//		} else {
//			return left + right;
//		}
//	}
//}
