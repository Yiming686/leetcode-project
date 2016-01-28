package Lintcode.Array.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**

Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

Have you met this question in a real interview? Yes
Example
Given intervals => merged intervals:

[                     [
  [1, 3],               [1, 6],
  [2, 6],      =>       [8, 10],
  [8, 10],              [15, 18]
  [15, 18]            ]
]
Challenge
O(n log n) time and O(1) extra space.

Tags Expand 
LinkedIn Sort Array Google


Related Problems Expand 
Medium Number of Airplanes in the Sky 22 %
Easy Insert Interval

 *
 */
public class Merge_Intervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    //worked, best 
    public List<Interval> merge9(List<Interval> intervals) {
    	if (intervals == null) {
    		return null;
		}
		ArrayList<Interval> res = new ArrayList<Interval>();
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if(o1.start!=o2.start)
				    return o1.start - o2.start;
				else
				    return o1.end - o2.end;
			}
		});
        for (Interval curr : intervals) {
//		for (int i = 0; i < intervals.size(); i++) {
//			Interval curr = intervals.get(i);
			if (res.isEmpty()) {
				res.add(curr);
			} else {
				Interval last = res.get(res.size() - 1);
		//		新list 里面的最后一个和当前进行比较
		//		沒有交集，直接加入；如果有交集，就找最大，end， 不用找start，因为已经排序过了
				if(curr.start <= last.end){
					last.end = Math.max(curr.end, last.end);
				}else{
					res.add(curr);
				}
			}
		}
		return res;
	}

	
    //Jiuzhang solution, worked 
    public List<Interval> merge8(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });       
  
        ArrayList<Interval> result = new ArrayList<Interval>();
        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curt = intervals.get(i);
            if (curt.start <= last.end ){
                last.end = Math.max(last.end, curt.end);
            }else{
                result.add(last);
                last = curt;
            }
        }
        
        result.add(last);
        return result;
    }
    
    
    //My solution, worked 
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if(intervals == null || intervals.size() < 2) return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        //这个是merge, results的size不确定
        ArrayList<Interval> results = new ArrayList<Interval>();
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (prev.end < curr.start) {
                results.add(prev);
                prev = curr;
            } else {
                // prevInterval.start = Math.min(prevInterval.start, interval.start);
                prev.end = Math.max(prev.end, curr.end);
            }
        }
        results.add(prev);   
        return results;
    }
    

}
