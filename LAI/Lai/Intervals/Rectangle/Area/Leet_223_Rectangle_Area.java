package Lai.Intervals.Rectangle.Area;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as
 * shown in the figure.
 * 
 * Rectangle Area
 * 
 * Example:
 * 
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2 Output: 45
 * Note:
 * 
 * Assume that the total area is never beyond the maximum possible value of int.
 *
 * 
 * 
 */
public class Leet_223_Rectangle_Area {

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
