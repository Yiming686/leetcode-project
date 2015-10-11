package LeetCode.JavaTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

 Hide Tags Tree Breadth-first Search

 * 
 */

public class LC_102_Binary_Tree_Level_Order_Traversal {
	
//	Accepted�� ţ�Ƶ�ͨ�÷�����ȥ��ע�ͣ�������zigzag����
//	ֻ��һ��queue
//	�����μ�
    public List<List<Integer>> levelOrder4(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
// 		boolean isLeft2Right = false;
        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                // if(isLeft2Right){
                    // level.addFirst(head.val);
                // }else{
                    level.addLast(head.val);
                // }
                
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            // isLeft2Right = !isLeft2Right;
            result.add(level);
        }

        return result;
    }
	
//	Only One Queues,�ǵݹ�ʵ����Ѵ�
//	���ʹ���for(int i = 0; i< q1.size(); i ++)
//	�����׷��֣�ѭ����q1�Ƕ�̬�仯��
//	Ҫ��ǰ��¼��q1��size��int size = q1.size();
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null)
			return list;
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		q1.offer(root);
		while (!q1.isEmpty() ) {
			List<Integer> intList = new ArrayList<Integer>();
			int size = q1.size();
			for(int i = 0; i< size; i ++){
				TreeNode node = q1.poll();
				intList.add(node.val);
				if (node.left != null)
					q1.add(node.left);
				if (node.right != null)
					q1.add(node.right);
			}
			list.add(intList);
		}
		return list;
	}
	
//	Accepted, With Two Queues
//	���뿼�ǣ�size��������ܼ��룬����Ľⷨ����Ҫ.if (intList.size() > 0) list.add(intList);
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null)
			return list;
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.add(root);q1.offer(root);
		while (!q1.isEmpty() || !q2.isEmpty()) {
			List<Integer> intList = new ArrayList<Integer>();
			while (!q1.isEmpty()) {
				TreeNode node = q1.poll();
				intList.add(node.val);
				if (node.left != null)
					q2.add(node.left);
				if (node.right != null)
					q2.add(node.right);
			}
			if (intList.size() > 0)
				list.add(intList);
			intList = new ArrayList<Integer>();
			while (!q2.isEmpty()) {
				TreeNode node = q2.poll();
				intList.add(node.val);
				if (node.left != null)
					q1.add(node.left);
				if (node.right != null)
					q1.add(node.right);
			}
			if (intList.size() > 0)
				list.add(intList);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
