package JavaInterviewQueston;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 Take a second to imagine that you are in a room with 100 chairs arranged in a circle. 
 These chairs are numbered sequentially from One to One Hundred.
At some point in time, the person in chair #1 will be told to leave the room. 
The person in chair #2 will be skipped, and the person in chair #3 will be told to leave. 
Next to go is person in chair #6. In other words, 1 person will be skipped initially, 
and then 2, 3, 4.. and so on. This pattern of skipping will keep going around 
the circle until there is only one person remaining.. the survivor. 
Note that the chair is removed when the person leaves the room.
 */

public class OneHundredPersonCircle {
	
	public static int oneHundredPersonCircle3(LinkedList<Integer> list){
		int curr = -1;
		int interval = 1;
		while(list.size()>1){
//			System.out.println(list);

//			interval = 2;
			for(int i= 1; i <= interval; i ++){
				curr ++;				
			}
			curr = curr % list.size();
			System.out.println(list.get(curr));
			list.remove(curr);
			curr--;
			interval ++;
		}
		return list.get(0);
	}
	
//	public static int oneHundredPersonCircle(LinkedList<Integer> list){
//		int curr = 0;
//		int interval = 2;
//		while(list.size()>1){
//			list.remove(curr);
//			for(int i= 1; i <= interval; i ++){
//				curr ++;				
//			}
//			curr--;
//			curr = curr % list.size();
//			interval ++;
//		}
//		return list.get(0);
//	}
	
	public static int oneHundredPersonCircle(LinkedList<Integer> list){
//		initial counter variables
		int curr = 0;
		int interval = 2;
		while(list.size()>1){
//			remove current value
			System.out.println(list);
			System.out.println(list.get(curr));
			list.remove(curr);
//			get next current index;
			for(int i= 1; i <= interval; i ++){
				curr ++;				
			}
			curr--;
			curr = curr % list.size();
//			change counter variables
			interval ++;
		}
		return list.get(0);
	}
	
	public static int OneHundredPersonCircle2(LinkedList<Integer> list){
		
//		int prev = 0;
		int curr = -1;
		int interval = 1;
//		Integer currInt = list.get(0);
		do{
//			System.out.println(list);

//			get index;
			for(int i= 1; i <= interval; i ++){
				curr ++;				
			}
			curr = curr % list.size();
//			remove the value;
			interval ++;
			System.out.println(list.get(curr));
			list.remove(curr);
			curr--;
//			prev = curr;
		}while(list.size()>1);
		
		return list.get(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 100;
//		int[] arr = new int[num];
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 1; i <= num; i ++){ 
			list.add(i);
		}
//		for(int i = 1; i <= num; i ++){ 
//			System.out.println(list);
//			list.remove(0);
//		}
//		System.out.println();
//				System.out.println();
//				System.out.println();
				System.out.println("----------------------");

		System.out.println(oneHundredPersonCircle3(list));
		
	}

}
