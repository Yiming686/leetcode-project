package Lintcode.String.Palindrome;

/**
Palindrome Partitioning II

 Description
 Notes
 Testcase
 Judge
Given a string s, cut s into some substrings such that every substring is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Have you met this question in a real interview? Yes
Example
Given s = "aab",

Return 1 since the palindrome partitioning ["aa", "b"] could be produced using 1 cut.

Tags 
Dynamic Programming
Related Problems 
Medium Wiggle Sort II 25 %
Medium Palindrome Partitioning 25 %
Medium Longest Palindromic Substring 28 %

 *
 */
public class Palindrome_Partitioning_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //  i--, j++
    //  s.charAt(i) == s.charAt(j) ���� s.charAt[i] == s.charAt[j]
    // ���״�: minCut[i] = Math.min(minCut[i], minCut[j+1] + 1);
    // Ϊʲô��j+1����j��,������

	//version 1, Worked, Best concise��ʷ����ѵ�
    //����ͬLongest Palindromic Substring�� All Unique Palindromes
    // ����һ��string ���������ָ����С�ָ�
    // �ؼ������ָ��ֱ�ۣ���������ã���С�ͱȽ��鷳��
    // ��������С�ָ�����Ĵ����ˣ��Ⱦ��µĸ������ˣ��ؼ��ǽ���dp[]�ĺ���
    // dp[i]��iλ�õ���β�Ļ��ķָ���
    public static int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int dp[] = new int[len+1];//len-1,len-2,len-3,...
        boolean[][] isPal = new boolean[len][len];
        for (int i = 0; i <= len; i++) {
            dp[i] = len - i - 1;//��ʼ��Ϊ���cuts
        }

        for (int i = len - 1; i >= 0; i--) {
    		for (int j = i; j < len; j++) {
                if(s.charAt(i) == s.charAt(j) && (j-i<2 || isPal[i+1][j-1])){
                    isPal[i][j] = true;
                    //��i=len-1ʱ��j+1=len,����dp��lenΪlen+1
                    //��
                    // dp[i] = dp[j+1] + 1;
                    dp[i] = Math.min(dp[i], dp[j+1] + 1);
                }    		    
    		}
        }
        return dp[0];//�Ӵ�λ�õ�������С�ָ���
        // return dp[len];
    }
}
