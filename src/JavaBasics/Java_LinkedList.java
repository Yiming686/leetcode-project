package JavaBasics;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Java_LinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] intArr = {5,2,6,7,2,3,7,4,2};
		LinkedList<Integer> intList = new LinkedList<Integer>();
		for(int i : intArr){
			intList.add(i);
//			intList.remove(new Integer(i));
		}
		System.out.println(""+intList);
		intList.remove(3);
		System.out.println(""+intList);
		intList.remove(new Integer(3));
		System.out.println(""+intList);
		intList.remove(new Integer(2));
		System.out.println(""+intList);

		System.out.println("========");
		
    	List<List<Integer>> ll = new LinkedList<List<Integer>>();
		ll.add(intList);
		LinkedList<Integer> intList2 = new LinkedList<Integer>();
		intList2.addAll(intList);
		intList = intList2;
		
		intList.removeLast();
    	System.out.println(intList);
    	
		boolean isDebug = false;
		if(isDebug){
		int[] intArr2 = {5,2,6,7,2,3,7,4,2};
		intList = new LinkedList<Integer>();
		for(int i : intArr){
			intList.add(i);
		}
		System.out.println(intList);
		System.out.println(intList.indexOf(7));
		System.out.println(intList.indexOf(11));
		System.out.println("The First£º" + intList.getFirst());
		System.out.println("The Last £º" + intList.getLast());
		intList.add(8);
		intList.addFirst(22);
		intList.addLast(22);
		System.out.println(intList);
		System.out.println("The First£º" + intList.getFirst());
		System.out.println("The Last £º" + intList.getLast());
		}
	}

}
