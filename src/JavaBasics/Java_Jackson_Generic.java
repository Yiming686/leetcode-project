package JavaBasics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Java_Jackson_Generic {
	private static ObjectMapper mapper = new ObjectMapper();
	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
		List<Device> listDevice1 = new ArrayList<>();
		listDevice1.add(new Device("name111", 111, "color111"));
		listDevice1.add(new Device("name222", 222, "color222"));
		listDevice1.add(new Device("name333", 333, "color333"));
		
		List<Device> listDevice2 = new ArrayList<>();
		listDevice2.add(new Device("name333", 333, "color333"));
		listDevice2.add(new Device("name444", 444, "color444"));
		listDevice2.add(new Device("name555", 555, "color555"));

		List<List<Device>> listListDevice = new ArrayList<>();
		listListDevice.add(listDevice1);
		listListDevice.add(listDevice2);
		
		String jsonString = mapper.writeValueAsString(listListDevice);
		System.out.println("jsonString: "+jsonString);
		
		try {
			List<List<Device>> listListDevice2 = mapper.readValue(jsonString, new TypeReference<List<List<Device>>>() {
			}) ;
			System.out.println("listListDevice2: "+listListDevice2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	static class Device{
		private String name;
		private Integer id;
		private String color;
		
//		@JsonCreator
		public Device() {
			super();
		}
		public Device(String name, Integer id, String color) {
			super();
			this.name = name;
			this.id = id;
			this.color = color;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		
		
	}
}
