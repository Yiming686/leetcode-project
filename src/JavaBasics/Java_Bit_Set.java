package JavaBasics;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Java_Bit_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        String [] arr = { "32","4", "8", "202", "20", "23"};
        		System.out.println(""+Arrays.toString(arr));
        		Arrays.sort(arr);
        		System.out.println(""+Arrays.toString(arr));
                Arrays.sort(arr, new Comparator<String>(){
                	@Override
                	public int compare(String s1, String s2) {
                		return (s2 + s1).compareTo(s1 + s2);
                        // return (s1 + s2).compareTo(s2 + s1);
                	}
                });
        		System.out.println(""+Arrays.toString(arr));
        		System.out.println(""+null);
        		System.out.println(""+map.get(null));
		        int [] array = new int [] {1,2,3,22,0,3};
		        BitSet bitSet  = new BitSet();
		        System.out.println(bitSet.size());
		        //将数组内容组bitmap
		        for(int i=0;i<array.length;i++)
		        {
		            bitSet.set(array[i], true);
		        }
		       System.out.println(bitSet.size());
		        System.out.println(bitSet.get(3));
		        System.out.println(bitSet.get(1));
	}

}
