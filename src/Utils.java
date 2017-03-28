import java.text.MessageFormat;

public class Utils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void println(String str){
		System.out.println(str);
	}

	public static void printf(String format, Object ... args ){
		System.out.printf(format, args);
	}
	
	public static void msgPrintf(String pattern, Object ... arguments ){
		System.out.println(MessageFormat.format(pattern, arguments));
	}
}
