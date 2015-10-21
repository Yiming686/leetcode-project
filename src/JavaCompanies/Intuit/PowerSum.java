package JavaCompanies.Intuit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
/*
You are given two integers, l and r. Find the number of integers x such that l <= x <= r, and x is a Power Number.
A Power Number is defined as an integer that can be represented as sum of two powers, i.e.
x = ap + bq,
a, b, p and q are all integers, 
a, b ¡Ý 0, and
p, q > 1.
 
You have to complete function int countPowerNumbers(int l, int r), which takes the arguments l and r and returns the result as described above. The code to process input and output is already provided.

Constraints
1 ¡Ü l ¡Ü r ¡Ü 5,000,000
 
Sample Input #1
l = 0
r = 1
 
Sample Output #1:
2
 
Explanation #1:
0 and 1 both are Power Numbers. 0 = 02+02. 1 = 12+02.
 
Sample Input #2:
l = 25
r = 30
 
Sample Output #2:
5
 
Explanation #2:
Except 30, all are Power Numbers.
25 = 52 + 02,
26 = 52 + 12,
27 = 33 + 02,
28 = 33 + 12,
29 = 55 + 22.
 *
 *
 */


public class PowerSum {
//	first submission
	public static int countPowerNumbers2(int l, int r) {
		Set<Long> set = new HashSet<Long>();
		set.add(0l);
		set.add(1l);

		for (int i = 0; i <= (int) Math.ceil(Math.sqrt(r)); i++) {
			if (set.contains(i)) {
				continue;
			}
			for (int j = 2; j < r; j++) {
				long temp = (long) Math.pow(i, j);
				if (temp > r) {
					break;
				}
				set.add(temp);
			}
		}
		int result = 0;
		for (int i = l; i <= r; i++) {
			boolean found = false;
			for (int j = 0; j < r; j++) {
				if (set.contains((long)j) && set.contains((long)i - j)) {
					found = true;
					break;
				}
			}
			if (found) {
				result++;
			}
		}
		return result;
	}
	
//		second submission
	public static int countPowerNumbers3(int left, int right) {
		Set<Long> set = new HashSet<Long>();
		set.add(0l);
		set.add(1l);

		for (int i = 0; i <= (int) Math.ceil(Math.sqrt(right)); i++) {
			if (set.contains(i)) {
				continue;
			}
			for (int j = 2; j < right; j++) {
				long temp = (long) Math.pow(i, j);
				if (temp > right) {
					break;
				}
				set.add(temp);
			}
		}
		int result = 0;
		for (int i = left; i <= right; i++) {
			boolean found = false;
			for (int j = 0; j <= (left+right)/2; j++) {
				if (set.contains((long)j) && set.contains((long)i - j)) {
					found = true;
					break;
				}
			}
			if (found) {
				result++;
			}
		}
		return result;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int t = 0; t < n; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(a + b);
//			countPowerNumbers(1,3);
		}
	}

	/*
	 * Complete the function below.
	 */

//	static int countPowerNumbers(int l, int r) {
//		if (l < 1 || l > r || r > 5000000) throw new IllegalArgumentException();
//			
//		
//		return -1;
//	}
	public static int numPowerNumber(int l, int r){
		if(r<l) return -1;
		int count=0; 
		List<Integer> list=getPowers(r);
		
		for(int i=l; i<=r; i++){
			if(isPowerSum(list, i)) count++;
		}
		return count;
	}
	
	public static boolean isPowerSum(List<Integer> list, int target){    
        int begin=0; 
        int end=list.size()-1; 
        
        while(begin<end){
            int sum=list.get(begin)+list.get(end);
            if(sum==target) return true;
            else if(sum<target) begin++;
            else end--;
        }
        return false;
    }
	
	
	public static List<Integer> getPowers(int n){
		Set<Integer> set=new HashSet<Integer>();
		set.add(0); set.add(1);
		int rootN=(int)Math.sqrt(n);
		
		for(int i=2; i<=rootN; i++){
			int num=i; 
			while(num*i<=n){
				num*=i; set.add(num);
			}
		}		
		List<Integer> list=new ArrayList<Integer>();
		for(int x : set) list.add(x);
		Collections.sort(list);
		return list;
	}

	
	
	
}