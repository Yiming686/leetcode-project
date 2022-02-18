package Leet.Binary_Tree.View;

import static Utils.ArrayUtils.print;
import static Utils.TreeNodeUtils.printTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import Utils.TreeNodeUtils;
import Utils.TreeNodeUtils.TreeNode;

public class Leet_199_Binary_Tree_Right_Side_View {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> root = TreeNodeUtils.fromStringToTree("{5,1,9,#,3,8,11,2,7,#,#,#,#,#,#,#,8,#,9}");
//		TreeNode<Integer> root = TreeNodeUtils.fromStringToTree("{5,1,9,#,3,8,11,2,7,#,#,#,#,#,#,#,8,#,#,#,#,#,9}");
		printTree(root);
		System.out.println("    rightSideView: "+rightSideView(root));
		System.out.println("rightSideView_rec: "+rightSideView_rec(root));
	}
	public static List<Integer> rightSideView_rec(TreeNode<Integer> root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		righSideView_rec(result, root, 0);
		return result;
	}
//	����似�����index�Ѿ���ע���ˣ�����һ��������ʱ�򣬼��뼴�ɣ�ÿһ�㶼�Ǵ��ҵ�������ģ���Ϊ����������Һ����preorder����
	private static void righSideView_rec(List<Integer> result, TreeNode<Integer> root, int level) {
		if(root == null) {
			return;
		}
		if(result.size() == level) {
			result.add(root.val);
		}
		righSideView_rec(result, root.right, level + 1);
		righSideView_rec(result, root.left, level + 1);
	}
	
	public static List<Integer> rightSideView(TreeNode<Integer> root) {
    		List<Integer> result = new ArrayList<>();
    		if(root == null) {
    			return result;
    		}
    		Deque<TreeNode<Integer>> queue = new ArrayDeque<>();
    		queue.offer(root);
    		while(!queue.isEmpty()) {
    			int size = queue.size();
    			for(int i = 0; i < size; i++) {
    				TreeNode<Integer> node = queue.poll();
    				if(i == size - 1) {
    					result.add(node.val);
    				}
    				if(node.left != null) {
    					queue.offer(node.left);
    				}
    				if(node.right != null) {
    					queue.offer(node.right);
    				}
    			}
    		}
    		return result;
    }

}
