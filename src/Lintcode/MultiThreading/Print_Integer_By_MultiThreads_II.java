package Lintcode.MultiThreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
我们要打印1到9这9个数字，由A线程先打印1，2，3，然后由B线程打印4,5,6，然后再由A线程打印7，8，9. 
这道题有很多种解法，现在我们使用Condition来做这道题（使用Object的wait，notify方法的解法在这里）
 *
 */
public class Print_Integer_By_MultiThreads_II {

	static class NumberWrapper {
		public int value =1;
	}

	public static void main(String[] args) {
		
		final Lock lock = new ReentrantLock();
		final Condition reachThreeCondition = lock.newCondition();
		final Condition reachSixCondition = lock.newCondition();

		int max = 100;
		int interval = 3;
		
		final NumberWrapper num = new NumberWrapper();
		
		Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					lock.lock();
					try {
						while (num.value <=99 && (num.value-1)/2 %2 == 0) {
							System.out.println("A: " + num.value);
							num.value++;
						}
						if(num.value >= 99) break;
						reachThreeCondition.signal();
					} finally {
						lock.unlock();
					}
				}
			}

		});


		Thread threadB = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					lock.lock();
					try {
						while (num.value <=99 &&  (num.value-1)/2%2 == 0) {
							//等待3输出完毕的信号
							reachThreeCondition.await();
						}
						while (num.value <=99 &&  (num.value-1)/2 %2 ==1) {
							System.out.println("B: " + num.value);
							num.value++;
						}
						if(num.value >= 96) break;
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}
					
					
				}
//				try {
//					lock.lock();
//					//已经收到信号，开始输出4，5，6
//					System.out.println("threadB start write");
//					while (num.value <= 6) {
//						System.out.println(num.value);
//						num.value++;
//					}
//					//4，5，6输出完毕，告诉A线程6输出完了
//					reachSixCondition.signal();
//				} finally {
//					lock.unlock();
//				}
			}

		});


		//启动两个线程
		threadB.start();
		threadA.start();
	}

}
