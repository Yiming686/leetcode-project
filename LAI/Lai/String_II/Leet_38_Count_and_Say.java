package Lai.String_II;


/**

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ¡Ü n ¡Ü 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

 *
 */
public class Leet_38_Count_and_Say {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String countAndSay(int n) {
		// Write your solution here    
		StringBuilder sb = new StringBuilder("1");
		while (--n > 0) {
			int size = sb.length();
			char prevCh = sb.charAt(0);
			int count = 1;
			for (int i = 1; i < size; i++) {
				char currCh = sb.charAt(i);
				if (currCh != prevCh) {
					sb.append(count);
					sb.append(prevCh);
					prevCh = currCh;
					count = 1;
				} else {
					count++;
				}
			}
			sb.append(count);
			sb.append(prevCh);
			//delete chars from 0 to size - 1
			sb.delete(0, size);
		}
		return sb.toString();
	}

}
