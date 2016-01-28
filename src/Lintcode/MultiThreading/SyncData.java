package Lintcode.MultiThreading;

import java.util.Random;

public class SyncData {
	private int data;// ��������

	public synchronized void set(int data) {
		System.out.println(Thread.currentThread().getName() + "׼��д������");
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.data = data;
		System.out.println(Thread.currentThread().getName() + "д��" + this.data);
	}

	public synchronized void get() {
		System.out.println(Thread.currentThread().getName() + "׼����ȡ����");
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "��ȡ" + this.data);
	}

	public static void main(String[] args) {
//      final Data data = new Data();    
		final SyncData data = new SyncData();
//      final RwLockData data = new RwLockData();    

		// д��
		for (int i = 0; i < 3; i++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 3; j++) {
						data.set(new Random().nextInt(30));
					}
				}
			});
			t.setName("Thread-W" + i);
			t.start();
		}
		// ��ȡ
		for (int i = 0; i < 3; i++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 5; j++) {
						data.get();
					}
				}
			});
			t.setName("Thread-R" + i);
			t.start();
		}
	}

}
