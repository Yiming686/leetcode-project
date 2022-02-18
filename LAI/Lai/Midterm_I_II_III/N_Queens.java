package Lai.Midterm_I_II_III;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(""+nqueens(5));
	}

	public static List<List<Integer>> nqueens(int n){
		//Assumption: n >= 1
		  List<List<Integer>> result = new ArrayList<>();
		  List<Integer> curr = new ArrayList<>();
		  helper(result, curr, n);
		  return result;
		}

		private static void helper(List<List<Integer>> result, List<Integer> curr, int n){
		  if(curr.size() == n){
		    result.add(new ArrayList<Integer>(curr));
		    return;
		  }
		  for(int i = 0; i < n; i++){
		    if(isValid(curr, i)){
		      curr.add(i);
		      helper(result, curr, n);
		      curr.remove(curr.size() - 1);
		    }
		  }  
		}

		private static boolean isValid(List<Integer> curr, int cols){
		  int rows = curr.size();
		  for(int i = 0; i < rows; i++){
		    if(curr.get(i) == cols || Math.abs(curr.get(i) - cols) == rows - i){
		      return false;
		    }
		  }
		  return true;
		}


}
