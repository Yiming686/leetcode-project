package Java.DesignPatterns.Singleton;

import java.io.Serializable;

public class Singleton implements Serializable{
	public int a = 99;
	private static final Singleton INSTANCE = null;
	private Singleton(){
		System.out.println("Info in Private Singleton Constructor!");
	}//must provide: private constructor
	
	//must provide: static inner class
	private static class SingletonHolder{
		//must provide: static final instance
		private static final Singleton INSTANCE = new Singleton();
	}
	
	//must provide: static public method
	public static Singleton getInstance(){
		return SingletonHolder.INSTANCE;
	}
	public static String print() {
		return "Print() in Singleton: ...... !";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Singleton in = Singleton.getInstance();
		System.out.println(""+in.a);
	}

	
	
}
