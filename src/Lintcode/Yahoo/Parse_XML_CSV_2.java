package Lintcode.Yahoo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Parse_XML_CSV_2 {

	public static void main(String[] args) throws XMLStreamException, FactoryConfigurationError, IOException {
		// TODO Auto-generated method stub
		parseXML();
	}
	
	static void parseXML() throws XMLStreamException, FactoryConfigurationError, IOException{
		// the input file location
		  final File fileLocation = new File("/Users/yiming/Downloads/largesize.2.part2.xml");
//		  final String csv2 = "/Users/yiming/Downloads/largesize.part1.csv";
		  File csv2 = new File("/Users/yiming/Downloads/largesize.part1.txt");
//		  final String fileLocation = "/Users/yiming/Downloads/text.21.lines.xml";
		  
		// the target elements
		  final String USERS_ELEMENT = "users";
		  final String ROW_ELEMENT = "row";

		// get the XML file handler
		//
		FileInputStream fileInputStream = new FileInputStream(fileLocation);
//		FileOutputStream fileOutputStream = new FileOutputStream(csv2);
		BufferedWriter bw = new BufferedWriter(new FileWriter(csv2.getAbsoluteFile()));
		
		XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance().createXMLStreamReader(
		    fileInputStream);

		// reading the data
		//
		while (xmlStreamReader.hasNext()) {

		  int eventCode = xmlStreamReader.next();
		  if (XMLStreamConstants.START_ELEMENT == eventCode&& xmlStreamReader.getLocalName().equalsIgnoreCase("breakfast_menu")){
				while (xmlStreamReader.hasNext()) {

					  eventCode = xmlStreamReader.next();
					  if (XMLStreamConstants.START_ELEMENT == eventCode&& xmlStreamReader.getLocalName().equalsIgnoreCase("food")){
						  String str = xmlStreamReader.getLocalName();
						  System.out.println(""+xmlStreamReader.getLocalName());
				          int attributesCount = xmlStreamReader.getAttributeCount();
				          System.out.println(""+xmlStreamReader.getAttributeCount());
				          System.out.println(""+xmlStreamReader.getNamespaceCount());
				          for (int i = 0; i < attributesCount; i++) {
				        	  bw.write(xmlStreamReader.getAttributeLocalName(i)+",");
			//	        	  System.out.println(""+xmlStreamReader.getAttributeLocalName(i));
				          }
					  }
				}
		  }
		}
		bw.close();

//		  // this triggers _users records_ logic
//		  //
//		  if ((XMLStreamConstants.START_ELEMENT == eventCode)
//		      && xmlStreamReader.getLocalName().equalsIgnoreCase(USERS_ELEMENT)) {
//
//		    // read and parse the user data rows
//		    //
//		    while (xmlStreamReader.hasNext()) {
//
//		      eventCode = xmlStreamReader.next();
//
//		      // this breaks _users record_ reading logic
//		      //
//		      if ((XMLStreamConstants.END_ELEMENT == eventCode)
//		          && xmlStreamReader.getLocalName().equalsIgnoreCase(USERS_ELEMENT)) {
//		        break;
//		      }
//		      else {
//
//		        if ((XMLStreamConstants.START_ELEMENT == eventCode)
//		            && xmlStreamReader.getLocalName().equalsIgnoreCase(ROW_ELEMENT)) {
//
//		          // extract the user data
//		          //
////		          User user = new User();
//		          int attributesCount = xmlStreamReader.getAttributeCount();
//		          for (int i = 0; i < 200; i++) {
//		        	  System.out.println(""+xmlStreamReader.getAttributeLocalName(i));
////		        	  for (int i = 0; i < attributesCount; i++) {
////		            user.setAttribute(xmlStreamReader.getAttributeLocalName(i),
////		                xmlStreamReader.getAttributeValue(i));
//		          }
//		          // all other user record-related logic
//		          //
//
//		        }
//		      }
//		    }
//		  }
	}

}

