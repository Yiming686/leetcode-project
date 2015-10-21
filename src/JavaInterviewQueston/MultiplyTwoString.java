package JavaInterviewQueston;

public class MultiplyTwoString {

public static String multiplyTwoStrings2(String num1, String num2) {
	if (num1 == null || num1.length() == 0) {
		throw new IllegalArgumentException();
	}
	if (num2 == null || num2.length() == 0) {
		throw new IllegalArgumentException();
	}
	boolean isNegative1 = false;
	boolean isNegative2 = false;
	if(num1.startsWith("-")){
		isNegative1 = true;
		num1 = num1.substring(1);
	}
	if(num2.startsWith("-")){
		isNegative2 = true;
		num2 = num2.substring(1);
	}
	
	int len1 = num1.length();
	int len2 = num2.length();
	for (int i = 0; i < len1; i++) {
		char ch = num1.charAt(i);
		if (ch < '0' || ch > '9')
			throw new IllegalArgumentException();
	}
	for (int i = 0; i < len2; i++) {
		char ch = num2.charAt(i);
		if (ch < '0' || ch > '9')
			throw new IllegalArgumentException();
	}

	int len3 = len1 + len2;
	int i, j, product, carry;

	int[] num3 = new int[len3];
	for (i = len1 - 1; i >= 0; i--) {
		// reset carry
		carry = 0;
		int a = num1.charAt(i) - '0';
		for (j = len2 - 1; j >= 0; j--) {
			int b = num2.charAt(j) - '0';
			product = carry + num3[i + j + 1] + a * b;
			num3[i + j + 1] = product % 10;
			carry = product / 10;
		}
		// keep the carry
		num3[i] = carry;
	}

	StringBuilder sb = new StringBuilder();
	i = 0;
	// check from 0 to len3 - 1
	while (i < len3 - 1 && num3[i] == 0) {
		i++;
	}
	while (i < len3) {
		sb.append(num3[i]);
		i++;
	}
	//check if the result is negative
	if(isNegative1 != isNegative2){
		if(!sb.toString().equals("0")){
			sb.insert(0, '-');
		}
	}
	return sb.toString();
}


public static String multiplyTwoStrings(String num1, String num2) {
	if (num1 == null || num1.length() == 0) {
		throw new IllegalArgumentException();
	}
	if (num2 == null || num2.length() == 0) {
		throw new IllegalArgumentException();
	}
	boolean isNegative1 = false;
	boolean isNegative2 = false;
	if(num1.startsWith("-")){
		isNegative1 = true;
		num1 = num1.substring(1);
	}
	if(num2.startsWith("-")){
		isNegative2 = true;
		num2 = num2.substring(1);
	}
	
	int len1 = num1.length();
	int len2 = num2.length();
	for (int i = 0; i < len1; i++) {
		char ch = num1.charAt(i);
		if (ch < '0' || ch > '9')
			throw new IllegalArgumentException();
	}
	for (int i = 0; i < len2; i++) {
		char ch = num2.charAt(i);
		if (ch < '0' || ch > '9')
			throw new IllegalArgumentException();
	}

	int len3 = len1 + len2;
	int i, j, product, carry;

	int[] num3 = new int[len3];
	for (i = len1 - 1; i >= 0; i--) {
		int a = num1.charAt(i) - '0';
		for (j = len2 - 1; j >= 0; j--) {
			int b = num2.charAt(j) - '0';
			num3[i + j + 1] += a * b;
		}
	}
	carry = 0;
	for(i = len3-1; i >= 0; i --){
		product = num3[i] + carry;
		num3[i] = product  % 10;
		carry = product  / 10;
	}

	StringBuilder sb = new StringBuilder();
	i = 0;
	// check from 0 to len3 - 1
	while (i < len3 - 1 && num3[i] == 0) {
		i++;
	}
	while (i < len3) {
		sb.append(num3[i]);
		i++;
	}
	//check if the result is negative
	if(isNegative1 != isNegative2){
		if(!sb.toString().equals("0")){
			sb.insert(0, '-');
		}
	}
	return sb.toString();
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("%6s%15s%15s%30s\n", "Index", "num1", "num2",
				"Multiplication ");
		System.out
				.printf("----------------------------------------------------------------------\n");
		String num1 = "0";
		String num2 = "0";
		int index = 1;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "0";
		num2 = "1";
		index++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "1";
		num2 = "0";
		index++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "1";
		num2 = "1";
		index++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "1";
		num2 = "-1";
		index++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "0";
		num2 = "-678";
		index++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "-678";
		num2 = "0";
		index++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "2";
		num2 = "35";
		index++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "2";
		num2 = "-35";
		index++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "-2";
		num2 = "35";
		index++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "-2";
		num2 = "-35";
		index++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "1000";
		num2 = "100";
		index ++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "24542";
		num2 = "585";
		index ++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "123456789";
		num2 = "985674321";
		index ++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "1234567890";
		num2 = "9856743210";
		index ++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "999999999999";
		num2 = "999999999999";
		index ++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "-999999999999";
		num2 = "999999999999";
		index ++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "-9999990999999";
		num2 = "-9999990999999";
		index ++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "-111111111111";
		num2 = "111111111111";
		index ++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "10000000000000";
		num2 = "10000000000000";
		index ++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = String.valueOf(Integer.MAX_VALUE ) ;
		num2 = String.valueOf(Integer.MAX_VALUE);
		index ++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = String.valueOf(Integer.MAX_VALUE ) + "00" ;
		num2 = "-" + String.valueOf(Integer.MAX_VALUE)+ "00";
		index ++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "000";
		num2 = "00000";
		index++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "-000";
		num2 = "00000";
		index++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		
		num1 = "-020";
		num2 = "00100";
		index++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "-020";
		num2 = "-00100";
		index++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		
		num1 = "20";
		num2 = "48";
		index++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "20";
		num2 = "-48";
		index++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "-20";
		num2 = "48";
		index++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
		num1 = "-20";
		num2 = "-48";
		index++;
		System.out.printf("%6s%15s%15s%30s\n", index, num1, num2,
				multiplyTwoStrings(num1, num2));
	}

}
