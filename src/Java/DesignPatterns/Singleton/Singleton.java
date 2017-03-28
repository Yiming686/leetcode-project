package Java.DesignPatterns.Singleton;

public class Singleton {

	private Singleton(){
		
	}//must provide: private constructor
	
	//must provide: static inner class
	private static class SingletonHolder{
		//must provide: static final instance
		private static final Singleton instance = new Singleton();
	}
	
	//must provide: static public method
	public static Singleton getInstance(){
		return SingletonHolder.instance;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	
	
}
