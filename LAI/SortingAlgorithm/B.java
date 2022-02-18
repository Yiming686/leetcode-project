package SortingAlgorithm;

import Lai.Midterm_I_II_III.Print_A_B_C;

public abstract class B extends A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	B(int y){
		this.y = y;
	}
	public int y;
	private void print() {
		System.out.println("ddd: "+ y);
	}
}

class C extends B {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C c = new C();
		c.print();
	}
	private void print() {
		System.out.println("ddd: "+ y);
	}

	C(){
		super(888);
//		new B(9);
	}
}