package Lai.String_I;

/**
 * Given a string which contains only lowercase letters, remove duplicate
 * letters so that every letter appear once and only once. You must make sure
 * your result is the smallest in lexicographical order among all possible
 * results.
 * 
 * Example:
 * 
 * Given "bcabc" Return "abc"
 * 
 * Given "cbacdcbc" Return "acdb"
 *
 * ����Ҫɾ���ĵ�ÿ���ַ�����Ψһ�ģ�����ʣ�µ�Ψһ�ַ���˳���н���������
 * �������ң������Ǵӵ�ǰ�ַ������濴��ȥ���Ǹ��ֵ�˳��������С���Ǹ���ϣ�����
 * ÿһ���ַ��������У���ɾ���ǲ���ɾ ���� �ܱ������ǲ��ܱ�����
 * 
 * ˼·��
 * ��Ǽ�¼�����ַ��ĳ��ָ���
 * ����ַ��Ƿ�ʹ�ù�
 * ���������ַ�
 * 		����ʣ����ַ�������һ
 * 		�����ǰ�ַ��Ѿ���ʹ�ù�����������
 * 		�����ǰ�ַ�û�б�ʹ�ù���
 * 
 */
public class L428_Remove_Duplicate_Letters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+removeDuplicateLetters("ccccbcabc"));
	}

	public static String removeDuplicateLetters(String input) {
		// Write your solution here
		if(input == null || input.length() < 2) {
			return input;
		}
		char[] arr = input.toCharArray();
		int[] count = new int[26];
		boolean[] used = new boolean[26];
		for(char ch : arr) {
			count[ch - 'a']++;
		}
		StringBuffer sb = new StringBuffer();
		for(char ch : arr) {
			count[ch - 'a']--;//ʣ�¶��ٸ��ˣ�Ψһ�ĸ���count�ĵط���ÿ�λ㱨���滹�ж��ٸ��ַ�
			if(!used[ch - 'a']) {//�����ǰ�ַ�û���ù���׼��ѭ��ɾ��ǰ���Ԫ��,���ǰ����ַ��������ֵ����ں�����Һ��滹�����
//				int len = sb.length();//��bug��sb�Ƕ�̬�仯����whileѭ������
//				 char lastCh = sb.charAt(len - 1);
				while(sb.length() > 0 && sb.charAt(sb.length() - 1) > ch && count[sb.charAt(sb.length() - 1) - 'a'] > 0 ) {
					used[sb.charAt(sb.length() - 1) - 'a'] = false;//���û��ʹ�ù������һ���ַ�
					sb.deleteCharAt(sb.length() - 1);//ɾ�����һ���ַ�
				}
				used[ch-'a'] = true;
				sb.append(ch);
			}
		}
		return sb.toString();
	}

}
