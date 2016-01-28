package JavaInterviewQueston;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.internal.runners.InitializationError;

import com.sun.media.jai.opimage.MinCRIF;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import sun.awt.im.InputMethodJFrame;

public class RocketFuel_Racer_Rater_3 {
	long id;
	String name;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		RocketFuel_Racer_Rater_3 other = (RocketFuel_Racer_Rater_3) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	static class SpaceShip {
		Long id;
		Long startTime;
		Long endTime;
		int score;

		public SpaceShip(Long id, Long startTime, Long endTime) {
			this.id = id;
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}

	public static void main(String[] args) throws IOException {
//		int [] arr2 = {2,6,3,2,3,0};
//		Arrays.sort(arr2);
//		System.out.println(""+Arrays.toString(arr2));
//		int val = 9;
//		System.out.println(""+getIndexToInsert(arr2,val));
//		System.out.println(""+getIndexToInsert(arr2,2));
//		System.out.println(""+getIndexToInsert(arr2,6));
//		System.out.println(""+getIndexToInsert(arr2,7));

		//第一步：输入得到 SpaceShip[] spaceShips
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int len = Integer.parseInt(line);
		SpaceShip[] spaceShips = new SpaceShip[len];
		int index = 0;
		while ((line = br.readLine()) != null) {
			String arr[] = line.trim().split(" ");
			spaceShips[index] = new SpaceShip(Long.valueOf(arr[0]), Long.valueOf(arr[1]), Long.valueOf(arr[2]));
			index++;
		}
		//第？步：clone一份，按照开始时间排序，这一步没没有用
		SpaceShip[] spaceShipsSortByStartTime = spaceShips.clone();
		Arrays.sort(spaceShipsSortByStartTime, new Comparator<SpaceShip>() {
			@Override
			public int compare(SpaceShip ss1, SpaceShip ss2) {
				return ss1.startTime.compareTo(ss2.startTime);
			}
		});
		//第二步：clone一份，按照结束时间排序，
		SpaceShip[] spaceShipsByEndTime = spaceShips.clone();
		Arrays.sort(spaceShipsByEndTime, new Comparator<SpaceShip>() {
			@Override
			public int compare(SpaceShip ss1, SpaceShip ss2) {
				return ss1.endTime.compareTo(ss2.endTime);
			}
		});
		//第四步：建立一个新的递增list，按照开始时间排序，不然不能找到插入index
		//利用这个list来计算score的这个是核心，但是好像没有考虑数值 重复的问题
		List<SpaceShip> listByStartTime = new ArrayList<SpaceShip>();//此list根据start time来排序的
		listByStartTime.add(spaceShipsByEndTime[0]);
		for (int i = 1; i < spaceShipsByEndTime.length; ++i) {
			SpaceShip ss = spaceShipsByEndTime[i];
			int numBeforeEndTime = listByStartTime.size();//比当前ss早结束的有几个？范围：1--n-1
			int indexToInsert = getIndexToInsert(listByStartTime, ss);//范围：0--n
			ss.score = numBeforeEndTime - indexToInsert;//计算当前ship的score
			listByStartTime.add(indexToInsert, ss);//将ss插入应该的位置根据starttime
		}
		//第五步：这一步才是根据题意，按照score排序的
		SpaceShip[] spaceShipsByScore = spaceShips.clone();
		Arrays.sort(spaceShipsByScore, new Comparator<SpaceShip>() {
			@Override
			public int compare(SpaceShip ss1, SpaceShip ss2) {
				int scDiff = ss1.score - ss2.score;
				if (scDiff != 0)
					return scDiff;
				return ss1.id.compareTo(ss2.id);
			}
		});

		for (SpaceShip ss : spaceShipsByScore)
			System.out.println(ss.id + " " + ss.score);

	}

	
	//对于一个list，寻找元素的插入位置，index:0--n-1,则可能插入位置0--n-1，n
//	如果有相等的话，任意相等的位置插入即可
	//如果比所有元素都小呢，插入第一个位置; 如果比所有元素都大，插入最后一个位置
	private static int getIndexToInsert(List<SpaceShip> listByStartTime, SpaceShip ss) {
		int left = 0;
		int right = listByStartTime.size() - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (ss.startTime == listByStartTime.get(mid).startTime)
				return mid;
			if (ss.startTime < listByStartTime.get(mid).startTime)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return left;
	}
	
	//对于一个list，寻找元素的插入位置，index:0--n-1,则可能插入位置0--n-1，n
	//如果有相等的话，任意相等的位置插入即可
	//如果比所有元素都小呢，插入第一个位置; 如果比所有元素都大，插入最后一个位置
	private static int getIndexToInsert(int[] arr, int val) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (val == arr[mid])
				return mid;
			if (val < arr[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return left;
	}

}
