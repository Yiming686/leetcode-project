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
	// ���Ǹ�������Ŀ��
	//�����д����������Ҳ�д���
	//	
	// ���ǿ���ѭ��ʵ�ֵĶ��ֿ�����:���ֶַΣ�ѭ�����߼��ֶκ�ѭ�������ֶΣ�ǰ����������߲�������������ʱ����������Ǳ����
	// ���ѭ�����߼��ֶΣ������ǷֶΣ����˷ֶΣ�û���κι����߼�����ô��ȫ�Ϳ���ת��Ϊѭ�������ֶ�
	//
	// һ��forѭ����ѭ����������ֵ���ж�������ѭ�����߼���ѭ���������ġ���������if-else��䣬��ôÿ�α����ı䣬��Ҫִ�������ÿһ��������
	// Ҳ����˵����վ�ڶԴ�ÿһ������ͬ�ȵĴ����߼�������������벻ͬѭ���������߼���ͬ���������
	// �����ֶδ��������ѭ�������ֶΣ�Ȼ�����ÿһ����������зֶδ�����ʱ���Կ���while���
	// ����Ŀ����������� (int i = 0; i < intervals.size(); i++)����һ��ͬ��.
	//
	//����whileѭ������һ����ֱ�Ӽ����������䣬�ڶ������ϵ��������䣬Ȼ����������������������������ȼ��������䣬Ȼ��ѭ�����к����
//	��ΪҪ����ѭ����Ĵ�������Ҫע����Ӵ���
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

	// �����Դ��ⷨ����ʱδ���
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
