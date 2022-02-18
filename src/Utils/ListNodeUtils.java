package Utils;

import static Utils.TreeNodeUtils.toPrintNullNode;

//import Utils.ListNode;
//import Utils.ListNodeUtils.CycleList;

public class ListNodeUtils {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		print(buildOnlyCycle(5));
//		printCycle(buildOnlyCycle(5));
//		printList(buildLine(5));
		
	}
	public static class DoublyListNode<E>{
		public E val;
		public DoublyListNode<E> prev;
		public DoublyListNode<E> next;
		public DoublyListNode(E val){
			this.val = val;
		}
	}

	public static class ListNode<E>{
		public E val;
		public ListNode<E> next;
		public ListNode(E val){
			this.val = val;
		}
	}
	
	public static class CycleList<E> {
		public ListNode<E> headOfLine;
		public ListNode<E> headOfCycle;

		CycleList(ListNode<E> headOfLine, ListNode<E> headOfCycle) {
			this.headOfLine = headOfLine;
			this.headOfCycle = headOfCycle;
		}
	}


//	---Generate LinkedList Array---------------------------------------------------------------------------------------------------------------
	
	ListNode<Integer> generateList(int[] arr){
		if(arr == null || arr.length == 0) {
			return null;
		}
		ListNode<Integer> dummy = new ListNode<Integer>(-1);
		ListNode<Integer> node = dummy;
		for(int val: arr) {
			node.next = new ListNode<Integer>(val);
			node = node.next;
		}
		return dummy.next;
	}
	
	ListNode<Integer> generateList(Integer[] arr){
		if(arr == null || arr.length == 0) {
			return null;
		}
		ListNode<Integer> dummy = new ListNode<Integer>(-1);
		ListNode<Integer> node = dummy;
		for(int val: arr) {
			node.next = new ListNode<Integer>(val);
			node = node.next;
		}
		return dummy.next;
		
	}
	
	ListNode<Character> generateList(char[] arr){
		if(arr == null || arr.length == 0) {
			return null;
		}
		ListNode<Character> dummy = new ListNode<>('0');
		ListNode<Character> node = dummy;
		for(char val: arr) {
			node.next = new ListNode<Character>(val);
			node = node.next;
		}
		return dummy.next;
	}
	
	ListNode<Character> generateList(Character[] arr){
		if(arr == null || arr.length == 0) {
			return null;
		}
		ListNode<Character> dummy = new ListNode<>('0');
		ListNode<Character> node = dummy;
		for(char val: arr) {
			node.next = new ListNode<Character>(val);
			node = node.next;
		}
		return dummy.next;
	}
	


	public static CycleList<Integer> buildCycle(int n) {
		// TODO Auto-generated method stub
		return buildCycleList(0, n);
	}

	public static CycleList<Integer> buildCycleList(int m, int n) {
		// TODO Auto-generated method stub
		if (m <= 0) {
			return new CycleList<>(null, buildOnlyCycle(n));
		}
		int last = -1;
		int first = last - m + 1;
		ListNode<Integer> head = new ListNode<>(first++);
		ListNode<Integer> curr = head;
		while (--m > 0) {
			curr.next = new ListNode<>(first++);
			curr = curr.next;
		}
		// curr points to last node
		curr.next = buildOnlyCycle(n);
		return new CycleList<>(head, curr.next);
	}

	//建立Linked List，包含n个node，从0 到 n-1 结束，入口是0节点
	private static ListNode<Integer> buildOnlyCycle(int n) {
		// TODO Auto-generated method stubn-1
		if (n < 2) {
			return null;
		}
		int first = 0;
		int last = first + n - 1;
		ListNode<Integer> head = new ListNode<>(first++);
		ListNode<Integer> curr = head;
		while (--n > 0) {
			curr.next = new ListNode<>(first++);
			curr = curr.next;
		}
		curr.next = head;
		return head;
	}

//建立Linked List，包含m个node，从-m 到 -1 结束，-1点将会指向环的入口0节点
	public static ListNode<Integer> buildLine(int m) {
		// TODO Auto-generated method stub
		if (m < 1) {
			return null;
		}
		Integer last = -1;
		Integer first = last - m + 1;
		ListNode<Integer> head = new ListNode<>(first++);
		ListNode<Integer> curr = head;
		while (--m > 0) {
			curr.next = new ListNode<>(first++);
			curr = curr.next;
		}
		return head;
	}

	/**
	 * @param start
	 * @param end
	 * @return
	 */
	//建立从 start 到 end 的 Linked List
	public static ListNode<Integer> buildLinkedList(int start, int end) {
		// asending order
		int m = end - start + 1;
		if (m < 1) {
			return null;
		}
		ListNode<Integer> head = new ListNode<>(start++);
		ListNode<Integer> curr = head;
		while (start <= end) {
			curr.next = new ListNode<>(start++);
			curr = curr.next;
		}
		return head;
	}

//	打印 Linked List，默认只打印 前面 50个 节点
	public static<E> String printList(ListNode<E> head) {
		return printList(head, 50);
	}
	
//	打印 Linked List，只打印 maxLimit 个节点
	public static<E> String printList(ListNode<E> head, int maxLimit) {
		StringBuilder sb = new StringBuilder("List: ");
		if(head == null) sb.append("null");
		int count = 0;
		String delimeter = "";
		while (head != null) {
			sb.append(delimeter);
			sb.append(head.val);
			delimeter = ",";
			head = head.next;
			count++;
			if(count == maxLimit) {
				sb.insert(0, "[First " + maxLimit + " Elements] ");
				break;
			} 
		}
		System.out.println(sb);
		return sb.toString();
	}

//	打印 Linked List，默认只打印 前面 50个 节点
	public static<E> String printList(DoublyListNode<E> head) {
		return "Left2Right : " + printListLeft2Right(head, 50) +
		"Right2Left: " + printListRight2Left(toTail(head), 50);
	}
	public static<E>  DoublyListNode toHead(DoublyListNode<E> head) {
		while(head.prev != null) {
			head = head.prev;
		}
		return head;
	}
	public static<E>  DoublyListNode toTail(DoublyListNode<E> head) {
		while(head.next != null) {
			head = head.next;
		}
		return head;
	}
	
//	打印 Linked List，只打印 maxLimit 个节点
	public static<E> String printListLeft2Right(DoublyListNode<E> head, int maxLimit) {
		StringBuilder sb = new StringBuilder("List: ");
		if(head == null) sb.append("null");
		int count = 0;
		String delimeter = "";
		while (head != null) {
			sb.append(delimeter);
			sb.append(head.val);
			delimeter = ",";
			head = head.next;
			count++;
			if(count == maxLimit) {
				sb.insert(0, "[First " + maxLimit + " Elements] ");
				break;
			} 
		}
		System.out.println("Left2Right: " +sb);
		return sb.toString();
	}
	public static<E> String printListRight2Left(DoublyListNode<E> head, int maxLimit) {
		StringBuilder sb = new StringBuilder("List: ");
		if(head == null) sb.append("null");
		int count = 0;
		String delimeter = "";
		while (head != null) {
			sb.append(delimeter);
			sb.append(head.val);
			delimeter = ",";
			head = head.prev;
			count++;
			if(count == maxLimit) {
				sb.insert(0, "[First " + maxLimit + " Elements] ");
				break;
			} 
		}
		System.out.println("Right2Left: " + sb);
		return sb.toString();
	}

	//	public static String printCycle(ListNode head) {
//		StringBuilder sb = new StringBuilder("List: ");
//		sb.append(head.val + ", ");
//		ListNode curr = head.next;
//		while (curr != null && curr != head) {
//			sb.append(curr.val + ", ");
//			curr = curr.next;
//		}
//		System.out.println(sb);
//		return sb.toString();
//	}

	public static<E> String printList(CycleList<E> cycleList) {
		// TODO Auto-generated method stub
		ListNode<E> headOfLine = cycleList.headOfLine;
		ListNode<E> headOfCycle = cycleList.headOfCycle;
		StringBuilder sb = new StringBuilder("Cycle List: ");
		if (headOfLine != null) {
			ListNode<E> curr = headOfLine;
			// sb.append(curr.val + ", ");
			while (curr != headOfCycle) {
				sb.append(curr.val + ", ");
				curr = curr.next;
			}
		}
		if (headOfCycle != null) {
			ListNode<E> curr = headOfCycle;
			sb.append("[ ");
			do {
				sb.append(curr.val + ", ");
				curr = curr.next;
			} while (curr != headOfCycle);
			sb.append("] ");
		}
		System.out.println(sb);
		return sb.toString();
	}


	public static <E> boolean hasCycle(ListNode<E> head) {
		// TODO Auto-generated method stub
		if (head == null || head.next == null) {
			return false;
		}
		ListNode<E> slow = head;
		ListNode<E> fast = head;
		while (fast.next != null && fast.next.next != null) {
//		while (fast != null && fast.next != null) {			
			System.out.printf("slow:fast %d:%d ", slow.val, fast.val);
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		System.out.println();
		return false;
	}
	public static<E> ListNode<E> buildLinkedList(E[] arr) {
		if (arr == null || arr.length < 1) {
			return null;
		}
		int i = 0;
		ListNode<E> head = new ListNode<E>(arr[i++]);
		ListNode<E> curr = head;
		while (i < arr.length) {
			curr.next = new ListNode<E>(arr[i++]);
			curr = curr.next;
		}
		return head;
	}

	public static<E> DoublyListNode<E> buildDoulbyLinkedList(E[] arr) {
		if (arr == null || arr.length < 1) {
			return null;
		}
		int i = 0;
		DoublyListNode<E> head = new DoublyListNode<E>(arr[i++]);
		DoublyListNode<E> curr = head;
		while (i < arr.length) {
			curr.next = new DoublyListNode<E>(arr[i++]);
			curr.next.prev = curr;
			curr = curr.next;
		}
		return head;
	}
	public static DoublyListNode<Integer> buildIntegerDoublyLinkedList(int[] arr) {
		return buildDoulbyLinkedList(ArrayUtils.convertIntArr2IntegerArr(arr));
	}
	
	public static ListNode<Integer> buildIntegerLinkedList(int[] arr) {
		return buildLinkedList(ArrayUtils.convertIntArr2IntegerArr(arr));
	}
	
	public static ListNode<Integer> buildIntegerLinkedList(int val) {
		return buildIntegerLinkedList(String.valueOf(val));
	}
	public static ListNode<Integer> buildIntegerLinkedList(String val) {
		val = val.trim();
		if(val.startsWith("{") || val.startsWith("[") ||val.startsWith("(")) {
			val = val.substring(1).trim();
		}
		if(val.endsWith("}") || val.endsWith("]") ||val.endsWith(")")) {
			val = val.substring(0, val.length()-1).trim();
		}
		if(val.contains(",")) {
			String[] arr = val.split(",");
			ListNode<Integer> head = new ListNode<>(Integer.valueOf(arr[0].trim()));
			ListNode<Integer> curr = head;
			for(int i = 1; i < arr.length; i++) {
				curr.next = new ListNode<>(Integer.valueOf(arr[i].trim()));
				curr = curr.next;
			}
			return head;
		}else {
			return buildLinkedList(ArrayUtils.convertCharArr2IntegerArr(val.toCharArray()));
		}
	}

	public static ListNode<Integer> buildIntegerLinkedList(int size, int min, int max) {
		return buildLinkedList(ArrayUtils.buildIntegerArray( size,  min,  max));
	}

	public static ListNode<Integer> buildIntegerLinkedList(int size, int min, int max,boolean toPrint) {
		return buildLinkedList(ArrayUtils.buildIntegerArray( size,  min,  max, toPrint));
	}

	public static ListNode<Integer> buildIntegerLinkedListNoDup(int size, int min, int max) {
		return buildLinkedList(ArrayUtils.buildIntegerArrayNoDup( size,  min,  max));
	}
	public static ListNode<Integer> buildIntegerLinkedListNoDup(int size, int min, int max,boolean toPrint) {
		return buildLinkedList(ArrayUtils.buildIntegerArrayNoDup( size,  min,  max, toPrint));
	}

	public static ListNode<Integer> buildIntegerLinkedListWithDup(int size, int min, int max) {
		return buildLinkedList(ArrayUtils.buildIntegerArrayWithDup( size,  min,  max));
	}
	public static ListNode<Integer> buildIntegerLinkedListWithDup(int size, int min, int max,boolean toPrint) {
		return buildLinkedList(ArrayUtils.buildIntegerArrayWithDup( size,  min,  max, toPrint));
	}

	public static ListNode<Integer> buildIntegerLinkedListAllDup(int size, int val) {
		return buildLinkedList(ArrayUtils.buildIntegerArrayAllDup( size, val));
	}
	public static ListNode<Integer> buildIntegerLinkedListAllDup(int size, int val,boolean toPrint) {
		return buildLinkedList(ArrayUtils.buildIntegerArrayAllDup( size, val, toPrint));
	}

	public static ListNode<Integer> buildIntegerLinkedListNoDupSorted(int size, int min, int max) {
		return buildLinkedList(ArrayUtils.buildIntegerArrayNoDupSorted( size,  min,  max));
	}

	public static ListNode<Integer> buildIntegerLinkedListWithDupSorted(int size, int min, int max) {
		return buildLinkedList(ArrayUtils.buildIntegerArrayWithDupSorted( size,  min,  max));
	}


	public static ListNode<Character> buildCharacterLinkedList(String val) {
		// TODO Auto-generated method stub
		val = val.trim();
		if(val.startsWith("{") || val.startsWith("[") ||val.startsWith("(")) {
			val = val.substring(1).trim();
		}
		if(val.endsWith("}") || val.endsWith("]") ||val.endsWith(")")) {
			val = val.substring(0, val.length()-1).trim();
		}
		if(val.contains(",")) {
			String[] arr = val.split(",");
			if(arr[0].trim().length() != 1) {
				System.out.println("Warning: Not a char sequence! " + arr[0].trim() );
			}
			ListNode<Character> head = new ListNode<>(arr[0].trim().toCharArray()[0]);
			ListNode<Character> curr = head;
			for(int i = 1; i < arr.length; i++) {
				if(arr[i].trim().length() == 1) {
					curr.next = new ListNode<>(arr[i].trim().toCharArray()[0]);
					curr = curr.next;
				}else {
					System.out.println("Warning: Not a char sequence!"  + arr[i].trim());
				}
			}
			return head;
		}else {
//			return buildLinkedList(ArrayUtils.convertCharArr2IntegerArr(val.toCharArray()));
			return buildLinkedList(ArrayUtils.convertCharArr2CharacterArr(val.toCharArray()));
		}
	}

	public static ListNode<Character> buildCharacterLinkedList(int size, char min, char max) {
		return buildLinkedList(ArrayUtils.buildCharacterArray( size,  min,  max));
	}

	public static ListNode<Character> buildCharacterLinkedList(int size, char min, char max,boolean toPrint) {
		return buildLinkedList(ArrayUtils.buildCharacterArray( size,  min,  max, toPrint));
	}

	public static ListNode<Character> buildCharacterLinkedListNoDup(int size, char min, char max) {
		return buildLinkedList(ArrayUtils.buildCharacterArrayNoDup( size,  min,  max));
	}
	public static ListNode<Character> buildCharacterLinkedListNoDup(int size, char min, char max,boolean toPrint) {
		return buildLinkedList(ArrayUtils.buildCharacterArrayNoDup( size,  min,  max, toPrint));
	}

	public static ListNode<Character> buildCharacterLinkedListWithDup(int size, char min, char max) {
		return buildLinkedList(ArrayUtils.buildCharacterArrayWithDup( size,  min,  max));
	}
	public static ListNode<Character> buildCharacterLinkedListWithDup(int size, char min, char max,boolean toPrint) {
		return buildLinkedList(ArrayUtils.buildCharacterArrayWithDup( size,  min,  max, toPrint));
	}

	public static ListNode<Character> buildCharacterLinkedListAllDup(int size, char val) {
		return buildLinkedList(ArrayUtils.buildCharacterArrayAllDup( size, val));
	}
	public static ListNode<Character> buildCharacterLinkedListAllDup(int size, char val,boolean toPrint) {
		return buildLinkedList(ArrayUtils.buildCharacterArrayAllDup( size, val, toPrint));
	}

	public static ListNode<Character> buildCharacterLinkedListNoDupSorted(int size, char min, char max) {
		return buildLinkedList(ArrayUtils.buildCharacterArrayNoDupSorted( size,  min,  max));
	}

	public static ListNode<Character> buildCharacterLinkedListWithDupSorted(int size, char min, char max) {
		return buildLinkedList(ArrayUtils.buildCharacterArrayWithDupSorted( size,  min,  max));
	}


//	返回Linked List 中点，奇数取最中间，偶数 取中间偏右侧的。
	public static<E> ListNode<E> findMiddle(ListNode<E> head) {
		// TODO Auto-generated method stub
		// 12345,
		// 13579,
		if (head == null || head.next == null) {
			return head;
		}
		ListNode<E> slow = head;
		ListNode<E> fast = head;
		while (fast.next != null && fast.next.next != null) {//必须关注fast，而不是slow，站在fast向右看，至少有两个点，fast和slow才同时跳;否则 不跳，并返回slow。
//		while (fast != null && fast.next != null) {			
//			System.out.printf("slow:fast %d:%d ", slow.val, fast.val);
			slow = slow.next;
			fast = fast.next.next;
		}
//		System.out.println();
		return slow;

	}

//	返回Linked List 中点，奇数取最中间，偶数 取中间偏右侧的。
	public static <E> ListNode<E> reverse(ListNode<E> head) {
		ListNode<E> prev = null;
		while (head != null) {
			ListNode<E> next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

}
