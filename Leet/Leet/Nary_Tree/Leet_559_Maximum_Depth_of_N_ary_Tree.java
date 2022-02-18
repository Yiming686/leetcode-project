package Leet.Nary_Tree;

public class Leet_559_Maximum_Depth_of_N_ary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxDepth(Node root) {
		if (root == null) {
			return 0;
		}
		int max = 0;
		for (Node child : root.children) {
			max = Math.max(max, maxDepth(child));
		}
		return max + 1;
	}

}
