package JavaInterviewQueston;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Amazon_3Questions_Conkey {

//	remain the one which has duplicates element
	public static int removeDuplicates(List<Integer> numbers){
	      Set<Integer> set = new HashSet<Integer>();
	      Iterator<Integer> it = numbers.iterator();
	      while(it.hasNext()){
	          int cur = it.next();
	          if(set.contains(cur)){
	              it.remove();
	          }else{
	              set.add(cur);
	          }
	      }
	      return numbers.size();
	}
	
//	remove the one which has duplicate element
	public static int removeDuplicates2(List<Integer> numbers){
	      Set<Integer> set1 = new HashSet<Integer>();
	      Set<Integer> set2 = new HashSet<Integer>();
//	      List<Integer> set1 = new LinkedList<Integer>();
//	      List<Integer> set2 = new LinkedList<Integer>();

	      for(Integer key : numbers){
	    	  if(!set1.contains(key)){
	    		  set1.add(key);
	    	  }else{
	    		  set2.add(key);
	    	  }
	      }
	      System.out.println(set1);
	      System.out.println(set2);
	      Iterator<Integer> it = numbers.iterator();
	      while(it.hasNext()){
	          int cur = it.next();
	          if(set2.contains(cur)){
	              it.remove();
	          }
	      }

	      return numbers.size();
	}
	public static int removeDuplicates3(List<Integer> numbers){
	      Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
	      for(Integer key : numbers){
	    	  if(map.containsKey(key)){
	    		  map.put(key, true);
	    	  }else{
	    		  map.put(key, false);
	    	  }
	      }
	      System.out.println(map);
	      for(Integer key: map.keySet()){
//	    	  if(map.get(key) == true)
//	    	  numbers.r(key);.
	      }

	      return numbers.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer [] arr1 = new Integer[]{1, 1, 5, 3, 8, 3, 7, 32, 32};
		List<Integer> list1 = arrToList(arr1);
		System.out.println(list1);
		System.out.println(removeDuplicates(list1));
		System.out.println(list1);
		
		Integer [] arr2  = new Integer[]{21, 10, 24, 2, 21};
		List<Integer> list2 = arrToList(arr2);
		System.out.println(list2);
		System.out.println(removeDuplicates(list2));
		System.out.println(list2);
		System.out.println("--------------------------");

		list1 = arrToList(arr1);

		System.out.println(list1);
		System.out.println(removeDuplicates2(list1));
		System.out.println(list1);
		
		list2 = arrToList(arr2);

		System.out.println(list2);
		System.out.println(removeDuplicates2(list2));
		System.out.println(list2);
	}
	public static  <T>  List<T> arrToList(T[] arr){
		List<T> list = new ArrayList<T>();
		for(T t  : arr){
			list.add(t);
		}
		return list;
	}

}
