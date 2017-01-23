package Lintcode.String;

public class Reverse_Sentence {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentence =null;
		sentence ="This#is#a#book";
		System.out.println(""+reverse(sentence));
		sentence ="This";
		System.out.println(""+reverse(sentence));
		sentence ="a";
		System.out.println(""+reverse(sentence));
		sentence ="#This#is#a#book##";
		System.out.println(""+reverse(sentence));
		sentence ="#This##is###a####book######";
		System.out.println(""+reverse(sentence));
	}


//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String str =null;
//		str ="This is a book";
//		System.out.println(""+reverse(str));
//		str ="This";
//		System.out.println(""+reverse(str));
//		str ="a";
//		System.out.println(""+reverse(str));
//		str =" This is a book ";
//		System.out.println(""+reverse(str));
//		str =" This  is   a     book      ";
//		System.out.println(""+reverse(str));
//	}

	private static String reverse(String sentence) {
		// TODO Auto-generated method stub
		char[] arr = sentence.toCharArray();
		String str1 = new String(reverse(arr,0,arr.length-1));
		System.out.println("===:"+str1);
		char[] arr1 = str1.toCharArray();
		int curr = 0;
		while(curr < arr1.length ){
			while(curr < arr1.length && arr1[curr] == '#'){
//			while(curr < arr1.length && arr1[curr] == ' '){
				curr++;
			}
			int left = curr;
			while(curr < arr1.length && arr1[curr] != '#'){
//			while(curr < arr1.length && arr1[curr] != ' '){
				curr++;
			}
			int right = curr;
			if(left < arr1.length && right <= arr1.length)
				reverse(arr1,left, right-1);
			
		}
		return new String(arr1);
	}
	
	private static char[]  reverse(char[] arr, int left, int right) {
		// TODO Auto-generated method stub
		while(left < right){
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		return arr;
	}
	
}
