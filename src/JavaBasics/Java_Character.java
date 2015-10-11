package JavaBasics;

public class Java_Character {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Character.digit('a', 10));
		System.out.println(Character.getNumericValue('A'));
		Character ch = new Character('A');
		char cc = 'd';
		ch.toLowerCase(ch);
		Character.toLowerCase(cc);
		Character.isDigit(cc);
		Character.isLetter(cc);
		
		ch.valueOf(cc);
	}
	
}
