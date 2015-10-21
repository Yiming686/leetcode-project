package JavaInterviewQueston;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Samsung_Interview {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
//	    Collections.sort(input, new comparator<Employee>(){

	}
	
//	List<Employee> sortByAge(List<Employee> input){
//	    if(input == null) retun null;
//	    
//	    Collections.sort(input, new comparator<Employee>(){
//	    
//	        @Override
//	        public int compare(Employee e1, Employee e1){
//	        
//	            return e1.age - e2.age;
//	        
//	        }
//	    });
//	    
//	    return input;
//	}

	// --go to a binary tree and print it in order
	// --in an array of 100, one no is missing ¨C fastest way to find the number

	public static List<Integer> preorderTraversal(TreeNode root) {
		if (root == null)
			return null;
		List<Integer> list = new ArrayList<Integer>();
		preorderTraversal(list, root);
		return list;
	}

	private static void preorderTraversal(List<Integer> list, TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		list.add(root.val);
		preorderTraversal(list, root.left);
		preorderTraversal(list, root.right);String s = "d";
	}

	public static List<Integer> preorderTraversal2(TreeNode root) {
		if (root == null)
			return null;
		List<Integer> list = new ArrayList<Integer>();

		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if (node.left != null)
				stack.push(node.left);
			if (node.right != null)
				stack.push(node.right);
		}
		return list;
	}

	public static int findMissingNumber(int [] myArray) 
	{
	int sum1=0, sum2=0;
	 
	for(int i=1; i <= myArray.length + 1; i ++) {
	   sum1 += i;
	}
	 
	for(int j=0; j < myArray.length; j++)
	{
	    sum2+= myArray[j];
	}
	 
	return sum1 - sum2;
	}
	
	public static void main(String[] args) {
		List<Character> list2 = new ArrayList<Character>();
		list2.add('d');
		list2.add('e');
		list2.add('f');
		list2.add('h');
		
//		System.out.println(String.valueOf(list2.toArray(new Character[0])));
		
		
		System.out.println(permute("123"));
		System.out.println(permute("123").size());
		System.out.println();
		
//		int [] arr = { 25, -10, 5,-4};
		int [] arr = { -20, -5, -3 };
		int [] arr2 = {1,2,3,4,5,7,8,9,10};
		int m = findMissingNumber(arr2);
		System.out.println(m);
		ListNode list  = new ListNode(arr[0]);
		ListNode curr = list;
		for(int i = 1; i < arr.length; i++){
			ListNode node = new ListNode(arr[i]);
			curr.next = node;
			curr = curr.next;
		}
		curr = list;
		while(curr!=null){
			System.out.print(" " + curr.val);
			curr = curr.next;
		}
		System.out.println(" ==> Max is "+findMax(list));
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static int findMax(ListNode head) {
		if(head == null) throw new IllegalArgumentException("Head is null!");
		int max = head.val;
		ListNode next = head.next;
		while (next != null) {
//			# the two lines below work
			if (next.val > max)
				max = next.val;
//			# the one line below works
			max = Math.max(max, next.val);
//			# the one line below works
			max = (next.val > max) ? next.val : max;
			next = next.next;
		}
		return max;
	}
	
	public static List<String> permute2(String str){
	    if(str == null)  return null;
	    List<String> result= new ArrayList<String>();
	    if(str.length() == 0 )  {
	    	result.add("");
	    	return result;
	    }
	    char[] charArr = str.toCharArray();
//	    String str = "";
	    List<Character> list = new ArrayList<Character>();
	    helper(result, list, charArr, charArr.length);
	    return result;
	}

	public static void helper(List<String> result,  List<Character> list, char[] charArr, int len){
	    if(list.size() == len){
	        //convert a list of character to a string and add it to the final result
	        String s = "";
	        for(Character ch : list ){
	            s  += ch;
	        }
	        result.add(s); 
	        return;   
	    }
	    for(int i = 0; i < charArr.length; i ++ ){
	        if(list.contains(charArr[i])){
	            continue;
	        }
	        list.add(charArr[i]);
	        helper(result, list, charArr, len);
	        list.remove(list.size() -1);
	    }
	}

	public static List<String> permute(String str){
	    if(str == null)  return null;
	    List<String> result= new ArrayList<String>();
	    if(str.length() == 0 )  {
	    	result.add("");
	    	return result;
	    }
	    char[] charArr = str.toCharArray();
//	    String str = "";
	    List<Character> list = new ArrayList<Character>();
	    helper2(result, list, charArr, charArr.length, 0);
	    return result;
	}

	public static void helper2(List<String> result,  List<Character> list, char[] charArr, int len, int pos){
	    if(list.size() == len){
	        //convert a list of character to a string and add it to the final result
	        String s = "";
	        for(Character ch : list ){
	            s  += ch;
	        }
	        result.add(s); 
	        return;   
	    }
	    for(int i = 0; i < charArr.length; i ++ ){
	        if(i  !=  pos){
	            continue;
	        }
	        list.add(charArr[i]);
	        helper2(result, list, charArr, len, pos + 1);
	        list.remove(list.size() -1);
	    }
	}
	
}
