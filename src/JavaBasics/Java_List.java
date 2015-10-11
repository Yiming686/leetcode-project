package JavaBasics;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
	


public class Java_List {
	
	public static  int f(int dividend, int divisor){
		return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	}
	public static void f(Integer a, Integer b){
		System.out.printf("3 a=%s, b=%s  \n", a, b);
		a=a * 2;
		b=b * 2;
		System.out.printf("4 a=%s, b=%s  \n", a, b);
	}
	
	public static void f(AB a, AB b){
		System.out.printf("3 a=%s, b=%s  \n", a, b);
		System.out.printf("2 a=%s, b=%s  \n", a.val, b.val);

		a.val=a.val * 2;
		b.val=b.val * 2;
		System.out.printf("4 a=%s, b=%s  \n", a, b);
		System.out.printf("2 a=%s, b=%s  \n", a.val, b.val);


	}
	public static void f(AB a, AB b, AB c){
		Stack<Integer> s = new Stack<Integer>();
		s.clear(); s.peek();
//		Arrays.sort(new int[7]);
		
		b  = new AB(5);
		c  = new AB(6);
		
//		System.out.printf("3 a=%s, b=%s  \n", a, b);
		System.out.printf("2 a=%s, b=%s ,c=%s  \n", a.val, b.val, c.val);

		a.val=a.val * 2;
		b.val=b.val * 2;
		a = c;
		System.out.printf("4 a=%s, b=%s  \n", a, b);
		System.out.printf("2 a=%s, b=%s  \n", a.val, b.val);
	}
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(4);

		list.add(null);
		list.add(6);
		list.add(null);
		list.add(null);list.add(null);list.add(null);list.add(null);
		
		System.out.println(list);
		AB a0  = new AB(2);
		AB b1  = null;
		AB c2  = null;
		f(a0,b1,c2);
		System.out.printf("22 a=%s  \n", a0.val);

		System.out.printf("33 a=%s, b=%s ,c=%s  \n", a0.val, b1.val, c2.val);


		boolean isTestBelow = false;
		if(isTestBelow){
			Integer a = new Integer(3);
			Integer b = new Integer(4);
			System.out.printf("1 a=%s, b=%s  \n", a, b);
			f(a, b);
			System.out.printf("2 a=%s, b=%s  \n", a, b);
			System.out.printf("-----------------\n");
			
			Java_List jr = new Java_List();
			AB ab1  = new AB(5);
			AB ab2  = new AB(6);
			System.out.printf("2 a=%s, b=%s  \n", ab1.val, ab2.val);
			System.out.printf("3 a=%s, b=%s  \n", ab1, ab2);
			f(ab1, ab2);
			System.out.printf("2 a=%s, b=%s  \n", ab1.val, ab2.val);
		}

	}
	static class AB{
		Integer val;

		public AB(Integer val) {
			super();
			this.val = val;
		}
		
	}
}
