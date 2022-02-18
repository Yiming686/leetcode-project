package Lai.String;

public class Leet_541_Reverse_String_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdefg"; 				
		int k = 2;
		System.out.println(""+reverseStr(s, 2));
	}

    public static String reverseStr(String s, int k) {
        if(s == null || s.length() == 0){
            return s;
        }
        char[] arr = s.toCharArray();
        int len = s.length();
        int left = 0;
        int right = len - 1;
        while(left <= right){
            int charsLeft = right - left + 1;
            if( charsLeft < k){
                reverse(arr, left, right);
                left = right + 1;
            }else if(charsLeft >= k && charsLeft < 2 * k){
                reverse(arr, left, left + k - 1);
                left = right + 1;
            }else{
                reverse(arr, left, left + k - 1);
                left = left + 2 * k;
            }            
        } 
        return String.valueOf(arr);
    }
    
    private static void reverse(char[] arr, int left, int right){
        while(left < right){
            char ch = arr[left];
            arr[left] = arr[right];
            arr[right] = ch;
            left++;
            right--;
        }
    }
}
