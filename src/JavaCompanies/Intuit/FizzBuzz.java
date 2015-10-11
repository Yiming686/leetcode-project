package JavaCompanies.Intuit;

import java.util.Scanner;
/*
Write a program to print the numbers from 1 to N, each on a new line, but for multiples of three print ¡°Fizz¡± instead of the number and for the multiples of five print ¡°Buzz¡±.  For numbers which are multiples of both three and five print ¡°FizzBuzz¡±. 

Input
Read in a single integer N from STDIN.

Output
N lines with one integer or string per line as described above.

Constraints :
N < 107

Sample Input #1:
15

Sample Output #1:
1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz
 
Explanation:
Position 3, 6, 9, 12 have the word "Fizz" because they are multiples of 3.
Positions 5 and 10 have the word "Buzz" because they are multiples of 5.  
Position 15 has the word FizzBuzz because it is a multiple of both 3 and 5.  


 *
 */
public class FizzBuzz {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printNum(n);
	}

	public static void printNum(int n) {
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}
}