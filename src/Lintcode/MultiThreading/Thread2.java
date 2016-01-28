package Lintcode.MultiThreading;

public class Thread2 implements Runnable{
	private volatile static Integer count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Thread2(Integer count) {
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
