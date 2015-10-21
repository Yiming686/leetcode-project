package LeetCode.JavaList;

public class LC_000_Length_Of_List_Loop {

	public int getLengthOfListLoop_WithSubMethod(ListNode list){
//		 �����ʼֵ�������two��ֵʱ�����쳣
//		������Ҫ�趨Ϊͬһ���
		if(list == null || list.next == null) return 0;
		ListNode one = list;
		ListNode two = list.next.next;
//		ѭ�����˳���������two���綨������С�ı���nullpointer�쳣
		while(two!=null&&two.next!= null){
//ѭ���ڵ��߼���һ������ж��߼���Ȼ�����ѭ��������ֵ��һ���������������ܱ�
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
//		 �����ʼֵ�������two��ֵʱ�����쳣
//		������Ҫ�趨Ϊͬһ���
		if(list == null || list.next == null) return 0;
		ListNode one = list;
		ListNode two = list.next.next;
		int len = 0;
//		ѭ�����˳���������two���綨������С�ı���nullpointer�쳣
		while(two!=null&&two.next!= null){
//ѭ���ڵ��߼���һ������ж��߼���Ȼ�����ѭ��������ֵ��һ���������������ܱ�
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
