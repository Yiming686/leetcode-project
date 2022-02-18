package Lai.String_I;


/**
��һ�����⣺���ظ�������£���������һ���ظ�Ԫ�أ���ϣ���������ظ���

��һ��Ҫ���ź��򣬵��ǽ���ǰ��������ظ�Ԫ�أ����ظ�������£���������һ���ظ�Ԫ�أ�����ϣ���������ظ���ʱ������
�ź���Ļ������ظ�������£���������һ���ظ�Ԫ�أ���ϣ���������ظ���
 *
 */
public class Remove_Adjacent_Repeated_Characters_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ccccbbbaaaabbbc";
		System.out.println("" + deDup(str));

	}

	public static String deDup(String input) {
		// Write your solution here
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] arr = input.toCharArray();
		int slow = 1;
		for (int fast = 1; fast < arr.length; fast++) {
			if(arr[fast] != arr[slow - 1]) {
				arr[slow++] = arr[fast];
			}
		}
		return new String(arr, 0, slow);
	}

}
