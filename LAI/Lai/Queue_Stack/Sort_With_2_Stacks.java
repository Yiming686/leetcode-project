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

//	��������count�治��һ���ð취����Ϊ����һ����������ʼ����ʹ�ã�������ѭ�� �����鷳�������ѿ�
//	 ��size()�����ÿ����� �������

//	���������˼�룬�������Ѿ��ź��򣬶�����С�Ķ����������ڵĴ�
//	������
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

//	�ǲ��ǲ�����countҲ���أ��ҵ�һ�����ģ��Ż�ȥ����һ������һ����ȵ����ģ��ٷŻ�ȥ���ƺ�Ҳû����
//	������ԭʼstack����������֣��Ҳ����ҵ�����������Ǵ��ҵ�������ô�����أ�һ��ѭ��������ֻ����1
	public static void sortWithDup2(LinkedList<Integer> stack) {
		if (stack == null) {
			return;
		}
		LinkedList<Integer> buffer = new LinkedList<>();
		int size = stack.size();//��Ǳ������������ٸ���
		int numOfSorted = 0; //ѭ����������ѭ�����棬�ҵ�һ����������һ�Σ�ֱ��==size����ɣ�
		while (numOfSorted < size) {
			Integer currMax = Integer.MIN_VALUE;
			while (stack.size() > numOfSorted) {//��ǰԪ�ض����Ѿ��ź���ĸ�����˵������Ԫ����Ҫ����
				currMax = Math.max(currMax, stack.peek());
				buffer.push(stack.pop());
			}
			stack.push(currMax);//���ı�pushһ��
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
//			ÿ��һ��Ԫ�أ���һ��; ������currMax�����£�����count=0�������ڣ�count++;
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
