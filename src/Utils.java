import java.text.MessageFormat;
import java.time.Instant;
import java.util.Random;

public class Utils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Find	 three   closest    elements from given three sorted arrays  ";
		String newName = convert(str);
		System.out.println(""+newName);
		String result = "AFEd: ";
		result += Instant.now();
		System.out.println(""+ result);
		System.out.println(""+ 0x55);
		System.out.println("Random: "+new Random().nextInt(1));
		System.out.println("Random: "+new Random().nextInt(1));
		System.out.println("Random: "+new Random().nextInt(1));
	}
	
	private static String convert(String str) {
		// TODO Auto-generated method stub
		String[] arr = str.split("\\s+");
		String newName = "";
		String prefix = "";
		for(String s : arr){
			newName += prefix+s;
			prefix = "_";
		}
		return newName;
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
