package LeetCode.JavaArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC_056_Merge_Intervals {

	/*
	 * Given a collection of intervals, merge all overlapping intervals.
	 * 
	 * For example, Given [1,3],[2,6],[8,10],[15,18], return
	 * [1,6],[8,10],[15,18].
	 */

//扩展：
//	1.找出最大重叠intervals
//2.找出所有interval的长度
//	3.给出时间区间，找出是否有人能够参加所有会议
// 什么时间，需要comparator需要比较end值
//给出会议区间，求最小会议室数目？
//	
	public class Solution {
		public List<Interval> merge(List<Interval> intervals) {
			if (intervals == null) {
				return null;
			}
			ArrayList<Interval> res = new ArrayList<Interval>();
			Comparator<Interval> cmp = new Comparator<Interval>() {

				@Override
				public int compare(Interval o1, Interval o2) {
					// TODO Auto-generated method stub
					if (o1.start < o2.start) {
						return -1;
					} else if (o1.start > o2.start) {
						return 1;
					} else {
						if (o1.end < o2.end) {
							return -1;
						} else if (o1.end > o2.end) {
							return 1;
						} else {
							return 0;
						}
					}
				}

			};
//sort 原始集合
			Collections.sort(intervals, cmp);

			for (int i = 0; i < intervals.size(); i++) {
				Interval curr = intervals.get(i);
				if (res.isEmpty()) {
					res.add(curr);
				} else {
					Interval last = res.get(res.size() - 1);
//					新list 里面的最后一个和当前进行比较
//					沒有交集，直接加入；如果有交集，就找最大，end， 不用找start，因为已经排序过了
					if(curr.start <= last.end){
						last.end = Math.max(curr.end, last.end);
					}else{
						res.add(curr);
					}
				}
			}

			return res;
		}
	}

	public static void main(String[] args) {

	}

}
