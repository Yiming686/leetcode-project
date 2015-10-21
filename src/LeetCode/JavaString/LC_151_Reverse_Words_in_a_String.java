package LeetCode.JavaString;

/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.

Hide Tags String


 */
public class LC_151_Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        if (s == null ) return null;
        if(s.length() == 0) {
            return "";
        }

        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        String prefix = "";
        for (int i = array.length - 1; i >= 0; --i) {
            if (!array[i].equals("")) {
                sb.append(prefix).append(array[i]);
            }
            prefix = " ";
        }
        return sb.toString();
        //remove the last " "
        // return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
