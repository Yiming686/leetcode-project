package JavaBasics;

import java.math.BigDecimal;
import java.sql.Time;

public class TimeComplexity {

    public static BigDecimal factorial(int n){   
        BigDecimal result = new BigDecimal(1);  
        BigDecimal a;  
        for(int i = 2; i <= n; i++){  
            a = new BigDecimal(i);//将i转换为BigDecimal类型  
            result = result.multiply(a);//不用result*a，因为BigDecimal类型没有定义*操作</span><span>  
        }  
        return result;  
    }  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 70;
//		//Integer.MAX_VALUE, Long.MAX_VALUE :: 31,21
//		for(int i = 0; i < n; i++) {
//			System.out.printf("n: %4d, n^2: %4d, 2^n: %-20f  %4s , n!: %-40f %4s \n",   i, i*i, Math.pow(2, i), Math.pow(2, i) > Integer.MAX_VALUE, factorial(i),factorial(i).doubleValue() > Long.MAX_VALUE  );	
//		}
//		System.out.println("\n\n");
//		//Integer.MAX_VALUE, Integer.MAX_VALUE :: 31,13
//		for(int i = 0; i < n; i++) {
//			System.out.printf("n: %4d, n^2: %4d, 2^n: %-20f  %4s , n!: %-40f %4s \n",   i, i*i, Math.pow(2, i), Math.pow(2, i) > Integer.MAX_VALUE, factorial(i),factorial(i).doubleValue() > Integer.MAX_VALUE  );	
//		}
		System.out.println("\n\n");
		//Long.MAX_VALUE, Long.MAX_VALUE :: 64,13
		for(int i = 0; i < n; i++) {
			System.out.printf("n: %4d, n^2: %4d, 2^n: %-20f  %4s , n!: %-40f %4s \n",   i, i*i, Math.pow(2, i), Math.pow(2, i) > Long.MAX_VALUE, factorial(i),factorial(i).doubleValue() > Long.MAX_VALUE  );	
		}
		
		System.out.println("\n\n");
		//Long.MAX_VALUE, Long.MAX_VALUE :: 64,13
		for(int i = 0; i < n; i++) {
			System.out.printf("n: %4d, n^2: %-15s, 2^n: %-28s  %6s , n!: %-35s %6s \n",   i, time(i*i), time(Math.pow(2, i)), Math.pow(2, i) > Long.MAX_VALUE, time(factorial(i)),factorial(i).doubleValue() > Long.MAX_VALUE  );	
		}
		
		System.out.println("MaxIntger: "+Integer.MAX_VALUE+", MaxLong: " + Long.MAX_VALUE );	

	}

	private static String time(BigDecimal val) {
		// TODO Auto-generated method stub
		double d = val.doubleValue();
//		return null;
//		return "("+d.doubleValue()/secondsOfyear +")"+ year + "("+d.doubleValue()%secondsOfyear/secondsOfday +")"+ day  ;
		return Math.round(d/secondsOfyear) + year + Math.round(d%secondsOfyear/secondsOfday)+ day + Math.round(d%secondsOfyear%secondsOfday/secondsOfHour) + hour+ Math.round(d%secondsOfyear%secondsOfday%secondsOfHour/secondsOfMinute) + minute + Math.round(d%secondsOfyear%secondsOfday%secondsOfHour%secondsOfMinute) + second  ;
	}

	private static String time(double d) {
		// TODO Auto-generated method stub
//		return null;
//		return "("+val/secondsOfyear +")"+ year ;
//		return "("+Math.round(d/secondsOfyear) +")"+ year + "("+Math.round(d%secondsOfyear/secondsOfday) +")"+ day + "("+Math.round(d%secondsOfyear%secondsOfday/secondsOfHour) +")"+ hour+ "("+Math.round(d%secondsOfyear%secondsOfday%secondsOfHour/secondsOfMinute) +")"+ minute  ;
		return Math.round(d/secondsOfyear) + year + Math.round(d%secondsOfyear/secondsOfday)+ day + Math.round(d%secondsOfyear%secondsOfday/secondsOfHour) + hour + Math.round(d%secondsOfyear%secondsOfday%secondsOfHour/secondsOfMinute) + minute + Math.round(d%secondsOfyear%secondsOfday%secondsOfHour%secondsOfMinute) + second  ;

	}
	private static String year = "年";
	private static String month = "月";
	private static String day = "日";
	private static String hour = "小时";
	private static String minute = "分钟";
	private static String second = "秒";
	
	private static int secondsOfSecond = 1;
	private static int secondsOfMinute = 60;
	private static int secondsOfHour = 60 * secondsOfMinute;
	private static int secondsOfday = 24 * secondsOfHour;
	private static int secondsOfmonth = 30 * secondsOfday;
	private static int secondsOfyear = 365 * secondsOfday;
	

}
