package Lintcode.Common.Questions;



/**
	//��ӡ��ָ������С��Fibonacci����
 *
 */
public class Print_Fibonacci_Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		printNumbers3(1);
//		printNumbers3(2);
		printNumbers3(3);
//			printNumbers3(200);
//			printNumbers3(100);
	}
	
	static void printNumbers3(int max) {
		if (max <= 1) {
			return;
		}
		int num1 = 1;
		int num2 = 1;

		int num = 1;
		//ѭ���жϱ���num
		//ѭ�����±���num1,num2,num
		System.out.println(num1);
		while (num < max) {
			//�����߼�
			System.out.println(num);
			//���±���
			num = num1 + num2;
			num1 = num2;
			num2 = num;
		}
	}

	
	//worked
	static void printNumbers2(int max){
	    int num1 = 1;
	    int num2 = 1;

	    if(max <= 1){
	        return;
	    }else if(max==2){
	        System.out.println(num1);
	        System.out.println(num2);
	        return;
	    }    
	    while(true){
	       int num = num1 + num2;
	       if(num > max) return;
	       System.out.println(num);
	       
	       num1 = num2;
	       num2 = num;
	    }
	}

}
