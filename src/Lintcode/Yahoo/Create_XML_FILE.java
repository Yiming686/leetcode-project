package Lintcode.Yahoo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Create_XML_FILE {

	public static void main(String[] args) throws IOException {

		long start = System.currentTimeMillis();
		
//		String xmlFileName = "/Users/yiming/Downloads/largesize.2.part6.xml";
//		long fileSize = 1024*1000*1000*1000;
//		createXMLFile(xmlFileName, fileSize);
		
		String xmlFileName = "/Users/yiming/Downloads/largesize.2.part7.xml";
		long fileSize = 1024*1000*1000*1000*10;
		createXMLFile(xmlFileName, fileSize);

//		xmlFileName = "/Users/yiming/Downloads/createTest1.xml";
//		fileSize = 1024*1000*1000;
//		createXMLFile( xmlFileName, fileSize);
//		
//		xmlFileName = "/Users/yiming/Downloads/createTest1.xml";
//		fileSize = 1024*1000*1000;
//		createXMLFile( xmlFileName, fileSize);
//		
//		xmlFileName = "/Users/yiming/Downloads/createTest1.xml";
//		fileSize = 1024*1000*1000;
//		createXMLFile( xmlFileName, fileSize);
		
		
		long end = System.currentTimeMillis();
		System.out.println("Time Elapsed : "+(end-start)+" ms !");
	}
	public static void createXMLFile(String xmlFileName, Long fileSize) throws IOException{
		File xmlFile = new File(xmlFileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(xmlFile.getAbsoluteFile()));

		bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		bw.write("<breakfast_menu>\n");
		while(xmlFile.length() < fileSize){
			bw.write("<food>\n"+"  <name>Belgian Waffles</name>\n"+"  <price>$5.95</price>\n" 
		+"  <description>Our famous Belgian Waffles with plenty of real maple syrup</description>\n"+
  "  <calories>650</calories>\n"+"</food>\n");
		}
		bw.write("</breakfast_menu>");
		bw.close();
	}
	

}
