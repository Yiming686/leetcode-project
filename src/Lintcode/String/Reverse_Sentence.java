package Lintcode.String;

public class Reverse_Sentence {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentence =null;
//		sentence ="This#is#a#book";
//		System.out.println("||"+reverse2(sentence)+"||");
//		sentence ="This";
//		System.out.println("||"+reverse2(sentence)+"||");
//		sentence ="  gty";
//		System.out.println("||"+reverse2(sentence)+"||");
//		sentence ="seed   ";
//		sentence ="d   ";
//		sentence ="    ";
//		sentence =" This  is   a    book!     ";
//		System.out.println("||"+reverse2(sentence)+"||");
//		sentence ="#This#is#a#book##";
//		System.out.println("||"+reverse2(sentence)+"||");
//		sentence ="#This##is###a####book######";
//		System.out.println("||"+reverse2(sentence)+"||");
		System.out.println("||"+reverseWords14(" this  is   a    book!  ")+"||");
	}
	public static String reverseWords14(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] array = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = array.length - 1; i > 0; --i){
            sb.append(array[i]).append(" ");
        }
        sb.append(array[0]);
        return sb.toString();
    }

	private static String reverse2(String sentence) {
		if(sentence == null || sentence.length() < 2){
			return sentence;
		}
		char[] arr = sentence.toCharArray();
		reverse(arr, 0, arr.length - 1);
		int curr = 0;
		int len = arr.length;//至少有两个
		while(curr < len){
			while(curr < len && arr[curr] == ' '){
				curr++;//只要是空字符，跳过
			}
			int left = curr;//!= ' ' or ==len，不空字符或者len
			while(curr < len && arr[curr] != ' '){
				curr++;//只要是不空字符，跳过
			}
			int right = curr - 1;//== ' ' or ==len,空字符或者len
			System.out.println(""+ String.valueOf(arr));
			System.out.println("left:right "+left+","+right);
			if(left < right){
				reverse(arr, left, right);
			}
		}
		return String.valueOf(arr);
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
		reverse(arr,0,arr.length-1);
		String str1 = String.valueOf(arr);
		System.out.println("===||"+str1+"||");
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
		return String.valueOf(arr1);
	}
	
	private static void  reverse(char[] arr, int left, int right) {
		// TODO Auto-generated method stub
		while(left < right){
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	
}
