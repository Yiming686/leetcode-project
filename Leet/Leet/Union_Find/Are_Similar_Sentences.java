package Leet.Union_Find;

public class Are_Similar_Sentences {

	public static void main(String[] args) {
		

	}

	public boolean areSimilarSentences(String[] sentence1, String[] sentence2, String[][] pairs) {
		if(sentence1.length != sentence2.length) {
			return false; 
		}
		for(String[] pair : pairs) {
			associate(pair[0], pair[1]);
		}
		return false;
	}

	private static void associate(String str1, String str2) {
		
		
	}
}
