package Utils;

public class IntegerUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+toBinaryString(3, 3));
	}
	public static String toBinaryString(int num) {//64 位，8个字节
		return toBinaryString(num, 3, true);
	}
	
	public static String toBinaryString(int num, int width) {//64 位，8个字节
		return toBinaryString(num, width, true);
	}

	public static String toBinaryString(int num, boolean withIndex) {
		// TODO Auto-generated method stub
		return toBinaryString(num, 3, withIndex);
	}

	public static String toBinaryString(int num, int width, boolean withIndex) {//64 位，8个字节
		return toBinaryString(Integer.valueOf(num), width, withIndex);
	}
	
	public static String toBinaryString(Integer num) {//64 位，8个字节
		return toBinaryString(num, 3, true);
	}
	
	public static String toBinaryString(Integer num, int width) {//64 位，8个字节
		return toBinaryString(num, width, true);
	}

	public static String toBinaryString(Integer num, boolean withIndex) {
		// TODO Auto-generated method stub
		return toBinaryString(num, 3, withIndex);
	}

	public static String toBinaryString(Integer num, int width, boolean withIndex) {//64 位，8个字节
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
		for(int offset = 31; offset >= 0; offset--) {
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
