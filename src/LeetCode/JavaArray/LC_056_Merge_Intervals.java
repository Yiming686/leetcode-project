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

//��չ��
//	1.�ҳ�����ص�intervals
//2.�ҳ�����interval�ĳ���
//	3.����ʱ�����䣬�ҳ��Ƿ������ܹ��μ����л���
// ʲôʱ�䣬��Ҫcomparator��Ҫ�Ƚ�endֵ
//�����������䣬����С��������Ŀ��
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
//sort ԭʼ����
			Collections.sort(intervals, cmp);

			for (int i = 0; i < intervals.size(); i++) {
				Interval curr = intervals.get(i);
				if (res.isEmpty()) {
					res.add(curr);
				} else {
					Interval last = res.get(res.size() - 1);
//					��list ��������һ���͵�ǰ���бȽ�
//					�]�н�����ֱ�Ӽ��룻����н������������end�� ������start����Ϊ�Ѿ��������
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
