package Lintcode.MultiThreading.Volatile;

import java.util.List;

public class VolatileTest2 {
//    private static final Logger LOGGER = MyLoggerFactory.getSimplestLogger();

    private static volatile Integer MY_INT = 0;

    public static void main(String[] args) {
        new ChangeListener(MY_INT).start();
        new ChangeMaker(MY_INT).start();
    }
	
}

class ChangeListener extends Thread {
	private volatile Integer MY_INT;
	ChangeListener(Integer MY_INT){
		this.MY_INT = MY_INT;
	}
	
    @Override
    public void run() {
        int local_value = MY_INT;
        while ( local_value < 5){
//        	System.out.println("--------");
            if( local_value!= MY_INT){
//                LOGGER.log(Level.INFO,"Got Change for MY_INT : {0}", MY_INT);
                System.out.println("Got Change for MY_INT : " +  MY_INT);
                 local_value= MY_INT;
            }
        }
    }
}

class ChangeMaker extends Thread{
	private volatile Integer MY_INT;
	ChangeMaker(Integer MY_INT){
		this.MY_INT = MY_INT;
	}
    @Override
    public void run() {

        int local_value = MY_INT;
        while (MY_INT <5){
//            LOGGER.log(Level.INFO, "Incrementing MY_INT to {0}", local_value+1);
            System.out.println("Incrementing MY_INT to " +(local_value+1));
            MY_INT = ++local_value;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
