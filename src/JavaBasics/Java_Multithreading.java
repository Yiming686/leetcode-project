package JavaBasics;

public class Java_Multithreading {

static class A implements Runnable{
	private int a;
	
	public synchronized void print(){
		try {

			System.out.printf("TN:%s, MSG:%s \n",Thread.currentThread().getName(),"wait...---------------------1");
			this.wait(999);
			System.out.printf("TN:%s, MSG:%s \n",Thread.currentThread().getName(),"aweak---------------------2");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			System.out.printf("TN:%s, MSG:%s \n",Thread.currentThread().getName(),"wait...---------------3");
			this.wait(999);
			System.out.printf("TN:%s, MSG:%s \n",Thread.currentThread().getName(),"aweak---------------------4");
 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("TN:%s, MSG:%s \n",Thread.currentThread().getName(),"End... print1 in A -----------5");

	};
	public synchronized void print2(){
		try {
			this.wait(9999);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("print2 in A 2 ...");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		print();
	};
}
static class B implements Runnable{
	private int b;
	
	public synchronized void print(){
		System.out.println("print in B ...");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		print();
	};
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		A a1 = new A();
		new Thread(a).start();
		new Thread(a).start();
	}

}
