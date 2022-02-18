package Leet.Nary_Tree;

import java.util.ArrayList;
import java.util.List;

public class Leet_590_N_ary_Tree_Postorder_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        postorder(root, result);
        return result;
    }
    
    private void postorder(Node root, List<Integer> result){
        if(root == null){
            return;
        }
        for(Node node : root.children){
            postorder(node, result);    
        }
        result.add(root.val);
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
