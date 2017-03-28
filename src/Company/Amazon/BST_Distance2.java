package Company.Amazon;

public class BST_Distance2 {

	static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		root.left.right.right = new Node(45);
		BST_Distance2 sol = new BST_Distance2();
		System.out.println("Path Length of 45:"+sol.PathLength(root, 45));
		System.out.println("Path Length of 20:"+sol.PathLength(root, 20));
		Node lca = sol.findLCA(root, 20, 45);
		System.out.println("LCA of 20 and 45:"+lca.data);
		System.out.println("Distance between 20 and 45:"+sol.findDistance(root, 45, 20));
		System.out.println("Distance between 20 and 45:"+sol.findDistance(root, 45, 35));
	}
	
	
	public int findDistance(Node root,int n1, int n2){
		int len1 = PathLength(root,n1)-1;
		int len2 = PathLength(root,n2)-1;
		int lca = findLCA(root,n1,n2).data;
		int lcaDistance = PathLength(root,lca)-1;
		return (len1+len2) - 2*lcaDistance;
	}
	public int PathLength(Node root, int n1){
		if(root!=null){
			int len = 0;
			if(root.data==n1 || (len = PathLength(root.left,n1))>0 || (len = PathLength(root.right,n1))>0){
				return len+1;
			}
			return 0;
		}
		return 0;
	}
	//recursive method to find Lowest Common Ancestor of two nodes
	public Node findLCA(Node root, int n1, int n2){
		if(root!=null){
			if(root.data==n1 || root.data == n2)
				return root; //exit criteria
			Node left = findLCA(root.left,n1,n2); //search the left subtree
			Node right = findLCA(root.right,n1,n2);//search the right sub tree
			
			if(left!=null && right!=null)//case where given nodes are in the left and right subtrees
				return root; //indicates root is the common ancestor
			if(left!=null)//case where the given nodes are in the left sub-tree
				return left;//indicates the LCA is in the left sub-tree of the root
			if(right!=null)//case where given nodes are in the right sub tree
				return right;//indicates the LCA is in the right sub tree of the root
		
		}
		return null;
	}	

}
