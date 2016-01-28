package Lintcode;

public class Reverse_Words_in_a_String {

    public static String reverseWords(String s) {
        // write your code
        if (s == null || s.length() == 0) {
            return "";
        }

        String[] array = s.trim().split("\\s+");
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = " the   sky     is  blue            ";
//		 s = "              ";

		System.out.println(""+s);
		System.out.println(""+reverseWords(s));
		
	}

}
