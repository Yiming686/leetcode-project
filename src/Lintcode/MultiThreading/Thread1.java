package Lintcode.MultiThreading;

public class Thread1 implements Runnable{
	private volatile Integer count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Thread1(Integer count) {
		super();
		this.count = count;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + "is Running!");
		count--;
	}

}
