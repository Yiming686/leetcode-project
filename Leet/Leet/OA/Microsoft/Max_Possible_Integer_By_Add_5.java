package Leet.OA.Microsoft;

public class Max_Possible_Integer_By_Add_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int num = 268;// to 5268 //5758 to 
		int num = 670;
//		int num = 0;
//		int num = -999;
//		int num = -14391;
//		int num = 666;
//		5268
//		6750
//		50
//		-5999
//		-1591
//		6665
		System.out.println(maxNumber(num));
//		System.out.println(maxNumber(num2));
//		System.out.println(maxNumber(num3));
//		System.out.println(maxNumber(num4));
//		System.out.println(maxNumber(num5));
//		System.out.println(maxNumber(num6));
		
	}

	private static int maxNumber(int N) {
		// TODO Auto-generated method stub
//        StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(N)));
        StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(N)));
//		StringBuilder sb = new StringBuilder(String.valueOf(N));
		int flag = N >= 0 ? 1 : -1;
		if (N >= 0) {
			int startIndex = 0;
			while (startIndex < sb.length() && (sb.charAt(startIndex) - '0') >= 5) {//�ҵ���һ��С��5��λ�ã��滻����Ȼ��󣬵���ʱ��������ƶ�
				startIndex++;
			}
			sb.insert(startIndex, 5);//����һ��С��5��λ�ò���
		} else {
			int startIndex = 0;
			while (startIndex < sb.length() && (sb.charAt(startIndex) - '0') <= 5) {//�ҵ���һ������5��λ�ã��滻����Ȼ��С��//'-' <= 5
				startIndex++;
			}
			sb.insert(startIndex, 5);//����һ������5��λ�ò���
		}
		int val = Integer.parseInt(sb.toString());
        return flag * val;

	}

}
