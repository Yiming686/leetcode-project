package JavaBasics;

public class Java_Two_While_Statements {
	
	public static void f1(int [] arr){
		int  i = 4;
		while(arr[i+1] == arr[i]){
			i++;
		};
		System.out.println(i);
	}
	public static void f2(int [] arr){
//		�˷������Ǵӵ�ǰiλ�ã��Ƶ���һ���͵�ǰarr[i]����ȵ�λ��
		int  i = 1;
		do{
			i++;
		}while(arr[i] == arr[i-1]);
		System.out.println(i);
		
	}
	
	public static void main(String[] args) {
		int [] arr = {1,2,2,2,2,6};
		f1(arr);
//		f2(arr);
	}
	
	
}
