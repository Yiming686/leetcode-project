package Leet.Binary_Tree.View;

import static Utils.TreeNodeUtils.printTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Zigzag_Binary_Tree_View {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode<Integer> root = TreeNodeUtils.fromStringToTree("{5,1,9,#,3,8,11,2}");
		TreeNode<Integer> root = TreeNodeUtils.fromStringToTree("{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}");
		printTree(root);
		System.out.println("leftSideView: "+zigzagView(root));
	}
    public static List<Integer> zigzagView(TreeNode<Integer> root) {
    		List<Integer> result = new ArrayList<>();
    		if(root == null) {
    			return result;
    		}
    		Deque<TreeNode<Integer>> queue = new ArrayDeque<>();
    		queue.offer(root);
    		boolean fromFirstToLast = true;//How to print in first level?//from   first to last
    		while(!queue.isEmpty()) {
    			int size = queue.size();
    			for(int i = 0; i < size; i++) {
    				if(fromFirstToLast) {//如果当前是从左到右pollFirst并处理，那么必须先left后right地OfferLast();
    					TreeNode<Integer> curr = queue.pollFirst();//1;
    					result.add(curr.val);
    					if(curr.left != null) {
    						queue.offerLast(curr.left);
    					}
    					if(curr.right != null) {
    						queue.offerLast(curr.right);
    					}
    				}else {
    					TreeNode<Integer> curr = queue.pollLast();//1,9;
    					result.add(curr.val);
    					if(curr.right != null) {
    						queue.offerFirst(curr.right);
    					}
    					if(curr.left != null) {
    						queue.offerFirst(curr.left);
    					}
    				}
    			}
    			fromFirstToLast = !fromFirstToLast;
    		}
    		return result;
    }

}
