package JavaBasics;

import java.util.HashMap;
import java.util.Map;

class A {
	static int a = 0;
	C ca = new C();

	int f() {
		return 5;
	}

	{
		int cb = ca.c;
	}
	private int a2 = 0;

	class B {
		// static int b = 0;
		private int b1 = 2;
		private int a2 = 2;

		B(int b2) {
			this.b1 = b2;
			A.this.a2 = b2;
			b2 = a2;
			a2 = b2;
			a2 = b1;
		}
	}

}

class C {
	int ff() {
		new A() {
			{
				f();
			}
		};
		return 9;
	}

	static int c = 0;
}

public class Java_Inner_Class {
	int ff() {

		return Java_Inner_Class.this.ff();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

class Dog {

	public void f() {
		System.out.println("void f() in Dog");
	}

	public interface Pet {

		public void beFriendly();

		public void play();

	}

	public static void main(String[] args) {

		new Dog() {
			public void f() {
				System.out.println("222void f() in Dog");
				Map<Integer, Integer> map = new HashMap<Integer, Integer>() {

					private static final long serialVersionUID = 8623272850179697565L;

					{
						put(1, 1);
						put(2, 2);
						put(3, 3);
					}
				};
				map.put(4, 4);
				map.put(5, 5);
				map.put(3, 8);

				System.out.println(map);
			}
		}.f();

		Pet dog = new Pet() {
			@Override
			public void beFriendly() {
				System.out.println("蹭蹭你^_^");
			}

			@Override
			public void play() {
				System.out.println("把飞盘叼给你，逼你把飞盘丢出去，然后它再捡回来让你继续扔，连续500次^_^");
			}
		};

		dog.beFriendly();
		dog.play();

	}
}

class Outer {

	int x = 1;

	public void doSomething() {
		final int y = 2;
		final int yy;
		int z = 8;
		yy = 22;
		class Inner {
			int x = 3;

			void print() {
				int x = 4;
				System.out.println(x);
				System.out.println(this.x = 8);
				System.out.println(Outer.this.x = 9);
				System.out.println(y);
				System.out.println(yy);
			}
		}
		Inner inner = new Inner();
		inner.print();
		z = z + 3;
	}

	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.doSomething();
	}
}
