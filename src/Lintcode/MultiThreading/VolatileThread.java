package Lintcode.MultiThreading;

import java.io.BufferedWriter;
import java.io.IOException;

public class VolatileThread extends Thread{
	private BufferedWriter bw;
    private final VolatileData data;
    
    public VolatileThread(BufferedWriter bw, VolatileData data) {
    	this.bw = bw;
        this.data = data;
    }
    
    @Override
    public void run() {
//    	try {
//			Thread.sleep(1L);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        int oldValue1 = data.getCounter();
        try {
			bw.write("before:after  " +oldValue1+":"+"\n"+Thread.currentThread().getName()+"is Running! \n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        data.decreaseCounter();
//        int oldValue2 = data.getCounter();
//        System.out.println(Thread.currentThread().getName()+"is Running! " +" before:after  " +oldValue1+":"+oldValue2 );
        
//        System.out.println("[Thread " + Thread.currentThread().getId()
//                + "]: Old value = " + oldValue);
//        data.increaseCounter();
//        int newValue = data.getCounter();
//        System.out.println("[Thread " + Thread.currentThread().getId()
//                + "]: New value = " + newValue);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
