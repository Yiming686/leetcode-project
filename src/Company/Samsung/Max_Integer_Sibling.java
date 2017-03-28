package Company.Samsung;

import static org.junit.Assert.*;

import org.junit.Test;

public class Max_Integer_Sibling {

	@Test
	public void testFindMax(){
		assertEquals(321, findMax(123));
		assertEquals(553, findMax(355));
		assertEquals(553, findMax(-355));
		assertEquals(-1, findMax(Integer.MAX_VALUE));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+findMax(355));
		System.out.println(""+findMax(213));
		System.out.println(""+findMax(543));
		System.out.println(""+Integer.MIN_VALUE);
		System.out.println(""+Integer.MAX_VALUE);
//		System.out.println(""+findMax(Integer.MAX_VALUE));2147483648
		System.out.println(""+findMax(Integer.MIN_VALUE-1));
//		System.out.println(""+findMax(-23454539));
	}
	private static int findMax(int num){
		if(num < 0) {
			num = (-1) * num;	
		}
		int len = String.valueOf(Integer.MAX_VALUE).length();
		int[] arr = new int[10];
		int val = num;
		while(val != 0){
			int index = val%10;
			arr[index]++;
			val = val/10;
		}
		String str = "";
		for(int i = len - 1; i >= 0; i--){
			for(int count = 0; count < arr[i]; count++){
				str += i;	
			}
		}
		System.out.println(""+str);
		try{
			val = Integer.valueOf(str);
		}catch(NumberFormatException ex){
			val = -1;
		}
		return val;
		
	}

}
