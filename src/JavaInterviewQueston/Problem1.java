package JavaInterviewQueston;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Problem1 {

	public static void validateString(String str) {
		// 1. str should not be null or empty
		if (str == null || str.length() == 0)
			throw new IllegalArgumentException("The argument \"" + str
					+ "\" is illegal!");
		// 2. let us assume that str can only contain characters which are the
		// digits '0'-'9' or a '-' or a '.'
		if (str.startsWith("-"))
			str = str.substring(1);
		int countOfDot = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			// once ch is not a digital character nor a dot, throw exception
			if (!(Character.isDigit(ch) || ch == '.'))
				throw new IllegalArgumentException("The argument \"" + str
						+ "\" is illegal!");
			if(ch == '.') countOfDot++;
		}
		// 3. let us assume that there is always only one dot in the str
		
		if (countOfDot > 1 )
			throw new IllegalArgumentException("The argument \"" + str
					+ "\" is illegal!");
	}

	private static String convertString(String str) {
		// TODO Auto-generated method stub
		if(str == null || str.length() == 0) return null;
		String[] strArr = str.split("\\.");
		if(strArr.length == 1)  return str + "00";
		if (strArr[1].length() == 2)
			return str;
		// ie. convert "2." to "2.00", "3.3" to "3.30", "4.444444" to "4.44"
		if (strArr[1].length() == 0)
			strArr[1] = "00";
		if (strArr[1].length() == 1)
			strArr[1] += "0";
		if (strArr[1].length() > 2)
			strArr[1] = strArr[1].substring(0, 2);
		String newStr = strArr[0] + '.' + strArr[1];
		return newStr;
	}

	private static int compareTwoStrings(String s1, String s2) {
		// compare the absolute value of two strings
		if (s1.startsWith("-"))
			s1 = s1.substring(1);
		if (s2.startsWith("-"))
			s2 = s2.substring(1);
		int len1 = s1.length();
		int len2 = s2.length();
		int max = Math.max(len1, len2);
		for (int i = 0; i < max; i++) {
			int index1 = i - max + len1;
			int index2 = i - max + len2;
			char ch1 = index1 < 0 ? '0' : s1.charAt(index1);
			char ch2 = index2 < 0 ? '0' : s2.charAt(index2);
			if (ch1 != ch2)
				return ch1 - ch2;
		}
		return 0;
	}

	public static String calculateDivision(String s1, int n, int accuracy) {
		// 1. validate two Strings
		validateString(s1);
		if (n < 0) throw new IllegalArgumentException("The argument \"" + n
				+ "\" is illegal!");
		// 2. convert two Strings
		s1 = convertString(s1);
		if(s1==null) return null;

		// 3. check if arguments are negative
		boolean isNegative1 = s1.startsWith("-");
		if (isNegative1 == true)
			s1 = s1.substring(1);
		
		// 4. compute the division from the rightmost to leftmost
		StringBuilder sb = new StringBuilder();
		int len1 = s1.length();
		int index = 0;
		int count = 0;
		String str = "";
		while(count < accuracy + 2){
			char ch  = index >= len1 ? '0' : s1.charAt(index);
			index++;
			if(ch == '.' || count > 0) count++;
			if(ch == '.') {
				if(sb.length()==0){
					sb.append("0.");
				}else{
					sb.append(".") ;
				}
				continue;
			}
			int val = Integer.valueOf(str+ch);
			if(val == 0){
				continue;
			}else if(val < n){
				sb.append("0") ;
				str += ch;
			}else{
				sb.append(val / n) ;
				str = "" +val % n;
			}
		}
//		5. truncate the value to make sure the result is accurate up to the specified decimal places
		int pos = sb.indexOf(".") + accuracy + 1;
		if(pos < sb.length() && sb.charAt(pos) - '5' >= 0){
				sb.delete(sb.indexOf(".") + accuracy + 1, sb.length() + 1);
				int carry = 1;
				for(int i = sb.length()-1; i >=0 ; i --){
					if(sb.charAt(i) == '.') continue;
					int sum = Character.getNumericValue(sb.charAt(i)) + carry;
					sb.setCharAt(i, Character.forDigit(sum % 10, 10));
					carry = sum / 10;
					if(carry == 0) break;
				}
				if(carry > 0) sb.insert(0, carry);
		}else if(pos < sb.length()){
			sb.delete(pos, sb.length() + 1);
		}
		
		// 6. remove all the 0s at the beginning of the StringBilder except the one before the dot
		// ie. convert 0078.32 to 78.32, 0000.45 to 0.45
		int len = sb.length();
		int start = 0;
		while (start + 1 < len && sb.charAt(start) == '0' && sb.charAt(start + 1) != '.') {
			start++;
		}
		
		// 7. add "-" if needed
		if (isNegative1 == true) {
			return "-" + sb.substring(start);
		} else {
			return sb.substring(start);
		}
	}

	public static String calculateSum(String s1, String s2) {
		// 1. validate two Strings
		validateString(s1);
		validateString(s2);
		// 2. convert two Strings
		s1 = convertString(s1);
		s2 = convertString(s2);
		
		if(s1==null) return null;
		if(s2==null) return null;

		// 3. check if arguments are negative
		boolean isNegative1 = s1.startsWith("-");
		boolean isNegative2 = s2.startsWith("-");
		if (isNegative1 != isNegative2) {
			if (isNegative1 == true) {
				return calculateSubtraction(s2, s1.substring(1));
			} else {
				return calculateSubtraction(s1, s2.substring(1));
			}
		}
		if (isNegative1 == true)
			s1 = s1.substring(1);
		if (isNegative2 == true)
			s2 = s2.substring(1);

		// 4. compute the sum from the rightmost to leftmost, since both s1 and s2 are valid
		StringBuilder sb = new StringBuilder();
		int len1 = s1.length();
		int len2 = s2.length();
		int carry = 0;
		int max = Math.max(len1, len2) - 1;

		for (int i1 = len1 - 1, i2 = len2 - 1; max >= 0; max--, i1--, i2--) {
			char ch1 = i1 < 0 ? '0' : s1.charAt(i1);
			char ch2 = i2 < 0 ? '0' : s2.charAt(i2);
			if (ch1 == '.' && ch2 == '.') {
				sb.insert(0, '.');
				continue;
			}
			int s = carry + Character.getNumericValue(ch1)
					+ Character.getNumericValue(ch2);
			carry = s / 10;
			sb.insert(0, s % 10);
		}
		sb.insert(0, carry);

		// 5. remove all the 0s at the beginning of the StringBilder except the one before the dot
		// ie. convert 0078.32 to 78.32, 0000.45 to 0.45
		int len = sb.length();
		int start = 0;
		while (start + 1 < len && sb.charAt(start) == '0' && sb.charAt(start + 1) != '.') {
			start++;
		}

		// 6. add "-" if both are negative
		if (isNegative1 == true) {
			return "-" + sb.substring(start);
		} else {
			return sb.substring(start);
		}
	}

	public static String calculateSubtraction(String s1, String s2) {
		// 1. validate two Strings
		validateString(s1);
		validateString(s2);

		// 2. convert two Strings
		s1 = convertString(s1);
		s2 = convertString(s2);
		if(s1==null) return null;
		if(s2==null) return null;
		
		// 3. check if arguments are negative
		boolean isNegative1 = s1.startsWith("-");
		boolean isNegative2 = s2.startsWith("-");
		if (isNegative1 != isNegative2) {
			if (isNegative1 == true) {
				return "-" + calculateSum(s1.substring(1), s2);
			} else {
				return calculateSum(s1, s2.substring(1));
			}
		}
		
		// 4. compare the absolute value of two string and swap them if needed to make sure s1 is greater than s2
		if (compareTwoStrings(s1, s2) < 0) {
			isNegative1 = ! isNegative1;
			String temp = s1;
			s1 = s2;
			s2 = temp;
		}

		// 5. compute the Subtraction from the rightmost to leftmost, since both s1 and s2 are valid
		StringBuilder sb = new StringBuilder();
		int len1 = s1.length();
		int len2 = s2.length();
		int borrow = 0;
		int max = Math.max(len1, len2) - 1;
		for (int i1 = len1 - 1, i2 = len2 - 1; max >= 0; max--, i1--, i2--) {
			char ch1 = i1 < 0 ? '0' : s1.charAt(i1);
			char ch2 = i2 < 0 ? '0' : s2.charAt(i2);
			if (ch1 == '.' && ch2 == '.') {
				sb.insert(0, '.');
				continue;
			}
			int sub = Character.getNumericValue(ch1)
					- Character.getNumericValue(ch2) - borrow;
			if (sub > 0) {
				sb.insert(0, sub);
			}else if(sub == 0){
				borrow = 0;
				sb.insert(0, sub);
			}else{
				borrow = 1;
				sub = 10 + sub;
				sb.insert(0, sub);
			}
		}

		// 6. remove all the 0s at the beginning of the StringBilder except the one before the dot
		// ie. convert 0078.32 to 78.32, 0000.45 to 0.45
		int len = sb.length();
		int start = 0;
		while (start + 1 < len && sb.charAt(start) == '0' && sb.charAt(start + 1) != '.') {
			start++;
		}
		
		//7. add '-' if needed
		if (isNegative1 == true) {
			return "-" + sb.substring(start);
		} else {
			return sb.substring(start);
		}
	}
	
	public static String computeByStrings(double[] A, int[] arr, int accuracy ){
		if(A==null || A.length == 0) return null;
		if(arr==null || arr.length == 0) return null;
		if(accuracy < 1) return null;
		
		String sum = calculateSum(String.valueOf(A[arr[0]]), String.valueOf(A[arr[1]]));
		for (int i = 2; i < arr.length; i++) {
			sum = calculateSum(sum, String.valueOf(A[arr[i]]));
		}
		String avg = calculateDivision(sum, arr.length, accuracy);
		return avg;
	}
	
	public static BigDecimal computeByBigDecimal(double[] A, int[] arr, int accuracy ){
		if(A==null || A.length == 0) return null;
		if(arr==null || arr.length == 0) return null;
		if(accuracy < 1) return null;
		
		BigDecimal sum  = BigDecimal.valueOf(A[arr[0]]);
		for (int i = 1; i < arr.length; i++) {
			sum = sum.add(BigDecimal.valueOf(A[arr[i]]));
		}
		BigDecimal avg = sum.divide(BigDecimal.valueOf(arr.length), RoundingMode.HALF_UP);
		avg.setScale(accuracy, RoundingMode.HALF_UP);
		return avg;
	}
	
	public static BigDecimal computeByLong(double[] A, int[] arr, int accuracy ){
		if(A==null || A.length == 0) return null;
		if(arr==null || arr.length == 0) return null;
		if(accuracy < 1) return null;
		
		Long sum = Long.valueOf(convertString(String.valueOf(A[arr[0]])).replace(".", ""));
		for (int i = 1; i < arr.length; i++) {
			sum += Long.valueOf(convertString(String.valueOf(A[arr[i]])).replace(".", ""));
		}
		BigDecimal avg = BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(100)).divide(BigDecimal.valueOf(arr.length), RoundingMode.HALF_UP);
		avg.setScale(accuracy, RoundingMode.HALF_UP);
		return avg;
	}

	public static void main(String[] args) {
		
		int accuracy = 2;
//		System.out.println(calculateDivision("-000002.99999994", 3, accuracy));
//		System.out.println(calculateDivision("-00.2", 3, accuracy));
//		System.out.println(calculateDivision("-0.2", 3, accuracy));
//		System.out.println(calculateDivision("-2.", 3, accuracy));
//		System.out.println(calculateDivision("-2.0", 3, accuracy));
//		System.out.println(calculateDivision("-2.00", 3, accuracy));
//		System.out.println(calculateDivision("-2.000", 3, accuracy));
//		System.out.println(calculateDivision("-0000.1", 3, accuracy));
//		System.out.println(calculateDivision("-0000.4599922", 4, accuracy));
////		System.out.println(calculateDivision("-0000.45", 0));
////		System.out.println(calculateDivision("-0000.45", -1));
//		System.out.println(calculateDivision("-0000.4533", 2, accuracy));
//		System.out.println(calculateDivision("-0000.45", 4, accuracy));
		
//		System.out.println(calculateSum("0.22", "0.44"));
//		System.out.println(calculateSum("-0.22", "0.44"));
//		System.out.println(calculateSum("0.22", "-0.44"));
		
//		System.out.println(calculateSubtraction("9.", "8.4"));
//		System.out.println(calculateSubtraction("8.44", "9.22"));
//		System.out.println(calculateSubtraction("90.01", "-22.33"));
//		System.out.println(calculateSubtraction("-22.33", "90.01"));
//		
//		System.out.println(compareTwoStrings("9.22", "128.44"));
		// TODO Auto-generated method stub
		// System.out.println(Character.getNumericValue('\u216C'));
		// System.out.println(Character.getNumericValue('.'));
		// System.out.println('.'+0);
		// System.out.println('0'+0);
		// System.out.println("1".compareTo("."));
		// System.out.println("9".compareTo("."));
//		System.out.println("22.60".compareTo("09.28"));
//		System.out.println("-19".compareTo("19"));
//		System.out.println("-14".compareTo("19"));
		// System.out.println("-14".compareTo("."));
		// System.out.println("-".compareTo("."));
		// System.out.println("56.89".compareTo(".22"));
		// System.out.println("55.88".compareTo("22.44"));
		// System.out.println(("22.44").compareTo("55.88"));
		// System.out.println(calculateSum("55.88", "22.44"));
		// System.out.println(calculateSum("-55.88", "22.44"));
		// System.out.println(calculateSum("55.88", "-22.44"));
		// System.out.println(calculateSum("-55.88", "-22.44"));
		// String calculateSum(String s1, String s2);
		// A[32] = [4.44, 8.45, 12.2, 16.6, 23.8, 31.0, 34.3, 38.8, 8.39, 16.5,
		// 24.0, 31.2, 43.4, 55.2, 58.3, 62.2, 12.2, 24.1, 34.3, 44.2, 58.3,
		// 72.4, 78.3, 82.9, 16.4, 31.1, 43.5, 55.8, 71.5, 82.2, 84.7, -1.00];
double[] A = { 4.44, 8.45, 12.2, 16.6, 23.8, 31.0, 34.3, 38.8, 8.39,
		16.5, 24.0, 31.2, 43.4, 55.2, 58.3, 62.2, 12.2, 24.1, 34.3,
		44.2, 58.3, 72.4, 78.3, 82.9, 16.4, 31.1, 43.5, 55.8, 71.5,
		82.2, 84.7, -1.00 };
		
int N = 30;

//		int N = 1000;
//		int N = 10000;
//		int N = 100000;
//		int N = 30;
int[] arr = new int[N];
//	initiate arr
List<String> list = new ArrayList<String>();
for(int i = 0 ; i < N; i ++){
	arr[i] = new Random().nextInt(31);
	list.add(String.valueOf(A[arr[i]]));
}
		
		System.out.println("A     :"+Arrays.toString(A));
		System.out.println("arr   :"+Arrays.toString(arr));
		System.out.println("values:"+list);
		System.out.println();
		
		String sum = calculateSum(String.valueOf(A[arr[0]]), String.valueOf(A[arr[1]]));
		for (int i = 2; i < N; i++) {
			sum = calculateSum(sum, String.valueOf(A[arr[i]]));
		}
		String avg = calculateDivision(sum, N, accuracy);
	
		
		BigDecimal sum2  = BigDecimal.valueOf(A[arr[0]]);
		for (int i = 1; i < N; i++) {
			sum2 = sum2.add(BigDecimal.valueOf(A[arr[i]]));
		}
		BigDecimal avg2 = sum2.divide(BigDecimal.valueOf(N), RoundingMode.HALF_UP);
		avg2.setScale(accuracy, RoundingMode.HALF_UP);
		
		Long sumLong = Long.valueOf(convertString(String.valueOf(A[arr[0]])).replace(".", ""));
		for (int i = 1; i < arr.length; i++) {
			sumLong += Long.valueOf(convertString(String.valueOf(A[arr[i]])).replace(".", ""));
		}
		BigDecimal sum3 = BigDecimal.valueOf(sumLong).divide(BigDecimal.valueOf(100));
		BigDecimal avg3 = sum3.divide(BigDecimal.valueOf(arr.length), RoundingMode.HALF_UP);
		avg3.setScale(accuracy, RoundingMode.HALF_UP);
		
		System.out.printf("%20s %40s %20s\n", "Item", "Sum", "Avg");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.printf("%-30s %30s %20s\n", "Solution 1: Using BigDecimal ", sum3, avg3);
		System.out.printf("%-30s %22s %20s\n", "Solution 2: Using Long and BigDecimal ", sum2, avg2);
		System.out.printf("%-30s %30s %20s\n", "Solution 3: Using String ", sum, avg);
		
//		System.out.println(computeByStrings(A, arr, accuracy));
//		System.out.println(computeByBigDecimal(A, arr, accuracy));
//		System.out.println(computeByLong(A, arr, accuracy));
		
		
	}

}
