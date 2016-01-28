package Lintcode.MultiThreading;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class ControlThreadOrderService {
	private volatile Integer count = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ControlThreadOrderService().test();
	}
	
	public void test(){
		Thread thread1 = new Thread(new Thread1(count));
		Thread thread2 = new Thread(new Thread2(count));
		Thread thread3 = new Thread(new Thread3(count));
		Thread thread4 = new Thread(new Thread4(count));
		thread1.start();
		thread2.start();
		thread3.start();
		while(count == 0){
			thread4.start();	
		}
	}

}
