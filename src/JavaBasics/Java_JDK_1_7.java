package JavaBasics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Java_JDK_1_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val = 22_212_32_23;
		System.out.println(""+val);
		List<Integer> list = Arrays.asList(4,2,6,2,7);
		Stream<Integer> stm = list.parallelStream();
		
		System.out.println(""+list.parallelStream());
		
	}

}
