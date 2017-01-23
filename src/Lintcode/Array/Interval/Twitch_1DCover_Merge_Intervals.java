package Lintcode.Array.Interval;

import java.util.ArrayList;
import java.util.Arrays;
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

//[1, 3],               [1, 6],
//[2, 6],      =>       [8, 10],
//[8, 10],              [15, 18]
//[15, 18]            ]

public class Twitch_1DCover_Merge_Intervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		float f1 = 0.44f;
//		float f2 = 0.44f;
//		System.out.println(""+(f1==f2));
		Interval[] intervals = new Interval[]{
				new Interval(1.0f, 3.0f),
				new Interval(2.0f, 6.0f),
				new Interval(8.0f, 10.0f),
				new Interval(15.0f, 18.0f)
		};
		
		System.out.println(""+IDCover(intervals));
		
	}

	static class Interval {
	    float start, end;
	    Interval(float start, float end) {
	        this.start = start;
	        this.end = end;
	    }
	}

    public static float IDCover(Interval[] intervals) {
    	if (intervals == null) {
    		return 0;
		}
    	float sum = 0.0f;
    	float prevStart = intervals[0].start;
    	float prevEnd   = intervals[0].end;
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
