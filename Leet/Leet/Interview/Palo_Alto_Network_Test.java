package Leet.Interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Palo_Alto_Network_Test {

	
	public static void main(String[] args) {
		// 
		Set<Long> nums = new HashSet<>();
		nums.add(5L);
		nums.add(55555L);
		nums.add(new Long(777777L));
		Integer a = 5;
		System.out.println("nums.contains(a): " + nums.contains(a));
		System.out.println("nums.contains(a): " + nums.contains(5L));
		System.out.println("nums.contains(a): " + nums.contains(55555L));
		System.out.println("nums.contains(a): " + nums.contains(new Long(777777L)));
		if (nums.contains(a)) {
			System.out.println("Value found!");
		}

	}

//	original
	public void processMessages_00(List<Message> messages, List<Recipient> recipients) {
		for (Message message : messages) {
			Location messageDestination = message.getLocation();
			for (Recipient recipient : recipients) {
				if (messageDestination.equals(recipient.getLocation())) { // getLocation returns an instance of the Location class.
					recipient.sendMessage(message);
				}
			}
		}
	}
	
public void processMessages(List<Message> messages, List<Recipient> recipients) {
	Map<Location, List<Recipient>> locations = new HashMap<>();
	for (Recipient recipient : recipients) {
		Location location = recipient.getLocation();
		List<Recipient> list = locations.getOrDefault(location, new ArrayList<>());
		list.add(recipient);
		locations.put(location, list);
	}
	for (Message message : messages) {
		Location messageDestination = message.getLocation();
		if(locations.containsKey(messageDestination)) {
			for(Recipient recipient : locations.get(messageDestination)) {
				recipient.sendMessage(message);
				
			}
		}
	}
}
	
	static class Message{

		public Location getLocation() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	static class Recipient{

		public void sendMessage(Message message) {
			// TODO Auto-generated method stub
			
		}

		public Location getLocation() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	static class Location{
		
	}

}
