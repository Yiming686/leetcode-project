package CodeChallenge.HackerRank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+new MyRegex("00.12.123.123123.123").isMatch());
		System.out.println(""+new MyRegex("122.23").isMatch());
		System.out.println(""+new MyRegex("Hello.IP").isMatch());
		
		System.out.println(""+new MyRegex("000.12.12.034").isMatch());
		System.out.println(""+new MyRegex("121.234.12.12").isMatch());
		System.out.println(""+new MyRegex("23.45.12.56").isMatch());
	}

    private static String pattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    private static Pattern PATTERN = Pattern.compile(pattern, Pattern.MULTILINE | Pattern.DOTALL);
        
    private  String iP;
    public MyRegex(String iP) { 
        this.iP = iP;        
    }
    
    public boolean isMatch() {
        Matcher matcher = PATTERN.matcher(iP);
        return matcher.find();
    }

}
