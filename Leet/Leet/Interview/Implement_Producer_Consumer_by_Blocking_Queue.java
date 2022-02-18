package Leet.Interview;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Implement_Producer_Consumer_by_Blocking_Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue sharedQueue = new LinkedBlockingQueue();

		//Creating Producer and Consumer Thread
		Thread prodThread = new Thread(new Producer(sharedQueue));
		Thread consThread = new Thread(new Consumer(sharedQueue));

		//Starting producer and Consumer thread
		prodThread.start();
		consThread.start();

	}

	private static class Producer implements Runnable {

		private final BlockingQueue sharedQueue;

		public Producer(BlockingQueue sharedQueue) {
			this.sharedQueue = sharedQueue;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					System.out.println("Produced: " + i);
					sharedQueue.put(i);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	private static class Consumer implements Runnable {

		private final BlockingQueue sharedQueue;

		public Consumer(BlockingQueue sharedQueue) {
			this.sharedQueue = sharedQueue;
		}

		@Override
		public void run() {
			while (true) {
				try {
					System.out.println("Consumed: " + sharedQueue.take());
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}
