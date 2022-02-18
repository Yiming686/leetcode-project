package Leet.XB.Mock.Day_04112020;

import static Utils.LinkedListUtils.buildIntLinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.events.EntityReference;


public class Is_Id_Expired_In_Log {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Entry e1 = new Entry(1, 0, true);
		Entry e2 = new Entry(2, 1, true);
		Entry e3 = new Entry(3, 1, true);
		Entry e4 = new Entry(2, 2, false);
		Entry e5 = new Entry(4, 3, true);
		Entry e6 = new Entry(3, 3, false);
		Entry e7 = new Entry(4, 4, false);
		List<Entry> streams = new ArrayList<Entry>();
		streams.add(e1);
		streams.add(e2);
		streams.add(e3);
		streams.add(e4);
		streams.add(e5);
		streams.add(e6);
		streams.add(e7);
		for(Entry entry : streams) {
			//current time, read an entry
			Integer id = entry.id;
			Integer timeStamp = entry.timeStamp;
			Integer startTime = map.get(id);
			if(entry.isStart) {// is start time
				if(startTime == null) {
					map.put(id, entry.timeStamp);// find curr start time
				}else if(startTime + expirationTime >= timeStamp){
					ids.add(id);//not end yet, but expired
				}else {
					//exception, double start
				}	
			}else {//is end time
				if(startTime == null) {
					//not exist, exception
				}else if(){
					
				}
			}
			
			
			System.out.println("ids: "+expiredIds());
		}
	}
	private static int expirationTime = 3;
	private static Map<Integer, Integer> map = new HashMap<>(); //id to start time
	private static List<Integer> ids = new ArrayList<Integer>();

	public static List<Integer> expiredIds() {
		return ids;
	}

	private static class Entry {
		private int id;
		private int timeStamp;
		private boolean isStart;

		public Entry(int id, int timeStamp, boolean isStart) {
			this.id = id;
			this.timeStamp = timeStamp;
			this.isStart = isStart;
		}
	}
}
