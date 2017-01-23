package JavaBasics;

import java.util.LinkedList;

import LeetCode.JavaList.ListNode;

public class Test2 {
	public static void main(String[] args) {
		SupperA supperA = new SupperA();
		int temp1 = supperA.supperA_public;
		int temp2 = supperA.supperA_default;
		int temp3 = supperA.supperA_protected;
		
		char ch = 'c';
		System.out.println(""+ch);
		if(null == null){
			System.out.println(""+null);
		}
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		while(node1 != node2){
			System.out.println(""+1);
			node1 = node1.next;
			node2 = node2.next;
		}
		System.out.println(""+999);
	}
	
}
