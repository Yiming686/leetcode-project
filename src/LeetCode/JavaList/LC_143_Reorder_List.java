package LeetCode.JavaList;

import java.util.HashMap;
import java.util.Map;

public class LC_143_Reorder_List {

	
	
//	Accepted, work but complecated
   public void reorderList(ListNode head) {
        if(head == null|| head.next == null || head.next.next == null) return ;
     
        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        int index = 0;
        while(head!=null){
            map.put(index, head);
            index++;
            head = head.next;
        }
        // int size = index;
        int start = 0;
        int end = index -1; 
        while(start + 1 < end){
            // ListNode node = map.get(start); 
            if(end - start < 3) break ;
            map.get(start).next = map.get(end);
            map.get(end).next = map.get(start+1);
            start ++;
            end --;
        }
        map.get(start).next = map.get(end);
        if(start+1==end){
            map.get(end).next = null;
        }else{
            map.get(end).next = map.get(start+1);
            map.get(start+1).next = null;
        }
        return ;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
