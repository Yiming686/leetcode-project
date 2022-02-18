package Lai.Queue_Stack;

import java.util.Arrays;
import java.util.LinkedList;

import Utils.ArrayUtils;
import Utils.LinkedListUtils;
import Utils.TreeNodeUtils.TP;

public class Sort_With_3_Stacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = ArrayUtils.buildIntArray(7, 2, 99);
		LinkedList<Integer> s1 = LinkedListUtils.buildIntLinkedList(arr);
//		16, 14, 13,  3,  9,  2, 18, 11, 17
//		int[] arr = {16, 14, 13,  3,  9,  2, 18, 11, 17};
//		int[] arr = {8,1, 7, 2, 9};
//		LinkedList<Integer> s1 = LinkedListUtils.generateIntLinkedList(arr);
		System.out.println("s1: "+ s1);
		sort(s1);
		System.out.println("s1: "+ s1);
		
		Arrays.sort(arr);
		Integer[] expected = ArrayUtils.convertIntArr2IntegerArr(arr);
		Integer[] actural = LinkedListUtils.convertList2Array(s1, Integer.class);
		ArrayUtils.verifyEqualTwoArray(expected, actural);
		
	}

//	s1是stack，包含整数没有排好序，排好序后，从顶端到底端升序排列
//	
	public static void sort(LinkedList<Integer> s1) {
		LinkedList<Integer> s2 = new LinkedList<Integer>();
		LinkedList<Integer> s3 = new LinkedList<Integer>();
		// Write your solution here.
		TP paraRoot = TP.build("[sb:level]",  "1111", null, s1, s2, s3, s1.size());
		sort(s1, s2, s3, s1.size(), paraRoot);
		paraRoot.print();//ie: <==> print("[sb:level]",  "1111", true), print all parameters
//		paraRoot.print("[sb:level]",  "1111", false, ""); //ie: <==> print("[sb:level]",  "1111", true, attrs), print all specified attributes

	}

	//标记变量和循环变量的区别，标记变量不可更改，循环变量必须更改
	private static void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int len,TP paraRoot) {
		if(len <= 1){
			return;
		}
		int mid2 = len / 2; //为什么是mid2呢？这个表明长度，将来是要放到s2的缘故
		int mid1 = len - mid2; //mid1 是 s1里面留下的
		for(int i = 0; i < mid2; i++) {
			s2.push(s1.pop());
		}
		sort(s1, s3, s2, mid1, TP.build(paraRoot, s1, s3, s2, mid1));
		sort(s2, s3, s1, mid2, TP.build(paraRoot, s2, s3, s1, mid2));
		//here, first mid1 in s1, first mid2 in s2 are sorted, so merge them
		//[s1, mid1, i] [s2, mid2, j]
        int i = 0;
        int j = 0;
		while(i < mid1 && j < mid2){
			if(s1.peek() < s2.peek()){
				s3.push(s1.pop()); // < 
				i++;
			}else{
				s3.push(s2.pop());//< or =
				j++;
			}
		}
		while(i < mid1){
			s3.push(s1.pop()); // < 
			i++;
		}
		while(j < mid2){
			s3.push(s2.pop()); // < 
			j++;
		}
		//here, s3 sorted in desending order
		while(--len >= 0) {
			s1.push(s3.pop());
		}
	}

//	java LinkedList 作为 stack，top是左侧第一个，bottom是右侧第一个; 就像(], 所以s1.pop()和push(),都是针对第一个元素。
//	解析为什么 提出一个新的方法
//	s1: input --> output 最后从小到大排列，从第一个到最后一个，从top到bottom
//	s2: input <--> buffer
//	s3: buffer <--> input
//	借助s2和s3, 把s1中靠后的length个数字，排好序
//	worked
	private static void sort111(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int len, TP paraRoot) {
		if(len <= 1) {
			return;
		}
		int mid1 = len / 2 +1; //len = mid1 + mid2, mid1 <= mid2 
		int mid2 = len - mid1;
		for(int i = 0; i < mid1; i++) {
			s2.push(s1.pop());//前面mid1个数字从s1挪到s2
		}
		sort111(s1, s3, s2, mid2, TP.build(paraRoot, s1, s3, s2, mid2));//sort first mid2 in s1， 最后从小到大排列，
		sort111(s2, s3, s1, mid1, TP.build(paraRoot, s2, s3, s1, mid1));//sort first mid1 in s2， 最后从小到大排列，
//		sort(s1, s2, s3, mid2, TP.build(paraRoot, s2, s3, s1, mid2));//sort first mid1 in s2， 最后从小到大排列，
//		sort(s2, s1, s3, mid1, TP.build(paraRoot, s2, s3, s1, mid1));//sort first mid1 in s2， 最后从小到大排列，
//		System.out.printf("s1:len1 %s:%d,   s2:len2 %s:%d,   s3:len3 %s:%d \n", s1, mid2, s2, mid1, s3, s3.size());
		int i = 0;
		int j = 0;
		//s1和s2从大到小排列，s3从大到小排列
		while(i < mid1 && j < mid2) {
			if(s2.peek() < s1.peek()) {
				s3.push(s2.pop());//必须先放小的
				i++;
			}else {
				s3.push(s1.pop());
				j++;
			}
		}
		while(i < mid1) {
			s3.push(s2.pop());
			i++;
		}
		while(j < mid2) {
			s3.push(s1.pop());
			j++;
		}
		for(i = 0; i < len; i++) {
			s1.push(s3.pop());
		}
	}

}
