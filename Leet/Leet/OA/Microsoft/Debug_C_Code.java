package Leet.OA.Microsoft;

public class Debug_C_Code {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fun();
	}

	static void fun() {
		int n = 123456789;
//	    char s[10];
		char[] arr = new char[10];
		int d = 0;
		for (int m = n; m > 0; m /= 10) {//to9, to1, ÔËÐÐ9´Î
			++d;
		}
		//d = 9; n = 123456789;
		for (; n > 0; n /= 10) {
			arr[d] = (char) ('0' + n % 10);
			--d;
		}
		//s:  123456789
		for (int i = 0; i < 10; i++) {
//	        printf("%c", arr[i]);//s:  123456789
			System.out.println("i: "+ i +", " + arr[i]);

		}

	}
}
