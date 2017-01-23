package Lintcode.MultiThreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
����Ҫ��ӡ1��9��9�����֣���A�߳��ȴ�ӡ1��2��3��Ȼ����B�̴߳�ӡ4,5,6��Ȼ������A�̴߳�ӡ7��8��9. 
������кܶ��ֽⷨ����������ʹ��Condition��������⣨ʹ��Object��wait��notify�����Ľⷨ�����
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
							//�ȴ�3�����ϵ��ź�
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
//					//�Ѿ��յ��źţ���ʼ���4��5��6
//					System.out.println("threadB start write");
//					while (num.value <= 6) {
//						System.out.println(num.value);
//						num.value++;
//					}
//					//4��5��6�����ϣ�����A�߳�6�������
//					reachSixCondition.signal();
//				} finally {
//					lock.unlock();
//				}
			}

		});


		//���������߳�
		threadB.start();
		threadA.start();
	}

}
