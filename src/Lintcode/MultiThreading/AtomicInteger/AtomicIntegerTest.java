package Lintcode.MultiThreading.AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
//	private static AtomicInteger count = new AtomicInteger(0);
	private static Integer count = new Integer(0);
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int num = 2000;
		Thread[] arr = new Thread[num];
		for(int i = 0; i<num; i++){
			arr[i] = new Thread(new IncrementAtomicInteger(count));
			arr[i].start();
		}
		for(int i = 0; i<num; i++){
			arr[i].join();;
		}

		System.out.println("count: "+count);
		
//		if(num!=count.get()){
		if(num!=count){
			System.out.println("==========================================================");
			System.out.println("==========================================================");
			System.out.println("  num: "+num);
			System.out.println("count: "+count);
		}
	}
	

}
 class IncrementAtomicInteger implements Runnable{
//	 private static AtomicInteger count;
	 private static Integer count = 0;
//	IncrementAtomicInteger(AtomicInteger count){
	IncrementAtomicInteger(Integer count){
		 this.count = count;
	 }

	public void run() {
		try {
			Thread.sleep(100L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		count.getAndIncrement();
			count++;
	}
}
