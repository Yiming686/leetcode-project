package JavaInterviewQueston;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

public class Yahoo_Find_Number_With_Max_Occurances {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,5,8,7,9,8,9,3,5,7,9,8,3,5,6,8,9};
		System.out.println(""+findNumberWithMaxOccurances(arr));
	}
	static int findNumberWithMaxOccurances(int[] arr){
		List<Integer>  list = new ArrayList<Integer>();
		int max = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr.length; i++){
			int key = arr[i];
			if(!map.containsKey(key)){
				map.put(key, 1);
			}else{
				int newVal = map.get(key) + 1;
				map.put(key,  newVal);
				if(newVal > max){
					max = newVal;
					list.clear();//经典考点在此
					list.add(key);
				}else if(newVal == max){
					list.add(key);
				}
			}
		}
		System.out.println(""+map);
		System.out.println(""+list);
		return max;
	}

}
