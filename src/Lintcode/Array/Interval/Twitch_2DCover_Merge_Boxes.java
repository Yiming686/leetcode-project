package Lintcode.Array.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.apple.laf.resources.aqua_pt_BR;

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

//[1, 3],               [1, 6],
//[2, 6],      =>       [8, 10],
//[8, 10],              [15, 18]
//[15, 18]            ]

public class Twitch_2DCover_Merge_Boxes {

	public static void main(String[] args) {
		Interval[] intervalsArr = new Interval[]{
				new Interval(1.0f, 3.0f),
				new Interval(2.0f, 6.0f),
				new Interval(8.0f, 10.0f),
				new Interval(15.0f, 18.0f)
		};
	    List<Interval> intervals = new ArrayList<Interval>();
	    intervals.add(new Interval(2.0f, 5.0f));
	    intervals.add(new Interval(2.0f, 4.0f));
	    
		System.out.println(""+IDCover(intervals));
		
		Box[] boxes1 = new Box[]{
				new Box(2,2,5,5),
				new Box(1,1,3,3),
				new Box(2,2,4,4)
		};//12
		
		Box[] boxes2 = new Box[]{
				new Box(2,1,4,2),
				new Box(2,2,4,3),
				new Box(2,3,4,4),
				new Box(2.5f,1.5f,3.5f,3.5f),
		};//6

		Box[] boxes3 = new Box[]{
				new Box(1,1,4,3),
				new Box(5,1,8,3),
				new Box(10,1,15,3),
		};//

		Box[] boxes4 = new Box[]{
				new Box(1-5,1,10-5,10),
				new Box(3-5,3,6-5,6),
				new Box(2-5,2,8-5,8),
		};//81

//		System.out.println(""+IIDCover(boxes));
		System.out.println(""+IIDCover(boxes1));
		System.out.println(""+IIDCover(boxes2));
		System.out.println(""+IIDCover(boxes3));
		System.out.println(""+IIDCover(boxes4));
		
		
	}

	static class Box {
	    float lower, left;
	    float upper,right;
	    Box( float lower, float left,float upper,float right) {
	    	this.lower = lower;
	        this.left = left;
	        this.upper = upper;
	        this.right = right;
	    }
	}
	static class CutLine {
	    float pos;
	    Interval interval;
	    int addOrRemove;
		public CutLine(float pos, Interval interval, int addOrRemove) {
			super();
			this.pos = pos;
			this.interval = interval;
			this.addOrRemove = addOrRemove;
		}
	    
	}	
    public static float IIDCover(Box[] boxes) {
    	if(boxes == null || boxes.length == 0) return 0.0f;
        List<CutLine> cutLineList = new ArrayList<CutLine>();

		for(Box box : boxes){
			cutLineList.add(new CutLine(box.left,  new Interval(box.lower,  box.upper),  1));
			cutLineList.add(new CutLine(box.right, new Interval(box.lower,  box.upper), -1));
		}
		
		Collections.sort(cutLineList, new Comparator<CutLine>() {
			@Override
			public int compare(CutLine o1, CutLine o2) {
				if(o1.pos != o2.pos){
					return o1.pos > o2.pos ? 1 : -1;
				}else{
					return o2.addOrRemove - o1.addOrRemove;//very important
				}
			}
		});
		System.out.println(""+cutLineList);
		
		List<Interval> intervals = new ArrayList<Interval>();
		CutLine prev = cutLineList.get(0);
		intervals.add(prev.interval);
		float area = 0.0f;
		for(int i = 1; i < cutLineList.size(); i++){
			CutLine curr = cutLineList.get(i);
			float height = IDCover(intervals);
			area += height * (curr.pos - prev.pos);
			System.out.println("height:width:area  "+ height + " : " + (curr.pos - prev.pos) +" : " + area);
			
			if(curr.addOrRemove == -1) intervals.remove(curr.interval);
			if(curr.addOrRemove ==  1) intervals.add(curr.interval);
			prev = curr;
		}
		return area;
    }
	
	
	
	
	
	
	static class Interval {
	    float start, end;
	    Interval(float start, float end) {
	        this.start = start;
	        this.end = end;
	    }
	    
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Float.floatToIntBits(end);
			result = prime * result + Float.floatToIntBits(start);
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Interval other = (Interval) obj;
			if (Float.floatToIntBits(end) != Float.floatToIntBits(other.end))
				return false;
			if (Float.floatToIntBits(start) != Float.floatToIntBits(other.start))
				return false;
			return true;
		}
	    
	    
	}

    public static float IDCover(List<Interval> intervals) {
    	if (intervals == null || intervals.size() == 0) {
    		return 0.0f;
		}
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start!=o2.start){
					return (o1.start > o2.start) ? 1 : -1;
				}else{
					if(o1.end == o2.end) return 0;
					return (o1.end == o2.end) ? 1:-1;
				}
			}
		});
		float sum = 0.0f;
		float prevStart = intervals.get(0).start;
		float prevEnd   = intervals.get(0).end;
        for (int i = 1; i< intervals.size(); i++) {
        	float currStart = intervals.get(i).start;
        	float currEnd   = intervals.get(i).end;
			if (currStart > prevEnd) {
				sum += prevEnd - prevStart;
				prevStart = currStart;
				prevEnd = currEnd;
			}else {
				prevEnd = Math.max(prevEnd, currEnd);
			}
		}
        sum += prevEnd - prevStart;
		return sum;
	}

	
    public static float IDCover(Interval[] intervals) {
    	if (intervals == null || intervals.length == 0) {
    		return 0.0f;
		}
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start!=o2.start){
					return (o1.start > o2.start) ? 1 : -1;
				}else{
					if(o1.end == o2.end) return 0;
					return (o1.end == o2.end) ? 1:-1;
				}
			}
		});
		float sum = 0.0f;
		float prevStart = intervals[0].start;
		float prevEnd   = intervals[0].end;
        for (int i = 1; i< intervals.length; i++) {
        	float currStart = intervals[i].start;
        	float currEnd   = intervals[i].end;
			if (currStart > prevEnd) {
				sum += prevEnd - prevStart;
				System.out.println(""+sum);
				prevStart = currStart;
				prevEnd = currEnd;
			}else {
				prevEnd = Math.max(prevEnd, currEnd);
			}
		}
        sum += prevEnd - prevStart;
		return sum;
	}

	
    

}
