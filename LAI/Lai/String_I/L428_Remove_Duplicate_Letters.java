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
 * 就是要删除的到每个字符都是唯一的，但是剩下的唯一字符的顺序有讲究！！！
 * 次序不能乱，必须是从当前字符串里面看上去，那个字典顺序里面最小的那个组合！！！
 * 每一个字符接受审判，能删还是不能删 或者 能保留还是不能保留？
 * 
 * 思路：
 * 标记记录所有字符的出现个数
 * 标记字符是否使用过
 * 遍历所有字符
 * 		后面剩余的字符个数减一
 * 		如果当前字符已经被使用过，则跳过；
 * 		如果当前字符没有被使用过，
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
			count[ch - 'a']--;//剩下多少个了，唯一的更新count的地方，每次汇报后面还有多少个字符
			if(!used[ch - 'a']) {//如果当前字符没有用过，准备循环删除前面的元素,如果前面的字符不仅在字典排在后面而且后面还会出现
//				int len = sb.length();//大bug，sb是动态变化的在while循环里面
//				 char lastCh = sb.charAt(len - 1);
				while(sb.length() > 0 && sb.charAt(sb.length() - 1) > ch && count[sb.charAt(sb.length() - 1) - 'a'] > 0 ) {
					used[sb.charAt(sb.length() - 1) - 'a'] = false;//标记没有使用过该最后一个字符
					sb.deleteCharAt(sb.length() - 1);//删除最后一个字符
				}
				used[ch-'a'] = true;
				sb.append(ch);
			}
		}
		return sb.toString();
	}

}
