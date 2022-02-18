package Lai.Quick_Select;

public class Lai_203_Median_Of_Two_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double median(int[] a, int[] b) {
		// Write your solution here
		int lenA = a.length;
		int lenB = b.length;
		int len = lenA + lenB;
		if (len % 2 != 0) {
			return findKth(a, b, 0, len - 1, len / 2 + 1) * 1.0;
		} else {
			return (findKth(a, b, 0, len - 1, len / 2) + findKth(a, b, 0, len - 1, len / 2 + 1)) / 2.0;
		}
	}

	private int findKth(int[] a, int[] b, int start, int end, int k) {
		int pos = partition(a, b, start, end);
		if (pos == k - 1) {
			return getVal(a, b, pos);
		} else if (pos < k - 1) {
			return findKth(a, b, pos + 1, end, k);
		} else {
			return findKth(a, b, start, pos - 1, k);
		}
	}

	private int partition(int[] a, int[] b, int start, int end) {
		int pivot = getVal(a, b, end);
		int pivotPos = end;
		int left = start;
		int right = end - 1;
		while (left <= right) {
			if (getVal(a, b, left) < pivot) {
				left++;
			} else {
				swap(a, b, left, right);
				right--;
			}
		}
		swap(a, b, left, pivotPos);
		return left;
	}

	private void swap(int[] a, int[] b, int pos1, int pos2) {
		int temp = getVal(a, b, pos1);
		setVal(a, b, pos1, getVal(a, b, pos2));
		setVal(a, b, pos2, temp);
	}

	private int getVal(int[] a, int[] b, int pos) {
		if (a.length > 0 && pos < a.length) {
			return a[pos];
		}
		return b[pos - a.length];
	}

	private void setVal(int[] a, int[] b, int pos, int val) {
		if (a.length > 0 && pos < a.length) {
			a[pos] = val;
		}
		b[pos - a.length] = val;
	}

}
