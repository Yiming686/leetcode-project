package Lintcode.Array.String.DP;

/**

Copy Books 

 Description
 Notes
 Testcase
 Judge
Given n books and the ith book has A[i] pages. You are given k people to copy the n books.

n books list in a row and each person can claim a continous range of the n books. For example one copier can copy the books from ith to jth continously, but he can not copy the 1st book, 2nd book and 4th book (without 3rd book).

They start copying books at the same time and they all cost 1 minute to copy 1 page of a book. What's the best strategy to assign books so that the slowest copier can finish at earliest time?

Have you met this question in a real interview? Yes
Example
Given array A = [3,2,4], k = 2.

Return 5( First person spends 5 minutes to copy book 1 and book 2 and second person spends 4 minutes to copy book 3. )

 *
 */
public class Copy_Books_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//  worked, O(N*logM), M is the total number of pages
   public static int copyBooks000(int[] pages, int k) {
       if (pages.length == 0) {
       return 0;
       }
   
       int total = 0;
       int max = pages[0];
       for (int i = 0; i < pages.length; i++) {
           total += pages[i];
           if (max < pages[i]) {
               max = pages[i];
           }
       }
   
       int start = max;
       int end = total;
//   max is less than total, max --> N, total --> 1
       while (start + 1 < end) {
           int mid = (end - start) / 2 + start;
           if (countCopiers(pages, mid) > k) {
               start = mid;
           } else {
               end = mid;
           }
       }
       if (countCopiers(pages, start) <= k) {
           return start;
       }
       return end;
   }
   
//   count the minmum copiers for the limit
   private static int countCopiers(int[] pages, int limit) {
       if (pages.length == 0) {
           return 0;
       }
       int copiers = 1;
       int sum = pages[0]; // limit is always >= pages[0]
       for (int i = 1; i < pages.length; i++) {
           if (sum + pages[i] > limit) {
               copiers++;
               sum = 0;
           }
           sum += pages[i];
       }
   
       return copiers;
   }

//=================================================================
	
}
