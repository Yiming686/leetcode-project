package Lintcode;

import java.util.LinkedList;
import java.util.Stack;

public class SupperB{

	public int supperB_public;
	protected int supperB_protected;
	int supperB_default;
	private int supperB_private;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<>();
		
		SubA subA = new SubA();
//		int temp = subB.subB_private;
		int temp1 = subA.subB_default;
		int temp2 = subA.subB_protected;
		
		int temp3 = subA.supperA_public;
//		int temp4 = subB.supperA_protected;

	}

}
