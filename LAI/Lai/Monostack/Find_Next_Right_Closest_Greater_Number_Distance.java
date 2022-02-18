package Lai.Monostack;

import static Utils.ArrayUtils.print;
import static Utils.ArrayUtils.printf;
import static Utils.ArrayUtils.toStr;

import java.util.Deque;
import java.util.LinkedList;

import Utils.ArrayUtils;
import Utils.StringUtils;

public class Find_Next_Right_Closest_Greater_Number_Distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Deque<Integer> monoStack = new LinkedList<>();
//		monoStack.offer(1);
//		monoStack.offer(9);
//		monoStack.offer(2);
//		monoStack.offer(3);
//		monoStack.offer(0);
//		monoStack.offer(6);
//		monoStack.offer(5);
//		monoStack.offer(4);
//		monoStack.offer(7);
//		monoStack.offer(1);
//		System.out.println(""+toStr(monoStack));;
		System.out.println(""+(int)(Math.log(Integer.MAX_VALUE)/ Math.log(3)));
//		int[] arr = { 5, 3, 1, 2, 4 };
		int[] arr = ArrayUtils.buildIntArrayNoDup(6, 0,20);
//		int[] arr = ArrayUtils.generateIntArrayWithDup(6, 0,20);
//		int[] arr = { 3,  3,  7, 19, 16, 13 };
		print(arr);
		System.out.println("" + toStr(findNextRighClosestGreaterDis(arr)));
	}

	
//	分左右侧：只看一侧的最大最小值，可以Stack； 只看一侧的比自己小的数字的个数或者比自己大的数字的个数，用segment tree或者merge sort
//	右侧第一个比它大的元素和自己的距离: 只看index比我大，
//	左侧第一个比它大的元素和自己的距离
//	右侧第一个比它大的元素和自己的距离 <==> 推导出：stack存储降序序列，还是升序序列？ 降序序列，最小栈，小了，就被pop出去。 
//	依次存储更大的值，还是更小的值？栈顶为大，最大栈或者单调递增栈；依次存储最小的值，称为最小栈或者单调递减栈；一个题目使用什么栈是由什么决定的呢？
//	栈的操作：插入和删除，类似Heap；问问删除的时候是最小值不需要了，还是最大值不需要了呢？
//	只看左侧第一个小的吗？ 不是，
	
//	只要改变： < 为 >, 则变为 求解右侧第一个小于自己的值和自己的距离。==> while (!monoStack.isEmpty() && arr[monoStack.peekFirst()] > arr[i]) {

//	Linear Scan 回头看N步，看什么，即看数值，也看位置，满足条件时，计算距离
	
//	无序数组：对每一个元素， 左右两侧都是无序的，那么左右两侧都可以试图寻找，
//	A: 集合上个数问题：大于自己的元素的个数;等于自己的元素的个数;大于或者等于自己的元素的个数
//	B: 集合上个数问题：小于自己的元素的个数;等于自己的元素的个数;小于或者等于自己的元素的个数
//	C: 集合上最近距离问题：最近，距离自己最近的大于自己元素的距离;距离自己最近的等于自己元素的距离;距离自己最近的大于或等于自己元素的距离
//	D: 集合上最近距离问题：最近，距离自己最近的小于自己元素的距离;距离自己最近的等于自己元素的距离;距离自己最近的小于或等于自己元素的距离
//	C: 集合上最远距离问题：最远，距离自己最远的大于自己元素的距离;距离自己最远的等于自己元素的距离;距离自己最远的大于或等于自己元素的距离
//	D: 集合上最远距离问题：最远，距离自己最远的小于自己元素的距离;距离自己最远的等于自己元素的距离;距离自己最远的小于或等于自己元素的距离

//	此题是求右侧最近的大于自己的元素的距离
//	findNextRighClosestGreaterDis
//	Next: 由更新规则决定:: 如果发现当前元素比栈顶的元素大时，更新栈顶元素位置的res的值
//	Right: 从左向右扫描，更新左边栈顶的缘故。
//	Closest: 因为第一个遇到就行动的缘故。最小栈，遇到第一个大于或等于栈顶元素，就把自己弹出来，弹出来就更新距离，不弹出来就不更新距离；
//	Distance:
	
	//单调栈的含义：从左到右扫描时的在当前元素的左侧，从左到右依次，保存截止目前为止，还没有发现 距离自己最近的大于等于自己的元素 的元素的索引，所以最小栈
//	所以栈内元素 从左到右 肯定是从大到小排列的，称为最小栈
	
//	如何将它变为最大栈呢？
	//单调栈的含义：从左到右扫描时的在当前元素的左侧，从左到右依次，保存截止目前为止，还没有发现 距离自己最近的小于自己的元素 的元素的索引，所以最小栈
//	所以栈内元素 从左到右 肯定是从大到小排列的，称为最小栈

	public static int[] findNextRighClosestGreaterDis(int[] arr) {
		int[] res = new int[arr.length];
		Deque<Integer> monoStack = new LinkedList<>();//最小栈，从大到小排序
		for (int i = 0; i < arr.length; i++) {
			res[i] = -1;//这个位置的初始值，表示没有右侧第一个比它大的元素
			while (!monoStack.isEmpty() && arr[monoStack.peekFirst()] <= arr[i]) {//针对栈顶元素，发现最近的距离了，最近大于等于自己的元素了，
				////栈里面的存的是index, 而不是array value;
//				res[monoStack.peekFirst()] = i - monoStack.peekFirst();
				res[monoStack.peekFirst()] = i;
				monoStack.pollFirst();
			}
			monoStack.offerFirst(i);//一定得放进去，需要后面的来和它比较
			printf("stack:res: %20s:%-20s ", StringUtils.toStr(monoStack), toStr(res));
		}
		print(toStr(res, true));
		return res;
	}


}
