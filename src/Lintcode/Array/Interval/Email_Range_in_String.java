package Lintcode.Array.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import com.sun.swing.internal.plaf.synth.resources.synth_sv;

/**
Example 1:
Input: 1:4  ,  5:10,11:20
Output: 1:20
Example 2:
Input: 5:10,1:2
Output: 1:2,5:10 

*
 */
public class Email_Range_in_String {

	public static void main(String[] args) {
		
        char[] arr = new char[3];
        int sum = 4;
        arr[1] = Character.valueOf((char) 4);
         arr[0] = (char) (sum%10);
         
            
		// TODO Auto-genString rangeserated method stub
		String ranges = "1:4  ,  5:10,11:20";
		String ranges2 = "5:10,1:2";
//		String ranges3 = " 5:10 ";
//		String[] arr1 = ranges3.split("\\,");
//		System.out.println(""+arr1.length);
//		String[] arr1 = ranges.split("\\,");
		System.out.println(""+compactAndSort(ranges));
		System.out.println(""+compactAndSort(ranges2));
		
		
		System.out.println(""+getNextStr("999"));
		
//		TreeSet<String> set = new TreeSet<String>(compStrs);
////		TreeSet<String> set = new TreeSet<String>();
//		set.add("6");	
//		set.add("223");
//		set.add("91");
//		set.add("27893");set.add("692");
//		set.add("27893");set.add("62793");
//		set.add("65");set.add("657");set.add("655");
//		System.out.println(""+set);
	}
	
	//经典把string当成Integer的比较器
	static Comparator<String> compStrs = new Comparator<String>() {
		@Override
	    public int compare(String str1, String str2) {
	        int len1 = str1.length();
	        int len2 = str2.length();
	        if(len1 != len2)  return  len1 - len2;
	        
	        for(int i = 0; i < len1; i++){
	        	int char1 = str1.charAt(i);  
	        	int char2 = str2.charAt(i);
	        	if(char1!=char2) return char1 - char2;
	        }
	        return 0;
	    }
	};
	//【not best】经典把string当成Integer的比较器, 
	static Comparator<String> compStrs2 = new Comparator<String>() {
		@Override
	    public int compare(String str1, String str2) {
	        int len1 = str1.length();
	        int len2 = str2.length();
	        if(len1 != len2)  return  len1 - len2;
	        
	        char arr1[] = str1.toCharArray();
	        char arr2[] = str2.toCharArray();

	        int k = 0;
	        while (k < len1) {
	            char c1 = arr1[k];
	            char c2 = arr2[k];
	            if (c1 != c2) {
	                return c1 - c2;
	            }
	            k++;
	        }
	        return 0;
	    }
	};

	
	static class Interval {
	    String start, end;
	    Interval(String start, String end) {
	        this.start = start;
	        this.end = end;
	    }
	}
    static String compactAndSort(String ranges) {
        if(ranges == null || ranges.length() == 0 || ranges.trim().length() == 0) return "";
    	List<Interval> intervals = new ArrayList<Interval>();
        String[] arr1 = ranges.split("\\,");
        if(arr1.length < 1) return "\"\"";
        if(arr1.length == 1 && arr1[0].trim().equals("")) return "\"\"";
        for(String itv : arr1){
            String[] arr2 = itv.trim().split("\\:");
            if(arr2.length == 2){
                if(!arr2[0].trim().equals("") && !arr2[1].trim().equals("")){
                    intervals.add(new Interval(arr2[0].trim(),arr2[1].trim()));                
                }
            } else{
                return "\"\"";
            }  

        }
        List<Interval> result = merge(intervals);
        StringBuilder sb = new StringBuilder();
        if(result.size() > 0){
            for(Interval itv : result){
                sb.append(itv.start + ":"+itv.end +",");
            }
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
    
     public static List<Interval> merge(List<Interval> intervals) {
			ArrayList<Interval> res = new ArrayList<Interval>();
        	if (intervals == null || intervals.size() == 0) {
				return res;
			}
        	Comparator<Interval> comp = new Comparator<Interval>() {
    			@Override
    			public int compare(Interval o1, Interval o2) {
    				if(o1.start.length()!=o2.start.length()){
    					return o1.start.length() - o2.start.length();
    				}
    				for(int i=0;i<o1.start.length();i++){
    					if(o1.start.charAt(i)!=o2.start.charAt(i)){
    						return o1.start.charAt(i) - o2.start.charAt(i);
    					}
    				}
    				return 0;
    			}
    		};
        	Collections.sort(intervals, comp);
        	
        	
			res.add(intervals.get(0));
			for (int i = 1; i < intervals.size(); i++) {
				Interval curr = intervals.get(i);
				Interval last = res.get(res.size() - 1);
                String nextStr = getNextStr(last.end);
				if(compare2Strs(curr.start, nextStr) <= 0 ){
                    if(compare2Strs(curr.end, last.end) <= 0){
    					last.end = last.end;                        
                    }else{
                       last.end = curr.end;
                    }
				}else{
					res.add(curr);
				}
			}
			return res;
    }

    public static String getNextStr(String last){
        
        char[] arr = last.toCharArray();
        int carry = 1;
        for(int i = arr.length - 1; i >=0;i--){
        	char ch = arr[i];
            int sum = carry + (ch-'0');
            arr[i] = (char) ('0'+sum%10) ;
            carry = sum/10;
        }
        if(carry ==1){
            return "1"+new String(arr);
        }else{
            return new String(arr);
        }
        
    }
    
    //String的字典的实现
    //找到最小的长度，从左到右遍历，一旦发现不等，则小的在前面
    public static int compareTo1(String str1, String str2) {
    	char[] value1 = str1.toCharArray();
    	char[] value2 = str1.toCharArray();
        int len1 = value1.length;
        int len2 = value2.length;
        int lim = Math.min(len1, len2);
        char v1[] = value1;
        char v2[] = value2;

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }

    //String的数字的实现
    //找到最小的长度，从右到左遍历，一旦发现不等，则小的在前面
    public static int compare2Strs(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if(len1 != len2)  return  len1 - len2;
        
        for(int i = 0; i < len1; i++){
        	int char1 = str1.charAt(i);  
        	int char2 = str2.charAt(i);
        	if(char1!=char2) return char1 - char2;
        }
        return 0;
    }

    //String的数字的实现
    //找到最小的长度，从右到左遍历，一旦发现不等，则小的在前面
    public static int compareTo2(String str1, String str2) {
    	char[] value1 = str1.toCharArray();
    	char[] value2 = str1.toCharArray();
        int len1 = value1.length;
        int len2 = value2.length;
        int lim = Math.min(len1, len2);
        char v1[] = value1;
        char v2[] = value2;

        int k = lim-1;
        while (k >= 0) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k--;
        }
        return len1 - len2;
    }


}	



