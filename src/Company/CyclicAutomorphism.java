package Company;

public class CyclicAutomorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+count(""));
		System.out.println(""+count("byebye"));
		System.out.println(""+count("codility"));
		System.out.println(""+count("ababab"));
		System.out.println(""+count("aabbaabb"));
		
	}

	public  static int count(String s) {
		int[] b = preprocess(s);
		int count = search(s + s, s, b);
		return count;
	}
	
	private  static int[] preprocess(String pattern) {
		int[] b = new int[pattern.length() + 1];
		int i = 0;
		int j = -1;
		b[0] = j;
		while(i < pattern.length()) {
			while(j >= 0 && pattern.charAt(j) != pattern.charAt(i)) {
				j = b[j];
			}
			i++;
			j++;
			b[i] = j;
		}
		return b;
	}
	
	private static int search(String text, String pattern, int[] b) {
		int i = 0;
		int j = 0;
		int count = -1;
		while(i < text.length()) {
			while(j >= 0 && pattern.charAt(j) != text.charAt(i)) {
				j = b[j];
			}
			i++;
			j++;
			if(j == pattern.length()) {
				count++;
				j = b[j];
			}
		}
		return count;
	}

}
