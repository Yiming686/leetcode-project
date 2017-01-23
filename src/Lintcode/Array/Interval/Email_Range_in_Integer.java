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
[ע��]��������һ���ʾ�����merge��ʱ��Ҫ����������1�������������1�ܼ�
[ע��]������ַǳ���ǳ����Ǿ��Ǳ��밴��String�������ˡ�
A:Java string�ıȽϣ��ǰ����ֵ�������ģ�
Ҳ����˵�ȱȽ϶���String�Ļ����ӵ�һ���ַ���ʼ����ͬʱ�����Ƚϣ�һ����һ��û���ַ��ˣ��ǾͱȽϳ��ȣ����ȶ̵���ǰ

B:������հ�String������������Ļ�����Ҫ�ȱȽϳ��ȣ����ȶ̵���ǰ�棬���ȳ����ں��棻Ȼ�����һ�������ˣ�һ���ַ�һ���ַ��ȽϾͺ�


*
 */
public class Email_Range_in_Integer {

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
		
//		System.out.println(""+getNextStr("999"));
	}
	
 	static class Interval {
	    long start, end;
	    Interval(long start, long end) {
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
                    intervals.add(new Interval(Integer.valueOf(arr2[0].trim()),Integer.valueOf(arr2[1].trim())));                
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
			Collections.sort(intervals, new Comparator<Interval>() {
				@Override
				public int compare(Interval o1, Interval o2) {
                     if(o1.start == o2.start){
                         return 0;
                     }else if(o1.start < o2.start){
                         return -1;
                     }else{
                         return 1;
                     }
				}
			});
			res.add(intervals.get(0));
			for (int i = 1; i < intervals.size(); i++) {
				Interval curr = intervals.get(i);
				Interval last = res.get(res.size() - 1);
				if(curr.start <= last.end + 1 ){
					last.end = Math.max(curr.end, last.end);
				}else{
					res.add(curr);
				}
			}
			return res;
    }


}
