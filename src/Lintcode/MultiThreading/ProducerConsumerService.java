package Lintcode.MultiThreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        BlockingQueue<Message> queue = new ArrayBlockingQueue<Message>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        //starting producer to produce messages in queue
        new Thread(producer).start();
        //starting consumer to consume messages from queue
        new Thread(consumer).start();
        System.out.println("Producer and Consumer has been started");
	}

}
