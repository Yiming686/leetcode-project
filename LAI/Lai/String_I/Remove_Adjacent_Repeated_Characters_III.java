package Lai.String_I;

/**
 * 
 * ���������⣺���ظ�������£���������ظ�Ԫ�أ�һ��Ҳ�������������ظ�Ԫ��
 * �����Ƿ��ź������ظ�������£���������ظ�Ԫ�أ�һ��Ҳ�������������ظ�Ԫ��
 * 
 * �ź����ˣ�IV�Ľⷨ��Ȼ����
 * 
Remove adjacent, repeated characters in a given string, leaving no character for each group of such characters. 
The characters in the string are sorted in ascending order.

Assumptions

Try to do it in place.
Examples

��aaaabbbc�� is transferred to ��c��
Corner Cases

If the given string is null, we do not need to do anything.
 *
 * 
 */
public class Remove_Adjacent_Repeated_Characters_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "bbbbtttttbaaaac";
		String str = "abbbaaabbaccczc";
		
		System.out.println("" + deDup(str));

	}

    public static String deDup(String input) {
        // Write your solution here
        if(input == null || input.length() == 0  ){
          return input;
        }		
        char[] arr = input.toCharArray();
        int left = 0;
        for (int right = 0; right < arr.length; right++){
          if (left == 0 || arr[right] != arr[left - 1]){
            arr[left++] = arr[right];
          } else {
            left--;
            while(right + 1 < arr.length && arr[right + 1] == arr[left]){
              right++;
            }
          }
        }
        return new String(arr, 0, left);    
      }

}
