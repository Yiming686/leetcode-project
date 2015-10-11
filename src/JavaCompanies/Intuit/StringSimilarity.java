package JavaCompanies.Intuit;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
For two strings A and B, we define the similarity of the strings to be the length of the longest prefix common to both strings. For example, the similarity of strings ¡°abc¡± and ¡°abd¡± is 2, while the similarity of strings ¡°aaa¡± and ¡°aaab¡± is 3.
Calculate the sum of similarities of a string S with each of its suffixes, including the string itself as the first suffix.

Input:
The first line contains the number of test cases T. Each of the next T lines contains a string each.

Output:
Output T lines, each containing one integer that is the answer for the corresponding test case.

Constraints:
1 ¡Ü T ¡Ü 10
The length of each string is at most 100,000
The strings contain only lowercase characters [a-z].

Sample Input:
2
ababaa  
aa
Sample Output:
11  
3

Explanation:
For the first case, the suffixes of the string are ¡°ababaa¡±, ¡°babaa¡±, ¡°abaa¡±, ¡°baa¡±, ¡°aa¡± and ¡°a¡±. The similarities of each of these strings with the string ¡°ababaa¡± are 6,0,3,0,1,1 respectively. Thus the answer is 6 + 0 + 3 + 0 + 1 + 1 = 11.
For the second case, the answer is 2 + 1 = 3.   
   
   
 */

public class StringSimilarity {
	// public static void main(String [] args) throws Exception
	// {
	// Scanner sc = new Scanner(System.in);
	// int n = sc.nextInt();
	// for(int t = 0; t < n; t++) {
	// int a = sc.nextInt();
	// int b = sc.nextInt();
	// System.out.println(a+b);
	// }
	// }
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		// public static void main(String [] args) throws Exception
		// {
		// Scanner sc = new Scanner(System.in);
		// int n = sc.nextInt();
		// for(int t = 0; t < n; t++) {
		// int a = sc.nextInt();
		// int b = sc.nextInt();
		// System.out.println(a+b);
		// }

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		for (int t = 0; t < n; t++) {
			String str = sc.nextLine();
			calculateSum2(str);
		}

	}

	public static void calculateSum(String str) {
		int len = str.length();
		int result = 0;
		for (int i = 0; i < len; i++) {
			int curr = i, j = 0;
			for (; j < len && curr < len; j++) {
				if (str.charAt(j) != str.charAt(curr)) {
					break;
				}
				curr++;
			}
			result += j;
		}
		System.out.println(result);
	}

	
	public static void calculateSum2(String str) {
		int len = str.length();
		int result = 0;
		for (int i = 0; i < len; i++) {
			int curr = i, j = 0;
			for (; j < len && curr < len; j++, curr++) {
				if (str.charAt(j) != str.charAt(curr)) {
					break;
				}
			}
			result += j;
		}
		System.out.println(result);
	}
	

	
	
	

}