package Leet.Interview;

import java.util.LinkedList;
import java.util.Queue;

public class Implement_Producer_Consumer_by_Wait_Notify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<>();
		int maxSize = 4; //容量

//        Main main = new Main();
		new Thread(new Producer(maxSize, queue)).start();
		new Thread(new Consumer(maxSize, queue)).start();

	}

	private static class Producer implements Runnable {
		private int maxSize;
		private final Queue<Integer> queue;//使用fianl只让queue关联一个对象，使synchronized只锁一个对象，而防止有变化

		public Producer(int maxSize, Queue<Integer> queue) {
			this.maxSize = maxSize;
			this.queue = queue;
		}

		@Override
		public void run() {
			for (int k = 0; k < 10; k++) {
				synchronized (queue) {
					while (queue.size() == maxSize) {
						try {
							System.out.println("Queue is full, Producer is waitting!");
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					System.out.println("Produce value: " + k);
					queue.offer(k);
					queue.notifyAll();
				}

			}
		}
	}

	private static class Consumer implements Runnable {
		private int maxSize;
		private final Queue<Integer> queue;

		public Consumer(int maxSize, Queue<Integer> queue) {
			this.maxSize = maxSize;
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							System.out.println("Queue is empty, Consumer is waitting!");
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					int x = queue.poll();
					System.out.println("Consumer value: " + x);
					queue.notifyAll();
				}
			}
		}
	}

}
