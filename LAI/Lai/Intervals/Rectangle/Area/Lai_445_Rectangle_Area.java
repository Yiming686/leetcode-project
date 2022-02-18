package Lai.Intervals.Rectangle.Area;

public class Lai_445_Rectangle_Area {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int area1 = (C - A) * (D - B);
		int area2 = (G - E) * (H - F);

		if (C <= E || G <= A || H <= B || D <= F) {
			return area1 + area2;
		}
		int right = Math.min(C, G);
		int left = Math.max(A, E);
		int top = Math.min(D, H);
		int bottom = Math.max(B, F);

		return area1 + area2 - (right - left) * (top - bottom);

	}

}
