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
//		此方法就是从当前i位置，移到第一个和当前arr[i]不相等的位置
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
