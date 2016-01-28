package JavaInterviewQueston;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.stream.events.EndDocument;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.InterningXmlVisitor;

import Lintcode.Matrix.Matrix;

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

//		Integer [] arr1 = new Integer[]{1, 1, 5, 3, 8, 3, 7, 32, 32};
//		List<Integer> list1 = arrToList(arr1);
//		System.out.println(list1);
//		System.out.println(removeDuplicates(list1));
//		System.out.println(list1);
//		
//		Integer [] arr2  = new Integer[]{21, 10, 24, 2, 21};
//		List<Integer> list2 = arrToList(arr2);
//		System.out.println(list2);
//		System.out.println(removeDuplicates(list2));
//		System.out.println(list2);
//		System.out.println("--------------------------");
//
//		list1 = arrToList(arr1);
//
//		System.out.println(list1);
//		System.out.println(removeDuplicates2(list1));
//		System.out.println(list1);
//		
//		list2 = arrToList(arr2);
//
//		System.out.println(list2);
//		System.out.println(removeDuplicates2(list2));
//		System.out.println(list2);
		int[][] arr = new int[4][5];
		arr[0] = new int[]{0,0,1,0,1};
		arr[1] = new int[]{0,0,0,0,0};
		arr[2] = new int[]{0,1,1,1,0};
		arr[3] = new int[]{0,1,1,0,0};
		System.out.println(""+Matrix.fromMatrixToString(arr));;
		int startX = 3;
		int startY = 0;
		int endX = 3;
		int endY = 1;
		System.out.println(""+find(arr,  startX,  startY,  endX,  endY));
		System.out.println(""+Matrix.fromMatrixToString(arr));;
	}
	public static  <T>  List<T> arrToList(T[] arr){
		List<T> list = new ArrayList<T>();
		for(T t  : arr){
			list.add(t);
		}
		return list;
	}
	class Point{
		int x;
		int y;
	}
	public static boolean find(int[][]arr, Point start, Point end){
		
		return false;
	}
	public static boolean find(int[][]arr, int startX, int startY, int endX, int endY){
		if(startX<0 || startX >= arr.length || startY<0 || startY >= arr[0].length )return false;
		if(startX == startY && startX == startY) return true;
		if(arr[startX][startY] == 1 || arr[endX][endY] == 1) return false;	
		
		arr[startX][startY] = 1;
		boolean result = 	find(arr, startX + 1, startY,     endX, endY) || 
							find(arr, startX,     startY + 1, endX, endY) ||
							find(arr, startX - 1, startY, 	  endX, endY) ||
							find(arr, startX,     startY + 1, endX, endY);
		arr[startX][startY] = 0;
		return result;
	}

	
	

}
