package Lai.Queue_Stack;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Sort_With_2_Stacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> stack = new LinkedList<>();

		stack.push(9);
		stack.push(2);
		stack.push(3);
		stack.push(3);
//		stack.push(3);
//		stack.push(7);
//		stack.push(1);
//		stack.push(9);
//
//		stack.push(3);
//		stack.push(8);
		stack.push(2);
		System.out.println("" + stack);
//		sortNoDup(stack);
//		sortWithDup1(stack);
		sortWithDup2(stack);
		System.out.println("" + stack);
	}

//	总评：用count真不是一个好办法，因为多了一个变量，初始化，使用，递增，循环 真是麻烦，代码难看
//	 用size()方法好看，简单 容易理解

//	借助挡板的思想，问题域已经排好序，而且最小的都比问题域内的大
//	问题域
//	from top to bottom the integers are sorted in ascending order, find MAX
//	[] works for no duplicate elements
	public static void sortNoDup(LinkedList<Integer> stack) {
		if (stack == null) {
			return;
		}
		LinkedList<Integer> buffer = new LinkedList<>();
		Integer prevMax = Integer.MAX_VALUE; //go on if less than preMax, any Integer is less than MAX_VALUE
		while (!stack.isEmpty() && stack.peek() < prevMax) {//go over the search space
			Integer currMax = Integer.MIN_VALUE;
			while (!stack.isEmpty() && stack.peek() < prevMax) {
				currMax = Math.max(currMax, stack.peek());//find current MAX
				buffer.push(stack.pop());
			}
			stack.push(currMax);//put MAX back to stack, its right neighbour is preMAX
			prevMax = currMax; // so update prevMAX
			while (!buffer.isEmpty()) {
				int temp = buffer.pop();
				if (temp != currMax) {
					stack.push(temp);
					;
				}
			}
		}
	}

//	是不是不用填count也行呢？找到一个最大的，放回去；下一次再找一个相等的最大的，再放回去；似乎也没问题
//	问题是原始stack里面分两部分，右侧是找到的区域，左侧是待找的区域，怎么区分呢？一次循环，右区只增加1
	public static void sortWithDup2(LinkedList<Integer> stack) {
		if (stack == null) {
			return;
		}
		LinkedList<Integer> buffer = new LinkedList<>();
		int size = stack.size();//标记变量，创建后不再更改
		int numOfSorted = 0; //循环变量，大循环里面，找到一个最大的增加一次，直到==size，完成！
		while (numOfSorted < size) {
			Integer currMax = Integer.MIN_VALUE;
			while (stack.size() > numOfSorted) {//当前元素多余已经排好序的个数，说明还有元素需要排序
				currMax = Math.max(currMax, stack.peek());
				buffer.push(stack.pop());
			}
			stack.push(currMax);//最大的被push一次
			boolean isFirst = true;
			while (!buffer.isEmpty()) {
				int temp = buffer.pop();
				if (temp == currMax && isFirst) {
					isFirst = false;
				} else {
					stack.push(temp);
				}
			}
			numOfSorted++;
		}
	}

// works for no duplicate elements
//		from top to bottom the integers are sorted in ascending order, find MAX
	public static void sortWithDup1(LinkedList<Integer> stack) {
		if (stack == null || stack.size() <= 1) {
			return;
		}
		LinkedList<Integer> buffer = new LinkedList<>();
		Integer prevMax = Integer.MAX_VALUE; //go on if less than preMax, any Integer is less than MAX_VALUE
		while (!stack.isEmpty() && stack.peek() < prevMax) {//go over the search space
			Integer currMax = Integer.MIN_VALUE;
			int count = 0;
//			每次一个元素，过一遍; 若大于currMax，更新，并且count=0；若等于，count++;
			while (!stack.isEmpty() && stack.peek() < prevMax) {
//				currMax = Math.max(currMax, stack.peek());//find current MAX
				if (currMax == stack.peek()) {
					count++;
				} else if (currMax < stack.peek()) {
					count = 1;
					currMax = stack.peek();
				}
//				System.out.println("count: " + count);
				buffer.push(stack.pop());
			}
			while (--count >= 0) {
				stack.push(currMax);//put MAX back to stack, its right neighbour is preMAX
			}
			prevMax = currMax; // so update prevMAX
			while (!buffer.isEmpty()) {
				int temp = buffer.pop();
				if (temp != currMax) {
					stack.push(temp);
					;
				}
			}
		}
		//done
	}

}
