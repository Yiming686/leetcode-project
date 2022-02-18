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
	    int[] arr = new int[8];//32bits * 8 = 256bits�� 8 �� 32 �еľ���
	    // for(char ch : chars){
	    for(int i = 0; i < word.length(); i++){      
	      // ׼ȷȡ����Ϊ����Ϊ1���Ѿ������ˣ�����false; ��Ϊ0����ֵΪ1��
	      // �������ڣ���ȻҲҪ��ֵΪ1��
	      char ch = word.charAt(i);
	      int row = ch / 32;
	      int col = ch % 32;
	      if(( (arr[row] >>> col) & 1) != 0){  ; //���ȡ���е�һ��bit��ԭֵ�����𣿣���// ch / 32 ˵�����Ǹ�0-7���������棬ch % 32 ����������
	        return false;
	      }else{
	        arr[row] |= (1 << col);//����������ȷ��bit��ȷ����λ��Ϊ1
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
