package Lintcode.Array.Interval;

import java.util.ArrayList;

/**
Insert Interval Show result 

Given a non-overlapping interval list which is sorted by start point.

Insert a new interval into it, make sure the list is still in order and non-overlapping (merge intervals if necessary).

Have you met this question in a real interview? Yes
Example
Insert [2, 5] into [[1,2], [5,9]], we get [[1,9]].

Insert [3, 4] into [[1,2], [5,9]], we get [[1,2], [3,4], [5,9]].

Tags Expand 
Basic Implementation LinkedIn Google


Related Problems Expand 
Easy Merge Intervals

 *
 */
public class Insert_Interval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//best solution, worked, good idea
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        
        if (newInterval == null || intervals == null) {
            return intervals;
        }

        ArrayList<Interval> results = new ArrayList<Interval>();
        int insertPos = 0;
        //ԭ��interval list���ֲ��䣬 ���������У�����result��newInterval�Ƕ�̬�仯��
        //ͬʱ�ҵ�newInterval�Ĳ���λ��
        //������������ǰ�ᣬinterval�Ѿ�sorted��by Start point����������λ����Ϣ�͸���
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                results.add(interval);
                insertPos++;
            } else if (interval.start > newInterval.end) {
                results.add(interval);
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        results.add(insertPos, newInterval);
        return results;
    }
    

}
