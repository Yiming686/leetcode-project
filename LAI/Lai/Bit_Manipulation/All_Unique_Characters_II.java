package Lai.Bit_Manipulation;

import java.util.HashSet;
import java.util.Set;

public class All_Unique_Characters_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+'\u0174');
	}

	//time: O(N), space: O(1)
	  public static boolean allUnique(String word) {
	    //char[] chars = word.toCharArray();
	    int[] arr = new int[8];//32bits * 8 = 256bits， 8 行 32 列的矩阵。
	    // for(char ch : chars){
	    for(int i = 0; i < word.length(); i++){      
	      // 准确取出该为，若为1，已经存在了，返回false; 若为0，则赋值为1；
	      // 若不存在，当然也要赋值为1；
	      char ch = word.charAt(i);
	      int row = ch / 32;
	      int col = ch % 32;
	      if(( (arr[row] >>> col) & 1) != 0){  ; //如何取其中的一个bit，原值动了吗？？？// ch / 32 说明在那个0-7个整数里面，ch % 32 表明列数，
	        return false;
	      }else{
	        arr[row] |= (1 << col);//仅仅设置正确地bit，确保此位置为1
	      }      
	    }
	    return true;
	  }
	  
	  //time: O(N), space: O(N)
	  public static boolean allUnique00(String word) {
	    //Not null
	    Set<Character> set = new HashSet<Character>();
	    for(int i = 1; i < word.length(); i++){      
	      char ch = word.charAt(i);
	      if(set.contains(ch)){
	        return false;
	      }else{
	        set.add(ch);
	      }
	    }
	    return true;
	  }


}
