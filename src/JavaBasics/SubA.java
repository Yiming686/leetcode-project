package JavaBasics;

public class SubA extends SupperA{

	public int subA_public;
	protected int subA_protected;
	int subA_default;
	private int subA_private;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SupperA supperA = new SupperA();
		int temp1 = supperA.supperA_public;
		int temp2 = supperA.supperA_default;
		int temp3 = supperA.supperA_protected;
//		int temp4 = supperA.su.su.supperA_protected;

	}

}
