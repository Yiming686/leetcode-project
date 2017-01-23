package Lintcode.String;

public class Reverse_Words_in_a_String {

	static char SPACE = ' '; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = " the   sky     is  blue            ";
		String s = "__the___sky____is_blue______";

//		 s = "              ";
		s = "_How__are___you?____";
		s = " How  are   you?    ";
//		s = "__You";
		System.out.println(""+s);
		System.out.println(""+reverseWords12(s));
		
	}

//	worked
    public static String reverseWords(String s) {
        // write your code
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        char[] arr = s.toCharArray();
        int left = 0;
        int right = len - 1;
        reverseCharArray(arr, left, right);
        System.out.println(""+String.valueOf(arr));
        left = 0;
        right = 0;
        for(int i = 1; i < len; i++){
            if(i==1 && arr[i-1] != SPACE){
                left = i-1;
            }else if(arr[i] != SPACE && arr[i-1] == SPACE){
                left = i;
            }else if(arr[i] == SPACE && arr[i-1] != SPACE){
                right = i-1;
                reverseCharArray(arr, left, right);
            }else if( i==len-1 && arr[i]!=SPACE){
                right = i;
                reverseCharArray(arr, left, right);
            }
        }
        return String.valueOf(arr);
    }  
    
    static void reverseCharArray(char[] arr, int left, int right){
        if (arr == null || arr.length == 0) {
            return ;
        }
        int len = arr.length;
        if(left<0 || right >= len || left > right){
            throw new IllegalArgumentException();
        } 
        while(left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return ;
    }
    
    //  worked, Jiuzhang solution
    public static String reverseWords12(String s) {
        // write your code
        if (s == null || s.length() == 0) {
            return s;
        }

        String[] array = s.split("\\s+");
        for(String str : array){
        	System.out.println("" + str);
        }
        System.out.println(""+array.length);
        StringBuilder sb = new StringBuilder();

        for (int i = array.length - 1; i >= 0; --i) {
            if (!array[i].equals("")) {
                sb.append(array[i]).append(" ");
            }
        }

        //remove the last " "
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);

    }


}
