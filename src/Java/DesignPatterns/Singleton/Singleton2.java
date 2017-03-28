package Java.DesignPatterns.Singleton;

import java.lang.reflect.Constructor;

//SingletongDoubleChecking
public class Singleton2 {

//	must provide private constructor
	private Singleton2(){
		
	}
	private static int num = 0;
//	must static volatile instance, what about final???
	private static volatile Singleton2 instance = null;
			
	public static Singleton2 getInstance(){
		if(instance == null){
			synchronized(Singleton2.class){
				if(instance == null){
					instance = new Singleton2();
				}
			}
		}
		return instance;
	}
			
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton2 instanceOne = Singleton2.getInstance();
		Singleton2 instanceOne2 = Singleton2.getInstance();
		instanceOne.num = 1;
		instanceOne2.num = 9;
		System.out.println(""+instanceOne.num);
		System.out.println(""+instanceOne2.num);
		
//		Singleton2 instanceTwo = null;
//		Singleton2 instanceThree = null;
//        try {
//	
//	        Constructor[] constructors = Singleton2.class.getDeclaredConstructors();
//	        for (Constructor constructor : constructors) {
//	            //Below code will destroy the singleton pattern
//	            constructor.setAccessible(true);
//	            instanceTwo = (Singleton2) constructor.newInstance();
//	            instanceThree = (Singleton2) constructor.newInstance();
//	            break;
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//        System.out.println(instanceOne.hashCode());
//	    System.out.println(instanceOne2.hashCode());
//	    System.out.println(instanceTwo.hashCode());
//	    System.out.println(instanceThree.hashCode());
//	    
//	    System.out.println(instanceOne.getInstance().hashCode());
//	    System.out.println(instanceTwo.getInstance().hashCode());
//	    System.out.println(instanceThree.getInstance().hashCode());
	}

}
