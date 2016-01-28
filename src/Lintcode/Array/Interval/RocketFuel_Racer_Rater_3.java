package Lintcode.Array.Interval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

		//��һ��������õ� SpaceShip[] spaceShips
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
		//�ڶ�����cloneһ�ݣ����տ�ʼʱ������
		SpaceShip[] spaceShipsSortByStartTime = spaceShips.clone();
		Arrays.sort(spaceShipsSortByStartTime, new Comparator<SpaceShip>() {
			@Override
			public int compare(SpaceShip ss1, SpaceShip ss2) {
				return ss1.startTime.compareTo(ss2.startTime);
			}
		});
		//��������cloneһ�ݣ����ս���ʱ������
		SpaceShip[] spaceShipsByEndTime = spaceShips.clone();
		Arrays.sort(spaceShipsByEndTime, new Comparator<SpaceShip>() {
			@Override
			public int compare(SpaceShip ss1, SpaceShip ss2) {
				return ss1.endTime.compareTo(ss2.endTime);
			}
		});
		//���Ĳ��������µ�list
		List<SpaceShip> listByStartTime = new ArrayList<SpaceShip>();
		listByStartTime.add(spaceShipsByEndTime[0]);
		for (int i = 1; i < spaceShipsByEndTime.length; ++i) {
			SpaceShip ss = spaceShipsByEndTime[i];
			int numBeforeEndTime = listByStartTime.size();
			int indexToInsert = getIndexToInsert(listByStartTime, ss);
			ss.score = numBeforeEndTime - indexToInsert;
			listByStartTime.add(indexToInsert, ss);
		}

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

	
	//����һ��list��Ѱ��Ԫ�صĲ���λ�ã�index:0--n-1,����ܲ���λ��0--n-1��n
//	�������ȵĻ���������ȵ�λ�ò��뼴��
	//���������Ԫ�ض�С�أ������һ��λ��; ���������Ԫ�ض��󣬲������һ��λ��
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
	
	//����һ��list��Ѱ��Ԫ�صĲ���λ�ã�index:0--n-1,����ܲ���λ��0--n-1��n
	//�������ȵĻ���������ȵ�λ�ò��뼴��
	//���������Ԫ�ض�С�أ������һ��λ��; ���������Ԫ�ض��󣬲������һ��λ��
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
