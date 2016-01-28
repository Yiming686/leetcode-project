package Lintcode.MultiThreading;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class VolatileMain {
	
	private final static int TOTAL_THREADS = 600;
	volatile Integer number = 8;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String outPutFileName = "/Users/yiming/Downloads/multiThreading.output.txt";
		File file = new File(outPutFileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));

		VolatileData volatileData = new VolatileData();
		volatileData.setCounter(TOTAL_THREADS-1);
        Thread[] threads = new Thread[TOTAL_THREADS];

		for(int i = 0; i < TOTAL_THREADS - 1; ++i)
			  threads[i] = new VolatileThread(bw, volatileData);
		threads[8].join();
		threads[TOTAL_THREADS - 1] = new LastVolatileThread(bw, volatileData);
		  
		for(int i = TOTAL_THREADS - 1; i >=0; i--)
			  threads[i].start();
        
		  
//        while(volatileData.getCounter() != 0){
//        	System.out.println("Befoe: "+volatileData.getCounter());
//        }
//        threads[TOTAL_THREADS-1].start();
	}
}
