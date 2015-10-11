package JavaInterviewQueston;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Random;

public class Program1b {

	private static String calculateSum(String sum, String valueOf) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(0.06+0.01);
//		System.out.println(1.0-0.42);
//		System.out.println(4.015*100);
//		System.out.println(303.1/1000);
//		
		System.out.println(BigDecimal.valueOf(0.06).add(BigDecimal.valueOf(0.01)));
		System.out.println(BigDecimal.valueOf(1.0).subtract(BigDecimal.valueOf(0.42)));
		System.out.println(BigDecimal.valueOf(4.015).multiply(BigDecimal.valueOf(100)));
		System.out.println(BigDecimal.valueOf(303.1).divide(BigDecimal.valueOf(1000)));

		
//		A[32] = [4.44, 8.45, 12.2, 16.6, 23.8, 31.0, 34.3, 38.8, 8.39, 16.5, 24.0, 31.2, 43.4, 55.2, 58.3, 62.2, 12.2, 24.1, 34.3, 44.2, 58.3, 72.4, 78.3, 82.9, 16.4, 31.1, 43.5, 55.8, 71.5, 82.2, 84.7, -1.00];
		double[] A = {4.44, 8.45, 12.2, 16.6, 23.8, 31.0, 34.3, 38.8, 8.39, 16.5, 24.0, 31.2, 43.4, 55.2, 58.3, 62.2, 12.2, 24.1, 34.3, 44.2, 58.3, 72.4, 78.3, 82.9, 16.4, 31.1, 43.5, 55.8, 71.5, 82.2, 84.7, -1.00};
		int N = 30;
		int[] arr = new int[N];
		//	initiate arr
		for(int i = 0 ; i < N; i ++){
			arr[i] = new Random().nextInt(31);
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(A));
		
		String[] ss = new String[A.length];
		for(int i = 0; i< A.length; i ++){
			ss[i] = String.valueOf(A[i]);
		}
		System.out.println(Arrays.toString(ss));
		
		BigDecimal sum2  = BigDecimal.valueOf(A[arr[0]]);
		for (int i = 1; i < N; i++) {
			sum2 = sum2.add(BigDecimal.valueOf(A[arr[i]]));
		}
		System.out.println("sum2:"+sum2);
		System.out.println("avg2:"+sum2.divide(BigDecimal.valueOf(N), RoundingMode.HALF_UP));

		System.out.println("avg2:"+sum2.divide(BigDecimal.valueOf(N)));
		
		System.out.println("avg2:"+sum2.divide(BigDecimal.valueOf(N),RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP));
		
		long[] ALong = new long[A.length];
		for(int i = 0; i < A.length; i ++){
			ALong[i] = (long)(100*A[i]);
		}
//		8.45, 34.3,38.8,34.3,16.4,
//		System.out.println((double)(100*8.45));
//		System.out.println((double)(100*34.3));
//		System.out.println(Arrays.toString(ALong));

		
		long sum = (long)(100*A[0]);
		for(int i = 2; i < N; i ++){
			sum += (long)(100*A[arr[i]]);
		}
//		sum = 102032;
//		sum = 148996;
//		sum = 93894;
		System.out.println(sum);
		System.out.println(N);
//		System.out.println(sum/(N*1.0));
		System.out.println((sum/N)/100.);
//		System.out.println(sum/N/100.000);
		
		BigDecimal val = new BigDecimal(sum/100.);
		System.out.println(val);
		val = val.divide(new BigDecimal(N), RoundingMode.HALF_EVEN);
		System.out.println(val);
		val = val.setScale(2, RoundingMode.HALF_EVEN);
		System.out.println(val);
		System.out.println(val.doubleValue());
		
		BigDecimal val2 = new BigDecimal(sum/100./N);
		System.out.println(val2);
		val2 = val2.setScale(2, RoundingMode.HALF_EVEN);
		System.out.println(val2);
		System.out.println(val2.doubleValue());
	}



//	private static long calculateSum(long long1, long long2) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
