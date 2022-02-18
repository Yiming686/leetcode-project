package Leet.Nary_Tree;

import java.util.ArrayList;

import Utils.SU;

public class Leet_428_Serialize_and_Deserialize_N_ary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SU.ll("524. Longest Word in Dictionary through Deleting\n" + 
		"");
	}

	private static final String SPLITTER = ",";
	private static final String NULL_NODE_VALUE = "#";
	private static final String OPEN = "[";
	private static final String CLOSE = "]";

//  如何处理null节点? 对于二叉树，用#，表示此分支终结; 对于多叉树，如果root为null, 返回空字符串；
//  其实对null可以有两种选择：[]或者""
//  但其实本题的实现仅仅处理了非null节点，只到叶子节点, 这是只需标记好
	// Encodes a tree to a single string.
	public static String serialize(Node root) {
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}

	// [,1, [,3, [,5,], [,6,], ], [,2,], [,4,],],
	private static void serialize(Node root, StringBuilder sb) {
		if (root == null) {
			// sb.append(OPEN).append(NULL_NODE_VALUE).append().append(CLOSE);
			return;
		}
		sb.append(OPEN).append(SPLITTER).append(root.val).append(SPLITTER);
		for (Node node : root.children) {//make sure children is not null
			serialize(node, sb);
		}
		sb.append(CLOSE).append(SPLITTER);
	}

	// [,1, [,3, [,5,], [,6,], ], [,2,], [,4,],],
	// Decodes your encoded data to tree.
	public static Node deserialize(String data) {
		if (data == null || data.length() == 0) {
			return null;
		}
		String[] arr = data.split(SPLITTER);
		int[] pos = new int[1];
		return deserialize(arr, pos);
	}

//  为什么可以呢？编码的时候，已经保证依次添加，所以解码的时候，也需要依次向后扫描，
	private static Node deserialize(String[] arr, int[] pos) {
		pos[0]++;//"["
		Node root = new Node(Integer.valueOf(arr[pos[0]]), new ArrayList<>());//find value
		// Node root = new Node(Integer.valueOf(arr[pos[0]]));
		pos[0]++;
		// while(!arr[pos[0]].equals(CLOSE)){
		while (arr[pos[0]].equals(OPEN)) {
			root.children.add(deserialize(arr, pos));
		}
		pos[0]++;// "]"
		return root;
	}

}
