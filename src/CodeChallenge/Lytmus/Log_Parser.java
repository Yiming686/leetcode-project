package CodeChallenge.Lytmus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Log_Parser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] lines = { 
				"(11/01/2015-04:00:00) :: START", 
				"(11/01/2015-04:00:00) :: CONNECTED",
				"(11/01/2015-04:30:00) :: DISCONNECTED", 
				"(11/01/2015-04:45:00) :: CONNECTED",
				"(11/01/2015-05:00:00) :: SHUTDOWN" };
		lines = new String[] { 
				"(01/01/2000-01:00:00) :: START", 
				"(01/01/2000-01:01:00) :: CONNECTED",
				"(01/01/2000-01:21:00) :: DISCONNECTED", 
				"(01/01/2000-01:50:00) :: SHUTDOWN" };
		
		System.out.println(parseLines(lines));

	}
	
	static String parseLines(String[] lines)
	{
		Map<String, LinkedList<String>> statusMap = new HashMap<String, LinkedList<String>>();
		int connectionTime = 0, index = 0, totalTime = 0;
		for (int i = 0; i < lines.length; i++){
			String[] line = lines[i].split("::");
			String dateTime = line[0].trim().substring(1, line[0].length() - 1);
			String status = line[1].trim();
			if (statusMap.containsKey(status)){
				LinkedList<String>  timeLst = statusMap.get(status);
				timeLst.addLast(dateTime);
				statusMap.put(status, timeLst);
			} else{
				LinkedList<String> dateTimeList = new LinkedList<String>();
				dateTimeList.addLast(dateTime);
				statusMap.put(status, dateTimeList);
			}
		}
		try{
			String patterStr = "MM/dd/yyyy-HH:mm:ss";
			DateFormat format = new SimpleDateFormat(patterStr);
			String startTime = statusMap.get("START").get(0);
			String endTime = statusMap.get("SHUTDOWN").get(0);
			Date startDate = format.parse(startTime);
			Date endDate = format.parse(endTime);
			totalTime = (int) ((endDate.getTime() / 60000) - (startDate.getTime() / 60000));

			LinkedList<String> connected = statusMap.get("CONNECTED");
			LinkedList<String> disconnected = statusMap.get("DISCONNECTED");

			for (String time : connected){
				startTime = time;
				if (disconnected.size() > index){
					endTime = disconnected.get(index);
				}else{
					endTime = statusMap.get("SHUTDOWN").get(0);
				}
				startDate = format.parse(startTime);
				endDate = format.parse(endTime);
				connectionTime += (int) ((endDate.getTime() / 60000) - (startDate.getTime() / 60000));
				index++;
			}

		} catch (ParseException e){
			e.printStackTrace();
		}
		int res = (int) ((connectionTime / (double) totalTime) * 100);
		return res + "%";
	}

}
