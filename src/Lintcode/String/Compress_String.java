package Lintcode.String;

public class Compress_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		(null, null)("","")("b","b")("abc","abc")
//		("aa","a2")("aaa","a3")("aab","a2b")("aaab","a3b")("abbcc","ab2c2")("aabbccc","a2b2c3")
		System.out.println("null:"+compress(null));
		System.out.println(""+compress(""));
		System.out.println("b:"+compress("b"));
//		System.out.println(""+compress("abc"));
		System.out.println("aa:"+compress("aa"));
		System.out.println("aaa:"+compress("aaa"));	
		System.out.println("aab:"+compress("aab"));
		System.out.println("aaab:"+compress("aaab"));
		System.out.println("abbcc:"+compress("abbcc"));
		System.out.println("aabbccc:"+compress("aabbccc"));
		
	}
	
	public static String compress(String str){
		if(str == null || str.length() < 2) return str;
		char preChar = str.charAt(0);
		char ch = str.charAt(0);
		int count = 1;
		String compressedStr = "";
		
		for(int i = 1; i < str.length(); i++){
			ch = str.charAt(i);
			if(ch == preChar){
				count++;
			}else if(count == 1){
				compressedStr =compressedStr+ preChar;
				preChar = ch;
				count = 1;
			}else{
				compressedStr = compressedStr + preChar+count;
				preChar = ch;
				count = 1;
			}
		}
		if(count == 1){
			compressedStr = compressedStr+ch;
		}else{
			compressedStr = compressedStr+ch+count;
		}

		return compressedStr;
	}

}
