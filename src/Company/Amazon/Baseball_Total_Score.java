package Company.Amazon;
import java.util.Stack;

/**

Baseball_Total_Score

The current selected programming language is Java. We emphasize the submission of a fully working code 
over partially correct but efficient code. Once submitted, you cannot review this problem again. 
The version of JDK being used is 1.8

John plays a game in which he throws a baseball at various blocks marked with a symbol so as to knock these out. 
A score is computed for each throw. The ¡°last score¡± is the score of the previous throw (or 0, 
if there is no previous throw) and the total score is the sum of the scores of all the throws. 
The symbol on a block can be an integer, a sign or a letter. Each sign or letter represents a special rule 
as given below:

If a throw hits a block marked with an integer, the score for that throw is the value of that integer.
If a throw hits a block marked with an 'X', the score for that throw is double the last score.
If a throw hits a block marked with a '+', the score for that throw is the sum of the last two scores.
If a throw hits a block marked with a 'Z', the last score is removed, as though the last throw never happened. Its value does not count towards the total score, and the subsequent throws will ignore it when computing their values (see example below).
Write an algorithm that computes the total score for a given list of ordered hits by John.

Input
The input to the function/method consists of two arguments - blocks, representing a list of symbols and 
n, an integer representing the number of symbols in the list.

Output
Return an integer representing the total score for the given list of ordered hits.
Example
Input:
blocks = [5, -2, 4, Z, X, 9, +, +], n = 8
Output:
27

Explanation:
After the block marked with 5 is hit, the current score is 5 and the total score is 5.
After the block marked with -2 is hit, the current score is -2 and the total score is 3.
After the block marked with 4 is hit, the current score is 4 and the total score is 7.
After the block marked with 'Z' is hit, the previous throw never happened, so the total score goes back to 3.
After the block marked with 'X' is hit, the current score is 2 * -2 = -4 and the total score is -1. (remember, throws after a Z ignore the removed score when computing their values)
After the block marked with 9 is hit, the current score is 9 and the total score is 8.
After the block marked with '+' is hit, the current score is -4 + 9 = 5 and the total score is 13.
After the block marked with '+' is hit, the current score is 9 + 5 = 14 and the total score is 27.


TestCase 1: 

Input: 
[5, -2, 4, Z, X, 9, +, +], 8
Expected Return Value: 
27
TestCase 2: 

Input: 
[1, 2, +, Z], 4

Expected Return Value: 
3


 *
 */
public class Baseball_Total_Score {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] blocks = {"5", "-2", "4", "Z", "X", "9", "+", "+"};
		System.out.println(""+totalScore(blocks,blocks.length));
		String[] blocks2 = {"1", "2", "+", "Z"};
		System.out.println(""+totalScore(blocks2,blocks2.length));

	}

	public static int totalScore(String[] blocks, int n)
	{
		// WRITE YOUR CODE HERE
		if (blocks == null || blocks.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		int temp = 0;
		int temp2 = 0;
		for(String str : blocks){
		    switch(str){
    		    case "X":
    		        if (!stack.isEmpty()) {
        		        temp = 2*stack.peek();
        		        stack.push(temp);
        		        sum += temp;
    		        }  
    		        break;
                case "+":
                    if (!stack.isEmpty()) {
                        temp = stack.pop();
                        temp2 = stack.peek();
                        stack.push(temp);
                        stack.push(temp + temp2);
                        sum += stack.peek();
                    }
    		        break;		        
    		    case "Z":
    		        if (!stack.isEmpty()) {
        		        temp =  stack.pop();
        		        sum -= temp;
    		        }
    		        break;
    		    default:
    		        temp = Integer.valueOf(str);
    		        stack.push(temp);
    		        sum += temp;
		    }
		}
		return sum;
	}

}
