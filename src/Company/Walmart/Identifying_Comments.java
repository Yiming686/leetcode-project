package Company.Walmart;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jdk.internal.dynalink.beans.StaticClass;
public class Identifying_Comments {

	static String code1 = "          // my  program in C++   \n "+
" \n" +
"#include <iostream> \n "+
"/** playing around in\n "+
"a new programming language **/\n "+
"using namespace std;\n "+
"\n "+
"int main ()\n "+
"{\\n "+
"  cout << \"Hello World\";\n "+
"  cout << \"I'm a C++ program\"; //use cout\n "+
"  return 0;\n "+
"}";
	
	static String code2 = " /*This is a program to calculate area of a circle after getting the radius as input from the user*/\n#include<stdio.h>\nint main()\n{\n   double radius,area;//variables for storing radius and area\n   printf(\"Enter the radius of the circle whose area is to be calculated\\n\");\n   scanf(\"%lf\",&radius);//entering the value for radius of the circle as float data type\n   area=(22.0/7.0)*pow(radius,2);//Mathematical function pow is used to calculate square of radius\n   printf(\"The area of the circle is %lf\",area);//displaying the results\n   getch();\n}\n/*A test run for the program was carried out and following output was observed\nIf 50 is the radius of the circle whose area is to be calculated\nThe area of the circle is 7857.1429*/"; 
	static final Pattern PATTERN = Pattern.compile("(//[^\\n]*)|(/\\*.*?\\*/)", Pattern.MULTILINE | Pattern.DOTALL);
//	static final Pattern PATTERN = Pattern.compile("(/\\*([^*]|(\\*+[^*/]))*\\*+/)|(//.*)", Pattern.MULTILINE | Pattern.DOTALL);

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String myString = scanner.next();
//		int myInt = scanner.nextInt();
//		scanner.close();
//
//		System.out.println("myString is: " + myString);
//		System.out.println("myInt is: " + myInt);

		
//		Scanner sc = new Scanner(System.in);
//
//		String code = readCode(sc);
		
		Matcher matcher = PATTERN.matcher(code2);
		while (matcher.find()) {
			String comment = matcher.group();
			display(comment);
		}

//		sc.close();
	}

	static String readCode(Scanner sc) {
		StringBuilder sb = new StringBuilder();
		while (sc.hasNextLine()) {
			sb.append(sc.nextLine());
			sb.append("\n");
		}
		return sb.toString();
	}

	static void display(String comment) {
		Scanner sc = new Scanner(comment);

		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine().trim());
		}

		sc.close();
	}

}
