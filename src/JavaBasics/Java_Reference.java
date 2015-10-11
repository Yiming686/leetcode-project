package JavaBasics;

public class Java_Reference {

	public static void f(Integer a, Integer b) {
		System.out.printf("3 a=%s, b=%s  \n", a, b);
		a = a * 2;
		b = b * 2;
		System.out.printf("4 a=%s, b=%s  \n", a, b);

	}

	public static void f(AB a, AB b) {
		System.out.printf("3 a=%s, b=%s  \n", a, b);
		System.out.printf("2 a=%s, b=%s  \n", a.val, b.val);

		a.val = a.val * 2;
		b.val = b.val * 2;
		System.out.printf("4 a=%s, b=%s  \n", a, b);
		System.out.printf("2 a=%s, b=%s  \n", a.val, b.val);

	}

	public static void f(AB a, AB b, AB c) {
		b = new AB(5);
		c = new AB(6);

		// System.out.printf("3 a=%s, b=%s  \n", a, b);
		System.out.printf("2 a=%s, b=%s ,c=%s  \n", a.val, b.val, c.val);

		a.val = a.val * 2;
		b.val = b.val * 2;
		a = c;
		System.out.printf("4 a=%s, b=%s  \n", a, b);
		System.out.printf("2 a=%s, b=%s  \n", a.val, b.val);
	}

	public static Integer ff(Integer i) {
		Integer j = ++i;
		return j;
	}

	public static void pp(AB cc, AB dd) {
		cc.val = 8;
		dd.val= 9;
		System.out.printf("pp=%s dd=%s  \n", cc.val, dd.val);

		return ;
	}
	public static void main(String[] args) {
		
		AB cc = null, dd = null;
		cc = new AB(2);
		dd = new AB(3);
		System.out.printf("cc=%s dd=%s  \n", cc.val, dd.val);

		pp(cc, dd);
		System.out.printf("cc=%s dd=%s  \n", cc.val, dd.val);

		
		boolean isTestBelow = false;
		if (isTestBelow) {
			System.out.printf("min a=%s  \n", Integer.MIN_VALUE);
			System.out.printf("min a=%s  \n", Integer.MIN_VALUE + 2);

			System.out.printf("max a=%s  \n", Integer.MAX_VALUE);
			System.out.printf("max a=%s  \n", Integer.MAX_VALUE
					- (Integer.MAX_VALUE + 300));
			System.out.printf("max a=%s  \n", Integer.MAX_VALUE
					- (Integer.MIN_VALUE + 300));
			System.out.printf("max a=%s  \n", Integer.MAX_VALUE
					- (Integer.MIN_VALUE));

			// boolean isTestBelow = false;
			// if (isTestBelow) {
			Integer i = 4;
			System.out.printf("22 a=%s  \n", i);

			Integer iii = ff(i);
			System.out.printf("33 a=%s  \n", iii);

			System.out.printf("44 a=%s  \n", i);

			AB a0 = new AB(2);
			AB b1 = null;
			AB c2 = null;
			f(a0, b1, c2);
			System.out.printf("22 a=%s  \n", a0.val);

			System.out
					.printf("33 a=%s, b=%s ,c=%s  \n", a0.val, b1.val, c2.val);

			// boolean isTestBelow = false;
			// if (isTestBelow) {
			Integer a = new Integer(3);
			Integer b = new Integer(4);
			System.out.printf("1 a=%s, b=%s  \n", a, b);
			f(a, b);
			System.out.printf("2 a=%s, b=%s  \n", a, b);
			System.out.printf("-----------------\n");

			Java_Reference jr = new Java_Reference();
			AB ab1 = new AB(5);
			AB ab2 = new AB(6);
			System.out.printf("2 a=%s, b=%s  \n", ab1.val, ab2.val);
			System.out.printf("3 a=%s, b=%s  \n", ab1, ab2);
			f(ab1, ab2);
			System.out.printf("2 a=%s, b=%s  \n", ab1.val, ab2.val);
		}

	}

	static class AB {
		Integer val;

		public AB(Integer val) {
			super();
			this.val = val;
		}

	}
}
