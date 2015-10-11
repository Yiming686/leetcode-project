package JavaInterviewQueston;

class ListNode{
	int val;
	ListNode next;
	public ListNode(){
		
	}
	public ListNode(int val){
		this.val = val;
	}
	public ListNode(int val, ListNode next){
		this.val = val;
		this.next = next;
	}
}

class SingleLinkedListWithTwoPointers {
	ListNode header;
	ListNode last;
	int size;
	public void addElement(int val){
		ListNode node = new ListNode(val);
		if(header == null){
			header = node;
			last = node;
		}else{
			last.next = node;
			last = last.next;
		}
		size++;
	}
//	remove the first one
	public void removeElement(int val){
		ListNode curr = header;
		while(curr.next!= null && curr.next.val != val){
//			return;
			curr = curr.next;
		}
		if(curr.next == null) return; 
		if(curr.next.val == val) {
			ListNode temp = curr.next;
			curr = temp.next;
			temp.next = null;
		}
	}
}

public class SingleLinkedList {
	ListNode header;
	int size;
	public void addElement(int val){
		ListNode node = new ListNode(val);
		ListNode last = header;
		if(last == null) last = node;
		while(last!=null){
			last = last.next;
		}
		if(last == null){
			header = node;
			last = node;
		}else{
			last.next = node;
			last = last.next;
		}
		size++;
	}
//	remove the first one
	public void removeElement(int val){
		ListNode curr = header;
		while(curr.next!= null && curr.next.val != val){
//			return;
			curr = curr.next;
		}
		if(curr.next == null) return; 
		if(curr.next.val == val) {
			ListNode temp = curr.next;
			curr = temp.next;
			temp.next = null;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
