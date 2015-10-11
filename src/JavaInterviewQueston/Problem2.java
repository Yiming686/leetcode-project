package JavaInterviewQueston;

import java.util.Arrays;

public class Problem2 {

	public static double[]  predict3(double[] s1, double[] s2){
		int len = s1.length;
		double[] bestPred1 = new double[len];
		bestPred1[0] = (s1[0] + s2[0])/2;
		for(int i = 1; i < len; i ++){
			double k1 = s1[i] - s1[i-1];
			double k2 = s2[i] - s2[i-1];
			double k = (k1 + k2)/2;
			bestPred1[i] = bestPred1[i-1] + k; 	
		}
		return null;
	}
	
	public static double[]  predict2(double[] s1, double[] s2){
		int len = s1.length;
		double[] bestPred2 = new double[len];
		bestPred2[0] = (s1[0] + s2[0])/2;
		bestPred2[1] = ((s1[1] - s1[0]) + (s2[1] - s2[0]))/2 + bestPred2[0];
		for(int i = 2; i < 5; i ++){
			double k1 = ((s1[i] - s1[i-1]) + (s1[i-1] - s1[i-2]))/2;
			double k2 = ((s2[i] - s2[i-1]) + (s2[i-1] - s2[i-2]))/2;
			System.out.println((k1+k2)/2 + "  "+ bestPred2[i-1]);

			bestPred2[i] = (k1+k2)/2 + bestPred2[i-1]; 	
		}
		System.out.println(Arrays.toString(bestPred2));
		return null;
	}
	
	public static double[]  predict(double[] s1, double[] s2){
		System.out.println(Arrays.toString(s1));
		System.out.println(Arrays.toString(s2));
		int len = s1.length;
		double[] bestEst = new double[len];
		for(int i = 0; i < 5; i ++){
			bestEst[i] = (s1[i] + s2[i])/2;
		}
		for(int i = 5; i < len; i ++){
			bestEst[i] = s1[i] - s1[i-1] + bestEst[i-1] ;
			s2[i] = s1[i] - s1[i-1] + s2[i-1];
		}
		
		System.out.println(Arrays.toString(s2));
		System.out.println(Arrays.toString(bestEst));
		return s2;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] s1 = { 4.47, 8.50, 12.8, 17.0, 24.5, 37.3, 40.0, 40.0 };
		double[] s2 = { 4.44, 8.45, 12.2, 16.6, 23.8, 0, 0, 0 };
		double[] s3 = { 9.00, 17.0, 26.0, 34.0, 48.0, 55.0, 60.0, 60.0 };
		double[] s4 = { 8.39, 16.5, 24.0, 31.2, 43.4, 0, 0, 0 };
		double[] s5 = { 13.9, 26.2, 36.8, 48.0, 55.0, 60.0, 60.0, 60.0 };
		double[] s6 = { 12.2, 24.1, 34.3, 44.2, 58.3, 0, 0, 0 };
		double[] s7 = { 18.0, 32.0, 44.0, 55.0, 60.0, 60, 60.0, 60.0 };
		double[] s8 = { 16.4, 31.1, 43.5, 55.8, 71.5, 0, 0, 0 };
		
		predict(s1, s2);
		predict(s3, s4);
		predict(s5, s6);
		predict(s7, s8);
		

	}

}
