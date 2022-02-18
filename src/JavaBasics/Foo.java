package JavaBasics;

import java.util.ArrayList;
import java.util.List;

import Java.DesignPatterns.Singleton.Singleton;

public class Foo {

	public static void parseList(List<Object> list) {
	}
	
	public static void main(String[] args) {
//		List<String> stringList = new ArrayList<String>();
//		parseList(stringList);
		System.out.println(""+Singleton.print());
		System.out.println(""+Singleton.print());
//		Singleton i= Singleton.getInstance();
//		System.out.println(""+i.a);
		
	}
	
}
