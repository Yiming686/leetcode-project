package JavaBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Java_JDK_1_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.forEach(System.out::println);
		list = Arrays.asList(59,2,66,3,77,32);
//		list.stream();
        list.sort((e1,e2)->e2-e1);
        list.sort((e1,e2)->e1-e2);
        System.out.println(""+list);
        Objects.requireNonNull(list);
	}
	
}
