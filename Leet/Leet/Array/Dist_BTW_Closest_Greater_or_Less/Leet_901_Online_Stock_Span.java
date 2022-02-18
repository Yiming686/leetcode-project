package Leet.Array.Dist_BTW_Closest_Greater_or_Less;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leet_901_Online_Stock_Span {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StockSpanner ss = new StockSpanner();//[100, 80, 60, 70, 60, 75, 85], [1, 1, 1, 2, 1, 4, 6]
		System.out.println("" + ss.next(100));
		System.out.println("" + ss.next(80));
		System.out.println("" + ss.next(60));
		System.out.println("" + ss.next(70));
		System.out.println("" + ss.next(60));
		System.out.println("" + ss.next(75));
		System.out.println("" + ss.next(85));
	}

	static class StockSpanner {

		List<Integer> list;
		Deque<Integer> stack;

		public StockSpanner() {
			list = new ArrayList<>();
			stack = new LinkedList<>();
		}

		public int next(int price) {
			list.add(price);
			int pos = list.size() - 1;
			if (stack.isEmpty()) {//first
				stack.push(pos);//do not forget
				return pos + 1;
			}
			while (!stack.isEmpty() && list.get(stack.peek()) <= price) {
				stack.pop();
			}
			int rightMostPos = stack.isEmpty() ? -1 : stack.peek();
			stack.push(pos);// do not forget, insert
			return pos - rightMostPos;
		}
	}
}
