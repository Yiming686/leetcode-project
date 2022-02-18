package Lai.XB.DFS.All_Path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.xml.internal.fastinfoset.Decoder;

public class Morse_String_Decode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"gin", "zen", "gig", "msg"};
		String[] encode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		Map<Character, String> charMorseMap = new HashMap<>();
		for(int i = 0; i < encode.length; i++) {
			charMorseMap.put((char)('a' + i) , encode[i]);
		}
		System.out.println(""+charMorseMap);

		Map<String, String> wordMorseMap = new HashMap<>();
		for(int i = 0; i < words.length; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < words[i].length(); j++) {
				sb.append(charMorseMap.get(words[i].charAt(j)));
			}
			wordMorseMap.put(words[i] , sb.toString());	
		}
		Map<String, List<String>> morseWordMap = new HashMap<>();
		for(int i = 0; i < words.length; i++) {
			String str = "";//morse
			for(int j = 0; j < words[i].length(); j++) {
				str += charMorseMap.get(words[i].charAt(j));
			}
			List<String> val = morseWordMap.getOrDefault(str, new ArrayList<String>());
			val.add(words[i]);
			morseWordMap.put(str, val);//
		}

		System.out.println("wordMorseMap:"+wordMorseMap);
		System.out.println("morseWordMap:"+morseWordMap);
		
		String str = "--...--.--...-.";
		List<String> result = decode(str, morseWordMap);
		System.out.println("result:"+result);
	}

	private static List<String> decode(String str, Map<String, List<String>> morseWordMap) {
		 List<String> result = new ArrayList<String>();
		 StringBuilder sb = new StringBuilder();
		 decode(result, sb, str, 0, morseWordMap);
		return result;
	}

	
	//??? Time= ; Space=;
	private static void decode(List<String> result, StringBuilder sb, String str, int pos,Map<String, List<String>> morseWordMap) {
		System.out.println("pos: "+ pos);
		if(pos == str.length()) {
			result.add(sb.toString());
			return;
		}
		for(int i = pos; i < str.length(); i++) {
			String sub = str.substring(pos, i + 1);
			System.out.println("sub: "+ sub);
			if(morseWordMap.containsKey(sub)) {
				for(String word : morseWordMap.get(sub) ) {
					sb.append(word);
					decode(result, sb, str, pos + sub.length(), morseWordMap);
					sb.delete(sb.length() - word.length(), sb.length());
				}
			}
		}
		
	}

}
