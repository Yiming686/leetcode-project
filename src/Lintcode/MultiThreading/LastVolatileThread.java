package Lintcode.MultiThreading;

import java.io.BufferedWriter;
import java.io.IOException;

public class LastVolatileThread extends Thread{
	private BufferedWriter bw;
    private final VolatileData data;
    
    public LastVolatileThread(BufferedWriter bw, VolatileData data) {
    	this.bw = bw;
        this.data = data;
    }
    
    @Override
    public void run() {
    	int oldValue1 = data.getCounter();	
    	while(data.getCounter() != 0){
    		System.out.println("Befoe: "+data.getCounter());
    	}
    	data.setCounter(500);	
    	int oldValue2 = data.getCounter();	
    	
        try {
			bw.write("Last Threding is Running! " +" before:after  " +oldValue1+":"+oldValue2 );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Last Threding is Running! " +" before:after  " +oldValue1+":"+oldValue2 );
        try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
