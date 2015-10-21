package LeetCode.JavaList;

public class LC_000_Length_Of_List_Loop {

	public int getLengthOfListLoop_WithSubMethod(ListNode list){
//		 处理初始值，避免给two赋值时，报异常
//		尽量不要设定为同一起点
		if(list == null || list.next == null) return 0;
		ListNode one = list;
		ListNode two = list.next.next;
//		循环的退出条件，由two来界定，尤其小心避免nullpointer异常
		while(two!=null&&two.next!= null){
//循环内的逻辑，一般进行判断逻辑，然后调整循环变量的值，一般情况，这个次序不能变
			 if(one == two){
				 return getListLength(one);
			 }
			 one = one.next;
			 two = two.next.next;
		}
		return 0;
	}

	private int getListLength(ListNode one) {
		int len = 0;
		len++;
		ListNode curr = one.next;
		while(curr != one){
			 len++;
			 curr = curr.next;
		}
		return len;
	}
	
	public int getLengthOfListLoop(ListNode list){
//		 处理初始值，避免给two赋值时，报异常
//		尽量不要设定为同一起点
		if(list == null || list.next == null) return 0;
		ListNode one = list;
		ListNode two = list.next.next;
		int len = 0;
//		循环的退出条件，由two来界定，尤其小心避免nullpointer异常
		while(two!=null&&two.next!= null){
//循环内的逻辑，一般进行判断逻辑，然后调整循环变量的值，一般情况，这个次序不能变
			 if(one == two){
				 len++;
				 one = one.next;
				 while(one != two){
					 len++;
					 one = one.next;
				 }
				 return len;
			 }
			 
			 one = one.next;
			 two = two.next.next;
		}
		
		return len;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
