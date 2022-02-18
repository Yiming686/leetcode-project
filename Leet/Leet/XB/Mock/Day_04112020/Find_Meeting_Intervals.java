package Leet.XB.Mock.Day_04112020;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

public class Find_Meeting_Intervals {

	public static void main(String[] args) {
		Map<Integer, List<Interval>> map = new HashMap<>();//intervals are sorted by start time
		int meetingDuration = 2; //hours
		List<Interval> list1 = new ArrayList<>();
		list1.add(new Interval(1, 3));
		list1.add(new Interval(5, 9));
		list1.add(new Interval(11, 15));
		map.put(1, list1);
		List<Interval> list2 = new ArrayList<>();
		list2.add(new Interval(2, 8));
		map.put(2, list2);
		List<Interval> list3 = new ArrayList<>();
		list3.add(new Interval(6, 11));
		list3.add(new Interval(13, 14));
		map.put(3, list3);

		findMeeting(map, meetingDuration);
	}

	private static List<Interval> findMeeting(Map<Integer, List<Interval>> map, int meetingDuration) {
		List<Interval> result = new ArrayList<>();
		int k = map.size();
		int[] pointers = new int[k];
		PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				if(c1.time != c2.time) {
					return c1.time - c2.time;
				}
				return c1.type = c2.type;
			}
		});
		for(Map.Entry<Integer, List<Interval>> entry : map.entrySet()) {
			int id = entry.getKey();
			List<Interval> list = entry.getValue();
			int index = 0;
			Interval i0 = list.get(index);
			pq.add(new Cell(id, 0, i0.start, 1));
		}
		int count = 0;
		Integer newStart = null;
		while(!pq.isEmpty()) {
			Cell cell = pq.poll();
			if(cell.type == 1) {
				if(count == k-1) {
					//new start
					newStart = cell.time;
				}else {
					
				}
				count++;//must ++
			}else {
				if(count == k) {
					//new end
					result.add(new Interval(newStart, cell.time));
				}
				count--;
			}
			//find rightward adjacent cell
			List<Interval> list = map.get(cell.id);
			if(cell.index < list.size() - 1 || (cell.index == list.size() - 1 && cell.type == 1) ) {
				//must have adjacent one
				if(cell.type == 1) {
					cell.type = -1;
					cell.time = list.get(cell.index).end;
					pq.add(cell);	
				}
				
			}
		}
		return null;
	}

	private static class Cell {
		int id;
		int index;
		int time;
		int type;
		Cell(int id, int index, int time, int type) {
			this.id = id;
			this.index = index;
			this.time = time;
			this.type = type;
		}
	}
	private static class Interval {
		int start;
		int end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

}
