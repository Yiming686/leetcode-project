package Lintcode.MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.sun.corba.se.impl.presentation.rmi.StubFactoryFactoryStaticImpl;

/**
Salesforce Interview Question for Software Engineers

There are three threads in a process. 
The first thread prints 1 1 1 бн, the second one prints 2 2 2 бн, and the third one prints 3 3 3 бн endlessly. 
How do you schedule these three threads in order to print 1 2 3 1 2 3 бн?

- jim.shan.JS May 15, 2015 in United States | Report Duplicate | Flag 
Salesforce Software Engineer Threads

 *
 */
public class Print_1_2_3_Endlessly {

	volatile  int max = 40;
	
	public static void main(String[] args) {
		
		final Lock lock = new ReentrantLock();
		final Condition condition = lock.newCondition();

		ThreadId threadId = new Print_1_2_3_Endlessly.ThreadId();
		threadId.setId(1);
		List<Integer> num = new ArrayList<Integer>();
		num.add(30);
		Thread t1 = createThread(lock, condition, 1, 2, threadId ,num);
		Thread t2 = createThread(lock, condition, 2, 3, threadId,num);
		Thread t3 = createThread(lock, condition, 3, 1, threadId,num);
		t1.start();
		t2.start();
		t3.start();

	}

	private static class ThreadId {
		private int id;

		public ThreadId() {
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}

	private static Thread createThread(final Lock lock, final Condition condition, final int actualThreadId,final int nextThreadId,
			final ThreadId threadId, final List<Integer> num) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				while (num.get(0) > 0) {
					lock.lock();
					try {
						while (threadId.getId() != actualThreadId)
							try {
								condition.await();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						System.out.println("" + actualThreadId);
						num.set(0, num.get(0)-1);
						threadId.setId(nextThreadId);
						condition.signalAll();
					} finally {
						lock.unlock();
					}
				}
			}
		};
		return thread;
	}

}
