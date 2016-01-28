package Lintcode.Yahoo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SAX_Parser_XML_To_CSV_2 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

//		long start = System.nanoTime();
		long start = System.currentTimeMillis();
		
		convertXML2CSV();

//		long end = System.nanoTime();
		long end = System.currentTimeMillis();
		
		System.out.println("Time Elapsed : "+(end-start)+" ms !");

	}
	
	static void convertXML2CSV() throws ParserConfigurationException, SAXException, IOException{
		
//		String inputFileName = "/Users/yiming/Downloads/largesize.2.part1.xml";
//		String inputFileName = "/Users/yiming/Downloads/text.21.lines.xml";
		String inputFileName = "/Users/yiming/Downloads/largesize.2.part6.xml";
		
		String outPutFileName = "/Users/yiming/Downloads/largesize.2.part2.output.txt";

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		File csv2 = new File(outPutFileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(csv2.getAbsoluteFile()));
		MyHandler handler = new MyHandler(bw);
		saxParser.parse(inputFileName, handler);
		bw.close();		
	}

	static class MyHandler extends DefaultHandler {
		public MyHandler(BufferedWriter bufferedWriter) {
			// TODO Auto-generated constructor stub
			this.bufferedWriter = bufferedWriter;
		}

		boolean isName = false;
		boolean isPrice = false;
		boolean isDescripiton = false;
		boolean isCalories = false;
		
		BufferedWriter bufferedWriter;

		public void startElement(String uri, String localName, String elementName, Attributes attributes)
				throws SAXException {

//			System.out.println("Start Element :" + elementName);

			if (elementName.equalsIgnoreCase("name")) {
				isName = true;
			}

			if (elementName.equalsIgnoreCase("price")) {

				isPrice = true;
			}

			if (elementName.equalsIgnoreCase("description")) {
				isDescripiton = true;
			}

			if (elementName.equalsIgnoreCase("calories")) {
				isCalories = true;
			}

		}

		public void endElement(String uri, String localName, String elementName) throws SAXException {

//			System.out.println("End Element :" + elementName);

		}

		public void characters(char ch[], int start, int length) throws SAXException {

			try {
				if (isName) {
//					System.out.println("name : " + new String(ch, start, length));
					bufferedWriter.write(new String(ch, start, length)+", ");
					isName = false;
				}

				if (isPrice) {
//					System.out.println("price : " + new String(ch, start, length));
					bufferedWriter.write(new String(ch, start, length)+", ");
					isPrice = false;
				}

				if (isDescripiton) {
//					System.out.println("description : " + new String(ch, start, length));
					bufferedWriter.write(new String(ch, start, length)+", ");
					isDescripiton = false;
				}

				if (isCalories) {
//					System.out.println("calories : " + new String(ch, start, length));
					bufferedWriter.write(new String(ch, start, length)+", \n");
					isCalories = false;
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
