package Lintcode.MultiThreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
����Ҫ��ӡ1��9��9�����֣���A�߳��ȴ�ӡ1��2��3��Ȼ����B�̴߳�ӡ4,5,6��Ȼ������A�̴߳�ӡ7��8��9. 
������кܶ��ֽⷨ����������ʹ��Condition��������⣨ʹ��Object��wait��notify�����Ľⷨ�����
 *
 */
public class Print_Integer_By_MultiThreads {

	static class NumberWrapper {
		public int value = 1;
	}

	public static void main(String[] args) {
		//��ʼ����������
		final Lock lock = new ReentrantLock();
		
		//��һ����������Ļ�������3
		final Condition reachThreeCondition = lock.newCondition();
		//�ڶ�����������Ļ�������6
		final Condition reachSixCondition = lock.newCondition();
		
		//NumberWrapperֻ��Ϊ�˷�װһ�����֣�һ�߿��Խ����ֶ���������������Ϊfinal
		//ע�����ﲻҪ��Integer, Integer �ǲ��ɱ����
		final NumberWrapper num = new NumberWrapper();
		//��ʼ��A�߳�
		Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {
				//��Ҫ�Ȼ����
				lock.lock();
				try {
					System.out.println("threadA start write");
					//A�߳������ǰ3����
					while (num.value <= 3) {
						System.out.println(num.value);
						num.value++;
					}
					//�����3ʱҪsignal������B�߳̿��Կ�ʼ��
					reachThreeCondition.signal();
				} finally {
					lock.unlock();
				}
				lock.lock();
				try {
					//�ȴ����6������
					reachSixCondition.await();
					System.out.println("threadA start write");
					//���ʣ������
					while (num.value <= 9) {
						System.out.println(num.value);
						num.value++;
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}

		});


		Thread threadB = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.lock();
					
					while (num.value <= 3) {
						//�ȴ�3�����ϵ��ź�
						reachThreeCondition.await();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
				try {
					lock.lock();
					//�Ѿ��յ��źţ���ʼ���4��5��6
					System.out.println("threadB start write");
					while (num.value <= 6) {
						System.out.println(num.value);
						num.value++;
					}
					//4��5��6�����ϣ�����A�߳�6�������
					reachSixCondition.signal();
				} finally {
					lock.unlock();
				}
			}

		});


		//���������߳�
		threadB.start();
		threadA.start();
	}

}
