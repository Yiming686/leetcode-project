package Lintcode.BinaryTree.BST;

import com.sun.corba.se.impl.orbutil.graph.Node;

/**
Inorder predecessor and successor for a given key in BST
I recently encountered with a question in an interview at e-commerce company. The interviewer asked the following question:

There is BST given with root node with key part as integer only. The structure of each node is as follows:

struct Node
{
    int key;
    struct Node *left, *right ;
};
Run on IDE
You need to find the inorder successor and predecessor of a given key. In case the given key is not found in BST, then return the two values within which this key will lie.

Following is the algorithm to reach the desired result. Its a recursive method:

Input: root node, key
output: predecessor node, successor node

1. If root is NULL
      then return
2. if key is found then
    a. If its left subtree is not null
        Then predecessor will be the right most 
        child of left subtree or left child itself.
    b. If its right subtree is not null
        The successor will be the left most child 
        of right subtree or right child itself.
    return
3. If key is smaller then root node
        set the successor as root
        search recursively into left subtree
    else
        set the predecessor as root
        search recursively into right subtree
        
         *
 */
public class Find_Predecessor_n_Successor_in_BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNode.fromStringToTree("{50, 30,70,20, 40,60,80}");
		TreeNode node = new TreeNode(15);
		TreeNode[] arr = findPredecessorSuccessor(root, node); System.out.println("Node: "+ node.val + ", Predecessor is: "+(arr[0]==null? null:arr[0].val) + ", Successor is: "+(arr[1]==null? null:arr[1].val));
		node = new TreeNode(0); arr = findPredecessorSuccessor(root, node); System.out.println("Node: "+ node.val + ", Predecessor is: "+(arr[0]==null? null:arr[0].val) + ", Successor is: "+(arr[1]==null? null:arr[1].val));
		node = null; arr = findPredecessorSuccessor(root, node); System.out.println("Node: "+ (node==null?null:node.val) + ", Predecessor is: "+(arr[0]==null? null:arr[0].val) + ", Successor is: "+(arr[1]==null? null:arr[1].val));

		node = new TreeNode(20); arr = findPredecessorSuccessor(root, node); System.out.println("Node: "+ node.val + ", Predecessor is: "+(arr[0]==null? null:arr[0].val) + ", Successor is: "+(arr[1]==null? null:arr[1].val));
		node = new TreeNode(25); arr = findPredecessorSuccessor(root, node); System.out.println("Node: "+ node.val + ", Predecessor is: "+(arr[0]==null? null:arr[0].val) + ", Successor is: "+(arr[1]==null? null:arr[1].val));
		node = new TreeNode(30); arr = findPredecessorSuccessor(root, node); System.out.println("Node: "+ node.val + ", Predecessor is: "+(arr[0]==null? null:arr[0].val) + ", Successor is: "+(arr[1]==null? null:arr[1].val));
		node = new TreeNode(35); arr = findPredecessorSuccessor(root, node); System.out.println("Node: "+ node.val + ", Predecessor is: "+(arr[0]==null? null:arr[0].val) + ", Successor is: "+(arr[1]==null? null:arr[1].val));
		node = new TreeNode(40); arr = findPredecessorSuccessor(root, node); System.out.println("Node: "+ node.val + ", Predecessor is: "+(arr[0]==null? null:arr[0].val) + ", Successor is: "+(arr[1]==null? null:arr[1].val));
		node = new TreeNode(50); arr = findPredecessorSuccessor(root, node); System.out.println("Node: "+ node.val + ", Predecessor is: "+(arr[0]==null? null:arr[0].val) + ", Successor is: "+(arr[1]==null? null:arr[1].val));
		node = new TreeNode(65); arr = findPredecessorSuccessor(root, node); System.out.println("Node: "+ node.val + ", Predecessor is: "+(arr[0]==null? null:arr[0].val) + ", Successor is: "+(arr[1]==null? null:arr[1].val));
		
		node = new TreeNode(70); arr = findPredecessorSuccessor(root, node); System.out.println("Node: "+ node.val + ", Predecessor is: "+(arr[0]==null? null:arr[0].val) + ", Successor is: "+(arr[1]==null? null:arr[1].val));
		node = new TreeNode(75); arr = findPredecessorSuccessor(root, node); System.out.println("Node: "+ node.val + ", Predecessor is: "+(arr[0]==null? null:arr[0].val) + ", Successor is: "+(arr[1]==null? null:arr[1].val));
		node = new TreeNode(80); arr = findPredecessorSuccessor(root, node); System.out.println("Node: "+ node.val + ", Predecessor is: "+(arr[0]==null? null:arr[0].val) + ", Successor is: "+(arr[1]==null? null:arr[1].val));
		node = new TreeNode(88); arr = findPredecessorSuccessor(root, node); System.out.println("Node: "+ node.val + ", Predecessor is: "+(arr[0]==null? null:arr[0].val) + ", Successor is: "+(arr[1]==null? null:arr[1].val));

	}
	
//	TC is O(logN)
	static TreeNode[]  findPredecessorSuccessor(TreeNode root, TreeNode node){
		TreeNode[] arr = new TreeNode[2];
        if(root == null || node == null) return arr;
        TreeNode predecessor = null;
        TreeNode successor = null;
        //第一步：用bst属性搜寻node，找p，用while循环
        while(root != null && root.val != node.val){
            if(root.val > node.val){
                successor = root;//因为当前是左子树的successor
                root = root.left;
            }else{
            	predecessor = root;//因为当前是左子树的successor
            	root = root.right;
            }
        }
        //第二步，处理结果，a：没找到
        if(root == null) {
        	arr[0] = predecessor;
        	arr[1] = successor;
        	return arr;
        };
        //b: 找到了，右子树为空，直接返回
        TreeNode newSuccessor   = root;
        TreeNode newPredecessor = root;
        //node找到，继续找successor
        if(newSuccessor.right != null){
        	newSuccessor = newSuccessor.right;
            while(newSuccessor.left!=null){
            	newSuccessor = newSuccessor.left;
            }
            successor = newSuccessor;
        }
        //node找到，继续找predecessor
        if(newPredecessor.left != null){
        	newPredecessor = newPredecessor.left;
            while(newPredecessor.right!=null){
            	newPredecessor = newPredecessor.right;
            }
            predecessor = newPredecessor;
        }

    	arr[0] = predecessor;
    	arr[1] = successor;

    	return arr;
	}
	
}
