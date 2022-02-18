package Lintcode.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.junit.Test;

/**

 Binary Tree Postorder Traversal

 Description
 Notes
 Testcase
 Judge
Given a binary tree, return the postorder traversal of its nodes' values.

Have you met this question in a real interview? Yes
Example
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
 

return [3,2,1].

Challenge 
Can you do it without recursion?

Tags 
Recursion Binary Tree Binary Tree Traversal
Related Problems 
Easy Binary Tree Preorder Traversal 41 %


 *
 *
 */
public class Binary_Tree_Postorder_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode.fromStringToTree("25,15,50,10,22,35,70,4,12,18,24,31,44,66,90");
	}
	
	@Test
	public void testPostorderTraversal() {
		TreeNode root = TreeNode.fromStringToTree(" { 25,15,50,10,22,35,70,4,12,18,24,31,44,66,90  }  ");
//		TreeNode root = TreeNode.fromStringToTree("{ 25,15,50,10,22,35,70,4,12,18,24,31,44,66,90 } ");
		System.out.println(TreeNode.convertToString(root));
		List<Integer> list = postorderTraversal(root);
		System.out.println(list);
	}
	
//	Ҫ�ܻ���prev��curr�����ͼ����Ϊ4�ࣺ����ͼ����бͼ����бͼ������ͼ��
//	ÿ��ͼ����prev��curr���λ�õı仯����ע��ͷ���򣬾������
//	

//  ��Ϣ���ɶ�ԭ��root������������
//  ��ֵά��ԭ�����ƺͷ�Χ��������ݼ�����Χ����
//   stack�Ƚ����������ȳ�
  public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      // Stack<Element> stack = new Stack<>(); 
      Deque<Element> stack = new ArrayDeque<Element>();
      stack.push(new Element(0, root));     //FIRST VISIT ��ʼ��stack
//       how to maintain type within 0 and 1
      while(!stack.isEmpty()){                               //ʹ��stack
          Element curr = stack.pop();       //SECOND VISIT
          if(curr.node == null){            //leaf node
              continue;
          }
          if(curr.type == 1){
              result.add(curr.node.val);     //THIRD VISIT
          }else{                                               //����stack
              // if(curr.node!= null) 
                  curr.type = 1;
                  stack.push(curr);       //SECOND VISIT
                  // stack.push(new Element(2, curr.node));       //SECOND VISIT
              // if(curr.node.right!= null) 
                  stack.push(new Element(0, curr.node.right)); //FIRST VISIT
              // if(curr.node.left!= null)
                  stack.push(new Element(0, curr.node.left));  //FIRST VISIT
          }
      }
      return result;
  }
  
  class Element{
      int type;//0, 1
      TreeNode node;
      Element(int type, TreeNode node){
          this.type = type;
          this.node = node;
      }
  }

}
