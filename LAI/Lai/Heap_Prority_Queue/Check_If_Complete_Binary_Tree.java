package Lai.Heap_Prority_Queue;

import java.util.LinkedList;
import java.util.Queue;

import Utils.TreeNodeUtils.TreeNode;

public class Check_If_Complete_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		System.out.println("" + queue.size());
		queue.offer(null);
		System.out.println("" + queue.size());
		queue.offer(null);
		System.out.println("" + queue.size());
		queue.offer(null);
		System.out.println("" + queue.size());
		queue.offer(null);
		System.out.println("" + queue.size());
	}

//	Best Solution, I have ever seen
	public boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();//�������null
		queue.offer(root);
		while (queue.peek() != null) {//�����ж�isEmpty()������BFS���ڼ䲻�ж��Ƿ�Ϊnull��ֱ��offer��ֻҪ��Ϊnull�ͼ�����ֱ������һ��null
			TreeNode node = queue.poll();
			queue.offer(node.left);
			queue.offer(node.right);
		}
		while (!queue.isEmpty()) {//��Ȼ������һ��null����������ε��������ֵ�һ����Ϊnull�ķ���false����Ĭ�Ϸ��֣�����true;
			TreeNode node = queue.poll();
			if (node != null) {
				return false;
			}
		}
		return true;
//		while (!queue.isEmpty() && queue.peek() == null) {//�����˵�һ��null�������е�null������ȥ
//			queue.poll();
//		}
//		return queue.isEmpty();//����ǿգ�true������false
	}

//	Sample soluton 
	public boolean isCompleteTree01(TreeNode root) {
		if(root == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();//�������null
		queue.offer(root);
		boolean hasFound = false;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node.left == null) {//find first null node
				hasFound = true;
			}else if(hasFound){ //non-null node after null node
				return false;
			}else {
				queue.offer(node.left);
			}
			if(node.right == null) {
				hasFound = true;
			}else if(hasFound) {//non-null node after null node
				return false;
			}else {
				queue.offer(node.right);
			}
		}
		return true;
	}

}
