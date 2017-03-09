package Lintcode.Array.QuickSort;

import java.util.Arrays;

/**

Nuts & Bolts Problem

 Description
 Notes
 Testcase
 Judge
Given a set of n nuts of different sizes and n bolts of different sizes. There is a one-one mapping between nuts and bolts. Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.

We will give you a compare function to compare nut with bolt.

Have you met this question in a real interview? Yes
Example
Given nuts = ['ab','bc','dd','gg'], bolts = ['AB','GG', 'DD', 'BC'].

Your code should find the matching bolts and nuts.

one of the possible return:

nuts = ['ab','bc','dd','gg'], bolts = ['AB','BC','DD','GG'].

we will tell you the match compare function. If we give you another compare function.

the possible return is the following:

nuts = ['ab','bc','dd','gg'], bolts = ['BC','AA','DD','GG'].

So you must use the compare function that we give to do the sorting.

The order of the nuts or bolts does not matter. You just need to find the matching bolt for each nut.

Tags 
Quick Sort Sort
Related Problems 
Medium First Bad Version 35 %


 *
 *
 */
public class Nuts_Bolts_Problem {

	public static void main(String[] args) {
//		String[] nuts = {"dd","bc","ab","gg"};// 
//		String[] bolts = {"GG","AB", "DD", "BC"}; // 
//		String[] nuts = {"ab","bc","dd","gg"};// "ab","bc","dd","gg"
//		String[] bolts = {"AB","GG","DD","BC"}; // "AB","GG","DD","BC"
		String[] bolts = {"ab","bc","dd","gg"};// "ab","bc","dd","gg"
		String[] nuts = {"AB","GG","DD","BC"}; // "AB","GG","DD","BC"

		
		NBCompare compare = new NBCompare();
//		System.out.println(""+compare.cmp("dd", "AB"));
//		System.out.println(""+compare.cmp("BC", "bc"));
		sortNutsAndBolts(nuts, bolts, compare);

		System.out.println("nuts: "+Arrays.toString(nuts));
        System.out.println("bolts: "+Arrays.toString(bolts));

	}

    public  static  void sortNutsAndBolts(String[] nuts, String[] bolts, NBCompare compare) {
        // write your code here
        if (nuts == null || bolts == null) return;
        if (nuts.length != bolts.length) return;

        qsort(nuts, bolts, compare, 0, nuts.length - 1);
    }

    private  static  void qsort(String[] nuts, String[] bolts, NBCompare compare, 
                       int l, int u) {
        if (l >= u) return;
        // find the partition index for nuts with bolts[l]
        int part_inx = partition(nuts, bolts[l], compare, l, u);
//        System.out.println("nuts: "+Arrays.toString(nuts));
        // partition bolts with nuts[part_inx]
        System.out.println("bolts[l]:nuts[part_inx]"+bolts[l]+", "+nuts[part_inx]);
        partition(bolts, bolts[l], compare, l, u);
//        System.out.println("bolts: "+Arrays.toString(bolts));
        // qsort recursively
        qsort(nuts, bolts, compare, l, part_inx - 1);
        qsort(nuts, bolts, compare, part_inx + 1, u);
    }

    private  static  int partition11(String[] str, String pivot, NBCompare compare, 
                          int l, int u) {
          //
        int m = l;//m指向小于等于pivot的地方
        for (int i = l+1 ; i <= u; i++) {
            if (compare.cmp(str[i], pivot) == -1 || //str[i] 大写， pivot小写
                compare.cmp(pivot, str[i]) == 1) {
                //
                m++;
                swap(str, i, m);
            } else if (compare.cmp(str[i], pivot) == 0 || //二者，相等
                       compare.cmp(pivot, str[i]) == 0) {
                // swap nuts[l]/bolts[l] with pivot
                swap(str, i, l);
                i--;
            }
        }
        // move pivot to proper index
        swap(str, m, l);

        return m;
    }

    private  static  int partition(String[] str, String pivot, NBCompare compare, 
            int l, int u) {
		//
		int m = l;//m指向小于等于pivot的地方
		for (int i = l+1 ; i <= u; i++) {
		if (compare.cmp(str[i], pivot) == -1 || //str[i] 大写， pivot小写
		  compare.cmp(pivot, str[i]) == 1) {
		  //
		  m++;
		  swap(str, i, m);
		} else if (compare.cmp(str[i], pivot) == 0 || //二者，相等
		         compare.cmp(pivot, str[i]) == 0) {
		  // swap nuts[l]/bolts[l] with pivot
		  swap(str, i, l);
		  i--;
		}
		}
		// move pivot to proper index
		swap(str, m, l);
		
		return m;
	}

    private static void swap(String[] str, int l, int r) {
        String temp = str[l];
        str[l] = str[r];
        str[r] = temp;
    }
    
    static class NBCompare {
    	public int cmp(String a, String b){
    		return a.toUpperCase().compareTo(b.toUpperCase());
    	};
    }
    
}
