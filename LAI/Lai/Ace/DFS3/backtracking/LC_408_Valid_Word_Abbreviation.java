package Lai.Ace.DFS3.backtracking;

public class LC_408_Valid_Word_Abbreviation {


//"internationalization"
//"i5a11o1"
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String word = "apple"; 
//		String abbr = "a2e";
//		String word = "intern a tionalizati on";
//		String abbr = "i55555 a tttttttttt  on";
//		String word = "internationalization";
//		String abbr = "i5a11o1";
//		String word = "hi";
//		String abbr = "1";
		String word = "a";
		String abbr = "2";
		
		System.out.println(""+validWordAbbreviation( word, abbr));
	}

	public static boolean validWordAbbreviation(String word, String abbr) {
		if (word.length() == 0 && abbr.length() == 0) {
			return true;
		}
		if (word.length() == 0 || abbr.length() == 0) {
			return false;
		}
		int count = 0;
		int j = -1;
		for (int i = 0; i < word.length(); i++) {
			char ch1 = word.charAt(i);
			if (count == 0) {
				j++;
				//for(int j = 0; j < abbr.length(); j++){
				if(j >= abbr.length()) {
					return false;
				}
				char ch2 = abbr.charAt(j);
				if (ch1 == ch2) {
					continue;
				} else if (!Character.isDigit(ch2)) {
					return false;
				} else {
                    // count = Character.forDigit(ch2, 10);
                    String str = "";
//                    j--;
                    while(j < abbr.length() && Character.isDigit(abbr.charAt(j))){
                        str += abbr.charAt(j);
                        j++;
//                        ch2 = abbr.charAt(j);
                    }
                    count = Integer.valueOf(str);;
                    j--;
                    count--;
				}
				//}

			} else {
				count--;
			}
		}
		return count == 0 && j == abbr.length();
	}

}
