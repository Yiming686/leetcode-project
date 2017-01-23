package Lintcode;

import org.junit.experimental.theories.Theories;

import JavaBasics.SupperA;

public class SubA extends SupperA{

	public int subB_public;
	protected int subB_protected;
	int subB_default;
	private int subB_private;
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		SubA subA = new SubA();
		int temp = subA.subB_private;
		int temp1 = subA.subB_default;
		int temp2 = subA.subB_protected;
		
		int temp3 = subA.supperA_public;
		int temp4 = subA.supperA_protected;
		
//		int temp = supperA.supperA_public;
//		
//		int temp1 = supperA.supperA_public;
//		int temp2 = supperA.su.su.supperA_default;
//		int temp3 = supperA.supperA_protected;
//		int temp4 = supperA.su.su.supperA_protected;

		
	}

}
