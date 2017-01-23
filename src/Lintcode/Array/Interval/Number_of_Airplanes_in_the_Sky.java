package Lintcode.Array.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
Number of Airplanes in the Sky

 Description
 Notes
 Testcase
 Judge
Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?

 Notice

If landing and flying happens at the same time, we consider landing should happen at first.

Example
For interval list

[
  [1,10],
  [2,3],
  [5,8],
  [4,7]
]
Return 3

Tags 
LintCode Copyright Array Interval
Related Problems 
Easy Merge Intervals 21 %

 *
 */
public class Number_of_Airplanes_in_the_Sky {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Point{
	    int time;
	    int flag;
	    Point(int t, int s){
	      this.time = t;
	      this.flag = s;
	    }
	}

    //worked, best solution 
    public int countOfAirplanes(List<Interval> airplanes) { 
        if(airplanes == null || airplanes.isEmpty()){
            return 0;
        }
        List<Point> list = new ArrayList<>(airplanes.size()*2);
        for(Interval interval : airplanes){
            list.add(new Point(interval.start, 1));
            list.add(new Point(interval.end, -1));
        }
        Collections.sort(list, new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2){
                if(p1.time != p2.time){
                    return p1.time - p2.time;
                }else{
                    return p1.flag - p2.flag;//Very Important, landing first
                }
            }
        });
        
        int count = 0;
        int max = 0;
        for(Point p : list){
            count += p.flag;
            max = Math.max(max, count);
        }
        return max;
    } 

    
}
