package Utils;

public class LongUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+toBinaryString(123L, 3));
	}

	public static String toBinaryString(Long num) {//64 位，8个字节
		return toBinaryString(num, 3, true);
	}
	
	public static String toBinaryString(Long num, int width) {//64 位，8个字节
		return toBinaryString(num, width, true);
	}

	public static String toBinaryString(Long num, boolean withIndex) {
		// TODO Auto-generated method stub
		return toBinaryString(num, 3, withIndex);
	}

	public static String toBinaryString(Long num, int width, boolean withIndex) {//64 位，8个字节
		if(num == null) {
			return null;
		}
		String prefix = "";
		for(int i = 1; i < width; i++) {
			prefix += " "; 			
		}
		StringBuilder sb = new StringBuilder();
		StringBuilder sbIndex = new StringBuilder();
		sb.append("[");
		sbIndex.append("[");
		for(int offset = 63; offset >= 0; offset--) {
			int val = (int)(num >>> offset) & 1;
			sb.append(prefix).append(val).append(",");
			sbIndex.append("").append(uniform(offset, width)).append(",");
		}
		sb.append("]").append("\n");
		sbIndex.append("]").append("\n");
		
		return withIndex ? sb.toString() + sbIndex.toString() : sb.toString();
	}

	private static String uniform(int offset, int width) {
		StringBuilder sb = new StringBuilder();
		sb.append(offset);
		while(sb.length() != width) {
			sb.insert(0, " ");
		}
		return sb.toString();
	}

}
