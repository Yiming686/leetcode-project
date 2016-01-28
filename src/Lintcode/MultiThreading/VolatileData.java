package Lintcode.MultiThreading;

public class VolatileData {

	private  int counter;
	public int getCounter() {
		return counter;
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}

	public void increaseCounter() {
		++counter;
	}
	public void decreaseCounter() {
		--counter;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
