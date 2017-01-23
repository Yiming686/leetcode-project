package Lintcode.Array.Interval;

	import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
Example 1:
Input: 1:4  ,  5:10,11:20
Output: 1:20
Example 2:
Input: 5:10,1:2
Output: 1:2,5:10 

//Make Interval comparable


*
 */
public class Email_Range_in_String3 {

	public static void main(String[] args) {
		
		String ranges = "1:4  ,  5:10,11:20";
		String ranges2 = "5:10,1:2";
		String ranges3 = " 5:10 ";
		String ranges4 = "5000000000003:99999999999999999999, 10000:5000000000000";
		
		System.out.println(""+compactAndSort(ranges));
		System.out.println(""+compactAndSort(ranges2));
		System.out.println(""+compactAndSort(ranges3));
		System.out.println(""+compactAndSort(ranges4));
		
	}
	
static class Interval implements Comparable<Interval> {
	String start, end;

	Interval(String start, String end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Interval otherInterval) {
		// TODO Auto-generated method stub
		String str1 = this.start;
		String str2 = otherInterval.start;
		int len1 = str1.length();
		int len2 = str2.length();
		if (len1 != len2)
			return len1 - len2;

		for (int i = 0; i < len1; i++) {
			int char1 = str1.charAt(i);
			int char2 = str2.charAt(i);
			if (char1 != char2)
				return char1 - char2;
		}
		return 0;
	}
}

public static String getNextStr(String last) {

	char[] arr = last.toCharArray();
	int carry = 1;
	for (int i = arr.length - 1; i >= 0; i--) {
		char ch = arr[i];
		int sum = carry + (ch - '0');
		arr[i] = (char) ('0' + sum % 10);
		carry = sum / 10;
	}
	if (carry == 1) {
		return "1" + new String(arr);
	} else {
		return new String(arr);
	}

}

//public static int compare2Strs(String str1, String str2) {
//	int len1 = str1.length();
//	int len2 = str2.length();
//	if (len1 != len2)
//		return len1 - len2;
//
//	for (int i = 0; i < len1; i++) {
//		int char1 = str1.charAt(i);
//		int char2 = str2.charAt(i);
//		if (char1 != char2)
//			return char1 - char2;
//	}
//	return 0;
//}

public static List<Interval> merge(List<Interval> intervals) {
	ArrayList<Interval> res = new ArrayList<Interval>();
	if (intervals == null || intervals.size() == 0) {
		return res;
	}
	Collections.sort(intervals);

//	Collections.sort(intervals, new Comparator<Interval>() {
//		@Override
//		public int compare(Interval o1, Interval o2) {
//			return compare2Strs(o1.start, o2.start);
//		}
//	});
	res.add(intervals.get(0));
	for (int i = 1; i < intervals.size(); i++) {
		Interval curr = intervals.get(i);
		Interval last = res.get(res.size() - 1);
		String nextStr = getNextStr(last.end);
		String lastEnd = last.end;
		last.end = nextStr;
		if (curr.compareTo(new Interval(last.end, last.end)) <= 0) {
//			last.end = compare2Strs(curr.end, last.end) <= 0 ? lastEnd : curr.end;
		} else {
			res.add(curr);
		}

//		if (compare2Strs(curr.start, nextStr) <= 0) {
//			last.end = compare2Strs(curr.end, last.end) <= 0 ? last.end : curr.end;
//		} else {
//			res.add(curr);
//		}
	}
	return res;
}

static String compactAndSort(String ranges) {
	if (ranges == null || ranges.length() == 0 || ranges.trim().length() == 0)
		return "";
	List<Interval> intervals = new ArrayList<Interval>();
	String[] arr1 = ranges.split("\\,");
	if (arr1.length < 1)
		return "\"\"";
	if (arr1.length == 1 && arr1[0].trim().equals(""))
		return "\"\"";
	for (String itv : arr1) {
		String[] arr2 = itv.trim().split("\\:");
		if (arr2.length == 2) {
			if (!arr2[0].trim().equals("") && !arr2[1].trim().equals("")) {
				intervals.add(new Interval(arr2[0].trim(), arr2[1].trim()));
			}
		} else {
			return "\"\"";
		}

	}
	List<Interval> result = merge(intervals);
	StringBuilder sb = new StringBuilder();
	if (result.size() > 0) {
		for (Interval itv : result) {
			sb.append(itv.start + ":" + itv.end + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
	}
	return sb.toString();
}    



}	



