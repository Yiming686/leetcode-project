package Lintcode.Array.Permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**

Permutations II

Given a list of numbers with duplicate number in it. Find all unique permutations.

Have you met this question in a real interview? Yes
Example
For numbers [1,2,2] the unique permutations are:

[
  [1,2,2],
  [2,1,2],
  [2,2,1]
]
Challenge
Using recursion to do it is acceptable. If you can do it without recursion, that would be great!

Tags Expand 
LinkedIn Recursion Depth First Search


Related Problems Expand 
Medium Next Permutation II 33 %
Medium Permutation Sequence 25 %
Medium Next Permutation 23 %
Medium Permutations
 *
 *
 *
 */
public class Permutations_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "aaacacabbcbcc";
		String str = "aaccbcdcf";
		System.out.println(""+stringPermutation2(str));
	}

	
    public static List<String> stringPermutation2(String str) {
        // Write your code here
        Set<String> set = new HashSet<String>();
        List<Character> list = new ArrayList<Character>();
        // String list ="";
        boolean[] visited = new boolean[str.length()];
        bfs(set, list, visited, str, 0);
        
        List<String> result = new ArrayList<String>();
        result.addAll(set);
        
        return result;
    }
    static void bfs(Set<String> set, List<Character> list, boolean[] visited, String str, int start){
        if(list.size() == str.length()){
            String s = "";
            for(Character ch : list){
                s+=ch;
            }
            set.add(s);
        }
        for(int i = start; i<str.length(); i++){
            char ch = str.charAt(i);
            if(visited[i] == false){
                visited[i] = true;
                list.add(ch);
                bfs(set, list, visited, str, start);    
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }

}
