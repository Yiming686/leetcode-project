package Leet.Binary_Tree.SerDeser;

import java.util.ArrayList;
import java.util.List;

public class Leet_428_Serialize_and_Deserialize_N_ary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node1 = new Node(1, new ArrayList<>());
		Node node2 = new Node(2, new ArrayList<>());
		Node node3 = new Node(3, new ArrayList<>());
		Node node4 = new Node(4, new ArrayList<>());
		Node node5 = new Node(5, new ArrayList<>());
		Node node6 = new Node(6, new ArrayList<>());
		node1.children.add(node3);
		node1.children.add(node2);
		node1.children.add(node4);
		node3.children.add(node5);
		node3.children.add(node6);
		Node root = node1;
//		Node root = null;
		System.out.println("Ser:"+serialize(root));
		Node newRoot = deserialize(serialize(root));
		System.out.println("Ser:"+serialize(newRoot));
//		System.out.println("Ser:"+deserialize(data);
	}

	private static final String SPLITTER = ",";
	private static final String NULL_NODE_VALUE = "#";
    private static final String OPEN = "[";
    private static final String CLOSE = "]";

//  如何处理null节点? 对于二叉树，用#，对于多叉树，如果root为null返回空字符串；
//   树和子树，只要是树，开始为[,紧接着是值，如果有子树，递归求取，子字符串其还是以[开始，以]结尾，最后以 ] 结尾
    // Encodes a tree to a single string.
    public static String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    // [,1, [,3, [,5,], [,6,], ], [,2,], [,4,],],
    private static void serialize(Node root, StringBuilder sb){
        if(root == null){
            // sb.append(OPEN).append(NULL_NODE_VALUE).append().append(CLOSE);
            return;
        }   
        sb.append(OPEN).append(SPLITTER).append(root.val).append(SPLITTER);
        for(Node node : root.children){
            serialize(node, sb);
        }
        sb.append(CLOSE).append(SPLITTER);
    }

    // [,1, [,3, [,5,], [,6,], ], [,2,], [,4,],],
    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {
        if(data == null || data.length() == 0){
            return null;
        }         
        String[] arr = data.split(SPLITTER);
        int[] pos = new int[1];
        return deserialize(arr, pos);
    }
    
    private static Node deserialize(String[] arr, int[] pos){
        pos[0]++;//"["
        Node root = new Node(Integer.valueOf(arr[pos[0]]), new ArrayList<>());
        pos[0]++;
        while(!arr[pos[0]].equals(CLOSE)){
            root.children.add(deserialize(arr, pos));
        }    
        pos[0]++;//"]"
        return root;
    }
	
	static class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};

}
