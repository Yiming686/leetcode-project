package LeetCode.JavaArray;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

 Hide Tags Array Sort

 */

public class LC_057_Insert_Interval {

	/**
	 * Definition for an interval. public class Interval { int start; int end;
	 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s;
	 * end = e; } }
	 */
	// 真是个经典题目，
	//输入有次序，输出必须也有次序
	//	
	// 真是考察循环实现的多种可能性:两种分段，循环体逻辑分段和循环条件分段，前者最常见，后者不常见，但是有时候根据需求是必须的
	// 如果循环体逻辑分段，仅仅是分段，除了分段，没有任何共用逻辑，那么完全就可以转化为循环条件分段
	//
	// 一个for循环：循环变量赋初值，判断条件，循环体逻辑，循环变量更改。这里面多个if-else语句，那么每次变量改变，都要执行里面的每一个条件，
	// 也就是说必须站在对待每一个变量同等的处理逻辑看待，如果真想不同循环变量，逻辑不同，这个不行
	// 如果想分段处理，必须对循环条件分段，然后根据每一段情况，进行分段处理，此时可以考虑while语句
	// 此题目如果条件采用 (int i = 0; i < intervals.size(); i++)，则一视同仁.
	//
	//三个while循环，第一个简单直接加入待检查区间，第二个不断调整新区间，然后必须加入他，第三个，不管如何先加入新区间，然后循环所有后面的
//	因为要保持循环后的次序，所以要注意添加次序
//
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null) return null;
        List<Interval> list = new ArrayList<Interval>();
		if(intervals.size() == 0) {
		    list.add(newInterval);
		    return list;
		}
		int len = intervals.size();

		int i = 0;
		while(i<len && newInterval.start > intervals.get(i).end){
			list.add(intervals.get(i++));
		}
		while(i<len && newInterval.end >= intervals.get(i).start){
			Interval itv = intervals.get(i++);
			newInterval.start = Math.min(itv.start, newInterval.start);
			newInterval.end = Math.max(itv.end, newInterval.end);

		}
        list.add(newInterval);
		while(i<len){
			list.add(intervals.get(i++));
		}
		return list;
	}

	// 自拍脑袋解法，暂时未完成
	public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
		List<Interval> list = new ArrayList<Interval>();

		double start = 0;
		double end = 0;
		for (int i = 0; i < intervals.size(); i++) {
			Interval itv = intervals.get(i);
			if (newInterval.start >= itv.start && newInterval.start <= itv.end) {
				start = i;
			} else {
				if (i + 1 < intervals.size()) {
					Interval itv2 = intervals.get(i + 1);
					if (newInterval.start > itv.end
							&& newInterval.start < itv2.start) {
						end = i + 0.5;
					}
				}
			}
			if (newInterval.end >= itv.start && newInterval.end <= itv.end) {
				start = i;
			} else {
				if (i + 1 < intervals.size()) {
					Interval itv2 = intervals.get(i + 1);
					if (newInterval.end > itv.end
							&& newInterval.end < itv2.start) {
						end = i + 0.5;
					}
				}
			}
		}

		for (int i = 0; i < intervals.size(); i++) {
			Interval itv = intervals.get(i);
			if (itv.end < newInterval.start || itv.start > newInterval.end) {
				list.add(itv);
			}
			if (itv.end == newInterval.start) {
				itv.end = newInterval.end;
				list.add(itv);
			}
			if (itv.start > newInterval.end) {
				list.add(itv);
			} else if (itv.start == newInterval.start) {
				itv.start = newInterval.start;
				list.add(itv);
			}

		}

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
