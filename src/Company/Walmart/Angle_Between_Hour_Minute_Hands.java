package Company.Walmart;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Angle_Between_Hour_Minute_Hands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern PATTERN = Pattern.compile("(//[^\\n]*)|(/\\*.*?\\*/)", Pattern.MULTILINE | Pattern.DOTALL);

		Matcher matcher = PATTERN.matcher("");
			String comment = matcher.group();

		System.out.println(""+calcAngle(9, 60));	
		System.out.println(""+calcAngle(3, 30));
	}

	private static int calcAngle(int hour, int minute) {
		// TODO Auto-generated method stub
	    if (hour <0 || minute < 0 || hour >12 || minute > 60)
//	        printf("Wrong input");
	 
//	    if (hour == 12) hour = 0;//h = h%12;
//	    if (minute == 60) minute = 0;//m = m%60;
	    hour = hour % 12;
	    minute = minute % 60;
	    // Calculate the angles moved by hour and minute hands
	    // with reference to 12:00
	    int hourAngle = (int)((hour + minute/60.)*30);//
	    int minuteAngle = (int)(6*minute);
	 
	    // Find the difference between two angles
	    
	    int angle = Math.abs(hourAngle - minuteAngle);
	 
	    // Return the smaller angle of two possible angles
	    angle = Math.min(360-angle, angle);
	 
	    return angle;
	}
	
	

}
