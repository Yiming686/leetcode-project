package Lintcode.BinarySearch;

public class Search_in_Rotated_Sorted_Array {
	// Best solution, worked
	public static int search5(int[] A, int target) {
		// write your code here
		if (A == null || A.length == 0)
			return -1;
		int start = 0, end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			}
			// ���ź�����ˣ����������
			boolean isGreaterThanStart = A[mid] > A[start];
			boolean isFromStartToMid = A[start] <= target && target <= A[mid];
			boolean isFromMidToEnd =     A[mid] <= target && target <= A[end];

			if (isGreaterThanStart && isFromStartToMid || !isGreaterThanStart && !isFromMidToEnd) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		if (A[start] == target)
			return start;
		if (A[end] == target)
			return end;
		return -1;
	}

	// һ�����ֽⷨ�����ԣ�Ψһ�������:ֻ��һ���ط�start��Ϊend
	// worked
	public static int search(int[] A, int target) {
		// write your code here
		if (A == null || A.length == 0)
			return -1;
		int start = 0, end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			}
			// search a target,ΪʲôҪ��start�Ƚ�?�ɲ����Ժ�end�Ƚ�
			// ���ǿ���
			if (A[start] < A[mid]) {
				// situation 1, red line
				// qub
				if (A[start] <= target && target <= A[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				// situation 2, green line
				if (A[mid] <= target && target <= A[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		if (A[start] == target)
			return start;
		if (A[end] == target)
			return end;
		return -1;
	}

	// worked
	public static int search3(int[] A, int target) {
		// write your code here
		if (A == null || A.length == 0)
			return -1;
		int start = 0, end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			}
			// search a target,ΪʲôҪ��start�Ƚ�?�ɲ����Ժ�end�Ƚ�
			if (A[end] < A[mid]) {
				// situation 1, red line
				// qub
				if (A[start] <= target && target <= A[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				// situation 2, green line
				if (A[mid] <= target && target <= A[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		if (A[start] == target)
			return start;
		if (A[end] == target)
			return end;
		return -1;
	}

	// not worked
	public int search9(int[] A, int target) {
		// write your code here
		if (A == null || A.length == 0)
			return -1;
		int start = 0, end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			}
			if (A[start] < A[end]) {
				if (A[mid] < target) {
					start = mid;
				} else {
					end = mid;
				}
			} else {
				if (A[end] < target) {
					if (A[mid] >= target) {
						end = mid;
					} else {
						start = mid;
					}
				} else {
					if (A[mid] > target) {
						end = mid;
					} else {
						start = mid;
					}
				}
			}
		}
		if (A[start] == target)
			return start;
		if (A[end] == target)
			return end;
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
