package Lintcode.MultiThreading.Volatile;

import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import Utils.MatrixUtils;

public class VolatileTest {
//    private static final Logger LOGGER = MyLoggerFactory.getSimplestLogger();

    private static volatile int MY_INT = 0;

    public static void main(String[] args) {
    	System.out.println("Integer.MAX_VALUE: "+Integer.MAX_VALUE);
    	int[][] arr = new int[][]{
    		{   0,  32, 33, -1,    25, 159,  6, -1},
    		{  25, 159,  7, -1,  7649,  13, 44, -1 },
    		{7649,  13, 45, -1, 14176,  34, 34, -1},
    		{3289,   0,  1, -1,  3295,   0,  1, -1}
    	};
    	arrCHS2LBA(arr);
    	System.out.println(MatrixUtils.fromMatrixToString(arr));
		for(int[] chs : arr){
			System.out.println(""+Arrays.toString(LBA2CHS(chs[3])));
			System.out.println(""+Arrays.toString(LBA2CHS(chs[7])));
		}
    	
		System.out.println(""+Arrays.toString(LBA2CHS(50000000)));
		System.out.println(""+Arrays.toString(LBA2CHS(52000000)));

//        new ChangeListener().start();
//        new ChangeMaker().start();
    }
    private static int[] LBA2CHS(int lba) {
    	int[] arr = new int[3];
    	arr[0] = lba / (255 * 63);
    	int rem =lba % (255 * 63); 
    	arr[1] =  rem / 63;
    	arr[2] = rem % 63 + 1;
    	return arr;
    }
    private static void arrCHS2LBA(int[][] arr) {
		// TODO Auto-generated method stub
		for(int[] chs : arr){
			chs[3] = 255 * 63 * chs[0] + 63 * chs[1] + chs[2] - 1;
			chs[7] = 255 * 63 * chs[4] + 63 * chs[5] + chs[6] - 1 ;
		}
	}

	static class ChangeListener extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;
            while ( local_value < 5){
                if( local_value!= MY_INT){
//                    LOGGER.log(Level.INFO,"Got Change for MY_INT : {0}", MY_INT);
                    System.out.println("Got Change for MY_INT : " +  MY_INT);
                     local_value= MY_INT;
                }
            }
        }
    }

    static class ChangeMaker extends Thread{
        @Override
        public void run() {

            int local_value = MY_INT;
            while (MY_INT <5){
//                LOGGER.log(Level.INFO, "Incrementing MY_INT to {0}", local_value+1);
                System.out.println("Incrementing MY_INT to " +(local_value+1));
                MY_INT = ++local_value;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }


}
