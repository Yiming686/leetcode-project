package Utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

import Utils.ListNodeUtils.ListNode;

public class LinkedListUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static LinkedList<Integer> buildIntLinkedList(int size, int min, int max) {
		int[] arr = ArrayUtils.buildIntArray(size, min, max);
		return buildIntLinkedList(arr);
	}

	public static LinkedList<Integer> buildIntLinkedList(int[] arr) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int val : arr) {
			list.add(val); //add to Last position
		}
		return list;
	}

	public static <E> E[] convertList2Array(LinkedList<E> s1, Class<E> class1) {
		E[] arr = (E[]) Array.newInstance(class1, s1.size());
		for (int i = 0; i < s1.size(); i++) {
			arr[i] = s1.get(i);
		}
		return arr;
	}

	public static void print(ListNode head) {
		int width = 3;
		print(head, width);
	}

	public static void print(ListNode head, int width) {
		if (head == null) {
			System.out.println("ListNode: null");
		}
		StringBuilder str1 = new StringBuilder();
		StringBuilder str2 = new StringBuilder();
		str1.append(" List: ");
		str2.append("Index: ");
		int count = 0;
		while (head != null) {
			str1.append(String.format("%"+width+"s", head.val));
			str2.append(String.format("%"+width+"s", count++));
			head = head.next;
		}
		System.out.println(str1);
		System.out.println(str2);
	}
}
