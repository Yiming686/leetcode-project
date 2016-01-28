package Lintcode.MultiThreading;

public class Thread4 implements Runnable{
	private volatile Integer count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Thread4(Integer count) {
		super();
		this.count = count;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + "is Running!");
	}

}
